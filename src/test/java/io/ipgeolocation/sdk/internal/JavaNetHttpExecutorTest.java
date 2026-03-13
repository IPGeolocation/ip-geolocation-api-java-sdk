package io.ipgeolocation.sdk.internal;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.net.Authenticator;
import java.net.CookieHandler;
import java.net.ProxySelector;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.security.NoSuchAlgorithmException;
import java.time.Duration;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSession;
import org.junit.jupiter.api.Test;

class JavaNetHttpExecutorTest {

  @Test
  void mapsHttpClientResponseToHttpResponseData() throws Exception {
    HttpRequest request = HttpRequest.newBuilder(URI.create("https://api.ipgeolocation.io/v3/ipgeo")).GET().build();

    StubHttpClient httpClient =
        new StubHttpClient(
            200,
            "{\"ip\":\"8.8.8.8\"}",
            HttpHeaders.of(Map.of("X-Test", java.util.List.of("a", "b")), (a, b) -> true));

    JavaNetHttpExecutor executor = new JavaNetHttpExecutor(httpClient);
    HttpResponseData data = executor.send(request, Duration.ofSeconds(2));

    assertThat(httpClient.capturedRequest).isSameAs(request);
    assertThat(data.statusCode()).isEqualTo(200);
    assertThat(data.body()).isEqualTo("{\"ip\":\"8.8.8.8\"}");
    assertThat(data.headers()).containsEntry("X-Test", java.util.List.of("a", "b"));
  }

  @Test
  void propagatesIOExceptionFromHttpClient() {
    HttpRequest request = HttpRequest.newBuilder(URI.create("https://api.ipgeolocation.io/v3/ipgeo")).GET().build();
    StubHttpClient httpClient = new StubHttpClient(new IOException("socket reset"));
    JavaNetHttpExecutor executor = new JavaNetHttpExecutor(httpClient);

    org.assertj.core.api.Assertions.assertThatThrownBy(() -> executor.send(request, Duration.ofSeconds(2)))
        .isInstanceOf(IOException.class)
        .hasMessageContaining("socket reset");
  }

  @Test
  void propagatesInterruptedExceptionFromHttpClient() {
    HttpRequest request = HttpRequest.newBuilder(URI.create("https://api.ipgeolocation.io/v3/ipgeo")).GET().build();
    StubHttpClient httpClient = new StubHttpClient(new InterruptedException("interrupted"));
    JavaNetHttpExecutor executor = new JavaNetHttpExecutor(httpClient);

    org.assertj.core.api.Assertions.assertThatThrownBy(() -> executor.send(request, Duration.ofSeconds(2)))
        .isInstanceOf(InterruptedException.class)
        .hasMessageContaining("interrupted");
  }

  private static final class StubHttpClient extends HttpClient {
    private final HttpResponse<String> response;
    private final IOException ioException;
    private final InterruptedException interruptedException;
    private HttpRequest capturedRequest;

    private StubHttpClient(int status, String body, HttpHeaders headers) {
      this.response = new StubHttpResponse(status, body, headers);
      this.ioException = null;
      this.interruptedException = null;
    }

    private StubHttpClient(IOException ioException) {
      this.response = null;
      this.ioException = ioException;
      this.interruptedException = null;
    }

    private StubHttpClient(InterruptedException interruptedException) {
      this.response = null;
      this.ioException = null;
      this.interruptedException = interruptedException;
    }

    @Override
    public Optional<CookieHandler> cookieHandler() {
      return Optional.empty();
    }

    @Override
    public Optional<Duration> connectTimeout() {
      return Optional.of(Duration.ofSeconds(10));
    }

    @Override
    public Redirect followRedirects() {
      return Redirect.NEVER;
    }

    @Override
    public Optional<ProxySelector> proxy() {
      return Optional.empty();
    }

    @Override
    public SSLContext sslContext() {
      try {
        return SSLContext.getDefault();
      } catch (NoSuchAlgorithmException e) {
        throw new IllegalStateException("Default SSLContext unavailable", e);
      }
    }

    @Override
    public SSLParameters sslParameters() {
      return new SSLParameters();
    }

    @Override
    public Optional<Authenticator> authenticator() {
      return Optional.empty();
    }

    @Override
    public HttpClient.Version version() {
      return HttpClient.Version.HTTP_1_1;
    }

    @Override
    public Optional<Executor> executor() {
      return Optional.empty();
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> HttpResponse<T> send(HttpRequest request, HttpResponse.BodyHandler<T> responseBodyHandler)
        throws IOException, InterruptedException {
      this.capturedRequest = request;
      if (ioException != null) {
        throw ioException;
      }
      if (interruptedException != null) {
        throw interruptedException;
      }
      return (HttpResponse<T>) response;
    }

    @Override
    public <T> CompletableFuture<HttpResponse<T>> sendAsync(
        HttpRequest request,
        HttpResponse.BodyHandler<T> responseBodyHandler) {
      throw new UnsupportedOperationException("sendAsync is not used in this test");
    }

    @Override
    public <T> CompletableFuture<HttpResponse<T>> sendAsync(
        HttpRequest request,
        HttpResponse.BodyHandler<T> responseBodyHandler,
        HttpResponse.PushPromiseHandler<T> pushPromiseHandler) {
      throw new UnsupportedOperationException("sendAsync is not used in this test");
    }
  }

  private record StubHttpResponse(
      int statusCode,
      String body,
      HttpHeaders headers) implements HttpResponse<String> {

    @Override
    public HttpRequest request() {
      return HttpRequest.newBuilder(URI.create("https://api.ipgeolocation.io/v3/ipgeo")).GET().build();
    }

    @Override
    public Optional<HttpResponse<String>> previousResponse() {
      return Optional.empty();
    }

    @Override
    public URI uri() {
      return URI.create("https://api.ipgeolocation.io/v3/ipgeo");
    }

    @Override
    public HttpClient.Version version() {
      return HttpClient.Version.HTTP_1_1;
    }

    @Override
    public Optional<SSLSession> sslSession() {
      return Optional.empty();
    }
  }
}
