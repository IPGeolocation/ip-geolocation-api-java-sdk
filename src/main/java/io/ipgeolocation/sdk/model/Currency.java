package io.ipgeolocation.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * Currency details for the resolved country.
 *
 * <p>The fields on this type correspond to the ISO currency code, display name, and symbol
 * returned for the resolved country.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public final class Currency {
  private final String code;
  private final String name;
  private final String symbol;

  @JsonCreator
  public Currency(
      @JsonProperty("code") String code,
      @JsonProperty("name") String name,
      @JsonProperty("symbol") String symbol) {
    this.code = code;
    this.name = name;
    this.symbol = symbol;
  }

  public String code() {
    return code;
  }

  public String name() {
    return name;
  }

  public String symbol() {
    return symbol;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) {
      return true;
    }
    if (!(other instanceof Currency)) {
      return false;
    }
    Currency that = (Currency) other;
    return Objects.equals(code, that.code)
        && Objects.equals(name, that.name)
        && Objects.equals(symbol, that.symbol);
  }

  @Override
  public int hashCode() {
    return Objects.hash(code, name, symbol);
  }

  @Override
  public String toString() {
    return "Currency{code='" + code + "', name='" + name + "', symbol='" + symbol + "'}";
  }
}
