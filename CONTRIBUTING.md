# Contributing Guide

This repository contains the public Java SDK package for the IP Geolocation API.

## Prerequisites
- Java 8+
- Maven 3.8+

## Setup
```bash
mvn clean compile
```

## Run Tests

Run full public test suite:
```bash
mvn clean verify
```

Run all tests without cleaning:
```bash
mvn test
```

Run one test class:
```bash
mvn -Dtest=IpGeolocationClientRequestBuildingTest test
```

Run one test method:
```bash
mvn -Dtest=IpGeolocationClientRequestBuildingTest#lookupBuildsExpectedQueryAndHeaders test
```

## Live API Tests (Optional)

Live tests consume API credits and are disabled by default.

```bash
IPGEO_RUN_LIVE_TESTS=true IPGEO_FREE_KEY=... IPGEO_PAID_KEY=... mvn -Dtest=IpGeolocationLiveIntegrationTest test
```

Optional live hardening tests compare raw API JSON to the typed SDK model and consume additional credits.

```bash
IPGEO_RUN_LIVE_HARDENING=true IPGEO_PAID_KEY=... mvn -Dtest=IpGeolocationLiveFieldParityTest test
```

## Coding and PR Notes
- Keep changes focused and include tests for behavior changes.
- Do not commit real API keys, tokens, or secrets.
- Use clear commit messages, for example:
  - `feat: add bulk xml raw response support`
  - `fix: validate connect timeout does not exceed read timeout`
  - `test: add error mapping coverage for 499`
