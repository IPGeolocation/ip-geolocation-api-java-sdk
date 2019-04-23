package io.ipgeolocation.api;

import java.util.Map;

public class TimezoneGeo {
    private String countryCode2;
    private String countryCode3;
    private String countryName;
    private String stateProvince;
    private String district;
    private String city;
    private String zipCode;
    private String latitude;
    private String longitude;

    TimezoneGeo(Map json) {
        this.countryCode2 = (String) json.get("country_code2");
        this.countryCode3 = (String) json.get("country_code3");
        this.countryName = (String) json.get("country_name");
        this.stateProvince = (String) json.get("state_prov");
        this.district = (String) json.get("district");
        this.city = (String) json.get("city");
        this.zipCode = (String) json.get("zipcode");
        this.latitude = (String) json.get("latitude");
        this.longitude = (String) json.get("longitude");
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

    public String getZipCode() {
        return zipCode;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    @Override
    public String toString() {
        return String.format("country_code2: '%s' \ncountry_code3: '%s' \ncountry_name: '%s' \nstate_prov: '%s' \ndistrict: '%s' \ncity: '%s' \nzipcode: '%s' \nlatitude: '%s' \nlongitude: '%s'", countryCode2, countryCode3, countryName, stateProvince, district, city, zipCode, latitude, longitude);
    }
}
