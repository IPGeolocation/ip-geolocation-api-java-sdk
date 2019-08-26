# IP Geolocation API Java SDK

## Introduction
[IPGeolocation API](https://ipgeolocation.io) is the solution to identify country code (ISO2 and ISO3 standard), country name, continent code, continent name, country capital, state/province, district, city, zip code, latitude and longitude of city, is country belongs to Europian Union, calling code, top level domain (TLD), languages, country flag, internet service provider (ISP), connection type, organization, geoname ID, currency code, currency name, time zone ID, time zone offset, current time in the time zone, is time zone in daylight saving time, and total daylight savings. This document provides important information to help you get up to speed with IPGeolocation API using IP Geolocation API Java SDK.

Developers can use this Java SDK for software and web projects related to, but not limited to:

1. Display native language and currency
2. Redirect based on the country
3. Digital rights management
4. Web log stats and analysis
5. Auto-selection of country, state/province and city on forms
6. Filter access from countries you do not do business with
7. Geo-targeting for increased sales and click-through

## Quick Start Guide

You need a valid 'IPGeolocation API key' to use this SDK. [Sign up](https://ipgeolocation.io/signup) here and get your free API key if you don’t have one.

**Note:** Complete documentation to use this SDK is also available at [IP Geolocation API JAVA SDK Documentation](https://ipgeolocation.io/documentation/ip-geolocation-api-java-sdk-20180807094025).

## System Requirements

IP Geolocation API Java SDK has been developed and tested on JDK version 8.  
Note: Internet connection is required to run this component.

## Installation
Our Java SDK can be installed by various methods given below:

### Maven

Add the following dependency in 'pom.xml' file to use the IP Geolocation API Java SDK.

```maven
<dependency>
    <groupId>io.ipgeolocation</groupId>
    <artifactId>ipgeolocation</artifactId>
    <version>1.0.8</version>
</dependency>
```

### Gradle

Add the following dependency in 'build.gradle' file to use the IP Geolocation API Java SDK.

```gradle
repositories {
    ...
    maven { url "http://dl.bintray.com/ipgeolocation/ipgeolocation" }
}

dependencies {
    compile 'io.ipgeolocation:ipgeolocation:1.0.8'
    ...
}
```

### Ivy

Add the following dependency code in 'ivy.xml' file to use the IP Geolocation API Java SDK.

```ivy
<dependency org='io.ipgeolocation' name='ipgeolocation' rev='1.0.8'>
    <artifact name='ipgeolocation' />
</dependency>
```

### JAR File

Use the following URL to download the latest JAR file for IP Geolocation API Java SDK.

* [https://ipgeolocation.io/downloads/ip-geolocation-api-java-1.0.5.jar](https://ipgeolocation.io/downloads/ip-geolocation-api-java-1.0.8.jar)

Basic Usage
-----------

### Setup API

```java
// Create IPGeolocationAPI object, passing your valid API key
IPGeolocationAPI api = new IPGeolocationAPI("YOUR_API_KEY");
```

### Geolocation Lookup

```java
// Get geolocation for IP address (1.1.1.1) and fields (geo, time_zone and currency)
GeolocationParams geoParams = new GeolocationParams();
geoParams.setIPAddress("1.1.1.1");
geoParams.setFields("geo,time_zone,currency");

Geolocation geolocation = api.getGeolocation(geoParams);

// Check if geolocation lookup was successful
if(geolocation.getStatus() == 200) {
    System.out.println(geolocation.getCountryName());
    System.out.println(geolocation.getCurrency().getName());
    System.out.println(geolocation.getTimezone().getCurrentTime());
} else {
    System.out.printf("Status Code: %d, Message: %s\n", geolocation.getStatus(), geolocation.getMessage());
}

// Get geolocation in Russian** for IP address (1.1.1.1) and all fields
GeolocationParams geoParams = new GeolocationParams();
geoParams.setIPAddress("1.1.1.1");
geoParams.setLang("ru");

Geolocation geolocation = api.getGeolocation(geoParams);

// Check if geolocation lookup was successful
if(geolocation.getStatus() == 200) {
    System.out.println(geolocation.getIPAddress());
    System.out.println(geolocation.getCountryName());
} else {
    System.out.printf("Status Code: %d, Message: %s\n", geolocation.getStatus(), geolocation.getMessage());
}

// Get geolocation for the calling machine's IP address for all fields
Geolocation geolocation = api.getGeolocation();

if(geolocation.getStatus() == 200) {
    System.out.println(geolocation.getCountryCode2());
    System.out.println(geolocation.getTimezone().getCurrentTime());
} else {
    System.out.printf("Status Code: %d, Message: %s\n", geolocation.getStatus(), geolocation.getMessage());
}
```

### Bulk Geolocations Lookup

```java
// Query geolocation in German** for multiple IP addresses and all fields
String[] ips = new String[]{"1.1.1.1", "2.2.2.2", "3.3.3.3"};
GeolocationParams geoParams = new GeolocationParams();
geoParams.setIPAddresses(ips);
geoParams.setLang("de");

List<Geolocation> geolocations = api.getBulkGeolocation(geoParams);

System.out.println(geolocations.size());
System.out.println(geolocations.get(0).getCountryName());
System.out.println(geolocations.get(1).getLanguages());
System.out.println(geolocations.get(2).getTimezone().getCurrentTime());

// Query geolocations for multiple IP addresses but only geo field
String[] ips = new String[]{"1.1.1.1", "2.2.2.2", "3.3.3.3"};
GeolocationParams geoParams = new GeolocationParams();
geoParams.setIPAddresses(ips);
geoParams.setFields("geo");

List<Geolocation> geolocations = api.getBulkGeolocation(geoParams);

System.out.println(geolocations.size());
System.out.println(geolocations.get(0).getCountryCode2());
System.out.println(geolocations.get(1).getCountryName());
System.out.println(geolocations.get(2).getLatitude());
```

### Timezone API

```java
// Get time zone information by time zone ID
TimezoneParams tzParams = new TimezoneParams();
tzParams.setTimezone("America/New_York");

Timezone tz = api.getTimezone(tzParams);

if(tz.getStatus() == 200) {
    System.out.println(tz.getDateTimeWti());
    System.out.println(tz.getDateTimeTxt());
} else {
    System.out.printf("Status Code: %d, Message: %s\n", geolocation.getStatus(), geolocation.getMessage());
}

// Get time zone information by latitude and longitude of the location
TimezoneParams tzParams = new TimezoneParams();
tzParams.setLocation(37.1838139, -123.8105225);

Timezone tz = api.getTimezone(tzParams);

if(tz.getStatus() == 200) {
    System.out.println(tz.getTimezone());
} else {
    System.out.printf("Status Code: %d, Message: %s\n", geolocation.getStatus(), geolocation.getMessage());
}

// Get time zone information for IP address (1.1.1.1) and geolocation information Japanese**
TimezoneParams tzParams = new TimezoneParams();
tzParams.setIPAddress("1.1.1.1");
tzParams.setLang("ja");

Timezone tz = api.getTimezone(tzParams);

if(tz.getStatus() == 200) {
    System.out.println(tz.getTimezone());
} else {
    System.out.printf("Status Code: %d, Message: %s\n", geolocation.getStatus(), geolocation.getMessage());
}

// Query time zone information for calling machine's IP address
Timezone tz = api.getTimezone();

if(tz.getMessage()) {
    System.out.println(tz.getTimezone());
    System.out.println(tz.getDateTimeYmd());
} else {
    System.out.printf("Status Code: %d, Message: %s\n", geolocation.getStatus(), geolocation.getMessage());
}
```

** IPGeolocation provides geolocation information in the following languages:
* English (en)
* German (de)
* Russian (ru)
* Japanese (ja)
* French (fr)
* Chinese Simplified (cn)
* Spanish (es)
* Czech (cs)
* Italian (it)

By default, geolocation information is returned in English. Response in a language other than English is available to paid users only.

## IP Geolocation API Java SDK Objects Reference

IP Geolocation API Java SDK has following classes that you can use to fully leverage it.

### Class: io.ipgeolocation.api.IPGeolocationAPI

| Method | Description | Return Type |
|:-------|:------------|:------------|
| IPGeolocationAPI(String apiKey) throws IllegalArgumentException | Constructs the IPGeolocationAPI object. It takes a valid apiKey as a parameter and throws IllegalArgumentException if apiKey is empty or null. ||
| getGeolocation() | This function to query Geolocation API. | Geolocation |
| getGeolocation(GeolocationParams params) | This function to query Geolocation API based on the parameters passed. | Geolocation |
| getTimezone() | This function to query Timezone API based on calling machine's IP address. | Timezone |
| getTimezone(TimezoneParams params) | This function to query Timezone API based on the parameters passed. | Timezone |
| getBulkGeolocation(GeolocationParams params) | This function to query Geolocation API to lookup multiple IP addresses (max. 50). | List\<Geolocation\> |
| getApiKey() | This function to get the API key that you set to query the IPGeolocation API. | String |

### Class: io.ipgeolocation.api.GeolocationParams

| Method | Description | Return Type |
|:-------|:------------|:------------|
| setIPAddress(String ip) | Sets IP address to lookup geolocation. | void |
| getIPAddress() | Get IP address set to lookup geolocation. | String |
| setFields(String fields) | Set fields to lookup geolocation. | void |
| getFields() | Get fields set to lookup geolocation. | String |
| setIPAddresses(String[] ips) throws IllegalArgumentException | Set IP addresses to lookup multiple geo-locations. Throws IllegalArgumentException if no. of IP addresses are more than 50. **Note:** Multiple IP addresses lookup is only available for paid users. | void |
| getIPAddresses() | Get IP addresses set to lookup bulk geolocations. | String[] |
| setLang(String lang) | Set language parameter to lookup geolocation. | void |
| getLang() | Get language set to lookup geolocation. | String |

### Class: io.ipgeolocation.api.Geolocation

| Method | Description | Return Type |
|:-------|:------------|:------------|
| getStatus() | Returns HTTP status of the geolocation query. 200 is the successful query status. | Integer |
| getMessage() | Returns error message, if the query was not successful. | String |
| getIPAddress() | Returns IP address of the geolocation. | String |
| getContinentCode() | Returns 2-letters continent code. | String |
| getContinentName() | Returns continent name. | String |
| getCountryCode2() | Returns 2-letters country code. | String |
| getCountryCode3() | Returns 3-letters country code. | String |
| getCountryName() | Returns country name. | String |
| getCountryCapital() | Returns country capital. | String |
| getStateProvince() | Returns state/province. | String |
| getDistrict() | Returns district. | String |
| getCity() | Returns city. | String |
| getZipCode() | Returns zip code. | String |
| getLatitude() | Returns latitude of the city. | Double |
| getLongitude() | Returns longitude of the city. | Double |
| isEU() | Returns is the country in European Union. | Boolean |
| getCallingCode() | Returns country calling code. | String |
| getCountryTLD() | Returns country's top level domain like '.au' for Australia. | String |
| getLanguages() | Returns languages spoken in the country. | String |
| getCountryFlag() | Returns a URL to country's flag. | String |
| getISP() | Returns ISP name. | String |
| getConnectionType() | Returns connection type of the IP address. | String |
| getOrganization() | Returns organization of the IP address. | String |
| getAsn() | Returns AS number of the IP address. | String |
| getRoute() | Returns BGP route of the IP address. | String |
| getGeonameID() | Returns geoname ID from geonames.org database. | String |
| getCurrency() | Returns currency information of the country. | GeolocationCurrency |
| getTimezone() | Returns time zone information of the country. | GeolocationTimezone |

### Class: io.ipgeolocation.api.GeolocationCurrency

| Method | Description | Return Type |
|:-------|:------------|:------------|
| getCode() | Returns 3-letters currency code. | String |
| getName() | Returns currency name. | String |
| getSymbol() | Returns currency symbol. | String |

### Class: io.ipgeolocation.api.GeolocationTimezone

| Method | Description | Return Type |
|:-------|:------------|:------------|
| getName() | Returns standard time zone ID like "America/New_York". | String |
| getOffset() | Returns time zone offset from UTC. | Double |
| getCurrentTime() | Returns current date-time string in the format "yyyy-MM-dd HH:mm:ss.SSSZ" | String |
| isDST() | Returns is the country observing daylight saving time. | Boolean |
| getDSTSavings() | Returns daylight savings time (in hours). | Double |

### Class: io.ipgeolocation.api.TimezoneParams

| Method | Description | Return Type |
|:-------|:------------|:------------|
| setTimezone(String timezone) | Sets time zone ID to query time zone information. | void |
| getTimezone() | Get time zone ID set to query time zone information. | String |
| setIPAddress(String ip) | Sets IP address to query time zone information. | void |
| getIPAddress() | Get IP address set to query time zone information. | String |
| setLocation(Double latitude, Double longitude) | Sets latitude and longitude of a location to query time zone information. | void |
| getLatitude() | Returns latitude set to query time zone information. | Double |
| getLongitude() | Returns longitude set to query time zone information. | Double |
| setLang(String lang) | Set language parameter to lookup geolocation. Default is 'en'. | void |
| getLang() | Get language set to lookup geolocation. | String |

### Class: io.ipgeolocation.api.Timezone

| Method | Description | Return Type |
|:-------|:------------|:------------|
| getStatus() | Returns HTTP status of the geolocation query. 200 is the successful query status. | Integer |
| getMessage() | Returns error message, if the query was not successful. | String |
| getTimezone() | Returns time zone ID like "America/New_York". | String |
| getTimezoneOffset() | Returns time zone offset from UTC. | Double |
| getDate() | Returns current date in the format "yyyy-MM-dd". | String |
| getDateTime() | Returns date-time string in the format "yyyy-MM-dd HH:mm:ss". | String |
| getDateTimeTxt() | Returns date-time string in the format "EEEE, MMMM dd, yyyy HH:mm:ss". | String |
| getDateTimeWti() | Returns date-time string in the format "EEE, dd MMM yyyy HH:mm:ss Z". | String |
| getDateTimeYmd() | Returns date-time string in the format "yyyy-MM-dd'T'HH:mm:ssZ". | String |
| getTime24() | Returns current time in the format "HH:mm:ss". | String |
| getTime12() | Returns current time in the format "hh:mm:ss aa". | String |
| getWeek() | Returns current week of the year. | String |
| getMonth() | Returns current month of the year. | String |
| getYear() | Returns current year. | String |
| getYearAbbr() | Returns 2-letters year abbreviation like "18". | String |
| isDST() | Returns is the country observing Daylight Saving time. | Boolean |
| getDSTSavings() | Returns daylight savings time (in hours). | Double |
| getTimezoneGeo() | Returns geolocation of timezone if you lookup timezone information from an IP address. | TimezoneGeo |

### Class: io.ipgeolocation.api.TimezoneGeo

| Method | Description | Return Type |
|:-------|:------------|:------------|
| getCountryCode2() | Returns 2-letters country code. | String |
| getCountryCode3() | Returns 3-letters country code. | String |
| getCountryName() | Returns country name. | String |
| getStateProvince() | Returns state/province. | String |
| getDistrict() | Returns district. | String |
| getCity() | Returns city. | String |
| getZipCode() | Returns zip code. | String |
| getLatitude() | Returns latitude of the city. | Double |
| getLongitude() | Returns longitude of the city. | Double |
