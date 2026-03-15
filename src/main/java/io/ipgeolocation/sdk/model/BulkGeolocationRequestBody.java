package io.ipgeolocation.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.ipgeolocation.sdk.internal.Compat;
import java.util.List;
import java.util.Objects;

/**
 * Wire body sent to the bulk lookup endpoint.
 */
public final class BulkGeolocationRequestBody {
  private final List<String> ips;

  @JsonCreator
  public BulkGeolocationRequestBody(@JsonProperty("ips") List<String> ips) {
    this.ips = Compat.immutableList(ips);
  }

  public List<String> ips() {
    return ips;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) {
      return true;
    }
    if (!(other instanceof BulkGeolocationRequestBody)) {
      return false;
    }
    BulkGeolocationRequestBody that = (BulkGeolocationRequestBody) other;
    return Objects.equals(ips, that.ips);
  }

  @Override
  public int hashCode() {
    return Objects.hash(ips);
  }

  @Override
  public String toString() {
    return "BulkGeolocationRequestBody{ips=" + ips + '}';
  }
}
