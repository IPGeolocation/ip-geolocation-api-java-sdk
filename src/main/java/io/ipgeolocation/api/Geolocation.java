package io.ipgeolocation.api;

import com.google.gson.internal.LinkedTreeMap;

import java.util.Map;

public class Geolocation {
    private final Integer status;
    private String message;
    private String domain;
    private String ip;
    private String hostname;
    private String continentCode;
    private String continentName;
    private String countryCode2;
    private String countryCode3;
    private String countryName;
    private String countryCapital;
    private String stateProvince;
    private String district;
    private String city;
    private String zipCode;
    private String latitude;
    private String longitude;
    private Boolean isEU;
    private String callingCode;
    private String countryTLD;
    private String languages;
    private String countryFlag;
    private String isp;
    private String connectionType;
    private String organization;
    private String asn;
    private String geonameID;
    private GeolocationCurrency currency;
    private GeolocationTimezone timezone;
    private GeolocationSecurity geolocationSecurity;
    private UserAgent userAgent;

    Geolocation(Map<String, Object> json) {
        this.status = Integer.parseInt((String) json.get("status"));
        String message = (String) json.get("message");
        if (this.status != 200 || message != null) {
            this.message = message;
        } else {
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
            if (json.get("currency") instanceof LinkedTreeMap) {
                Map<String, Object> currencyJson = (LinkedTreeMap) json.get("currency");
                this.currency = new GeolocationCurrency(currencyJson);
            }

            if (json.get("time_zone") instanceof LinkedTreeMap) {
                Map<String, Object> timezoneJson = (LinkedTreeMap) json.get("time_zone");
                this.timezone = new GeolocationTimezone(timezoneJson);
            }

            if (json.get("security") instanceof LinkedTreeMap) {
                Map<String, Object> securityJson = (LinkedTreeMap) json.get("security");
                this.geolocationSecurity = new GeolocationSecurity(securityJson);
            }

            if (json.get("user_agent") instanceof LinkedTreeMap) {
                Map<String, Object> userAgentJson = (LinkedTreeMap) json.get("user_agent");
                this.userAgent = new UserAgent(userAgentJson);
            }
        }
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
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
