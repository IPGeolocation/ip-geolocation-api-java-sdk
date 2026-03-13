package io.ipgeolocation.sdk;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import io.ipgeolocation.sdk.exceptions.ValidationException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Test;

class BulkRequestValidationBoundaryTest {

  @Test
  void acceptsExactlyFiftyThousandIps() {
    List<String> ips = new ArrayList<>(Collections.nCopies(50_000, "8.8.8.8"));

    BulkLookupIpGeolocationRequest request =
        BulkLookupIpGeolocationRequest.builder().ips(ips).build();

    assertThat(request.ips()).hasSize(50_000);
  }

  @Test
  void rejectsMoreThanFiftyThousandIps() {
    List<String> ips = new ArrayList<>(Collections.nCopies(50_001, "8.8.8.8"));

    assertThatThrownBy(() -> BulkLookupIpGeolocationRequest.builder().ips(ips).build())
        .isInstanceOf(ValidationException.class)
        .hasMessageContaining("at most 50000");
  }

  @Test
  void rejectsBlankIpEntries() {
    assertThatThrownBy(() -> BulkLookupIpGeolocationRequest.builder().addIp("   ").build())
        .isInstanceOf(ValidationException.class)
        .hasMessageContaining("must not be blank");
  }
}
