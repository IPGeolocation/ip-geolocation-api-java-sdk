package io.ipgeolocation.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Error payload with message field returned by the API.
 *
 * @param message error message text
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record ErrorResponse(String message) {}
