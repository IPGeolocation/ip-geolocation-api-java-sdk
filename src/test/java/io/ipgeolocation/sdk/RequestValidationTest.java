package io.ipgeolocation.sdk;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import io.ipgeolocation.sdk.exceptions.ValidationException;
import org.junit.jupiter.api.Test;

class RequestValidationTest {

  @Test
  void bulkRequestRejectsEmptyIpList() {
    assertThatThrownBy(() -> BulkLookupIpGeolocationRequest.builder().build())
        .isInstanceOf(ValidationException.class)
        .hasMessageContaining("ips must not be empty");
  }

  @Test
  void typedLookupRejectsXmlOutput() {
    TestHttpExecutor executor = new TestHttpExecutor();
    IpGeolocationClient client =
        new IpGeolocationClient(
            IpGeolocationClientConfig.builder("k").build(),
            executor,
            millis -> {},
            io.ipgeolocation.sdk.internal.ObjectMapperFactory.create());

    LookupIpGeolocationRequest request =
        LookupIpGeolocationRequest.builder().output(ResponseFormat.XML).build();

    assertThatThrownBy(() -> client.lookupIpGeolocation(request))
        .isInstanceOf(ValidationException.class)
        .hasMessageContaining("XML output is not supported");
  }

  @Test
  void typedBulkRejectsXmlOutput() {
    TestHttpExecutor executor = new TestHttpExecutor();
    IpGeolocationClient client =
        new IpGeolocationClient(
            IpGeolocationClientConfig.builder("k").build(),
            executor,
            millis -> {},
            io.ipgeolocation.sdk.internal.ObjectMapperFactory.create());

    BulkLookupIpGeolocationRequest request =
        BulkLookupIpGeolocationRequest.builder()
            .addIp("8.8.8.8")
            .output(ResponseFormat.XML)
            .build();

    assertThatThrownBy(() -> client.bulkLookupIpGeolocation(request))
        .isInstanceOf(ValidationException.class)
        .hasMessageContaining("XML output is not supported");
  }

  @Test
  void rawMethodsAllowXmlOutput() {
    TestHttpExecutor executor = new TestHttpExecutor();
    executor.enqueueResponse(200, "<ipgeo><ip>8.8.8.8</ip></ipgeo>");
    executor.enqueueResponse(200, "<items><item><ip>8.8.8.8</ip></item></items>");
    IpGeolocationClient client =
        new IpGeolocationClient(
            IpGeolocationClientConfig.builder("k").build(),
            executor,
            millis -> {},
            io.ipgeolocation.sdk.internal.ObjectMapperFactory.create());

    client.lookupIpGeolocationRaw(
        LookupIpGeolocationRequest.builder()
            .ip("8.8.8.8")
            .output(ResponseFormat.XML)
            .build());

    client.bulkLookupIpGeolocationRaw(
        BulkLookupIpGeolocationRequest.builder()
            .addIp("8.8.8.8")
            .output(ResponseFormat.XML)
            .build());
  }

  @Test
  void lookupRejectsNullRequest() {
    TestHttpExecutor executor = new TestHttpExecutor();
    IpGeolocationClient client =
        new IpGeolocationClient(
            IpGeolocationClientConfig.builder("k").build(),
            executor,
            millis -> {},
            io.ipgeolocation.sdk.internal.ObjectMapperFactory.create());

    assertThatThrownBy(() -> client.lookupIpGeolocation(null))
        .isInstanceOf(ValidationException.class)
        .hasMessageContaining("request must not be null");
  }

  @Test
  void bulkRejectsNullRequest() {
    TestHttpExecutor executor = new TestHttpExecutor();
    IpGeolocationClient client =
        new IpGeolocationClient(
            IpGeolocationClientConfig.builder("k").build(),
            executor,
            millis -> {},
            io.ipgeolocation.sdk.internal.ObjectMapperFactory.create());

    assertThatThrownBy(() -> client.bulkLookupIpGeolocation(null))
        .isInstanceOf(ValidationException.class)
        .hasMessageContaining("request must not be null");
  }

  @Test
  void typedBulkRejectsMissingApiKeyBeforeSendingRequest() {
    TestHttpExecutor executor = new TestHttpExecutor();
    IpGeolocationClient client =
        new IpGeolocationClient(
            IpGeolocationClientConfig.builder().build(),
            executor,
            millis -> {},
            io.ipgeolocation.sdk.internal.ObjectMapperFactory.create());

    assertThatThrownBy(
            () ->
                client.bulkLookupIpGeolocation(
                    BulkLookupIpGeolocationRequest.builder().addIp("8.8.8.8").build()))
        .isInstanceOf(ValidationException.class)
        .hasMessageContaining("bulk lookup requires apiKey");

    org.assertj.core.api.Assertions.assertThat(executor.capturedRequests()).isEmpty();
  }

  @Test
  void rawBulkRejectsMissingApiKeyBeforeSendingRequest() {
    TestHttpExecutor executor = new TestHttpExecutor();
    IpGeolocationClient client =
        new IpGeolocationClient(
            IpGeolocationClientConfig.builder().build(),
            executor,
            millis -> {},
            io.ipgeolocation.sdk.internal.ObjectMapperFactory.create());

    assertThatThrownBy(
            () ->
                client.bulkLookupIpGeolocationRaw(
                    BulkLookupIpGeolocationRequest.builder().addIp("8.8.8.8").build()))
        .isInstanceOf(ValidationException.class)
        .hasMessageContaining("bulk lookup requires apiKey");

    org.assertj.core.api.Assertions.assertThat(executor.capturedRequests()).isEmpty();
  }
}
