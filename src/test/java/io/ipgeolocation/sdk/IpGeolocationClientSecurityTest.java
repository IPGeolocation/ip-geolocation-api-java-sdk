package io.ipgeolocation.sdk;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.ipgeolocation.sdk.exceptions.ApiException;
import io.ipgeolocation.sdk.exceptions.SerializationException;
import io.ipgeolocation.sdk.exceptions.TransportException;
import io.ipgeolocation.sdk.exceptions.UnauthorizedException;
import io.ipgeolocation.sdk.internal.ObjectMapperFactory;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class IpGeolocationClientSecurityTest {
  private static final String KEY = "dummy-test-key/+ with space";

  @ParameterizedTest
  @ValueSource(ints = {0, 1, 2, 3})
  void redactsApiErrorsForEveryLookupMethod(int operation) throws Exception {
    String encoded = URLEncoder.encode(KEY, "UTF-8").replace("+", "%20");
    TestHttpExecutor executor = new TestHttpExecutor();
    executor.enqueueResponse(401, "{\"message\":\"Invalid " + KEY + " or " + encoded + "\"}");
    Throwable error = catchThrowable(() -> execute(client(executor), operation));
    assertThat(error).isInstanceOf(UnauthorizedException.class);
    assertThat(((ApiException) error).statusCode()).isEqualTo(401);
    assertThat(((ApiException) error).apiMessage()).isEqualTo("Invalid [REDACTED] or [REDACTED]");
    assertNoKey(error);
  }

  @Test
  void redactsBeforeTruncatingNonJsonErrors() throws Exception {
    TestHttpExecutor executor = new TestHttpExecutor();
    String prefix = String.join("", Collections.nCopies(500, "x"));
    executor.enqueueResponse(503, prefix + KEY);
    Throwable error = catchThrowable(() -> execute(client(executor), 0));
    assertThat(((ApiException) error).apiMessage()).isEqualTo(prefix + "[REDACTED]");
    assertNoKey(error);
  }

  @ParameterizedTest
  @ValueSource(ints = {0, 1, 2, 3})
  void preservesStatusWhenErrorBodyIsJsonNull(int operation) {
    TestHttpExecutor executor = new TestHttpExecutor();
    executor.enqueueResponse(401, "null");
    Throwable error = catchThrowable(() -> execute(client(executor), operation));
    assertThat(error).isInstanceOf(UnauthorizedException.class);
    assertThat(((ApiException) error).statusCode()).isEqualTo(401);
    assertThat(((ApiException) error).apiMessage()).isNull();
  }

  @ParameterizedTest
  @ValueSource(ints = {0, 2})
  void detachesParsingErrorsThatRetainSensitiveValues(int operation) throws Exception {
    TestHttpExecutor executor = new TestHttpExecutor();
    String body = "{\"ip\":\"8.8.8.8\",\"security\":{\"threat_score\":\"" + KEY + "\"}}";
    executor.enqueueResponse(200, operation == 2 ? "[" + body + "]" : body);
    Throwable error = catchThrowable(() -> execute(client(executor), operation));
    assertThat(error).isInstanceOf(SerializationException.class);
    assertThat(error.getCause()).isExactlyInstanceOf(IOException.class);
    assertNoKey(error);
  }

  @Test
  void removesNestedAndSuppressedTransportSecrets() throws Exception {
    IOException original = new IOException("Unable to read " + KEY, new IOException(KEY));
    original.addSuppressed(new IOException(KEY));
    TestHttpExecutor executor = new TestHttpExecutor();
    executor.enqueueIOException(original);
    Throwable error = catchThrowable(() -> execute(client(executor), 0));
    assertThat(error).isInstanceOf(TransportException.class);
    assertThat(error.getCause()).isNotSameAs(original);
    assertThat(error.getCause().getCause()).isNull();
    assertThat(error.getCause().getSuppressed()).isEmpty();
    assertNoKey(error);
  }

  @ParameterizedTest
  @ValueSource(ints = {467, 480, 499, 500, 1000})
  void parsingErrorsCannotExposePartOfATruncatedKey(int prefixLength) throws Exception {
    TestHttpExecutor executor = new TestHttpExecutor();
    String prefix = String.join("", Collections.nCopies(prefixLength, "x"));
    executor.enqueueResponse(200,
        "{\"security\":{\"threat_score\":\"" + prefix + KEY + prefix + "\"}}");
    Throwable error = catchThrowable(() -> execute(client(executor), 0));
    assertThat(error).isInstanceOf(SerializationException.class);
    assertNoKey(error);
    assertThat(error.getCause().getMessage()).isEqualTo(
        "com.fasterxml.jackson.databind.exc.InvalidFormatException");
  }

  @Test
  void invalidBaseUrlDoesNotExposeQueryValues() throws Exception {
    IpGeolocationClient client = new IpGeolocationClient(
        IpGeolocationClientConfig.builder(KEY).baseUrl("https://invalid host").build());
    Throwable error = catchThrowable(() -> execute(client, 0));
    assertThat(error).isInstanceOf(IllegalArgumentException.class)
        .hasMessage("Invalid API request URI");
    assertNoKey(error);
  }

  @ParameterizedTest
  @ValueSource(strings = {"null", "", "[null]", "[true]", "[5]", "[\"text\"]"})
  void malformedBulkResultsUseSerializationException(String body) {
    TestHttpExecutor executor = new TestHttpExecutor();
    executor.enqueueResponse(200, body);
    assertThatThrownBy(() -> execute(client(executor), 2)).isInstanceOf(SerializationException.class);
  }

  @Test
  void nullSingleResultUsesSerializationException() {
    TestHttpExecutor executor = new TestHttpExecutor();
    executor.enqueueResponse(200, "null");
    assertThatThrownBy(() -> execute(client(executor), 0)).isInstanceOf(SerializationException.class);
  }

  @Test
  void successfulResponsesAreNotRedacted() {
    TestHttpExecutor executor = new TestHttpExecutor();
    String body = "{\"ip\":\"" + KEY + "\"}";
    executor.enqueueResponse(200, body);
    executor.enqueueResponse(200, body);
    IpGeolocationClient client = client(executor);
    LookupIpGeolocationRequest request = LookupIpGeolocationRequest.builder().build();
    assertThat(client.lookupIpGeolocation(request).data().ip()).isEqualTo(KEY);
    assertThat(client.lookupIpGeolocationRaw(request).data()).isEqualTo(body);
  }

  private static IpGeolocationClient client(TestHttpExecutor executor) {
    return new IpGeolocationClient(IpGeolocationClientConfig.builder(KEY).build(),
        executor, ObjectMapperFactory.create());
  }

  private static Object execute(IpGeolocationClient client, int operation) {
    LookupIpGeolocationRequest single = LookupIpGeolocationRequest.builder().ip("8.8.8.8").build();
    BulkLookupIpGeolocationRequest bulk = BulkLookupIpGeolocationRequest.builder().addIp("8.8.8.8").build();
    switch (operation) {
      case 0: return client.lookupIpGeolocation(single);
      case 1: return client.lookupIpGeolocationRaw(single);
      case 2: return client.bulkLookupIpGeolocation(bulk);
      default: return client.bulkLookupIpGeolocationRaw(bulk);
    }
  }

  private static void assertNoKey(Throwable error) throws Exception {
    StringWriter text = new StringWriter();
    error.printStackTrace(new PrintWriter(text));
    ByteArrayOutputStream bytes = new ByteArrayOutputStream();
    try (ObjectOutputStream output = new ObjectOutputStream(bytes)) { output.writeObject(error); }
    String encoded = URLEncoder.encode(KEY, "UTF-8").replace("+", "%20");
    assertThat(text.toString()).doesNotContain(KEY, encoded);
    assertThat(new String(bytes.toByteArray(), StandardCharsets.ISO_8859_1))
        .doesNotContain(KEY, encoded);
  }
}
