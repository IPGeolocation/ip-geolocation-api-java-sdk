package io.ipgeolocation.sdk.model;

import java.util.Objects;

/**
 * Successful item in bulk lookup response array.
 *
 * @param item typed geolocation payload for the input item
 */
public record BulkLookupSuccess(IpGeolocationResponse item) implements BulkLookupResult {
  public BulkLookupSuccess {
    Objects.requireNonNull(item, "item must not be null");
  }

  @Override
  public boolean success() {
    return true;
  }
}
