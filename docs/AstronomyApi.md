# AstronomyApi

All URIs are relative to *https://api.ipgeolocation.io/v2*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**astronomyGet**](AstronomyApi.md#astronomyGet) | **GET** /astronomy |  |


<a id="astronomyGet"></a>
# **astronomyGet**
> AstronomyResponse astronomyGet().ip(ip).location(location).lat(lat)._long(_long).date(date).output(output).lang(lang).execute();



The Astronomy API provides the location-based rise and set times for the Sun and Moon along with the current position, distance from earth, and azimuth of the Sun and the Moon for a specific date at the queried time. 

### Example

```java
// Import classes:

import invoker.io.ipgeolocation.sdk.ApiClient;
import invoker.io.ipgeolocation.sdk.ApiException;
import invoker.io.ipgeolocation.sdk.Configuration;
import io.ipgeolocation.sdk.api.AstronomyAPI;
import io.ipgeolocation.sdk.api.AstronomyApi;
import io.ipgeolocation.sdk.invoker.auth.ApiKeyAuth;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://api.ipgeolocation.io/v2");

        // Configure API key authorization: ApiKeyAuth
        ApiKeyAuth ApiKeyAuth = (ApiKeyAuth) defaultClient.getAuthentication("ApiKeyAuth");
        ApiKeyAuth.setApiKey("YOUR API KEY");
        // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
        //ApiKeyAuth.setApiKeyPrefix("Token");

        AstronomyAPI apiInstance = new AstronomyAPI(defaultClient);
        String ip = "8.8.8.8"; // String | query paramter 'ip'. If not provided, will be your network IP
        String location = "New York, US"; // String | query paramter 'location'. If not provided, will be your ip location
        String lat = "40.76473"; // String | query paramter 'lat'.
        String _long = "-74.00084"; // String | query paramter 'long'.
        String date = "2025-04-22"; // String | The date (YYYY-MM-DD) to lookup for. default will be the current date
        String output = "json"; // String | Desired output format.
        String lang = "en"; // String | By default, the API responds in English. You can change the response language by passing the language code as a query parameter `lang`. Multi language feature is available only for `paid users`.
        try {
            AstronomyResponse result = apiInstance.getAstronomy()
                    .ip(ip)
                    .location(location)
                    .lat(lat)
                    ._long(_long)
                    .date(date)
                    .output(output)
                    .lang(lang)
                    .execute();
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling AstronomyApi#astronomyGet");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **ip** | **String**| query paramter &#39;ip&#39;. If not provided, will be your network IP | [optional] |
| **location** | **String**| query paramter &#39;location&#39;. If not provided, will be your ip location | [optional] |
| **lat** | **String**| query paramter &#39;lat&#39;. | [optional] |
| **_long** | **String**| query paramter &#39;long&#39;. | [optional] |
| **date** | **String**| The date (YYYY-MM-DD) to lookup for. default will be the current date | [optional] |
| **output** | **String**| Desired output format. | [optional] |
| **lang** | **String**| By default, the API responds in English. You can change the response language by passing the language code as a query parameter &#x60;lang&#x60;. Multi language feature is available only for &#x60;paid users&#x60;. | [optional] [enum: en, de, ru, ja, fr, cn, es, cs, it, ko, fa, pt] |

### Return type

[**AstronomyResponse**](AstronomyResponse.md)

### Authorization

[ApiKeyAuth](../README.md#ApiKeyAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, application/xml

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Successful response |  -  |
| **400** | Bad Request – Possible reasons include:   - Invalid or not found location/address   - Special characters in API key or value   - Invalid date format (expected: yyyy-MM-dd)   - IP not found in the database  |  -  |
| **401** | Unauthorized – Possible reasons include:   - Missing or invalid API key   - Account unverified, locked, or disabled   - Accessing API with an unauthorized key   - Subscription expired or downgraded  |  -  |
| **405** | Method Not Allowed – Only GET is allowed for &#x60;/astronomy&#x60; endpoint |  -  |
| **429** | Too Many Requests – API usage limits exceeded for current plan |  -  |
| **499** | Client Closed Request – Client terminated connection before completion |  -  |
| **500** | Internal Server Error – Something went wrong on our end |  -  |

