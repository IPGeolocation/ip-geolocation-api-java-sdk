package io.ipgeolocation.sdk.internal;

import static org.assertj.core.api.Assertions.assertThat;

import java.net.URI;
import org.junit.jupiter.api.Test;

class UriBuilderTest {

  @Test
  void omitsBlankQueryParams() {
    URI uri =
        UriBuilder.of("https://api.ipgeolocation.io", "/v3/ipgeo")
            .queryParam("apiKey", " ")
            .queryParam("ip", null)
            .queryParam("lang", "en")
            .build();

    assertThat(uri.toString()).isEqualTo("https://api.ipgeolocation.io/v3/ipgeo?lang=en");
  }

  @Test
  void omitsNullAndBlankQueryParamNames() {
    URI uri =
        UriBuilder.of("https://api.ipgeolocation.io", "/v3/ipgeo")
            .queryParam(null, "x")
            .queryParam(" ", "y")
            .queryParam("lang", "en")
            .build();

    assertThat(uri.toString()).isEqualTo("https://api.ipgeolocation.io/v3/ipgeo?lang=en");
  }

  @Test
  void encodesReservedCharactersInQueryValues() {
    URI uri =
        UriBuilder.of("https://api.ipgeolocation.io", "/v3/ipgeo")
            .queryParam("include", "security,abuse")
            .queryParam("ip", "New York")
            .build();

    assertThat(uri.toString())
        .isEqualTo(
            "https://api.ipgeolocation.io/v3/ipgeo?include=security%2Cabuse&ip=New%20York");
  }

  @Test
  void buildWithoutQueryParamsKeepsBaseUrlAndPathOnly() {
    URI uri = UriBuilder.of("https://api.ipgeolocation.io", "/v3/ipgeo").build();
    assertThat(uri.toString()).isEqualTo("https://api.ipgeolocation.io/v3/ipgeo");
  }
}
