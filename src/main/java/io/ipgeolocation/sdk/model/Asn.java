package io.ipgeolocation.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * Autonomous System Number block details.
 *
 * <p>This type contains the ASN identifier, organization, registry, country, and related metadata
 * returned for the routed network.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public final class Asn {
  private final String asNumber;
  private final String organization;
  private final String country;
  private final String type;
  private final String domain;
  private final String dateAllocated;
  private final String rir;

  @JsonCreator
  public Asn(
      @JsonProperty("as_number") String asNumber,
      @JsonProperty("organization") String organization,
      @JsonProperty("country") String country,
      @JsonProperty("type") String type,
      @JsonProperty("domain") String domain,
      @JsonProperty("date_allocated") String dateAllocated,
      @JsonProperty("rir") String rir) {
    this.asNumber = asNumber;
    this.organization = organization;
    this.country = country;
    this.type = type;
    this.domain = domain;
    this.dateAllocated = dateAllocated;
    this.rir = rir;
  }

  public String asNumber() {
    return asNumber;
  }

  public String organization() {
    return organization;
  }

  public String country() {
    return country;
  }

  public String type() {
    return type;
  }

  public String domain() {
    return domain;
  }

  public String dateAllocated() {
    return dateAllocated;
  }

  public String rir() {
    return rir;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) {
      return true;
    }
    if (!(other instanceof Asn)) {
      return false;
    }
    Asn that = (Asn) other;
    return Objects.equals(asNumber, that.asNumber)
        && Objects.equals(organization, that.organization)
        && Objects.equals(country, that.country)
        && Objects.equals(type, that.type)
        && Objects.equals(domain, that.domain)
        && Objects.equals(dateAllocated, that.dateAllocated)
        && Objects.equals(rir, that.rir);
  }

  @Override
  public int hashCode() {
    return Objects.hash(asNumber, organization, country, type, domain, dateAllocated, rir);
  }

  @Override
  public String toString() {
    return "Asn{asNumber='"
        + asNumber
        + "', organization='"
        + organization
        + "', country='"
        + country
        + "', type='"
        + type
        + "', domain='"
        + domain
        + "', dateAllocated='"
        + dateAllocated
        + "', rir='"
        + rir
        + "'}";
  }
}
