package io.ipgeolocation.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Device portion of parsed user-agent data.
 *
 * @param name device name
 * @param type device type
 * @param brand device brand
 * @param cpu device CPU architecture
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record UserAgentDevice(String name, String type, String brand, String cpu) {}
