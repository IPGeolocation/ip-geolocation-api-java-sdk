# IP Geolocation API Java SDK

## Introduction

[IPGeolocation API](https://ipgeolocation.io) is the solution to identify country code (ISO2 and ISO3 standard), country
name, continent code, continent name, country capital, state/province, district, city, zip code, latitude and longitude
of city, is country belongs to European Union, calling code, top level domain (TLD), languages, country flag, internet
service provider (ISP), connection type, organization, geo name ID, currency code, currency name, time zone ID, time zone
offset, current time in the time zone, is time zone in daylight saving time, total daylight savings and user agent
details. This document provides important information to help you get up to speed with IPGeolocation API using IP
Geolocation API Java SDK.

Developers can use this Java SDK for software and web projects related to, but not limited to:

1. Display native language and currency
2. Redirect based on the country
3. Digital rights management
4. Web log stats and analysis
5. Auto-selection of country, state/province and city on forms
6. Filter access from countries you do not do business with
7. Geo-targeting for increased sales and click-through

## Quick Start Guide

You need a valid 'IPGeolocation API key' to use this SDK. [Sign up](https://ipgeolocation.io/signup) here and get your
free API key if you don’t have one.

**Note:** Complete documentation [![javadoc](https://javadoc.io/badge2/io.ipgeolocation/ipgeolocation/ipgeolocation.svg)](https://javadoc.io/doc/io.ipgeolocation/ipgeolocation) to use this SDK is also available
at [IP Geolocation API Website](https://ipgeolocation.io/documentation/ip-geolocation-api-java-sdk.html)
.

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
    <version>1.0.16</version>
</dependency>
```

### Gradle

Add the following dependency in 'build.gradle' file to use the IP Geolocation API Java SDK.

```gradle
implementation 'io.ipgeolocation:ipgeolocation:1.0.16'
```

### Ivy

Add the following dependency code in 'ivy.xml' file to use the IP Geolocation API Java SDK.

```ivy
<dependency org="io.ipgeolocation" name="ipgeolocation" rev="1.0.16"/>
```

### JAR File

Use the following URL to download the latest JAR file for IP Geolocation API Java SDK.

* [https://ipgeolocation.io/downloads/ip-geolocation-api-java-1.0.16.jar](https://ipgeolocation.io/downloads/ip-geolocation-api-java-1.0.16.jar)

Documentation
-----------
Use the following URL to visit documentation

* [https://ipgeolocation.io/documentation.html](https://ipgeolocation.io/documentation.html)

Basic Usage
-----------

### Setup API

```java
// Create IPGeolocationAPI object, passing your valid API key
IPGeolocationAPI ipGeolocationAPI = new IPGeolocationAPI("YOUR_API_KEY");
```

### Geolocation Lookup

```java
// Get geolocation for IP address (1.1.1.1) and fields (geo, time_zone and currency)
GeolocationParams geolocationParams =
        GeolocationParams.builder()
            .withIPAddress("1.1.1.1")
            .withFields("geo,time_zone,currency")
            .includeSecurity()
            .build();

try {
    Geolocation geolocation = ipGeolocationAPI.getGeolocation(geolocationParams);

    // Geolocation Info
    System.out.println("Country: " + geolocation.getCountryName());
    System.out.println("Currency: " + geolocation.getCurrency().getName());
    System.out.println("Location time: " + geolocation.getTimezone().getCurrentTime());

    // Security Info
    System.out.println("Is Anonymous: " + geolocation.getGeolocationSecurity().isAnonymous());
    System.out.println("Is Known Attacker: " + geolocation.getGeolocationSecurity().isKnownAttacker());
    System.out.println("Is Proxy: " + geolocation.getGeolocationSecurity().isProxy());
    System.out.println("Proxy Type: " + geolocation.getGeolocationSecurity().getProxyType());
    System.out.println("IP Threat Score: " + geolocation.getGeolocationSecurity().getThreatScore());
    System.out.println("Is Bot: " + geolocation.getGeolocationSecurity().isBot());
    System.out.println("Is Spam: " + geolocation.getGeolocationSecurity().isSpam());
    System.out.println("Is Tor: " + geolocation.getGeolocationSecurity().isTor());
    System.out.println("Is Cloud Provider: " + geolocation.getGeolocationSecurity().isCloudProvider());
} catch (IPGeolocationError e) {
    // on unsuccessful lookup or invalid input IPGeolocationError is thrown
    System.err.println("HTTP status: " + e.getStatus() + " Error: " + e.getMessage());
}
```
```java
// Get geolocation in Russian** for IP address (1.1.1.1) and all fields
GeolocationParams geolocationParams =
        GeolocationParams.builder()
            .withIPAddress("1.1.1.1")
            .withLang("ru")
            .build();

try {
    Geolocation geolocation = ipGeolocationAPI.getGeolocation(geolocationParams);

    System.out.println("IP Address: " + geolocation.getIP());
    System.out.println("Country: " + geolocation.getCountryName());
} catch (IPGeolocationError e) {
    // on unsuccessful lookup or invalid input IPGeolocationError is thrown
    System.err.println("HTTP status: " + e.getStatus() + " Error: " + e.getMessage());
}
```
```java
// Get geolocation for the calling machine's IP address for all fields
try {
    Geolocation geolocation = ipGeolocationAPI.getGeolocation();

    System.out.println("IP Address: " + geolocation.getIP());
    System.out.println("Country Code ISO2: " + geolocation.getCountryCode2());
    System.out.println("Location time: " + geolocation.getTimezone().getCurrentTime());
} catch (IPGeolocationError e) {
    // on unsuccessful lookup or invalid input IPGeolocationError is thrown
    System.err.println("HTTP status: " + e.getStatus() + " Error: " + e.getMessage());
}
```

### Bulk Geolocations Lookup
```java
// Query geolocation in German** for multiple IP addresses and all fields
String[] ips = new String[]{"1.1.1.1", "2.2.2.2", "3.3.3.3"};
GeolocationParams geolocationParams =
        GeolocationParams.builder()
            .withLang("de")
            .build();

try {
    List<Geolocation> geolocations = ipGeolocationAPI.getBulkGeolocation(ips, geolocationParams);

    System.out.println("No. of Requests: " + geolocations.size());
    System.out.println("1st IP's Country: " + geolocations.get(0).getCountryName());
    System.out.println("2nd IP's Language: " + geolocations.get(1).getLanguages());
    System.out.println("3rd IP's location time: " + geolocations.get(2).getTimezone().getCurrentTime());
} catch (IPGeolocationError e) {
    // on unsuccessful lookup or invalid input IPGeolocationError is thrown
    System.err.println("HTTP status: " + e.getStatus() + " Error: " + e.getMessage());
}
```
```java
// Query geolocations for multiple IP addresses but only geo field
String[] ips = new String[]{"1.1.1.1", "2.2.2.2", "3.3.3.3"};
GeolocationParams geolocationParams =
        GeolocationParams.builder()
            .withFields("geo")
            .build();

try {
    List<Geolocation> geolocations = ipGeolocationAPI.getBulkGeolocation(ips, geolocationParams);

    System.out.println("No. of Requests: " + geolocations.size());
    System.out.println("1st IP's Country: " + geolocations.get(0).getCountryName());
    System.out.println("2nd IP's City: "+geolocations.get(1).getCity());
    System.out.println("3rd IP's City Zipcode: " + geolocations.get(2).getZipCode());
} catch (IPGeolocationError e) {
    // on unsuccessful lookup or invalid input IPGeolocationError is thrown
    System.err.println("HTTP status: " + e.getStatus() + " Error: " + e.getMessage());
}
```

### Timezone API
```java
// Get time zone information by time zone ID
TimezoneParams timezoneParams =
        TimezoneParams.builder().withTimeZone("America/New_York").build();

try {
    Timezone tz = ipGeolocationAPI.getTimezone(timezoneParams);
    
    System.out.println("Format 'EEEE, MMMM dd, yyyy HH:mm:ss': " + tz.getDateTimeTxt());
    System.out.println("Format 'EEE, dd MMM yyyy HH:mm:ss Z': " + tz.getDateTimeWti());
} catch (IPGeolocationError e) {
    // on unsuccessful lookup or invalid input IPGeolocationError is thrown
    System.err.println("HTTP status: " + e.getStatus() + " Error: " + e.getMessage());
}
```
```java
// Get time zone information by coordinates (latitude and longitude) of the location
TimezoneParams timezoneParams =
        TimezoneParams.builder()
            .withCoordinates(BigDecimal.valueOf(37.1838139), BigDecimal.valueOf(-123.8105225))
            .build();

try {
    Timezone tz = ipGeolocationAPI.getTimezone(timezoneParams);

    System.out.println("Timezone: " + tz.getTimezone());
    System.out.println("Timezone in Unix: " + tz.getDateTimeUnix());
    System.out.println("Time in 24 format: " + tz.getTime24());
} catch (IPGeolocationError e) {
    // on unsuccessful lookup or invalid input IPGeolocationError is thrown
    System.err.println("HTTP status: " + e.getStatus() + " Error: " + e.getMessage());
}
```
```java
// Get time zone information for IP address (1.1.1.1) and geolocation information in Japanese**
TimezoneParams timezoneParams =
        TimezoneParams.builder()
            .withIPAddress("1.1.1.1")
            .withLang("ja")
            .build();

try {
    Timezone tz = ipGeolocationAPI.getTimezone(timezoneParams);

    // Timezone Info
    System.out.println("Timezone: " + tz.getTimezone());
    System.out.println("Format 'EEEE, MMMM dd, yyyy HH:mm:ss': " + tz.getDateTimeTxt());
    System.out.println("Format 'yyyy-MM-dd'T'HH:mm:ssZ': " + tz.getDateTimeYmd());

    // Geo Info
    System.out.println("City: " + tz.getGeo().getCity());
    System.out.println("State/Province: " + tz.getGeo().getStateProvince());
    System.out.println("Country: " + tz.getGeo().getCountryName());
} catch (IPGeolocationError e) {
    // on unsuccessful lookup or invalid input IPGeolocationError is thrown
    System.err.println("HTTP status: " + e.getStatus() + " Error: " + e.getMessage());
}
```
```java
// Query time zone information for calling machine's IP address
try {
    Timezone tz = ipGeolocationAPI.getTimezone();

    // Timezone Info
    System.out.println("Timezone Offset: " + tz.getTimezoneOffset());
    System.out.println("Date: " + tz.getDate());
    System.out.println("Month (No.): " + tz.getMonth());

    // Geo Info
    System.out.println("City: " + tz.getGeo().getCity());
    System.out.println("Country Code ISO3: " + tz.getGeo().getCountryCode3());
    System.out.println("Lat/Lon: " + tz.getGeo().getLatitude() + "/" + tz.getGeo().getLongitude());
} catch (IPGeolocationError e) {
    // on unsuccessful lookup or invalid input IPGeolocationError is thrown
    System.err.println("HTTP status: " + e.getStatus() + " Error: " + e.getMessage());
}
```
```java
// Get time zone information by location (city, country, etc.)
TimezoneParams timezoneParams = 
        TimezoneParams.builder().withLocation("Syria, Damascus").build();

try {
    Timezone tz = ipGeolocationAPI.getTimezone(timezoneParams);

    System.out.println("Format 'EEEE, MMMM dd, yyyy HH:mm:ss': " + tz.getDateTimeTxt());
    System.out.println("Country: " + tz.getGeo().getCountryName());
} catch (IPGeolocationError e) {
    // on unsuccessful lookup or invalid input IPGeolocationError is thrown
    System.err.println("HTTP status: " + e.getStatus() + " Error: " + e.getMessage());
}
```

### UserAgent API
```java
// Query/Parse user agent information for Provided the provided string
try {
    String uaString = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_2) AppleWebKit/601.3.9 (KHTML, like Gecko) Version/9.0.2 Safari/601.3.9";
    UserAgent ua = ipGeolocationAPI.getUserAgent(uaString);

    System.out.println("Device name: " + ua.getDevice().getName());
    System.out.println("OS name: " + ua.getOperatingSystem().getName());
    System.out.println("OS version: " + ua.getOperatingSystem().getVersion());
    System.out.println("CPU: " + ua.getDevice().getCpu());
} catch (IPGeolocationError e) {
    // on unsuccessful lookup or invalid input IPGeolocationError is thrown
    System.err.println("HTTP status: " + e.getStatus() + " Error: " + e.getMessage());
}
```
```java
// Query/Parse user agent information for the provided strings
String[] uaStrings = new String[]
        {"Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_2) AppleWebKit/601.3.9 (KHTML, like Gecko) Version/9.0.2 Safari/601.3.9",
                "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/47.0.2526.111 Safari/537.36",
                "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:40.0) Gecko/20100101 Firefox/40.1"};

try {
    List<UserAgent> uas = ipGeolocationAPI.getBulkUserAgent(uaStrings);

    System.out.println("No. of Requests: " + uas.size());
    System.out.println("1st UA's Device name: " + uas.get(0).getDevice().getName());
    System.out.println("2nd UA's OS name: " + uas.get(1).getOperatingSystem().getName());
    System.out.println("3rd UA's Browser: " + uas.get(2).getName());
} catch (IPGeolocationError e) {
    System.err.println("HTTP status: " + e.getStatus() + " Error: " + e.getMessage());
}
```
```java
// Query useragent of the machine IP Address along with Geolocation
GeolocationParams geolocationParams = 
        GeolocationParams.builder()
                .includeUserAgentDetail()
               .build();
try {
    Geolocation geolocation = ipGeolocationAPI.getGeolocation(geolocationParams);

    System.out.println("IP: " + geolocation.getIP());
    System.out.println("City: " + geolocation.getCity());
    System.out.println("UserAgent OS: " + geolocation.getUserAgent().getOperatingSystem().getName());
    System.out.println("UserAgent Browser:" + geolocation.getUserAgent().getName());
    System.out.println("UserAgent Device: " + geolocation.getUserAgent().getDevice().getName());

} catch (IPGeolocationError e) {
    // on unsuccessful lookup or invalid input IPGeolocationError is thrown
    System.err.println("HTTP status: " + e.getStatus() + " Error: " + e.getMessage());
}
```
### Astronomy API
```java
// Query astronomy information for location (city, country, etc.)
AstronomyParams astronomyParams =
        AstronomyParams.builder()
                .withLocation("Amsterdam, Netherlands")
                .build();

try {
    Astronomy astronomy = ipGeolocationAPI.getAstronomy(astronomyParams);

    System.out.println("City: " + astronomy.getLocation().getCity());
    System.out.println("Country: " + astronomy.getLocation().getCountryName());
    System.out.println("Locality: " + astronomy.getLocation().getLocality());

    System.out.println("Sun Distance: " + astronomy.getSunDistance());
    System.out.println("Sun Altitude: " + astronomy.getSunAltitude());
    System.out.println("Day length: " + astronomy.getDayLength());
} catch (IPGeolocationError e) {
    // on unsuccessful lookup or invalid input IPGeolocationError is thrown
    System.err.println("HTTP status: " + e.getStatus() + " Error: " + e.getMessage());
}
```
```java
// Query astronomy information for given geo coordinates (latitude/longitude)
AstronomyParams astronomyParams = 
        AstronomyParams.builder()
                .withCoordinates(BigDecimal.valueOf(51.507277), BigDecimal.valueOf(-0.1290644))
                .withDate("2024-02-29")
                .build();

try {
    Astronomy astronomy = ipGeolocationAPI.getAstronomy(astronomyParams);

    System.out.println("Lat/Lon: " + astronomy.getLocation().getLatitude() + "/" + astronomy.getLocation().getLongitude());

    System.out.println("Date: " + astronomy.getDate());
    System.out.println("Moonset: " + astronomy.getMoonset());
    System.out.println("Sun Azimuth: " + astronomy.getSunAzimuth());
} catch (IPGeolocationError e) {
    // on unsuccessful lookup or invalid input IPGeolocationError is thrown
    System.err.println("HTTP status: " + e.getStatus() + " Error: " + e.getMessage());
}
```
```java
// Query astronomy information for machine IP
try {
    Astronomy astronomy = ipGeolocationAPI.getAstronomy();

    System.out.println("Zipcode: " + astronomy.getLocation().getCity());
    System.out.println("State code: " + astronomy.getLocation().getStateCode());
    System.out.println("City: " + astronomy.getLocation().getCity());

    System.out.println("Sunrise: " + astronomy.getSunrise());
    System.out.println("Sunset: " + astronomy.getSunset());
    System.out.println("Moonrise: " + astronomy.getMoonrise());
} catch (IPGeolocationError e) {
    // on unsuccessful lookup or invalid input IPGeolocationError is thrown
    System.err.println("HTTP status: " + e.getStatus() + " Error: " + e.getMessage());
}
```
```java
// Query astronomy information for specific IP in Chinese Language
AstronomyParams astronomyParams = AstronomyParams.builder()
        .withIPAddress("1.1.1.1")
        .withLang("cn")
        .build();

try {
    Astronomy astronomy = ipGeolocationAPI.getAstronomy(astronomyParams);

    System.out.println("Zipcode: " + astronomy.getLocation().getCity());
    System.out.println("Country Name: " + astronomy.getLocation().getCountryName());

    System.out.println("Sun distance: " + astronomy.getSunDistance());
    System.out.println("Moonrise: " + astronomy.getMoonrise());
    System.out.println("Moon Parallactic Angle: " + astronomy.getMoonParallacticAngle());
} catch (IPGeolocationError e) {
    // on unsuccessful lookup or invalid input IPGeolocationError is thrown
    System.err.println("HTTP status: " + e.getStatus() + " Error: " + e.getMessage());
}
```
### Time Conversion API
```java
// Convert time using timezone ID with the provided time
TimezoneConvertParams timezoneConvertParams =
        TimezoneConvertParams.builder()
                .withTimeZone("America/New_York", "Asia/Karachi")
                .withDateTime("2024-02-29 16:40")
                .build();

try {
    TimezoneConvert tzConverted = ipGeolocationAPI.convertTimeZone(timezoneConvertParams);

    System.out.println("Original time: " + tzConverted.getOriginalTime());
    System.out.println("Converted time: " + tzConverted.getConvertedTime());
    System.out.println("Difference in hours: " + tzConverted.getDiffHour());
}catch (IPGeolocationError e) {
    // on unsuccessful lookup or invalid input IPGeolocationError is thrown
    System.err.println("HTTP status: " + e.getStatus() + " Error: " + e.getMessage());
}
```
```java
// Convert time using locations with current time
TimezoneConvertParams timezoneConvertParams =
        TimezoneConvertParams.builder()
                .withLocation("Lahore, Pakistan", "London, United Kingdom")
                .build();

try {
    TimezoneConvert tzConverted = ipGeolocationAPI.convertTimeZone(timezoneConvertParams);

    System.out.println("Original time: " + tzConverted.getOriginalTime());
    System.out.println("Converted time: " + tzConverted.getConvertedTime());
    System.out.println("Difference in minutes: " + tzConverted.getDiffMin());
}catch (IPGeolocationError e) {
    // on unsuccessful lookup or invalid input IPGeolocationError is thrown
    System.err.println("HTTP status: " + e.getStatus() + " Error: " + e.getMessage());
}
```
```java
// Convert time using Geo Coordinates of locations with the provided time
TimezoneConvertParams timezoneConvertParams =
        TimezoneConvertParams.builder()
                .withCoordinates(
                        BigDecimal.valueOf(31.522165), BigDecimal.valueOf(74.358422),
                        BigDecimal.valueOf(38.907084), BigDecimal.valueOf(-77.03449))
                .withDateTime("2024-02-29 16:40:40")
                .build();

try {
    TimezoneConvert tzConverted = ipGeolocationAPI.convertTimeZone(timezoneConvertParams);

    System.out.println("Original time: " + tzConverted.getOriginalTime());
    System.out.println("Converted time: " + tzConverted.getConvertedTime());
    System.out.println("Difference in hours: " + tzConverted.getDiffHour());
}catch (IPGeolocationError e) {
    // on unsuccessful lookup or invalid input IPGeolocationError is thrown
    System.err.println("HTTP status: " + e.getStatus() + " Error: " + e.getMessage());
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

By default, geolocation information is returned into English. Response in a language other than English is available to
paid users only.

## IP Geolocation API Java SDK Objects Reference

IP Geolocation API Java SDK has the following classes that you can use to fully leverage it.

### Class: io.ipgeolocation.api.IPGeolocationAPI

| Method                                                          | Description                                                                                                                                    | Return Type       |
|:----------------------------------------------------------------|:-----------------------------------------------------------------------------------------------------------------------------------------------|:------------------|
| IPGeolocationAPI(String apiKey) throws IllegalArgumentException | Constructs the IPGeolocationAPI object. It takes a valid apiKey as a parameter and throws IllegalArgumentException if apiKey is empty or null. |                   |
| getApiKey()                                                     | Return the API key that you set to query the IPGeolocation API.                                                                                | String            |
| getGeolocation()                                                | Query Geolocation API.                                                                                                                         | Geolocation       |
| getGeolocation(GeolocationParams params)                        | Query Geolocation API based on the parameters passed.                                                                                          | Geolocation       |
| getBulkGeolocation(String[] ips)                                | Query Geolocation API to lookup multiple IP addresses (max. 50).                                                                               | List<Geolocation> |
| getBulkGeolocation(String[] ips, GeolocationParams params)      | Query Geolocation API to lookup multiple IP addresses (max. 50) based upon the parameters passed.                                              | List<Geolocation> |
| getTimezone()                                                   | Query Timezone API based on calling machine's IP address.                                                                                      | Timezone          |
| getTimezone(TimezoneParams params)                              | Query Timezone API based on the parameters passed.                                                                                             | Timezone          |
| convertTimeZone(TimezoneConvertParams params)                   | Convert between different timezones.                                                                                                           | TimezoneConvert   |
| getUserAgent(String uaString)                                   | Query UserAgent API.                                                                                                                           | UserAgent         |
| getBulkUserAgent(String[] uaStrings)                            | Query UserAgent API to lookup multiple user-agent strings (max. 50).                                                                           | List<UserAgent>   |
| getAstronomy()                                                  | Query Astronomy API with default the parameters.                                                                                               | Astronomy         |
| getAstronomy(AstronomyParams params)                            | Query Astronomy API based upon the parameters passed.                                                                                          | Astronomy         |

### Class: io.ipgeolocation.api.GeolocationParams

| Method                          | Description                                                                                 | Return Type                     |
|:--------------------------------|:--------------------------------------------------------------------------------------------|:--------------------------------|
| getIPAddress()                  | Get IP address set to lookup geolocation.                                                   | String                          |
| getLang()                       | Get language set to lookup geolocation.                                                     | String                          |
| getFields()                     | Get fields set to lookup geolocation.                                                       | String                          |
| isIncludeHostname()             | Returns Boolean object whether hostname is included in response or not.                     | boolean                         |
| isIncludeHostnameFallbackLive() | Returns Boolean object whether hostname with fall-back-live is included in response or not. | boolean                         |
| isIncludeLiveHostname()         | Returns Boolean object whether live hostname is included in response or not.                | boolean                         |
| isIncludeSecurity()             | Returns Boolean object whether Security object is included in response or not.              | boolean                         |
| isIncludeUserAgentDetail()      | Returns Boolean object whether UserAgent object is included in response or not.             | boolean                         |
| getExcludes()                   | Get fields (as a comma separated value) that have been excluded from response.              | String                          |
| builder()                       | Returns an instance of GeolocationParamsBuilder.                                            | static GeolocationParamsBuilder |

### Class: io.ipgeolocation.api.GeolocationParamsBuilder

| Method                        | Description                                                                                                                                                                                                                                                                                                                      | Return Type                  |
|:------------------------------|:---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|:-----------------------------|
| withIPAddress(String ip)      | Sets IP address to lookup geolocation.                                                                                                                                                                                                                                                                                           | GeolocationParamsBuilder     |
| withLang(String lang)         | Set language parameter to lookup geolocation.                                                                                                                                                                                                                                                                                    | GeolocationParamsBuilder     |
| withFields(String fields)     | Set fields to lookup geolocation.                                                                                                                                                                                                                                                                                                | GeolocationParamsBuilder     |
| includeHostname()             | This URL parameter enables the IPGeolocation API to lookup hostname from our IP-Hostname database and returns the same IP address if there is no hostname found for the queried IP address. Lookup thru IP-Hostname database is faster than other options but is experimental and under process and can produce unwanted output. | GeolocationParamsBuilder     |
| includeHostnameFallbackLive() | This URL parameter enables the IPGeolocation API to lookup hostname from our IP-Hostname database and if there is no hostname found for the queried IP address, then lookup thru the live sources. This option has been introduced for faster and accurate lookup.                                                               | GeolocationParamsBuilder     |
| includeLiveHostname()         | Returns Boolean object whether live hostname is included in response or not.                                                                                                                                                                                                                                                     | GeolocationParamsBuilder     |
| includeSecurity()             | Returns Boolean object whether Security object is included in response or not.                                                                                                                                                                                                                                                   | GeolocationParamsBuilder     |
| includeUserAgentDetail()      | Returns Boolean object whether UserAgent object is included in response or not.                                                                                                                                                                                                                                                  | GeolocationParamsBuilder     |
| withExcludes(String excludes) | Set fields (as a comma separated value) to exclude from response.                                                                                                                                                                                                                                                                | GeolocationParamsBuilder     |
| build()                       | Returns an instance of GeolocationParams with the values set earlier.                                                                                                                                                                                                                                                            | GeolocationParams            |

### Class: io.ipgeolocation.api.Geolocation

| Method                   | Description                                                  | Return Type         |
|:-------------------------|:-------------------------------------------------------------|:--------------------|
| getDomain()              | Returns domain name if domain name is passed.                | String              |
| getHostname()            | Returns hostname for the IP address.                         | String              |
| getIP()                  | Returns IP address of the geolocation.                       | String              |
| getContinentCode()       | Returns 2-letters continent code.                            | String              |
| getContinentName()       | Returns continent name.                                      | String              |
| getCountryCode2()        | Returns 2-letters country code.                              | String              |
| getCountryCode3()        | Returns 3-letters country code.                              | String              |
| getCountryName()         | Returns country name.                                        | String              |
| getCountryCapital()      | Returns country capital.                                     | String              |
| getStateProvince()       | Returns state/province.                                      | String              |
| getStateCode()           | Returns the ISO code for state/province.                     | String              |
| getDistrict()            | Returns district.                                            | String              |
| getCity()                | Returns city.                                                | String              |
| getZipCode()             | Returns zip code.                                            | String              |
| getLatitude()            | Returns latitude of the city.                                | BigDecimal          |
| getLongitude()           | Returns longitude of the city.                               | BigDecimal          |
| isEU()                   | Returns is the country in European Union.                    | boolean             |
| getCallingCode()         | Returns country calling code.                                | String              |
| getCountryTLD()          | Returns country's top level domain like '.au' for Australia. | String              |
| getLanguages()           | Returns languages spoken in the country.                     | String              |
| getCountryFlag()         | Returns a URL to country's flag.                             | String              |
| getISP()                 | Returns ISP name.                                            | String              |
| getConnectionType()      | Returns connection type of the IP address.                   | String              |
| getOrganization()        | Returns organization of the IP address.                      | String              |
| getAsn()                 | Returns AS number of the IP address.                         | String              |
| getGeoNameId()           | Returns Geo Name ID from geonames.org database.              | String              |
| getCurrency()            | Returns currency information of the country.                 | GeolocationCurrency |
| getTimezone()            | Returns time zone information of the country.                | GeolocationTimezone |
| getGeolocationSecurity() | Returns security details of the ip address.                  | GeolocationSecurity |
| getUserAgent()           | Returns user agent information of the country.               | UserAgent           |

### Class: io.ipgeolocation.api.GeolocationCurrency

| Method      | Description                      | Return Type |
|:------------|:---------------------------------|:------------|
| getName()   | Returns currency name.           | String      |
| getCode()   | Returns 3-letters currency code. | String      |
| getSymbol() | Returns currency symbol.         | String      |

### Class: io.ipgeolocation.api.GeolocationTimezone

| Method               | Description                                                               | Return Type |
|:---------------------|:--------------------------------------------------------------------------|:------------|
| getName()            | Returns standard time zone ID like "America/New_York".                    | String      |
| getOffset()          | Returns time zone offset from UTC.                                        | int         |
| getCurrentTime()     | Returns current date-time string in the format "yyyy-MM-dd HH:mm:ss.SSSZ" | String      |
| getCurrentTimeUnix() | Returns current date-time as a unix time                                  | BigDecimal  |
| isDST()              | Returns is the country observing daylight saving time.                    | Boolean     |
| getDSTSavings()      | Returns daylight savings time (in hours).                                 | int         |
| getOffsetWithDst()   | Returns daylight savings time offset with UTC (in hours).                 | int         |

### Class: io.ipgeolocation.api.GeolocationSecurity

| Method             | Description                                                     | Return Type |
|:-------------------|:----------------------------------------------------------------|:------------|
| getThreatScore()   | Returns threat score for the ip address                         | int         |
| isTor()            | Returns Boolean object whether the ip is using tor or not.      | boolean     |
| isProxy()          | Returns Boolean object whether the ip is using proxy or not.    | boolean     |
| getProxyType()     | Returns the type of proxy used by ip address                    | String      |
| isAnonymous()      | Returns Boolean object whether the ip is anonymous or not.      | boolean     |
| isKnownAttacker()  | Returns Boolean object whether the ip is known attacker or not. | boolean     |
| isBot()            | Returns Boolean object whether the ip is bot or not.            | boolean     |
| isSpam()           | Returns Boolean object whether the ip is spam or not.           | boolean     |
| isCloudProvider()  | Returns Boolean object whether the ip is cloud provider or not. | boolean     |

### Class: io.ipgeolocation.api.TimezoneParams

| Method         | Description                                                               | Return Type                  |
|:---------------|:--------------------------------------------------------------------------|:-----------------------------|
| getTimezone()  | Get time zone ID set to query time zone information.                      | String                       |
| getIPAddress() | Get IP address set to query time zone information.                        | String                       |
| getLatitude()  | Returns latitude set to query time zone information.                      | BigDecimal                   |
| getLongitude() | Returns longitude set to query time zone information.                     | BigDecimal                   |
| getLocation()  | Get location parameter value to get timezone details.                     | String                       |
| getLang()      | Get language set to lookup geolocation.                                   | String                       |
| builder()      | Returns an instance of TimezoneParamsBuilder.                             | static TimezoneParamsBuilder |

### Class: io.ipgeolocation.api.TimezoneParamsBuilder

| Method                                                     | Description                                                               | Return Type           |
|:-----------------------------------------------------------|:--------------------------------------------------------------------------|:----------------------|
| withTimezone(String timeZone)                              | Sets time zone ID to query time zone information.                         | TimezoneParamsBuilder |
| withIPAddress(String ipAddress)                            | Sets IP address to query time zone information.                           | TimezoneParamsBuilder |
| withCoordinates(BigDecimal latitude, BigDecimal longitude) | Sets latitude and longitude of a location to query time zone information. | TimezoneParamsBuilder |
| withLocation(String location)                              | Set location parameter to get timezone details.                           | TimezoneParamsBuilder |
| withLang(String lang)                                      | Set language parameter to lookup geolocation. Default is 'en'.            | TimezoneParamsBuilder |
| build()                                                    | Returns an instance of TimezoneParams with the values set earlier.        | TimezoneParams        |

### Class: io.ipgeolocation.api.Timezone

| Method                     | Description                                                                            | Return Type |
|:---------------------------|:---------------------------------------------------------------------------------------|:------------|
| getTimezone()              | Returns time zone ID like "America/New_York".                                          | String      |
| getTimezoneOffset()        | Returns time zone offset from UTC.                                                     | int         |
| getTimezoneOffsetWithDST() | Returns time zone offset with dst value from UTC.                                      | int         |
| getDate()                  | Returns current date in the format "yyyy-MM-dd".                                       | String      |
| getDateTime()              | Returns date-time string in the format "yyyy-MM-dd HH:mm:ss".                          | String      |
| getDateTimeTxt()           | Returns date-time string in the format "EEEE, MMMM dd, yyyy HH:mm:ss".                 | String      |
| getDateTimeWti()           | Returns date-time string in the format "EEE, dd MMM yyyy HH:mm:ss Z".                  | String      |
| getDateTimeYmd()           | Returns date-time string in the format "yyyy-MM-dd'T'HH:mm:ssZ".                       | String      |
| getDateTimeUnix()          | Returns current date-time as unix time.                                                | BigDecimal  |
| getTime24()                | Returns current time in the format "HH:mm:ss".                                         | String      |
| getTime12()                | Returns current time in the format "hh:mm:ss aa".                                      | String      |
| getWeek()                  | Returns current week of the year.                                                      | int         |
| getMonth()                 | Returns current month of the year.                                                     | int         |
| getYear()                  | Returns current year.                                                                  | int         |
| getYearAbbr()              | Returns 2-letters year abbreviation like "18".                                         | String      |
| isDST()                    | Returns is the country observing Daylight Saving time.                                 | boolean     |
| getDSTSavings()            | Returns daylight savings time (in hours).                                              | int         |
| getGeo()                   | Returns geolocation of timezone if you lookup timezone information from an IP address. | TimezoneGeo |

### Class: io.ipgeolocation.api.TimezoneGeo

| Method             | Description                      | Return Type |
|:-------------------|:---------------------------------|:------------|
| getCountryCode2()  | Returns 2-letters country code.  | String      |
| getCountryCode3()  | Returns 3-letters country code.  | String      |
| getCountryName()   | Returns country name.            | String      |
| getStateProvince() | Returns state/province.          | String      |
| getDistrict()      | Returns district.                | String      |
| getCity()          | Returns city.                    | String      |
| getZipCode()       | Returns zip code.                | String      |
| getLatitude()      | Returns latitude of the city.    | BigDecimal  |
| getLongitude()     | Returns longitude of the city.   | BigDecimal  |

### Class: io.ipgeolocation.api.UserAgent

| Method                 | Description                                       | Return Type              |
|:-----------------------|:--------------------------------------------------|:-------------------------|
| getUserAgentString()   | Returns user-agent string.                        | String                   |
| getName()              | Returns name of the user agent.                   | String                   |
| getType()              | Returns type of the user agent.                   | String                   |
| getVersion()           | Returns version of the user agent.                | String                   |
| getVersionMajor()      | Returns version major of the user agent.          | String                   |
| getDevice()            | Returns user-agent's device details.              | UserAgentDevice          |
| getEngine()            | Returns user-agent's engine details.              | UserAgentEngine          |
| getOperatingSystem()   | Returns user-agent's operating system details.    | UserAgentOperatingSystem |

### Class: io.ipgeolocation.api.UserAgentDevice

| Method     | Description                       | Return Type |
|:-----------|:----------------------------------|:------------|
| getName()  | Returns user-agent's device name. | String      |
| getType()  | Returns user-agent's type name.   | String      |
| getBrand() | Returns user-agent's brand name.  | String      |
| getCpu()   | Returns user-agent's CPU name.    | String      |

### Class: io.ipgeolocation.api.UserAgentEngine

| Method            | Description                                | Return Type |
|:------------------|:-------------------------------------------|:------------|
| getName()         | Returns user-agent's engine name.          | String      |
| getType()         | Returns user-agent's engine type.          | String      |
| getVersion()      | Returns user-agent's engine version.       | String      |
| getVersionMajor() | Returns user-agent's engine version major. | String      |

### Class: io.ipgeolocation.api.UserAgentOperatingSystem

| Method            | Description                                          | Return Type |
|:------------------|:-----------------------------------------------------|:------------|
| getName()         | Returns user-agent's operating system name.          | String      |
| getType()         | Returns user-agent's operating system type.          | String      |
| getVersion()      | Returns user-agent's operating system version.       | String      |
| getVersionMajor() | Returns user-agent's operating system version major. | String      |

### Class: io.ipgeolocation.api.AstronomyParams

| Method            | Description                                                        | Return Type                   |
|:------------------|:-------------------------------------------------------------------|:------------------------------|
| getLocation()     | Returns location parameter value to get astronomy information.     | String                        |
| getLatitude()     | Returns latitude parameter value to get astronomy information.     | BigDecimal                    |
| getLongitude()    | Returns longitude parameter value to get astronomy information.    | BigDecimal                    |
| getIpAddress()    | Returns IP address parameter value to get astronomy information.   | String                        |
| getDate()         | Returns date parameter value to get astronomy information.         | String                        |
| getLang()         | Returns language set to get the astronomy information.             | String                        |
| builder()         | Returns an instance of AstronomyParamsBuilder class.               | static AstronomyParamsBuilder |

### Class: io.ipgeolocation.api.AstronomyParams.AstronomyParamsBuilder
| Method                                                     | Description                                                               | Return Type            |
|:-----------------------------------------------------------|:--------------------------------------------------------------------------|:-----------------------|
| withLocation(String location)                              | Sets location to query astronomy information.                             | AstronomyParamsBuilder |
| withCoordinates(BigDecimal latitude, BigDecimal longitude) | Sets latitude and longitude of a location to query astronomy information. | AstronomyParamsBuilder |
| withIPAddress(String ipAddress)                            | Sets IP address of which to query astronomy information.                  | AstronomyParamsBuilder | 
| withDate(String date)                                      | Sets date of which to query astronomy information.                        | AstronomyParamsBuilder |
| withLang(String lang)                                      | Sets language in which to query information.                              | AstronomyParamsBuilder |
| build()                                                    | Returns an instance of AstronomyParams with the above specified value(s). | AstronomyParams        |

### Class: io.ipgeolocation.api.Astronomy
| Method                    | Description                                                                              | Return Type       |
|:--------------------------|:-----------------------------------------------------------------------------------------|:------------------|
| getDate()                 | Returns the date of which the information is queried in "yyyy-MM-dd" format.             | String            |
| getCurrentTime()          | Returns the current time in the format "HH:mm:ss".                                       | String            |
| getSunrise()              | Returns the time at which sun rises in format "HH:mm".                                   | String            |
| getSunset()               | Returns the time at which sun sets in format "HH:mm".                                    | String            |
| getSunStatus()            | Returns the status of sunrise and sunset as "-", if these values are not available.      | String            |
| getSolarNoon()            | Returns the solar noon time in the format "HH:mm".                                       | String            |
| getDayLength()            | Returns the day length in the format "HH:mm".                                            | String            |
| getSunAltitude()          | Returns the altitude of the sun in degrees.                                              | BigDecimal        |
| getSunDistance()          | Returns the distance from the sun in km.                                                 | BidDecimal        |
| getSunAzimuth()           | Returns the azimuth of the sun in degrees.                                               | BigDecimal        |
| getMoonrise()             | Returns the moon rise time in the format "HH:mm".                                        | BigDecimal        |
| getMoonset()              | Returns the moon set time in the format "HH:mm".                                         | BigDecimal        |
| getMoonStatus()           | Returns the status of moon rise and moon set as "-", if these values are not available.  | BigDecimal        |
| getMoonAltitude()         | Returns the altitude of the moon in degrees.                                             | BigDecimal        |
| getMoonDistance()         | Returns the distance from the moon in km.                                                | BigDecimal        |
| getMoonAzimuth()          | Returns the azimuth of the moon in degrees.                                              | BigDecimal        |
| getMoonParallacticAngle() | Returns the Moon Parallactic angle of the moon in degrees.                               | BigDecimal        |
| getLocation()             | Returns the instance of the AstronomyLocation related to astronomy information.          | AstronomyLocation |
| toString()                | Returns the fetched JSON from the API in formatted way.                                  | String            |

### Class: io.ipgeolocation.api.AstronomyLocation
| Method                    | Description                                                                               | Return Type |
|:--------------------------|:------------------------------------------------------------------------------------------|:------------|
| getLocation()             | Returns the input location i.e., street address.                                          | String      |
| getLatitude()             | Returns the latitude value for which the astronomy information was queried.               | BigDecimal  |
| getLongitude()            | Returns the longitude value for which the astronomy information was queried.              | BigDecimal  |
| getZipcode()              | Returns the zip code related to the queried astronomy information.                        | String      |
| getCountryCode2()         | Returns the two letter country code for queried astronomy information. e.g. 'PK'.         | String      |
| getCountryCode3()         | Returns the three letter country code for the queried astronomy information. e.g., 'PAK'. | String      |
| getCountryName()          | Returns the general country name of the queried astronomy information.                    | String      |
| getCountryNameOfficial()  | Returns the official country name of the queried astronomy information.                   | String      |
| getStateProv()            | Returns the State/Province of the queried astronomy information.                          | String      |
| getStateCode()            | Returns the state code of the queried astronomy information. e.g., 'PK-PB'                | String      |
| getDistrict()             | Returns the district of the queried astronomy information.                                | String      |
| getLocality()             | Returns the locality of the queried astronomy information.                                | String      |
| getCity()                 | Returns the city of the queried astronomy information.                                    | String      |
| toString()                | Returns the fetched JSON from the API in the formatted way.                               | String      |

### Class: io.ipgeolocation.api.TimezoneConvertParams
| Method             | Description                                                                                                                             | Return Type                  |
|:-------------------|:----------------------------------------------------------------------------------------------------------------------------------------|:-----------------------------|
| getTimezoneFrom()  | Returns the source [timezone ID](https://en.wikipedia.org/wiki/List_of_tz_database_time_zones) for which conversion would be performed. | String                       |
| getTimezoneTo()    | Returns the target timezone ID for which conversion would be performed.                                                                 | String                       |
| getTime()          | Returns the dateTime which would be used for conversion.                                                                                | String                       |
| getLatitudeFrom()  | Returns the source latitude for which conversion would be performed.                                                                    | BigDecimal                   |
| getLongitudeFrom() | Returns the source longitude for which conversion would be performed.                                                                   | BigDecimal                   |
| getLatitudeTo()    | Returns the target latitude for which conversion would be performed.                                                                    | BigDecimal                   |
| getLongitudeTo()   | Returns the target longitude for which conversion would be performed.                                                                   | BigDecimal                   |
| getLocationFrom()  | Returns the source location (i.e., city, country) for which conversion would be performed.                                              | String                       |
| getLocationTo()    | Returns the target location (i.e., city, country) for which conversion would be performed.                                              | String                       |
| builder()          | Returns an instance of TimezoneConvertParamsBuilder class to create TimezoneConvertParams object with custom parameters.                | static TimezoneConvertParams |

### Class: io.ipgeolocation.api.TimezoneConvertParams.TimezoneConvertParamsBuilder
| Method                                                                                        | Description                                                                                                                | Return Type                  |
|:----------------------------------------------------------------------------------------------|:---------------------------------------------------------------------------------------------------------------------------|:-----------------------------|
| withTimeZone(String timezoneFrom, String timezoneTo)                                          | Sets source and target [timezone IDs](https://en.wikipedia.org/wiki/List_of_tz_database_time_zones) to perform conversion. | TimezoneConvertParamsBuilder |
| withDateTime(String dateTime)                                                                 | Sets dateTime which would be used for conversion.                                                                          | TimezoneConvertParamsBuilder |
| withCoordinates(BigDecimal latFrom, BigDecimal longFrom, BigDecimal latTo, BigDecimal longTo) | Sets the source and target geo coordinates.                                                                                | TimezoneConvertParamsBuilder |
| withLocation(String locationFrom, String locationTo)                                          | Sets the source and target locations (i.e., city, country).                                                                | TimezoneConvertParamsBuilder |
| build()                                                                                       | Returns an instance of the TimezoneConvertParams with the above specified value(s).                                        | TimezoneConvertParams        |