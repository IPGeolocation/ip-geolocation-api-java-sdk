package io.ipgeolocation.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Company details associated with the IP address.
 *
 * @param name company name
 * @param type company type/category
 * @param domain company domain
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record Company(String name, String type, String domain) {}
