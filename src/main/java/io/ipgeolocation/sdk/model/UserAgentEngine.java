package io.ipgeolocation.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * Engine portion of parsed user-agent data.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public final class UserAgentEngine {
  private final String name;
  private final String type;
  private final String version;
  private final String versionMajor;

  @JsonCreator
  public UserAgentEngine(
      @JsonProperty("name") String name,
      @JsonProperty("type") String type,
      @JsonProperty("version") String version,
      @JsonProperty("version_major") String versionMajor) {
    this.name = name;
    this.type = type;
    this.version = version;
    this.versionMajor = versionMajor;
  }

  public String name() {
    return name;
  }

  public String type() {
    return type;
  }

  public String version() {
    return version;
  }

  public String versionMajor() {
    return versionMajor;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) {
      return true;
    }
    if (!(other instanceof UserAgentEngine)) {
      return false;
    }
    UserAgentEngine that = (UserAgentEngine) other;
    return Objects.equals(name, that.name)
        && Objects.equals(type, that.type)
        && Objects.equals(version, that.version)
        && Objects.equals(versionMajor, that.versionMajor);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, type, version, versionMajor);
  }

  @Override
  public String toString() {
    return "UserAgentEngine{name='"
        + name
        + "', type='"
        + type
        + "', version='"
        + version
        + "', versionMajor='"
        + versionMajor
        + "'}";
  }
}
