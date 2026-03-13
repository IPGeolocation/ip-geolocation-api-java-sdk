package io.ipgeolocation.sdk.model;

/**
 * Item-level error in bulk lookup response array.
 *
 * @param message item-level error message
 */
public record BulkLookupError(String message) implements BulkLookupResult {
  @Override
  public boolean success() {
    return false;
  }
}
