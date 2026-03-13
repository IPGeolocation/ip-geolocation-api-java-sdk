package io.ipgeolocation.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Parsed user-agent summary when user-agent module is requested.
 *
 * @param userAgentString original user-agent string
 * @param name parsed user-agent name
 * @param type parsed user-agent type
 * @param version parsed full version
 * @param versionMajor parsed major version
 * @param device parsed device details
 * @param engine parsed engine details
 * @param operatingSystem parsed operating-system details
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record UserAgent(
    String userAgentString,
    String name,
    String type,
    String version,
    String versionMajor,
    UserAgentDevice device,
    UserAgentEngine engine,
    UserAgentOperatingSystem operatingSystem) {}
