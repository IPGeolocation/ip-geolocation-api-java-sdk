# TimezoneAPI

All URIs are relative to *https://api.ipgeolocation.io/v2*

| Method                                            | HTTP request | Description |
|---------------------------------------------------| ------------- | -------------|
| [**getTimezone**](TimezoneAPI.md#gettimezone) | **GET** /timezone | Timezone information details |



# **getTimezone**
> TimezoneResponse getTimezone().tz(tz).location(location).lat(lat)._long(_long).ip(ip).iataCode(iataCode).icaoCode(icaoCode).loCode(loCode).output(output).lang(lang).execute();

Timezone information details

The Time Zone API provides current time, date, and time zone-related information. It supports various input types including time zone name, geographic coordinates, addresses, IPs, and location codes.  The API determines the time zone based on the following priority order if multiple parameters are provided:   1. Time Zone Name   2. Geographic Coordinates (latitude &amp; longitude)   3. Location Address   4. IP Address   5. IATA Code   6. ICAO Code   7. UN/LOCODE  Enriched response data is returned based on the type of input: - IP: includes geolocation info - Address: includes location metadata - IATA/ICAO: includes airport info - UN/LOCODE: includes city details  You can call the time zone API without passing any time zone, coordinates, IATA, ICAO, LO code or IP address as well. It will use the calling machine&#39;s IP address to return the regional time zone information.

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **tz** | **String**| pass a valid time zone name as a query parameter tz to get the time zone information. | [optional] |
| **location** | **String**| pass any address of a location as the query parameter location to get the time zone information. | [optional] |
| **lat** | **Float**| pass the latitude of a location as query parameters to get the time zone information. | [optional] |
| **_long** | **Float**| pass the longitude of a location as query parameters to get the time zone information. | [optional] |
| **ip** | **String**| You can pass any IPv4 or IPv6 address as a query parameter ip to get the regional timezone information. | [optional] |
| **iataCode** | **String**| pass any 3 letter IATA code as a query paramter iata_code to get the comprehensive airport details along with the time zone information, in which that airport exists. | [optional] |
| **icaoCode** | **String**| pass any 4 letter ICAO code as a query paramter icao_code to get the comprehensive airport details along with the time zone information, in which that airport exists. | [optional] |
| **loCode** | **String**| pass any 5 letter UNLOCODE as a query paramter lo_code to get the comprehensive lo code/city details along with the time zone information of the concerned city. | [optional] |
| **output** | **String**| Desired output format (json or xml). | [optional] |
| **lang** | **String**| By default, the API responds in English. You can change the response language by passing the language code as a query parameter &#x60;lang&#x60;. Multi language feature is available only for &#x60;paid users&#x60;. | [optional] [enum: en, de, ru, ja, fr, cn, es, cs, it, ko, fa, pt] |

### Return type

[**TimezoneResponse**](TimezoneResponse.md)

### Authorization

[ApiKeyAuth](../README.md#authentication-setup)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json, application/xml

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Successful response |  -  |
| **400** | Bad Request – Possible reasons include:   - If the provided IPv4, IPv6 address, or domain name is invalid.    - If special character(s) ( ) [ ] { } | ^ &#x60; is passed in the API URL either as paramter or its value. Specially in case of API key.      - If the provided IATA code to the request paramter iata_code is not in the format as three letter code AAA.      - If the provided ICAO code to the request paramter icao_code is not in the format as four letter code AAAA.      - If the provided UN/LOCODE to the request paramter lo_code is not in format as first two characters of country code, followed by the three alphanumeric characters of the city/region.      - If the provided values to the request parameters lat andlong are not numbers, or the values fall outside the acceptable latitude and longitude ranges. The valid range for latitude is between -90 and 90, and for longitude, it is between -180 and 180.      - If the bogon or private IP address is provided to query the Time Zone information.      - If the provided time zone name to the query paramter tz is wrong or not registered in the IANA time zone database.  |  -  |
| **401** | Unauthorized – Possible reasons include:   - Missing or invalid API key   - Account unverified, locked, or disabled   - Accessing API with an unauthorized key   - Subscription expired or downgraded   - If your account has been disabled or locked to use by the admin due to abuse or illegal activity.   - When the request to IP Geolocation API is made using API key for a database subscription   - When the request to IP Geolocation API is made on the &#39;paused&#39; subscription.   - If you’re making API requests after your subscription trial has been expired.   - If your active until date has passed and you need to upgrade your account.  |  -  |
| **404** | Not Found – Possible reasons include:   - If the IPv4, IPv6, or domain name does not not exists in our database.    - If the IPv4, IPv6, or domain name is passed as a path variable, instead of url parameter as ip&#x3D;.      - If the location address provided to the request paramters location is invalid. City or state level address must be provided.      - If the provided ICAO code to the request paramter icao_code is not in the format as four letter code AAAA.      - If the provided UN/LOCODE, IATA code or ICAO code to the query paramters lo_code, iata_code, or icao_code does not exists in our database.      - If the wrong endpoint is called, that does not exists in our API.  |  -  |
| **405** | Method Not Allowed – Only GET is allowed for &#x60;/timezone&#x60; endpoint |  -  |
| **429** | Too Many Requests – Possible reasons include:   - If the API usage limit has reached for the free subscriptions, or paid subscriptions with the status &#39;past due&#39;, &#39;deleted&#39; or &#39;trial expired&#39;.    - If the surcharge API usage limit has reached against the subscribed plan.     |  -  |
| **499** | Client Closed Request – Client terminated connection before completion |  -  |
| **500** | Internal Server Error – Something went wrong on our end |  -  |

