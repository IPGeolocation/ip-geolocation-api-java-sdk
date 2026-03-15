package io.ipgeolocation.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * Operating-system portion of parsed user-agent data.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public final class UserAgentOperatingSystem {
  private final String name;
  private final String type;
  private final String version;
  private final String versionMajor;
  private final String build;

  @JsonCreator
  public UserAgentOperatingSystem(
      @JsonProperty("name") String name,
      @JsonProperty("type") String type,
      @JsonProperty("version") String version,
      @JsonProperty("version_major") String versionMajor,
      @JsonProperty("build") String build) {
    this.name = name;
    this.type = type;
    this.version = version;
    this.versionMajor = versionMajor;
    this.build = build;
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

  public String build() {
    return build;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) {
      return true;
    }
    if (!(other instanceof UserAgentOperatingSystem)) {
      return false;
    }
    UserAgentOperatingSystem that = (UserAgentOperatingSystem) other;
    return Objects.equals(name, that.name)
        && Objects.equals(type, that.type)
        && Objects.equals(version, that.version)
        && Objects.equals(versionMajor, that.versionMajor)
        && Objects.equals(build, that.build);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, type, version, versionMajor, build);
  }

  @Override
  public String toString() {
    return "UserAgentOperatingSystem{name='"
        + name
        + "', type='"
        + type
        + "', version='"
        + version
        + "', versionMajor='"
        + versionMajor
        + "', build='"
        + build
        + "'}";
  }
}
