package io.ipgeolocation.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Autonomous System Number block details.
 *
 * @param asNumber ASN identifier
 * @param organization ASN organization name
 * @param country ASN registration country
 * @param type ASN type
 * @param domain ASN domain
 * @param dateAllocated ASN allocation date
 * @param rir regional internet registry
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record Asn(
    String asNumber,
    String organization,
    String country,
    String type,
    String domain,
    String dateAllocated,
    String rir) {}
