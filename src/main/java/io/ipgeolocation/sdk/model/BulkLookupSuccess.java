package io.ipgeolocation.sdk.model;

import java.util.Objects;

/**
 * Successful item in a bulk lookup response array.
 */
public final class BulkLookupSuccess implements BulkLookupResult {
  private final IpGeolocationResponse item;

  public BulkLookupSuccess(IpGeolocationResponse item) {
    this.item = Objects.requireNonNull(item, "item must not be null");
  }

  public IpGeolocationResponse item() {
    return item;
  }

  @Override
  public boolean success() {
    return true;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) {
      return true;
    }
    if (!(other instanceof BulkLookupSuccess)) {
      return false;
    }
    BulkLookupSuccess that = (BulkLookupSuccess) other;
    return Objects.equals(item, that.item);
  }

  @Override
  public int hashCode() {
    return Objects.hash(item);
  }

  @Override
  public String toString() {
    return "BulkLookupSuccess{item=" + item + '}';
  }
}
