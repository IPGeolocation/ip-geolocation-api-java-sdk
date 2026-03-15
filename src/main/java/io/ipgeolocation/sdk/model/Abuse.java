package io.ipgeolocation.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.ipgeolocation.sdk.internal.Compat;
import java.util.List;
import java.util.Objects;

/**
 * Abuse-contact data associated with the resolved IP or network.
 *
 * <p>The fields on this type represent the abuse route, contact identity, organization, address,
 * and reporting channels returned by the API for the resolved network.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public final class Abuse {
  private final String route;
  private final String country;
  private final String name;
  private final String organization;
  private final String kind;
  private final String address;
  private final List<String> emails;
  private final List<String> phoneNumbers;

  @JsonCreator
  public Abuse(
      @JsonProperty("route") String route,
      @JsonProperty("country") String country,
      @JsonProperty("name") String name,
      @JsonProperty("organization") String organization,
      @JsonProperty("kind") String kind,
      @JsonProperty("address") String address,
      @JsonProperty("emails") List<String> emails,
      @JsonProperty("phone_numbers") List<String> phoneNumbers) {
    this.route = route;
    this.country = country;
    this.name = name;
    this.organization = organization;
    this.kind = kind;
    this.address = address;
    this.emails = Compat.immutableList(emails);
    this.phoneNumbers = Compat.immutableList(phoneNumbers);
  }

  public String route() { return route; }
  public String country() { return country; }
  public String name() { return name; }
  public String organization() { return organization; }
  public String kind() { return kind; }
  public String address() { return address; }
  public List<String> emails() { return emails; }
  public List<String> phoneNumbers() { return phoneNumbers; }

  @Override
  public boolean equals(Object other) {
    if (this == other) {
      return true;
    }
    if (!(other instanceof Abuse)) {
      return false;
    }
    Abuse that = (Abuse) other;
    return Objects.equals(route, that.route)
        && Objects.equals(country, that.country)
        && Objects.equals(name, that.name)
        && Objects.equals(organization, that.organization)
        && Objects.equals(kind, that.kind)
        && Objects.equals(address, that.address)
        && Objects.equals(emails, that.emails)
        && Objects.equals(phoneNumbers, that.phoneNumbers);
  }

  @Override
  public int hashCode() {
    return Objects.hash(route, country, name, organization, kind, address, emails, phoneNumbers);
  }

  @Override
  public String toString() {
    return "Abuse{route='"
        + route
        + "', country='"
        + country
        + "', name='"
        + name
        + "', organization='"
        + organization
        + "', kind='"
        + kind
        + "', address='"
        + address
        + "', emails="
        + emails
        + ", phoneNumbers="
        + phoneNumbers
        + '}';
  }
}
