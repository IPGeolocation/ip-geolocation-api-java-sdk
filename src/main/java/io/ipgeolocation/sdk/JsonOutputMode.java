package io.ipgeolocation.sdk;

/**
 * Controls whether null fields are included in serialized JSON output.
 */
public enum JsonOutputMode {
  /**
   * Omits fields with null values for cleaner developer-facing output.
   */
  COMPACT,

  /**
   * Includes null fields for complete structural/debug output.
   */
  FULL
}
