package io.ipgeolocation.api;

import java.util.Objects;
import org.json.JSONObject;

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

  public String getUserAgentString() {
    return userAgentString;
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

  public UserAgentDevice getDevice() {
    return device;
  }

  public UserAgentEngine getEngine() {
    return engine;
  }

  public UserAgentOperatingSystem getOperatingSystem() {
    return operatingSystem;
  }

  @Override
  public String toString() {
    return json.toString(2);
  }
}
