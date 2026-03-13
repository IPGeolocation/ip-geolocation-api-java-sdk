package io.ipgeolocation.sdk.model;

/**
 * One item in bulk lookup response; either success data or item-level error.
 */
public sealed interface BulkLookupResult permits BulkLookupSuccess, BulkLookupError {
  /**
   * @return true when this item contains resolved geolocation data
   */
  boolean success();
}
