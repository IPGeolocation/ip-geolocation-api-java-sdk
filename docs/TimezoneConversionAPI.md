# TimezoneConversionAPI

All URIs are relative to *https://api.ipgeolocation.io/v2*

| Method                                                          | HTTP request | Description |
|-----------------------------------------------------------------| ------------- | -------------|
| [**convertTimezone**](TimezoneConversionAPI.md#converttimezone) | **GET** /timezone/convert |  |


# **convertTimezone**
> TimezoneConversionResponse convertTimezone().time(time).tzFrom(tzFrom).tzTo(tzTo).latFrom(latFrom).longFrom(longFrom).latTo(latTo).longTo(longTo).locationFrom(locationFrom).locationTo(locationTo).icaoFrom(icaoFrom).icaoTo(icaoTo).iataFrom(iataFrom).iataTo(iataTo).locodeFrom(locodeFrom).locodeTo(locodeTo).execute();



You can convert a timestamp provided as a query parameter time from one time zone to another time zone.

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **time** | **String**| time parameter takes the input in the following two formats: i) &#39;yyyy-MM-dd HH:mm&#39;, and ii) &#39;yyyy-MM-dd HH:mm:ss&#39;. This parameter is optional and you can omit it to convert the current time between two coordinates, time zones or locations. | [optional] |
| **tzFrom** | **String**| timezone to convert from | [optional] |
| **tzTo** | **String**| timezone to convert to | [optional] |
| **latFrom** | **Float**| latitude to convert from | [optional] |
| **longFrom** | **Float**| longitude to convert from | [optional] |
| **latTo** | **Float**| latitude to convert to | [optional] |
| **longTo** | **Float**| longitude to convert to | [optional] |
| **locationFrom** | **String**| location to convert from | [optional] |
| **locationTo** | **String**| location to convert to | [optional] |
| **icaoFrom** | **String**| location to convert from | [optional] |
| **icaoTo** | **String**| location to convert to | [optional] |
| **iataFrom** | **String**| location to convert from | [optional] |
| **iataTo** | **String**| location to convert to | [optional] |
| **locodeFrom** | **String**| location to convert from | [optional] |
| **locodeTo** | **String**| location to convert to | [optional] |

### Return type

[**TimezoneConversionResponse**](TimezoneConversionResponse.md)

### Authorization

[ApiKeyAuth](../README.md#authentication-setup)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json, application/xml

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Successful response |  -  |
| **400** | Bad Request – Possible reasons include:   - If one of the query paramters tz_from and tz_to is provided and other is missing, for time conversion.    - If one of the query paramters location_from and location_to is provided and other is missing, for time conversion.      - If one of the query paramters lat_from, long_from, lat_to, and long_to is provided and other(s) is/are missing, for time conversion.      - If the location address provided to one of the paramters location_from and location_to is invalid, for time conversion. City or state level address must be provided.      - If the geographic coordinates provided to one of the paramters lat_from, long_from, lat_to, and long_to is/are not numbers, or the values fall outside the acceptable latitude and longitude ranges. The valid range for latitude is between -90 and 90, and for longitude, it is between -180 and 180.      - If the time zone names provided to one of the paramters tz_from and tz_to is/are wrong or not registered in the IANA time zone database.      - If none of the query parameter combination is provided for time conversion. tz_from and tz_to or location_from and location_to or lat_from, long_from, lat_to, long_to combination must be provided.  |  -  |
| **401** | Unauthorized – Possible reasons include:   - Missing or invalid API key   - Account unverified, locked, or disabled   - Accessing API with an unauthorized key   - Subscription expired or downgraded   - If your account has been disabled or locked to use by the admin due to abuse or illegal activity.   - When the request to IP Geolocation API is made using API key for a database subscription   - When the request to IP Geolocation API is made on the &#39;paused&#39; subscription.   - If you’re making API requests after your subscription trial has been expired.   - If your active until date has passed and you need to upgrade your account.  |  -  |
| **404** | Not Found – Possible reasons include:   - If the IPv4, IPv6, or domain name does not not exists in our database.    - If the IPv4, IPv6, or domain name is passed as a path variable, instead of url parameter as ip&#x3D;.      - If the location address provided to the request paramters location is invalid. City or state level address must be provided.      - If the provided ICAO code to the request paramter icao_code is not in the format as four letter code AAAA.      - If the provided UN/LOCODE, IATA code or ICAO code to the query paramters lo_code, iata_code, or icao_code does not exists in our database.      - If the wrong endpoint is called, that does not exists in our API.  |  -  |
| **405** | Method Not Allowed – Only GET is allowed for &#x60;/timezone/convert&#x60; endpoint |  -  |
| **429** | Too Many Requests – Possible reasons include:   - If the API usage limit has reached for the free subscriptions, or paid subscriptions with the status &#39;past due&#39;, &#39;deleted&#39; or &#39;trial expired&#39;.    - If the surcharge API usage limit has reached against the subscribed plan.     |  -  |
| **499** | Client Closed Request – Client terminated connection before completion |  -  |
| **500** | Internal Server Error – Something went wrong on our end |  -  |

