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
    private String geonameID;
    private GeolocationCurrency currency;
    private GeolocationTimezone timezone;

    Geolocation(Map<String, Object> json) {
        this.status = Integer.parseInt((String) json.get("status"));
        String message = (String) json.get("message");

        if(this.status != 200 || message != null) {
            this.message = message;
        } else {
            this.ip = (String) json.get("ip");
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
            this.geonameID = (String) json.get("geoname_id");
            if(json.get("currency") instanceof LinkedTreeMap) {
                Map currencyJson = (LinkedTreeMap) json.get("currency");
                this.currency = new GeolocationCurrency(currencyJson);
            }

            if(json.get("time_zone") instanceof LinkedTreeMap) {
                Map timezoneJson = (LinkedTreeMap) json.get("time_zone");
                this.timezone = new GeolocationTimezone(timezoneJson);
            }
        }
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public String getIPAddress() {
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

    public String getGeonameID() {
        return geonameID;
    }

    public GeolocationCurrency getCurrency() {
        return currency;
    }

    public GeolocationTimezone getTimezone() {
        return timezone;
    }

    @Override
    public String toString() {
        String currencyString = "";
        String timezoneString = "";

        if(currency != null) {
            currencyString = currency.toString();
        }

        if(timezone != null) {
            timezoneString = timezone.toString();
        }

        return String.format("IP address: '%s' \nContinent Code: '%s' \nContinent Name: '%s' \nCountry Code ISO2: '%s' \nCountry Code ISO3: '%s' \nCountry Name: '%s' \nCountry Capital: '%s \nState/Province: '%s' \nDistrict: '%s' \nCity: '%s' \nZip Code: '%s' \nLatitude: '%s' \nLongitude: '%s' \nIs EU Member: '%s' \nCalling Code: '%s' \nCountry TLD: '%s' \nLanguages: '%s' \nFlag URL: '%s' \nISP: '%s' \nConnection Type: '%s' \nOrganization: '%s' \nGeoname ID: '%s' \nCurrency: {\n%s\n} \nTimezone: {\n%s\n}\n", ip, continentCode, continentName, countryCode2, countryCode3, countryName, countryCapital, stateProvince, district, city, zipCode, latitude, longitude, isEU, callingCode, countryTLD, languages, countryFlag, isp, connectionType, organization, geonameID, currencyString, timezoneString);
    }
}