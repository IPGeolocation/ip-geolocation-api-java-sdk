# IPGeolocation Java SDK for the IPGeolocation API

[![Maven Central](https://img.shields.io/maven-central/v/io.ipgeolocation/ipgeolocation?label=Maven%20Central)](https://central.sonatype.com/artifact/io.ipgeolocation/ipgeolocation)
[![Java 8+](https://img.shields.io/badge/Java-8%2B-orange)](https://openjdk.org/)
[![Build](https://img.shields.io/badge/Build-Maven-C71A36)](https://maven.apache.org/)
[![Endpoints](https://img.shields.io/badge/Endpoints-%2Fv3%2Fipgeo%20%2B%20%2Fv3%2Fipgeo--bulk-1F6FEB)](https://ipgeolocation.io/documentation/ip-location-api.html)
[![License](https://img.shields.io/badge/License-MIT-111111)](https://opensource.org/license/mit/)
[![API Docs](https://img.shields.io/badge/API%20Docs-IPGeolocation-0052CC)](https://ipgeolocation.io/documentation/ip-location-api.html)
[![Website](https://img.shields.io/badge/Website-ipgeolocation.io-117A37)](https://ipgeolocation.io/)

## Overview
The official Java SDK for the [IPGeolocation API](https://ipgeolocation.io/documentation/ip-location-api.html). Use `/v3/ipgeo` and `/v3/ipgeo-bulk` to get IP geolocation, company and ASN data, timezone and network data, hostname and abuse details, browser and device details, and security signals from one API call. Security signals include VPN detection, proxy detection, threat score, Tor detection, attacker flags, and cloud or data center IP checks.

This SDK supports IPv4, IPv6, and domain lookups, typed Java response classes, raw JSON or XML output, and response metadata including credits charged and request duration.

## At a Glance

| Item | Value |
|------|-------|
| SDK Name | IPGeolocation Java SDK |
| API Type | IPGeolocation API |
| Supported Endpoints | `/v3/ipgeo`, `/v3/ipgeo-bulk` |
| Supported Inputs | IPv4, IPv6, domain |
| Main Data Returned | Geolocation, company, ASN, timezone, security, abuse, hostname, user-agent, network, currency |
| Pricing | Free plan available; paid plans for higher limits and extra modules |
| Authentication | API key, request origin allowlisting for `/v3/ipgeo` only |
| Response Formats | Typed JSON, raw JSON, raw XML |
| Bulk Limit | Up to 50,000 IPs or domains per request |
| Java Requirement | 8+ |
| API Version | 3.0 |

**Official Release**

- Available on [Maven Central](https://central.sonatype.com/artifact/io.ipgeolocation/ipgeolocation)
- Source code on [GitHub](https://github.com/IPGeolocation/ip-geolocation-api-java-sdk)

## Table of Contents

- [Requirements](#requirements)
- [Installation](#installation)
- [Get Your API Key](#get-your-api-key)
- [Quick Start](#quick-start)
- [What You Can Get From One API Call](#what-you-can-get-from-one-api-call)
- [Common Use Cases](#common-use-cases)
- [Security and Risk Signals](#security-and-risk-signals)
- [Supported Endpoints](#supported-endpoints)
- [Authentication Modes](#authentication-modes)
- [Plan Features and Limits](#plan-features-and-limits)
- [Client Configuration](#client-configuration)
- [Available Methods](#available-methods)
- [Request Options](#request-options)
- [Single Lookup Examples](#single-lookup-examples)
- [Raw JSON and XML Methods](#raw-json-and-xml-methods)
- [Bulk Lookup Examples](#bulk-lookup-examples)
- [Advanced Configuration](#advanced-configuration)
- [Error Handling](#error-handling)
- [Troubleshooting](#troubleshooting)
- [FAQ](#faq)
- [Links](#links)

## Requirements

| Item | Value |
|------|-------|
| Java | 8+ |
| Maven | 3.8+ |

## Installation

### Maven

```xml
<dependency>
  <groupId>io.ipgeolocation</groupId>
  <artifactId>ipgeolocation</artifactId>
  <version>3.0.0</version>
</dependency>
```

### Gradle (Groovy)

```gradle
dependencies {
  implementation 'io.ipgeolocation:ipgeolocation:3.0.0'
}
```

### Gradle (Kotlin)

```kotlin
dependencies {
  implementation("io.ipgeolocation:ipgeolocation:3.0.0")
}
```

### Build From Source

```bash
git clone https://github.com/IPGeolocation/ip-geolocation-api-java-sdk.git
cd ip-geolocation-api-java-sdk
mvn clean install
```

## Get Your API Key

To use the SDK, create or access your IPGeolocation account and copy an API key from your dashboard.

1. Sign up: [https://app.ipgeolocation.io/signup](https://app.ipgeolocation.io/signup)
2. If you signed up with email, verify your email address when prompted.
3. Sign in: [https://app.ipgeolocation.io/login](https://app.ipgeolocation.io/login)
4. Open your dashboard: [https://app.ipgeolocation.io/dashboard](https://app.ipgeolocation.io/dashboard)
5. Copy an API key from the `API Keys` section
6. Use that key in `IpGeolocationClientConfig.builder("YOUR_API_KEY")`

> [!TIP]
> For backend applications, store your API key in an environment variable or secret manager.
> For browser-based single lookups on paid plans, use request origin allowlisting instead of exposing an API key in frontend code.

## Quick Start

```java
import io.ipgeolocation.sdk.ApiResponse;
import io.ipgeolocation.sdk.IpGeolocationClient;
import io.ipgeolocation.sdk.IpGeolocationClientConfig;
import io.ipgeolocation.sdk.LookupIpGeolocationRequest;
import io.ipgeolocation.sdk.model.IpGeolocationResponse;

IpGeolocationClientConfig config = IpGeolocationClientConfig.builder("YOUR_API_KEY").build();

try (IpGeolocationClient client = new IpGeolocationClient(config)) {
  ApiResponse<IpGeolocationResponse> result = client.lookupIpGeolocation(
      LookupIpGeolocationRequest.builder()
          .ip("8.8.8.8")
          .build());

  System.out.println("IP: " + result.data().ip());

  if (result.data().location() != null) {
    System.out.println("Country: " + result.data().location().countryName());
    System.out.println("City: " + result.data().location().city());
  }

  if (result.data().timeZone() != null) {
    System.out.println("Timezone: " + result.data().timeZone().name());
  }
}
```

> [!TIP]
> Start with the default response, then add `include(...)` values such as `security`, `abuse`, `hostname`, `user_agent`, `geo_accuracy`, or `dma_code` when you need more data.

## What You Can Get From One API Call

| Data Set | How To Request It | Common Use Cases |
|----------|-------------------|------------------|
| IP geolocation | Default response | IP geolocation lookup, localization, geo targeting |
| Company and ASN | Default response | ASN lookup, ISP lookup, ownership enrichment, network analysis |
| Timezone | Default response | Local time lookup, scheduling, regional reporting |
| Network and currency | Default response | Routing context, analytics, pricing workflows |
| Security and risk signals | `include("security")` | VPN detection, proxy detection, fraud prevention, threat analysis |
| Abuse contact data | `include("abuse")` | Incident response, abuse handling, reporting |
| Hostname data | `include("hostname")`, `include("liveHostname")`, `include("hostnameFallbackLive")` | Reverse DNS lookup, infrastructure enrichment, hosting checks |
| User-agent data | `include("user_agent")` with `userAgent(...)` | Browser detection, device detection, traffic analysis |
| Geo accuracy and DMA data | `include("geo_accuracy")`, `include("dma_code")` | Local targeting, media market mapping, proximity analysis |

## Common Use Cases

- VPN detection and proxy detection for login, signup, and payment screening
- Threat score checks and IP risk signals for fraud prevention
- ASN lookup, ISP lookup, and company enrichment for B2B traffic analysis
- Browser, device, and operating system detection with `include=user_agent`
- Abuse contact lookups for investigation and incident response
- Hostname and reverse DNS enrichment for infrastructure visibility
- Bulk IP enrichment for analytics pipelines, SIEM workflows, ad verification, and security operations

## Security and Risk Signals

Request `include("security")` to receive the `security` object. This adds the signals most teams search for when they need VPN detection, proxy detection, threat score data, anonymous IP checks, or data center IP detection from the same API call.

| Search Use Case | SDK Fields |
|-----------------|-----------|
| VPN detection | `isVpn()`, `vpnProviderNames()`, `vpnConfidenceScore()`, `vpnLastSeen()` |
| Proxy detection | `isProxy()`, `proxyProviderNames()`, `proxyConfidenceScore()`, `proxyLastSeen()` |
| Residential proxy detection | `isResidentialProxy()` |
| Tor detection | `isTor()` |
| Anonymous IP detection | `isAnonymous()` |
| Threat score and risk scoring | `threatScore()` |
| Bot, spam, and attacker signals | `isBot()`, `isSpam()`, `isKnownAttacker()` |
| Relay detection | `isRelay()`, `relayProviderName()` |
| Cloud, hosting, or data center IP detection | `isCloudProvider()`, `cloudProviderName()` |

Provider names, confidence scores, and last-seen dates are returned when the API has supporting evidence for the matched VPN, proxy, relay, or hosting signal.

## Supported Endpoints

This SDK supports the IPGeolocation API endpoints below.

| Endpoint | HTTP Method | SDK Methods | Primary Use Case |
|----------|-------------|-------------|------------------|
| `/v3/ipgeo` | `GET` | `lookupIpGeolocation(...)`, `lookupIpGeolocationRaw(...)` | Single IPv4, IPv6, or domain lookup |
| `/v3/ipgeo-bulk` | `POST` | `bulkLookupIpGeolocation(...)`, `bulkLookupIpGeolocationRaw(...)` | Bulk lookup for up to 50,000 IPs or domains |

> [!NOTE]
> Through these two endpoints, the API can return geolocation, company, ASN, timezone, hostname, user-agent, abuse, network, currency, and security data depending on your request parameters and plan.

## Authentication Modes

| Mode | SDK Setup | Typical Use |
|------|-----------|-------------|
| API key query param | `IpGeolocationClientConfig.builder("YOUR_API_KEY")` | Server-side API calls |
| Request origin allowlisting | `IpGeolocationClientConfig.builder()` | Single lookup with `/v3/ipgeo` on paid plans |

> [!WARNING]
> Request origin allowlisting does not work with `/v3/ipgeo-bulk`.
> Bulk lookup always requires an API key in the client configuration.
> The API key is sent as the `apiKey` query parameter because that is how our IPGeolocation API authenticates these endpoints, so avoid logging full request URLs in application logs.

## Plan Features and Limits

Feature availability depends on your plan and request parameters. The table below matches the current live API behavior for `/v3/ipgeo` and `/v3/ipgeo-bulk`.

Features marked **Paid only** return `401 Unauthorized` (`UnauthorizedException`) on free plans.

| Capability | Free Plan | Paid Plan |
|------------|-----------|-----------|
| IPv4 and IPv6 single lookup | Supported | Supported |
| Domain lookup | Paid only | Supported |
| Bulk endpoint `/v3/ipgeo-bulk` | Paid only | Supported, but always requires an API key |
| `.include("*")` | Accepted, returns the default response only | Accepted, returns all available modules |
| `include=security`, `abuse`, `hostname`, `liveHostname`, `hostnameFallbackLive`, `geo_accuracy`, `dma_code`, `user_agent` | Paid only | Supported |
| Non-English `lang` | Paid only | Supported |
| `fields` and `excludes` | Supported | Supported |

### Free Plan Example

```java
ApiResponse<IpGeolocationResponse> freeResponse = client.lookupIpGeolocation(
    LookupIpGeolocationRequest.builder()
        .ip("8.8.8.8")
        .include("*")
        .fields("location.country_name")
        .excludes("currency")
        .build());
```

### Paid Plan Example

```java
ApiResponse<IpGeolocationResponse> paidResponse = client.lookupIpGeolocation(
    LookupIpGeolocationRequest.builder()
        .ip("ipgeolocation.io")
        .lang(io.ipgeolocation.sdk.Language.DE)
        .include("security")
        .include("abuse")
        .include("user_agent")
        .include("hostnameFallbackLive")
        .build());
```

> [!CAUTION]
> Bulk lookup does not support request origin allowlisting. `/v3/ipgeo-bulk` always requires an API key in the client configuration.

## Client Configuration

| Builder Method | Type | Default | Notes |
|----------------|------|---------|-------|
| `apiKey(String)` | `String` | `null` if omitted | Required unless using request origin allowlisting for `/v3/ipgeo` |
| `baseUrl(String)` | `String` | `https://api.ipgeolocation.io` | Trailing slash is trimmed |
| `connectTimeout(Duration)` | `Duration` | `10s` | Must be greater than zero and less than or equal to `readTimeout` |
| `readTimeout(Duration)` | `Duration` | `30s` | Must be greater than zero |

> [!IMPORTANT]
> `connectTimeout` must be less than or equal to `readTimeout`.

```java
import java.time.Duration;

IpGeolocationClientConfig config = IpGeolocationClientConfig.builder("YOUR_API_KEY")
    .baseUrl("https://api.ipgeolocation.io")
    .connectTimeout(Duration.ofSeconds(10))
    .readTimeout(Duration.ofSeconds(30))
    .build();
```

## Available Methods

### Single Lookup

| Method | Return Type | Notes |
|--------|-------------|-------|
| `lookupIpGeolocation(request)` | `ApiResponse<IpGeolocationResponse>` | Typed body plus metadata |
| `lookupIpGeolocationRaw(request)` | `ApiResponse<String>` | Raw JSON or XML plus metadata |

### Bulk Lookup

| Method | Return Type | Notes |
|--------|-------------|-------|
| `bulkLookupIpGeolocation(request)` | `ApiResponse<List<BulkLookupResult>>` | Typed bulk result plus metadata |
| `bulkLookupIpGeolocationRaw(request)` | `ApiResponse<String>` | Raw JSON or XML plus metadata |

## Request Options

### Single Lookup Query Parameters

| Builder Method | API Param | Type | Default | Notes |
|----------------|-----------|------|---------|-------|
| `ip(String)` | `ip` | `String` | omitted | IPv4, IPv6, or domain. Blank is treated as omitted and resolves to the caller IP. |
| `lang(Language)` | `lang` | `Language` | API default `en` | Non-English requires a paid plan |
| `include(String)` | `include` | repeatable `String` | none | Sent as comma-separated values |
| `fields(String)` | `fields` | repeatable `String` | none | Sent as comma-separated values |
| `excludes(String)` | `excludes` | repeatable `String` | none | Sent as comma-separated values |
| `output(ResponseFormat)` | `output` | `ResponseFormat` | `JSON` | Typed methods are JSON only. Raw methods support JSON and XML |

Language values supported by `.lang(...)`:

- `Language.EN` for English
- `Language.DE` for German
- `Language.RU` for Russian
- `Language.JA` for Japanese
- `Language.FR` for French
- `Language.CN` for Chinese Simplified
- `Language.ES` for Spanish
- `Language.CS` for Czech
- `Language.IT` for Italian
- `Language.KO` for Korean
- `Language.FA` for Persian
- `Language.PT` for Portuguese

Dot-separated field paths can be passed to `.fields(...)` and `.excludes(...)` to control which parts of the response are returned.

- `.fields(...)` returns only the specified fields or objects.
- `.excludes(...)` removes the specified fields or objects from the response.

### `include` Supported Values

| Value | Adds to Response | Extra Credits |
|-------|------------------|---------------|
| `security` | `security` object with threat score, VPN detection, proxy detection, Tor detection, anonymous IP signals, residential proxy signals, bot and spam signals, attacker flags, relay detection, and cloud or hosting or data center IP identification | +2 |
| `abuse` | `abuse` object | +1 |
| `geo_accuracy` | `location.locality`, `location.accuracy_radius`, `location.confidence` | 0 |
| `dma_code` | `location.dma_code` | 0 |
| `user_agent` | `user_agent` object with browser, device, operating system, and engine details | 0 |
| `hostname` | `hostname` via local source | 0 |
| `liveHostname` | `hostname` via live DNS | 0 |
| `hostnameFallbackLive` | `hostname` with fallback strategy | 0 |
| `*` | All available modules for the plan | +3 |

> [!NOTE]
> When you request `include=security`, the API can return fields such as `threat_score`, `is_vpn`, `vpn_provider_names`, `vpn_confidence_score`, `is_proxy`, `proxy_provider_names`, `proxy_confidence_score`, `is_tor`, `is_anonymous`, `is_residential_proxy`, `is_known_attacker`, `is_bot`, `is_spam`, `is_relay`, `relay_provider_name`, `is_cloud_provider`, and `cloud_provider_name`.

### Single Lookup Header Parameters

| Builder Method | API Header | Type | Default | Notes |
|----------------|------------|------|---------|-------|
| `userAgent(String)` | `User-Agent` | `String` | omitted | Per-request override for `.include("user_agent")` requests |

### Bulk Lookup Body, Query, and Header Parameters

| Builder Method | API Field or Param | Type | Required | Notes |
|----------------|--------------------|------|----------|-------|
| `addIp(String)` | body `ips[]` | `String` | Yes | Adds one IP or domain |
| `ips(List<String>)` | body `ips[]` | `List<String>` | Yes | Replaces the current list |
| `lang(Language)` | query `lang` | `Language` | No | Same behavior as single lookup |
| `include(String)` | query `include` | repeatable `String` | No | Sent as comma-separated values |
| `fields(String)` | query `fields` | repeatable `String` | No | Sent as comma-separated values |
| `excludes(String)` | query `excludes` | repeatable `String` | No | Sent as comma-separated values |
| `output(ResponseFormat)` | query `output` | `ResponseFormat` | No | Typed methods are JSON only. Raw methods support JSON and XML |
| `userAgent(String)` | header `User-Agent` | `String` | No | Per-request override for `include=user_agent` requests |

> [!IMPORTANT]
> Bulk lookup validation rules:
> - Client config must include an API key
> - `ips` must not be empty
> - Maximum `ips` size is 50,000
> - Request origin allowlisting is not supported for `/v3/ipgeo-bulk`

## Single Lookup Examples

All examples below assume the following client setup:

```java
IpGeolocationClient client = new IpGeolocationClient(
    IpGeolocationClientConfig.builder("YOUR_API_KEY").build());
```

### Full Enrichment Example

```java
LookupIpGeolocationRequest request = LookupIpGeolocationRequest.builder()
    .ip("8.8.8.8")
    .include("security")
    .include("abuse")
    .include("user_agent")
    .userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_2) AppleWebKit/601.3.9 (KHTML, like Gecko) Version/9.0.2 Safari/601.3.9")
    .build();

ApiResponse<IpGeolocationResponse> response = client.lookupIpGeolocation(request);

System.out.println("IP: " + response.data().ip());
System.out.println("Country: " + response.data().location().countryName());
System.out.println("Timezone: " + response.data().timeZone().name());
System.out.println("Threat Score: " + response.data().security().threatScore());
System.out.println("VPN: " + response.data().security().isVpn());
System.out.println("Proxy: " + response.data().security().isProxy());
System.out.println("Browser: " + response.data().userAgent().name());
System.out.println("OS: " + response.data().userAgent().operatingSystem().name());
System.out.println("Credits: " + response.metadata().creditsCharged());
```

### `ip`

```java
LookupIpGeolocationRequest request = LookupIpGeolocationRequest.builder()
    .ip("2607:fb91:16c6:8860:e531:2d1d:4944:6c7c")
    .build();

ApiResponse<IpGeolocationResponse> response = client.lookupIpGeolocation(request);
System.out.println(response.data().ip());
```

### `lang`

```java
LookupIpGeolocationRequest request = LookupIpGeolocationRequest.builder()
    .ip("8.8.8.8")
    .lang(io.ipgeolocation.sdk.Language.DE)
    .build();

ApiResponse<IpGeolocationResponse> response = client.lookupIpGeolocation(request);
System.out.println(response.data().location().countryName());
```

### `include`

```java
LookupIpGeolocationRequest request = LookupIpGeolocationRequest.builder()
    .ip("8.8.8.8")
    .include("security")
    .include("abuse")
    .build();

ApiResponse<IpGeolocationResponse> response = client.lookupIpGeolocation(request);
System.out.println(response.data().security().threatScore());
System.out.println(response.data().security().isVpn());
System.out.println(response.data().security().isProxy());
System.out.println(response.data().abuse());
```

### `userAgent`

```java
LookupIpGeolocationRequest request = LookupIpGeolocationRequest.builder()
    .ip("91.128.103.196")
    .include("user_agent")
    .userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_2) AppleWebKit/601.3.9 (KHTML, like Gecko) Version/9.0.2 Safari/601.3.9")
    .build();

ApiResponse<IpGeolocationResponse> response = client.lookupIpGeolocation(request);
System.out.println(response.data().userAgent().name());
System.out.println(response.data().userAgent().operatingSystem().name());
```

### `fields`

```java
LookupIpGeolocationRequest request = LookupIpGeolocationRequest.builder()
    .ip("8.8.8.8")
    .fields("location.country_name")
    .fields("asn.organization")
    .build();

ApiResponse<IpGeolocationResponse> response = client.lookupIpGeolocation(request);
```

> [!TIP]
> Use `fields` when you want a smaller response and a more focused payload.

### `excludes`

```java
LookupIpGeolocationRequest request = LookupIpGeolocationRequest.builder()
    .ip("8.8.8.8")
    .excludes("currency")
    .excludes("time_zone")
    .build();

ApiResponse<IpGeolocationResponse> response = client.lookupIpGeolocation(request);
```

### `output`

Typed methods are JSON only.

```java
try {
  client.lookupIpGeolocation(
      LookupIpGeolocationRequest.builder()
          .ip("8.8.8.8")
          .output(ResponseFormat.XML)
          .build());
} catch (io.ipgeolocation.sdk.exceptions.ValidationException ex) {
  System.out.println(ex.getMessage());
}
```

Raw methods support XML and return raw response text:

```java
ApiResponse<String> xml = client.lookupIpGeolocationRaw(
    LookupIpGeolocationRequest.builder()
        .ip("8.8.8.8")
        .output(ResponseFormat.XML)
        .build());

System.out.println(xml.data());
```

## Raw JSON and XML Methods

Use raw methods when you want the server response body exactly as returned.

| Method | `output` parameter | `data()` Type | Result |
|--------|--------------------|---------------|--------|
| `lookupIpGeolocation(...)` | omitted or `ResponseFormat.JSON` | `IpGeolocationResponse` | Typed parse |
| `lookupIpGeolocation(...)` | `ResponseFormat.XML` | N/A | `ValidationException` |
| `lookupIpGeolocationRaw(...)` | omitted or `ResponseFormat.JSON` | `String` | Raw JSON |
| `lookupIpGeolocationRaw(...)` | `ResponseFormat.XML` | `String` | Raw XML |
| `bulkLookupIpGeolocation(...)` | omitted or `ResponseFormat.JSON` | `List<BulkLookupResult>` | Typed parse |
| `bulkLookupIpGeolocation(...)` | `ResponseFormat.XML` | N/A | `ValidationException` |
| `bulkLookupIpGeolocationRaw(...)` | omitted or `ResponseFormat.JSON` | `String` | Raw JSON |
| `bulkLookupIpGeolocationRaw(...)` | `ResponseFormat.XML` | `String` | Raw XML |

### Single Raw JSON Example

```java
ApiResponse<String> rawJson = client.lookupIpGeolocationRaw(
    LookupIpGeolocationRequest.builder()
        .ip("8.8.8.8")
        .output(ResponseFormat.JSON)
        .build());

System.out.println(rawJson.data());
System.out.println(rawJson.metadata().statusCode());
System.out.println(rawJson.metadata().creditsCharged());
```

### Single Raw XML Example

```java
ApiResponse<String> rawXml = client.lookupIpGeolocationRaw(
    LookupIpGeolocationRequest.builder()
        .ip("8.8.8.8")
        .output(ResponseFormat.XML)
        .build());

System.out.println(rawXml.data());
System.out.println(rawXml.metadata().statusCode());
System.out.println(rawXml.metadata().firstHeaderValue("Content-Type"));
```

### Bulk Raw JSON Example

```java
ApiResponse<String> rawBulkJson = client.bulkLookupIpGeolocationRaw(
    BulkLookupIpGeolocationRequest.builder()
        .addIp("8.8.8.8")
        .addIp("1.1.1.1")
        .output(ResponseFormat.JSON)
        .build());

System.out.println(rawBulkJson.data());
System.out.println(rawBulkJson.metadata().creditsCharged());
```

### Bulk Raw XML Example

```java
ApiResponse<String> rawBulkXml = client.bulkLookupIpGeolocationRaw(
    BulkLookupIpGeolocationRequest.builder()
        .addIp("8.8.8.8")
        .addIp("invalid-ip")
        .output(ResponseFormat.XML)
        .build());

System.out.println(rawBulkXml.data());
System.out.println(rawBulkXml.metadata().statusCode());
System.out.println(rawBulkXml.metadata().rawHeaders());
```

## Bulk Lookup Examples

### Bulk With All Valid Inputs

```java
import io.ipgeolocation.sdk.model.BulkLookupResult;
import java.util.List;

BulkLookupIpGeolocationRequest request = BulkLookupIpGeolocationRequest.builder()
    .addIp("8.8.8.8")
    .addIp("1.1.1.1")
    .build();

ApiResponse<List<BulkLookupResult>> response = client.bulkLookupIpGeolocation(request);
System.out.println("Count: " + response.data().size());
System.out.println("Credits: " + response.metadata().creditsCharged());
```

### Bulk With Mixed Valid and Invalid Inputs

```java
import io.ipgeolocation.sdk.model.BulkLookupError;
import io.ipgeolocation.sdk.model.BulkLookupResult;
import io.ipgeolocation.sdk.model.BulkLookupSuccess;
import java.util.List;

BulkLookupIpGeolocationRequest request = BulkLookupIpGeolocationRequest.builder()
    .addIp("8.8.8.8")
    .addIp("invalid-ip")
    .addIp("1.1.1.1")
    .build();

ApiResponse<List<BulkLookupResult>> results = client.bulkLookupIpGeolocation(request);

for (BulkLookupResult item : results.data()) {
  if (item instanceof BulkLookupSuccess) {
    BulkLookupSuccess success = (BulkLookupSuccess) item;
    System.out.println("OK: " + success.item().ip());
  } else if (item instanceof BulkLookupError) {
    BulkLookupError error = (BulkLookupError) item;
    System.out.println("ERR: " + error.message());
  }
}
```

> [!TIP]
> Prefer bulk lookup when you are processing larger datasets or batched enrichment jobs.

## Advanced Configuration

### Response Metadata

All lookup methods return `ApiResponse<T>`.

`ApiResponse<T>` contains:

- `data()`
- `metadata()`

`ApiResponseMetadata` fields:

| Field | Type | Description |
|-------|------|-------------|
| `statusCode` | `int` | Final HTTP response status |
| `durationMs` | `long` | Total request duration |
| `creditsCharged` | `Integer` | Parsed from `X-Credits-Charged` when present |
| `successfulRecords` | `Integer` | Parsed from `X-Successful-Record` for bulk responses |
| `rawHeaders` | `Map<String, List<String>>` | Immutable raw response header map |

Header helper methods:

| Method | Return Type | Description |
|--------|-------------|-------------|
| `headerValues("Header-Name")` | `List<String>` | Case-insensitive header lookup for all values |
| `firstHeaderValue("Header-Name")` | `String` | Case-insensitive header lookup for the first value |

```java
ApiResponse<IpGeolocationResponse> response = client.lookupIpGeolocation(
    LookupIpGeolocationRequest.builder().ip("8.8.8.8").build());

System.out.println("Status: " + response.metadata().statusCode());
System.out.println("Duration ms: " + response.metadata().durationMs());
System.out.println("Credits: " + response.metadata().creditsCharged());
System.out.println("Raw X-Credits-Charged: "
    + response.metadata().firstHeaderValue("X-Credits-Charged"));
```

The client always sends SDK-managed `User-Agent` and `Accept` headers. Bulk requests also send `Content-Type: application/json`.

### JSON Output Modes

Use `JsonOutput` for logs or CLI output. By default, it omits `null` fields from the API response.

| Mode | Behavior |
|------|----------|
| `JsonOutputMode.COMPACT` | Omits `null` fields |
| `JsonOutputMode.FULL` | Includes `null` fields |

```java
import io.ipgeolocation.sdk.JsonOutput;
import io.ipgeolocation.sdk.JsonOutputMode;

String compact = JsonOutput.toPrettyJson(response.data());
String full = JsonOutput.toPrettyJson(response.data(), JsonOutputMode.FULL);
```

## Error Handling

All SDK exceptions extend `IpGeolocationException`.

| HTTP Status | Exception |
|-------------|-----------|
| 400 | `BadRequestException` |
| 401 | `UnauthorizedException` |
| 404 | `NotFoundException` |
| 405 | `MethodNotAllowedException` |
| 413 | `PayloadTooLargeException` |
| 415 | `UnsupportedMediaTypeException` |
| 423 | `LockedException` |
| 429 | `RateLimitException` |
| 499 | `ClientClosedRequestException` |
| 5xx | `ServerErrorException` |
| Other non-2xx | `ApiException` |

```java
import io.ipgeolocation.sdk.exceptions.RateLimitException;
import io.ipgeolocation.sdk.exceptions.UnauthorizedException;

try {
  client.lookupIpGeolocation(LookupIpGeolocationRequest.builder().build());
} catch (UnauthorizedException ex) {
  System.err.println("Unauthorized: " + ex.apiMessage());
} catch (RateLimitException ex) {
  System.err.println("Rate limit: " + ex.apiMessage());
}
```

## Troubleshooting

| Symptom | Likely Cause | What To Do |
|---------|--------------|------------|
| `IllegalArgumentException: connectTimeout must be <= readTimeout` | Invalid timeout relation | Set connect timeout less than or equal to read timeout |
| `ValidationException` for XML with typed methods | Typed methods are JSON only | Use `lookupIpGeolocationRaw(...)` or `bulkLookupIpGeolocationRaw(...)` for XML |
| `ValidationException: bulk lookup requires apiKey in client config` | Bulk client config has no API key | Configure `IpGeolocationClientConfig` with an API key |
| `ValidationException: ips must not be empty` | Bulk body has no entries | Add at least one IP or domain |
| `ValidationException: ips must contain at most 50000 entries` | Bulk request is too large | Split the request into smaller chunks |
| `UnauthorizedException` | Missing or invalid key, or plan limitation | Verify your key and requested features |
| `RateLimitException` | Usage or billing condition | Review account usage and plan status |
| `LockedException` | Bogon IP address was queried | Use a valid public IP address |
| `BadRequestException` | Provided IP address is not valid | Use a valid public IP address |

For the full list of API-side errors, see the [IPGeolocation API error codes documentation](https://ipgeolocation.io/documentation/ip-location-api.html#error-codes).

## FAQ

### Can this Java SDK return VPN detection, proxy detection, and threat score data?

Yes. Use `include("security")` with `/v3/ipgeo` or `/v3/ipgeo-bulk` to receive the `security` object. That object can contain threat score, VPN detection, proxy detection, Tor detection, anonymous IP checks, residential proxy signals, bot and spam signals, known attacker signals, relay detection, and cloud or data center IP identification.

### Can I get geolocation, company, ASN, timezone, and security data in one API call?

Yes. A single request can return geolocation, company, ASN, timezone, network, and currency data by default, and you can add more modules such as `security`, `abuse`, `hostname`, and `user_agent` with `include(...)`.

### Does the SDK support domain lookup?

Yes, but domain lookup requires a paid API plan. On free plans, the live API currently returns `401 Unauthorized` for domain lookups.

### Does the SDK support bulk IP enrichment?

Yes. Use `/v3/ipgeo-bulk` through `bulkLookupIpGeolocation(...)` or `bulkLookupIpGeolocationRaw(...)`. Bulk requests support up to 50,000 IPs or domains per request and always require an API key.

### Can I request raw XML instead of typed JSON?

Yes. Use `lookupIpGeolocationRaw(...)` or `bulkLookupIpGeolocationRaw(...)` with `output(ResponseFormat.XML)`. Typed methods are JSON only.

### How do I get user-agent details such as browser, device, and operating system?

Use `include("user_agent")` and set the request `User-Agent` header with `.userAgent(...)`. The API can then return browser, device, operating system, and rendering engine details in the `user_agent` object.

### What does `include("*")` return?

On free plans, `include("*")` returns the default response. On paid plans, it returns all modules available to your plan for that request.

### Can I use request origin allowlisting for bulk lookup?

No. Request origin allowlisting works only for `/v3/ipgeo` on paid plans. `/v3/ipgeo-bulk` requires an API key.

## Links

- [IPGeolocation Website](https://ipgeolocation.io/)
- [IPGeolocation Java SDK on GitHub](https://github.com/IPGeolocation/ip-geolocation-api-java-sdk)
- [IPGeolocation API Documentation](https://ipgeolocation.io/documentation/ip-location-api.html)
- [IPGeolocation API Credits and Usage](https://ipgeolocation.io/documentation/credits-usage.html)
- [IPGeolocation API Authentication Methods](https://ipgeolocation.io/documentation/api-authentication.html)
- [IPGeolocation API Response Formats](https://ipgeolocation.io/documentation/api-response-formats.html)
- [IPGeolocation API Plans and Pricing](https://ipgeolocation.io/pricing.html)
- [IPGeolocation Java SDK on Maven Central](https://central.sonatype.com/artifact/io.ipgeolocation/ipgeolocation)
