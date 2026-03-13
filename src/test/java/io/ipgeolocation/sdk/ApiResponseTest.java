package io.ipgeolocation.sdk;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Map;
import org.junit.jupiter.api.Test;

class ApiResponseTest {

  @Test
  void allowsNullDataWhenMetadataIsPresent() {
    ApiResponseMetadata metadata = new ApiResponseMetadata(null, null, 200, 4L, Map.of());

    ApiResponse<String> response = new ApiResponse<>(null, metadata);

    assertThat(response.data()).isNull();
    assertThat(response.metadata()).isEqualTo(metadata);
  }

  @Test
  void rejectsNullMetadata() {
    assertThatThrownBy(() -> new ApiResponse<>(null, null))
        .isInstanceOf(NullPointerException.class)
        .hasMessageContaining("metadata must not be null");
  }
}
