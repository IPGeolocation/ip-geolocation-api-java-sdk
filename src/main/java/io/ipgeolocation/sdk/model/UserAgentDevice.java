package io.ipgeolocation.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * Device portion of parsed user-agent data.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public final class UserAgentDevice {
  private final String name;
  private final String type;
  private final String brand;
  private final String cpu;

  @JsonCreator
  public UserAgentDevice(
      @JsonProperty("name") String name,
      @JsonProperty("type") String type,
      @JsonProperty("brand") String brand,
      @JsonProperty("cpu") String cpu) {
    this.name = name;
    this.type = type;
    this.brand = brand;
    this.cpu = cpu;
  }

  public String name() {
    return name;
  }

  public String type() {
    return type;
  }

  public String brand() {
    return brand;
  }

  public String cpu() {
    return cpu;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) {
      return true;
    }
    if (!(other instanceof UserAgentDevice)) {
      return false;
    }
    UserAgentDevice that = (UserAgentDevice) other;
    return Objects.equals(name, that.name)
        && Objects.equals(type, that.type)
        && Objects.equals(brand, that.brand)
        && Objects.equals(cpu, that.cpu);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, type, brand, cpu);
  }

  @Override
  public String toString() {
    return "UserAgentDevice{name='"
        + name
        + "', type='"
        + type
        + "', brand='"
        + brand
        + "', cpu='"
        + cpu
        + "'}";
  }
}
