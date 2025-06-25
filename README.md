# ipgeolocation-java-sdk

IPGeolocation.io - IP intelligence products
- API version: 2.0

Ipgeolocation provides a set of APIs to make ip based decisions.

## Table of Contents

1. [Installation](#installation)
   - [Maven](#maven)
   - [Gradle](#gradle)
   - [Manual Installation](#manual-installation)
2. [Authentication Setup](#authentication-setup)

3. [IP Geolocation Examples](#ip-geolocation-examples)
   - [1. Basic Plan Examples](#1-basic-plan-examples)
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
  <version>2.0.0</version>
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
    implementation "io.ipgeolocation:ipgeolocation:2.0.0"
}
```

## Manual Installation

To build the SDK manually:

```bash
mvn clean package
```

Then include the following JARs in your classpath:
- `target/ipgeolocation-sdk-java-2.0.0.jar`
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

### 1. Basic Plan Examples

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
        userAgentString: OpenAPI-Generator/1.0.0/java
        name: OpenAPI-Generator
        type: Special
        version: 1.0.0
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
        userAgentString: OpenAPI-Generator/1.0.0/java
        name: OpenAPI-Generator
        type: Special
        version: 1.0.0
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
import io.ipgeolocation.sdk.api.TimezoneAPI;
import io.ipgeolocation.sdk.model.TimezoneConversionResponse;

TimezoneAPI api = new TimezoneAPI(client);

TimezoneConversionResponse response = api.convertTimezone()
        .from("America/New_York")
        .to("Asia/Tokyo")
        .execute();

System.out.println(response);
```
Sample Response
```
class TimeConversionResponse {
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
        .lat(40.7128F)
        ._long(-74.0060F)
        .execute();

System.out.println(response);
```
Sample Response
```
class AstronomyResponse {
    location: class TimezoneLocation {
        latitude: 40.71280
        longitude: -74.00600
    }
    astronomy: class Astronomy {
        date: 2025-06-24
        currentTime: 07:30:21.579
        sunrise: 05:26
        sunset: 20:31
        sunStatus: -
        solarNoon: 12:58
        dayLength: 15:05
        sunAltitude: 20.804246588855296
        sunDistance: 152040201.01537988
        sunAzimuth: 76.49892606690912
        moonrise: 04:03
        moonset: 20:23
        moonStatus: -
        moonAltitude: 34.414214378812524
        moonDistance: 364347.463373039
        moonAzimuth: 80.61208284060893
        moonParallacticAngle: -57.93796259578105
        moonPhase: NEW_MOON
        moonIlluminationPercentage: -1.31
        moonAngle: 346.8453135834885
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
        zipcode: 94043-1351
        latitude: 37.42240
        longitude: -122.08421
    }
    astronomy: class Astronomy {
        date: 2025-06-24
        currentTime: 04:34:28.021
        sunrise: 05:48
        sunset: 20:33
        sunStatus: -
        solarNoon: 13:10
        dayLength: 14:45
        sunAltitude: -12.617167576625503
        sunDistance: 152040201.01537988
        sunAzimuth: 46.86985777464207
        moonrise: 04:37
        moonset: 20:30
        moonStatus: -
        moonAltitude: -0.21211874350402243
        moonDistance: 364352.7073377457
        moonAzimuth: 53.468292502889824
        moonParallacticAngle: -46.31833060135301
        moonPhase: NEW_MOON
        moonIlluminationPercentage: -1.30
        moonAngle: 346.8846229043112
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
    location: class TimezoneLocation {
        locationString: Milan, Italy
        countryName: Italy
        stateProv: Lombardy
        city: Milan
        locality: 
        latitude: 45.46419
        longitude: 9.18963
    }
    astronomy: class Astronomy {
        date: 2025-06-24
        currentTime: 13:42:31.494
        sunrise: 05:35
        sunset: 21:16
        sunStatus: -
        solarNoon: 13:25
        dayLength: 15:41
        sunAltitude: 67.67235422430544
        sunDistance: 152040201.01537988
        sunAzimuth: 190.14730820895687
        moonrise: 03:55
        moonset: 20:58
        moonStatus: -
        moonAltitude: 67.12458191571332
        moonDistance: 364363.02827482205
        moonAzimuth: 226.96305382114292
        moonParallacticAngle: 35.51972222628293
        moonPhase: NEW_MOON
        moonIlluminationPercentage: -1.29
        moonAngle: 346.9617371469379
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
    location: class TimezoneLocation {
        latitude: -27.47000
        longitude: 153.02000
    }
    astronomy: class Astronomy {
        date: 2025-01-01
        currentTime: 21:52:17.735
        sunrise: 04:56
        sunset: 18:46
        sunStatus: -
        solarNoon: 11:51
        dayLength: 13:50
        sunAltitude: -31.926446962587317
        sunDistance: 147102938.8803657
        sunAzimuth: 212.6674132050822
        moonrise: 05:42
        moonset: 20:08
        moonStatus: -
        moonAltitude: -18.400463391101542
        moonDistance: 380312.3006037494
        moonAzimuth: 228.6071219705199
        moonParallacticAngle: 133.10083951250047
        moonPhase: NEW_MOON
        moonIlluminationPercentage: 2.80
        moonAngle: 19.261001616778085
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
    location: class TimezoneLocation {
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
        locality: null
        zipcode: 4101
        latitude: -27.47306
        longitude: 153.01421
    }
    astronomy: class Astronomy {
        date: 2025-06-24
        currentTime: 21:58:05.865
        sunrise: 06:38
        sunset: 17:02
        sunStatus: -
        solarNoon: 11:50
        dayLength: 10:24
        sunAltitude: -64.35374526473097
        sunDistance: 152040201.0153799
        sunAzimuth: 267.19451980250926
        moonrise: 05:11
        moonset: 15:31
        moonStatus: -
        moonAltitude: -77.90471534790521
        moonDistance: 364383.09958533326
        moonAzimuth: 276.0819890304232
        moonParallacticAngle: 90.30849575969972
        moonPhase: NEW_MOON
        moonIlluminationPercentage: -1.26
        moonAngle: 347.1107575290927
    }
}
```


## Documentation for Models

 - [ASNConnection](docs/ASNConnection.md)
 - [ASNResponse](docs/ASNResponse.md)
 - [ASNDetails](docs/ASNDetails.md)
 - [Abuse](docs/Abuse.md)
 - [Astronomy](docs/Astronomy.md)
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
 - [TimeConversionResponse](docs/TimeConversionResponse.md)
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


