package io.ipgeolocation.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Network-level properties for the resolved IP.
 *
 * @param connectionType connection type classification
 * @param route routed prefix for the IP
 * @param isAnycast true when IP is anycast
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record Network(
    String connectionType,
    String route,
    @JsonProperty("is_anycast") Boolean isAnycast) {}
