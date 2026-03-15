package io.ipgeolocation.sdk.model;

/**
 * One item in bulk lookup response; either success data or item-level error.
 */
public interface BulkLookupResult {
  /**
   * Indicates whether this bulk item contains resolved IPGeolocation API data.
   *
   * @return true when this item contains resolved geolocation data
   */
  boolean success();
}
