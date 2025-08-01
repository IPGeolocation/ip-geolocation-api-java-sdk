# IPGeolocation.io Java SDK

IPGeolocation.io – Real-time IP Intelligence, Threat Detection APIs & Database Solutions
- API version: 2.0

## IPGeolocation.io SDK for Java

The official **Java SDK** provides streamlined access to **IPGeolocation.io**, a comprehensive platform offering RESTful IP-based APIs and downloadable databases delivering precise geolocation, network, timezone, currency, abuse, ASN, and company/ISP details for IPv4 and IPv6 addresses and User-Agent strings.

With built-in support for **VPN**, **proxy**, **TOR detection**, and **threat detection** (via the IPGeolocation's Security API), this SDK also empowers developers to integrate threat intelligence, personalization, fraud prevention, compliance, and analytics features into Java applications.

Whether you're enriching signup forms with ip geolocation data, localizing content, embedding threat intelligence in back-end systems, or converting time zones and currencies, the SDK ensures seamless, scalable integration with IPGeolocation.io’s global API infrastructure.

## Table of Contents

1. [Installation](#installation)
   - [Maven](#using-maven)
   - [Gradle](#using-gradle)
   - [Manual Installation](#manual-installation)
2. [Authentication Setup](#authentication-setup)
3. [API Endpoints](#api-endpoints)
3. [IP Geolocation Examples](#ip-geolocation-examples)
   - [1. Developer(Free) Plan Examples](#1-developer-plan-examples)
   - [2. Standard Plan Examples](#2-standard-plan-examples)
   - [3. Advanced Plan Examples](#3-advanced-plan-examples)
   - [Bulk IP Geolocation Example](#bulk-ip-geolocation-example)

4. [IP Security Examples](#ip-security-examples)
   - [Basic Request (Minimal Setup)](#basic-request-minimal-setup)
   - [Include Multiple Optional Fields](#include-multiple-optional-fields)
   - [Request with Field Filtering](#request-with-field-filtering)
   - [Bulk IP Security Request](#bulk-ip-security-request)

5. [ASN API Examples](#asn-api-examples)
   - [Get ASN Information by IP Address](#get-asn-information-by-ip-address)
   - [Get ASN Information by ASN Number](#get-asn-information-by-asn-number)
   - [Combine All objects using Include](#combine-all-objects-using-include)

6. [Timezone API Examples](#timezone-api-examples)
   - [Get Timezone by IP Address](#get-timezone-by-ip-address)
   - [Get Timezone by Timezone Name](#get-timezone-by-timezone-name)
   - [Get Timezone from Any Address](#get-timezone-from-any-address)
   - [Get Timezone from Location Coordinates](#get-timezone-from-location-coordinates)
   - [Get Timezone and Airport Details from IATA Code](#get-timezone-and-airport-details-from-iata-code)
   - [Get Timezone and City Details from UN/LOCODE](#get-timezone-and-city-details-from-unlocode)

7. [Timezone Converter Examples](#timezone-converter-examples)
   - [Convert Current Time from One Timezone to Another](#convert-current-time-from-one-timezone-to-another)

8. [User Agent API Examples](#user-agent-api-examples)
   - [Parse a Basic User Agent String](#parse-a-basic-user-agent-string)
   - [Bulk User Agent Parsing Example](#bulk-user-agent-parsing-example)
9. [Astronomy API Examples](#astronomy-api-examples)
   - [Astronomy by Coordinates](#astronomy-by-coordinates)
   - [Astronomy by IP Address](#astronomy-by-ip-address)
   - [Astronomy by Location String](#astronomy-by-location-string)
   - [Astronomy for Specific Date](#astronomy-for-specific-date)
   - [Astronomy in Different Language](#astronomy-in-different-language)

10. [Documentation for Models](#documentation-for-models)


# Installation

## Requirements
- **Java**: 1.8 or higher
- **Build Tools**: Maven 3.8.3+ or Gradle 7.2+

## Using Maven

Add the following dependency to your `pom.xml` file:

```xml
<dependency>
  <groupId>io.ipgeolocation</groupId>
  <artifactId>ipgeolocation</artifactId>
  <version>2.0.1</version>
</dependency>
```

## Using Gradle

Add this to your `build.gradle` file:

```groovy
repositories {
    mavenCentral()
    mavenLocal() // Only needed if using locally built version
}

dependencies {
    implementation "io.ipgeolocation:ipgeolocation:2.0.1"
}
```

## Manual Installation

To build the SDK manually:

```bash
mvn clean package
```

Then include the following JARs in your classpath:
- `target/ipgeolocation-sdk-java-2.0.1.jar`
- All JARs in `target/lib/`

---

# Authentication Setup

To authenticate API requests, you need an API key from [ipgeolocation.io](https://ipgeolocation.io/). Once obtained, configure your API client as follows:

```java
import invoker.io.ipgeolocation.sdk.ApiClient;
import invoker.io.ipgeolocation.sdk.Configuration;
import auth.invoker.io.ipgeolocation.sdk.ApiKeyAuth;

ApiClient client = Configuration.getDefaultApiClient();
client.setBasePath("https://api.ipgeolocation.io/v2");

ApiKeyAuth apiKeyAuth = (ApiKeyAuth) client.getAuthentication("ApiKeyAuth");
apiKeyAuth.setApiKey("YOUR_API_KEY_HERE");
```

Ensure that your API key is securely stored and not exposed in public repositories.

---

# API Endpoints

All URIs are relative to *https://api.ipgeolocation.io/v2*

Class | Method                                                                            | HTTP request | Description
------------ |-----------------------------------------------------------------------------------| ------------- | -------------
*ASNLookupAPI* | [**getAsnDetails**](docs/ASNLookupAPI.md#getasndetails)                           | **GET** /asn | Get details of any ASN number or associated IP address
*AbuseContactAPI* | [**getAbuseContactInfo**](docs/AbuseContactAPI.md#getabusecontactinfo)            | **GET** /abuse | Retrieve abuse reporting contact information for a given IP address
*AstronomyAPI* | [**getAstronomy**](docs/AstronomyAPI.md#getastronomydetails)                      | **GET** /astronomy | Get sunrise, sunset, moonrise, moonset, and related data for a location
*IPGeolocationAPI* | [**getBulkIPGeolocation**](docs/IPGeolocationAPI.md#getbulkipgeolocation)         | **POST** /ipgeo-bulk | Get geolocation data for multiple IP addresses in a single API request
*IPGeolocationAPI* | [**getIPGeolocation**](docs/IPGeolocationAPI.md#getipgeolocation)                 | **GET** /ipgeo | 	Get geolocation data for a single IP address
*IPSecurityAPI* | [**getBulkIPSecurity**](docs/IPSecurityAPI.md#getbulkipsecurity)                  | **POST** /security-bulk | Retrieve security threat intelligence for multiple IPs
*IPSecurityAPI* | [**getIPSecurity**](docs/IPSecurityAPI.md#getipsecurity)                          | **GET** /security | Retrieve security information (VPN, TOR, proxy, etc.) for a single IP
*TimeConversionAPI* | [**convertTimezone**](docs/TimezoneConversionAPI.md#converttimezone)              | **GET** /timezone/convert | Convert time between two specified timezones
*TimezoneAPI* | [**getTimezone**](docs/TimezoneAPI.md#gettimezone)                                | **GET** /timezone | Timezone information details
*UserAgentAPI* | [**getUserAgent**](docs/Api/UserAgentAPI.md#getuseragentdetails)                  | **GET** /user-agent | Get details of user-agent
*UserAgentAPI* | [**getBulkUserAgent**](docs/UserAgentAPI.md#getbulkuseragent)                     | **POST** /user-agent-bulk | Handle multiple user-agent string lookups
*UserAgentAPI* | [**getUserAgentOfCustomString**](docs/UserAgentAPI.md#getuseragentofcustomstring) | **POST** /user-agent | Handle single User-Agent string
---

# Example Usage

## IP Geolocation Examples

This section provides usage examples of the `getIPGeolocation()` method from the SDK across Free, Standard, and Advanced subscription tiers. Each example highlights different combinations of parameters: `fields`, `include`, and `excludes`.

### Parameters

#### `fields`
Use this parameter to include specific fields in the response.

#### `excludes`
Use this parameter to omit specific fields from the response.

#### `include`
Use this parameter to add optional modules to the response, such as:
- `security`
- `user_agent`
- `hostname`
- `liveHostname`
- `hostnameFallbackLive`
- `abuse`
- `dma`
- `timezone`


For complete details, refer to the official documentation: [IP Geolocation API Documentation](https://ipgeolocation.io/ip-location-api.html#documentation-overview)

The `ip` parameter in the SDK can accept any valid IPv4 address, IPv6 address, or domain name. If the `ip()` method is not used or the parameter is omitted, the API will return information about the public IP address of the device or server where the SDK is executed.

### 1. Developer Plan Examples

#### Default Fields

```java
import io.ipgeolocation.sdk.api.IPGeolocationAPI;
import io.ipgeolocation.sdk.model.GeolocationResponse;

IPGeolocationAPI api = new IPGeolocationAPI(client);
GeolocationResponse response = api.getIPGeolocation()
        .ip("8.8.8.8")
        .execute();

System.out.println(response);
```
Sample Response:
```
class GeolocationResponse {
    ip: 8.8.8.8
    location: class Location {
        continentCode: NA
        continentName: North America
        countryCode2: US
        countryCode3: USA
        countryName: United States
        countryNameOfficial: United States of America
        countryCapital: Washington, D.C.
        stateProv: California
        stateCode: US-CA
        district: Santa Clara
        city: Mountain View
        zipcode: 94043-1351
        latitude: 37.42240
        longitude: -122.08421
        isEu: false
        countryFlag: https://ipgeolocation.io/static/flags/us_64.png
        geonameId: 6301403
        countryEmoji: 🇺🇸
    }
    countryMetadata: class CountryMetadata {
        callingCode: +1
        tld: .us
        languages: [en-US, es-US, haw, fr]
    }
    currency: class Currency {
        code: USD
        name: US Dollar
        symbol: $
    }
}
```
Filtering Specific Fields from the Response (Use of 'exclude' and 'fields')
```java
GeolocationResponse response = api.getIPGeolocation()
    .ip("8.8.4.4")
    .fields("location")
    .excludes("location.continent_code,location.continent_name")
    .execute();

System.out.println(response);
```
Sample Response
```
class GeolocationResponse {
    ip: 8.8.4.4
    location: class Location {
        countryCode2: US
        countryCode3: USA
        countryName: United States
        countryNameOfficial: United States of America
        countryCapital: Washington, D.C.
        stateProv: California
        stateCode: US-CA
        district: Santa Clara
        city: Mountain View
        zipcode: 94043-1351
        latitude: 37.42240
        longitude: -122.08421
        isEu: false
        countryFlag: https://ipgeolocation.io/static/flags/us_64.png
        geonameId: 6301403
        countryEmoji: 🇺🇸
    }
}
```

### 2. Standard Plan Examples
#### Default Fields

```java
import io.ipgeolocation.sdk.api.IPGeolocationAPI;
import io.ipgeolocation.sdk.model.GeolocationResponse;

IPGeolocationAPI api = new IPGeolocationAPI(client);
GeolocationResponse response = api.getIPGeolocation()
        .ip("8.8.8.8")
        .execute();

System.out.println(response);
```
Sample Response:
```
class GeolocationResponse {
    ip: 8.8.8.8
    location: class Location {
        continentCode: NA
        continentName: North America
        countryCode2: US
        countryCode3: USA
        countryName: United States
        countryNameOfficial: United States of America
        countryCapital: Washington, D.C.
        stateProv: California
        stateCode: US-CA
        district: Santa Clara
        city: Mountain View
        zipcode: 94043-1351
        latitude: 37.42240
        longitude: -122.08421
        isEu: false
        countryFlag: https://ipgeolocation.io/static/flags/us_64.png
        geonameId: 6301403
        countryEmoji: 🇺🇸
    }
    countryMetadata: class CountryMetadata {
        callingCode: +1
        tld: .us
        languages: [en-US, es-US, haw, fr]
    }
    network: class Network {
        asn: class NetworkAsn {
            asNumber: AS15169
            organization: Google LLC
            country: US
        }
        company: class NetworkCompany {
            name: Google LLC
        }
    }
    currency: class Currency {
        code: USD
        name: US Dollar
        symbol: $
    }
}
```
### Retrieving Geolocation Data in Multiple Languages
Here is an example to get the geolocation data for IP address '2001:4230:4890::1' in French language:
```java
IPGeolocationAPI api = new IPGeolocationAPI(client);
GeolocationResponse response = api.getIPGeolocation()
        .ip("2001:4230:4890::1")
        .lang("fr")
        .execute();

System.out.println(response);
```

Sample Response
```
class GeolocationResponse {
    ip: 2001:4230:4890:0:0:0:0:1
    location: class Location {
        continentCode: AF
        continentName: Afrique
        countryCode2: MU
        countryCode3: MUS
        countryName: Maurice
        countryNameOfficial: 
        countryCapital: Port Louis
        stateProv: Wilhems des plaines
        stateCode: MU-PW
        district: Quatre Bornes
        city: Quatre Bornes
        zipcode: 72201
        latitude: -20.24304
        longitude: 57.49631
        isEu: false
        countryFlag: https://ipgeolocation.io/static/flags/mu_64.png
        geonameId: 1106777
        countryEmoji: 🇲🇺
    }
    countryMetadata: class CountryMetadata {
        callingCode: +230
        tld: .mu
        languages: [en-MU, bho, fr]
    }
    network: class Network {
        asn: class NetworkAsn {
            asNumber: AS0
            organization: 
            country:
        }
        company: class NetworkCompany {
            name: African Network Information Center AfriNIC Ltd
        }
    }
    currency: class Currency {
        code: MUR
        name: Mauritius Rupee
        symbol: ₨
    }
}
```

#### Include HostName, Timezone and User-Agent
```java
IPGeolocationAPI api = new IPGeolocationAPI(client);
GeolocationResponse response = api.getIPGeolocation()
        .ip("4.5.6.7")
        .fields("location.country_name,location.country_capital")
        .include("user_agent, time_zone, hostnameFallbackLive")
        .execute();

System.out.println(response);
```
Sample Response
```
class GeolocationResponse {
    ip: 4.5.6.7
    hostname: 4.5.6.7
    location: class Location {
        countryName: United States
        countryCapital: Washington, D.C.
    }
    timeZone: class TimeZone {
        name: America/Chicago
        offset: -6
        offsetWithDst: -5
        currentTime: 2025-05-28 06:52:16.748-0500
        currentTimeUnix: 1748433136.748
        isDst: true
        dstSavings: 1
        dstExists: true
        dstStart: class TimeZoneDstStart {
            utcTime: 2025-03-09 TIME 08
            duration: +1H
            gap: true
            dateTimeAfter: 2025-03-09 TIME 03
            dateTimeBefore: 2025-03-09 TIME 02
            overlap: false
        }
        dstEnd: class TimeZoneDstEnd {
            utcTime: 2025-11-02 TIME 07
            duration: -1H
            gap: false
            dateTimeAfter: 2025-11-02 TIME 01
            dateTimeBefore: 2025-11-02 TIME 02
            overlap: true
        }
    }
    userAgent: class UserAgentData {
        userAgentString: IPGeolocation/2.0.0/java
        name: IPGeolocation Java SDK
        type: Special
        version: 2.0.0
        versionMajor: 1
        device: class UserAgentDataDevice {
            name: Unknown
            type: Unknown
            brand: Unknown
            cpu: Unknown
        }
        engine: class UserAgentDataEngine {
            name: Unknown
            type: Unknown
            version: ??
            versionMajor: ??
        }
        operatingSystem: class UserAgentDataOperatingSystem {
            name: Unknown
            type: Unknown
            version: ??
            versionMajor: ??
            build: ??
        }
    }
}
```
**Note on Hostname Parameters**

The IP Geolocation API supports hostname lookup for all paid subscriptions. However, this is not included by default. To enable hostname resolution, use the `include` parameter with one of the following options:

- `hostname`: Performs a quick lookup using the internal hostname database. If no match is found, the IP is returned as-is. This is fast but may produce incomplete results.
- `liveHostname`: Queries live sources for accurate hostname resolution. This may increase response time.
- `hostnameFallbackLive`: Attempts the internal database first, and falls back to live sources if no result is found. This option provides a balance of speed and reliability.

### 3. Advanced Plan Examples
#### Include DMA, Abuse and Security

```java
import io.ipgeolocation.sdk.api.IPGeolocationAPI;
import io.ipgeolocation.sdk.model.GeolocationResponse;

IPGeolocationAPI api = new IPGeolocationAPI(client);
GeolocationResponse response = api.getIPGeolocation()
        .ip("8.8.8.8")
        .excludes("location.country_flag,location.country_emoji")
        .include("dma,abuse,security")
        .execute();

System.out.println(response);
```
Sample Response:
```
class GeolocationResponse {
    ip: 8.8.8.8
    location: class Location {
        continentCode: NA
        continentName: North America
        countryCode2: US
        countryCode3: USA
        countryName: United States
        countryNameOfficial: United States of America
        countryCapital: Washington, D.C.
        stateProv: California
        stateCode: US-CA
        district: Santa Clara
        city: Mountain View
        zipcode: 94043-1351
        latitude: 37.42240
        longitude: -122.08421
        isEu: false
        countryFlag: null
        geonameId: 6301403
        countryEmoji: null
        accuracyRadius: 
        locality: Mountain View
        dmaCode: 807
    }
    countryMetadata: class CountryMetadata {
        callingCode: +1
        tld: .us
        languages: [en-US, es-US, haw, fr]
    }
    network: class Network {
        asn: class NetworkAsn {
            asNumber: AS15169
            organization: Google LLC
            country: US
            asnName: GOOGLE
            type: BUSINESS
            domain: about.google
            dateAllocated: 
            allocationStatus: assigned
            numOfIpv4Routes: 965
            numOfIpv6Routes: 104
            rir: ARIN
        }
        connectionType: 
        company: class NetworkCompany {
            name: Google LLC
            type: Business
            domain: googlellc.com
        }
    }
    currency: class Currency {
        code: USD
        name: US Dollar
        symbol: $
    }
    security: class Security {
        threatScore: 0
        isTor: false
        isProxy: false
        proxyType: 
        proxyProvider: 
        isAnonymous: false
        isKnownAttacker: false
        isSpam: false
        isBot: false
        isCloudProvider: false
        cloudProvider: 
    }
    abuse: class Abuse {
        route: 8.8.8.0/24
        country: 
        handle: ABUSE5250-ARIN
        name: Abuse
        organization: Abuse
        role: abuse
        kind: group
        address: 1600 Amphitheatre Parkway
        Mountain View
        CA
        94043
        United States
        emails: [network-abuse@google.com]
        phoneNumbers: [+1-650-253-0000]
    }
}
```
These examples demonstrate typical usage of the IP Geolocation API with different subscription tiers. Use `fields` to specify exactly which data to receive, `include` for optional data like security and user agent, and `excludes` to omit specific keys from the response.

**Note:** All features available in the Free plan are also included in the Standard and Advanced plans. Similarly, all features of the Standard plan are available in the Advanced plan.

## Bulk IP Geolocation Example
The SDK also supports bulk IP geolocation requests using the `getBulkIpGeolocation()` method. All parameters like `fields`, `include`, and `excludes` can also be used in bulk requests.

```java

import io.ipgeolocation.sdk.model.BulkIPRequest;
import io.ipgeolocation.sdk.api.IPGeolocationAPI;
import io.ipgeolocation.sdk.model.BulkGeolocationResponse;

IPGeolocationAPI api = new IPGeolocationAPI(client);

BulkIPRequest bulkRequest = new BulkIPRequest();
bulkRequest.addIp("8.8.8.8");
bulkRequest.addIp("1.1.1.1");

List<BulkGeolocationResponse> response = api.getBulkIPGeolocation()
        .bulkIpRequest(bulkRequest)
        .fields("location.country_name,location.city")
        .include("security,timezone")
        .excludes("location.continent_code")
        .execute();

System.out.println(response);
```

## IP Security Examples

This section provides usage examples of the `getIPSecurity()` method from the SDK across various subscription tiers. Each example demonstrates different ways to query threat intelligence and risk metadata using parameters like fields, excludes, and optional modules.

For full API specifications, refer to the [official IP Security API documentation](https://ipgeolocation.io/ip-security-api.html#documentation-overview).

---

### Basic Request (Minimal Setup)

```java
import io.ipgeolocation.sdk.api.IPSecurityAPI;
import io.ipgeolocation.sdk.model.SecurityAPIResponse;

IPSecurityAPI api = new IPSecurityAPI(client);
SecurityAPIResponse response = api.getIPSecurity()
        .ip("2.56.188.34")
        .execute();

System.out.println(response);
```

Sample Response
```
class SecurityAPIResponse {
    ip: 2.56.188.34
    security: class Security {
        threatScore: 80
        isTor: false
        isProxy: true
        proxyType: VPN
        proxyProvider: Nord VPN
        isAnonymous: true
        isKnownAttacker: true
        isSpam: false
        isBot: false
        isCloudProvider: true
        cloudProvider: Packethub S.A.
    }
}
```
### Include Multiple Optional Fields
```java
SecurityAPIResponse response = api.getIPSecurity()
    .ip("2.56.188.34")
    .include("location,network,currency,time_zone,user_agent,country_metadata,hostname")
    .execute();
```

Sample Response
```
class SecurityAPIResponse {
    ip: 2.56.188.34
    hostname: 2.56.188.34
    security: class Security {
        threatScore: 80
        isTor: false
        isProxy: true
        proxyType: VPN
        proxyProvider: Nord VPN
        isAnonymous: true
        isKnownAttacker: true
        isSpam: false
        isBot: false
        isCloudProvider: true
        cloudProvider: Packethub S.A.
    }
    location: class LocationMinimal {
        continentCode: NA
        continentName: North America
        countryCode2: US
        countryCode3: USA
        countryName: United States
        countryNameOfficial: United States of America
        countryCapital: Washington, D.C.
        stateProv: Texas
        stateCode: US-TX
        district: Dallas County
        city: Dallas
        zipcode: 75207
        latitude: 32.78916
        longitude: -96.82170
        isEu: false
        countryFlag: https://ipgeolocation.io/static/flags/us_64.png
        geonameId: 7181768
        countryEmoji: 🇺🇸
    }
    network: class NetworkMinimal {
        asn: class NetworkMinimalAsn {
            asNumber: AS62240
            organization: Clouvider Limited
            country: GB
        }
        company: class NetworkMinimalCompany {
            name: Packethub S.A.
        }
    }
    timeZone: class TimeZone {
        name: America/Chicago
        offset: -6
        offsetWithDst: -5
        currentTime: 2025-05-29 08:27:44.939-0500
        currentTimeUnix: 1748525264.939
        isDst: true
        dstSavings: 1
        dstExists: true
        dstStart: class TimeZoneDstStart {
            utcTime: 2025-03-09 TIME 08
            duration: +1H
            gap: true
            dateTimeAfter: 2025-03-09 TIME 03
            dateTimeBefore: 2025-03-09 TIME 02
            overlap: false
        }
        dstEnd: class TimeZoneDstEnd {
            utcTime: 2025-11-02 TIME 07
            duration: -1H
            gap: false
            dateTimeAfter: 2025-11-02 TIME 01
            dateTimeBefore: 2025-11-02 TIME 02
            overlap: true
        }
    }
    userAgent: class UserAgentData {
        userAgentString: IPGeolocation/2.0.0/java
        name: IPGeolocation Java SDK
        type: Special
        version: 2.0.0
        versionMajor: 1
        device: class UserAgentDataDevice {
            name: Unknown
            type: Unknown
            brand: Unknown
            cpu: Unknown
        }
        engine: class UserAgentDataEngine {
            name: Unknown
            type: Unknown
            version: ??
            versionMajor: ??
        }
        operatingSystem: class UserAgentDataOperatingSystem {
            name: Unknown
            type: Unknown
            version: ??
            versionMajor: ??
            build: ??
        }
    }
    countryMetadata: class CountryMetadata {
        callingCode: +1
        tld: .us
        languages: [en-US, es-US, haw, fr]
    }
    currency: class Currency {
        code: USD
        name: US Dollar
        symbol: $
    }
}
```
### Request with Field Filtering

```java
SecurityAPIResponse response = api.getIPSecurity()
        .ip("195.154.221.54")
        .fields("is_tor,is_proxy,is_bot,is_spam")
        .execute();

System.out.println(response);
```
Sample Response
```
class SecurityAPIResponse {
    ip: 195.154.221.54
    security: class Security {
        isTor: false
        isProxy: true
        isSpam: false
        isBot: false
    }
}

```
## Bulk IP Security Request
The SDK also supports bulk IP Security requests using the `getBulkIPSecurity()` method. All parameters like `fields`, `include`, and `excludes` can also be used in bulk requests.

```java
import io.ipgeolocation.sdk.model.BulkSecurityResponse;
import io.ipgeolocation.sdk.model.BulkIPRequest;

BulkIPRequest bulkRequest = new BulkIPRequest();
bulkRequest.addIp("2.56.188.34");
bulkRequest.addIp("2.56.188.35");

List<BulkSecurityResponse> response = api.getBulkIPSecurity(bulkIPRequest)
        .include("location,network")
        .fields("security.threat_score,location.country_name")
        .execute();

System.out.println(response);
```
## ASN API Examples

This section provides usage examples of the `getAsnDetails()` method from the SDK. These methods allow developers to retrieve detailed ASN-level network data either by ASN number or by IP address. Note that ASN API is only available in the Advanced subscription plans.

Refer to the [ASN API documentation](https://ipgeolocation.io/asn-api.html#documentation-overview) for a detailed list of supported fields and behaviors.

### Get ASN Information by IP Address

```java
import io.ipgeolocation.sdk.api.AsnLookupAPI;
import io.ipgeolocation.sdk.api.AsnLookupApi;
import io.ipgeolocation.sdk.model.ASNResponse;

AsnLookupAPI api = new AsnLookupAPI(client);

ASNResponse response = api.getAsnDetails()
        .ip("8.8.8.8")
        .execute();

System.out.println(response);
```
Sample Response
```
class ASNResponse {
    ip: 8.8.8.8
    asn: class ASNDetails {
        asNumber: AS15169
        organization: Google LLC
        country: US
        asnName: GOOGLE
        type: BUSINESS
        domain: about.google
        dateAllocated: 
        allocationStatus: assigned
        numOfIpv4Routes: 983
        numOfIpv6Routes: 104
        rir: ARIN
    }
}
```
### Get ASN Information by ASN Number

```java
import io.ipgeolocation.sdk.model.ASNResponse;

ASNResponse response = api.getAsnDetails()
        .asn("AS15169")
        .execute();

System.out.println(response);
```
Sample Response
```
class ASNResponse {
    asn: class ASNDetails {
        asNumber: AS15169
        organization: Google LLC
        country: US
        asnName: GOOGLE
        type: BUSINESS
        domain: about.google
        dateAllocated: 
        allocationStatus: assigned
        numOfIpv4Routes: 983
        numOfIpv6Routes: 104
        rir: ARIN
    }
}
```

### Combine All objects using Include
```java
import io.ipgeolocation.sdk.model.ASNResponse;

ASNResponse response = api.getAsnDetails()
        .asn("AS12")
        .include("peers,downstreams,upstreams,routes,whois_response")
        .execute();

System.out.println(response);
```
Sample Response
```
class ASNResponse {
    ip: null
    asn: class ASNDetails {
        asNumber: AS12
        organization: New York University
        country: US
        asnName: NYU-DOMAIN
        type: EDUCATION
        domain: nyu.edu
        dateAllocated: 
        allocationStatus: assigned
        numOfIpv4Routes: 11
        numOfIpv6Routes: 1
        rir: ARIN
        routes: [192.76.177.0/24, 216.165.96.0/20, 216.165.89.0/24, 216.165.0.0/18, 216.165.112.0/21, 128.122.0.0/16, 2607:f600::/32, 216.165.102.0/24, 216.165.64.0/19, 216.165.120.0/22, 192.86.139.0/24, 216.165.103.0/24]
        upstreams: [class ASNConnection {
            asNumber: AS3269
            description: Telecom Italia S.p.A.
            country: IT
        }, class ASNConnection {
            asNumber: AS8220
            description: COLT Technology Services Group Limited
            country: GB
        }, class ASNConnection {
            asNumber: AS286
            description: GTT Communications Inc.
            country: US
        }, class ASNConnection {
            asNumber: AS3257
            description: GTT Communications Inc.
            country: US
        }, class ASNConnection {
            asNumber: AS3754
            description: NYSERNet
            country: US
        }, class ASNConnection {
            asNumber: AS3356
            description: Level 3 Parent, LLC
            country: US
        }, class ASNConnection {
            asNumber: AS6461
            description: Zayo Bandwidth
            country: US
        }, class ASNConnection {
            asNumber: AS137
            description: Consortium GARR
            country: IT
        }]
        downstreams: [class ASNConnection {
            asNumber: AS394666
            description: NYU Langone Health
            country: US
        }, class ASNConnection {
            asNumber: AS54965
            description: Polytechnic Institute of NYU
            country: US
        }]
        peers: [class ASNConnection {
            asNumber: AS3269
            description: Telecom Italia S.p.A.
            country: IT
        }, class ASNConnection {
            asNumber: AS8220
            description: COLT Technology Services Group Limited
            country: GB
        }, class ASNConnection {
            asNumber: AS394666
            description: NYU Langone Health
            country: US
        }, class ASNConnection {
            asNumber: AS286
            description: GTT Communications Inc.
            country: NL
        }, class ASNConnection {
            asNumber: AS286
            description: GTT Communications Inc.
            country: US
        }, class ASNConnection {
            asNumber: AS3257
            description: GTT Communications Inc.
            country: US
        }, class ASNConnection {
            asNumber: AS3754
            description: NYSERNet
            country: US
        }, class ASNConnection {
            asNumber: AS3356
            description: Level 3 Parent, LLC
            country: US
        }, class ASNConnection {
            asNumber: AS6461
            description: Zayo Bandwidth
            country: US
        }, class ASNConnection {
            asNumber: AS137
            description: Consortium GARR
            country: IT
        }, class ASNConnection {
            asNumber: AS54965
            description: Polytechnic Institute of NYU
            country: US
        }]
        whoisResponse: 
        
        
        ASNumber:       12
        ASName:         NYU-DOMAIN
        ASHandle:       AS12
        RegDate:        1984-07-05
        Updated:        2023-05-25    
        Ref:            https://rdap.arin.net/registry/autnum/12
        
        
        OrgName:        New York University
        OrgId:          NYU-Z
        Address:        726 Broadway, 8th Floor - ITS
        City:           New York
        StateProv:      NY
        PostalCode:     10003
        Country:        US
        RegDate:        2023-05-15
        Updated:        2023-05-15
        Ref:            https://rdap.arin.net/registry/entity/NYU-Z
        
        
        OrgAbuseHandle: OIS9-ARIN
        OrgAbuseName:   Office of Information Security
        OrgAbusePhone:  +1-212-998-3333 
        OrgAbuseEmail:  abuse@nyu.edu
        OrgAbuseRef:    https://rdap.arin.net/registry/entity/OIS9-ARIN
        
        OrgNOCHandle: COSI-ARIN
        OrgNOCName:   Communications Operations Services - ITS
        OrgNOCPhone:  +1-212-998-3444 
        OrgNOCEmail:  noc-cosi-arin@nyu.edu
        OrgNOCRef:    https://rdap.arin.net/registry/entity/COSI-ARIN
        
        OrgTechHandle: COSI-ARIN
        OrgTechName:   Communications Operations Services - ITS
        OrgTechPhone:  +1-212-998-3444 
        OrgTechEmail:  noc-cosi-arin@nyu.edu
        OrgTechRef:    https://rdap.arin.net/registry/entity/COSI-ARIN
        
        RTechHandle: COSI-ARIN
        RTechName:   Communications Operations Services - ITS
        RTechPhone:  +1-212-998-3444 
        RTechEmail:  noc-cosi-arin@nyu.edu
        RTechRef:    https://rdap.arin.net/registry/entity/COSI-ARIN
        
        RNOCHandle: COSI-ARIN
        RNOCName:   Communications Operations Services - ITS
        RNOCPhone:  +1-212-998-3444 
        RNOCEmail:  noc-cosi-arin@nyu.edu
        RNOCRef:    https://rdap.arin.net/registry/entity/COSI-ARIN
               
    }
}
```
## Timezone API Examples

This section provides usage examples of the `getTimezone()` method from the SDK, showcasing how to fetch timezone and time-related data using different query types — IP address, latitude/longitude, and timezone ID.

For full API specifications, refer to the [Timezone API documentation](https://ipgeolocation.io/timezone-api.html#documentation-overview).

### Get Timezone by IP Address

```java
import io.ipgeolocation.sdk.api.TimezoneAPI;
import io.ipgeolocation.sdk.model.TimezoneResponse;

TimezoneAPI api = new TimezoneAPI(client);

TimezoneResponse response = api.getTimezone()
        .ip("8.8.8.8")
        .execute();

System.out.println(response);
```
Sample Response
```
class TimeZoneResponse {
    ip: 8.8.8.8
   
    location: class TimezoneLocation {
        continentCode: NA
        continentName: North America
        countryCode2: US
        countryCode3: USA
        countryName: United States
        countryNameOfficial: United States of America
        isEu: false
        stateProv: California
        stateCode: US-CA
        district: Santa Clara
        city: Mountain View
        locality: null
        zipcode: 94043-1351
        latitude: 37.42240
        longitude: -122.08421
    }
    timeZone: class TimezoneDetails {
        name: America/Los_Angeles
        offset: -8
        offsetWithDst: -7
        date: 2025-06-23
        dateTime: 2025-06-23 02:15:25
        dateTimeTxt: Monday, June 23, 2025 02:15:25
        dateTimeWti: Mon, 23 Jun 2025 02:15:25 -0700
        dateTimeYmd: 2025-06-23T02:15:25-0700
        dateTimeUnix: 1.750670125437E9
        time24: 02:15:25
        time12: 02:15:25 AM
        week: 26
        month: 6
        year: 2025
        yearAbbr: 25
        isDst: true
        dstSavings: 1
        dstExists: true
        dstStart: class TimezoneDetailDstStart {
            utcTime: 2025-03-09 TIME 10
            duration: +1H
            gap: true
            dateTimeAfter: 2025-03-09 TIME 03
            dateTimeBefore: 2025-03-09 TIME 02
            overlap: false
        }
        dstEnd: class TimezoneDetailDstEnd {
            utcTime: 2025-11-02 TIME 09
            duration: -1H
            gap: false
            dateTimeAfter: 2025-11-02 TIME 01
            dateTimeBefore: 2025-11-02 TIME 02
            overlap: true
        }
    }
}
```
### Get Timezone by Timezone Name

```java
import io.ipgeolocation.sdk.model.TimezoneResponse;

TimezoneResponse response = api.getTimezone()
        .tz("Europe/ London")
        .execute();

System.out.println(response);
```
Sample Response
``` 
class TimeZoneResponse {
    timeZone: class TimezoneDetails {
        name: Europe/London
        offset: 0
        offsetWithDst: 1
        date: 2025-06-23
        dateTime: 2025-06-23 10:25:01
        dateTimeTxt: Monday, June 23, 2025 10:25:01
        dateTimeWti: Mon, 23 Jun 2025 10:25:01 +0100
        dateTimeYmd: 2025-06-23T10:25:01+0100
        dateTimeUnix: 1.750670701706E9
        time24: 10:25:01
        time12: 10:25:01 AM
        week: 26
        month: 6
        year: 2025
        yearAbbr: 25
        isDst: true
        dstSavings: 1
        dstExists: true
        dstStart: class TimezoneDetailDstStart {
            utcTime: 2025-03-30 TIME 01
            duration: +1H
            gap: true
            dateTimeAfter: 2025-03-30 TIME 02
            dateTimeBefore: 2025-03-30 TIME 01
            overlap: false
        }
        dstEnd: class TimezoneDetailDstEnd {
            utcTime: 2025-10-26 TIME 01
            duration: -1H
            gap: false
            dateTimeAfter: 2025-10-26 TIME 01
            dateTimeBefore: 2025-10-26 TIME 02
            overlap: true
        }
    }
}
```
### Get Timezone from Any Address

```java
import io.ipgeolocation.sdk.model.TimezoneResponse;

TimezoneResponse response = api.getTimezone()
        .location("Munich, Germany")
        .execute();

System.out.println(response);
```
Sample Response
```
class TimeZoneResponse {
    location: class TimezoneLocation {
        locationString: Munich, Germany
        countryName: Germany
        stateProv: Bavaria
        city: Munich
        locality: 
        latitude: 48.13711
        longitude: 11.57538
    }
    timeZone: class TimezoneDetails {
        name: Europe/Berlin
        offset: 1
        offsetWithDst: 2
        date: 2025-06-23
        dateTime: 2025-06-23 11:35:23
        dateTimeTxt: Monday, June 23, 2025 11:35:23
        dateTimeWti: Mon, 23 Jun 2025 11:35:23 +0200
        dateTimeYmd: 2025-06-23T11:35:23+0200
        dateTimeUnix: 1.750671323755E9
        time24: 11:35:23
        time12: 11:35:23 AM
        week: 26
        month: 6
        year: 2025
        yearAbbr: 25
        isDst: true
        dstSavings: 1
        dstExists: true
        dstStart: class TimezoneDetailDstStart {
            utcTime: 2025-03-30 TIME 01
            duration: +1H
            gap: true
            dateTimeAfter: 2025-03-30 TIME 03
            dateTimeBefore: 2025-03-30 TIME 02
            overlap: false
        }
        dstEnd: class TimezoneDetailDstEnd {
            utcTime: 2025-10-26 TIME 01
            duration: -1H
            gap: false
            dateTimeAfter: 2025-10-26 TIME 02
            dateTimeBefore: 2025-10-26 TIME 03
            overlap: true
        }
    }
}
```
### Get Timezone from Location Coordinates

```java
import io.ipgeolocation.sdk.model.TimezoneResponse;

TimezoneResponse response = api.getTimezone()
        .lat(48.8566F)
        ._long(2.3522F)
        .execute();

System.out.println(response);
```
Sample Response
```
class TimeZoneResponse {
    timeZone: class TimezoneDetails {
        name: Europe/Paris
        offset: 1
        offsetWithDst: 2
        date: 2025-06-23
        dateTime: 2025-06-23 11:53:31
        dateTimeTxt: Monday, June 23, 2025 11:53:31
        dateTimeWti: Mon, 23 Jun 2025 11:53:31 +0200
        dateTimeYmd: 2025-06-23T11:53:31+0200
        dateTimeUnix: 1.750672411295E9
        time24: 11:53:31
        time12: 11:53:31 AM
        week: 26
        month: 6
        year: 2025
        yearAbbr: 25
        isDst: true
        dstSavings: 1
        dstExists: true
        dstStart: class TimezoneDetailDstStart {
            utcTime: 2025-03-30 TIME 01
            duration: +1H
            gap: true
            dateTimeAfter: 2025-03-30 TIME 03
            dateTimeBefore: 2025-03-30 TIME 02
            overlap: false
        }
        dstEnd: class TimezoneDetailDstEnd {
            utcTime: 2025-10-26 TIME 01
            duration: -1H
            gap: false
            dateTimeAfter: 2025-10-26 TIME 02
            dateTimeBefore: 2025-10-26 TIME 03
            overlap: true
        }
    }
}
```
### Get Timezone and Airport Details from IATA Code

```java
import io.ipgeolocation.sdk.model.TimezoneResponse;

TimezoneResponse response = api.getTimezone()
        .iataCode("ZRH")
        .execute();

System.out.println(response);
```
Sample Response
```
class TimeZoneResponse {
    airportDetails: class TimezoneAirport {
        type: large_airport
        name: Zurich Airport
        latitude: 47.45806
        longitude: 8.54806
        elevationFt: 1417
        continentCode: EU
        countryCode: CH
        stateCode: CH-ZH
        city: Zurich
        iataCode: ZRH
        icaoCode: LSZH
        faaCode: 
    }
    timeZone: class TimezoneDetails {
        name: Europe/Zurich
        offset: 1
        offsetWithDst: 2
        date: 2025-06-23
        dateTime: 2025-06-23 12:24:08
        dateTimeTxt: Monday, June 23, 2025 12:24:08
        dateTimeWti: Mon, 23 Jun 2025 12:24:08 +0200
        dateTimeYmd: 2025-06-23T12:24:08+0200
        dateTimeUnix: 1.750674248242E9
        time24: 12:24:08
        time12: 12:24:08 PM
        week: 26
        month: 6
        year: 2025
        yearAbbr: 25
        isDst: true
        dstSavings: 1
        dstExists: true
        dstStart: class TimezoneDetailDstStart {
            utcTime: 2025-03-30 TIME 01
            duration: +1H
            gap: true
            dateTimeAfter: 2025-03-30 TIME 03
            dateTimeBefore: 2025-03-30 TIME 02
            overlap: false
        }
        dstEnd: class TimezoneDetailDstEnd {
            utcTime: 2025-10-26 TIME 01
            duration: -1H
            gap: false
            dateTimeAfter: 2025-10-26 TIME 02
            dateTimeBefore: 2025-10-26 TIME 03
            overlap: true
        }
    }
}
```
Similarly, you can fetch Airport Details and Timezone from using any ICAO code as well

### Get Timezone and City Details from UN/LOCODE

```java
import io.ipgeolocation.sdk.model.TimezoneResponse;

TimezoneResponse response = api.getTimezone()
        .loCode("ESBCN")
        .execute();

System.out.println(response);
```
Sample Response
```
class TimeZoneResponse {
    loCodeDetails: class TimezoneLocode {
        loCode: ESBCN
        city: Barcelona
        stateCode: 
        countryCode: ES
        countryName: 
        locationType: Port, Rail Terminal, Road Terminal, Airport, Postal Exchange
        latitude: 41.38289
        longitude: 2.17743
    }
    timeZone: class TimezoneDetails {
        name: Europe/Madrid
        offset: 1
        offsetWithDst: 2
        date: 2025-06-23
        dateTime: 2025-06-23 12:32:55
        dateTimeTxt: Monday, June 23, 2025 12:32:55
        dateTimeWti: Mon, 23 Jun 2025 12:32:55 +0200
        dateTimeYmd: 2025-06-23T12:32:55+0200
        dateTimeUnix: 1.750674775033E9
        time24: 12:32:55
        time12: 12:32:55 PM
        week: 26
        month: 6
        year: 2025
        yearAbbr: 25
        isDst: true
        dstSavings: 1
        dstExists: true
        dstStart: class TimezoneDetailDstStart {
            utcTime: 2025-03-30 TIME 01
            duration: +1H
            gap: true
            dateTimeAfter: 2025-03-30 TIME 03
            dateTimeBefore: 2025-03-30 TIME 02
            overlap: false
        }
        dstEnd: class TimezoneDetailDstEnd {
            utcTime: 2025-10-26 TIME 01
            duration: -1H
            gap: false
            dateTimeAfter: 2025-10-26 TIME 02
            dateTimeBefore: 2025-10-26 TIME 03
            overlap: true
        }
    }
}
```
## Timezone Converter Examples

This section provides usage examples of the `convertTimezone()` method from the SDK. The Timezone Converter API allows you to convert a specific time from one timezone to another using timezone identifiers and optional date/time inputs.

For more details, refer to official documentation: [Timezone Converter API](https://ipgeolocation.io/timezone-api.html#convert-time-bw-time-zones).

### Convert Current Time from One Timezone to Another

```java
import io.ipgeolocation.sdk.api.TimezoneConversionAPI;
import io.ipgeolocation.sdk.model.TimezoneConversionResponse;

TimezoneConversionAPI api = new TimezoneConversionAPI(client);

TimezoneConversionResponse response = api.convertTimezone()
        .from("America/New_York")
        .to("Asia/Tokyo")
        .execute();

System.out.println(response);
```
Sample Response
```
class TimezoneConversionResponse {
    originalTime: 2024-12-08 11:00
    convertedTime: 2024-12-09 01:00:00
    diffHour: 14.0
    diffMin: 840
}
```
Similarly, you can convert time from any timezone to another timezone using location coordinates (Latitude and Longitude), location addresses, IATA codes, ICAO codes and UN/LUCODE .

## User Agent API Examples

This section provides usage examples of the `getUserAgent()` method from the SDK. The User Agent API extracts and classifies information from user agent strings, including browser, engine, device, OS, and type metadata.

For full explanation, visit the [User Agent API documentation](https://ipgeolocation.io/user-agent-api.html#documentation-overview).

### Parse a Basic User Agent String

```java
import io.ipgeolocation.sdk.api.UserAgentAPI;
import io.ipgeolocation.sdk.model.UserAgentResponse;

UserAgentAPI api = new UserAgentAPI(client);

UserAgentResponse response = api.getUserAgent()
        .userAgentString("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/125.0.0.0 Safari/537.36")
        .execute();

System.out.println(response);
```
Sample Response
```
class UserAgentData {
    userAgentString: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/125.0.0.0 Safari/537.36
    name: Chrome
    type: Browser
    version: 125
    versionMajor: 125
    device: class UserAgentDataDevice {
        name: Desktop
        type: Desktop
        brand: Unknown
        cpu: Intel x86_64
    }
    engine: class UserAgentDataEngine {
        name: Blink
        type: Browser
        version: 125
        versionMajor: 125
    }
    operatingSystem: class UserAgentDataOperatingSystem {
        name: Windows NT
        type: Desktop
        version: ??
        versionMajor: ??
        build: ??
    }
}
```
If you don't pass any userAgentString, the API will return the data of device's user agent.

## Bulk User Agent Parsing Example

The SDK also supports bulk User Agent parsing using the `getBulkUserAgent()` method. This allows parsing multiple user agent strings in a single request. All fields available in single-user-agent parsing are returned per entry.

```java
import io.ipgeolocation.sdk.api.UserAgentAPI;
import io.ipgeolocation.sdk.model.UserAgentBulkRequest;
import io.ipgeolocation.sdk.model.UserAgentData;

UserAgentAPI api = new UserAgentAPI(client);

UserAgentBulkRequest bulkRequest = new UserAgentBulkRequest();
bulkRequest.addUaString("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/125.0.0.0 Safari/537.36");
bulkRequest.addUaString("Mozilla/5.0 (iPhone; CPU iPhone OS 16_0 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/16.0 Mobile/15E148 Safari/604.1");

List<UserAgentData> response = api.getBulkUserAgent()
        .userAgentBulkRequest(bulkRequest)
        .execute();

System.out.println(response);
```

## Astronomy API Examples

This section provides usage examples of the `getAstronomy()` method from the SDK, allowing developers to fetch sun and moon timings and position data based on coordinates, IP, or location string.

Refer to the [official Astronomy API documentation](https://ipgeolocation.io/astronomy-api.html#documentation-overview) for more details.

### Astronomy by Coordinates

```java
import io.ipgeolocation.sdk.api.AstronomyAPI;
import io.ipgeolocation.sdk.model.AstronomyResponse;

AstronomyAPI api = new AstronomyAPI(client);

AstronomyResponse response = api.getAstronomy()
        .lat("40.7128")
        ._long("-74.0060")
        .execute();

System.out.println(response);
```
Sample Response
```
class AstronomyResponse {
    location: class AstronomyLocation {
        countryName:
        stateProv: New York
        city: New York
        locality: 
        latitude: 40.71280
        longitude: -74.00600
        elevation: 6.0
    }
    astronomy: class Astronomy {
        date: 2025-07-22
        currentTime: 05:34:17.046
        midNight: 01:02
        nightEnd: 03:48
        morning: class AstronomyMorning {
            astronomicalTwilightBegin: 03:48
            astronomicalTwilightEnd: 04:32
            nauticalTwilightBegin: 04:32
            nauticalTwilightEnd: 05:12
            civilTwilightBegin: 05:12
            civilTwilightEnd: 05:43
            blueHourBegin: 04:59
            blueHourEnd: 05:24
            goldenHourBegin: 05:24
            goldenHourEnd: 06:23
        }
        sunrise: 05:43
        sunset: 20:21
        evening: class AstronomyEvening {
            goldenHourBegin: 19:41
            goldenHourEnd: 20:40
            blueHourBegin: 20:40
            blueHourEnd: 21:05
            civilTwilightBegin: 20:21
            civilTwilightEnd: 20:52
            nauticalTwilightBegin: 20:52
            nauticalTwilightEnd: 21:31
            astronomicalTwilightBegin: 21:31
            astronomicalTwilightEnd: 22:16
        }
        nightBegin: 22:16
        sunStatus: -
        solarNoon: 13:02
        dayLength: 14:37
        sunAltitude: -2.4240905951150817
        sunDistance: 152012050.75662628
        sunAzimuth: 60.53270916713848
        moonPhase: WANING_CRESCENT
        moonrise: 02:48
        moonset: 19:10
        moonStatus: -
        moonAltitude: 26.687264834949556
        moonDistance: 369857.6483476412
        moonAzimuth: 74.22460131532307
        moonParallacticAngle: -56.08124322972331
        moonIlluminationPercentage: -7.41
        moonAngle: 328.4181377849406
    }
}
```
### Astronomy by IP Address
```java
AstronomyResponse response = api.getAstronomy()
        .ip("8.8.8.8")
        .execute();

System.out.println(response);
```
Sample Response
```
class AstronomyResponse {
    ip: 8.8.8.8
    location: class AstronomyLocation {
        continentCode: NA
        continentName: North America
        countryCode2: US
        countryCode3: USA
        countryName: United States
        countryNameOfficial: United States of America
        isEu: false
        stateProv: California
        stateCode: US-CA
        district: Santa Clara
        city: Mountain View
        locality: Charleston Terrace
        zipcode: 94043-1351
        latitude: 37.42240
        longitude: -122.08421
        elevation: 3.0
    }
    astronomy: class Astronomy {
        date: 2025-07-22
        currentTime: 02:36:01.027
        midNight: 01:15
        nightEnd: 04:18
        morning: class AstronomyMorning {
            astronomicalTwilightBegin: 04:18
            astronomicalTwilightEnd: 04:58
            nauticalTwilightBegin: 04:58
            nauticalTwilightEnd: 05:35
            civilTwilightBegin: 05:35
            civilTwilightEnd: 06:04
            blueHourBegin: 05:23
            blueHourEnd: 05:47
            goldenHourBegin: 05:47
            goldenHourEnd: 06:42
        }
        sunrise: 06:04
        sunset: 20:24
        evening: class AstronomyEvening {
            goldenHourBegin: 19:46
            goldenHourEnd: 20:42
            blueHourBegin: 20:42
            blueHourEnd: 21:05
            civilTwilightBegin: 20:24
            civilTwilightEnd: 20:54
            nauticalTwilightBegin: 20:54
            nauticalTwilightEnd: 21:30
            astronomicalTwilightBegin: 21:30
            astronomicalTwilightEnd: 22:10
        }
        nightBegin: 22:10
        sunStatus: -
        solarNoon: 13:14
        dayLength: 14:20
        sunAltitude: -29.312204242565592
        sunDistance: 152012050.7566263
        sunAzimuth: 21.915241201213632
        moonPhase: WANING_CRESCENT
        moonrise: 03:23
        moonset: 19:16
        moonStatus: -
        moonAltitude: -6.780866431657464
        moonDistance: 369859.5847016905
        moonAzimuth: 45.928379972251605
        moonParallacticAngle: -40.47546867785306
        moonIlluminationPercentage: -7.40
        moonAngle: 328.43423626935555
    }
}
```

### Astronomy by Location String
```java
AstronomyResponse response = api.getAstronomy()
    .location("Milan, Italy")
    .execute();

System.out.println(response);
```
Sample Response
```
class AstronomyResponse {
    location: class AstronomyLocation {
        locationString: Milan, Italy
        countryName: Italy
        stateProv: Lombardy
        city: Milan
        locality: 
        latitude: 45.46419
        longitude: 9.18963
        elevation: 122.0
    }
    astronomy: class Astronomy {
        date: 2025-07-22
        currentTime: 11:37:28.787
        midNight: 01:29
        nightEnd: 03:39
        morning: class AstronomyMorning {
            astronomicalTwilightBegin: 03:39
            astronomicalTwilightEnd: 04:35
            nauticalTwilightBegin: 04:35
            nauticalTwilightEnd: 05:21
            civilTwilightBegin: 05:21
            civilTwilightEnd: 05:54
            blueHourBegin: 05:06
            blueHourEnd: 05:35
            goldenHourBegin: 05:35
            goldenHourEnd: 06:40
        }
        sunrise: 05:54
        sunset: 21:04
        evening: class AstronomyEvening {
            goldenHourBegin: 20:19
            goldenHourEnd: 21:24
            blueHourBegin: 21:24
            blueHourEnd: 21:52
            civilTwilightBegin: 21:04
            civilTwilightEnd: 21:38
            nauticalTwilightBegin: 21:38
            nauticalTwilightEnd: 22:23
            astronomicalTwilightBegin: 22:23
            astronomicalTwilightEnd: 23:18
        }
        nightBegin: 23:18
        sunStatus: -
        solarNoon: 13:29
        dayLength: 15:10
        sunAltitude: 55.76507063803926
        sunDistance: 152012050.7566263
        sunAzimuth: 128.26574664275847
        moonPhase: WANING_CRESCENT
        moonrise: 02:36
        moonset: 19:49
        moonStatus: -
        moonAltitude: 72.39158071193661
        moonDistance: 369861.22005060845
        moonAzimuth: 197.31311454833428
        moonParallacticAngle: 13.735730743087668
        moonIlluminationPercentage: -7.39
        moonAngle: 328.44782327106236
    }
}
```
### Astronomy for Specific Date
```java
AstronomyResponse response = api.getAstronomy()
        .lat("-27.47")
        ._long("153.02")
        .date("2025-01-01")
        .execute();

System.out.println(response);
```
Sample Response
```
class AstronomyResponse {
    location: class AstronomyLocation {
        countryName: Australia
        stateProv: Queensland
        city: Brisbane
        locality: Brisbane
        latitude: -27.47000
        longitude: 153.02000
        elevation: 
    }
    astronomy: class Astronomy {
        date: 2025-01-01
        currentTime: 19:45:17.561
        midNight: 23:51
        nightEnd: 03:24
        morning: class AstronomyMorning {
            astronomicalTwilightBegin: 03:24
            astronomicalTwilightEnd: 03:57
            nauticalTwilightBegin: 03:57
            nauticalTwilightEnd: 04:29
            civilTwilightBegin: 04:29
            civilTwilightEnd: 04:56
            blueHourBegin: 04:19
            blueHourEnd: 04:40
            goldenHourBegin: 04:40
            goldenHourEnd: 05:30
        }
        sunrise: 04:56
        sunset: 18:46
        evening: class AstronomyEvening {
            goldenHourBegin: 18:12
            goldenHourEnd: 19:02
            blueHourBegin: 19:02
            blueHourEnd: 19:23
            civilTwilightBegin: 18:46
            civilTwilightEnd: 19:13
            nauticalTwilightBegin: 19:13
            nauticalTwilightEnd: 19:45
            astronomicalTwilightBegin: 19:45
            astronomicalTwilightEnd: 20:18
        }
        nightBegin: 20:18
        sunStatus: -
        solarNoon: 11:51
        dayLength: 13:50
        sunAltitude: -12.059617608402677
        sunDistance: 147102938.88036567
        sunAzimuth: 235.897971324645
        moonPhase: NEW_MOON
        moonrise: 05:42
        moonset: 20:08
        moonStatus: -
        moonAltitude: 4.6701693782344345
        moonDistance: 380596.5823950267
        moonAzimuth: 244.56945849604378
        moonParallacticAngle: 118.21976701203934
        moonIlluminationPercentage: 2.49
        moonAngle: 18.156495178599695
    }
}
```

### Astronomy in Different Language
You can also get Astronomy Data in other languages as well. Only paid subscriptions can access this feature.
```java
AstronomyResponse response = api.getAstronomy()
        .ip("1.1.1.1")
        .lang("fr")
        .execute();

System.out.println(response);
```
Sample Response
```
class AstronomyResponse {
    ip: 1.1.1.1
    location: class AstronomyLocation {
        continentCode: OC
        continentName: Océanie
        countryCode2: AU
        countryCode3: AUS
        countryName: Australie
        countryNameOfficial: 
        isEu: false
        stateProv: Queensland
        stateCode: AU-QLD
        district: Brisbane
        city: Brisbane Sud
        locality: 
        zipcode: 4101
        latitude: -27.47306
        longitude: 153.01421
        elevation: 
    }
    astronomy: class Astronomy {
        date: 2025-07-22
        currentTime: 19:54:32.920
        midNight: 23:54
        nightEnd: 05:13
        morning: class AstronomyMorning {
            astronomicalTwilightBegin: 05:13
            astronomicalTwilightEnd: 05:41
            nauticalTwilightBegin: 05:41
            nauticalTwilightEnd: 06:09
            civilTwilightBegin: 06:09
            civilTwilightEnd: 06:34
            blueHourBegin: 06:00
            blueHourEnd: 06:19
            goldenHourBegin: 06:19
            goldenHourEnd: 07:08
        }
        sunrise: 06:34
        sunset: 17:14
        evening: class AstronomyEvening {
            goldenHourBegin: 16:40
            goldenHourEnd: 17:29
            blueHourBegin: 17:29
            blueHourEnd: 17:49
            civilTwilightBegin: 17:14
            civilTwilightEnd: 17:39
            nauticalTwilightBegin: 17:39
            nauticalTwilightEnd: 18:07
            astronomicalTwilightBegin: 18:07
            astronomicalTwilightEnd: 18:35
        }
        nightBegin: 18:35
        sunStatus: -
        solarNoon: 11:54
        dayLength: 10:39
        sunAltitude: -35.15165719378359
        sunDistance: 152012050.75662628
        sunAzimuth: 276.2757088601843
        moonPhase: WANING_CRESCENT
        moonrise: 04:04
        moonset: 14:19
        moonStatus: -
        moonAltitude: -66.8771626746063
        moonDistance: 369880.37618917384
        moonAzimuth: 278.66762618741274
        moonParallacticAngle: 93.79636599869248
        moonIlluminationPercentage: -7.32
        moonAngle: 328.6063710418327
    }
}
```
## Abuse Contact API Examples
This section demonstrates how to use the `getAbuseContactInfo()` method of the AbuseContact API. This API helps security teams, hosting providers, and compliance professionals quickly identify the correct abuse reporting contacts for any IPv4 or IPv6 address. You can retrieve data like the responsible organization, role, contact emails, phone numbers, and address to take appropriate mitigation action against abusive or malicious activity.
> **Note**: Abuse Contact API is only available in Advanced Plan

Refer to the official [Abuse Contact API documentation](https://ipgeolocation.io/ip-abuse-contact-api.html#documentation-overview) for details on all available fields.
### Lookup Abuse Contact by IP
```java
import io.ipgeolocation.sdk.api.AbuseContactAPI;
import io.ipgeolocation.sdk.model.AbuseResponse;

AbuseContactAPI api = new AbuseContactAPI(client);

AbuseResponse response = api.getAbuseContactInfo()
        .ip("1.0.0.0")
        .execute();

System.out.println(response);
```
Sample Response:
```
class AbuseResponse {
    ip: 1.0.0.0
    abuse: class Abuse {
        route: 1.0.0.0/24
        country: AU
        handle: IRT-APNICRANDNET-AU
        name: IRT-APNICRANDNET-AU
        organization: 
        role: abuse
        kind: group
        address: PO Box 3646
        South Brisbane, QLD 4101
        Australia
        emails: [helpdesk@apnic.net]
        phoneNumbers: [+61 7 3858 3100]
    }
}
```

### Lookup Abuse Contact with Specific Fields
```java
AbuseResponse response = api.getAbuseContactInfo()
        .ip("1.2.3.4")
        .fields("abuse.role,abuse.emails")
        .execute();

System.out.println(response);
```
Sample Response:
```
class AbuseResponse {
    ip: 1.2.3.4
    abuse: class Abuse {
        role: abuse
        emails: [helpdesk@apnic.net]
    }
}
```
### Lookup Abuse Contact while Excluding Fields
```java
AbuseResponse response = api.getAbuseContactInfo()
        .ip("9.9.9.9")
        .excludes("abuse.handle,abuse.emails")
        .execute();

System.out.println(response);
```
Sample Response:
```
class AbuseResponse {
    ip: 9.9.9.9
    abuse: class Abuse {
        route: 9.9.9.0/24
        country:
        name: Quad9 Abuse
        organization: Quad9 Abuse
        role: abuse
        kind: group
        address: 1442 A Walnut Street Ste 501
        Berkeley
        CA
        94709
        United States
        phoneNumbers: [+1-415-831-3129]
    }
}
```


## Documentation for Models

 - [ASNConnection](docs/ASNConnection.md)
 - [ASNResponse](docs/ASNResponse.md)
 - [ASNDetails](docs/ASNDetails.md)
 - [Abuse](docs/Abuse.md)
 - [AbuseResponse](docs/AbuseResponse.md)
 - [Astronomy](docs/Astronomy.md)
 - [AstronomyEvening](docs/AstronomyEvening.md)
 - [AstronomyLocation](docs/AstronomyLocation.md)
 - [AstronomyMorning](docs/AstronomyMorning.md)
 - [AstronomyResponse](docs/AstronomyResponse.md)
 - [CountryMetadata](docs/CountryMetadata.md)
 - [Currency](docs/Currency.md)
 - [ErrorResponse](docs/ErrorResponse.md)
 - [GeolocationResponse](docs/GeolocationResponse.md)
 - [BulkGeolocationResponse](docs/BulkGeolocationResponse.md)
 - [BulkIPRequest](docs/BulkIPRequest.md)
 - [Location](docs/Location.md)
 - [LocationMinimal](docs/LocationMinimal.md)
 - [Network](docs/Network.md)
 - [NetworkAsn](docs/NetworkAsn.md)
 - [NetworkCompany](docs/NetworkCompany.md)
 - [NetworkMinimal](docs/NetworkMinimal.md)
 - [NetworkMinimalAsn](docs/NetworkMinimalAsn.md)
 - [NetworkMinimalCompany](docs/NetworkMinimalCompany.md)
 - [Security](docs/Security.md)
 - [SecurityAPIResponse](docs/SecurityAPIResponse.md)
 - [BulkSecurityResponse](docs/BulkSecurityResponse.md)
 - [TimeConversionResponse](docs/TimezoneConversionResponse.md)
 - [TimeZone](docs/TimeZone.md)
 - [TimezoneResponse](docs/TimezoneResponse.md)
 - [TimezoneDstEnd](docs/TimezoneDstEnd.md)
 - [TimezoneDstStart](docs/TimeZoneDstStart.md)
 - [TimezoneAirport](docs/TimezoneAirport.md)
 - [TimezoneDetails](docs/TimezoneDetails.md)
 - [TimezoneDetailDstEnd](docs/TimezoneDetailDstEnd.md)
 - [TimezoneDetailDstStart](docs/TimezoneDetailDstStart.md)
 - [TimezoneLocation](docs/TimezoneLocation.md)
 - [TimezoneLocode](docs/TimezoneLocode.md)
 - [UserAgentBulkRequest](docs/UserAgentBulkRequest.md)
 - [UserAgentData](docs/UserAgentData.md)
 - [UserAgentDataDevice](docs/UserAgentDataDevice.md)
 - [UserAgentDataEngine](docs/UserAgentDataEngine.md)
 - [UserAgentDataOperatingSystem](docs/UserAgentDataOperatingSystem.md)
 - [UserAgentPostRequest](docs/UserAgentRequest.md)


