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
import io.ipgeolocation.sdk.model.GeolocationResponse;
import io.ipgeolocation.sdk.model.BulkGeolocationResponse;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IPGeolocationAPI {
    private ApiClient localVarApiClient;
    private int localHostIndex;
    private String localCustomBaseUrl;

    public IPGeolocationAPI() {
        this(Configuration.getDefaultApiClient());
    }

    public IPGeolocationAPI(ApiClient apiClient) {
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

    private okhttp3.Call ipgeoBulkPostCall(@javax.annotation.Nonnull BulkIPRequest bulkIpRequest, @javax.annotation.Nullable String lang, @javax.annotation.Nullable String fields, @javax.annotation.Nullable String excludes, @javax.annotation.Nullable String include, @javax.annotation.Nullable String output, final ApiCallback _callback) throws ApiException {
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
        String localVarPath = "/ipgeo-bulk";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        if (lang != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("lang", lang));
        }

        if (fields != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("fields", fields));
        }

        if (excludes != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("excludes", excludes));
        }

        if (include != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("include", include));
        }

        if (output != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("output", output));
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
    private okhttp3.Call ipgeoBulkPostValidateBeforeCall(@javax.annotation.Nonnull BulkIPRequest bulkIpRequest, @javax.annotation.Nullable String lang, @javax.annotation.Nullable String fields, @javax.annotation.Nullable String excludes, @javax.annotation.Nullable String include, @javax.annotation.Nullable String output, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'ipgeoBulkPostRequest' is set
        if (bulkIpRequest == null) {
            throw new ApiException("Missing the required parameter 'ipgeoBulkPostRequest' when calling ipgeoBulkPost(Async)");
        }

        return ipgeoBulkPostCall(bulkIpRequest, lang, fields, excludes, include, output, _callback);

    }


    private ApiResponse<List<BulkGeolocationResponse>> ipgeoBulkPostWithHttpInfo(@javax.annotation.Nonnull BulkIPRequest bulkIpRequest, @javax.annotation.Nullable String lang, @javax.annotation.Nullable String fields, @javax.annotation.Nullable String excludes, @javax.annotation.Nullable String include, @javax.annotation.Nullable String output) throws ApiException {
        okhttp3.Call localVarCall = ipgeoBulkPostValidateBeforeCall(bulkIpRequest, lang, fields, excludes, include, output, null);
        Type localVarReturnType = new TypeToken<List<BulkGeolocationResponse>>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call ipgeoBulkPostAsync(@javax.annotation.Nonnull BulkIPRequest bulkIpRequest, @javax.annotation.Nullable String lang, @javax.annotation.Nullable String fields, @javax.annotation.Nullable String excludes, @javax.annotation.Nullable String include, @javax.annotation.Nullable String output, final ApiCallback<List<BulkGeolocationResponse>> _callback) throws ApiException {

        okhttp3.Call localVarCall = ipgeoBulkPostValidateBeforeCall(bulkIpRequest, lang, fields, excludes, include, output, _callback);
        Type localVarReturnType = new TypeToken<List<BulkGeolocationResponse>>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class APIipgeoBulkPostRequest {
        @javax.annotation.Nonnull
        private final BulkIPRequest bulkIpRequest;
        @javax.annotation.Nullable
        private String lang;
        @javax.annotation.Nullable
        private String fields;
        @javax.annotation.Nullable
        private String excludes;
        @javax.annotation.Nullable
        private String include;
        @javax.annotation.Nullable
        private String output;

        private APIipgeoBulkPostRequest(@javax.annotation.Nonnull BulkIPRequest bulkIpRequest) {
            this.bulkIpRequest = bulkIpRequest;
        }

        /**
         * Set lang
         * @param lang By default, the API responds in English. You can change the response language by passing the language code as a query parameter &#x60;lang&#x60;. Multi language feature is available only for &#x60;paid users&#x60;. (optional)
         * @return APIipgeoBulkPostRequest
         */
        public APIipgeoBulkPostRequest lang(@javax.annotation.Nullable String lang) {
            this.lang = lang;
            return this;
        }

        /**
         * Set fields
         * @param fields you can filter the API response by specifying the fields that you need, instead of getting the full response. To do this, pass the desired field names using the &#x60;fields&#x60; query parameter with each field represented as a dot-separated path. (optional)
         * @return APIipgeoBulkPostRequest
         */
        public APIipgeoBulkPostRequest fields(@javax.annotation.Nullable String fields) {
            this.fields = fields;
            return this;
        }

        /**
         * Set excludes
         * @param excludes you can also filter the API response by excluding specific fields (except the IP address) that you don&#39;t need. To do this, pass the unwanted field names using the excludes query parameter, with each field represented as a dot-separated path (optional)
         * @return APIipgeoBulkPostRequest
         */
        public APIipgeoBulkPostRequest excludes(@javax.annotation.Nullable String excludes) {
            this.excludes = excludes;
            return this;
        }

        /**
         * Set include
         * @param include IP Geolocation API also provides IP-Security, abuse, timezone, user-agent and DMA (Designated Market Area) code, which is specifically used in the US for marketing and regional targeting information on Advanced API subscription, but doesn&#39;t respond it by default. To get these information along with the geolocation information, you must pass the &#x60;include&#x3D;security&#x60; or &#x60;include&#x3D;abuse&#x60; or &#x60;include&#x3D;dma&#x60; or &#x60;include&#x3D;time_zone&#x60; or &#x60;include&#x3D;user-agent&#x60; or you can fetch multiples by adding values in comma-separated way. In addition to that, IPGeolocation API also provide hostname lookup for an IP address on all the paid API subscriptions (STANDARD and ADVANCED), but doesn&#39;t respond it by default. To get the hostname for an IP address, you can pass one of the three values &#x60;hostname, liveHostname, hostnameFallbackLive&#x60; as a URL parameter &#x60;include&#x3D;&#x60;. (optional)
         * @return APIipgeoBulkPostRequest
         */
        public APIipgeoBulkPostRequest include(@javax.annotation.Nullable String include) {
            this.include = include;
            return this;
        }

        /**
         * Set output
         * @param output Desired output format(json or xml). (optional)
         * @return APIipgeoBulkPostRequest
         */
        public APIipgeoBulkPostRequest output(@javax.annotation.Nullable String output) {
            this.output = output;
            return this;
        }

        /**
         * Build call for ipgeoBulkPost
         * @param _callback ApiCallback API callback
         * @return Call to execute
         * @throws ApiException If fail to serialize the request body object
         * @http.response.details
         <table border="1">
       <caption>Response Details</caption>
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> success </td><td>  -  </td></tr>
            <tr><td> 400 </td><td> Bad Request – Possible reasons include:   - If the provided IPv4, IPv6 address, or domain name is invalid.    - If special character(s) ( ) [ ] { } | ^ &#x60; is passed in the API URL either as paramter or its value. Specially in case of API key.      - If the IP addresses JSON list is empty, or the provided JSON does not have &#39;ips&#39; field while querying /ipgeo-bulk endpoint.    - If more than 50,000 IP addresses are provided while quering from /ipgeo-bulk endpoint.        </td><td>  -  </td></tr>
            <tr><td> 401 </td><td> Unauthorized – Possible reasons include:   - Missing or invalid API key   - Account unverified, locked, or disabled   - Accessing API with an unauthorized key   - Subscription expired or downgraded   - If your account has been disabled or locked to use by the admin due to abuse or illegal activity.   - When the request to IP Security API is made using API key for a database subscription   - When the request to IP Security API is made on the &#39;paused&#39; subscription.   - If you’re making API requests after your subscription trial has been expired.   - If your active until date has passed and you need to upgrade your account.      - If IP-hostname lookup, IP-security lookup or user-agent parsing endpoint is called using free subsciption API key.    - If bulk IP to geolocation look-ups endpoint is called using free subscription API key.  </td><td>  -  </td></tr>
            <tr><td> 403 </td><td> Forbidden | Possible reasons include:   - If IP to geolocation look-up for a domain name is done using a free subscription API key.     </td><td>  -  </td></tr>
            <tr><td> 404 </td><td> Not Found – Possible reasons include:   - If the IPv4, IPv6, or domain name does not exist in our database.    - If the IPv4, IPv6, or domain name is passed as a path variable, instead of url parameter as ip&#x3D;.      - If the wrong endpoint is called, that does not exist in our API.  </td><td>  -  </td></tr>
            <tr><td> 405 </td><td> Method Not Allowed – Only POST is allowed for &#x60;/ipgeo-bulk&#x60; endpoint </td><td>  -  </td></tr>
            <tr><td> 413 </td><td> If the passed data in the POST requests is more than the limit of the API. </td><td>  -  </td></tr>
            <tr><td> 415 </td><td> If the payload for IPs in /ipgeo-bulk endpoint is mising, or the content type is not mentioned as JSON. </td><td>  -  </td></tr>
            <tr><td> 423 </td><td> If the passed IP address is from a bogon ip ranges, or is part of a private network. </td><td>  -  </td></tr>
            <tr><td> 429 </td><td> Too Many Requests – Possible reasons include:   - If the API usage limit has reached for the free subscriptions, or paid subscriptions with the status &#39;past due&#39;, &#39;deleted&#39; or &#39;trial expired&#39;.    - If the surcharge API usage limit has reached against the subscribed plan.     </td><td>  -  </td></tr>
            <tr><td> 499 </td><td> Client Closed Request – Client terminated connection before completion </td><td>  -  </td></tr>
            <tr><td> 500 </td><td> Internal Server Error – Something went wrong on our end </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call buildCall(final ApiCallback _callback) throws ApiException {
            return ipgeoBulkPostCall(bulkIpRequest, lang, fields, excludes, include, output, _callback);
        }

        /**
         * Execute ipgeoBulkPost request
         * @return List&lt;IpgeoBulkPost200ResponseInner&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table border="1">
       <caption>Response Details</caption>
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> success </td><td>  -  </td></tr>
            <tr><td> 400 </td><td> Bad Request – Possible reasons include:   - If the provided IPv4, IPv6 address, or domain name is invalid.    - If special character(s) ( ) [ ] { } | ^ &#x60; is passed in the API URL either as paramter or its value. Specially in case of API key.      - If the IP addresses JSON list is empty, or the provided JSON does not have &#39;ips&#39; field while querying /ipgeo-bulk endpoint.    - If more than 50,000 IP addresses are provided while quering from /ipgeo-bulk endpoint.        </td><td>  -  </td></tr>
            <tr><td> 401 </td><td> Unauthorized – Possible reasons include:   - Missing or invalid API key   - Account unverified, locked, or disabled   - Accessing API with an unauthorized key   - Subscription expired or downgraded   - If your account has been disabled or locked to use by the admin due to abuse or illegal activity.   - When the request to IP Security API is made using API key for a database subscription   - When the request to IP Security API is made on the &#39;paused&#39; subscription.   - If you’re making API requests after your subscription trial has been expired.   - If your active until date has passed and you need to upgrade your account.      - If IP-hostname lookup, IP-security lookup or user-agent parsing endpoint is called using free subsciption API key.    - If bulk IP to geolocation look-ups endpoint is called using free subscription API key.  </td><td>  -  </td></tr>
            <tr><td> 403 </td><td> Forbidden | Possible reasons include:   - If IP to geolocation look-up for a domain name is done using a free subscription API key.     </td><td>  -  </td></tr>
            <tr><td> 404 </td><td> Not Found – Possible reasons include:   - If the IPv4, IPv6, or domain name does not exist in our database.    - If the IPv4, IPv6, or domain name is passed as a path variable, instead of url parameter as ip&#x3D;.      - If the wrong endpoint is called, that does not exist in our API.  </td><td>  -  </td></tr>
            <tr><td> 405 </td><td> Method Not Allowed – Only POST is allowed for &#x60;/ipgeo-bulk&#x60; endpoint </td><td>  -  </td></tr>
            <tr><td> 413 </td><td> If the passed data in the POST requests is more than the limit of the API. </td><td>  -  </td></tr>
            <tr><td> 415 </td><td> If the payload for IPs in /ipgeo-bulk endpoint is mising, or the content type is not mentioned as JSON. </td><td>  -  </td></tr>
            <tr><td> 423 </td><td> If the passed IP address is from a bogon ip ranges, or is part of a private network. </td><td>  -  </td></tr>
            <tr><td> 429 </td><td> Too Many Requests – Possible reasons include:   - If the API usage limit has reached for the free subscriptions, or paid subscriptions with the status &#39;past due&#39;, &#39;deleted&#39; or &#39;trial expired&#39;.    - If the surcharge API usage limit has reached against the subscribed plan.     </td><td>  -  </td></tr>
            <tr><td> 499 </td><td> Client Closed Request – Client terminated connection before completion </td><td>  -  </td></tr>
            <tr><td> 500 </td><td> Internal Server Error – Something went wrong on our end </td><td>  -  </td></tr>
         </table>
         */
        public List<BulkGeolocationResponse> execute() throws ApiException {
            ApiResponse<List<BulkGeolocationResponse>> localVarResp = ipgeoBulkPostWithHttpInfo(bulkIpRequest, lang, fields, excludes, include, output);
            return localVarResp.getData();
        }

        /**
         * Execute ipgeoBulkPost request with HTTP info returned
         * @return ApiResponse&lt;List&lt;IpgeoBulkPost200ResponseInner&gt;&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table border="1">
       <caption>Response Details</caption>
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> success </td><td>  -  </td></tr>
            <tr><td> 400 </td><td> Bad Request – Possible reasons include:   - If the provided IPv4, IPv6 address, or domain name is invalid.    - If special character(s) ( ) [ ] { } | ^ &#x60; is passed in the API URL either as paramter or its value. Specially in case of API key.      - If the IP addresses JSON list is empty, or the provided JSON does not have &#39;ips&#39; field while querying /ipgeo-bulk endpoint.    - If more than 50,000 IP addresses are provided while quering from /ipgeo-bulk endpoint.        </td><td>  -  </td></tr>
            <tr><td> 401 </td><td> Unauthorized – Possible reasons include:   - Missing or invalid API key   - Account unverified, locked, or disabled   - Accessing API with an unauthorized key   - Subscription expired or downgraded   - If your account has been disabled or locked to use by the admin due to abuse or illegal activity.   - When the request to IP Security API is made using API key for a database subscription   - When the request to IP Security API is made on the &#39;paused&#39; subscription.   - If you’re making API requests after your subscription trial has been expired.   - If your active until date has passed and you need to upgrade your account.      - If IP-hostname lookup, IP-security lookup or user-agent parsing endpoint is called using free subsciption API key.    - If bulk IP to geolocation look-ups endpoint is called using free subscription API key.  </td><td>  -  </td></tr>
            <tr><td> 403 </td><td> Forbidden | Possible reasons include:   - If IP to geolocation look-up for a domain name is done using a free subscription API key.     </td><td>  -  </td></tr>
            <tr><td> 404 </td><td> Not Found – Possible reasons include:   - If the IPv4, IPv6, or domain name does not exist in our database.    - If the IPv4, IPv6, or domain name is passed as a path variable, instead of url parameter as ip&#x3D;.      - If the wrong endpoint is called, that does not exist in our API.  </td><td>  -  </td></tr>
            <tr><td> 405 </td><td> Method Not Allowed – Only POST is allowed for &#x60;/ipgeo-bulk&#x60; endpoint </td><td>  -  </td></tr>
            <tr><td> 413 </td><td> If the passed data in the POST requests is more than the limit of the API. </td><td>  -  </td></tr>
            <tr><td> 415 </td><td> If the payload for IPs in /ipgeo-bulk endpoint is mising, or the content type is not mentioned as JSON. </td><td>  -  </td></tr>
            <tr><td> 423 </td><td> If the passed IP address is from a bogon ip ranges, or is part of a private network. </td><td>  -  </td></tr>
            <tr><td> 429 </td><td> Too Many Requests – Possible reasons include:   - If the API usage limit has reached for the free subscriptions, or paid subscriptions with the status &#39;past due&#39;, &#39;deleted&#39; or &#39;trial expired&#39;.    - If the surcharge API usage limit has reached against the subscribed plan.     </td><td>  -  </td></tr>
            <tr><td> 499 </td><td> Client Closed Request – Client terminated connection before completion </td><td>  -  </td></tr>
            <tr><td> 500 </td><td> Internal Server Error – Something went wrong on our end </td><td>  -  </td></tr>
         </table>
         */
        public ApiResponse<List<BulkGeolocationResponse>> executeWithHttpInfo() throws ApiException {
            return ipgeoBulkPostWithHttpInfo(bulkIpRequest, lang, fields, excludes, include, output);
        }

        /**
         * Execute ipgeoBulkPost request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table border="1">
       <caption>Response Details</caption>
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> success </td><td>  -  </td></tr>
            <tr><td> 400 </td><td> Bad Request – Possible reasons include:   - If the provided IPv4, IPv6 address, or domain name is invalid.    - If special character(s) ( ) [ ] { } | ^ &#x60; is passed in the API URL either as paramter or its value. Specially in case of API key.      - If the IP addresses JSON list is empty, or the provided JSON does not have &#39;ips&#39; field while querying /ipgeo-bulk endpoint.    - If more than 50,000 IP addresses are provided while quering from /ipgeo-bulk endpoint.        </td><td>  -  </td></tr>
            <tr><td> 401 </td><td> Unauthorized – Possible reasons include:   - Missing or invalid API key   - Account unverified, locked, or disabled   - Accessing API with an unauthorized key   - Subscription expired or downgraded   - If your account has been disabled or locked to use by the admin due to abuse or illegal activity.   - When the request to IP Security API is made using API key for a database subscription   - When the request to IP Security API is made on the &#39;paused&#39; subscription.   - If you’re making API requests after your subscription trial has been expired.   - If your active until date has passed and you need to upgrade your account.      - If IP-hostname lookup, IP-security lookup or user-agent parsing endpoint is called using free subsciption API key.    - If bulk IP to geolocation look-ups endpoint is called using free subscription API key.  </td><td>  -  </td></tr>
            <tr><td> 403 </td><td> Forbidden | Possible reasons include:   - If IP to geolocation look-up for a domain name is done using a free subscription API key.     </td><td>  -  </td></tr>
            <tr><td> 404 </td><td> Not Found – Possible reasons include:   - If the IPv4, IPv6, or domain name does not exist in our database.    - If the IPv4, IPv6, or domain name is passed as a path variable, instead of url parameter as ip&#x3D;.      - If the wrong endpoint is called, that does not exist in our API.  </td><td>  -  </td></tr>
            <tr><td> 405 </td><td> Method Not Allowed – Only POST is allowed for &#x60;/ipgeo-bulk&#x60; endpoint </td><td>  -  </td></tr>
            <tr><td> 413 </td><td> If the passed data in the POST requests is more than the limit of the API. </td><td>  -  </td></tr>
            <tr><td> 415 </td><td> If the payload for IPs in /ipgeo-bulk endpoint is mising, or the content type is not mentioned as JSON. </td><td>  -  </td></tr>
            <tr><td> 423 </td><td> If the passed IP address is from a bogon ip ranges, or is part of a private network. </td><td>  -  </td></tr>
            <tr><td> 429 </td><td> Too Many Requests – Possible reasons include:   - If the API usage limit has reached for the free subscriptions, or paid subscriptions with the status &#39;past due&#39;, &#39;deleted&#39; or &#39;trial expired&#39;.    - If the surcharge API usage limit has reached against the subscribed plan.     </td><td>  -  </td></tr>
            <tr><td> 499 </td><td> Client Closed Request – Client terminated connection before completion </td><td>  -  </td></tr>
            <tr><td> 500 </td><td> Internal Server Error – Something went wrong on our end </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<List<BulkGeolocationResponse>> _callback) throws ApiException {
            return ipgeoBulkPostAsync(bulkIpRequest, lang, fields, excludes, include, output, _callback);
        }
    }

    /**
     * 
     * This feature is available only on our paid API subscriptions (STANDARD or ADVANCED). This endpoint allows you to perform the geolocation lookup for multiple IPv4, IPv6 addresses or domain names (maximum 50,000) at the same time. The requests count per lookup is equal to total IP addresses or domain names passed. To perform bulk IP Geolocation Lookup, send a POST request and pass the \&quot;ips\&quot; array as JSON data along with it.  
     * @param bulkIpRequest  (required)
     * @return APIipgeoBulkPostRequest
     * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> success </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Bad Request – Possible reasons include:   - If the provided IPv4, IPv6 address, or domain name is invalid.    - If special character(s) ( ) [ ] { } | ^ &#x60; is passed in the API URL either as paramter or its value. Specially in case of API key.      - If the IP addresses JSON list is empty, or the provided JSON does not have &#39;ips&#39; field while querying /ipgeo-bulk endpoint.    - If more than 50,000 IP addresses are provided while quering from /ipgeo-bulk endpoint.        </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized – Possible reasons include:   - Missing or invalid API key   - Account unverified, locked, or disabled   - Accessing API with an unauthorized key   - Subscription expired or downgraded   - If your account has been disabled or locked to use by the admin due to abuse or illegal activity.   - When the request to IP Security API is made using API key for a database subscription   - When the request to IP Security API is made on the &#39;paused&#39; subscription.   - If you’re making API requests after your subscription trial has been expired.   - If your active until date has passed and you need to upgrade your account.      - If IP-hostname lookup, IP-security lookup or user-agent parsing endpoint is called using free subsciption API key.    - If bulk IP to geolocation look-ups endpoint is called using free subscription API key.  </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> Forbidden | Possible reasons include:   - If IP to geolocation look-up for a domain name is done using a free subscription API key.     </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found – Possible reasons include:   - If the IPv4, IPv6, or domain name does not exist in our database.    - If the IPv4, IPv6, or domain name is passed as a path variable, instead of url parameter as ip&#x3D;.      - If the wrong endpoint is called, that does not exist in our API.  </td><td>  -  </td></tr>
        <tr><td> 405 </td><td> Method Not Allowed – Only POST is allowed for &#x60;/ipgeo-bulk&#x60; endpoint </td><td>  -  </td></tr>
        <tr><td> 413 </td><td> If the passed data in the POST requests is more than the limit of the API. </td><td>  -  </td></tr>
        <tr><td> 415 </td><td> If the payload for IPs in /ipgeo-bulk endpoint is mising, or the content type is not mentioned as JSON. </td><td>  -  </td></tr>
        <tr><td> 423 </td><td> If the passed IP address is from a bogon ip ranges, or is part of a private network. </td><td>  -  </td></tr>
        <tr><td> 429 </td><td> Too Many Requests – Possible reasons include:   - If the API usage limit has reached for the free subscriptions, or paid subscriptions with the status &#39;past due&#39;, &#39;deleted&#39; or &#39;trial expired&#39;.    - If the surcharge API usage limit has reached against the subscribed plan.     </td><td>  -  </td></tr>
        <tr><td> 499 </td><td> Client Closed Request – Client terminated connection before completion </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> Internal Server Error – Something went wrong on our end </td><td>  -  </td></tr>
     </table>
     */
    public APIipgeoBulkPostRequest getBulkIPGeolocation(@javax.annotation.Nonnull BulkIPRequest bulkIpRequest) {
        return new APIipgeoBulkPostRequest(bulkIpRequest);
    }
    private okhttp3.Call ipgeoGetCall(@javax.annotation.Nullable String ip, @javax.annotation.Nullable String lang, @javax.annotation.Nullable String fields, @javax.annotation.Nullable String excludes, @javax.annotation.Nullable String include, @javax.annotation.Nullable String output, final ApiCallback _callback) throws ApiException {
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
        String localVarPath = "/ipgeo";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        if (ip != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("ip", ip));
        }

        if (lang != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("lang", lang));
        }

        if (fields != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("fields", fields));
        }

        if (excludes != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("excludes", excludes));
        }

        if (include != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("include", include));
        }

        if (output != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("output", output));
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
    private okhttp3.Call ipgeoGetValidateBeforeCall(@javax.annotation.Nullable String ip, @javax.annotation.Nullable String lang, @javax.annotation.Nullable String fields, @javax.annotation.Nullable String excludes, @javax.annotation.Nullable String include, @javax.annotation.Nullable String output, final ApiCallback _callback) throws ApiException {
        return ipgeoGetCall(ip, lang, fields, excludes, include, output, _callback);

    }


    private ApiResponse<GeolocationResponse> ipgeoGetWithHttpInfo(@javax.annotation.Nullable String ip, @javax.annotation.Nullable String lang, @javax.annotation.Nullable String fields, @javax.annotation.Nullable String excludes, @javax.annotation.Nullable String include, @javax.annotation.Nullable String output) throws ApiException {
        okhttp3.Call localVarCall = ipgeoGetValidateBeforeCall(ip, lang, fields, excludes, include, output, null);
        Type localVarReturnType = new TypeToken<GeolocationResponse>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call ipgeoGetAsync(@javax.annotation.Nullable String ip, @javax.annotation.Nullable String lang, @javax.annotation.Nullable String fields, @javax.annotation.Nullable String excludes, @javax.annotation.Nullable String include, @javax.annotation.Nullable String output, final ApiCallback<GeolocationResponse> _callback) throws ApiException {

        okhttp3.Call localVarCall = ipgeoGetValidateBeforeCall(ip, lang, fields, excludes, include, output, _callback);
        Type localVarReturnType = new TypeToken<GeolocationResponse>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class APIipgeoGetRequest {
        @javax.annotation.Nullable
        private String ip;
        @javax.annotation.Nullable
        private String lang;
        @javax.annotation.Nullable
        private String fields;
        @javax.annotation.Nullable
        private String excludes;
        @javax.annotation.Nullable
        private String include;
        @javax.annotation.Nullable
        private String output;

        private APIipgeoGetRequest() {
        }

        /**
         * Set ip
         * @param ip In order to find geolocation information about an IP (ipv4 ipv6) address or a domain name, pass it as a query parameter ip. When this endpoint is queried without an IP address, it returns the geolocation information of the device/client which is calling it (optional)
         * @return APIipgeoGetRequest
         */
        public APIipgeoGetRequest ip(@javax.annotation.Nullable String ip) {
            this.ip = ip;
            return this;
        }

        /**
         * Set lang
         * @param lang By default, the API responds in English. You can change the response language by passing the language code as a query parameter &#x60;lang&#x60;. Multi language feature is available only for &#x60;paid users&#x60;. (optional)
         * @return APIipgeoGetRequest
         */
        public APIipgeoGetRequest lang(@javax.annotation.Nullable String lang) {
            this.lang = lang;
            return this;
        }

        /**
         * Set fields
         * @param fields you can filter the API response by specifying the fields that you need, instead of getting the full response. To do this, pass the desired field names using the &#x60;fields&#x60; query parameter with each field represented as a dot-separated path. (optional)
         * @return APIipgeoGetRequest
         */
        public APIipgeoGetRequest fields(@javax.annotation.Nullable String fields) {
            this.fields = fields;
            return this;
        }

        /**
         * Set excludes
         * @param excludes you can also filter the API response by excluding specific fields (except the IP address) that you don&#39;t need. To do this, pass the unwanted field names using the excludes query parameter, with each field represented as a dot-separated path (optional)
         * @return APIipgeoGetRequest
         */
        public APIipgeoGetRequest excludes(@javax.annotation.Nullable String excludes) {
            this.excludes = excludes;
            return this;
        }

        /**
         * Set include
         * @param include IP Geolocation API also provides IP-Security, abuse, timezone, user-agent and DMA (Designated Market Area) code, which is specifically used in the US for marketing and regional targeting information on Advanced API subscription, but doesn&#39;t respond it by default. To get these information along with the geolocation information, you must pass the &#x60;include&#x3D;security&#x60; or &#x60;include&#x3D;abuse&#x60; or &#x60;include&#x3D;dma&#x60; or &#x60;include&#x3D;time_zone&#x60; or &#x60;include&#x3D;user-agent&#x60; or you can fetch multiples by adding values in comma-separated way. In addition to that, IPGeolocation API also provide hostname lookup for an IP address on all the paid API subscriptions (STANDARD and ADVANCED), but doesn&#39;t respond it by default. To get the hostname for an IP address, you can pass one of the three values &#x60;hostname, liveHostname, hostnameFallbackLive&#x60; as a URL parameter &#x60;include&#x3D;&#x60;. (optional)
         * @return APIipgeoGetRequest
         */
        public APIipgeoGetRequest include(@javax.annotation.Nullable String include) {
            this.include = include;
            return this;
        }

        /**
         * Set output
         * @param output Desired output format (json or xml). (optional)
         * @return APIipgeoGetRequest
         */
        public APIipgeoGetRequest output(@javax.annotation.Nullable String output) {
            this.output = output;
            return this;
        }

        /**
         * Build call for ipgeoGet
         * @param _callback ApiCallback API callback
         * @return Call to execute
         * @throws ApiException If fail to serialize the request body object
         * @http.response.details
         <table border="1">
       <caption>Response Details</caption>
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> successful response </td><td>  -  </td></tr>
            <tr><td> 400 </td><td> Bad Request – Possible reasons include:   - If the provided IPv4, IPv6 address, or domain name is invalid.    - If special character(s) ( ) [ ] { } | ^ &#x60; is passed in the API URL either as paramter or its value. Specially in case of API key.        </td><td>  -  </td></tr>
            <tr><td> 401 </td><td> Unauthorized – Possible reasons include:   - Missing or invalid API key   - Account unverified, locked, or disabled   - Accessing API with an unauthorized key   - Subscription expired or downgraded   - If your account has been disabled or locked to use by the admin due to abuse or illegal activity.   - When the request to IP Security API is made using API key for a database subscription   - When the request to IP Security API is made on the &#39;paused&#39; subscription.   - If you’re making API requests after your subscription trial has been expired.   - If your active until date has passed and you need to upgrade your account.      - If IP-hostname lookup, IP-security lookup or user-agent parsing endpoint is called using free subsciption API key.  </td><td>  -  </td></tr>
            <tr><td> 403 </td><td> Forbidden | Possible reasons include:   - If IP to geolocation look-up for a domain name is done using a free subscription API key.     </td><td>  -  </td></tr>
            <tr><td> 404 </td><td> Not Found – Possible reasons include:   - If the IPv4, IPv6, or domain name does not exist in our database.    - If the IPv4, IPv6, or domain name is passed as a path variable, instead of url parameter as ip&#x3D;.      - If the wrong endpoint is called, that does not exist in our API.  </td><td>  -  </td></tr>
            <tr><td> 405 </td><td> Method Not Allowed – Only GET is allowed for &#x60;/ipgeo&#x60; endpoint </td><td>  -  </td></tr>
            <tr><td> 423 </td><td> If the passed IP address is from a bogon ip ranges, or is part of a private network. </td><td>  -  </td></tr>
            <tr><td> 429 </td><td> Too Many Requests – Possible reasons include:   - If the API usage limit has reached for the free subscriptions, or paid subscriptions with the status &#39;past due&#39;, &#39;deleted&#39; or &#39;trial expired&#39;.    - If the surcharge API usage limit has reached against the subscribed plan.     </td><td>  -  </td></tr>
            <tr><td> 499 </td><td> Client Closed Request – Client terminated connection before completion </td><td>  -  </td></tr>
            <tr><td> 500 </td><td> Internal Server Error – Something went wrong on our end </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call buildCall(final ApiCallback _callback) throws ApiException {
            return ipgeoGetCall(ip, lang, fields, excludes, include, output, _callback);
        }

        /**
         * Execute ipgeoGet request
         * @return GeolocationResponse
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table border="1">
       <caption>Response Details</caption>
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> successful response </td><td>  -  </td></tr>
            <tr><td> 400 </td><td> Bad Request – Possible reasons include:   - If the provided IPv4, IPv6 address, or domain name is invalid.    - If special character(s) ( ) [ ] { } | ^ &#x60; is passed in the API URL either as paramter or its value. Specially in case of API key.        </td><td>  -  </td></tr>
            <tr><td> 401 </td><td> Unauthorized – Possible reasons include:   - Missing or invalid API key   - Account unverified, locked, or disabled   - Accessing API with an unauthorized key   - Subscription expired or downgraded   - If your account has been disabled or locked to use by the admin due to abuse or illegal activity.   - When the request to IP Security API is made using API key for a database subscription   - When the request to IP Security API is made on the &#39;paused&#39; subscription.   - If you’re making API requests after your subscription trial has been expired.   - If your active until date has passed and you need to upgrade your account.      - If IP-hostname lookup, IP-security lookup or user-agent parsing endpoint is called using free subsciption API key.  </td><td>  -  </td></tr>
            <tr><td> 403 </td><td> Forbidden | Possible reasons include:   - If IP to geolocation look-up for a domain name is done using a free subscription API key.     </td><td>  -  </td></tr>
            <tr><td> 404 </td><td> Not Found – Possible reasons include:   - If the IPv4, IPv6, or domain name does not exist in our database.    - If the IPv4, IPv6, or domain name is passed as a path variable, instead of url parameter as ip&#x3D;.      - If the wrong endpoint is called, that does not exist in our API.  </td><td>  -  </td></tr>
            <tr><td> 405 </td><td> Method Not Allowed – Only GET is allowed for &#x60;/ipgeo&#x60; endpoint </td><td>  -  </td></tr>
            <tr><td> 423 </td><td> If the passed IP address is from a bogon ip ranges, or is part of a private network. </td><td>  -  </td></tr>
            <tr><td> 429 </td><td> Too Many Requests – Possible reasons include:   - If the API usage limit has reached for the free subscriptions, or paid subscriptions with the status &#39;past due&#39;, &#39;deleted&#39; or &#39;trial expired&#39;.    - If the surcharge API usage limit has reached against the subscribed plan.     </td><td>  -  </td></tr>
            <tr><td> 499 </td><td> Client Closed Request – Client terminated connection before completion </td><td>  -  </td></tr>
            <tr><td> 500 </td><td> Internal Server Error – Something went wrong on our end </td><td>  -  </td></tr>
         </table>
         */
        public GeolocationResponse execute() throws ApiException {
            ApiResponse<GeolocationResponse> localVarResp = ipgeoGetWithHttpInfo(ip, lang, fields, excludes, include, output);
            return localVarResp.getData();
        }

        /**
         * Execute ipgeoGet request with HTTP info returned
         * @return ApiResponse&lt;GeolocationResponse&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table border="1">
       <caption>Response Details</caption>
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> successful response </td><td>  -  </td></tr>
            <tr><td> 400 </td><td> Bad Request – Possible reasons include:   - If the provided IPv4, IPv6 address, or domain name is invalid.    - If special character(s) ( ) [ ] { } | ^ &#x60; is passed in the API URL either as paramter or its value. Specially in case of API key.        </td><td>  -  </td></tr>
            <tr><td> 401 </td><td> Unauthorized – Possible reasons include:   - Missing or invalid API key   - Account unverified, locked, or disabled   - Accessing API with an unauthorized key   - Subscription expired or downgraded   - If your account has been disabled or locked to use by the admin due to abuse or illegal activity.   - When the request to IP Security API is made using API key for a database subscription   - When the request to IP Security API is made on the &#39;paused&#39; subscription.   - If you’re making API requests after your subscription trial has been expired.   - If your active until date has passed and you need to upgrade your account.      - If IP-hostname lookup, IP-security lookup or user-agent parsing endpoint is called using free subsciption API key.  </td><td>  -  </td></tr>
            <tr><td> 403 </td><td> Forbidden | Possible reasons include:   - If IP to geolocation look-up for a domain name is done using a free subscription API key.     </td><td>  -  </td></tr>
            <tr><td> 404 </td><td> Not Found – Possible reasons include:   - If the IPv4, IPv6, or domain name does not exist in our database.    - If the IPv4, IPv6, or domain name is passed as a path variable, instead of url parameter as ip&#x3D;.      - If the wrong endpoint is called, that does not exist in our API.  </td><td>  -  </td></tr>
            <tr><td> 405 </td><td> Method Not Allowed – Only GET is allowed for &#x60;/ipgeo&#x60; endpoint </td><td>  -  </td></tr>
            <tr><td> 423 </td><td> If the passed IP address is from a bogon ip ranges, or is part of a private network. </td><td>  -  </td></tr>
            <tr><td> 429 </td><td> Too Many Requests – Possible reasons include:   - If the API usage limit has reached for the free subscriptions, or paid subscriptions with the status &#39;past due&#39;, &#39;deleted&#39; or &#39;trial expired&#39;.    - If the surcharge API usage limit has reached against the subscribed plan.     </td><td>  -  </td></tr>
            <tr><td> 499 </td><td> Client Closed Request – Client terminated connection before completion </td><td>  -  </td></tr>
            <tr><td> 500 </td><td> Internal Server Error – Something went wrong on our end </td><td>  -  </td></tr>
         </table>
         */
        public ApiResponse<GeolocationResponse> executeWithHttpInfo() throws ApiException {
            return ipgeoGetWithHttpInfo(ip, lang, fields, excludes, include, output);
        }

        /**
         * Execute ipgeoGet request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table border="1">
       <caption>Response Details</caption>
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> successful response </td><td>  -  </td></tr>
            <tr><td> 400 </td><td> Bad Request – Possible reasons include:   - If the provided IPv4, IPv6 address, or domain name is invalid.    - If special character(s) ( ) [ ] { } | ^ &#x60; is passed in the API URL either as paramter or its value. Specially in case of API key.        </td><td>  -  </td></tr>
            <tr><td> 401 </td><td> Unauthorized – Possible reasons include:   - Missing or invalid API key   - Account unverified, locked, or disabled   - Accessing API with an unauthorized key   - Subscription expired or downgraded   - If your account has been disabled or locked to use by the admin due to abuse or illegal activity.   - When the request to IP Security API is made using API key for a database subscription   - When the request to IP Security API is made on the &#39;paused&#39; subscription.   - If you’re making API requests after your subscription trial has been expired.   - If your active until date has passed and you need to upgrade your account.      - If IP-hostname lookup, IP-security lookup or user-agent parsing endpoint is called using free subsciption API key.  </td><td>  -  </td></tr>
            <tr><td> 403 </td><td> Forbidden | Possible reasons include:   - If IP to geolocation look-up for a domain name is done using a free subscription API key.     </td><td>  -  </td></tr>
            <tr><td> 404 </td><td> Not Found – Possible reasons include:   - If the IPv4, IPv6, or domain name does not exist in our database.    - If the IPv4, IPv6, or domain name is passed as a path variable, instead of url parameter as ip&#x3D;.      - If the wrong endpoint is called, that does not exist in our API.  </td><td>  -  </td></tr>
            <tr><td> 405 </td><td> Method Not Allowed – Only GET is allowed for &#x60;/ipgeo&#x60; endpoint </td><td>  -  </td></tr>
            <tr><td> 423 </td><td> If the passed IP address is from a bogon ip ranges, or is part of a private network. </td><td>  -  </td></tr>
            <tr><td> 429 </td><td> Too Many Requests – Possible reasons include:   - If the API usage limit has reached for the free subscriptions, or paid subscriptions with the status &#39;past due&#39;, &#39;deleted&#39; or &#39;trial expired&#39;.    - If the surcharge API usage limit has reached against the subscribed plan.     </td><td>  -  </td></tr>
            <tr><td> 499 </td><td> Client Closed Request – Client terminated connection before completion </td><td>  -  </td></tr>
            <tr><td> 500 </td><td> Internal Server Error – Something went wrong on our end </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<GeolocationResponse> _callback) throws ApiException {
            return ipgeoGetAsync(ip, lang, fields, excludes, include, output, _callback);
        }
    }

    /**
     * 
     * IP Geolocation API provides real-time and accurate geolocation, network, abuse, and security information for any IPv4 or IPv6 address and domain name along with the user-agent detail for the provided user-agent string. You can geolocate your online visitors and provide them the customized user-experience accordingly.
     * @return APIipgeoGetRequest
     * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> successful response </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Bad Request – Possible reasons include:   - If the provided IPv4, IPv6 address, or domain name is invalid.    - If special character(s) ( ) [ ] { } | ^ &#x60; is passed in the API URL either as paramter or its value. Specially in case of API key.        </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized – Possible reasons include:   - Missing or invalid API key   - Account unverified, locked, or disabled   - Accessing API with an unauthorized key   - Subscription expired or downgraded   - If your account has been disabled or locked to use by the admin due to abuse or illegal activity.   - When the request to IP Security API is made using API key for a database subscription   - When the request to IP Security API is made on the &#39;paused&#39; subscription.   - If you’re making API requests after your subscription trial has been expired.   - If your active until date has passed and you need to upgrade your account.      - If IP-hostname lookup, IP-security lookup or user-agent parsing endpoint is called using free subsciption API key.  </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> Forbidden | Possible reasons include:   - If IP to geolocation look-up for a domain name is done using a free subscription API key.     </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found – Possible reasons include:   - If the IPv4, IPv6, or domain name does not exist in our database.    - If the IPv4, IPv6, or domain name is passed as a path variable, instead of url parameter as ip&#x3D;.      - If the wrong endpoint is called, that does not exist in our API.  </td><td>  -  </td></tr>
        <tr><td> 405 </td><td> Method Not Allowed – Only GET is allowed for &#x60;/ipgeo&#x60; endpoint </td><td>  -  </td></tr>
        <tr><td> 423 </td><td> If the passed IP address is from a bogon ip ranges, or is part of a private network. </td><td>  -  </td></tr>
        <tr><td> 429 </td><td> Too Many Requests – Possible reasons include:   - If the API usage limit has reached for the free subscriptions, or paid subscriptions with the status &#39;past due&#39;, &#39;deleted&#39; or &#39;trial expired&#39;.    - If the surcharge API usage limit has reached against the subscribed plan.     </td><td>  -  </td></tr>
        <tr><td> 499 </td><td> Client Closed Request – Client terminated connection before completion </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> Internal Server Error – Something went wrong on our end </td><td>  -  </td></tr>
     </table>
     */
    public APIipgeoGetRequest getIPGeolocation() {
        return new APIipgeoGetRequest();
    }
}
