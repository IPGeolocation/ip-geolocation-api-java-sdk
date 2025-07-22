# IPGeolocationAPI
All URIs are relative to *https://api.ipgeolocation.io/v2*

| Method                                                               | HTTP request | Description |
|----------------------------------------------------------------------| ------------- | -------------|
| [**getBulkIPGeolocation**](IPGeolocationAPI.md#getbulkipgeolocation) | **POST** /ipgeo-bulk |  |
| [**getIPGeolocation**](IPGeolocationAPI.md#getipgeolocation)         | **GET** /ipgeo |  |


# **getBulkIpGeolocation**
> List&lt;BulkIPGeolocationResponse&gt; getBulkIPGeolocation(bulkIPRequest).lang(lang).fields(fields).excludes(excludes).include(include).output(output).execute();



This feature is available only on our paid API subscriptions (STANDARD or ADVANCED). This endpoint allows you to perform the geolocation lookup for multiple IPv4, IPv6 addresses or domain names (maximum 50,000) at the same time. The requests count per lookup is equal to total IP addresses or domain names passed. To perform bulk IP Geolocation Lookup, send a POST request and pass the \&quot;ips\&quot; array as JSON data along with it.

### Parameters

| Name              | Type                                  | Description  | Notes |
|-------------------|---------------------------------------| ------------- | -------------|
| **bulkIPRequest** | [**BulkIPRequest**](BulkIPRequest.md) |  | |
| **lang**          | **String**                            | By default, the API responds in English. You can change the response language by passing the language code as a query parameter &#x60;lang&#x60;. Multi language feature is available only for &#x60;paid users&#x60;. | [optional] [enum: en, de, ru, ja, fr, cn, es, cs, it, ko, fa, pt] |
| **fields**        | **String**                            | you can filter the API response by specifying the fields that you need, instead of getting the full response. To do this, pass the desired field names using the &#x60;fields&#x60; query parameter with each field represented as a dot-separated path. | [optional] |
| **excludes**      | **String**                            | you can also filter the API response by excluding specific fields (except the IP address) that you don&#39;t need. To do this, pass the unwanted field names using the excludes query parameter, with each field represented as a dot-separated path | [optional] |
| **include**       | **String**                            | IP Geolocation API also provides IP-Security, abuse, timezone, user-agent and DMA (Designated Market Area) code, which is specifically used in the US for marketing and regional targeting information on Advanced API subscription, but doesn&#39;t respond it by default. To get these information along with the geolocation information, you must pass the &#x60;include&#x3D;security&#x60; or &#x60;include&#x3D;abuse&#x60; or &#x60;include&#x3D;dma&#x60; or &#x60;include&#x3D;time_zone&#x60; or &#x60;include&#x3D;user-agent&#x60; or you can fetch multiples by adding values in comma-separated way. In addition to that, IPGeolocation API also provide hostname lookup for an IP address on all the paid API subscriptions (STANDARD and ADVANCED), but doesn&#39;t respond it by default. To get the hostname for an IP address, you can pass one of the three values &#x60;hostname, liveHostname, hostnameFallbackLive&#x60; as a URL parameter &#x60;include&#x3D;&#x60;. | [optional] |
| **output**        | **String**                            | Desired output format(json or xml). | [optional] |

### Return type

[**List&lt;BulkIPRequest&gt;**](GetBulkIpGeolocation200ResponseInner.md)

### Authorization

[ApiKeyAuth](../README.md#authentication-setup)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json, application/xml

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | success |  -  |
| **400** | Bad Request – Possible reasons include:   - If the provided IPv4, IPv6 address, or domain name is invalid.    - If special character(s) ( ) [ ] { } | ^ &#x60; is passed in the API URL either as paramter or its value. Specially in case of API key.      - If the IP addresses JSON list is empty, or the provided JSON does not have &#39;ips&#39; field while querying /ipgeo-bulk endpoint.    - If more than 50,000 IP addresses are provided while quering from /ipgeo-bulk endpoint.        |  -  |
| **401** | Unauthorized – Possible reasons include:   - Missing or invalid API key   - Account unverified, locked, or disabled   - Accessing API with an unauthorized key   - Subscription expired or downgraded   - If your account has been disabled or locked to use by the admin due to abuse or illegal activity.   - When the request to IP Security API is made using API key for a database subscription   - When the request to IP Security API is made on the &#39;paused&#39; subscription.   - If you’re making API requests after your subscription trial has been expired.   - If your active until date has passed and you need to upgrade your account.      - If IP-hostname lookup, IP-security lookup or user-agent parsing endpoint is called using free subsciption API key.    - If bulk IP to geolocation look-ups endpoint is called using free subscription API key.  |  -  |
| **403** | Forbidden | Possible reasons include:   - If IP to geolocation look-up for a domain name is done using a free subscription API key.     |  -  |
| **404** | Not Found – Possible reasons include:   - If the IPv4, IPv6, or domain name does not exist in our database.    - If the IPv4, IPv6, or domain name is passed as a path variable, instead of url parameter as ip&#x3D;.      - If the wrong endpoint is called, that does not exist in our API.  |  -  |
| **405** | Method Not Allowed – Only POST is allowed for &#x60;/ipgeo-bulk&#x60; endpoint |  -  |
| **413** | If the passed data in the POST requests is more than the limit of the API. |  -  |
| **415** | If the payload for IPs in /ipgeo-bulk endpoint is mising, or the content type is not mentioned as JSON. |  -  |
| **423** | If the passed IP address is from a bogon ip ranges, or is part of a private network. |  -  |
| **429** | Too Many Requests – Possible reasons include:   - If the API usage limit has reached for the free subscriptions, or paid subscriptions with the status &#39;past due&#39;, &#39;deleted&#39; or &#39;trial expired&#39;.    - If the surcharge API usage limit has reached against the subscribed plan.     |  -  |
| **499** | Client Closed Request – Client terminated connection before completion |  -  |
| **500** | Internal Server Error – Something went wrong on our end |  -  |

<a id="getIpGeolocation"></a>
# **getIPGeolocation**
> GeolocationResponse getIPGeolocation().ip(ip).lang(lang).fields(fields).excludes(excludes).include(include).output(output).execute();



IP Geolocation API provides real-time and accurate geolocation, network, abuse, and security information for any IPv4 or IPv6 address and domain name along with the user-agent detail for the provided user-agent string. You can geolocate your online visitors and provide them the customized user-experience accordingly.

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **ip** | **String**| In order to find geolocation information about an IP (ipv4 ipv6) address or a domain name, pass it as a query parameter ip. When this endpoint is queried without an IP address, it returns the geolocation information of the device/client which is calling it | [optional] |
| **lang** | **String**| By default, the API responds in English. You can change the response language by passing the language code as a query parameter &#x60;lang&#x60;. Multi language feature is available only for &#x60;paid users&#x60;. | [optional] [enum: en, de, ru, ja, fr, cn, es, cs, it, ko, fa, pt] |
| **fields** | **String**| you can filter the API response by specifying the fields that you need, instead of getting the full response. To do this, pass the desired field names using the &#x60;fields&#x60; query parameter with each field represented as a dot-separated path. | [optional] |
| **excludes** | **String**| you can also filter the API response by excluding specific fields (except the IP address) that you don&#39;t need. To do this, pass the unwanted field names using the excludes query parameter, with each field represented as a dot-separated path | [optional] |
| **include** | **String**| IP Geolocation API also provides IP-Security, abuse, timezone, user-agent and DMA (Designated Market Area) code, which is specifically used in the US for marketing and regional targeting information on Advanced API subscription, but doesn&#39;t respond it by default. To get these information along with the geolocation information, you must pass the &#x60;include&#x3D;security&#x60; or &#x60;include&#x3D;abuse&#x60; or &#x60;include&#x3D;dma&#x60; or &#x60;include&#x3D;time_zone&#x60; or &#x60;include&#x3D;user-agent&#x60; or you can fetch multiples by adding values in comma-separated way. In addition to that, IPGeolocation API also provide hostname lookup for an IP address on all the paid API subscriptions (STANDARD and ADVANCED), but doesn&#39;t respond it by default. To get the hostname for an IP address, you can pass one of the three values &#x60;hostname, liveHostname, hostnameFallbackLive&#x60; as a URL parameter &#x60;include&#x3D;&#x60;. | [optional] |
| **output** | **String**| Desired output format (json or xml). | [optional] |

### Return type

[**GeolocationResponse**](GeolocationResponse.md)

### Authorization

[ApiKeyAuth](../README.md#authentication-setup)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json, application/xml

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | successful response |  -  |
| **400** | Bad Request – Possible reasons include:   - If the provided IPv4, IPv6 address, or domain name is invalid.    - If special character(s) ( ) [ ] { } | ^ &#x60; is passed in the API URL either as paramter or its value. Specially in case of API key.        |  -  |
| **401** | Unauthorized – Possible reasons include:   - Missing or invalid API key   - Account unverified, locked, or disabled   - Accessing API with an unauthorized key   - Subscription expired or downgraded   - If your account has been disabled or locked to use by the admin due to abuse or illegal activity.   - When the request to IP Security API is made using API key for a database subscription   - When the request to IP Security API is made on the &#39;paused&#39; subscription.   - If you’re making API requests after your subscription trial has been expired.   - If your active until date has passed and you need to upgrade your account.      - If IP-hostname lookup, IP-security lookup or user-agent parsing endpoint is called using free subsciption API key.  |  -  |
| **403** | Forbidden | Possible reasons include:   - If IP to geolocation look-up for a domain name is done using a free subscription API key.     |  -  |
| **404** | Not Found – Possible reasons include:   - If the IPv4, IPv6, or domain name does not exist in our database.    - If the IPv4, IPv6, or domain name is passed as a path variable, instead of url parameter as ip&#x3D;.      - If the wrong endpoint is called, that does not exist in our API.  |  -  |
| **405** | Method Not Allowed – Only GET is allowed for &#x60;/ipgeo&#x60; endpoint |  -  |
| **423** | If the passed IP address is from a bogon ip ranges, or is part of a private network. |  -  |
| **429** | Too Many Requests – Possible reasons include:   - If the API usage limit has reached for the free subscriptions, or paid subscriptions with the status &#39;past due&#39;, &#39;deleted&#39; or &#39;trial expired&#39;.    - If the surcharge API usage limit has reached against the subscribed plan.     |  -  |
| **499** | Client Closed Request – Client terminated connection before completion |  -  |
| **500** | Internal Server Error – Something went wrong on our end |  -  |

