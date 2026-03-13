package io.ipgeolocation.sdk;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

class ApiResponseMetadataTest {

  @Test
  void storesProvidedValues() {
    ApiResponseMetadata metadata =
        new ApiResponseMetadata(
            2,
            3,
            200,
            12L,
            Map.of("X-Credits-Charged", List.of("2")));

    assertThat(metadata.creditsCharged()).isEqualTo(2);
    assertThat(metadata.successfulRecords()).isEqualTo(3);
    assertThat(metadata.statusCode()).isEqualTo(200);
    assertThat(metadata.durationMs()).isEqualTo(12L);
    assertThat(metadata.rawHeaders()).containsKey("X-Credits-Charged");
  }

  @Test
  void nullHeadersBecomeEmptyImmutableMap() {
    ApiResponseMetadata metadata =
        new ApiResponseMetadata(null, null, 200, 0L, null);

    assertThat(metadata.rawHeaders()).isEmpty();
    assertThatThrownBy(() -> metadata.rawHeaders().put("X-New", List.of("1")))
        .isInstanceOf(UnsupportedOperationException.class);
  }

  @Test
  void rawHeadersAreDefensivelyCopiedAndNormalized() {
    Map<String, List<String>> source = new HashMap<>();
    source.put("X-Trace-Id", new ArrayList<>(List.of("trace-1")));
    source.put("X-Null", null);
    source.put(null, List.of("ignored"));

    ApiResponseMetadata metadata =
        new ApiResponseMetadata(null, null, 200, 1L, source);

    source.put("X-Client-Hint", List.of("hint-1"));
    source.get("X-Trace-Id").add("trace-2");

    assertThat(metadata.rawHeaders()).containsOnlyKeys("X-Trace-Id", "X-Null");
    assertThat(metadata.rawHeaders().get("X-Trace-Id")).containsExactly("trace-1");
    assertThat(metadata.rawHeaders().get("X-Null")).isEmpty();
    assertThatThrownBy(() -> metadata.rawHeaders().get("X-Trace-Id").add("trace-3"))
        .isInstanceOf(UnsupportedOperationException.class);
  }

  @Test
  void rawHeadersWithOnlyNullHeaderNamesNormalizeToEmptyMap() {
    Map<String, List<String>> source = new HashMap<>();
    source.put(null, List.of("ignored"));

    ApiResponseMetadata metadata =
        new ApiResponseMetadata(null, null, 200, 1L, source);

    assertThat(metadata.rawHeaders()).isEmpty();
  }

  @Test
  void headerLookupIsCaseInsensitive() {
    ApiResponseMetadata metadata =
        new ApiResponseMetadata(
            null,
            null,
            200,
            1L,
            Map.of("X-Credits-Charged", List.of("2")));

    assertThat(metadata.headerValues("x-credits-charged")).containsExactly("2");
    assertThat(metadata.firstHeaderValue("X-CREDITS-CHARGED")).isEqualTo("2");
  }

  @Test
  void duplicateHeaderNamesWithDifferentCasePreferFirstInsertedHeader() {
    Map<String, List<String>> headers = new LinkedHashMap<>();
    headers.put("X-Credits-Charged", List.of("2"));
    headers.put("x-credits-charged", List.of("9"));

    ApiResponseMetadata metadata =
        new ApiResponseMetadata(null, null, 200, 1L, headers);

    assertThat(metadata.headerValues("X-CREDITS-CHARGED")).containsExactly("2");
    assertThat(metadata.firstHeaderValue("x-credits-charged")).isEqualTo("2");
  }

  @Test
  void missingHeaderReturnsEmptyListAndNullFirstValue() {
    ApiResponseMetadata metadata =
        new ApiResponseMetadata(null, null, 200, 0L, Map.of());

    assertThat(metadata.headerValues("X-Unknown")).isEmpty();
    assertThat(metadata.firstHeaderValue("X-Unknown")).isNull();
  }

  @Test
  void headerLookupRejectsBlankName() {
    ApiResponseMetadata metadata =
        new ApiResponseMetadata(null, null, 200, 0L, Map.of());

    assertThatThrownBy(() -> metadata.headerValues(" "))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("header name must not be blank");
    assertThatThrownBy(() -> metadata.firstHeaderValue(null))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("header name must not be blank");
  }

  @Test
  void allowsNullParsedHeaderValues() {
    ApiResponseMetadata metadata =
        new ApiResponseMetadata(null, null, 200, 0L, Map.of());

    assertThat(metadata.creditsCharged()).isNull();
    assertThat(metadata.successfulRecords()).isNull();
  }

  @Test
  void rejectsOutOfRangeStatusCode() {
    assertThatThrownBy(() -> new ApiResponseMetadata(null, null, 99, 0L, Map.of()))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("statusCode must be between 100 and 599");
  }

  @Test
  void rejectsNegativeDurationMs() {
    assertThatThrownBy(() -> new ApiResponseMetadata(null, null, 200, -1L, Map.of()))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("durationMs must be >= 0");
  }
}
