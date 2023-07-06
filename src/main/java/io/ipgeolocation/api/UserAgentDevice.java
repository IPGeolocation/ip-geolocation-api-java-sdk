package io.ipgeolocation.api;

import java.util.Objects;
import org.json.JSONObject;

public class UserAgentDevice {
  private final String name;
  private final String type;
  private final String brand;
  private final String cpu;
  private final JSONObject json;

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

  public String getName() {
    return name;
  }

  public String getType() {
    return type;
  }

  public String getBrand() {
    return brand;
  }

  public String getCpu() {
    return cpu;
  }

  @Override
  public String toString() {
    return json.toString(2);
  }
}
