package io.ipgeolocation.sdk;

import static org.assertj.core.api.Assertions.assertThat;

import io.ipgeolocation.sdk.internal.ObjectMapperFactory;
import io.ipgeolocation.sdk.model.IpGeolocationResponse;
import io.ipgeolocation.sdk.model.Location;
import org.junit.jupiter.api.Test;

class EnumEvolutionTest {

  @Test
  void unknownConfidenceValueFallsBackToUnknown() throws Exception {
    String payload =
        """
        {
          "ip":"8.8.8.8",
          "location":{"confidence":"very_high"}
        }
        """;

    IpGeolocationResponse parsed =
        ObjectMapperFactory.create().readValue(payload, IpGeolocationResponse.class);

    assertThat(parsed.location().confidence()).isEqualTo(Location.Confidence.UNKNOWN);
  }
}
