package io.ipgeolocation.api;

import java.util.Objects;
import org.json.JSONObject;

/**
 * Represents currency information associated with geolocation data.
 */
public class GeolocationCurrency {
  private final String name;
  private final String code;
  private final String symbol;
  private final JSONObject json;

  /**
   * Constructs a new GeolocationCurrency object with the provided JSON data.
   *
   * @param json The JSON object containing currency information.
   * @throws IllegalArgumentException If the provided JSON object is null or empty.
   */
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

  /**
   * Returns the name of the currency (ISO 4217).
   *
   * @return The currency name as a string.
   */
  public String getName() {
    return name;
  }

  /**
   * Returns the currency code (ISO 4217).
   *
   * @return The currency code as a string.
   */
  public String getCode() {
    return code;
  }

  /**
   * Returns the currency symbol.
   *
   * @return The currency symbol as a string.
   */
  public String getSymbol() {
    return symbol;
  }

  /**
   * Returns a JSON representation of the currency data.
   *
   * @return The JSON representation of the currency data as a string.
   */
  @Override
  public String toString() {
    return json.toString(2);
  }
}
