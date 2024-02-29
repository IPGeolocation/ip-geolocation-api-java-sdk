package io.ipgeolocation.api;

import java.util.Objects;
import org.json.JSONObject;

/**
 * Represents information about a device associated with a user agent.
 * <p>It contains information about the device name, type, brand, and CPU model.
 *
 * <p>The UserAgentDevice class provides methods to access the information about the {@code UserAgentDevice}
 * object. For example,  you can get the name of the device by calling {@link #getName()}.
 *
 */
public class UserAgentDevice {
  private final String name;
  private final String type;
  private final String brand;
  private final String cpu;
  private final JSONObject json;

  /**
   * Constructs a new UserAgentDevice object with the provided JSON data.
   *
   * @param json The JSON object containing device information.
   * @throws IllegalArgumentException If the provided JSON object is null or empty.
   */
  UserAgentDevice(JSONObject json) {
    if (Objects.isNull(json)) {
      throw new IllegalArgumentException("'json' must not be null");
    }

    if (json.isEmpty()) {
      throw new IllegalArgumentException("'json' must not be empty");
    }

    this.name = json.getString("name");
    this.type = json.getString("type");
    this.brand = json.getString("brand");
    this.cpu = json.getString("cpu");
    this.json = json;
  }

  /**
   * Returns the name of the device.
   *
   * @return The name of the device.
   */
  public String getName() {
    return name;
  }

  /**
   * Returns the type of the device.
   *
   * @return The type of the device.
   */
  public String getType() {
    return type;
  }

  /**
   * Returns the brand of the device.
   *
   * @return The brand of the device.
   */
  public String getBrand() {
    return brand;
  }

  /**
   * Returns the CPU Model of the device.
   *
   * @return The CPU Model of the device.
   */
  public String getCpu() {
    return cpu;
  }

  /**
   * Returns a JSON representation of the device data.
   *
   * @return The JSON representation of the device data as a string.
   */
  @Override
  public String toString() {
    return json.toString(2);
  }
}
