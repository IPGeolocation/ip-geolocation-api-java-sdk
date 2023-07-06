package io.ipgeolocation.api;

import io.ipgeolocation.api.exceptions.IPGeolocationError;
import java.math.BigDecimal;

public class TimezoneParams {
  private final String timeZone;
  private final String ipAddress;
  private final BigDecimal latitude;
  private final BigDecimal longitude;
  private final String location;
  private final String lang;

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

  public String getTimeZone() {
    return timeZone;
  }

  public String getIPAddress() {
    return ipAddress;
  }

  public BigDecimal getLatitude() {
    return latitude;
  }

  public BigDecimal getLongitude() {
    return longitude;
  }

  public String getLocation() {
    return location;
  }

  public String getLang() {
    return lang;
  }

  public static TimezoneParamsBuilder builder() {
    return new TimezoneParamsBuilder();
  }

  public static class TimezoneParamsBuilder {
    private String timeZone;
    private String ipAddress;
    private BigDecimal latitude;
    private BigDecimal longitude;
    private String location;
    private String lang;

    private TimezoneParamsBuilder() {
      timeZone = "";
      ipAddress = "";
      latitude = null;
      longitude = null;
      location = "";
      lang = "en";
    }

    public TimezoneParamsBuilder withTimeZone(String timeZone) {
      this.timeZone = timeZone;
      return this;
    }

    public TimezoneParamsBuilder withIPAddress(String ipAddress) {
      this.ipAddress = ipAddress;
      return this;
    }

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

    public TimezoneParamsBuilder withLocation(String location) {
      this.location = location;
      return this;
    }

    public TimezoneParamsBuilder withLang(String lang) {
      this.lang = lang;
      return this;
    }

    public TimezoneParams build() {
      return new TimezoneParams(timeZone, ipAddress, latitude, longitude, location, lang);
    }
  }
}
