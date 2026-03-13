package io.ipgeolocation.sdk;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class LookupIpGeolocationRequestBuilderTest {

  @Test
  void blankIpIsTreatedAsOmitted() {
    LookupIpGeolocationRequest request =
        LookupIpGeolocationRequest.builder().ip("   ").build();

    assertThat(request.ip()).isNull();
  }

  @Test
  void nullIpRemainsOmitted() {
    LookupIpGeolocationRequest request = LookupIpGeolocationRequest.builder().ip(null).build();
    assertThat(request.ip()).isNull();
  }

  @Test
  void languageDefaultsToNullWhenNotProvided() {
    LookupIpGeolocationRequest request = LookupIpGeolocationRequest.builder().build();
    assertThat(request.lang()).isNull();
  }

  @Test
  void rejectsBlankIncludeValue() {
    assertThatThrownBy(() -> LookupIpGeolocationRequest.builder().include("   "))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("include value must not be blank");
  }

  @Test
  void rejectsNullIncludeFieldAndExcludeValues() {
    assertThatThrownBy(() -> LookupIpGeolocationRequest.builder().include(null))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("include value must not be blank");

    assertThatThrownBy(() -> LookupIpGeolocationRequest.builder().fields(null))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("fields value must not be blank");

    assertThatThrownBy(() -> LookupIpGeolocationRequest.builder().excludes(null))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("excludes value must not be blank");
  }

  @Test
  void rejectsBlankFieldValue() {
    assertThatThrownBy(() -> LookupIpGeolocationRequest.builder().fields(" "))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("fields value must not be blank");
  }

  @Test
  void rejectsBlankExcludeValue() {
    assertThatThrownBy(() -> LookupIpGeolocationRequest.builder().excludes(""))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("excludes value must not be blank");
  }

  @Test
  void userAgentOverrideCanBeSet() {
    LookupIpGeolocationRequest request =
        LookupIpGeolocationRequest.builder()
            .userAgent("Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36")
            .build();

    assertThat(request.userAgent()).isEqualTo("Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36");
  }

  @Test
  void nullUserAgentKeepsOverrideUnset() {
    LookupIpGeolocationRequest request =
        LookupIpGeolocationRequest.builder().userAgent(null).build();

    assertThat(request.userAgent()).isNull();
  }

  @Test
  void rejectsBlankUserAgent() {
    assertThatThrownBy(() -> LookupIpGeolocationRequest.builder().userAgent(" "))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("userAgent must not be blank");
  }

  @Test
  void rejectsNullOutput() {
    assertThatThrownBy(() -> LookupIpGeolocationRequest.builder().output(null))
        .isInstanceOf(NullPointerException.class)
        .hasMessageContaining("output must not be null");
  }
}
