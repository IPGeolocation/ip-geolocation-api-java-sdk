package io.ipgeolocation.sdk.internal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import io.ipgeolocation.sdk.TestSupport;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

class JavaNetHttpExecutorTest {

  @Test
  void rejectsInvalidTimeoutsAndNullConnectionFactory() {
    assertThatThrownBy(() -> new JavaNetHttpExecutor(Duration.ZERO))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("greater than zero");

    assertThatThrownBy(() -> new JavaNetHttpExecutor(Duration.ofSeconds(-1)))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("greater than zero");

    assertThatThrownBy(() -> new JavaNetHttpExecutor(Duration.ofSeconds(1), null))
        .isInstanceOf(NullPointerException.class)
        .hasMessageContaining("connectionFactory");

    assertThatThrownBy(
            () ->
                new JavaNetHttpExecutor(
                    Duration.ofSeconds(1),
                    0,
                    new StubConnectionFactory(
                        new StubHttpURLConnection(
                            url("https://api.ipgeolocation.io/v3/ipgeo"),
                            200,
                            "{}",
                            Collections.<String, List<String>>emptyMap()))))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("maxResponseBodyChars");
  }

  @Test
  void mapsConnectionResponseToHttpResponseData() throws Exception {
    StubHttpURLConnection connection =
        new StubHttpURLConnection(
            URI.create("https://api.ipgeolocation.io/v3/ipgeo").toURL(),
            200,
            "{\"ip\":\"8.8.8.8\"}",
            TestSupport.headers("X-Test", "a"));

    JavaNetHttpExecutor executor =
        new JavaNetHttpExecutor(Duration.ofSeconds(3), new StubConnectionFactory(connection));

    HttpRequestData request =
        new HttpRequestData(
            URI.create("https://api.ipgeolocation.io/v3/ipgeo?ip=8.8.8.8"),
            "POST",
            TestSupport.headers("User-Agent", "ipgeolocation-java-sdk/test"),
            "{\"ips\":[\"8.8.8.8\"]}",
            Duration.ofSeconds(4));

    HttpResponseData data = executor.send(request);

    assertThat(connection.getRequestMethod()).isEqualTo("POST");
    assertThat(connection.getConnectTimeout()).isEqualTo(3000);
    assertThat(connection.getReadTimeout()).isEqualTo(4000);
    assertThat(connection.requestPropertyValues("User-Agent")).containsExactly("ipgeolocation-java-sdk/test");
    assertThat(connection.writtenBody()).isEqualTo("{\"ips\":[\"8.8.8.8\"]}");
    assertThat(data.statusCode()).isEqualTo(200);
    assertThat(data.body()).isEqualTo("{\"ip\":\"8.8.8.8\"}");
    assertThat(data.headers()).containsEntry("X-Test", TestSupport.list("a"));
  }

  @Test
  void usesErrorStreamForNon2xxResponses() throws Exception {
    StubHttpURLConnection connection =
        new StubHttpURLConnection(
            URI.create("https://api.ipgeolocation.io/v3/ipgeo").toURL(),
            401,
            "{\"message\":\"invalid key\"}",
            Collections.<String, List<String>>emptyMap());

    JavaNetHttpExecutor executor =
        new JavaNetHttpExecutor(Duration.ofSeconds(2), new StubConnectionFactory(connection));

    HttpResponseData data =
        executor.send(
            new HttpRequestData(
                URI.create("https://api.ipgeolocation.io/v3/ipgeo"),
                "GET",
                Collections.<String, List<String>>emptyMap(),
                null,
                Duration.ofSeconds(5)));

    assertThat(data.statusCode()).isEqualTo(401);
    assertThat(data.body()).isEqualTo("{\"message\":\"invalid key\"}");
  }

  @Test
  void getRequestSkipsNullHeaderEntriesAndDoesNotWriteBody() throws Exception {
    StubHttpURLConnection connection =
        new StubHttpURLConnection(
            URI.create("https://api.ipgeolocation.io/v3/ipgeo").toURL(),
            200,
            "{\"ip\":\"8.8.4.4\"}",
            Collections.<String, List<String>>emptyMap());

    JavaNetHttpExecutor executor =
        new JavaNetHttpExecutor(Duration.ofSeconds(2), new StubConnectionFactory(connection));

    Map<String, List<String>> headers = new LinkedHashMap<String, List<String>>();
    headers.put(null, TestSupport.list("ignored"));
    headers.put("X-Test", TestSupport.list(null, "value"));

    HttpResponseData data =
        executor.send(
            new HttpRequestData(
                URI.create("https://api.ipgeolocation.io/v3/ipgeo"),
                "GET",
                headers,
                "{\"ignored\":true}",
                Duration.ofSeconds(2)));

    assertThat(connection.requestPropertyValues("X-Test")).containsExactly("value");
    assertThat(connection.outputStreamRequested()).isFalse();
    assertThat(connection.fixedLengthStreamingMode()).isEqualTo(-1);
    assertThat(data.body()).isEqualTo("{\"ip\":\"8.8.4.4\"}");
  }

  @Test
  void putRequestHonorsExistingContentLengthAndHandlesNullErrorStream() throws Exception {
    StubHttpURLConnection connection =
        new StubHttpURLConnection(
            URI.create("https://api.ipgeolocation.io/v3/ipgeo-bulk").toURL(),
            500,
            "{\"message\":\"upstream failed\"}",
            Collections.<String, List<String>>emptyMap());
    connection.returnNullErrorStream();
    connection.setExistingRequestProperty("Content-Length", "4");

    JavaNetHttpExecutor executor =
        new JavaNetHttpExecutor(Duration.ofDays(30_000), new StubConnectionFactory(connection));

    HttpResponseData data =
        executor.send(
            new HttpRequestData(
                URI.create("https://api.ipgeolocation.io/v3/ipgeo-bulk"),
                "PUT",
                Collections.<String, List<String>>emptyMap(),
                "{\"ips\":[\"8.8.8.8\"]}",
                Duration.ofDays(30_000)));

    assertThat(connection.getConnectTimeout()).isEqualTo(Integer.MAX_VALUE);
    assertThat(connection.getReadTimeout()).isEqualTo(Integer.MAX_VALUE);
    assertThat(connection.fixedLengthStreamingMode()).isEqualTo(-1);
    assertThat(connection.writtenBody()).isEqualTo("{\"ips\":[\"8.8.8.8\"]}");
    assertThat(data.statusCode()).isEqualTo(500);
    assertThat(data.body()).isEmpty();
  }

  @Test
  void propagatesIOExceptionFromConnectionFactory() {
    JavaNetHttpExecutor executor =
        new JavaNetHttpExecutor(
            Duration.ofSeconds(2),
            new JavaNetHttpExecutor.ConnectionFactory() {
              @Override
              public HttpURLConnection open(URI uri) throws IOException {
                throw new IOException("socket reset");
              }
            });

    assertThatThrownBy(
            () ->
                executor.send(
                    new HttpRequestData(
                        URI.create("https://api.ipgeolocation.io/v3/ipgeo"),
                        "GET",
                        Collections.<String, List<String>>emptyMap(),
                        null,
                        Duration.ofSeconds(2))))
        .isInstanceOf(IOException.class)
        .hasMessageContaining("socket reset");
  }

  @Test
  void rejectsResponsesThatExceedConfiguredBodyLimit() {
    StubHttpURLConnection connection =
        new StubHttpURLConnection(
            url("https://api.ipgeolocation.io/v3/ipgeo"),
            200,
            "{\"ip\":\"1234567890\"}",
            Collections.<String, List<String>>emptyMap());

    JavaNetHttpExecutor executor =
        new JavaNetHttpExecutor(
            Duration.ofSeconds(2),
            8,
            new StubConnectionFactory(connection));

    assertThatThrownBy(
            () ->
                executor.send(
                    new HttpRequestData(
                        URI.create("https://api.ipgeolocation.io/v3/ipgeo"),
                        "GET",
                        Collections.<String, List<String>>emptyMap(),
                        null,
                        Duration.ofSeconds(2))))
        .isInstanceOf(IOException.class)
        .hasMessageContaining("Response body exceeded max size");
  }

  private static URL url(String value) {
    try {
      return URI.create(value).toURL();
    } catch (IOException e) {
      throw new AssertionError(e);
    }
  }

  private static final class StubConnectionFactory implements JavaNetHttpExecutor.ConnectionFactory {
    private final StubHttpURLConnection connection;

    private StubConnectionFactory(StubHttpURLConnection connection) {
      this.connection = connection;
    }

    @Override
    public HttpURLConnection open(URI uri) {
      return connection;
    }
  }

  private static final class StubHttpURLConnection extends HttpURLConnection {
    private final int responseCode;
    private final String body;
    private final Map<String, List<String>> headerFields;
    private final ByteArrayOutputStream output = new ByteArrayOutputStream();
    private boolean nullInputStream;
    private boolean nullErrorStream;
    private boolean outputStreamRequested;
    private int fixedLengthStreamingMode = -1;

    private StubHttpURLConnection(
        URL url, int responseCode, String body, Map<String, List<String>> headerFields) {
      super(url);
      this.responseCode = responseCode;
      this.body = body;
      this.headerFields = headerFields;
    }

    @Override
    public void disconnect() {}

    @Override
    public boolean usingProxy() {
      return false;
    }

    @Override
    public void connect() {}

    @Override
    public void setRequestMethod(String method) throws ProtocolException {
      this.method = method;
    }

    @Override
    public int getResponseCode() {
      return responseCode;
    }

    @Override
    public InputStream getInputStream() {
      if (nullInputStream) {
        return null;
      }
      return responseCode >= 400
          ? new ByteArrayInputStream(new byte[0])
          : new ByteArrayInputStream(body.getBytes(java.nio.charset.StandardCharsets.UTF_8));
    }

    @Override
    public InputStream getErrorStream() {
      if (nullErrorStream) {
        return null;
      }
      return responseCode >= 400
          ? new ByteArrayInputStream(body.getBytes(java.nio.charset.StandardCharsets.UTF_8))
          : null;
    }

    @Override
    public OutputStream getOutputStream() {
      outputStreamRequested = true;
      return output;
    }

    @Override
    public void setFixedLengthStreamingMode(int contentLength) {
      fixedLengthStreamingMode = contentLength;
    }

    @Override
    public Map<String, List<String>> getHeaderFields() {
      return headerFields;
    }

    private String writtenBody() {
      return new String(output.toByteArray(), java.nio.charset.StandardCharsets.UTF_8);
    }

    private List<String> requestPropertyValues(String name) {
      List<String> values = getRequestProperties().get(name);
      return values == null ? Collections.<String>emptyList() : values;
    }

    private boolean outputStreamRequested() {
      return outputStreamRequested;
    }

    private int fixedLengthStreamingMode() {
      return fixedLengthStreamingMode;
    }

    private void returnNullErrorStream() {
      this.nullErrorStream = true;
    }

    private void setExistingRequestProperty(String name, String value) {
      super.setRequestProperty(name, value);
    }
  }
}
