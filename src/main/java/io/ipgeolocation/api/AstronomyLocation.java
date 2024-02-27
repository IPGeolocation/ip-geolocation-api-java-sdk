package io.ipgeolocation.api;

import org.json.JSONObject;

import java.math.BigDecimal;
import java.util.Objects;

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

    public String getLocation() {
        return location;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public String getZipcode() {
        return zipcode;
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

    public String getStateProv() {
        return stateProv;
    }

    public String getStateCode() {
        return stateCode;
    }

    public String getDistrict() {
        return district;
    }

    public String getLocality() {
        return locality;
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return json.toString(2);
    }
}
