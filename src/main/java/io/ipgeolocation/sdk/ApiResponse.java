package io.ipgeolocation.sdk;

import java.util.Objects;

/**
 * Wraps parsed IP Geolocation API response data with SDK metadata.
 *
 * @param <T> parsed response body type
 * @param data parsed response payload; may be {@code null} for empty API responses
 * @param metadata response metadata extracted from headers and SDK execution metrics
 */
public record ApiResponse<T>(T data, ApiResponseMetadata metadata) {
  public ApiResponse {
    Objects.requireNonNull(metadata, "metadata must not be null");
  }
}
