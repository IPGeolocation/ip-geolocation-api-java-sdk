package io.ipgeolocation.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * Top-level typed response returned by the IPGeolocation API for single lookups and successful
 * bulk-lookup entries.
 *
 * <p>The accessors on this type map directly to response sections returned by {@code /v3/ipgeo}
 * and successful items from {@code /v3/ipgeo-bulk}. Depending on plan and requested modules, the
 * response can include:
 *
 * <ul>
 *   <li>resolved IP, domain, and hostname values
 *   <li>location and country metadata
 *   <li>network, currency, ASN, and company details
 *   <li>security and abuse-contact details
 *   <li>time-zone and parsed user-agent details
 * </ul>
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public final class IpGeolocationResponse {
  private final String ip;
  private final String domain;
  private final String hostname;
  private final Location location;
  private final CountryMetadata countryMetadata;
  private final Network network;
  private final Currency currency;
  private final Asn asn;
  private final Company company;
  private final Security security;
  private final Abuse abuse;
  private final TimeZoneInfo timeZone;
  private final UserAgent userAgent;

  @JsonCreator
  public IpGeolocationResponse(
      @JsonProperty("ip") String ip,
      @JsonProperty("domain") String domain,
      @JsonProperty("hostname") String hostname,
      @JsonProperty("location") Location location,
      @JsonProperty("country_metadata") CountryMetadata countryMetadata,
      @JsonProperty("network") Network network,
      @JsonProperty("currency") Currency currency,
      @JsonProperty("asn") Asn asn,
      @JsonProperty("company") Company company,
      @JsonProperty("security") Security security,
      @JsonProperty("abuse") Abuse abuse,
      @JsonProperty("time_zone") TimeZoneInfo timeZone,
      @JsonProperty("user_agent") UserAgent userAgent) {
    this.ip = ip;
    this.domain = domain;
    this.hostname = hostname;
    this.location = location;
    this.countryMetadata = countryMetadata;
    this.network = network;
    this.currency = currency;
    this.asn = asn;
    this.company = company;
    this.security = security;
    this.abuse = abuse;
    this.timeZone = timeZone;
    this.userAgent = userAgent;
  }

  public String ip() { return ip; }
  public String domain() { return domain; }
  public String hostname() { return hostname; }
  public Location location() { return location; }
  public CountryMetadata countryMetadata() { return countryMetadata; }
  public Network network() { return network; }
  public Currency currency() { return currency; }
  public Asn asn() { return asn; }
  public Company company() { return company; }
  public Security security() { return security; }
  public Abuse abuse() { return abuse; }
  public TimeZoneInfo timeZone() { return timeZone; }
  public UserAgent userAgent() { return userAgent; }

  @Override
  public boolean equals(Object other) {
    if (this == other) {
      return true;
    }
    if (!(other instanceof IpGeolocationResponse)) {
      return false;
    }
    IpGeolocationResponse that = (IpGeolocationResponse) other;
    return Objects.equals(ip, that.ip)
        && Objects.equals(domain, that.domain)
        && Objects.equals(hostname, that.hostname)
        && Objects.equals(location, that.location)
        && Objects.equals(countryMetadata, that.countryMetadata)
        && Objects.equals(network, that.network)
        && Objects.equals(currency, that.currency)
        && Objects.equals(asn, that.asn)
        && Objects.equals(company, that.company)
        && Objects.equals(security, that.security)
        && Objects.equals(abuse, that.abuse)
        && Objects.equals(timeZone, that.timeZone)
        && Objects.equals(userAgent, that.userAgent);
  }

  @Override
  public int hashCode() {
    return Objects.hash(ip, domain, hostname, location, countryMetadata, network, currency, asn, company, security, abuse, timeZone, userAgent);
  }

  @Override
  public String toString() {
    return "IpGeolocationResponse{ip='"
        + ip
        + "', domain='"
        + domain
        + "', hostname='"
        + hostname
        + "', location="
        + location
        + ", countryMetadata="
        + countryMetadata
        + ", network="
        + network
        + ", currency="
        + currency
        + ", asn="
        + asn
        + ", company="
        + company
        + ", security="
        + security
        + ", abuse="
        + abuse
        + ", timeZone="
        + timeZone
        + ", userAgent="
        + userAgent
        + '}';
  }
}
