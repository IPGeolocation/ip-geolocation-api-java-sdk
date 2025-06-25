# AsnLookupApi

All URIs are relative to *https://api.ipgeolocation.io/v2*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**asnGet**](AsnLookupApi.md#asnGet) | **GET** /asn |  |


<a id="asnGet"></a>
# **asnGet**
> ASNResponse asnGet().ip(ip).asn(asn).include(include).excludes(excludes).fields(fields).execute();



ASN API provides comprehensive details for an ASN including the as name,  organization name, the country of registration, associated domain, and its  type (ISP, host provider, or business). The API also shows the allocation  date of provided ASN and if it is currently allocated or not. It also contains  the routing information including peering, upstreams, and downstreams to help  understand the relationship between different ASNs.  Example Use Cases:  - Looking up ASN information for an IP address (e.g., &#x60;GET /asn?ip&#x3D;8.8.8.8&#x60;)  - Retrieving ASN information for a specific ASN number (e.g., &#x60;GET /asn?asn&#x3D;12345&#x60;)  - Getting peering relationships for an ASN (e.g., &#x60;GET /asn?asn&#x3D;12345&amp;include&#x3D;peers&#x60;) 

### Example

```java
// Import classes:

import invoker.io.ipgeolocation.sdk.ApiClient;
import invoker.io.ipgeolocation.sdk.ApiException;
import invoker.io.ipgeolocation.sdk.Configuration;
import io.ipgeolocation.sdk.api.AsnLookupAPI;
import io.ipgeolocation.sdk.api.AsnLookupApi;
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

        AsnLookupAPI apiInstance = new AsnLookupAPI(defaultClient);
        String ip = "8.8.8.8"; // String | query parameter 'ip'.
        Integer asn = 1; // Integer | query paramter 'asn'.
        String include = "peers"; // String | This parameter can have four options: a) peers b) downstreams c) upstreams d) routes e) whois_response. You may add any of them in comma-separated way. In order to get the ASN details with peering data, pass peers string in the include parameter like mentioned below.
        String excludes = "asn.date_allocated,asn.allocation_status"; // String | You can exclude fields from the response according to you requirement with the exception of ip field. For example, you want to remove date_allocated and allocation_status from api response, you can put the keys in excludes parameter like this.
        String fields = "asn.organization,asn.country,asn.downstreams"; // String | You can filter out only those fields which you want to see in the response by using the fields parameter. To retrieve only the AS organization, its country and downstreams in api response, you can put the keys in fields parameter like this. API will combine these fields with the default ASN response. Note: Parameters `peers, downstreams, upstreams, routes, whois_response` can be used in both `include` , and `fields`. If you use include and fields at the same time, fields parameter will be considered only.
        try {
            ASNResponse result = apiInstance.getAsnDetails()
                    .ip(ip)
                    .asn(asn)
                    .include(include)
                    .excludes(excludes)
                    .fields(fields)
                    .execute();
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling AsnLookupApi#asnGet");
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
| **ip** | **String**| query parameter &#39;ip&#39;. | [optional] |
| **asn** | **Integer**| query paramter &#39;asn&#39;. | [optional] |
| **include** | **String**| This parameter can have four options: a) peers b) downstreams c) upstreams d) routes e) whois_response. You may add any of them in comma-separated way. In order to get the ASN details with peering data, pass peers string in the include parameter like mentioned below. | [optional] |
| **excludes** | **String**| You can exclude fields from the response according to you requirement with the exception of ip field. For example, you want to remove date_allocated and allocation_status from api response, you can put the keys in excludes parameter like this. | [optional] |
| **fields** | **String**| You can filter out only those fields which you want to see in the response by using the fields parameter. To retrieve only the AS organization, its country and downstreams in api response, you can put the keys in fields parameter like this. API will combine these fields with the default ASN response. Note: Parameters &#x60;peers, downstreams, upstreams, routes, whois_response&#x60; can be used in both &#x60;include&#x60; , and &#x60;fields&#x60;. If you use include and fields at the same time, fields parameter will be considered only. | [optional] |

### Return type

[**ASNResponse**](ASNResponse.md)

### Authorization

[ApiKeyAuth](../README.md#ApiKeyAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, application/xml

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Successful response |  -  |
| **400** | Bad Request – Possible reasons include:   - If the provided IPv4, IPv6 address, or ASN is invalid.    - If special character(s) ( ) [ ] { } | ^ &#x60; is passed in the API URL either as paramter or its value. Specially in case of API key.        |  -  |
| **401** | Unauthorized – Possible reasons include:   - Missing or invalid API key   - Account unverified, locked, or disabled   - Accessing API with an unauthorized key   - Subscription expired or downgraded   - If your account has been disabled or locked to use by the admin due to abuse or illegal activity.   - When the request to IP ASN API is made using API key for a database subscription   - When the request to IP ASN API is made on the &#39;paused&#39; subscription.   - If you’re making API requests after your subscription trial has been expired.   - If your active until date has passed and you need to upgrade your account.  |  -  |
| **404** | Not Found – Possible reasons include:   - If the IPv4, IPv6, or ASN name does not exist in our database.    - If the IPv4, IPv6, or ASN  is passed as a path variable, instead of url parameter as ip&#x3D;.      - If the wrong endpoint is called, that does not exist in our API.  |  -  |
| **405** | Method Not Allowed – Only GET is allowed for &#x60;/asn&#x60; endpoint |  -  |
| **429** | Too Many Requests – Possible reasons include:   - If the API usage limit has reached for the free subscriptions, or paid subscriptions with the status &#39;past due&#39;, &#39;deleted&#39; or &#39;trial expired&#39;.    - If the surcharge API usage limit has reached against the subscribed plan.     |  -  |
| **499** | Client Closed Request – Client terminated connection before completion |  -  |
| **500** | Internal Server Error – Something went wrong on our end |  -  |

