package io.ipgeolocation.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Currency details for the resolved country.
 *
 * @param code ISO currency code
 * @param name currency name
 * @param symbol currency symbol
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record Currency(String code, String name, String symbol) {}
