# UserAgentAPI

All URIs are relative to *https://api.ipgeolocation.io/v2*

| Method                                                                       | HTTP request | Description |
|------------------------------------------------------------------------------| ------------- | -------------|
| [**getUserAgent**](UserAgentAPI.md#getuseragent)                             | **GET** /user-agent | Get details of user-agent |
| [**getBulkUserAgent**](UserAgentAPI.md#getbulkuseragent)                     | **POST** /user-agent-bulk | Handle multiple user-agent string lookups |
| [**getUserAgentOfCustomString**](UserAgentAPI.md#getuseragentofcustomstring) | **POST** /user-agent | Handle single User-Agent string |



# **getUserAgent**
> UserAgentData getUserAgent().userAgent(userAgent).execute();

Get details of user-agent

User Agent Parser API provides the accurate browser, device, and operating system details from a User Agent String. It also provides information about crawlers and attack sources. You can use these details to customize user experience, prevent crawlers and attackers from accessing your website.

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **userAgent** | **String**|  | [optional] |
| **output** | **String**| Desired output format (json or xml). | [optional] |

### Return type

[**UserAgentData**](UserAgentData.md)

### Authorization

[ApiKeyAuth](../README.md#authentication-setup)

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

# **getBulkUserAgent**
> List&lt;UserAgentData&gt; getBulkUserAgent().parseBulkUserAgentStringsRequest(parseBulkUserAgentStringsRequest).execute();

Handle multiple user-agent string lookups

This endpoint allows you to perform the parsing of multiple User-Angent strings (max. 50,000) at the same time. The requests count per round is equal to total User-Agent strings passed. This feature is &#x60;only available for paid plans&#x60;.

### Parameters

| Name                     | Type | Description  | Notes |
|--------------------------| ------------- | ------------- | -------------|
| **output**               | **String**| Desired output format (json or xml). | [optional] |
| **UserAgentBulkRequest** | [**UserAgentBulkRequest**](UserAgentBulkRequest.md)|  | [optional] |

### Return type

[**List&lt;UserAgentData&gt;**](UserAgentData.md)

### Authorization

[ApiKeyAuth](../README.md#authentication-setup)

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

# **getUserAgentOfCustomString**
> UserAgentData getUserAgentOfCustomString().parseUserAgentStringRequest(parseUserAgentStringRequest).execute();

Handle single User-Agent string

You can also provide custom User-Agent string to parse in JSON payload. This endpoint is meant to be called from server-side and is available for paid subscriptions only.

### Parameters

| Name                 | Type | Description  | Notes |
|----------------------| ------------- | ------------- | -------------|
| **output**           | **String**| Desired output format (json or xml). | [optional] |
| **UserAgentRequest** | [**UserAgentRequest**](UserAgentRequest.md)|  | [optional] |

### Return type

[**UserAgentData**](UserAgentData.md)

### Authorization

[ApiKeyAuth](../README.md#authentication-setup)

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

