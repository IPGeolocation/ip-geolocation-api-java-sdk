package io.ipgeolocation.api;

import org.json.JSONObject;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * The AstronomyLocation class represents geographic location data associated with astronomical information,
 * including latitude, longitude, country, state/province, city, and other details.
 *
 * <p>The AstronomyLocation class provides methods to access the information about the {@code AstronomyLocation} object.
 * For example, you can get the city name using the {@link AstronomyLocation#getCity()} method.
 *
 */
public class AstronomyLocation {
    private final String location;
    private final BigDecimal latitude;
    private final BigDecimal longitude;
    private final String zipcode;
    private final String countryCode2;
    private final String countryCode3;
    private final String countryName;
    private final String countryNameOfficial;
    private final String stateProv;
    private final String stateCode;
    private final String district;
    private final String locality;
    private final String city;
    private final JSONObject json;

    /**
     * Constructs an AstronomyLocation object based on the provided JSON data.
     *
     * @param json the JSON object containing location data
     * @throws IllegalArgumentException if the provided JSON object is null or empty
     */
    AstronomyLocation(JSONObject json) {
        if (Objects.isNull(json)) {
            throw new IllegalArgumentException("'json' must not be null");
        }

        if (json.isEmpty()) {
            throw new IllegalArgumentException("'json' must not be empty");
        }

        this.location = json.optString("location");
        this.countryCode2 = json.optString("country_code2");
        this.countryCode3 = json.optString("country_code3");
        this.countryNameOfficial = json.optString("country_name_official");
        this.countryName = json.optString("country_name", json.optString("country"));
        this.stateProv = json.optString("state_prov", json.optString("state"));
        this.stateCode = json.optString("state_code");
        this.latitude = json.getBigDecimal("latitude");
        this.longitude = json.getBigDecimal("longitude");
        this.zipcode = json.optString("zipcode");
        this.district = json.optString("district");
        this.locality = json.optString("locality");
        this.city = json.optString("city");
        this.json = json;
    }

    /**
     * Returns the location name (i.e., city, country) for which astronomy information queried.
     *
     * @return The location name as String.
     */
    public String getLocation() {
        return location;
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
     * Returns the postal code/Zip code.
     *
     * @return The postal code/Zip code as String.
     */
    public String getZipcode() {
        return zipcode;
    }

    /**
     * Returns the ISO 3166-1 alpha-2 country code. e.g., 'PK' for Pakistan.
     *
     * @return The ISO 3166-1 alpha-2 country code as String.
     */
    public String getCountryCode2() {
        return countryCode2;
    }

    /**
     * Returns the ISO 3166-1 alpha-3 country code. e.g., 'PAK' for Pakistan.
     *
     * @return The ISO 3166-1 alpha-3 country code as String.
     */
    public String getCountryCode3() {
        return countryCode3;
    }

    /**
     * Returns the general country name.
     *
     * @return The country name as String.
     */
    public String getCountryName() {
        return countryName;
    }

    /**
     * Returns the official country name.
     *
     * @return The official country name as String.
     */
    public String getCountryNameOfficial() {
        return countryNameOfficial;
    }

    /**
     * Returns the state or province or region name.
     *
     * @return The state or province name as String.
     */
    public String getStateProv() {
        return stateProv;
    }

    /**
     * Returns the state or province code. e.g., 'PK-PB'
     *
     * @return The state or province code as String.
     */
    public String getStateCode() {
        return stateCode;
    }

    /**
     * Returns the district name.
     *
     * @return The district name.
     */
    public String getDistrict() {
        return district;
    }

    /**
     * Returns the locality.
     *
     * @return The locality as String.
     */
    public String getLocality() {
        return locality;
    }

    /**
     * Returns the city.
     *
     * @return The city as String.
     */
    public String getCity() {
        return city;
    }

    /**
     * Returns a string representation of the {@code AstronomyLocation} object, in JSON format.
     *
     * @return A JSON string representing the location data.
     */
    @Override
    public String toString() {
        return json.toString(2);
    }
}
