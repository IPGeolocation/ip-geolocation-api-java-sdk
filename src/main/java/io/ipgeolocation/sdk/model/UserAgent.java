package io.ipgeolocation.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * Parsed user-agent summary when user-agent module is requested.
 *
 * <p>{@code name}, {@code type}, {@code version}, and {@code versionMajor} describe the main
 * parsed user-agent result. Nested objects provide device, engine, and operating-system details.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public final class UserAgent {
  private final String userAgentString;
  private final String name;
  private final String type;
  private final String version;
  private final String versionMajor;
  private final UserAgentDevice device;
  private final UserAgentEngine engine;
  private final UserAgentOperatingSystem operatingSystem;

  @JsonCreator
  public UserAgent(
      @JsonProperty("user_agent_string") String userAgentString,
      @JsonProperty("name") String name,
      @JsonProperty("type") String type,
      @JsonProperty("version") String version,
      @JsonProperty("version_major") String versionMajor,
      @JsonProperty("device") UserAgentDevice device,
      @JsonProperty("engine") UserAgentEngine engine,
      @JsonProperty("operating_system") UserAgentOperatingSystem operatingSystem) {
    this.userAgentString = userAgentString;
    this.name = name;
    this.type = type;
    this.version = version;
    this.versionMajor = versionMajor;
    this.device = device;
    this.engine = engine;
    this.operatingSystem = operatingSystem;
  }

  public String userAgentString() { return userAgentString; }
  public String name() { return name; }
  public String type() { return type; }
  public String version() { return version; }
  public String versionMajor() { return versionMajor; }
  public UserAgentDevice device() { return device; }
  public UserAgentEngine engine() { return engine; }
  public UserAgentOperatingSystem operatingSystem() { return operatingSystem; }

  @Override
  public boolean equals(Object other) {
    if (this == other) {
      return true;
    }
    if (!(other instanceof UserAgent)) {
      return false;
    }
    UserAgent that = (UserAgent) other;
    return Objects.equals(userAgentString, that.userAgentString)
        && Objects.equals(name, that.name)
        && Objects.equals(type, that.type)
        && Objects.equals(version, that.version)
        && Objects.equals(versionMajor, that.versionMajor)
        && Objects.equals(device, that.device)
        && Objects.equals(engine, that.engine)
        && Objects.equals(operatingSystem, that.operatingSystem);
  }

  @Override
  public int hashCode() {
    return Objects.hash(userAgentString, name, type, version, versionMajor, device, engine, operatingSystem);
  }

  @Override
  public String toString() {
    return "UserAgent{userAgentString='"
        + userAgentString
        + "', name='"
        + name
        + "', type='"
        + type
        + "', version='"
        + version
        + "', versionMajor='"
        + versionMajor
        + "', device="
        + device
        + ", engine="
        + engine
        + ", operatingSystem="
        + operatingSystem
        + '}';
  }
}
