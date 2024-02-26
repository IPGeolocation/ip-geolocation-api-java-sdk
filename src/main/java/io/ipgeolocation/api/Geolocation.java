package io.ipgeolocation.api;

import java.math.BigDecimal;
import java.util.Objects;
import org.json.JSONObject;

public class Geolocation {
  private final String domain;
  private final String ip;
  private final String hostname;
  private final String continentCode;
  private final String continentName;
  private final String countryCode2;
  private final String countryCode3;
  private final String countryName;
  private final String countryNameOfficial;
  private final String countryCapital;
  private final String stateProvince;
  private final String stateCode;
  private final String district;
  private final String city;
  private final String zipCode;
  private final BigDecimal latitude;
  private final BigDecimal longitude;
  private final boolean eu;
  private final String callingCode;
  private final String countryTLD;
  private final String languages;
  private final String countryFlag;
  private final String isp;
  private final String connectionType;
  private final String organization;
  private final String asn;
  private final long geoNameId;
  private GeolocationCurrency currency;
  private GeolocationTimezone timezone;
  private GeolocationSecurity geolocationSecurity;
  private UserAgent userAgent;
  private final JSONObject json;

  Geolocation(JSONObject json) {
    if (Objects.isNull(json)) {
      throw new IllegalArgumentException("'json' must not be null");
    }

    if (json.isEmpty()) {
      throw new IllegalArgumentException("'json' must not be empty");
    }

    this.domain = json.optString("domain");
    this.ip = json.getString("ip");
    this.hostname = json.optString("hostname");
    this.continentCode = json.optString("continent_code");
    this.continentName = json.optString("continent_name");
    this.countryCode2 = json.optString("country_code2");
    this.countryCode3 = json.optString("country_code3");
    this.countryName = json.optString("country_name");
    this.countryNameOfficial = json.optString("country_name_official");
    this.countryCapital = json.optString("country_capital");
    this.stateProvince = json.optString("state_prov");
    this.stateCode = json.optString("state_code");
    this.district = json.optString("district");
    this.city = json.optString("city");
    this.zipCode = json.optString("zipcode");
    this.latitude = new BigDecimal(json.optString("latitude", "0.0"));
    this.longitude = new BigDecimal(json.optString("longitude", "0.0"));
    this.eu = json.optBoolean("is_eu");
    this.callingCode = json.optString("calling_code");
    this.countryTLD = json.optString("country_tld");
    this.languages = json.optString("languages");
    this.countryFlag = json.optString("country_flag");
    this.isp = json.optString("isp");
    this.connectionType = json.optString("connection_type");
    this.organization = json.optString("organization");
    this.asn = json.optString("asn");
    this.geoNameId = Long.parseLong(json.optString("geoname_id", "0"));

    if (json.has("currency")) {
      this.currency = new GeolocationCurrency(json.getJSONObject("currency"));
    }

    if (json.has("time_zone")) {
      this.timezone = new GeolocationTimezone(json.getJSONObject("time_zone"));
    }

    if (json.has("security")) {
      this.geolocationSecurity = new GeolocationSecurity(json.getJSONObject("security"));
    }

    if (json.has("user_agent")) {
      this.userAgent = new UserAgent(json.getJSONObject("user_agent"));
    }

    this.json = json;
  }

  public String getDomain() {
    return domain;
  }

  public String getIP() {
    return ip;
  }

  public String getHostname() {
    return hostname;
  }

  public String getContinentCode() {
    return continentCode;
  }

  public String getContinentName() {
    return continentName;
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

  public String getCountryNameOfficial() {
    return countryNameOfficial;
  }

  public String getCountryCapital() {
    return countryCapital;
  }

  public String getStateProvince() {
    return stateProvince;
  }

  public String getStateCode() {
    return stateCode;
  }

  public String getDistrict() {
    return district;
  }

  public String getCity() {
    return city;
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

  public boolean isEU() {
    return eu;
  }

  public String getCallingCode() {
    return callingCode;
  }

  public String getCountryTLD() {
    return countryTLD;
  }

  public String getLanguages() {
    return languages;
  }

  public String getCountryFlag() {
    return countryFlag;
  }

  public String getISP() {
    return isp;
  }

  public String getConnectionType() {
    return connectionType;
  }

  public String getOrganization() {
    return organization;
  }

  public String getAsn() {
    return asn;
  }

  public long getGeoNameId() {
    return geoNameId;
  }

  public GeolocationCurrency getCurrency() {
    return currency;
  }

  public GeolocationTimezone getTimezone() {
    return timezone;
  }

  public GeolocationSecurity getGeolocationSecurity() {
    return geolocationSecurity;
  }

  public UserAgent getUserAgent() {
    return userAgent;
  }

  @Override
  public String toString() {
    return json.toString(2);
  }
}
