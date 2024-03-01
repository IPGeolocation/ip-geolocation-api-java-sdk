package io.ipgeolocation.api;

import java.math.BigDecimal;
import java.util.Objects;
import org.json.JSONObject;

/**
 * The TimezoneGeo class represents geographic information associated with a timezone, including details such as country,
 * state/province, city, latitude, and longitude.
 *
 * <p>The TimezoneGeo class provides methods to access the information about the {@code TimezoneGeo} object. For example,
 * the {@link #getCity()} method returns the city name.
 *
 */
public class TimezoneGeo {
  private final String countryCode2;
  private final String countryCode3;
  private final String countryName;
  private final String stateProvince;
  private final String district;
  private final String city;
  private final String locality;
  private final String location;
  private final String zipCode;
  private final BigDecimal latitude;
  private final BigDecimal longitude;
  private final JSONObject json;

  /**
   * Constructs a TimezoneGeo object based on the provided JSON data.
   *
   * @param json the JSON object containing geographic data
   * @throws IllegalArgumentException if the provided JSON object is null or empty
   */
  TimezoneGeo(JSONObject json) {
    if (Objects.isNull(json)) {
      throw new IllegalArgumentException("'json' must not be null");
    }

    if (json.isEmpty()) {
      throw new IllegalArgumentException("'json' must not be empty");
    }

    this.countryCode2 = json.optString("country_code2");
    this.countryCode3 = json.optString("country_code3");
    this.countryName = json.optString("country_name", json.optString("country"));
    this.stateProvince = json.optString("state_prov", json.optString("state"));
    this.district = json.optString("district");
    this.city = json.getString("city");
    this.locality = json.optString("locality");
    this.location = json.optString("location");
    this.zipCode = json.optString("zipcode");
    this.latitude = json.getBigDecimal("latitude");
    this.longitude = json.getBigDecimal("longitude");
    this.json = json;
  }

  /**
   * Returns the two-letter country code.
   *
   * @return The two-letter country code as String.
   */
  public String getCountryCode2() {
    return countryCode2;
  }

  /**
   * Returns the three-letter country code.
   *
   * @return The three-letter country code as String.
   */
  public String getCountryCode3() {
    return countryCode3;
  }

  /**
   * Returns the name of the country.
   *
   * @return The name of the country as String.
   */
  public String getCountryName() {
    return countryName;
  }

  /**
   * Returns the state or province.
   *
   * @return The state or province or region as String.
   */
  public String getStateProvince() {
    return stateProvince;
  }

  /**
   * Returns the district.
   *
   * @return The district.
   */
  public String getDistrict() {
    return district;
  }

  /**
   * Returns the city.
   *
   * @return The city.
   */
  public String getCity() {
    return city;
  }

  /**
   * Returns the locality.
   *
   * @return The locality.
   */
  public String getLocality() {
    return locality;
  }

  /**
   * Returns the specific location.
   *
   * @return The specific location.
   */
  public String getLocation() {
    return location;
  }

  /**
   * Returns the postal code.
   *
   * @return The postal code as String.
   */
  public String getZipCode() {
    return zipCode;
  }

  /**
   * Returns the latitude coordinate.
   *
   * @return The latitude coordinate as BigDecimal.
   */
  public BigDecimal getLatitude() {
    return latitude;
  }

  /**
   * Returns the longitude coordinate.
   *
   * @return The longitude coordinate as BigDecimal.
   */
  public BigDecimal getLongitude() {
    return longitude;
  }

  /**
   * Returns a string representation of the TimezoneGeo object, in JSON format.
   *
   * @return A JSON string representing the geographic data.
   */
  @Override
  public String toString() {
    return json.toString(2);
  }
}
