package io.ipgeolocation.api;

import com.google.gson.internal.LinkedTreeMap;

import java.util.Map;

public class Geolocation {
    private Integer status;
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

    Geolocation(Map<String, Object> json) {
        this.status = Integer.parseInt((String) json.get("status"));
        String message = (String) json.get("message");

        if(this.status != 200 || message != null) {
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
            if(json.get("currency") instanceof LinkedTreeMap) {
                Map currencyJson = (LinkedTreeMap) json.get("currency");
                this.currency = new GeolocationCurrency(currencyJson);
            }

            if(json.get("time_zone") instanceof LinkedTreeMap) {
                Map timezoneJson = (LinkedTreeMap) json.get("time_zone");
                this.timezone = new GeolocationTimezone(timezoneJson);
            }

            if(json.get("security") instanceof LinkedTreeMap) {
                Map securityJson = (LinkedTreeMap) json.get("security");
                this.geolocationSecurity = new GeolocationSecurity(securityJson);
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

    @Override
    public String toString() {
        String currencyString = "";
        String timezoneString = "";
        String geolocationSecurityString = "";

        if(currency != null) {
            currencyString = currency.toString();
        }

        if(timezone != null) {
            timezoneString = timezone.toString();
        }

        if(geolocationSecurity != null){
            geolocationSecurityString = geolocationSecurity.toString();
        }

        return String.format("domain: '%s' \nip: '%s' \nhostname: '%s' \ncontinent_code: '%s' \ncontinent_name: '%s' \ncountry_code2: '%s' \ncountry_code3: '%s' \ncountry_name: '%s' \ncountry_capital: '%s \nstate_prov: '%s' \ndistrict: '%s' \ncity: '%s' \nzipcode: '%s' \nlatitude: '%s' \nlongitude: '%s' \nis_eu: '%s' \ncalling_code: '%s' \ncountry_tld: '%s' \nlanguages: '%s' \ncountry_flag: '%s' \nisp: '%s' \nconnection_type: '%s' \norganization: '%s' \ngeoname_id: '%s'\nasn: '%s' \ncurrency: {\n%s\n} \ntime_zone: {\n%s\n} \nsecurity: {\n%s\n}\n", domain, ip, hostname, continentCode, continentName, countryCode2, countryCode3, countryName, countryCapital, stateProvince, district, city, zipCode, latitude, longitude, isEU, callingCode, countryTLD, languages, countryFlag, isp, connectionType, organization, geonameID, asn, currencyString, timezoneString, geolocationSecurityString);
    }
}
