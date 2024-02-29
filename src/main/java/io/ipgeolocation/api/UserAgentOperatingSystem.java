package io.ipgeolocation.api;

import java.util.Objects;
import org.json.JSONObject;

/**
 * Represents information about an operating system associated with a user agent.
 * <p>It contains information about the name, type, version, and major version of the operating system of user agent.
 *
 * <p>The UserAgentOperatingSystem class provides methods to access the information stored in the
 * UserAgentOperatingSystem object. For example, you can get the version of the Operating System of the user agent
 * by calling {@link #getVersion()}.
 */
public class UserAgentOperatingSystem {
  private final String name;
  private final String type;
  private final String version;
  private final String versionMajor;
  private final JSONObject json;

  /**
   * Constructs a new UserAgentOperatingSystem object with the provided JSON data.
   *
   * @param json The JSON object containing operating system information.
   * @throws IllegalArgumentException If the provided JSON object is null or empty.
   */
  UserAgentOperatingSystem(JSONObject json) {
    if (Objects.isNull(json)) {
      throw new IllegalArgumentException("'json' must not be null");
    }

    if (json.isEmpty()) {
      throw new IllegalArgumentException("'json' must not be empty");
    }

    this.name = json.getString("name");
    this.type = json.getString("type");
    this.version = json.getString("version");
    this.versionMajor = json.getString("versionMajor");
    this.json = json;
  }

  /**
   * Returns the name of the operating system.
   *
   * @return The name of the operating system.
   */
  public String getName() {
    return name;
  }

  /**
   * Returns the class of the operating system.
   *
   * @return The class of the operating system.
   */
  public String getType() {
    return type;
  }

  /**
   * Returns the version of the operating system.
   *
   * @return The version of the operating system.
   */
  public String getVersion() {
    return version;
  }

  /**
   * Returns the major version of the operating system.
   *
   * @return The major version of the operating system.
   */
  public String getVersionMajor() {
    return versionMajor;
  }

  /**
   * Returns a JSON representation of the operating system data.
   *
   * @return The JSON representation of the operating system data as a string.
   */
  @Override
  public String toString() {
    return json.toString(2);
  }
}
