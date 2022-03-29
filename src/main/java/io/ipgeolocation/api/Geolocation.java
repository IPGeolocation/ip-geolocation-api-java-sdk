package io.ipgeolocation.api;

import java.util.HashMap;
import java.util.Map;

import static java.util.Objects.isNull;

public class Geolocation {
  private final String domain;
  private final String ip;
  private final String hostname;
  private final String continentCode;
  private final String continentName;
  private final String countryCode2;
  private final String countryCode3;
  private final String countryName;
  private final String countryCapital;
  private final String stateProvince;
  private final String district;
  private final String city;
  private final String zipCode;
  private final String latitude;
  private final String longitude;
  private final Boolean isEU;
  private final String callingCode;
  private final String countryTLD;
  private final String languages;
  private final String countryFlag;
  private final String isp;
  private final String connectionType;
  private final String organization;
  private final String asn;
  private final String geonameID;
  private GeolocationCurrency currency;
  private GeolocationTimezone timezone;
  private GeolocationSecurity geolocationSecurity;
  private UserAgent userAgent;

  Geolocation(Map<String, Object> json) {
    if (isNull(json)) {
      throw new IllegalArgumentException("'json' must not be null.");
    }

    if (json.isEmpty()) {
      throw new IllegalArgumentException("'json' must not be empty.");
    }

    this.domain = (String) json.get("domain");
    this.ip = (String) json.get("ip");
    this.hostname = (String) json.get("hostname");
    this.continentCode = (String) json.get("continent_code");
    this.continentName = (String) json.get("continent_name");
    this.countryCode2 = (String) json.get("country_code2");
    this.countryCode3 = (String) json.get("country_code3");
    this.countryName = (String) json.get("country_name");
    this.countryCapital = (String) json.get("country_capital");
    this.stateProvince = (String) json.get("state_prov");
    this.district = (String) json.get("district");
    this.city = (String) json.get("city");
    this.zipCode = (String) json.get("zipcode");
    this.latitude = (String) json.get("latitude");
    this.longitude = (String) json.get("longitude");
    this.isEU = (Boolean) json.get("is_eu");
    this.callingCode = (String) json.get("calling_code");
    this.countryTLD = (String) json.get("country_tld");
    this.languages = (String) json.get("languages");
    this.countryFlag = (String) json.get("country_flag");
    this.isp = (String) json.get("isp");
    this.connectionType = (String) json.get("connection_type");
    this.organization = (String) json.get("organization");
    this.asn = (String) json.get("asn");
    this.geonameID = (String) json.get("geoname_id");
    if (json.get("currency") instanceof HashMap) {
      Map<String, Object> currencyJson = (HashMap) json.get("currency");
      this.currency = new GeolocationCurrency(currencyJson);
    }

    if (json.get("time_zone") instanceof HashMap) {
      Map<String, Object> timezoneJson = (HashMap) json.get("time_zone");
      this.timezone = new GeolocationTimezone(timezoneJson);
    }

    if (json.get("security") instanceof HashMap) {
      Map<String, Object> securityJson = (HashMap) json.get("security");
      this.geolocationSecurity = new GeolocationSecurity(securityJson);
    }

    if (json.get("user_agent") instanceof HashMap) {
      Map<String, Object> userAgentJson = (HashMap) json.get("user_agent");
      this.userAgent = new UserAgent(userAgentJson);
    }
  }

  public String getDomain() {
    return domain;
  }

  public String getIPAddress() {
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

  public String getCountryCapital() {
    return countryCapital;
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

  public String getZipCode() {
    return zipCode;
  }

  public String getLatitude() {
    return latitude;
  }

  public String getLongitude() {
    return longitude;
  }

  public Boolean isEU() {
    return isEU;
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

  public String getGeonameID() {
    return geonameID;
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
}
