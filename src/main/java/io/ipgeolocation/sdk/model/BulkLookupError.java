package io.ipgeolocation.sdk.model;

import java.util.Objects;

/**
 * Item-level error in a bulk lookup response array.
 */
public final class BulkLookupError implements BulkLookupResult {
  private final String message;

  public BulkLookupError(String message) {
    this.message = message;
  }

  public String message() {
    return message;
  }

  @Override
  public boolean success() {
    return false;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) {
      return true;
    }
    if (!(other instanceof BulkLookupError)) {
      return false;
    }
    BulkLookupError that = (BulkLookupError) other;
    return Objects.equals(message, that.message);
  }

  @Override
  public int hashCode() {
    return Objects.hash(message);
  }

  @Override
  public String toString() {
    return "BulkLookupError{message='" + message + "'}";
  }
}
