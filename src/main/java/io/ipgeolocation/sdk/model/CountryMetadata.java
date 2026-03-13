package io.ipgeolocation.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

/**
 * Country-level metadata returned by the API.
 *
 * @param callingCode telephone calling code
 * @param tld top-level domain
 * @param languages list of language codes
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record CountryMetadata(String callingCode, String tld, List<String> languages) {}
