package io.ipgeolocation.api;

import io.ipgeolocation.api.exceptions.IPGeolocationError;
import java.math.BigDecimal;

/**
 * The {@code TimezoneParams} class represents parameters used for querying timezone information
 * from the IP Geolocation API.
 * <p>
 * The class provides methods for setting the IP Address, language, and location parameters, as
 * well as getting the corresponding values.</p>
 * <p>
 * It also includes a builder pattern to facilitate the construction of {@code TimezoneParams} objects
 * with various parameters.
 * </p>
 *
 * <p>The class is immutable and thread-safe.
 *
 * <p>
 * Example usage:
 * <pre>{@code
 * TimezoneParams params = TimezoneParams.builder()
 *     .withIPAddress("1.1.1.1")
 *     .withLang("fr")
 *     .build();}
 * </p>
 */
public class TimezoneParams {
  private final String timeZone;
  private final String ipAddress;
  private final BigDecimal latitude;
  private final BigDecimal longitude;
  private final String location;
  private final String lang;

  /**
   * Constructs a new {@code TimezoneParams} object with the specified parameters.
   *
   * @param timeZone   The time zone ID.
   * @param ipAddress  The IP address.
   * @param latitude   The latitude coordinate.
   * @param longitude  The longitude coordinate.
   * @param location   The location name.
   * @param lang       The language preference.
   */
  private TimezoneParams(
      String timeZone,
      String ipAddress,
      BigDecimal latitude,
      BigDecimal longitude,
      String location,
      String lang) {
    this.timeZone = timeZone;
    this.ipAddress = ipAddress;
    this.latitude = latitude;
    this.longitude = longitude;
    this.location = location;
    this.lang = lang;
  }

  /**
   * Returns the time zone ID.
   *
   * @return The time zone ID as String.
   */
  public String getTimeZone() {
    return timeZone;
  }

  /**
   * Returns the IP address.
   *
   * @return The IP address as String.
   */
  public String getIPAddress() {
    return ipAddress;
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
   * Returns the location name or street address.
   *
   * @return The location name or street address.
   */
  public String getLocation() {
    return location;
  }

  /**
   * Returns the language preference.
   *
   * @return The language preference.
   */
  public String getLang() {
    return lang;
  }

  /**
   * Returns a new {@code TimezoneParamsBuilder} instance to facilitate the construction
   * of {@code TimezoneParams} objects with various parameters.
   *
   * @return A {@code TimezoneParamsBuilder} instance.
   */
  public static TimezoneParamsBuilder builder() {
    return new TimezoneParamsBuilder();
  }

  /**
   * The {@code TimezoneParamsBuilder} class is a builder pattern for constructing {@code TimezoneParams}
   * objects with various parameters.
   */
  public static class TimezoneParamsBuilder {
    private String timeZone;
    private String ipAddress;
    private BigDecimal latitude;
    private BigDecimal longitude;
    private String location;
    private String lang;

    /**
     * Constructs a new {@code TimezoneParamsBuilder} with default values for optional parameters.
     */
    private TimezoneParamsBuilder() {
      timeZone = "";
      ipAddress = "";
      latitude = null;
      longitude = null;
      location = "";
      lang = "en";
    }

    /**
     * Sets the time zone ID to query timezone information.
     *
     * @param timeZone The time zone ID.
     * @return This {@code TimezoneParamsBuilder} instance for method chaining.
     */
    public TimezoneParamsBuilder withTimeZone(String timeZone) {
      this.timeZone = timeZone;
      return this;
    }

    /**
     * Sets the IP address to query timezone information.
     *
     * @param ipAddress The IP address.
     * @return This {@code TimezoneParamsBuilder} instance for method chaining.
     */
    public TimezoneParamsBuilder withIPAddress(String ipAddress) {
      this.ipAddress = ipAddress;
      return this;
    }

    /**
     * Sets the latitude and longitude coordinates to query timezone information.
     *
     * @param latitude  The latitude coordinate.
     * @param longitude The longitude coordinate.
     * @return This {@code TimezoneParamsBuilder} instance for method chaining.
     * @throws IPGeolocationError If the latitude or longitude values are out of range.
     */
    public TimezoneParamsBuilder withCoordinates(BigDecimal latitude, BigDecimal longitude) {
      if (latitude.compareTo(BigDecimal.valueOf(-90.0)) < 0
          || latitude.compareTo(BigDecimal.valueOf(90.0)) > 0) {
        throw new IPGeolocationError("'latitude' must be between -90.0 and 90.0");
      }

      if (longitude.compareTo(BigDecimal.valueOf(-180.0)) < 0
          || longitude.compareTo(BigDecimal.valueOf(180.0)) > 0) {
        throw new IPGeolocationError("'longitude' must be between -180.0 and 180.0");
      }

      this.latitude = latitude;
      this.longitude = longitude;
      return this;
    }

    /**
     * Sets the location / street address to query timezone information.
     *
     * @param location The location name.
     * @return This {@code TimezoneParamsBuilder} instance for method chaining.
     */
    public TimezoneParamsBuilder withLocation(String location) {
      this.location = location;
      return this;
    }

    /**
     * Sets the language preference.
     *
     * @param lang The language preference.
     * @return This {@code TimezoneParamsBuilder} instance for method chaining.
     */
    public TimezoneParamsBuilder withLang(String lang) {
      this.lang = lang;
      return this;
    }

    /**
     * Builds a new {@code TimezoneParams} object with the configured parameters.
     *
     * @return A new {@code TimezoneParams} object.
     */
    public TimezoneParams build() {
      return new TimezoneParams(timeZone, ipAddress, latitude, longitude, location, lang);
    }
  }
}
