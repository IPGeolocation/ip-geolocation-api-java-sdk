# SecurityApi

All URIs are relative to *https://api.ipgeolocation.io/v2*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**securityBulkPost**](SecurityApi.md#securityBulkPost) | **POST** /security-bulk |  |
| [**securityGet**](SecurityApi.md#securityGet) | **GET** /security |  |


<a id="securityBulkPost"></a>
# **securityBulkPost**
> List&lt;SecurityBulkPost200ResponseInner&gt; securityBulkPost(bulkIpRequest).include(include).fields(fields).excludes(excludes).output(output).lang(lang).execute();



The Bulk IP Security Lookup API can provide security details for up to &#x60;50,000&#x60; bulk IPs. This API also has parameters to customize the response, just like the single IP Security Lookup API.

### Example

```java
// Import classes:

import invoker.io.ipgeolocation.sdk.ApiClient;
import invoker.io.ipgeolocation.sdk.ApiException;
import invoker.io.ipgeolocation.sdk.Configuration;
import io.ipgeolocation.sdk.api.IPSecurityAPI;
import io.ipgeolocation.sdk.api.SecurityApi;
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

        IPSecurityAPI apiInstance = new IPSecurityAPI(defaultClient);
        IpgeoBulkPostRequest bulkIpRequest = new IpgeoBulkPostRequest(); // IpgeoBulkPostRequest | 
        String include = "location,network,currency,time_zone,user_agent,country_metadata,hostname"; // String | Include optional objects like `location`, `network`.  Use comma-separated values. Example: include=location,network 
        String fields = "security.is_tor, location,"; // String | Get specific fields, objects from the response.
        String excludes = "security.is_cloud_provider"; // String | Exclude specific fields, objects from the response.
        String output = "json"; // String | Desired output format.
        String lang = "en"; // String | By default, the API responds in English. You can change the response language by passing the language code as a query parameter `lang`. Multi language feature is available only for `paid users`.
        try {
            List<SecurityBulkPost200ResponseInner> result = apiInstance.getBulkIPSecurity(bulkIpRequest)
                    .include(include)
                    .fields(fields)
                    .excludes(excludes)
                    .output(output)
                    .lang(lang)
                    .execute();
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling SecurityApi#securityBulkPost");
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
| **bulkIpRequest** | [**IpgeoBulkPostRequest**](BulkIPRequest.md)|  | |
| **include** | **String**| Include optional objects like &#x60;location&#x60;, &#x60;network&#x60;.  Use comma-separated values. Example: include&#x3D;location,network  | [optional] |
| **fields** | **String**| Get specific fields, objects from the response. | [optional] |
| **excludes** | **String**| Exclude specific fields, objects from the response. | [optional] |
| **output** | **String**| Desired output format. | [optional] |
| **lang** | **String**| By default, the API responds in English. You can change the response language by passing the language code as a query parameter &#x60;lang&#x60;. Multi language feature is available only for &#x60;paid users&#x60;. | [optional] [enum: en, de, ru, ja, fr, cn, es, cs, it, ko, fa, pt] |

### Return type

[**List&lt;SecurityBulkPost200ResponseInner&gt;**](BulkSecurityResponse.md)

### Authorization

[ApiKeyAuth](../README.md#ApiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json, application/xml

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Get the security details of bulk IPs. It may include the following information  subjecting to the availability of query parameters  - If include&#x3D;network, it will include network object  - If include&#x3D;location, it will include location object  - If include&#x3D;location,network, it will include both objects  - To get specific fields/object, use fields&#x3D;field_name e.g., security.is_tor - to exclude fields, same can be done  |  -  |
| **400** | Bad Request – Possible reasons include:   - If the provided IPv4, IPv6 address, or domain name is invalid.    - If special character(s) ( ) [ ] { } | ^ &#x60; is passed in the API URL either as paramter or its value. Specially in case of API key.      - If the IP addresses JSON list is empty, or the provided JSON does not have &#39;ips&#39; field while querying /security-bulk endpoint.      - If more than 50,000 IP addresses are provided while quering from /security-bulk endpoint.     |  -  |
| **401** | Unauthorized – Possible reasons include:   - Missing or invalid API key   - Account unverified, locked, or disabled   - Accessing API with an unauthorized key   - Subscription expired or downgraded   - If your account has been disabled or locked to use by the admin due to abuse or illegal activity.   - When the request to IP Security API is made using API key for a database subscription   - When the request to IP Security API is made on the &#39;paused&#39; subscription.   - If you’re making API requests after your subscription trial has been expired.   - If your active until date has passed and you need to upgrade your account.   - If bulk IP to security look-ups endpoint is called &#x60;using free subscription API key&#x60;.  |  -  |
| **403** | Forbidden | Possible reasons include:   - If IP to security look-up for a domain name is done using a free subscription API key.     |  -  |
| **404** | Not Found – Possible reasons include:   - If the IPv4, IPv6, or domain name does not not exists in our database.    - If the IPv4, IPv6, or domain name is passed as a path variable, instead of url parameter as ip&#x3D;.      - If the wrong endpoint is called, that does not exists in our API.  |  -  |
| **405** | Method Not Allowed – Only POST method is allowed for &#x60;/security-bulk&#x60; endpoint |  -  |
| **413** | Content Too Large – Possible reasons include:   - If the passed data in the POST requests is more than the limit of the API.     |  -  |
| **429** | Too Many Requests – Possible reasons include:   - If the API usage limit has reached for the free subscriptions, or paid subscriptions with the status &#39;past due&#39;, &#39;deleted&#39; or &#39;trial expired&#39;.    - If the surcharge API usage limit has reached against the subscribed plan.     |  -  |
| **499** | Client Closed Request – Client terminated connection before completion |  -  |
| **500** | Internal Server Error – Something went wrong on our end |  -  |

<a id="securityGet"></a>
# **securityGet**
> SecurityAPIResponse securityGet().ip(ip).include(include).fields(fields).excludes(excludes).output(output).lang(lang).execute();



IP Security API provides security details of a given IP. It detects whether the IP is proxy, tor or bot. It also shows the proxy types of the IP (like VPN, PROXY, RELAY etc.) with it&#39;s VPN/proxy service provider making our API powerful VPN checker. It finds the IPs that are involved in spam activities. It also checks whether the IP links to a cloud provider and includes the provider&#39;s name.

### Example

```java
// Import classes:

import invoker.io.ipgeolocation.sdk.ApiClient;
import invoker.io.ipgeolocation.sdk.ApiException;
import invoker.io.ipgeolocation.sdk.Configuration;
import io.ipgeolocation.sdk.api.IPSecurityAPI;
import io.ipgeolocation.sdk.api.SecurityApi;
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

        IPSecurityAPI apiInstance = new IPSecurityAPI(defaultClient);
        String ip = "8.8.8.8"; // String | query parameter 'ip'. If not provided, will be your network IP
        String include = "location,network,currency,time_zone,user_agent,country_metadata,hostname"; // String | Include optional details like location and/or network.
        String fields = "security.is_tor, location,"; // String | Get specific fields, objects from the response.
        String excludes = "security.is_cloud_provider"; // String | Exclude specific fields, objects from the response.
        String output = "json"; // String | Desired output format (json or xml).
        String lang = "en"; // String | By default, the API responds in English. You can change the response language by passing the language code as a query parameter `lang`. Multi language feature is available only for `paid users`.
        try {
            SecurityAPIResponse result = apiInstance.getIPSecurity()
                    .ip(ip)
                    .include(include)
                    .fields(fields)
                    .excludes(excludes)
                    .output(output)
                    .lang(lang)
                    .execute();
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling SecurityApi#securityGet");
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
| **ip** | **String**| query parameter &#39;ip&#39;. If not provided, will be your network IP | [optional] |
| **include** | **String**| Include optional details like location and/or network. | [optional] |
| **fields** | **String**| Get specific fields, objects from the response. | [optional] |
| **excludes** | **String**| Exclude specific fields, objects from the response. | [optional] |
| **output** | **String**| Desired output format (json or xml). | [optional] |
| **lang** | **String**| By default, the API responds in English. You can change the response language by passing the language code as a query parameter &#x60;lang&#x60;. Multi language feature is available only for &#x60;paid users&#x60;. | [optional] [enum: en, de, ru, ja, fr, cn, es, cs, it, ko, fa, pt] |

### Return type

[**SecurityAPIResponse**](SecurityAPIResponse.md)

### Authorization

[ApiKeyAuth](../README.md#ApiKeyAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, application/xml

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Get the security details of the ip. It may include the following information  subjecting to the availability of query parameters  - If include&#x3D;network, it will include network object  - If include&#x3D;location, it will include location object  - If include&#x3D;location,network, it will include both objects  - To get specific fields/object, use fields&#x3D;field_name e.g., security.is_tor - to exclude fields, same can be done  |  -  |
| **400** | Bad Request – Possible reasons include:   - If the provided IPv4, IPv6 address is invalid.    - If special character(s) ( ) [ ] { } | ^ &#x60; is passed in the API URL either as paramter or its value. Specially in case of API key.        |  -  |
| **401** | Unauthorized – Possible reasons include:   - Missing or invalid API key   - Account unverified, locked, or disabled   - Accessing API with an unauthorized key   - Subscription expired or downgraded   - If your account has been disabled or locked to use by the admin due to abuse or illegal activity.   - When the request to IP Security API is made using API key for a database subscription   - When the request to IP Security API is made on the &#39;paused&#39; subscription.   - If you’re making API requests after your subscription trial has been expired.   - If your active until date has passed and you need to upgrade your account.  |  -  |
| **404** | Not Found – Possible reasons include:   - If the IPv4, IPv6, or domain name does not exist in our database.    - If the IPv4, IPv6, or domain name is passed as a path variable, instead of url parameter as ip&#x3D;.      - If the wrong endpoint is called, that does not exist in our API.  |  -  |
| **405** | Method Not Allowed – Only GET is allowed for &#x60;/security&#x60; endpoint |  -  |
| **429** | Too Many Requests – Possible reasons include:   - If the API usage limit has reached for the free subscriptions, or paid subscriptions with the status &#39;past due&#39;, &#39;deleted&#39; or &#39;trial expired&#39;.    - If the surcharge API usage limit has reached against the subscribed plan.     |  -  |
| **499** | Client Closed Request – Client terminated connection before completion |  -  |
| **500** | Internal Server Error – Something went wrong on our end |  -  |

