# UserAgentApi

All URIs are relative to *https://api.ipgeolocation.io/v2*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**userAgentBulkPost**](UserAgentApi.md#userAgentBulkPost) | **POST** /user-agent-bulk | Handle multiple user-agent string lookups |
| [**userAgentGet**](UserAgentApi.md#userAgentGet) | **GET** /user-agent | Get details of user-agent |
| [**userAgentPost**](UserAgentApi.md#userAgentPost) | **POST** /user-agent | Handle single User-Agent string |


<a id="userAgentBulkPost"></a>
# **userAgentBulkPost**
> List&lt;UserAgentData&gt; userAgentBulkPost().output(output).userAgentBulkRequest(userAgentBulkRequest).execute();

Handle multiple user-agent string lookups

This endpoint allows you to perform the parsing of multiple User-Angent strings (max. 50,000) at the same time. The requests count per round is equal to total User-Agent strings passed. This feature is &#x60;only available for paid plans&#x60;.

### Example

```java
// Import classes:

import invoker.io.ipgeolocation.sdk.ApiClient;
import invoker.io.ipgeolocation.sdk.ApiException;
import invoker.io.ipgeolocation.sdk.Configuration;
import io.ipgeolocation.sdk.api.UserAgentAPI;
import io.ipgeolocation.sdk.api.UserAgentApi;
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

        UserAgentAPI apiInstance = new UserAgentAPI(defaultClient);
        String output = "json"; // String | Desired output format (json or xml).
        UserAgentBulkPostRequest userAgentBulkRequest = new UserAgentBulkPostRequest(); // UserAgentBulkPostRequest | 
        try {
            List<UserAgentData> result = apiInstance.getBulkUserAgent()
                    .output(output)
                    .userAgentBulkRequest(userAgentBulkRequest)
                    .execute();
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling UserAgentApi#userAgentBulkPost");
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
| **output** | **String**| Desired output format (json or xml). | [optional] |
| **userAgentBulkRequest** | [**UserAgentBulkPostRequest**](UserAgentBulkRequest.md)|  | [optional] |

### Return type

[**List&lt;UserAgentData&gt;**](UserAgentData.md)

### Authorization

[ApiKeyAuth](../README.md#ApiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json, application/xml

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Success |  -  |
| **400** | Bad Request – Possible reasons include:   - If the user-agent string is empty/null.   - If the User Agent Strings JSON list is empty, or the provided JSON does not have &#39;uaStrings&#39; field while querying /user-agent-bulk endpoint.   - If more than 50,000 user agent strings are provided while quering from /user-agent-bulk endpoint.  |  -  |
| **401** | Unauthorized – Possible reasons include:   - If API key (as apiKey URL parameter) is missing from the request to User Agent API.    - If the provided API key is not valid.   - If your account has been disabled or locked by admin because of any illegal activity.   - If you’re making requests after your subscription trial has been expired.   - If you’ve exceeded your requests limit.   - If your subscription is paused or is not active.   - If you’re accessing a paid feature on free subscription.   - If bulk user agent parsing endpoint is called using free subscription API key.  |  -  |
| **405** | If wrong HTTP request method is used for calling the endpoints. Only POST method is allowed. |  -  |
| **429** | Too Many Requests – API usage limits exceeded for current plan |  -  |
| **499** | Client Closed Request – Client terminated connection before completion |  -  |
| **500** | Internal Server Error – Something went wrong on our end |  -  |

<a id="userAgentGet"></a>
# **userAgentGet**
> UserAgentData userAgentGet().userAgent(userAgent).output(output).execute();

Get details of user-agent

User Agent Parser API provides the accurate browser, device, and operating system details from a User Agent String. It also provides information about crawlers and attack sources. You can use these details to customize user experience, prevent crawlers and attackers from accessing your website. 

### Example

```java
// Import classes:

import invoker.io.ipgeolocation.sdk.ApiClient;
import invoker.io.ipgeolocation.sdk.ApiException;
import invoker.io.ipgeolocation.sdk.Configuration;
import io.ipgeolocation.sdk.api.UserAgentAPI;
import io.ipgeolocation.sdk.api.UserAgentApi;
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

        UserAgentAPI apiInstance = new UserAgentAPI(defaultClient);
        String userAgent = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_2) AppleWebKit/601.3.9 (KHTML, like Gecko) Version/9.0.2 Safari/601.3.9"; // String | 
        String output = "json"; // String | Desired output format (json or xml).
        try {
            UserAgentData result = apiInstance.getUserAgent()
                    .userAgentString(userAgent)
                    .output(output)
                    .execute();
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling UserAgentApi#userAgentGet");
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
| **userAgent** | **String**|  | [optional] |
| **output** | **String**| Desired output format (json or xml). | [optional] |

### Return type

[**UserAgentData**](UserAgentData.md)

### Authorization

[ApiKeyAuth](../README.md#ApiKeyAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, application/xml

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | successful response |  -  |
| **400** | Bad Request – Possible reasons include:   - If the user-agent string is empty/null.  |  -  |
| **401** | Unauthorized – Possible reasons include:   - If API key (as apiKey URL parameter) is missing from the request to User Agent API.    - If the provided API key is not valid.   - If your account has been disabled or locked by admin because of any illegal activity.   - If you’re making requests after your subscription trial has been expired.   - If you’ve exceeded your requests limit.   - If your subscription is paused or is not active.   - If you’re accessing a paid feature on free subscription.  |  -  |
| **405** | If wrong HTTP request method is used for calling the endpoints. Only GET and POST methods are allowed. |  -  |
| **429** | Too Many Requests – API usage limits exceeded for current plan |  -  |
| **499** | Client Closed Request – Client terminated connection before completion |  -  |
| **500** | Internal Server Error – Something went wrong on our end |  -  |

<a id="userAgentPost"></a>
# **userAgentPost**
> UserAgentData userAgentPost().output(output).userAgentRequest(userAgentRequest).execute();

Handle single User-Agent string

You can also provide custom User-Agent string to parse in JSON payload. This endpoint is meant to be called from server-side and is available for paid subscriptions only.

### Example

```java
// Import classes:

import invoker.io.ipgeolocation.sdk.ApiClient;
import invoker.io.ipgeolocation.sdk.ApiException;
import invoker.io.ipgeolocation.sdk.Configuration;
import io.ipgeolocation.sdk.api.UserAgentAPI;
import io.ipgeolocation.sdk.api.UserAgentApi;
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

        UserAgentAPI apiInstance = new UserAgentAPI(defaultClient);
        String output = "json"; // String | Desired output format (json or xml).
        UserAgentPostRequest userAgentRequest = new UserAgentPostRequest(); // UserAgentPostRequest | 
        try {
            UserAgentData result = apiInstance.getUserAgentOfCustomString()
                    .output(output)
                    .userAgentRequest(userAgentRequest)
                    .execute();
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling UserAgentApi#userAgentPost");
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
| **output** | **String**| Desired output format (json or xml). | [optional] |
| **userAgentRequest** | [**UserAgentPostRequest**](UserAgentRequest.md)|  | [optional] |

### Return type

[**UserAgentData**](UserAgentData.md)

### Authorization

[ApiKeyAuth](../README.md#ApiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json, application/xml

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Successful request |  -  |
| **400** | Bad Request – Possible reasons include:   - If the user-agent string is empty/null.  |  -  |
| **401** | Unauthorized – Possible reasons include:   - If API key (as apiKey URL parameter) is missing from the request to User Agent API.    - If the provided API key is not valid.   - If your account has been disabled or locked by admin because of any illegal activity.   - If you’re making requests after your subscription trial has been expired.   - If you’ve exceeded your requests limit.   - If your subscription is paused or is not active.   - If you’re accessing a paid feature on free subscription.  |  -  |
| **405** | If wrong HTTP request method is used for calling the endpoints. Only POST Method is acceptable for this endpoint |  -  |
| **429** | Too Many Requests – API usage limits exceeded for current plan |  -  |
| **499** | Client Closed Request – Client terminated connection before completion |  -  |
| **500** | Internal Server Error – Something went wrong on our end |  -  |

