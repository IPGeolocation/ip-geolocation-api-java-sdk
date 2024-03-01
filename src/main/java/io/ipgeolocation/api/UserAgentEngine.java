package io.ipgeolocation.api;

import java.util.Objects;
import org.json.JSONObject;

/**
 * Represents information about an engine associated with a user agent.
 * <p>It contains information such as the name, type, version, and major version.
 *
 * <p>The UserAgentEngine class provides methods to access the information stored in
 * UserAgentEngine objects. For example, you can use the {@link #getName()} method to get the name of engine of useragent.
 */
public class UserAgentEngine {
  private final String name;
  private final String type;
  private final String version;
  private final String versionMajor;
  private final JSONObject json;

  /**
   * Constructs a new UserAgentEngine object with the provided JSON data.
   *
   * @param json The JSON object containing engine information.
   * @throws IllegalArgumentException If the provided JSON object is null or empty.
   */
  UserAgentEngine(JSONObject json) {
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
   * Returns the name of the layout engine.
   *
   * @return The name of the engine.
   */
  public String getName() {
    return name;
  }

  /**
   * Returns the class of the layout engine.
   *
   * @return The class of the layout engine.
   */
  public String getType() {
    return type;
  }

  /**
   * Returns the version of the layout engine.
   *
   * @return The version of the layout engine.
   */
  public String getVersion() {
    return version;
  }

  /**
   * Returns the major version of the layout engine.
   *
   * @return The major version of the layout engine.
   */
  public String getVersionMajor() {
    return versionMajor;
  }

  /**
   * Returns a JSON representation of the engine data.
   *
   * @return The JSON representation of the engine data as a string.
   */
  @Override
  public String toString() {
    return json.toString(2);
  }
}
