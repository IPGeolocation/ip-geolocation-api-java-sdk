package io.ipgeolocation.api;

import java.math.BigDecimal;
import java.util.Map;

public class TimezoneGeo {
    private final String countryCode2;
    private final String countryCode3;
    private final String countryName;
    private final String stateProvince;
    private final String district;
    private final String city;
    private final String zipCode;
    private BigDecimal latitude;
    private BigDecimal longitude;

    TimezoneGeo(Map<String, Object> json) {
        this.countryCode2 = (String) json.get("country_code2");
        this.countryCode3 = (String) json.get("country_code3");
        this.countryName = (String) json.get("country_name");
        this.stateProvince = (String) json.get("state_prov");
        this.district = (String) json.get("district");
        this.city = (String) json.get("city");
        this.zipCode = (String) json.get("zipcode");

        if (json.get("latitude") instanceof String) {
            this.latitude = new BigDecimal((String) json.get("latitude"));
        } else if (json.get("latitude") instanceof BigDecimal) {
            this.latitude = (BigDecimal) json.get("latitude");
        }

        if (json.get("longitude") instanceof String) {
            this.longitude = new BigDecimal((String) json.get("longitude"));
        } else if (json.get("longitude") instanceof BigDecimal) {
            this.longitude = (BigDecimal) json.get("longitude");
        }
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

    public BigDecimal getLatitude() {
        return latitude;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

}
