package io.ipgeolocation.sdk;

import java.util.Objects;

/**
 * Wraps parsed IPGeolocation API response data with SDK metadata.
 *
 * @param <T> parsed response body type
 */
public final class ApiResponse<T> {
  private final T data;
  private final ApiResponseMetadata metadata;

  public ApiResponse(T data, ApiResponseMetadata metadata) {
    this.data = data;
    this.metadata = Objects.requireNonNull(metadata, "metadata must not be null");
  }

  public T data() {
    return data;
  }

  public ApiResponseMetadata metadata() {
    return metadata;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) {
      return true;
    }
    if (!(other instanceof ApiResponse)) {
      return false;
    }
    ApiResponse<?> that = (ApiResponse<?>) other;
    return Objects.equals(data, that.data) && Objects.equals(metadata, that.metadata);
  }

  @Override
  public int hashCode() {
    return Objects.hash(data, metadata);
  }

  @Override
  public String toString() {
    return "ApiResponse{data=" + data + ", metadata=" + metadata + '}';
  }
}
