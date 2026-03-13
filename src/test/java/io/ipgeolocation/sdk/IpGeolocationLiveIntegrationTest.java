package io.ipgeolocation.sdk;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import io.ipgeolocation.sdk.exceptions.UnauthorizedException;
import io.ipgeolocation.sdk.exceptions.ValidationException;
import io.ipgeolocation.sdk.model.BulkLookupError;
import io.ipgeolocation.sdk.model.BulkLookupResult;
import io.ipgeolocation.sdk.model.BulkLookupSuccess;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assumptions;

class IpGeolocationLiveIntegrationTest {
  private static String freeKey;
  private static String paidKey;

  @BeforeAll
  static void beforeAll() {
    Assumptions.assumeTrue(
        "true".equalsIgnoreCase(System.getenv("IPGEO_RUN_LIVE_TESTS")),
        "Set IPGEO_RUN_LIVE_TESTS=true to enable live tests");

    freeKey = System.getenv("IPGEO_FREE_KEY");
    paidKey = System.getenv("IPGEO_PAID_KEY");

    Assumptions.assumeTrue(freeKey != null && !freeKey.isBlank(), "IPGEO_FREE_KEY is required");
    Assumptions.assumeTrue(paidKey != null && !paidKey.isBlank(), "IPGEO_PAID_KEY is required");
  }

  @Test
  void freePlanBaseLookupWorks() {
    try (IpGeolocationClient client = new IpGeolocationClient(IpGeolocationClientConfig.builder(freeKey).build())) {
      var response = client.lookupIpGeolocation(
          LookupIpGeolocationRequest.builder().ip("8.8.8.8").build());

      assertThat(response.data().ip()).isEqualTo("8.8.8.8");
      assertThat(response.metadata().creditsCharged()).isGreaterThanOrEqualTo(1);
    }
  }

  @Test
  void freePlanSecurityModuleIsRejected() {
    try (IpGeolocationClient client = new IpGeolocationClient(IpGeolocationClientConfig.builder(freeKey).build())) {
      assertFreePlanIncludeRejected(client, "security");
    }
  }

  @Test
  void freePlanGeoAccuracyModuleIsRejected() {
    try (IpGeolocationClient client = new IpGeolocationClient(IpGeolocationClientConfig.builder(freeKey).build())) {
      assertFreePlanIncludeRejected(client, "geo_accuracy");
    }
  }

  @Test
  void freePlanDmaCodeModuleIsRejected() {
    try (IpGeolocationClient client = new IpGeolocationClient(IpGeolocationClientConfig.builder(freeKey).build())) {
      assertFreePlanIncludeRejected(client, "dma_code");
    }
  }

  @Test
  void freePlanHostnameModuleIsRejected() {
    try (IpGeolocationClient client = new IpGeolocationClient(IpGeolocationClientConfig.builder(freeKey).build())) {
      assertFreePlanIncludeRejected(client, "hostname");
    }
  }

  @Test
  void freePlanLiveHostnameModuleIsRejected() {
    try (IpGeolocationClient client = new IpGeolocationClient(IpGeolocationClientConfig.builder(freeKey).build())) {
      assertFreePlanIncludeRejected(client, "liveHostname");
    }
  }

  @Test
  void freePlanHostnameFallbackLiveModuleIsRejected() {
    try (IpGeolocationClient client = new IpGeolocationClient(IpGeolocationClientConfig.builder(freeKey).build())) {
      assertFreePlanIncludeRejected(client, "hostnameFallbackLive");
    }
  }

  @Test
  void freePlanIncludeStarReturnsDefaultResponseWithoutAdditionalModules() {
    try (IpGeolocationClient client = new IpGeolocationClient(IpGeolocationClientConfig.builder(freeKey).build())) {
      var response =
          client.lookupIpGeolocation(
              LookupIpGeolocationRequest.builder()
                  .ip("8.8.8.8")
                  .include("*")
                  .build());

      assertThat(response.data().ip()).isEqualTo("8.8.8.8");
      assertThat(response.data().security()).isNull();
      assertThat(response.data().abuse()).isNull();
      assertThat(response.data().userAgent()).isNull();
      assertThat(response.data().hostname()).isNull();
    }
  }

  @Test
  void freePlanBulkIsRejected() {
    try (IpGeolocationClient client = new IpGeolocationClient(IpGeolocationClientConfig.builder(freeKey).build())) {
      assertThatThrownBy(
              () ->
                  client.bulkLookupIpGeolocation(
                      BulkLookupIpGeolocationRequest.builder().addIp("8.8.8.8").build()))
          .isInstanceOf(UnauthorizedException.class);
    }
  }

  @Test
  void paidPlanSecurityAndAbuseWorks() {
    try (IpGeolocationClient client = new IpGeolocationClient(IpGeolocationClientConfig.builder(paidKey).build())) {
      var response =
          client.lookupIpGeolocation(
              LookupIpGeolocationRequest.builder()
                  .ip("8.8.8.8")
                  .include("security")
                  .include("abuse")
                  .build());

      assertThat(response.data().security()).isNotNull();
      assertThat(response.data().abuse()).isNotNull();
      assertThat(response.metadata().creditsCharged()).isGreaterThanOrEqualTo(4);
    }
  }

  @Test
  void paidPlanBulkMixedReturnsSuccessAndErrorItems() {
    try (IpGeolocationClient client = new IpGeolocationClient(IpGeolocationClientConfig.builder(paidKey).build())) {
      ApiResponse<List<BulkLookupResult>> response =
          client.bulkLookupIpGeolocation(
              BulkLookupIpGeolocationRequest.builder()
                  .addIp("8.8.8.8")
                  .addIp("invalid-ip")
                  .build());

      assertThat(response.data()).hasSize(2);
      assertThat(response.data().get(0)).isInstanceOf(BulkLookupSuccess.class);
      assertThat(response.data().get(1)).isInstanceOf(BulkLookupError.class);
    }
  }

  @Test
  void paidPlanXmlOutputIsRejectedForTypedMethod() {
    try (IpGeolocationClient client = new IpGeolocationClient(IpGeolocationClientConfig.builder(paidKey).build())) {
      assertThatThrownBy(
              () ->
                  client.lookupIpGeolocation(
                      LookupIpGeolocationRequest.builder()
                          .ip("8.8.8.8")
                          .output(ResponseFormat.XML)
                          .build()))
          .isInstanceOf(ValidationException.class)
          .hasMessageContaining("XML output is not supported");
    }
  }

  @Test
  void paidPlanIncludeUserAgentReflectsRequestUserAgentOverride() {
    try (IpGeolocationClient client = new IpGeolocationClient(IpGeolocationClientConfig.builder(paidKey).build())) {
      var defaultUaResponse =
          client.lookupIpGeolocation(
              LookupIpGeolocationRequest.builder()
                  .ip("8.8.8.8")
                  .include("user_agent")
                  .build());

      String overrideUserAgent = "python-requests/2.32.5";
      var overriddenUaResponse =
          client.lookupIpGeolocation(
              LookupIpGeolocationRequest.builder()
                  .ip("8.8.8.8")
                  .include("user_agent")
                  .userAgent(overrideUserAgent)
                  .build());

      assertThat(defaultUaResponse.data().userAgent()).isNotNull();
      assertThat(defaultUaResponse.data().userAgent().userAgentString()).isNotBlank();
      assertThat(overriddenUaResponse.data().userAgent()).isNotNull();
      assertThat(overriddenUaResponse.data().userAgent().userAgentString()).isEqualTo(overrideUserAgent);
      assertThat(overriddenUaResponse.data().userAgent().userAgentString())
          .isNotEqualTo(defaultUaResponse.data().userAgent().userAgentString());
    }
  }

  @Test
  void paidPlanRawMethodsReturnXmlWhenRequested() {
    try (IpGeolocationClient client = new IpGeolocationClient(IpGeolocationClientConfig.builder(paidKey).build())) {
      ApiResponse<String> single =
          client.lookupIpGeolocationRaw(
              LookupIpGeolocationRequest.builder()
                  .ip("8.8.8.8")
                  .output(ResponseFormat.XML)
                  .build());
      assertThat(single.data()).contains("<");

      ApiResponse<String> bulk =
          client.bulkLookupIpGeolocationRaw(
              BulkLookupIpGeolocationRequest.builder()
                  .addIp("8.8.8.8")
                  .addIp("invalid-ip")
                  .output(ResponseFormat.XML)
                  .build());
      assertThat(bulk.data()).contains("<");
    }
  }

  private static void assertFreePlanIncludeRejected(IpGeolocationClient client, String includeValue) {
    assertThatThrownBy(
            () ->
                client.lookupIpGeolocation(
                    LookupIpGeolocationRequest.builder()
                        .ip("8.8.8.8")
                        .include(includeValue)
                        .build()))
        .isInstanceOfSatisfying(
            UnauthorizedException.class,
            ex -> assertThat(ex.statusCode()).isEqualTo(401));
  }
}
