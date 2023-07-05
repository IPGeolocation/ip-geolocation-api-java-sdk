package io.ipgeolocation.api;

import java.util.Objects;
import org.json.JSONObject;

public class UserAgentOperatingSystem {
  private final String name;
  private final String type;
  private final String version;
  private final String versionMajor;
  private final JSONObject json;

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

  public String getName() {
    return name;
  }

  public String getType() {
    return type;
  }

  public String getVersion() {
    return version;
  }

  public String getVersionMajor() {
    return versionMajor;
  }

  @Override
  public String toString() {
    return json.toString(2);
  }
}
