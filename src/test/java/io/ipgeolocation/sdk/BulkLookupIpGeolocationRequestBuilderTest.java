package io.ipgeolocation.sdk;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import io.ipgeolocation.sdk.exceptions.ValidationException;
import java.util.List;
import org.junit.jupiter.api.Test;

class BulkLookupIpGeolocationRequestBuilderTest {

  @Test
  void ipsListOverridesPreviouslyAddedIps() {
    BulkLookupIpGeolocationRequest request =
        BulkLookupIpGeolocationRequest.builder()
            .addIp("8.8.8.8")
            .ips(List.of("1.1.1.1"))
            .build();

    assertThat(request.ips()).containsExactly("1.1.1.1");
  }

  @Test
  void acceptsDomainEntries() {
    BulkLookupIpGeolocationRequest request =
        BulkLookupIpGeolocationRequest.builder()
            .addIp("ipgeolocation.io")
            .build();

    assertThat(request.ips()).containsExactly("ipgeolocation.io");
  }

  @Test
  void languageDefaultsToNullWhenNotProvided() {
    BulkLookupIpGeolocationRequest request =
        BulkLookupIpGeolocationRequest.builder()
            .addIp("8.8.8.8")
            .build();

    assertThat(request.lang()).isNull();
  }

  @Test
  void rejectsNullIpsList() {
    assertThatThrownBy(() -> BulkLookupIpGeolocationRequest.builder().ips(null))
        .isInstanceOf(NullPointerException.class)
        .hasMessageContaining("ips must not be null");
  }

  @Test
  void rejectsNullOutput() {
    assertThatThrownBy(() -> BulkLookupIpGeolocationRequest.builder().output(null))
        .isInstanceOf(NullPointerException.class)
        .hasMessageContaining("output must not be null");
  }

  @Test
  void rejectsBlankIncludeFieldAndExcludeValues() {
    assertThatThrownBy(() -> BulkLookupIpGeolocationRequest.builder().include(" "))
        .isInstanceOf(ValidationException.class)
        .hasMessageContaining("include value must not be blank");

    assertThatThrownBy(() -> BulkLookupIpGeolocationRequest.builder().fields(" "))
        .isInstanceOf(ValidationException.class)
        .hasMessageContaining("fields value must not be blank");

    assertThatThrownBy(() -> BulkLookupIpGeolocationRequest.builder().excludes(""))
        .isInstanceOf(ValidationException.class)
        .hasMessageContaining("excludes value must not be blank");
  }

  @Test
  void rejectsNullIncludeFieldAndExcludeValues() {
    assertThatThrownBy(() -> BulkLookupIpGeolocationRequest.builder().include(null))
        .isInstanceOf(ValidationException.class)
        .hasMessageContaining("include value must not be blank");

    assertThatThrownBy(() -> BulkLookupIpGeolocationRequest.builder().fields(null))
        .isInstanceOf(ValidationException.class)
        .hasMessageContaining("fields value must not be blank");

    assertThatThrownBy(() -> BulkLookupIpGeolocationRequest.builder().excludes(null))
        .isInstanceOf(ValidationException.class)
        .hasMessageContaining("excludes value must not be blank");
  }

  @Test
  void userAgentOverrideCanBeSet() {
    BulkLookupIpGeolocationRequest request =
        BulkLookupIpGeolocationRequest.builder()
            .addIp("8.8.8.8")
            .userAgent("python-requests/2.32.5")
            .build();

    assertThat(request.userAgent()).isEqualTo("python-requests/2.32.5");
  }

  @Test
  void nullUserAgentKeepsOverrideUnset() {
    BulkLookupIpGeolocationRequest request =
        BulkLookupIpGeolocationRequest.builder()
            .addIp("8.8.8.8")
            .userAgent(null)
            .build();

    assertThat(request.userAgent()).isNull();
  }

  @Test
  void rejectsBlankUserAgent() {
    assertThatThrownBy(
            () -> BulkLookupIpGeolocationRequest.builder().addIp("8.8.8.8").userAgent(" "))
        .isInstanceOf(ValidationException.class)
        .hasMessageContaining("userAgent must not be blank");
  }
}
