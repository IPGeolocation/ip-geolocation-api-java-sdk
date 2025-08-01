/*
 * IPGeolocation.io - IP intelligence products
 * Ipgeolocation provides a set of APIs to make ip based decisions.
 */


package io.ipgeolocation.sdk.api;

import io.ipgeolocation.sdk.invoker.ApiCallback;
import io.ipgeolocation.sdk.invoker.ApiClient;
import io.ipgeolocation.sdk.invoker.ApiException;
import io.ipgeolocation.sdk.invoker.ApiResponse;
import io.ipgeolocation.sdk.invoker.Configuration;
import io.ipgeolocation.sdk.invoker.Pair;

import com.google.gson.reflect.TypeToken;


import io.ipgeolocation.sdk.model.BulkIPRequest;
import io.ipgeolocation.sdk.model.BulkSecurityResponse;
import io.ipgeolocation.sdk.model.SecurityAPIResponse;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IPSecurityAPI {
    private ApiClient localVarApiClient;
    private int localHostIndex;
    private String localCustomBaseUrl;

    public IPSecurityAPI() {
        this(Configuration.getDefaultApiClient());
    }

    public IPSecurityAPI(ApiClient apiClient) {
        this.localVarApiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return localVarApiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.localVarApiClient = apiClient;
    }

    public int getHostIndex() {
        return localHostIndex;
    }

    public void setHostIndex(int hostIndex) {
        this.localHostIndex = hostIndex;
    }

    public String getCustomBaseUrl() {
        return localCustomBaseUrl;
    }

    public void setCustomBaseUrl(String customBaseUrl) {
        this.localCustomBaseUrl = customBaseUrl;
    }

    private okhttp3.Call securityBulkPostCall(@javax.annotation.Nonnull BulkIPRequest bulkIpRequest, @javax.annotation.Nullable String include, @javax.annotation.Nullable String fields, @javax.annotation.Nullable String excludes, @javax.annotation.Nullable String output, @javax.annotation.Nullable String lang, final ApiCallback _callback) throws ApiException {
        String basePath = null;
        // Operation Servers
        String[] localBasePaths = new String[] {  };

        // Determine Base Path to Use
        if (localCustomBaseUrl != null){
            basePath = localCustomBaseUrl;
        } else if ( localBasePaths.length > 0 ) {
            basePath = localBasePaths[localHostIndex];
        } else {
            basePath = null;
        }

        Object localVarPostBody = bulkIpRequest;

        // create path and map variables
        String localVarPath = "/security-bulk";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        if (include != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("include", include));
        }

        if (fields != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("fields", fields));
        }

        if (excludes != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("excludes", excludes));
        }

        if (output != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("output", output));
        }

        if (lang != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("lang", lang));
        }

        final String[] localVarAccepts = {
            "application/json",
            "application/xml"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        if (localVarContentType != null) {
            localVarHeaderParams.put("Content-Type", localVarContentType);
        }

        String[] localVarAuthNames = new String[] { "ApiKeyAuth" };
        return localVarApiClient.buildCall(basePath, localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call securityBulkPostValidateBeforeCall(@javax.annotation.Nonnull BulkIPRequest bulkIpRequest, @javax.annotation.Nullable String include, @javax.annotation.Nullable String fields, @javax.annotation.Nullable String excludes, @javax.annotation.Nullable String output, @javax.annotation.Nullable String lang, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'ipgeoBulkPostRequest' is set
        if (bulkIpRequest == null) {
            throw new ApiException("Missing the required parameter 'ipgeoBulkPostRequest' when calling securityBulkPost(Async)");
        }

        return securityBulkPostCall(bulkIpRequest, include, fields, excludes, output, lang, _callback);

    }


    private ApiResponse<List<BulkSecurityResponse>> securityBulkPostWithHttpInfo(@javax.annotation.Nonnull BulkIPRequest bulkIpRequest, @javax.annotation.Nullable String include, @javax.annotation.Nullable String fields, @javax.annotation.Nullable String excludes, @javax.annotation.Nullable String output, @javax.annotation.Nullable String lang) throws ApiException {
        okhttp3.Call localVarCall = securityBulkPostValidateBeforeCall(bulkIpRequest, include, fields, excludes, output, lang, null);
        Type localVarReturnType = new TypeToken<List<BulkSecurityResponse>>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call securityBulkPostAsync(@javax.annotation.Nonnull BulkIPRequest bulkIpRequest, @javax.annotation.Nullable String include, @javax.annotation.Nullable String fields, @javax.annotation.Nullable String excludes, @javax.annotation.Nullable String output, @javax.annotation.Nullable String lang, final ApiCallback<List<BulkSecurityResponse>> _callback) throws ApiException {

        okhttp3.Call localVarCall = securityBulkPostValidateBeforeCall(bulkIpRequest, include, fields, excludes, output, lang, _callback);
        Type localVarReturnType = new TypeToken<List<BulkSecurityResponse>>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class APIsecurityBulkPostRequest {
        @javax.annotation.Nonnull
        private final BulkIPRequest bulkIpRequest;
        @javax.annotation.Nullable
        private String include;
        @javax.annotation.Nullable
        private String fields;
        @javax.annotation.Nullable
        private String excludes;
        @javax.annotation.Nullable
        private String output;
        @javax.annotation.Nullable
        private String lang;

        private APIsecurityBulkPostRequest(@javax.annotation.Nonnull BulkIPRequest bulkIpRequest) {
            this.bulkIpRequest = bulkIpRequest;
        }

        /**
         * Set include
         * @param include Include optional objects like &#x60;location&#x60;, &#x60;network&#x60;.  Use comma-separated values. Example: include&#x3D;location,network  (optional)
         * @return APIsecurityBulkPostRequest
         */
        public APIsecurityBulkPostRequest include(@javax.annotation.Nullable String include) {
            this.include = include;
            return this;
        }

        /**
         * Set fields
         * @param fields Get specific fields, objects from the response. (optional)
         * @return APIsecurityBulkPostRequest
         */
        public APIsecurityBulkPostRequest fields(@javax.annotation.Nullable String fields) {
            this.fields = fields;
            return this;
        }

        /**
         * Set excludes
         * @param excludes Exclude specific fields, objects from the response. (optional)
         * @return APIsecurityBulkPostRequest
         */
        public APIsecurityBulkPostRequest excludes(@javax.annotation.Nullable String excludes) {
            this.excludes = excludes;
            return this;
        }

        /**
         * Set output
         * @param output Desired output format. (optional)
         * @return APIsecurityBulkPostRequest
         */
        public APIsecurityBulkPostRequest output(@javax.annotation.Nullable String output) {
            this.output = output;
            return this;
        }

        /**
         * Set lang
         * @param lang By default, the API responds in English. You can change the response language by passing the language code as a query parameter &#x60;lang&#x60;. Multi language feature is available only for &#x60;paid users&#x60;. (optional)
         * @return APIsecurityBulkPostRequest
         */
        public APIsecurityBulkPostRequest lang(@javax.annotation.Nullable String lang) {
            this.lang = lang;
            return this;
        }

        /**
         * Build call for securityBulkPost
         * @param _callback ApiCallback API callback
         * @return Call to execute
         * @throws ApiException If fail to serialize the request body object
         * @http.response.details
         <table border="1">
       <caption>Response Details</caption>
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> Get the security details of bulk IPs. It may include the following information  subjecting to the availability of query parameters  - If include&#x3D;network, it will include network object  - If include&#x3D;location, it will include location object  - If include&#x3D;location,network, it will include both objects  - To get specific fields/object, use fields&#x3D;field_name e.g., security.is_tor - to exclude fields, same can be done  </td><td>  -  </td></tr>
            <tr><td> 400 </td><td> Bad Request – Possible reasons include:   - If the provided IPv4, IPv6 address, or domain name is invalid.    - If special character(s) ( ) [ ] { } | ^ &#x60; is passed in the API URL either as paramter or its value. Specially in case of API key.      - If the IP addresses JSON list is empty, or the provided JSON does not have &#39;ips&#39; field while querying /security-bulk endpoint.      - If more than 50,000 IP addresses are provided while quering from /security-bulk endpoint.     </td><td>  -  </td></tr>
            <tr><td> 401 </td><td> Unauthorized – Possible reasons include:   - Missing or invalid API key   - Account unverified, locked, or disabled   - Accessing API with an unauthorized key   - Subscription expired or downgraded   - If your account has been disabled or locked to use by the admin due to abuse or illegal activity.   - When the request to IP Security API is made using API key for a database subscription   - When the request to IP Security API is made on the &#39;paused&#39; subscription.   - If you’re making API requests after your subscription trial has been expired.   - If your active until date has passed and you need to upgrade your account.   - If bulk IP to security look-ups endpoint is called &#x60;using free subscription API key&#x60;.  </td><td>  -  </td></tr>
            <tr><td> 403 </td><td> Forbidden | Possible reasons include:   - If IP to security look-up for a domain name is done using a free subscription API key.     </td><td>  -  </td></tr>
            <tr><td> 404 </td><td> Not Found – Possible reasons include:   - If the IPv4, IPv6, or domain name does not not exists in our database.    - If the IPv4, IPv6, or domain name is passed as a path variable, instead of url parameter as ip&#x3D;.      - If the wrong endpoint is called, that does not exists in our API.  </td><td>  -  </td></tr>
            <tr><td> 405 </td><td> Method Not Allowed – Only POST method is allowed for &#x60;/security-bulk&#x60; endpoint </td><td>  -  </td></tr>
            <tr><td> 413 </td><td> Content Too Large – Possible reasons include:   - If the passed data in the POST requests is more than the limit of the API.     </td><td>  -  </td></tr>
            <tr><td> 429 </td><td> Too Many Requests – Possible reasons include:   - If the API usage limit has reached for the free subscriptions, or paid subscriptions with the status &#39;past due&#39;, &#39;deleted&#39; or &#39;trial expired&#39;.    - If the surcharge API usage limit has reached against the subscribed plan.     </td><td>  -  </td></tr>
            <tr><td> 499 </td><td> Client Closed Request – Client terminated connection before completion </td><td>  -  </td></tr>
            <tr><td> 500 </td><td> Internal Server Error – Something went wrong on our end </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call buildCall(final ApiCallback _callback) throws ApiException {
            return securityBulkPostCall(bulkIpRequest, include, fields, excludes, output, lang, _callback);
        }

        /**
         * Execute securityBulkPost request
         * @return List&lt;SecurityBulkPost200ResponseInner&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table border="1">
       <caption>Response Details</caption>
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> Get the security details of bulk IPs. It may include the following information  subjecting to the availability of query parameters  - If include&#x3D;network, it will include network object  - If include&#x3D;location, it will include location object  - If include&#x3D;location,network, it will include both objects  - To get specific fields/object, use fields&#x3D;field_name e.g., security.is_tor - to exclude fields, same can be done  </td><td>  -  </td></tr>
            <tr><td> 400 </td><td> Bad Request – Possible reasons include:   - If the provided IPv4, IPv6 address, or domain name is invalid.    - If special character(s) ( ) [ ] { } | ^ &#x60; is passed in the API URL either as paramter or its value. Specially in case of API key.      - If the IP addresses JSON list is empty, or the provided JSON does not have &#39;ips&#39; field while querying /security-bulk endpoint.      - If more than 50,000 IP addresses are provided while quering from /security-bulk endpoint.     </td><td>  -  </td></tr>
            <tr><td> 401 </td><td> Unauthorized – Possible reasons include:   - Missing or invalid API key   - Account unverified, locked, or disabled   - Accessing API with an unauthorized key   - Subscription expired or downgraded   - If your account has been disabled or locked to use by the admin due to abuse or illegal activity.   - When the request to IP Security API is made using API key for a database subscription   - When the request to IP Security API is made on the &#39;paused&#39; subscription.   - If you’re making API requests after your subscription trial has been expired.   - If your active until date has passed and you need to upgrade your account.   - If bulk IP to security look-ups endpoint is called &#x60;using free subscription API key&#x60;.  </td><td>  -  </td></tr>
            <tr><td> 403 </td><td> Forbidden | Possible reasons include:   - If IP to security look-up for a domain name is done using a free subscription API key.     </td><td>  -  </td></tr>
            <tr><td> 404 </td><td> Not Found – Possible reasons include:   - If the IPv4, IPv6, or domain name does not not exists in our database.    - If the IPv4, IPv6, or domain name is passed as a path variable, instead of url parameter as ip&#x3D;.      - If the wrong endpoint is called, that does not exists in our API.  </td><td>  -  </td></tr>
            <tr><td> 405 </td><td> Method Not Allowed – Only POST method is allowed for &#x60;/security-bulk&#x60; endpoint </td><td>  -  </td></tr>
            <tr><td> 413 </td><td> Content Too Large – Possible reasons include:   - If the passed data in the POST requests is more than the limit of the API.     </td><td>  -  </td></tr>
            <tr><td> 429 </td><td> Too Many Requests – Possible reasons include:   - If the API usage limit has reached for the free subscriptions, or paid subscriptions with the status &#39;past due&#39;, &#39;deleted&#39; or &#39;trial expired&#39;.    - If the surcharge API usage limit has reached against the subscribed plan.     </td><td>  -  </td></tr>
            <tr><td> 499 </td><td> Client Closed Request – Client terminated connection before completion </td><td>  -  </td></tr>
            <tr><td> 500 </td><td> Internal Server Error – Something went wrong on our end </td><td>  -  </td></tr>
         </table>
         */
        public List<BulkSecurityResponse> execute() throws ApiException {
            ApiResponse<List<BulkSecurityResponse>> localVarResp = securityBulkPostWithHttpInfo(bulkIpRequest, include, fields, excludes, output, lang);
            return localVarResp.getData();
        }

        /**
         * Execute securityBulkPost request with HTTP info returned
         * @return ApiResponse&lt;List&lt;SecurityBulkPost200ResponseInner&gt;&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table border="1">
       <caption>Response Details</caption>
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> Get the security details of bulk IPs. It may include the following information  subjecting to the availability of query parameters  - If include&#x3D;network, it will include network object  - If include&#x3D;location, it will include location object  - If include&#x3D;location,network, it will include both objects  - To get specific fields/object, use fields&#x3D;field_name e.g., security.is_tor - to exclude fields, same can be done  </td><td>  -  </td></tr>
            <tr><td> 400 </td><td> Bad Request – Possible reasons include:   - If the provided IPv4, IPv6 address, or domain name is invalid.    - If special character(s) ( ) [ ] { } | ^ &#x60; is passed in the API URL either as paramter or its value. Specially in case of API key.      - If the IP addresses JSON list is empty, or the provided JSON does not have &#39;ips&#39; field while querying /security-bulk endpoint.      - If more than 50,000 IP addresses are provided while quering from /security-bulk endpoint.     </td><td>  -  </td></tr>
            <tr><td> 401 </td><td> Unauthorized – Possible reasons include:   - Missing or invalid API key   - Account unverified, locked, or disabled   - Accessing API with an unauthorized key   - Subscription expired or downgraded   - If your account has been disabled or locked to use by the admin due to abuse or illegal activity.   - When the request to IP Security API is made using API key for a database subscription   - When the request to IP Security API is made on the &#39;paused&#39; subscription.   - If you’re making API requests after your subscription trial has been expired.   - If your active until date has passed and you need to upgrade your account.   - If bulk IP to security look-ups endpoint is called &#x60;using free subscription API key&#x60;.  </td><td>  -  </td></tr>
            <tr><td> 403 </td><td> Forbidden | Possible reasons include:   - If IP to security look-up for a domain name is done using a free subscription API key.     </td><td>  -  </td></tr>
            <tr><td> 404 </td><td> Not Found – Possible reasons include:   - If the IPv4, IPv6, or domain name does not not exists in our database.    - If the IPv4, IPv6, or domain name is passed as a path variable, instead of url parameter as ip&#x3D;.      - If the wrong endpoint is called, that does not exists in our API.  </td><td>  -  </td></tr>
            <tr><td> 405 </td><td> Method Not Allowed – Only POST method is allowed for &#x60;/security-bulk&#x60; endpoint </td><td>  -  </td></tr>
            <tr><td> 413 </td><td> Content Too Large – Possible reasons include:   - If the passed data in the POST requests is more than the limit of the API.     </td><td>  -  </td></tr>
            <tr><td> 429 </td><td> Too Many Requests – Possible reasons include:   - If the API usage limit has reached for the free subscriptions, or paid subscriptions with the status &#39;past due&#39;, &#39;deleted&#39; or &#39;trial expired&#39;.    - If the surcharge API usage limit has reached against the subscribed plan.     </td><td>  -  </td></tr>
            <tr><td> 499 </td><td> Client Closed Request – Client terminated connection before completion </td><td>  -  </td></tr>
            <tr><td> 500 </td><td> Internal Server Error – Something went wrong on our end </td><td>  -  </td></tr>
         </table>
         */
        public ApiResponse<List<BulkSecurityResponse>> executeWithHttpInfo() throws ApiException {
            return securityBulkPostWithHttpInfo(bulkIpRequest, include, fields, excludes, output, lang);
        }

        /**
         * Execute securityBulkPost request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table border="1">
       <caption>Response Details</caption>
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> Get the security details of bulk IPs. It may include the following information  subjecting to the availability of query parameters  - If include&#x3D;network, it will include network object  - If include&#x3D;location, it will include location object  - If include&#x3D;location,network, it will include both objects  - To get specific fields/object, use fields&#x3D;field_name e.g., security.is_tor - to exclude fields, same can be done  </td><td>  -  </td></tr>
            <tr><td> 400 </td><td> Bad Request – Possible reasons include:   - If the provided IPv4, IPv6 address, or domain name is invalid.    - If special character(s) ( ) [ ] { } | ^ &#x60; is passed in the API URL either as paramter or its value. Specially in case of API key.      - If the IP addresses JSON list is empty, or the provided JSON does not have &#39;ips&#39; field while querying /security-bulk endpoint.      - If more than 50,000 IP addresses are provided while quering from /security-bulk endpoint.     </td><td>  -  </td></tr>
            <tr><td> 401 </td><td> Unauthorized – Possible reasons include:   - Missing or invalid API key   - Account unverified, locked, or disabled   - Accessing API with an unauthorized key   - Subscription expired or downgraded   - If your account has been disabled or locked to use by the admin due to abuse or illegal activity.   - When the request to IP Security API is made using API key for a database subscription   - When the request to IP Security API is made on the &#39;paused&#39; subscription.   - If you’re making API requests after your subscription trial has been expired.   - If your active until date has passed and you need to upgrade your account.   - If bulk IP to security look-ups endpoint is called &#x60;using free subscription API key&#x60;.  </td><td>  -  </td></tr>
            <tr><td> 403 </td><td> Forbidden | Possible reasons include:   - If IP to security look-up for a domain name is done using a free subscription API key.     </td><td>  -  </td></tr>
            <tr><td> 404 </td><td> Not Found – Possible reasons include:   - If the IPv4, IPv6, or domain name does not not exists in our database.    - If the IPv4, IPv6, or domain name is passed as a path variable, instead of url parameter as ip&#x3D;.      - If the wrong endpoint is called, that does not exists in our API.  </td><td>  -  </td></tr>
            <tr><td> 405 </td><td> Method Not Allowed – Only POST method is allowed for &#x60;/security-bulk&#x60; endpoint </td><td>  -  </td></tr>
            <tr><td> 413 </td><td> Content Too Large – Possible reasons include:   - If the passed data in the POST requests is more than the limit of the API.     </td><td>  -  </td></tr>
            <tr><td> 429 </td><td> Too Many Requests – Possible reasons include:   - If the API usage limit has reached for the free subscriptions, or paid subscriptions with the status &#39;past due&#39;, &#39;deleted&#39; or &#39;trial expired&#39;.    - If the surcharge API usage limit has reached against the subscribed plan.     </td><td>  -  </td></tr>
            <tr><td> 499 </td><td> Client Closed Request – Client terminated connection before completion </td><td>  -  </td></tr>
            <tr><td> 500 </td><td> Internal Server Error – Something went wrong on our end </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<List<BulkSecurityResponse>> _callback) throws ApiException {
            return securityBulkPostAsync(bulkIpRequest, include, fields, excludes, output, lang, _callback);
        }
    }

    /**
     * 
     * The Bulk IP Security Lookup API can provide security details for up to &#x60;50,000&#x60; bulk IPs. This API also has parameters to customize the response, just like the single IP Security Lookup API.
     * @param bulkIpRequest  (required)
     * @return APIsecurityBulkPostRequest
     * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Get the security details of bulk IPs. It may include the following information  subjecting to the availability of query parameters  - If include&#x3D;network, it will include network object  - If include&#x3D;location, it will include location object  - If include&#x3D;location,network, it will include both objects  - To get specific fields/object, use fields&#x3D;field_name e.g., security.is_tor - to exclude fields, same can be done  </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Bad Request – Possible reasons include:   - If the provided IPv4, IPv6 address, or domain name is invalid.    - If special character(s) ( ) [ ] { } | ^ &#x60; is passed in the API URL either as paramter or its value. Specially in case of API key.      - If the IP addresses JSON list is empty, or the provided JSON does not have &#39;ips&#39; field while querying /security-bulk endpoint.      - If more than 50,000 IP addresses are provided while quering from /security-bulk endpoint.     </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized – Possible reasons include:   - Missing or invalid API key   - Account unverified, locked, or disabled   - Accessing API with an unauthorized key   - Subscription expired or downgraded   - If your account has been disabled or locked to use by the admin due to abuse or illegal activity.   - When the request to IP Security API is made using API key for a database subscription   - When the request to IP Security API is made on the &#39;paused&#39; subscription.   - If you’re making API requests after your subscription trial has been expired.   - If your active until date has passed and you need to upgrade your account.   - If bulk IP to security look-ups endpoint is called &#x60;using free subscription API key&#x60;.  </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> Forbidden | Possible reasons include:   - If IP to security look-up for a domain name is done using a free subscription API key.     </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found – Possible reasons include:   - If the IPv4, IPv6, or domain name does not not exists in our database.    - If the IPv4, IPv6, or domain name is passed as a path variable, instead of url parameter as ip&#x3D;.      - If the wrong endpoint is called, that does not exists in our API.  </td><td>  -  </td></tr>
        <tr><td> 405 </td><td> Method Not Allowed – Only POST method is allowed for &#x60;/security-bulk&#x60; endpoint </td><td>  -  </td></tr>
        <tr><td> 413 </td><td> Content Too Large – Possible reasons include:   - If the passed data in the POST requests is more than the limit of the API.     </td><td>  -  </td></tr>
        <tr><td> 429 </td><td> Too Many Requests – Possible reasons include:   - If the API usage limit has reached for the free subscriptions, or paid subscriptions with the status &#39;past due&#39;, &#39;deleted&#39; or &#39;trial expired&#39;.    - If the surcharge API usage limit has reached against the subscribed plan.     </td><td>  -  </td></tr>
        <tr><td> 499 </td><td> Client Closed Request – Client terminated connection before completion </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> Internal Server Error – Something went wrong on our end </td><td>  -  </td></tr>
     </table>
     */
    public APIsecurityBulkPostRequest getBulkIPSecurity(@javax.annotation.Nonnull BulkIPRequest bulkIpRequest) {
        return new APIsecurityBulkPostRequest(bulkIpRequest);
    }
    private okhttp3.Call securityGetCall(@javax.annotation.Nullable String ip, @javax.annotation.Nullable String include, @javax.annotation.Nullable String fields, @javax.annotation.Nullable String excludes, @javax.annotation.Nullable String output, @javax.annotation.Nullable String lang, final ApiCallback _callback) throws ApiException {
        String basePath = null;
        // Operation Servers
        String[] localBasePaths = new String[] {  };

        // Determine Base Path to Use
        if (localCustomBaseUrl != null){
            basePath = localCustomBaseUrl;
        } else if ( localBasePaths.length > 0 ) {
            basePath = localBasePaths[localHostIndex];
        } else {
            basePath = null;
        }

        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/security";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        if (ip != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("ip", ip));
        }

        if (include != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("include", include));
        }

        if (fields != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("fields", fields));
        }

        if (excludes != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("excludes", excludes));
        }

        if (output != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("output", output));
        }

        if (lang != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("lang", lang));
        }

        final String[] localVarAccepts = {
            "application/json",
            "application/xml"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        if (localVarContentType != null) {
            localVarHeaderParams.put("Content-Type", localVarContentType);
        }

        String[] localVarAuthNames = new String[] { "ApiKeyAuth" };
        return localVarApiClient.buildCall(basePath, localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call securityGetValidateBeforeCall(@javax.annotation.Nullable String ip, @javax.annotation.Nullable String include, @javax.annotation.Nullable String fields, @javax.annotation.Nullable String excludes, @javax.annotation.Nullable String output, @javax.annotation.Nullable String lang, final ApiCallback _callback) throws ApiException {
        return securityGetCall(ip, include, fields, excludes, output, lang, _callback);

    }


    private ApiResponse<SecurityAPIResponse> securityGetWithHttpInfo(@javax.annotation.Nullable String ip, @javax.annotation.Nullable String include, @javax.annotation.Nullable String fields, @javax.annotation.Nullable String excludes, @javax.annotation.Nullable String output, @javax.annotation.Nullable String lang) throws ApiException {
        okhttp3.Call localVarCall = securityGetValidateBeforeCall(ip, include, fields, excludes, output, lang, null);
        Type localVarReturnType = new TypeToken<SecurityAPIResponse>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call securityGetAsync(@javax.annotation.Nullable String ip, @javax.annotation.Nullable String include, @javax.annotation.Nullable String fields, @javax.annotation.Nullable String excludes, @javax.annotation.Nullable String output, @javax.annotation.Nullable String lang, final ApiCallback<SecurityAPIResponse> _callback) throws ApiException {

        okhttp3.Call localVarCall = securityGetValidateBeforeCall(ip, include, fields, excludes, output, lang, _callback);
        Type localVarReturnType = new TypeToken<SecurityAPIResponse>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class APIsecurityGetRequest {
        @javax.annotation.Nullable
        private String ip;
        @javax.annotation.Nullable
        private String include;
        @javax.annotation.Nullable
        private String fields;
        @javax.annotation.Nullable
        private String excludes;
        @javax.annotation.Nullable
        private String output;
        @javax.annotation.Nullable
        private String lang;

        private APIsecurityGetRequest() {
        }

        /**
         * Set ip
         * @param ip query parameter &#39;ip&#39;. If not provided, will be your network IP (optional)
         * @return APIsecurityGetRequest
         */
        public APIsecurityGetRequest ip(@javax.annotation.Nullable String ip) {
            this.ip = ip;
            return this;
        }

        /**
         * Set include
         * @param include Include optional details like location and/or network. (optional)
         * @return APIsecurityGetRequest
         */
        public APIsecurityGetRequest include(@javax.annotation.Nullable String include) {
            this.include = include;
            return this;
        }

        /**
         * Set fields
         * @param fields Get specific fields, objects from the response. (optional)
         * @return APIsecurityGetRequest
         */
        public APIsecurityGetRequest fields(@javax.annotation.Nullable String fields) {
            this.fields = fields;
            return this;
        }

        /**
         * Set excludes
         * @param excludes Exclude specific fields, objects from the response. (optional)
         * @return APIsecurityGetRequest
         */
        public APIsecurityGetRequest excludes(@javax.annotation.Nullable String excludes) {
            this.excludes = excludes;
            return this;
        }

        /**
         * Set output
         * @param output Desired output format (json or xml). (optional)
         * @return APIsecurityGetRequest
         */
        public APIsecurityGetRequest output(@javax.annotation.Nullable String output) {
            this.output = output;
            return this;
        }

        /**
         * Set lang
         * @param lang By default, the API responds in English. You can change the response language by passing the language code as a query parameter &#x60;lang&#x60;. Multi language feature is available only for &#x60;paid users&#x60;. (optional)
         * @return APIsecurityGetRequest
         */
        public APIsecurityGetRequest lang(@javax.annotation.Nullable String lang) {
            this.lang = lang;
            return this;
        }

        /**
         * Build call for securityGet
         * @param _callback ApiCallback API callback
         * @return Call to execute
         * @throws ApiException If fail to serialize the request body object
         * @http.response.details
         <table border="1">
       <caption>Response Details</caption>
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> Get the security details of the ip. It may include the following information  subjecting to the availability of query parameters  - If include&#x3D;network, it will include network object  - If include&#x3D;location, it will include location object  - If include&#x3D;location,network, it will include both objects  - To get specific fields/object, use fields&#x3D;field_name e.g., security.is_tor - to exclude fields, same can be done  </td><td>  -  </td></tr>
            <tr><td> 400 </td><td> Bad Request – Possible reasons include:   - If the provided IPv4, IPv6 address is invalid.    - If special character(s) ( ) [ ] { } | ^ &#x60; is passed in the API URL either as paramter or its value. Specially in case of API key.        </td><td>  -  </td></tr>
            <tr><td> 401 </td><td> Unauthorized – Possible reasons include:   - Missing or invalid API key   - Account unverified, locked, or disabled   - Accessing API with an unauthorized key   - Subscription expired or downgraded   - If your account has been disabled or locked to use by the admin due to abuse or illegal activity.   - When the request to IP Security API is made using API key for a database subscription   - When the request to IP Security API is made on the &#39;paused&#39; subscription.   - If you’re making API requests after your subscription trial has been expired.   - If your active until date has passed and you need to upgrade your account.  </td><td>  -  </td></tr>
            <tr><td> 404 </td><td> Not Found – Possible reasons include:   - If the IPv4, IPv6, or domain name does not exist in our database.    - If the IPv4, IPv6, or domain name is passed as a path variable, instead of url parameter as ip&#x3D;.      - If the wrong endpoint is called, that does not exist in our API.  </td><td>  -  </td></tr>
            <tr><td> 405 </td><td> Method Not Allowed – Only GET is allowed for &#x60;/security&#x60; endpoint </td><td>  -  </td></tr>
            <tr><td> 429 </td><td> Too Many Requests – Possible reasons include:   - If the API usage limit has reached for the free subscriptions, or paid subscriptions with the status &#39;past due&#39;, &#39;deleted&#39; or &#39;trial expired&#39;.    - If the surcharge API usage limit has reached against the subscribed plan.     </td><td>  -  </td></tr>
            <tr><td> 499 </td><td> Client Closed Request – Client terminated connection before completion </td><td>  -  </td></tr>
            <tr><td> 500 </td><td> Internal Server Error – Something went wrong on our end </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call buildCall(final ApiCallback _callback) throws ApiException {
            return securityGetCall(ip, include, fields, excludes, output, lang, _callback);
        }

        /**
         * Execute securityGet request
         * @return SecurityAPIResponse
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table border="1">
       <caption>Response Details</caption>
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> Get the security details of the ip. It may include the following information  subjecting to the availability of query parameters  - If include&#x3D;network, it will include network object  - If include&#x3D;location, it will include location object  - If include&#x3D;location,network, it will include both objects  - To get specific fields/object, use fields&#x3D;field_name e.g., security.is_tor - to exclude fields, same can be done  </td><td>  -  </td></tr>
            <tr><td> 400 </td><td> Bad Request – Possible reasons include:   - If the provided IPv4, IPv6 address is invalid.    - If special character(s) ( ) [ ] { } | ^ &#x60; is passed in the API URL either as paramter or its value. Specially in case of API key.        </td><td>  -  </td></tr>
            <tr><td> 401 </td><td> Unauthorized – Possible reasons include:   - Missing or invalid API key   - Account unverified, locked, or disabled   - Accessing API with an unauthorized key   - Subscription expired or downgraded   - If your account has been disabled or locked to use by the admin due to abuse or illegal activity.   - When the request to IP Security API is made using API key for a database subscription   - When the request to IP Security API is made on the &#39;paused&#39; subscription.   - If you’re making API requests after your subscription trial has been expired.   - If your active until date has passed and you need to upgrade your account.  </td><td>  -  </td></tr>
            <tr><td> 404 </td><td> Not Found – Possible reasons include:   - If the IPv4, IPv6, or domain name does not exist in our database.    - If the IPv4, IPv6, or domain name is passed as a path variable, instead of url parameter as ip&#x3D;.      - If the wrong endpoint is called, that does not exist in our API.  </td><td>  -  </td></tr>
            <tr><td> 405 </td><td> Method Not Allowed – Only GET is allowed for &#x60;/security&#x60; endpoint </td><td>  -  </td></tr>
            <tr><td> 429 </td><td> Too Many Requests – Possible reasons include:   - If the API usage limit has reached for the free subscriptions, or paid subscriptions with the status &#39;past due&#39;, &#39;deleted&#39; or &#39;trial expired&#39;.    - If the surcharge API usage limit has reached against the subscribed plan.     </td><td>  -  </td></tr>
            <tr><td> 499 </td><td> Client Closed Request – Client terminated connection before completion </td><td>  -  </td></tr>
            <tr><td> 500 </td><td> Internal Server Error – Something went wrong on our end </td><td>  -  </td></tr>
         </table>
         */
        public SecurityAPIResponse execute() throws ApiException {
            ApiResponse<SecurityAPIResponse> localVarResp = securityGetWithHttpInfo(ip, include, fields, excludes, output, lang);
            return localVarResp.getData();
        }

        /**
         * Execute securityGet request with HTTP info returned
         * @return ApiResponse&lt;SecurityAPIResponse&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table border="1">
       <caption>Response Details</caption>
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> Get the security details of the ip. It may include the following information  subjecting to the availability of query parameters  - If include&#x3D;network, it will include network object  - If include&#x3D;location, it will include location object  - If include&#x3D;location,network, it will include both objects  - To get specific fields/object, use fields&#x3D;field_name e.g., security.is_tor - to exclude fields, same can be done  </td><td>  -  </td></tr>
            <tr><td> 400 </td><td> Bad Request – Possible reasons include:   - If the provided IPv4, IPv6 address is invalid.    - If special character(s) ( ) [ ] { } | ^ &#x60; is passed in the API URL either as paramter or its value. Specially in case of API key.        </td><td>  -  </td></tr>
            <tr><td> 401 </td><td> Unauthorized – Possible reasons include:   - Missing or invalid API key   - Account unverified, locked, or disabled   - Accessing API with an unauthorized key   - Subscription expired or downgraded   - If your account has been disabled or locked to use by the admin due to abuse or illegal activity.   - When the request to IP Security API is made using API key for a database subscription   - When the request to IP Security API is made on the &#39;paused&#39; subscription.   - If you’re making API requests after your subscription trial has been expired.   - If your active until date has passed and you need to upgrade your account.  </td><td>  -  </td></tr>
            <tr><td> 404 </td><td> Not Found – Possible reasons include:   - If the IPv4, IPv6, or domain name does not exist in our database.    - If the IPv4, IPv6, or domain name is passed as a path variable, instead of url parameter as ip&#x3D;.      - If the wrong endpoint is called, that does not exist in our API.  </td><td>  -  </td></tr>
            <tr><td> 405 </td><td> Method Not Allowed – Only GET is allowed for &#x60;/security&#x60; endpoint </td><td>  -  </td></tr>
            <tr><td> 429 </td><td> Too Many Requests – Possible reasons include:   - If the API usage limit has reached for the free subscriptions, or paid subscriptions with the status &#39;past due&#39;, &#39;deleted&#39; or &#39;trial expired&#39;.    - If the surcharge API usage limit has reached against the subscribed plan.     </td><td>  -  </td></tr>
            <tr><td> 499 </td><td> Client Closed Request – Client terminated connection before completion </td><td>  -  </td></tr>
            <tr><td> 500 </td><td> Internal Server Error – Something went wrong on our end </td><td>  -  </td></tr>
         </table>
         */
        public ApiResponse<SecurityAPIResponse> executeWithHttpInfo() throws ApiException {
            return securityGetWithHttpInfo(ip, include, fields, excludes, output, lang);
        }

        /**
         * Execute securityGet request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table border="1">
       <caption>Response Details</caption>
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> Get the security details of the ip. It may include the following information  subjecting to the availability of query parameters  - If include&#x3D;network, it will include network object  - If include&#x3D;location, it will include location object  - If include&#x3D;location,network, it will include both objects  - To get specific fields/object, use fields&#x3D;field_name e.g., security.is_tor - to exclude fields, same can be done  </td><td>  -  </td></tr>
            <tr><td> 400 </td><td> Bad Request – Possible reasons include:   - If the provided IPv4, IPv6 address is invalid.    - If special character(s) ( ) [ ] { } | ^ &#x60; is passed in the API URL either as paramter or its value. Specially in case of API key.        </td><td>  -  </td></tr>
            <tr><td> 401 </td><td> Unauthorized – Possible reasons include:   - Missing or invalid API key   - Account unverified, locked, or disabled   - Accessing API with an unauthorized key   - Subscription expired or downgraded   - If your account has been disabled or locked to use by the admin due to abuse or illegal activity.   - When the request to IP Security API is made using API key for a database subscription   - When the request to IP Security API is made on the &#39;paused&#39; subscription.   - If you’re making API requests after your subscription trial has been expired.   - If your active until date has passed and you need to upgrade your account.  </td><td>  -  </td></tr>
            <tr><td> 404 </td><td> Not Found – Possible reasons include:   - If the IPv4, IPv6, or domain name does not exist in our database.    - If the IPv4, IPv6, or domain name is passed as a path variable, instead of url parameter as ip&#x3D;.      - If the wrong endpoint is called, that does not exist in our API.  </td><td>  -  </td></tr>
            <tr><td> 405 </td><td> Method Not Allowed – Only GET is allowed for &#x60;/security&#x60; endpoint </td><td>  -  </td></tr>
            <tr><td> 429 </td><td> Too Many Requests – Possible reasons include:   - If the API usage limit has reached for the free subscriptions, or paid subscriptions with the status &#39;past due&#39;, &#39;deleted&#39; or &#39;trial expired&#39;.    - If the surcharge API usage limit has reached against the subscribed plan.     </td><td>  -  </td></tr>
            <tr><td> 499 </td><td> Client Closed Request – Client terminated connection before completion </td><td>  -  </td></tr>
            <tr><td> 500 </td><td> Internal Server Error – Something went wrong on our end </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<SecurityAPIResponse> _callback) throws ApiException {
            return securityGetAsync(ip, include, fields, excludes, output, lang, _callback);
        }
    }

    /**
     * 
     * IP Security API provides security details of a given IP. It detects whether the IP is proxy, tor or bot. It also shows the proxy types of the IP (like VPN, PROXY, RELAY etc.) with it&#39;s VPN/proxy service provider making our API powerful VPN checker. It finds the IPs that are involved in spam activities. It also checks whether the IP links to a cloud provider and includes the provider&#39;s name.
     * @return APIsecurityGetRequest
     * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Get the security details of the ip. It may include the following information  subjecting to the availability of query parameters  - If include&#x3D;network, it will include network object  - If include&#x3D;location, it will include location object  - If include&#x3D;location,network, it will include both objects  - To get specific fields/object, use fields&#x3D;field_name e.g., security.is_tor - to exclude fields, same can be done  </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Bad Request – Possible reasons include:   - If the provided IPv4, IPv6 address is invalid.    - If special character(s) ( ) [ ] { } | ^ &#x60; is passed in the API URL either as paramter or its value. Specially in case of API key.        </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized – Possible reasons include:   - Missing or invalid API key   - Account unverified, locked, or disabled   - Accessing API with an unauthorized key   - Subscription expired or downgraded   - If your account has been disabled or locked to use by the admin due to abuse or illegal activity.   - When the request to IP Security API is made using API key for a database subscription   - When the request to IP Security API is made on the &#39;paused&#39; subscription.   - If you’re making API requests after your subscription trial has been expired.   - If your active until date has passed and you need to upgrade your account.  </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found – Possible reasons include:   - If the IPv4, IPv6, or domain name does not exist in our database.    - If the IPv4, IPv6, or domain name is passed as a path variable, instead of url parameter as ip&#x3D;.      - If the wrong endpoint is called, that does not exist in our API.  </td><td>  -  </td></tr>
        <tr><td> 405 </td><td> Method Not Allowed – Only GET is allowed for &#x60;/security&#x60; endpoint </td><td>  -  </td></tr>
        <tr><td> 429 </td><td> Too Many Requests – Possible reasons include:   - If the API usage limit has reached for the free subscriptions, or paid subscriptions with the status &#39;past due&#39;, &#39;deleted&#39; or &#39;trial expired&#39;.    - If the surcharge API usage limit has reached against the subscribed plan.     </td><td>  -  </td></tr>
        <tr><td> 499 </td><td> Client Closed Request – Client terminated connection before completion </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> Internal Server Error – Something went wrong on our end </td><td>  -  </td></tr>
     </table>
     */
    public APIsecurityGetRequest getIPSecurity() {
        return new APIsecurityGetRequest();
    }
}
