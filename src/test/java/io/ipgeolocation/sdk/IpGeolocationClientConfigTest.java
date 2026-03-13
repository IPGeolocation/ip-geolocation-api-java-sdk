package io.ipgeolocation.sdk;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.time.Duration;
import org.junit.jupiter.api.Test;

class IpGeolocationClientConfigTest {

  @Test
  void allowsBuildingWithoutApiKeyForRequestOriginMode() {
    IpGeolocationClientConfig config = IpGeolocationClientConfig.builder().build();
    assertThat(config.apiKey()).isNull();
  }

  @Test
  void keepsProvidedApiKey() {
    IpGeolocationClientConfig config = IpGeolocationClientConfig.builder("k").build();
    assertThat(config.apiKey()).isEqualTo("k");
  }

  @Test
  void rejectsBlankApiKeyWhenProvided() {
    assertThatThrownBy(() -> IpGeolocationClientConfig.builder("   ").build())
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("apiKey must not be blank");
  }

  @Test
  void builderApiKeyNullClearsConfiguredKey() {
    IpGeolocationClientConfig config =
        IpGeolocationClientConfig.builder("k").apiKey(null).build();

    assertThat(config.apiKey()).isNull();
  }

  @Test
  void trimsTrailingSlashFromBaseUrl() {
    IpGeolocationClientConfig config =
        IpGeolocationClientConfig.builder("k")
            .baseUrl("https://api.ipgeolocation.io///")
            .build();

    assertThat(config.baseUrl()).isEqualTo("https://api.ipgeolocation.io");
  }

  @Test
  void keepsBaseUrlWithoutTrailingSlashUnchanged() {
    IpGeolocationClientConfig config =
        IpGeolocationClientConfig.builder("k")
            .baseUrl("https://api.ipgeolocation.io")
            .build();

    assertThat(config.baseUrl()).isEqualTo("https://api.ipgeolocation.io");
  }

  @Test
  void rejectsConnectTimeoutGreaterThanReadTimeout() {
    assertThatThrownBy(
            () ->
                IpGeolocationClientConfig.builder("k")
                    .connectTimeout(Duration.ofSeconds(31))
                    .readTimeout(Duration.ofSeconds(30))
                    .build())
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("connectTimeout must be <= readTimeout");
  }

  @Test
  void rejectsBlankBaseUrl() {
    assertThatThrownBy(() -> IpGeolocationClientConfig.builder("k").baseUrl("   "))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("baseUrl must not be blank");
  }

  @Test
  void rejectsNullBaseUrl() {
    assertThatThrownBy(() -> IpGeolocationClientConfig.builder("k").baseUrl(null))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("baseUrl must not be blank");
  }

  @Test
  void rejectsNullAndNonPositiveTimeoutValues() {
    assertThatThrownBy(() -> IpGeolocationClientConfig.builder("k").connectTimeout(null))
        .isInstanceOf(NullPointerException.class)
        .hasMessageContaining("connectTimeout must not be null");

    assertThatThrownBy(() -> IpGeolocationClientConfig.builder("k").readTimeout(null))
        .isInstanceOf(NullPointerException.class)
        .hasMessageContaining("readTimeout must not be null");

    assertThatThrownBy(() -> IpGeolocationClientConfig.builder("k").connectTimeout(Duration.ZERO))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("connectTimeout must be greater than zero");

    assertThatThrownBy(() -> IpGeolocationClientConfig.builder("k").readTimeout(Duration.ofSeconds(-1)))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("readTimeout must be greater than zero");
  }

}
