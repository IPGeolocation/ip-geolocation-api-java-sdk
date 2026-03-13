package io.ipgeolocation.sdk;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import io.ipgeolocation.sdk.exceptions.SerializationException;
import io.ipgeolocation.sdk.internal.ObjectMapperFactory;
import io.ipgeolocation.sdk.model.BulkLookupError;
import io.ipgeolocation.sdk.model.BulkLookupResult;
import io.ipgeolocation.sdk.model.BulkLookupSuccess;
import io.ipgeolocation.sdk.model.IpGeolocationResponse;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

class IpGeolocationClientParsingTest {

  @Test
  void parsesSingleLookupResponseAndMetadata() {
    TestHttpExecutor executor = new TestHttpExecutor();
    executor.enqueueResponse(
        200,
        """
        {
          "ip":"91.128.103.196",
          "location":{"country_name":"Sweden","is_eu":true,"confidence":"high"},
          "time_zone":{"name":"Europe/Stockholm","is_dst":false}
        }
        """,
        Map.of(
            "X-Credits-Charged", List.of("1"),
            "X-Trace-Id", List.of("trace-1")));

    IpGeolocationClient client =
        new IpGeolocationClient(
            IpGeolocationClientConfig.builder("k").build(),
            executor,
            millis -> {},
            ObjectMapperFactory.create());

    ApiResponse<IpGeolocationResponse> response =
        client.lookupIpGeolocation(LookupIpGeolocationRequest.builder().build());

    assertThat(response.data().ip()).isEqualTo("91.128.103.196");
    assertThat(response.data().location().countryName()).isEqualTo("Sweden");
    assertThat(response.data().location().isEu()).isTrue();
    assertThat(response.data().location().confidence()).isEqualTo(io.ipgeolocation.sdk.model.Location.Confidence.HIGH);
    assertThat(response.metadata().creditsCharged()).isEqualTo(1);
    assertThat(response.metadata().statusCode()).isEqualTo(200);
    assertThat(response.metadata().durationMs()).isGreaterThanOrEqualTo(0L);
  }

  @Test
  void parsesBulkOneOfItems() {
    TestHttpExecutor executor = new TestHttpExecutor();
    executor.enqueueResponse(
        200,
        """
        [
          {"ip":"8.8.8.8","location":{"country_name":"United States"}},
          {"message":"'10.0.0.1' is a bogon IP address."}
        ]
        """);

    IpGeolocationClient client =
        new IpGeolocationClient(
            IpGeolocationClientConfig.builder("k").build(),
            executor,
            millis -> {},
            ObjectMapperFactory.create());

    ApiResponse<List<BulkLookupResult>> response =
        client.bulkLookupIpGeolocation(
            BulkLookupIpGeolocationRequest.builder().addIp("8.8.8.8").addIp("10.0.0.1").build());

    assertThat(response.data()).hasSize(2);
    assertThat(response.data().get(0)).isInstanceOf(BulkLookupSuccess.class);
    assertThat(((BulkLookupSuccess) response.data().get(0)).item().ip()).isEqualTo("8.8.8.8");
    assertThat(response.data().get(1)).isInstanceOf(BulkLookupError.class);
    assertThat(((BulkLookupError) response.data().get(1)).message()).contains("bogon");
  }

  @Test
  void parsesHeadersCaseInsensitivelyAndIgnoresMalformedNumericHeaderValues() {
    TestHttpExecutor executor = new TestHttpExecutor();
    executor.enqueueResponse(
        200,
        """
        {"ip":"8.8.8.8"}
        """,
        Map.of(
            "x-credits-charged", List.of("not-a-number"),
            "x-trace-id", List.of("trace-2"),
            "x-client-hint", List.of("hint-2")));

    IpGeolocationClient client =
        new IpGeolocationClient(
            IpGeolocationClientConfig.builder("k").build(),
            executor,
            millis -> {},
            ObjectMapperFactory.create());

    ApiResponse<IpGeolocationResponse> response =
        client.lookupIpGeolocation(LookupIpGeolocationRequest.builder().build());

    assertThat(response.metadata().creditsCharged()).isNull();
    assertThat(response.metadata().statusCode()).isEqualTo(200);
  }

  @Test
  void bulkTypedResponseRejectsNonArrayPayload() {
    TestHttpExecutor executor = new TestHttpExecutor();
    executor.enqueueResponse(200, """
        {"ip":"8.8.8.8"}
        """);

    IpGeolocationClient client =
        new IpGeolocationClient(
            IpGeolocationClientConfig.builder("k").build(),
            executor,
            millis -> {},
            ObjectMapperFactory.create());

    assertThatThrownBy(
            () ->
                client.bulkLookupIpGeolocation(
                    BulkLookupIpGeolocationRequest.builder().addIp("8.8.8.8").build()))
        .isInstanceOf(SerializationException.class)
        .hasMessageContaining("expected an array payload");
  }

  @Test
  void singleTypedResponseRejectsMalformedJson() {
    TestHttpExecutor executor = new TestHttpExecutor();
    executor.enqueueResponse(200, "{malformed-json");

    IpGeolocationClient client =
        new IpGeolocationClient(
            IpGeolocationClientConfig.builder("k").build(),
            executor,
            millis -> {},
            ObjectMapperFactory.create());

    assertThatThrownBy(
            () -> client.lookupIpGeolocation(LookupIpGeolocationRequest.builder().build()))
        .isInstanceOf(SerializationException.class)
        .hasMessageContaining("Failed to deserialize API response");
  }

  @Test
  void bulkTypedResponseRejectsMalformedJson() {
    TestHttpExecutor executor = new TestHttpExecutor();
    executor.enqueueResponse(200, "[{");

    IpGeolocationClient client =
        new IpGeolocationClient(
            IpGeolocationClientConfig.builder("k").build(),
            executor,
            millis -> {},
            ObjectMapperFactory.create());

    assertThatThrownBy(
            () ->
                client.bulkLookupIpGeolocation(
                    BulkLookupIpGeolocationRequest.builder().addIp("8.8.8.8").build()))
        .isInstanceOf(SerializationException.class)
        .hasMessageContaining("Failed to deserialize bulk lookup response");
  }

  @Test
  void handlesNullHeadersFromTransportAsNullUsageMetadata() {
    TestHttpExecutor executor = new TestHttpExecutor();
    executor.enqueueResponse(200, "{\"ip\":\"8.8.8.8\"}", null);

    IpGeolocationClient client =
        new IpGeolocationClient(
            IpGeolocationClientConfig.builder("k").build(),
            executor,
            millis -> {},
            ObjectMapperFactory.create());

    ApiResponse<IpGeolocationResponse> response =
        client.lookupIpGeolocation(LookupIpGeolocationRequest.builder().build());

    assertThat(response.metadata().creditsCharged()).isNull();
    assertThat(response.metadata().successfulRecords()).isNull();
    assertThat(response.metadata().rawHeaders()).isEmpty();
    assertThat(response.metadata().statusCode()).isEqualTo(200);
  }

  @Test
  void readTimeoutFallsBackToConfigReadTimeout() {
    TestHttpExecutor executor = new TestHttpExecutor();
    executor.enqueueResponse(200, "{\"ip\":\"8.8.8.8\"}");

    IpGeolocationClientConfig config =
        IpGeolocationClientConfig.builder("k")
            .connectTimeout(java.time.Duration.ofSeconds(5))
            .readTimeout(java.time.Duration.ofSeconds(7))
            .build();

    IpGeolocationClient client =
        new IpGeolocationClient(config, executor, millis -> {}, ObjectMapperFactory.create());

    client.lookupIpGeolocation(LookupIpGeolocationRequest.builder().build());

    assertThat(executor.capturedTimeouts()).containsExactly(java.time.Duration.ofSeconds(7));
  }

  @Test
  void blankCreditsHeaderValueIsIgnoredAsNull() {
    TestHttpExecutor executor = new TestHttpExecutor();
    executor.enqueueResponse(
        200,
        "{\"ip\":\"8.8.8.8\"}",
        Map.of("X-Credits-Charged", List.of(" ")));

    IpGeolocationClient client =
        new IpGeolocationClient(
            IpGeolocationClientConfig.builder("k").build(),
            executor,
            millis -> {},
            ObjectMapperFactory.create());

    ApiResponse<IpGeolocationResponse> response =
        client.lookupIpGeolocation(LookupIpGeolocationRequest.builder().build());

    assertThat(response.metadata().creditsCharged()).isNull();
  }

  @Test
  void bulkEntryContainingMessageAndIpIsTreatedAsSuccess() {
    TestHttpExecutor executor = new TestHttpExecutor();
    executor.enqueueResponse(
        200,
        """
        [
          {"ip":"8.8.8.8","message":"ignored-message","location":{"country_name":"United States"}}
        ]
        """);

    IpGeolocationClient client =
        new IpGeolocationClient(
            IpGeolocationClientConfig.builder("k").build(),
            executor,
            millis -> {},
            ObjectMapperFactory.create());

    ApiResponse<List<BulkLookupResult>> response =
        client.bulkLookupIpGeolocation(
            BulkLookupIpGeolocationRequest.builder().addIp("8.8.8.8").build());

    assertThat(response.data()).hasSize(1);
    assertThat(response.data().getFirst()).isInstanceOf(BulkLookupSuccess.class);
    assertThat(((BulkLookupSuccess) response.data().getFirst()).item().ip()).isEqualTo("8.8.8.8");
  }

  @Test
  void rawSingleReturnsXmlBodyWithoutTypedDeserialization() {
    TestHttpExecutor executor = new TestHttpExecutor();
    executor.enqueueResponse(
        200,
        "<ipgeo><ip>8.8.8.8</ip><location><country_name>United States</country_name></location></ipgeo>",
        Map.of("X-Credits-Charged", List.of("1")));

    IpGeolocationClient client =
        new IpGeolocationClient(
            IpGeolocationClientConfig.builder("k").build(),
            executor,
            millis -> {},
            ObjectMapperFactory.create());

    ApiResponse<String> response =
        client.lookupIpGeolocationRaw(
            LookupIpGeolocationRequest.builder()
                .ip("8.8.8.8")
                .output(ResponseFormat.XML)
                .build());

    assertThat(response.data()).contains("<ipgeo>").contains("<ip>8.8.8.8</ip>");
    assertThat(response.metadata().creditsCharged()).isEqualTo(1);
  }

  @Test
  void rawBulkReturnsXmlBodyWithoutTypedDeserialization() {
    TestHttpExecutor executor = new TestHttpExecutor();
    executor.enqueueResponse(
        200,
        "<items><item><ip>8.8.8.8</ip></item><item><message>invalid</message></item></items>",
        Map.of("X-Credits-Charged", List.of("2")));

    IpGeolocationClient client =
        new IpGeolocationClient(
            IpGeolocationClientConfig.builder("k").build(),
            executor,
            millis -> {},
            ObjectMapperFactory.create());

    ApiResponse<String> response =
        client.bulkLookupIpGeolocationRaw(
            BulkLookupIpGeolocationRequest.builder()
                .addIp("8.8.8.8")
                .output(ResponseFormat.XML)
                .build());

    assertThat(response.data()).contains("<items>").contains("<message>invalid</message>");
    assertThat(response.metadata().creditsCharged()).isEqualTo(2);
  }
}
