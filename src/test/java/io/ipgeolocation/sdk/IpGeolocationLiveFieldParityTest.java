package io.ipgeolocation.sdk;

import static org.assertj.core.api.Assertions.assertThat;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.ipgeolocation.sdk.internal.ObjectMapperFactory;
import io.ipgeolocation.sdk.model.BulkLookupError;
import io.ipgeolocation.sdk.model.BulkLookupResult;
import io.ipgeolocation.sdk.model.BulkLookupSuccess;
import io.ipgeolocation.sdk.model.IpGeolocationResponse;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;

/**
 * Optional live hardening tests that compare raw API JSON to the typed SDK model.
 *
 * <p>These tests consume credits and are disabled by default. Enable them with
 * {@code IPGEO_RUN_LIVE_HARDENING=true} and a valid {@code IPGEO_PAID_KEY}.
 */
class IpGeolocationLiveFieldParityTest {
  private static final ObjectMapper MAPPER = ObjectMapperFactory.create();

  private static String paidKey;

  @BeforeAll
  static void beforeAll() {
    Assumptions.assumeTrue(
        "true".equalsIgnoreCase(System.getenv("IPGEO_RUN_LIVE_HARDENING")),
        "Set IPGEO_RUN_LIVE_HARDENING=true to enable live field parity tests");

    paidKey = System.getenv("IPGEO_PAID_KEY");
    Assumptions.assumeTrue(!TestSupport.isBlank(paidKey), "IPGEO_PAID_KEY is required");
  }

  @Test
  void includeStarResponseMatchesTypedModel() throws Exception {
    assertSingleLookupParity(
        LookupIpGeolocationRequest.builder()
            .ip("8.8.8.8")
            .include("*")
            .build());
  }

  @Test
  void geoAccuracyAndDmaResponseMatchesTypedModel() throws Exception {
    assertSingleLookupParity(
        LookupIpGeolocationRequest.builder()
            .ip("8.8.8.8")
            .include("geo_accuracy")
            .include("dma_code")
            .build());
  }

  @Test
  void domainLookupResponseMatchesTypedModel() throws Exception {
    assertSingleLookupParity(
        LookupIpGeolocationRequest.builder()
            .ip("ipgeolocation.io")
            .include("hostnameFallbackLive")
            .build());
  }

  @Test
  void securityAbuseAndUserAgentResponseMatchesTypedModel() throws Exception {
    assertSingleLookupParity(
        LookupIpGeolocationRequest.builder()
            .ip("8.8.8.8")
            .include("security")
            .include("abuse")
            .include("user_agent")
            .userAgent(
                "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_2) "
                    + "AppleWebKit/601.3.9 (KHTML, like Gecko) Version/9.0.2 Safari/601.3.9")
            .build());
  }

  @Test
  void bulkMixedResponseMatchesTypedModel() throws Exception {
    try (IpGeolocationClient client =
        new IpGeolocationClient(IpGeolocationClientConfig.builder(paidKey).build())) {
      BulkLookupIpGeolocationRequest request =
          BulkLookupIpGeolocationRequest.builder()
              .addIp("8.8.8.8")
              .addIp("invalid-ip")
              .addIp("1.1.1.1")
              .build();

      ApiResponse<String> raw = client.bulkLookupIpGeolocationRaw(request);
      ApiResponse<List<BulkLookupResult>> typed = client.bulkLookupIpGeolocation(request);

      JsonNode rawArray = MAPPER.readTree(raw.data());
      assertThat(rawArray.isArray()).isTrue();
      assertThat(typed.data()).hasSize(rawArray.size());

      for (int i = 0; i < rawArray.size(); i++) {
        JsonNode rawItem = rawArray.get(i);
        BulkLookupResult typedItem = typed.data().get(i);

        if (typedItem instanceof BulkLookupSuccess) {
          assertJsonSubset(
              rawItem,
              MAPPER.valueToTree(((BulkLookupSuccess) typedItem).item()),
              "$[" + i + "]");
        } else {
          assertThat(typedItem).isInstanceOf(BulkLookupError.class);
          assertThat(rawItem.path("message").asText())
              .isEqualTo(((BulkLookupError) typedItem).message());
        }
      }
    }
  }

  private static void assertSingleLookupParity(LookupIpGeolocationRequest request) throws Exception {
    try (IpGeolocationClient client =
        new IpGeolocationClient(IpGeolocationClientConfig.builder(paidKey).build())) {
      ApiResponse<String> raw = client.lookupIpGeolocationRaw(request);
      ApiResponse<IpGeolocationResponse> typed = client.lookupIpGeolocation(request);

      JsonNode rawNode = MAPPER.readTree(raw.data());
      JsonNode typedNode = MAPPER.valueToTree(typed.data());

      assertJsonSubset(rawNode, typedNode, "$");
    }
  }

  private static void assertJsonSubset(JsonNode rawNode, JsonNode typedNode, String path) {
    if (rawNode == null || rawNode.isNull()) {
      assertThat(typedNode == null || typedNode.isNull()).as(path).isTrue();
      return;
    }

    assertThat(typedNode).as(path).isNotNull();

    if (isLiveClockField(path)) {
      assertThat(typedNode.isNull()).as(path).isFalse();
      return;
    }

    if (rawNode.isObject()) {
      assertThat(typedNode.isObject()).as(path).isTrue();
      for (Map.Entry<String, JsonNode> field : rawNode.properties()) {
        assertThat(typedNode.has(field.getKey()))
            .as(path + "." + field.getKey())
            .isTrue();
        assertJsonSubset(field.getValue(), typedNode.get(field.getKey()), path + "." + field.getKey());
      }
      return;
    }

    if (rawNode.isArray()) {
      assertThat(typedNode.isArray()).as(path).isTrue();
      assertThat(typedNode.size()).as(path + " size").isEqualTo(rawNode.size());
      for (int i = 0; i < rawNode.size(); i++) {
        assertJsonSubset(rawNode.get(i), typedNode.get(i), path + "[" + i + "]");
      }
      return;
    }

    if (rawNode.isNumber() && typedNode.isNumber()) {
      BigDecimal rawValue = rawNode.decimalValue().stripTrailingZeros();
      BigDecimal typedValue = typedNode.decimalValue().stripTrailingZeros();
      assertThat(typedValue).as(path).isEqualByComparingTo(rawValue);
      return;
    }

    assertThat(typedNode).as(path).isEqualTo(rawNode);
  }

  private static boolean isLiveClockField(String path) {
    return path.endsWith(".time_zone.current_time")
        || path.endsWith(".time_zone.current_time_unix");
  }
}
