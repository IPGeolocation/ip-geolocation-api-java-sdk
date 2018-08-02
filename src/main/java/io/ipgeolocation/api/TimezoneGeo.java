package io.ipgeolocation.api;

import java.util.Map;

public class TimezoneGeo {
    private String countryCode2;
    private String countryCode3;
    private String countryName;
    private String stateProvince;
    private String district;
    private String city;
    private String zipcode;
    private String latitude;
    private String longitude;

    TimezoneGeo(Map json) {
        this.countryCode2 = (String) json.get("country_code2");
        this.countryCode3 = (String) json.get("country_code3");
        this.countryName = (String) json.get("country_name");
        this.stateProvince = (String) json.get("state_prov");
        this.district = (String) json.get("district");
        this.city = (String) json.get("city");
        this.zipcode = (String) json.get("zipcode");
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

    public String getZipcode() {
        return zipcode;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }
}
