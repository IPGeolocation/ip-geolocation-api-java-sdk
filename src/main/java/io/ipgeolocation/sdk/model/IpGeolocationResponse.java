package io.ipgeolocation.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Top-level typed response returned by the IP Geolocation API for single lookups and successful
 * bulk-lookup entries.
 *
 * @param ip resolved IP address
 * @param domain reverse-resolved domain, if available
 * @param hostname reverse-resolved hostname, if available
 * @param location location details
 * @param countryMetadata country metadata fields
 * @param network network details
 * @param currency currency details
 * @param asn autonomous system details
 * @param company company details
 * @param security security module details
 * @param abuse abuse module details
 * @param timeZone time-zone details
 * @param userAgent parsed user-agent details
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record IpGeolocationResponse(
    String ip,
    String domain,
    String hostname,
    Location location,
    @JsonProperty("country_metadata") CountryMetadata countryMetadata,
    Network network,
    Currency currency,
    Asn asn,
    Company company,
    Security security,
    Abuse abuse,
    @JsonProperty("time_zone") TimeZoneInfo timeZone,
    @JsonProperty("user_agent") UserAgent userAgent) {}
