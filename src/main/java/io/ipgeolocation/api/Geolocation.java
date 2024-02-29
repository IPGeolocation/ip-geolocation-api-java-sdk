package io.ipgeolocation.api;

import java.math.BigDecimal;
import java.util.Objects;
import org.json.JSONObject;

/**
 * Represents geolocation information for an IP address.
 * <p>It contains information such as the IP address, country, city, etc.
 *
 * <p>The Geolocation class provides methods to access the information stored in the Geolocation
 * object. For example, you can get the country name using the {@link #getCountryName()}
 */
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

  /**
   * Constructs a new Geolocation object with the provided JSON data.
   *
   * @param json The JSON object containing geolocation information.
   * @throws IllegalArgumentException If the provided JSON object is null or empty.
   */
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

  /**
   * Returns the domain name that is used to lookup geolocation information. It would be empty string, if an IP address
   * is used to query IP Geolocation API.
   *
   * @return The domain as a string.
   */
  public String getDomain() {
    return domain;
  }

  /**
   * Returns the IP address/domain name that is used to lookup geolocation information.
   *
   * @return The IP address/domain as a string.
   */
  public String getIP() {
    return ip;
  }

  /**
   * Returns the hostname of the IP address used to query IP Geolocation API.
   *
   * @return The hostname as a string.
   */
  public String getHostname() {
    return hostname;
  }

  /**
   * Returns the 2-letter code of the continent.
   *
   * @return The continent code as a string.
   */
  public String getContinentCode() {
    return continentCode;
  }

  /**
   * Returns the continent name.
   *
   * @return The continent name as a string.
   */
  public String getContinentName() {
    return continentName;
  }

  /**
   * Returns the two-letter country code (ISO 3166-1 alpha-2) of the country.
   *
   * @return The two-letter country code as a string.
   */
  public String getCountryCode2() {
    return countryCode2;
  }

  /**
   * Returns the three-letter country code (ISO 3166-1 alpha-3) of the country.
   *
   * @return The three-letter country code as a string.
   */
  public String getCountryCode3() {
    return countryCode3;
  }

  /**
   * Returns the common name of the country.
   *
   * @return The country name as a string.
   */
  public String getCountryName() {
    return countryName;
  }

  /**
   * Returns the official name of the country.
   *
   * @return The official country name as a string.
   */
  public String getCountryNameOfficial() {
    return countryNameOfficial;
  }

  /**
   * Returns the capital city of the country.
   *
   * @return The capital city name as a string.
   */
  public String getCountryCapital() {
    return countryCapital;
  }

  /**
   * Returns the state or province or region name.
   *
   * @return The state or province or region name as a string.
   */
  public String getStateProvince() {
    return stateProvince;
  }

  /**
   * Returns the state or province code.
   *
   * @return The state or province code as a string.
   */
  public String getStateCode() {
    return stateCode;
  }

  /**
   * Returns the district name or county name.
   *
   * @return The district name or county name as a string.
   */
  public String getDistrict() {
    return district;
  }

  /**
   * Returns the city name.
   *
   * @return The city name as a string.
   */
  public String getCity() {
    return city;
  }

  /**
   * Returns the ZIP or postal code of the place.
   *
   * @return The ZIP or postal code as a string.
   */
  public String getZipCode() {
    return zipCode;
  }

  /**
   * Returns the latitude coordinate of the place.
   *
   * @return The latitude coordinate as a BigDecimal.
   */
  public BigDecimal getLatitude() {
    return latitude;
  }

  /**
   * Returns the longitude coordinate of the place.
   *
   * @return The longitude coordinate as a BigDecimal.
   */
  public BigDecimal getLongitude() {
    return longitude;
  }

  /**
   * Indicates if the country is part of the European Union.
   *
   * @return {@code true} if the country is part of the EU, {@code false} otherwise.
   */
  public boolean isEU() {
    return eu;
  }

  /**
   * Returns the calling code associated with the country.
   *
   * @return The calling code as a string.
   */
  public String getCallingCode() {
    return callingCode;
  }

  /**
   * Returns the top-level domain associated with the country.
   *
   * @return The top-level domain as a string.
   */
  public String getCountryTLD() {
    return countryTLD;
  }

  /**
   * Returns comma-separated list of the languages’ codes, spoken in the country.
   *
   * @return The languages' codes, spoken in the country as a comma-separated list of string.
   */
  public String getLanguages() {
    return languages;
  }

  /**
   * Returns the URL of the country's flag.
   *
   * @return The URL of the country's flag as a string.
   */
  public String getCountryFlag() {
    return countryFlag;
  }

  /**
   * Returns the name Internet Service Provider (ISP) holding the IP address.
   *
   * @return The ISP name as a string.
   */
  public String getISP() {
    return isp;
  }

  /**
   * Returns the connection type consuming the IP address. It can be an empty string.
   *
   * @return The connection type as a string.
   */
  public String getConnectionType() {
    return connectionType;
  }

  /**
   * Returns the name of AS organization holding the IP address.
   *
   * @return The organization name as a string.
   */
  public String getOrganization() {
    return organization;
  }

  /**
   * Returns the Autonomous System Number (ASN) of the autonomous system, associated with the IP address.
   * It can be an empty string.
   *
   * @return The ASN as a string.
   */
  public String getAsn() {
    return asn;
  }

  /**
   * Returns the GeoName ID of the place from <a href="https://www.geonames.org">geonames.org</a>.
   *
   * @return The GeoName ID as a long.
   */
  public long getGeoNameId() {
    return geoNameId;
  }

  /**
   * Returns the currency information associated with the country.
   *
   * @return The currency information as a {@link GeolocationCurrency} object, or null if not available.
   */
  public GeolocationCurrency getCurrency() {
    return currency;
  }

  /**
   * Returns the timezone information associated with the IP address.
   *
   * @return The timezone information as a {@link GeolocationTimezone} object, or null if not available.
   */
  public GeolocationTimezone getTimezone() {
    return timezone;
  }

  /**
   * Returns the security information associated with the IP address.
   *
   * @return The security information as a {@link GeolocationSecurity} object, or null if not available.
   */
  public GeolocationSecurity getGeolocationSecurity() {
    return geolocationSecurity;
  }

  /**
   * Returns the user agent information associated with the IP address.
   *
   * @return The user agent information as a {@link UserAgent} object, or null if not available.
   */
  public UserAgent getUserAgent() {
    return userAgent;
  }

  /**
   * Returns a JSON representation of the geolocation data.
   *
   * @return The JSON representation of the geolocation data as a string.
   */
  @Override
  public String toString() {
    return json.toString(2);
  }
}
