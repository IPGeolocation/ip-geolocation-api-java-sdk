package io.ipgeolocation.sdk;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Metadata extracted from IP Geolocation API response headers and SDK execution.
 *
 * @param creditsCharged parsed value of {@code X-Credits-Charged}, or {@code null} when missing
 *     or non-numeric
 * @param successfulRecords parsed value of {@code X-Successful-Record}, or {@code null} when
 *     missing or non-numeric
 * @param statusCode HTTP status code of the final response
 * @param durationMs total request duration in milliseconds
 * @param rawHeaders immutable response header map with original header names
 */
public record ApiResponseMetadata(
    Integer creditsCharged,
    Integer successfulRecords,
    int statusCode,
    long durationMs,
    Map<String, List<String>> rawHeaders) {

  public ApiResponseMetadata {
    if (statusCode < 100 || statusCode > 599) {
      throw new IllegalArgumentException("statusCode must be between 100 and 599");
    }
    if (durationMs < 0) {
      throw new IllegalArgumentException("durationMs must be >= 0");
    }
    rawHeaders = normalizeHeaders(rawHeaders);
  }

  /**
   * Returns all values for a response header using case-insensitive header-name matching.
   *
   * @param name header name, non-blank
   * @return immutable values; empty when header is not present
   * @throws IllegalArgumentException when name is null or blank
   */
  public List<String> headerValues(String name) {
    if (name == null || name.isBlank()) {
      throw new IllegalArgumentException("header name must not be blank");
    }
    for (Map.Entry<String, List<String>> entry : rawHeaders.entrySet()) {
      String key = entry.getKey();
      if (key != null && key.equalsIgnoreCase(name)) {
        return entry.getValue();
      }
    }
    return List.of();
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
      return Map.of();
    }
    Map<String, List<String>> normalized = new LinkedHashMap<>(headers.size());
    headers.forEach(
        (name, values) -> {
          if (name == null) {
            return;
          }
          normalized.put(name, values == null || values.isEmpty() ? List.of() : List.copyOf(values));
        });
    if (normalized.isEmpty()) {
      return Map.of();
    }
    return Collections.unmodifiableMap(normalized);
  }
}
