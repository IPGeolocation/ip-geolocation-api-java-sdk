# IPGeolocation Java SDK for the IP Geolocation API

[![Maven Central](https://img.shields.io/maven-central/v/io.ipgeolocation/ipgeolocation?label=Maven%20Central)](https://mvnrepository.com/artifact/io.ipgeolocation/ipgeolocation/latest)
[![Java 21+](https://img.shields.io/badge/Java-21%2B-orange)](https://openjdk.org/)
[![Build Tool](https://img.shields.io/badge/build-Maven-C71A36)](https://maven.apache.org/)
[![API Scope](https://img.shields.io/badge/API-IP%20Geolocation%20API-0A7B83)](https://ipgeolocation.io/documentation/ip-location-api.html)
[![Endpoints](https://img.shields.io/badge/endpoints-%2Fv3%2Fipgeo%20%2B%20%2Fv3%2Fipgeo--bulk-1F6FEB)](https://ipgeolocation.io/documentation/ip-location-api.html)
[![License](https://img.shields.io/badge/license-Proprietary-111111)](https://ipgeolocation.io/tos.html)
[![Documentation](https://img.shields.io/badge/docs-IP%20Geolocation%20API-0052CC)](https://ipgeolocation.io/documentation/ip-location-api.html)
[![Website](https://img.shields.io/badge/website-ipgeolocation.io-117A37)](https://ipgeolocation.io/)

## Overview
The official **Java SDK** for **[IPGeolocation.io](https://ipgeolocation.io)** provides typed access to the **IP Geolocation API**. It supports **single IP lookup** through `/v3/ipgeo` and **bulk IP lookup** through `/v3/ipgeo-bulk` for **IPv4**, **IPv6**, and **domain** inputs.

Use this SDK when you need **IP geolocation data** in Java applications, including **location**, **network**, **timezone**, **currency**, **ASN**, **company**, **security**, **abuse**, **hostname**, and **user-agent** data returned by `/v3/ipgeo` and `/v3/ipgeo-bulk`.

It fits backend services, fraud prevention, analytics, compliance, personalization, and enrichment pipelines that need typed responses, raw JSON or XML access, and clear exception handling.

This version supports only the **Unified IPGeolocation API** endpoints `/v3/ipgeo` and `/v3/ipgeo-bulk`. Dedicated endpoint families are not included in this release.

## At a Glance

| Item | Value |
|------|-------|
| SDK Name | IPGeolocation Java SDK |
| API Scope | IP Geolocation API |
| Supported Endpoints | `/v3/ipgeo`, `/v3/ipgeo-bulk` |
| Supported Inputs | IPv4, IPv6, domain |
| Authentication | API key, request origin allowlisting for `/v3/ipgeo` only |
| Response Formats | Typed JSON, raw JSON, raw XML |
| Bulk Limit | Up to 50,000 IPs or domains per request |
| Java Requirement | 21+ |
| API Version | 3.0 |

**Official Release:**
- Available on [**Maven Central**](https://mvnrepository.com/artifact/io.ipgeolocation/ipgeolocation/latest)
- Source Code: [**GitHub Repository**](https://github.com/IPGeolocation/ip-geolocation-api-java-sdk)

## Table of Contents
- [Requirements](#requirements)
- [Installation](#installation)
- [Supported Endpoints](#supported-endpoints)
- [Quick Start](#quick-start)
- [Authentication Modes](#authentication-modes)
- [Free and Paid Plan Paths](#free-and-paid-plan-paths)
- [Client Configuration (Core)](#client-configuration-core)
- [Available Methods](#available-methods)
  - [Single Lookup](#single-lookup)
  - [Bulk Lookup](#bulk-lookup)
- [Request Parameters](#request-parameters)
- [Single Lookup Parameter Examples](#single-lookup-parameter-examples)
- [Raw Response Methods](#raw-response-methods)
  - [Single Raw JSON Example](#single-raw-json-example)
  - [Single Raw XML Example](#single-raw-xml-example)
  - [Bulk Raw JSON Example](#bulk-raw-json-example)
  - [Bulk Raw XML Example](#bulk-raw-xml-example)
- [Bulk Examples](#bulk-examples)
  - [Bulk With All Valid Inputs](#bulk-with-all-valid-inputs)
  - [Bulk With Mixed Valid and Invalid Inputs](#bulk-with-mixed-valid-and-invalid-inputs)
- [Advanced Configuration](#advanced-configuration)
  - [Response Metadata](#response-metadata)
  - [JSON Output Modes](#json-output-modes)
- [Error Handling](#error-handling)
- [Plan Behavior (Free vs Paid)](#plan-behavior-free-vs-paid)
- [Troubleshooting](#troubleshooting)
- [Links](#links)

## Why This SDK
- Java 21+ SDK for the IP Geolocation API
- Single lookup and bulk lookup support for IPv4, IPv6, and domain names
- Typed request builders and response models for this SDK
- Access to location, network, currency, timezone, ASN, company, security, abuse, hostname, and user-agent data through the unified endpoint
- Raw JSON and XML response methods when typed parsing is not required
- Clear validation rules for authentication, bulk request limits, and output formats
- Typed API exceptions mapped by HTTP status
- Response metadata for status, duration, usage counters, and raw headers

## Requirements

| Item        | Value                  |
|-------------|------------------------|
| Java        | 21+                    |
| Maven       | 3.8+                   |

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
git clone https://github.com/IPGeolocation/ip-geolocation-api-java-sdk
cd ip-geolocation-api-java-sdk
mvn -q clean install
```

After `mvn install`, your local Maven repository contains version `3.0.0` and you can use the same dependency coordinates shown above.

## Supported Endpoints

This SDK currently supports the Unified IPGeolocation API endpoints below.

| Endpoint         | HTTP Method | SDK Methods                                                                 | Primary Use Case                              |
|------------------|-------------|------------------------------------------------------------------------------|-----------------------------------------------|
| `/v3/ipgeo`      | `GET`       | `lookupIpGeolocation(...)`, `lookupIpGeolocationRaw(...)`                   | Single IPv4, IPv6, or domain lookup           |
| `/v3/ipgeo-bulk` | `POST`      | `bulkLookupIpGeolocation(...)`, `bulkLookupIpGeolocationRaw(...)`           | Bulk lookup for up to 50,000 IPs or domains   |

> [!NOTE]
> Scope of this version:
> - Supported: the Unified IPGeolocation API endpoints listed above
> - Not included: dedicated endpoint families outside `/v3/ipgeo` and `/v3/ipgeo-bulk`

## Quick Start

```java
import io.ipgeolocation.sdk.IpGeolocationClient;
import io.ipgeolocation.sdk.IpGeolocationClientConfig;
import io.ipgeolocation.sdk.LookupIpGeolocationRequest;
import io.ipgeolocation.sdk.ApiResponse;
import io.ipgeolocation.sdk.model.IpGeolocationResponse;

IpGeolocationClientConfig config = IpGeolocationClientConfig.builder("YOUR_API_KEY").build();

try (IpGeolocationClient client = new IpGeolocationClient(config)) {
  ApiResponse<IpGeolocationResponse> result = client.lookupIpGeolocation(
      LookupIpGeolocationRequest.builder()
          .ip("8.8.8.8")
          .include("*")
          .build());

  System.out.println("IP: " + result.data().ip());
  if (result.data().location() != null) {
    System.out.println("Country: " + result.data().location().countryName());
    System.out.println("City: " + result.data().location().city());
  }
  System.out.println("Credits: " + result.metadata().creditsCharged());
  System.out.println("Typed Response: " + result.data());
} catch (Exception e) {
  System.err.println("Request failed: " + e.getMessage());
}
```

## Authentication Modes

| Mode                        | SDK Setup                                           | Typical Use                             |
|-----------------------------|-----------------------------------------------------|-----------------------------------------|
| API key query param         | `IpGeolocationClientConfig.builder("YOUR_API_KEY")` | Server-side API calls                   |
| Request origin allowlisting | `IpGeolocationClientConfig.builder()`               | Single lookup (`/v3/ipgeo`) only on paid plan |

## Free and Paid Plan Paths

### Free Plan Path

Use this path if you are on the free plan.

Supported:
- IPv4 and IPv6 single lookup
- `fields` and `excludes`
- `include=*` (accepted, returns base/default response)

Not supported on free plan:
- domain lookup
- bulk endpoint
- non-`*` include values such as `security` or `abuse`
- non-English `lang`

> [!CAUTION]
> On the free plan, `/v3/ipgeo-bulk`, domain lookup, non-`*` include modules, and non-English `lang` are not available.

```java
var freeResponse = client.lookupIpGeolocation(
    LookupIpGeolocationRequest.builder()
        .ip("8.8.8.8")
        .include("*")
        .fields("location.country_name")
        .excludes("currency")
        .build());
```

### Paid Plan Path

Use this path if you need domain lookup, enrichment modules, localization, bulk lookup, and everything included in the free plan.

Supported:
- domain lookup (`.ip("ipgeolocation.io")`)
- bulk endpoint (`/v3/ipgeo-bulk`)
- non-`*` include values (`security`, `abuse`, `user_agent`, and others)
- non-English `lang`

```java
var paidResponse = client.lookupIpGeolocation(
    LookupIpGeolocationRequest.builder()
        .ip("ipgeolocation.io")
        .lang(Language.DE)
        .include("security")
        .include("abuse")
        .build());
```

## Client Configuration (Core)

These are the configuration options for the client.

| Builder Method             | Type       | Default                        | Notes                                                               |
|----------------------------|------------|--------------------------------|---------------------------------------------------------------------|
| `apiKey(String)`           | `String`   | `null` if omitted              | Required unless using request origin allowlisting                   |
| `baseUrl(String)`          | `String`   | `https://api.ipgeolocation.io` | Not Required, trailing slash is trimmed                             |
| `connectTimeout(Duration)` | `Duration` | `10s`                          | Not Required, must be greater than zero and less than `readTimeout` |
| `readTimeout(Duration)`    | `Duration` | `30s`                          | Not Required, must be greater than zero                             |

> [!IMPORTANT]
> Validation rule:
> - `connectTimeout <= readTimeout`

```java
import java.time.Duration;

IpGeolocationClientConfig config = IpGeolocationClientConfig.builder("YOUR_API_KEY")
    .baseUrl("https://api.ipgeolocation.io")
    .connectTimeout(Duration.ofSeconds(10))
    .readTimeout(Duration.ofSeconds(30))
    .build();
```

> [!WARNING]
> Request-origin allowlisting applies only to `/v3/ipgeo`.
> You can omit the API key only for single lookup requests when the request origin domain is whitelisted on a paid plan.
> `/v3/ipgeo-bulk` always requires an API key.

## Available Methods

> [!NOTE]
> What This SDK Supports:
> `/v3/ipgeo` and `/v3/ipgeo-bulk` only.

### Single Lookup

| Method                            | Return Type                          | Notes                           |
|-----------------------------------|--------------------------------------|---------------------------------|
| `lookupIpGeolocation(request)`    | `ApiResponse<IpGeolocationResponse>` | Typed body plus metadata        |
| `lookupIpGeolocationRaw(request)` | `ApiResponse<String>`                | Raw JSON/XML body plus metadata |

### Bulk Lookup

| Method                                | Return Type                           | Notes                           |
|---------------------------------------|---------------------------------------|---------------------------------|
| `bulkLookupIpGeolocation(request)`    | `ApiResponse<List<BulkLookupResult>>` | Typed bulk result plus metadata |
| `bulkLookupIpGeolocationRaw(request)` | `ApiResponse<String>`                 | Raw JSON/XML body plus metadata |

## Request Parameters

### Single Lookup Query Parameters

#### `LookupIpGeolocationRequest.builder()` options

| Builder Method           | API Param  | Type                | Default          | Notes                                                                      |
|--------------------------|------------|---------------------|------------------|----------------------------------------------------------------------------|
| `ip(String)`             | `ip`       | `String`            | omitted          | IPv4, IPv6, or domain. Blank is treated as omitted and resolves to the caller IP. |
| `lang(Language)`         | `lang`     | `Language`          | API default `en` | Non-English requires paid plan                                             |
| `include(String)`        | `include`  | repeatable `String` | none             | Sent to the API as comma-separated values                                  |
| `fields(String)`         | `fields`   | repeatable `String` | none             | Sent to the API as comma-separated values                                  |
| `excludes(String)`       | `excludes` | repeatable `String` | none             | Sent to the API as comma-separated values                                  |
| `output(ResponseFormat)` | `output`   | `ResponseFormat`    | `JSON`           | Typed methods use JSON only. Raw methods support JSON and XML              |


Available enum values to pass in `.lang(...)` on paid plans for location fields translation are:
- `Language.EN` - English (default)
- `Language.DE` - German
- `Language.RU` - Russian
- `Language.JA` - Japanese
- `Language.FR` - French
- `Language.CN` - Chinese Simplified
- `Language.ES` - Spanish
- `Language.CS` - Czech
- `Language.IT` - Italian
- `Language.KO` - Korean
- `Language.FA` - Persian (Farsi)
- `Language.PT` - Portuguese

Dot-separated field paths can be passed to `.fields(...)` and `.excludes(...)` to control which parts of the response are returned.
- `.fields(...)` returns only the specified fields or objects.
- `.excludes(...)` removes the specified fields or objects from the response.

#### `include` supported values

| Value                  | Adds to Response                                                       | Extra Credits |
|------------------------|------------------------------------------------------------------------|---------------|
| `security`             | `security` object                                                      | +2            |
| `abuse`                | `abuse` object                                                         | +1            |
| `geo_accuracy`         | `location.locality`, `location.accuracy_radius`, `location.confidence` | 0             |
| `dma_code`             | `location.dma_code`                                                    | 0             |
| `user_agent`           | `user_agent` object                                                    | 0             |
| `hostname`             | `hostname` via local source                                            | 0             |
| `liveHostname`         | `hostname` via live DNS                                                | 0             |
| `hostnameFallbackLive` | `hostname` with fallback strategy                                      | 0             |
| `*`                    | All modules (free plan returns base response only)                     | +3            |

> [!NOTE]
> `include=user_agent` behavior:
> - If the request `User-Agent` header is passed through `userAgent(...)`, that value is parsed.
> - If the request `User-Agent` header is not passed, the API parses the caller machine or application user agent.

### Single Lookup Header Parameters

| Builder Method      | API Header   | Type     | Default | Notes                                                      |
|---------------------|--------------|----------|---------|------------------------------------------------------------|
| `userAgent(String)` | `User-Agent` | `String` | omitted | Per-request override for `.include("user_agent")` requests |

### Bulk Lookup Body, Query, and Header Parameters

`BulkLookupIpGeolocationRequest.builder()` options:

| Builder Method           | API Field/Param  | Type                | Required | Notes                                                         |
|--------------------------|------------------|---------------------|----------|---------------------------------------------------------------|
| `addIp(String)`          | body `ips[]`     | `String`            | Yes      | Adds one IP/domain                                            |
| `ips(List<String>)`      | body `ips[]`     | `List<String>`      | Yes      | Replaces current list                                         |
| `lang(Language)`         | query `lang`     | `Language`          | No       | Same behavior as single lookup                                |
| `include(String)`        | query `include`  | repeatable `String` | No       | Sent to the API as comma-separated values                     |
| `fields(String)`         | query `fields`   | repeatable `String` | No       | Sent to the API as comma-separated values                     |
| `excludes(String)`       | query `excludes` | repeatable `String` | No       | Sent to the API as comma-separated values                     |
| `output(ResponseFormat)` | query `output`   | `ResponseFormat`    | No       | Typed methods use JSON only. Raw methods support JSON and XML |

Bulk request header options:

| Builder Method      | API Header   | Type     | Required | Notes                                                  |
|---------------------|--------------|----------|----------|--------------------------------------------------------|
| `userAgent(String)` | `User-Agent` | `String` | No       | Per-request override for `include=user_agent` requests |


> [!IMPORTANT]
> Bulk lookup validation rules:
> - Client config must include an API key.
> - `ips` must not be empty.
> - Maximum `ips` size is 50,000.
> - Request-origin allowlisting is not supported for `/v3/ipgeo-bulk`.

## Single Lookup Parameter Examples

All examples below assume the following client setup:

```java
IpGeolocationClient client = new IpGeolocationClient(
        IpGeolocationClientConfig.builder("YOUR_API_KEY").build());
```

### `ip` Example

```java
var request = LookupIpGeolocationRequest.builder()
    .ip("2607:fb91:16c6:8860:e531:2d1d:4944:6c7c")
    .build();

var response = client.lookupIpGeolocation(request);
System.out.println(response.data().ip());
```

Expected: returned `ip` matches the lookup target.

### `lang` Example

```java
var request = LookupIpGeolocationRequest.builder()
    .ip("8.8.8.8")
    .lang(Language.DE)
    .build();

var response = client.lookupIpGeolocation(request);
System.out.println(response.data().location().countryName());
```

Expected: localized values are returned when the plan supports the selected language.

### `include` Example

```java
var request = LookupIpGeolocationRequest.builder()
    .ip("8.8.8.8")
    .include("security")
    .include("abuse")
    .build();

var response = client.lookupIpGeolocation(request);
System.out.println(response.data().security());
System.out.println(response.data().abuse());
```

Expected: `security` and `abuse` objects are present in the typed response.

### User-Agent Header Example

```java
var request = LookupIpGeolocationRequest.builder()
    .ip("91.128.103.196")
    .include("user_agent")
    .userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_2) AppleWebKit/601.3.9 (KHTML, like Gecko) Version/9.0.2 Safari/601.3.9")
    .build();

var response = client.lookupIpGeolocation(request);
System.out.println(response.data().userAgent().userAgentString());
```

Expected: `user_agent` is parsed from the forwarded visitor header value.

### `fields` Example

```java
var request = LookupIpGeolocationRequest.builder()
    .ip("8.8.8.8")
    .fields("location.country_name")
    .fields("asn.organization")
    .build();

var response = client.lookupIpGeolocation(request);
```

Expected: response contains only requested fields plus mandatory `ip`.

> [!TIP]
> Use `fields` to reduce response size and improve request time.

### `excludes` Example

```java
var request = LookupIpGeolocationRequest.builder()
    .ip("8.8.8.8")
    .excludes("currency")
    .excludes("time_zone")
    .build();

var response = client.lookupIpGeolocation(request);
```

Expected: excluded fields and objects are not returned in the payload.

### `output` Example

Typed methods are JSON only.

```java
assertThrows(
    io.ipgeolocation.sdk.exceptions.ValidationException.class,
    () -> client.lookupIpGeolocation(
        LookupIpGeolocationRequest.builder()
            .ip("8.8.8.8")
            .output(ResponseFormat.XML)
            .build()));
```

Expected: `ValidationException` with message that XML is not supported by typed methods.

Raw methods support XML and return raw response text:

```java
var xml = client.lookupIpGeolocationRaw(
    LookupIpGeolocationRequest.builder()
        .ip("8.8.8.8")
        .output(ResponseFormat.XML)
        .build());

System.out.println(xml.data());
```

Expected: `data()` contains XML returned by API and `metadata()` contains headers/status/duration.

## Raw Response Methods

Use raw methods when you want the server response body exactly as returned.

| Method                            | `output` parameter              | `data()` Type            | Result                |
|-----------------------------------|---------------------------------|--------------------------|-----------------------|
| `lookupIpGeolocation(...)`        | omitted / `ResponseFormat.JSON` | `IpGeolocationResponse`  | typed parse           |
| `lookupIpGeolocation(...)`        | `ResponseFormat.XML`            | N/A                      | `ValidationException` |
| `lookupIpGeolocationRaw(...)`     | omitted / `ResponseFormat.JSON` | `String`                 | raw JSON              |
| `lookupIpGeolocationRaw(...)`     | `ResponseFormat.XML`            | `String`                 | raw XML               |
| `bulkLookupIpGeolocation(...)`    | omitted / `ResponseFormat.JSON` | `List<BulkLookupResult>` | typed parse           |
| `bulkLookupIpGeolocation(...)`    | `ResponseFormat.XML`            | N/A                      | `ValidationException` |
| `bulkLookupIpGeolocationRaw(...)` | omitted / `ResponseFormat.JSON` | `String`                 | raw JSON              |
| `bulkLookupIpGeolocationRaw(...)` | `ResponseFormat.XML`            | `String`                 | raw XML               |

Raw methods still return full metadata in `ApiResponseMetadata`.

### Single Raw JSON Example

```java
var rawJson = client.lookupIpGeolocationRaw(
    LookupIpGeolocationRequest.builder()
        .ip("8.8.8.8")
        .output(ResponseFormat.JSON)
        .build());

System.out.println(rawJson.data()); // raw JSON text
System.out.println(rawJson.metadata().statusCode());
System.out.println(rawJson.metadata().creditsCharged());
```

### Single Raw XML Example

```java
var rawXml = client.lookupIpGeolocationRaw(
    LookupIpGeolocationRequest.builder()
        .ip("8.8.8.8")
        .output(ResponseFormat.XML)
        .build());

System.out.println(rawXml.data()); // raw XML text
System.out.println(rawXml.metadata().statusCode());
System.out.println(rawXml.metadata().firstHeaderValue("Content-Type"));
```

### Bulk Raw JSON Example

```java
var rawBulkJson = client.bulkLookupIpGeolocationRaw(
    BulkLookupIpGeolocationRequest.builder()
        .addIp("8.8.8.8")
        .addIp("1.1.1.1")
        .output(ResponseFormat.JSON)
        .build());

System.out.println(rawBulkJson.data()); // raw JSON array text
System.out.println(rawBulkJson.metadata().creditsCharged());
```

### Bulk Raw XML Example

```java
var rawBulkXml = client.bulkLookupIpGeolocationRaw(
    BulkLookupIpGeolocationRequest.builder()
        .addIp("8.8.8.8")
        .addIp("invalid-ip")
        .output(ResponseFormat.XML)
        .build());

System.out.println(rawBulkXml.data()); // raw XML text
System.out.println(rawBulkXml.metadata().statusCode());
System.out.println(rawBulkXml.metadata().rawHeaders());
```

## Bulk Examples

### Bulk With All Valid Inputs

```java
var request = BulkLookupIpGeolocationRequest.builder()
    .addIp("8.8.8.8")
    .addIp("1.1.1.1")
    .build();

var response = client.bulkLookupIpGeolocation(request);
System.out.println("Count: " + response.data().size());
System.out.println("Credits: " + response.metadata().creditsCharged());
```

### Bulk With Mixed Valid and Invalid Inputs

```java
BulkLookupIpGeolocationRequest request = BulkLookupIpGeolocationRequest.builder()
    .addIp("8.8.8.8")
    .addIp("invalid-ip")
    .addIp("1.1.1.1")
    .build();

ApiResponse<List<BulkLookupResult>> results = client.bulkLookupIpGeolocation(request);
for (var item : results.data()) {
  if (item instanceof BulkLookupSuccess(IpGeolocationResponse ok)) {
    System.out.println("OK: " + ok.ip());
  } else if (item instanceof BulkLookupError(String message)) {
    System.out.println("ERR: " + message);
  }
}
```

Expected behavior:
- response array length equals input length
- valid entries map to `BulkLookupSuccess`
- invalid entries map to `BulkLookupError`

> [!TIP]
> Prefer bulk lookups when processing large datasets.

## Advanced Configuration

### Response Metadata

All lookup methods return `ApiResponse<T>`.

`ApiResponse<T>` contains:
- `data()`
- `metadata()`

`ApiResponseMetadata` fields:

| Field               | Type                        | Description                                                              |
|---------------------|-----------------------------|--------------------------------------------------------------------------|
| `statusCode`        | `int`                       | final HTTP response status                                               |
| `durationMs`        | `long`                      | total request duration                                                   |
| `creditsCharged`    | `Integer`                   | parsed from `X-Credits-Charged` when request is successful               |
| `successfulRecords` | `Integer`                   | parsed from `X-Successful-Record` for bulk lookup responses              |
| `rawHeaders`        | `Map<String, List<String>>` | immutable raw response header map                                        |

Header helper methods:

| Method                            | Return Type    | Description                                           |
|-----------------------------------|----------------|-------------------------------------------------------|
| `headerValues("Header-Name")`     | `List<String>` | case-insensitive header lookup, all values            |
| `firstHeaderValue("Header-Name")` | `String`       | case-insensitive header lookup, first value or `null` |

```java
var response = client.lookupIpGeolocation(
    LookupIpGeolocationRequest.builder().ip("8.8.8.8").build());

System.out.println("Status: " + response.metadata().statusCode());
System.out.println("Duration ms: " + response.metadata().durationMs());
System.out.println("Credits: " + response.metadata().creditsCharged());
System.out.println("Raw X-Credits-Charged: " + response.metadata().firstHeaderValue("X-Credits-Charged"));
```

The SDK always uses:
- timeout is always `IpGeolocationClientConfig.readTimeout()`
- SDK-managed headers always include `User-Agent`, `Accept`, and bulk `Content-Type`

### JSON Output Modes

Use `JsonOutput` for logs or CLI output. By default, it omits `null` fields from API response.

| Mode                     | Behavior               |
|--------------------------|------------------------|
| `JsonOutputMode.COMPACT` | omits `null` fields    |
| `JsonOutputMode.FULL`    | includes `null` fields |

```java
import io.ipgeolocation.sdk.JsonOutput;
import io.ipgeolocation.sdk.JsonOutputMode;

String compact = JsonOutput.toPrettyJson(response.data()); // default compact mode
String full = JsonOutput.toPrettyJson(response.data(), JsonOutputMode.FULL);
```

## Error Handling

All SDK exceptions extend `IpGeolocationException`. Catch specific types for targeted handling:

| HTTP Status   | Exception                       |
|---------------|---------------------------------|
| 400           | `BadRequestException`           |
| 401           | `UnauthorizedException`         |
| 404           | `NotFoundException`             |
| 405           | `MethodNotAllowedException`     |
| 413           | `PayloadTooLargeException`      |
| 415           | `UnsupportedMediaTypeException` |
| 423           | `LockedException`               |
| 429           | `RateLimitException`            |
| 499           | `ClientClosedRequestException`  |
| 5xx           | `ServerErrorException`          |
| other non-2xx | `ApiException`                  |

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

| Symptom                                                            | Likely Cause                             | What To Do                                                                     |
|--------------------------------------------------------------------|------------------------------------------|--------------------------------------------------------------------------------|
| `IllegalArgumentException: connectTimeout must be <= readTimeout`  | Timeout relation invalid                 | Set connect timeout less than or equal to read timeout                         |
| `ValidationException` for XML with typed methods                   | Typed methods are JSON-only              | Use `lookupIpGeolocationRaw(...)` or `bulkLookupIpGeolocationRaw(...)` for XML |
| `ValidationException: bulk lookup requires apiKey in client config` | Bulk client config omits API key         | Configure `IpGeolocationClientConfig` with an API key                          |
| `ValidationException: ips must not be empty`                       | Bulk body has no entries                 | Add at least one IP/domain                                                     |
| `ValidationException: ips must contain at most 50000 entries`      | Bulk request too large                   | Split request into chunks                                                      |
| `UnauthorizedException`                                            | Key missing, invalid, or plan limitation | Verify key and requested features                                              |
| `RateLimitException`                                               | Usage or billing condition               | Review account usage and subscription status                                   |
| `LockedException`                                                  | Bogon IP address is queried              | Use a valid public IP address                                                  |
| `BadRequestException`                                              | Provided IP address is not valid.        | Use a valid public IP address                                                  |

For a detailed list of errors, causes, and fixes, refer to the [IP Geolocation API Error Codes Documentation](https://ipgeolocation.io/documentation/ip-location-api.html#error-codes).

## Plan Behavior (Free vs Paid)

| Behavior                                           | Free Plan                               | Paid Plan                             |
|----------------------------------------------------|-----------------------------------------|---------------------------------------|
| IPv4 / IPv6 lookup                                 | supported                               | supported                             |
| Domain lookup                                      | `UnauthorizedException`                 | supported                             |
| Bulk endpoint (`/v3/ipgeo-bulk`)                   | `UnauthorizedException` with API key    | supported, but always requires API key |
| `.include("*")`                                    | accepted, returns base/default response | accepted, returns all include modules |
| non-`*` include values (`security`, `abuse`, etc.) | `UnauthorizedException`                 | supported                             |
| non-English `lang`                                 | `UnauthorizedException`                 | supported                             |
| `fields` / `excludes`                              | supported                               | supported                             |

## Links

Use these links to navigate the main IPGeolocation resources related to this Java SDK.

- [IPGeolocation.io Website](https://ipgeolocation.io/)
- [IPGeolocation Java SDK GitHub Repository](https://github.com/IPGeolocation/ip-geolocation-api-java-sdk)
- [IP Geolocation API Documentation](https://ipgeolocation.io/documentation/ip-location-api.html)
- [Credits Usage for the IP Geolocation API](https://ipgeolocation.io/documentation/credits-usage.html)
- [API Authentication with API Key and Request Origin](https://ipgeolocation.io/documentation/api-authentication.html)
- [API Response Formats for JSON and XML](https://ipgeolocation.io/documentation/api-response-formats.html)
- [IPGeolocation API Plans and Pricing](https://ipgeolocation.io/pricing.html)
- [Maven Central Package for the Java SDK](https://mvnrepository.com/artifact/io.ipgeolocation/ipgeolocation/latest)
- [Java SDK Contribution Guide](https://github.com/IPGeolocation/ip-geolocation-api-java-sdk/blob/master/CONTRIBUTING.md)
