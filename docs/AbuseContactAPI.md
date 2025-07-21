# AbuseContactAPI

All URIs are relative to *https://api.ipgeolocation.io/v2*

| Method                                                            | HTTP request | Description |
|-------------------------------------------------------------------| ------------- | -------------|
| [**getAbuseContactInfo**](AbuseContactAPI.md#getabusecontactinfo) | **GET** /abuse |  |



# **getAbuseContactInfo**
> AbuseResponse getAbuseContactInfo().ip(ip).excludes(excludes).fields(fields).execute();



The Abuse Contact API provides essential contact information to report abusive activity associated with IP addresses. By querying an IP address (IPv4 or IPv6), users receive detailed abuse contact data, including the responsible organization, abuse handling role, contact emails, phone numbers, and registered address. This enables users to swiftly take action to report and mitigate threats such as spam, DDoS attacks, and phishing.     In addition to abuse-specific contacts, the API also includes registration metadata like the registered country and abuse handle. This empowers cybersecurity teams, hosting providers, and compliance entities to take appropriate legal or administrative action. 

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **ip** | **String**| query parameter &#39;ip&#39;. | [optional] |
| **excludes** | **String**| You can exclude specific fields from the API response (except the ip field) by listing them in the excludes parameter as a comma-separated list. For example, you want to remove emails and handle from api response, you can put the keys in excludes parameter like this. | [optional] |
| **fields** | **String**| You can customize the API response by using the fields parameter to include only the specific data you need. For example, to retrieve only the role and emails, specify these keys in the fields parameter as shown below. | [optional] |

### Return type

[**AbuseResponse**](AbuseResponse.md)

### Authorization

[ApiKeyAuth](../README.md#authentication-setup)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, application/xml

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Successful response |  -  |
| **400** | Bad Request – Possible reasons include:   - If the provided IPv4, IPv6 address, or ASN is invalid.    - If special character(s) ( ) [ ] { } | ^ &#x60; is passed in the API URL either as paramter or its value. Specially in case of API key.        |  -  |
| **401** | Unauthorized – Possible reasons include:   - Missing or invalid API key   - Account unverified, locked, or disabled   - Accessing API with an unauthorized key   - Subscription expired or downgraded   - If your account has been disabled or locked to use by the admin due to abuse or illegal activity.   - When the request to IP Abuse Contact API is made using API key for a database subscription   - When the request to IP Abuse Contact API is made on the &#39;paused&#39; subscription.   - If you’re making API requests after your subscription trial has been expired.   - If your active until date has passed and you need to upgrade your account.  |  -  |
| **404** | Not Found – Possible reasons include:   - If the IPv4, IPv6, or ASN name does not exist in our database.    - If the IPv4, IPv6, or ASN  is passed as a path variable, instead of url parameter as ip&#x3D;.      - If the wrong endpoint is called, that does not exist in our API.  |  -  |
| **405** | Method Not Allowed – Only GET is allowed for &#x60;/abuse&#x60; endpoint |  -  |
| **429** | Too Many Requests – Possible reasons include:   - If the API usage limit has reached for the free subscriptions, or paid subscriptions with the status &#39;past due&#39;, &#39;deleted&#39; or &#39;trial expired&#39;.    - If the surcharge API usage limit has reached against the subscribed plan.     |  -  |
| **499** | Client Closed Request – Client terminated connection before completion |  -  |
| **500** | Internal Server Error – Something went wrong on our end |  -  |

