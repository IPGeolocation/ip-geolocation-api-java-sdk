package io.ipgeolocation.api;

import java.math.BigDecimal;
import java.util.Objects;
import org.json.JSONObject;

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

  public String getCountryCode2() {
    return countryCode2;
  }

  public String getCountryCode3() {
    return countryCode3;
  }

  public String getCountryName() {
    return countryName;
  }

  public String getStateProvince() {
    return stateProvince;
  }

  public String getDistrict() {
    return district;
  }

  public String getCity() {
    return city;
  }

  public String getLocality() {
    return locality;
  }

  public String getLocation() {
    return location;
  }

  public String getZipCode() {
    return zipCode;
  }

  public BigDecimal getLatitude() {
    return latitude;
  }

  public BigDecimal getLongitude() {
    return longitude;
  }

  @Override
  public String toString() {
    return json.toString(2);
  }
}
