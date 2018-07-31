package io.ipgeolocation.api;

import com.google.gson.internal.LinkedTreeMap;

import java.util.Map;

public class Geolocation {
    private Integer status;
    private String message;
    private String ip;
    private String continentCode;
    private String continentName;
    private String countryCode2;
    private String countryCode3;
    private String countryName;
    private String countryCapital;
    private String stateProvince;
    private String city;
    private String zipcode;
    private String latitude;
    private String longitude;
    private Boolean isEu;
    private String callingCode;
    private String countryTld;
    private String languages;
    private String countryFlag;
    private String isp;
    private String connectionType;
    private String organization;
    private String geonameId;
    private GeolocationCurrency currency;
    private GeolocationTimezone timezone;

    Geolocation(Map<String, Object> json) {
        if(!json.get("status").equals("200")) {
            this.message = (String) json.get("message");
        } else {
            this.ip = (String) json.get("ip");
            this.continentCode = (String) json.get("continent_code");
            this.continentName = (String) json.get("continent_name");
            this.countryCode2 = (String) json.get("country_code2");
            this.countryCode3 = (String) json.get("country_code3");
            this.countryName = (String) json.get("country_name");
            this.countryCapital = (String) json.get("country_capital");
            this.stateProvince = (String) json.get("state_province");
            this.city = (String) json.get("city");
            this.zipcode = (String) json.get("zipcode");
            this.latitude = (String) json.get("latitude");
            this.longitude = (String) json.get("longitude");
            this.isEu = (Boolean) json.get("is_eu");
            this.callingCode = (String) json.get("calling_code");
            this.countryTld = (String) json.get("country_tld");
            this.languages = (String) json.get("languages");
            this.countryFlag = (String) json.get("country_flag");
            this.isp = (String) json.get("isp");
            this.connectionType = (String) json.get("connection_type");
            this.organization = (String) json.get("organization");
            this.geonameId = (String) json.get("geoname_id");
            if(json.get("currency") instanceof LinkedTreeMap) {
                Map currencyJson = (LinkedTreeMap) json.get("currency");
                this.currency = new GeolocationCurrency((String) currencyJson.get("name"), (String) currencyJson.get("code"));
            }
            if(json.get("time_zone") instanceof LinkedTreeMap) {
                Map timezoneJson = (LinkedTreeMap) json.get("time_zone");
                this.timezone = new GeolocationTimezone((String) timezoneJson.get("name"), (Double) timezoneJson.get("offset"), (String) timezoneJson.get("current_time"), (Boolean) timezoneJson.get("is_dst"), (Double) timezoneJson.get("dst_savings"));
            }
        }
        this.status = Integer.parseInt((String) json.get("status"));
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public String getIp() {
        return ip;
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

    public Boolean isEu() {
        return isEu;
    }

    public String getCallingCode() {
        return callingCode;
    }

    public String getCountryTld() {
        return countryTld;
    }

    public String getLanguages() {
        return languages;
    }

    public String getCountryFlag() {
        return countryFlag;
    }

    public String getIsp() {
        return isp;
    }

    public String getConnectionType() {
        return connectionType;
    }

    public String getOrganization() {
        return organization;
    }

    public String getGeonameId() {
        return geonameId;
    }

    public GeolocationCurrency getCurrency() {
        return currency;
    }

    public GeolocationTimezone getTimezone() {
        return timezone;
    }
}