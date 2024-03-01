package io.ipgeolocation.api;

import java.util.Objects;
import org.json.JSONObject;

/**
 * Represents information about a user agent.
 * <p>It contains information about the user agent string, the name, type, version, version major,
 * device, engine, and operating system.
 *
 * <p>The UserAgent class provides methods to retrieve information about a user agent.
 * For example, you can use the {@link #getOperatingSystem()} method to retrieve the operating system of the user
 */
public class UserAgent {
  private final String userAgentString;
  private final String name;
  private final String type;
  private final String version;
  private final String versionMajor;
  public UserAgentDevice device;
  private UserAgentEngine engine;
  private UserAgentOperatingSystem operatingSystem;
  private final JSONObject json;

  /**
   * Constructs a new UserAgent object with the provided JSON data.
   *
   * @param json The JSON object containing user agent information.
   * @throws IllegalArgumentException If the provided JSON object is null or empty.
   */
  UserAgent(JSONObject json) {
    if (Objects.isNull(json)) {
      throw new IllegalArgumentException("'json' must not be null");
    }

    if (json.isEmpty()) {
      throw new IllegalArgumentException("'json' must not be empty");
    }

    this.userAgentString = json.getString("userAgentString");
    this.name = json.getString("name");
    this.type = json.getString("type");
    this.version = json.getString("version");
    this.versionMajor = json.getString("versionMajor");

    if (json.has("device")) {
      this.device = new UserAgentDevice(json.getJSONObject("device"));
    }

    if (json.has("engine")) {
      this.engine = new UserAgentEngine(json.getJSONObject("engine"));
    }

    if (json.has("operatingSystem")) {
      this.operatingSystem = new UserAgentOperatingSystem(json.getJSONObject("operatingSystem"));
    }

    this.json = json;
  }

  /**
   * Returns the user agent string passed along with the query.
   *
   * @return The user agent string.
   */
  public String getUserAgentString() {
    return userAgentString;
  }

  /**
   * Returns the name of the user agent.
   *
   * @return The name of the user agent.
   */
  public String getName() {
    return name;
  }

  /**
   * Returns the class of the user agent.
   *
   * @return The class of the user agent.
   */
  public String getType() {
    return type;
  }

  /**
   * Returns the version of the user agent.
   *
   * @return The version of the user agent.
   */
  public String getVersion() {
    return version;
  }

  /**
   * Returns the major version of the user agent.
   *
   * @return The major version of the user agent.
   */
  public String getVersionMajor() {
    return versionMajor;
  }

  /**
   * Returns information about the device associated with the user agent.
   *
   * @return Information about the device as {@link UserAgentDevice} object, or null if no device associated with the user agent.
   */
  public UserAgentDevice getDevice() {
    return device;
  }

  /**
   * Returns information about the engine associated with the user agent.
   *
   * @return Information about the engine as {@link UserAgentEngine} object, or null if no engine associated with the user agent.
   */
  public UserAgentEngine getEngine() {
    return engine;
  }

  /**
   * Returns information about the operating system associated with the user agent.
   *
   * @return Information about the operating system as {@link UserAgentOperatingSystem} object, or null if no
   * operating system associated with the user agent.
   */
  public UserAgentOperatingSystem getOperatingSystem() {
    return operatingSystem;
  }

  /**
   * Returns a JSON representation of the user agent data.
   *
   * @return The JSON representation of the user agent data as a string.
   */
  @Override
  public String toString() {
    return json.toString(2);
  }
}
