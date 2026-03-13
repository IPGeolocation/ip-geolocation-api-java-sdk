package io.ipgeolocation.sdk;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import io.ipgeolocation.sdk.exceptions.ApiException;
import io.ipgeolocation.sdk.exceptions.BadRequestException;
import io.ipgeolocation.sdk.exceptions.ClientClosedRequestException;
import io.ipgeolocation.sdk.exceptions.LockedException;
import io.ipgeolocation.sdk.exceptions.MethodNotAllowedException;
import io.ipgeolocation.sdk.exceptions.NotFoundException;
import io.ipgeolocation.sdk.exceptions.PayloadTooLargeException;
import io.ipgeolocation.sdk.exceptions.RateLimitException;
import io.ipgeolocation.sdk.exceptions.ServerErrorException;
import io.ipgeolocation.sdk.exceptions.UnauthorizedException;
import io.ipgeolocation.sdk.exceptions.UnsupportedMediaTypeException;
import io.ipgeolocation.sdk.internal.ObjectMapperFactory;
import java.util.Map;
import org.junit.jupiter.api.Test;

class IpGeolocationClientErrorMappingTest {

  @Test
  void maps400ToBadRequestException() {
    assertMappedStatus(400, BadRequestException.class);
  }

  @Test
  void maps401ToUnauthorizedException() {
    assertMappedStatus(401, UnauthorizedException.class);
  }

  @Test
  void maps403ToGenericApiException() {
    assertMappedStatus(403, ApiException.class);
  }

  @Test
  void maps404ToNotFoundException() {
    assertMappedStatus(404, NotFoundException.class);
  }

  @Test
  void maps405ToMethodNotAllowedException() {
    assertMappedStatus(405, MethodNotAllowedException.class);
  }

  @Test
  void maps413ToPayloadTooLargeException() {
    assertMappedStatus(413, PayloadTooLargeException.class);
  }

  @Test
  void maps415ToUnsupportedMediaTypeException() {
    assertMappedStatus(415, UnsupportedMediaTypeException.class);
  }

  @Test
  void maps423ToLockedException() {
    assertMappedStatus(423, LockedException.class);
  }

  @Test
  void maps429ToRateLimitException() {
    assertMappedStatus(429, RateLimitException.class);
  }

  @Test
  void maps499ToClientClosedRequestException() {
    assertMappedStatus(499, ClientClosedRequestException.class);
  }

  @Test
  void maps5xxToServerErrorException() {
    assertMappedStatus(503, ServerErrorException.class);
  }

  @Test
  void mapsUnspecifiedStatusToGenericApiException() {
    assertMappedStatus(418, ApiException.class);
  }

  @Test
  void preservesApiErrorDetails() {
    TestHttpExecutor executor = new TestHttpExecutor();
    executor.enqueueResponse(
        401,
        "{\"message\":\"invalid key\"}",
        Map.of());

    IpGeolocationClient client =
        new IpGeolocationClient(
            IpGeolocationClientConfig.builder("k")
                .build(),
            executor,
            millis -> {},
            ObjectMapperFactory.create());

    assertThatThrownBy(
            () -> client.lookupIpGeolocation(LookupIpGeolocationRequest.builder().build()))
        .isInstanceOfSatisfying(
            ApiException.class,
            ex -> {
              assertThat(ex.statusCode()).isEqualTo(401);
              assertThat(ex.apiMessage()).isEqualTo("invalid key");
            });
  }

  @Test
  void nonJsonErrorBodyIsTruncatedAndExposedAsApiMessage() {
    String longBody = "x".repeat(700);

    TestHttpExecutor executor = new TestHttpExecutor();
    executor.enqueueResponse(400, longBody, Map.of());

    IpGeolocationClient client =
        new IpGeolocationClient(
            IpGeolocationClientConfig.builder("k")
                .build(),
            executor,
            millis -> {},
            ObjectMapperFactory.create());

    assertThatThrownBy(
            () -> client.lookupIpGeolocation(LookupIpGeolocationRequest.builder().build()))
        .isInstanceOfSatisfying(
            BadRequestException.class,
            ex -> {
              assertThat(ex.apiMessage()).hasSize(512);
              assertThat(ex.getMessage()).contains("HTTP status 400");
            });
  }

  @Test
  void emptyErrorBodyUsesGenericStatusMessage() {
    TestHttpExecutor executor = new TestHttpExecutor();
    executor.enqueueResponse(400, "", Map.of());

    IpGeolocationClient client =
        new IpGeolocationClient(
            IpGeolocationClientConfig.builder("k")
                .build(),
            executor,
            millis -> {},
            ObjectMapperFactory.create());

    assertThatThrownBy(
            () -> client.lookupIpGeolocation(LookupIpGeolocationRequest.builder().build()))
        .isInstanceOfSatisfying(
            BadRequestException.class,
            ex -> {
              assertThat(ex.apiMessage()).isNull();
              assertThat(ex.getMessage()).isEqualTo("API request failed with HTTP status 400");
            });
  }

  @Test
  void shortNonJsonErrorBodyIsExposedWithoutTruncation() {
    TestHttpExecutor executor = new TestHttpExecutor();
    executor.enqueueResponse(400, "plain-error-body", Map.of());

    IpGeolocationClient client =
        new IpGeolocationClient(
            IpGeolocationClientConfig.builder("k")
                .build(),
            executor,
            millis -> {},
            ObjectMapperFactory.create());

    assertThatThrownBy(
            () -> client.lookupIpGeolocation(LookupIpGeolocationRequest.builder().build()))
        .isInstanceOfSatisfying(
            BadRequestException.class,
            ex -> {
              assertThat(ex.apiMessage()).isEqualTo("plain-error-body");
              assertThat(ex.getMessage()).contains("plain-error-body");
            });
  }

  private void assertMappedStatus(int statusCode, Class<? extends Throwable> expected) {
    TestHttpExecutor executor = new TestHttpExecutor();
    executor.enqueueResponse(
        statusCode,
        "{\"message\":\"error detail\"}",
        Map.of());

    IpGeolocationClient client =
        new IpGeolocationClient(
            IpGeolocationClientConfig.builder("k")
                .build(),
            executor,
            millis -> {},
            ObjectMapperFactory.create());

    assertThatThrownBy(
            () -> client.lookupIpGeolocation(LookupIpGeolocationRequest.builder().build()))
        .isInstanceOf(expected)
        .hasMessageContaining("HTTP status " + statusCode)
        .hasMessageContaining("error detail");
  }
}
