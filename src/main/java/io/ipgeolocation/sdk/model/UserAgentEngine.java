package io.ipgeolocation.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Engine portion of parsed user-agent data.
 *
 * @param name engine name
 * @param type engine type
 * @param version engine version
 * @param versionMajor engine major version
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record UserAgentEngine(String name, String type, String version, String versionMajor) {}
