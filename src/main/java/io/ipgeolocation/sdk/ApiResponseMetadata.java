package io.ipgeolocation.sdk;

import io.ipgeolocation.sdk.internal.Compat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Metadata extracted from IPGeolocation API response headers and SDK execution.
 */
public final class ApiResponseMetadata {
  private final Integer creditsCharged;
  private final Integer successfulRecords;
  private final int statusCode;
  private final long durationMs;
  private final Map<String, List<String>> rawHeaders;

  public ApiResponseMetadata(
      Integer creditsCharged,
      Integer successfulRecords,
      int statusCode,
      long durationMs,
      Map<String, List<String>> rawHeaders) {
    if (statusCode < 100 || statusCode > 599) {
      throw new IllegalArgumentException("statusCode must be between 100 and 599");
    }
    if (durationMs < 0) {
      throw new IllegalArgumentException("durationMs must be >= 0");
    }
    this.creditsCharged = creditsCharged;
    this.successfulRecords = successfulRecords;
    this.statusCode = statusCode;
    this.durationMs = durationMs;
    this.rawHeaders = normalizeHeaders(rawHeaders);
  }

  public Integer creditsCharged() {
    return creditsCharged;
  }

  public Integer successfulRecords() {
    return successfulRecords;
  }

  public int statusCode() {
    return statusCode;
  }

  public long durationMs() {
    return durationMs;
  }

  public Map<String, List<String>> rawHeaders() {
    return rawHeaders;
  }

  /**
   * Returns all values for a response header using case-insensitive header-name matching.
   *
   * @param name header name, non-blank
   * @return immutable values; empty when header is not present
   * @throws IllegalArgumentException when name is null or blank
   */
  public List<String> headerValues(String name) {
    if (Compat.isBlank(name)) {
      throw new IllegalArgumentException("header name must not be blank");
    }
    for (Map.Entry<String, List<String>> entry : rawHeaders.entrySet()) {
      String key = entry.getKey();
      if (key != null && key.equalsIgnoreCase(name)) {
        return entry.getValue();
      }
    }
    return Collections.emptyList();
  }

  /**
   * Returns the first value for a response header using case-insensitive header-name matching.
   *
   * @param name header name, non-blank
   * @return first value, or {@code null} when header is not present
   * @throws IllegalArgumentException when name is null or blank
   */
  public String firstHeaderValue(String name) {
    List<String> values = headerValues(name);
    return values.isEmpty() ? null : values.get(0);
  }

  private static Map<String, List<String>> normalizeHeaders(Map<String, List<String>> headers) {
    if (headers == null || headers.isEmpty()) {
      return Collections.emptyMap();
    }
    Map<String, List<String>> normalized = new LinkedHashMap<>(headers.size());
    for (Map.Entry<String, List<String>> entry : headers.entrySet()) {
      String name = entry.getKey();
      List<String> values = entry.getValue();
      if (name == null) {
        continue;
      }
      normalized.put(
          name,
          values == null || values.isEmpty()
              ? Collections.<String>emptyList()
              : Collections.unmodifiableList(new ArrayList<String>(values)));
    }
    if (normalized.isEmpty()) {
      return Collections.emptyMap();
    }
    return Collections.unmodifiableMap(normalized);
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) {
      return true;
    }
    if (!(other instanceof ApiResponseMetadata)) {
      return false;
    }
    ApiResponseMetadata that = (ApiResponseMetadata) other;
    return statusCode == that.statusCode
        && durationMs == that.durationMs
        && Objects.equals(creditsCharged, that.creditsCharged)
        && Objects.equals(successfulRecords, that.successfulRecords)
        && Objects.equals(rawHeaders, that.rawHeaders);
  }

  @Override
  public int hashCode() {
    return Objects.hash(creditsCharged, successfulRecords, statusCode, durationMs, rawHeaders);
  }

  @Override
  public String toString() {
    return "ApiResponseMetadata{creditsCharged="
        + creditsCharged
        + ", successfulRecords="
        + successfulRecords
        + ", statusCode="
        + statusCode
        + ", durationMs="
        + durationMs
        + ", rawHeaders="
        + rawHeaders
        + '}';
  }
}
