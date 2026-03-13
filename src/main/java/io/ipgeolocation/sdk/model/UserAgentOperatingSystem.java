package io.ipgeolocation.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Operating-system portion of parsed user-agent data.
 *
 * @param name operating-system name
 * @param type operating-system type
 * @param version operating-system version
 * @param versionMajor operating-system major version
 * @param build operating-system build string
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record UserAgentOperatingSystem(
    String name, String type, String version, String versionMajor, String build) {}
