package io.ipgeolocation.api;

import java.util.Map;

public class TimezoneGeo {
    private final String countryCode2;
    private final String countryCode3;
    private final String countryName;
    private final String stateProvince;
    private final String district;
    private final String city;
    private final String zipCode;
    private final String latitude;
    private final String longitude;

    TimezoneGeo(Map<String, Object> json) {
        this.countryCode2 = (String) json.get("country_code2");
        this.countryCode3 = (String) json.get("country_code3");
        this.countryName = (String) json.get("country_name");
        this.stateProvince = (String) json.get("state_prov");
        this.district = (String) json.get("district");
        this.city = (String) json.get("city");
        this.zipCode = (String) json.get("zipcode");
        this.latitude = Double.toString((Double) json.get("latitude"));
        this.longitude = Double.toString((Double) json.get("longitude"));
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

}
