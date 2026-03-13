package io.ipgeolocation.sdk;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class IpGeolocationClientConstructionTest {

  @Test
  void constructsClientWithDefaultHttpClientPath() {
    IpGeolocationClientConfig config = IpGeolocationClientConfig.builder("k").build();

    try (IpGeolocationClient client = new IpGeolocationClient(config)) {
      assertThat(client).isNotNull();
    }
  }
}
