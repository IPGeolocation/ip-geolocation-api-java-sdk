package io.ipgeolocation.api;

import java.util.Objects;
import org.json.JSONObject;

public class GeolocationCurrency {
  private final String name;
  private final String code;
  private final String symbol;
  private final JSONObject json;

  GeolocationCurrency(JSONObject json) {
    if (Objects.isNull(json)) {
      throw new IllegalArgumentException("'json' must not be null");
    }

    if (json.isEmpty()) {
      throw new IllegalArgumentException("'json' must not be empty");
    }

    this.name = json.getString("name");
    this.code = json.getString("code");
    this.symbol = json.getString("symbol");
    this.json = json;
  }

  public String getName() {
    return name;
  }

  public String getCode() {
    return code;
  }

  public String getSymbol() {
    return symbol;
  }

  @Override
  public String toString() {
    return json.toString(2);
  }
}
