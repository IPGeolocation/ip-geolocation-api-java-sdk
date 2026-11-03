package io.ipgeolocation.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * Network-level properties for the resolved IP.
 *
 * <p>{@code connectionType} is the network category returned by the API, {@code route} is the
 * routed prefix for the IP, and {@code isAnycast} indicates whether the address is identified as
 * anycast.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public final class Network {
  private final String connectionType;
  private final String route;
  private final Boolean isAnycast;
  private final Boolean isCdn;
  private final String cdnProviderName;

  public Network(
      String connectionType, String route, Boolean isAnycast) {
    this(connectionType, route, isAnycast, null, null);
  }

  @JsonCreator
  public Network(
      @JsonProperty("connection_type") String connectionType,
      @JsonProperty("route") String route,
      @JsonProperty("is_anycast") Boolean isAnycast,
      @JsonProperty("is_cdn") Boolean isCdn,
      @JsonProperty("cdn_provider_name") String cdnProviderName) {
    this.connectionType = connectionType;
    this.route = route;
    this.isAnycast = isAnycast;
    this.isCdn = isCdn;
    this.cdnProviderName = cdnProviderName;
  }

  public String connectionType() { return connectionType; }
  public String route() { return route; }
  public Boolean isAnycast() { return isAnycast; }
  public Boolean isCdn() { return isCdn; }
  public String cdnProviderName() { return cdnProviderName; }

  @Override
  public boolean equals(Object other) {
    if (this == other) {
      return true;
    }
    if (!(other instanceof Network)) {
      return false;
    }
    Network that = (Network) other;
    return Objects.equals(connectionType, that.connectionType)
        && Objects.equals(route, that.route)
        && Objects.equals(isAnycast, that.isAnycast)
        && Objects.equals(isCdn, that.isCdn)
        && Objects.equals(cdnProviderName, that.cdnProviderName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(connectionType, route, isAnycast, isCdn, cdnProviderName);
  }

  @Override
  public String toString() {
    return "Network{connectionType='"
        + connectionType
        + "', route='"
        + route
        + "', isAnycast="
        + isAnycast
        + ", isCdn="
        + isCdn
        + ", cdnProviderName='"
        + cdnProviderName
        + "'}";
  }
}
