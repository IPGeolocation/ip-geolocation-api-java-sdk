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


import io.ipgeolocation.sdk.model.ASNResponse;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AsnLookupAPI {
    private ApiClient localVarApiClient;
    private int localHostIndex;
    private String localCustomBaseUrl;

    public AsnLookupAPI() {
        this(Configuration.getDefaultApiClient());
    }

    public AsnLookupAPI(ApiClient apiClient) {
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

    private okhttp3.Call asnGetCall(@javax.annotation.Nullable String ip, @javax.annotation.Nullable Integer asn, @javax.annotation.Nullable String include, @javax.annotation.Nullable String excludes, @javax.annotation.Nullable String fields, final ApiCallback _callback) throws ApiException {
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
        String localVarPath = "/asn";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        if (ip != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("ip", ip));
        }

        if (asn != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("asn", asn));
        }

        if (include != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("include", include));
        }

        if (excludes != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("excludes", excludes));
        }

        if (fields != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("fields", fields));
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
    private okhttp3.Call asnGetValidateBeforeCall(@javax.annotation.Nullable String ip, @javax.annotation.Nullable Integer asn, @javax.annotation.Nullable String include, @javax.annotation.Nullable String excludes, @javax.annotation.Nullable String fields, final ApiCallback _callback) throws ApiException {
        return asnGetCall(ip, asn, include, excludes, fields, _callback);

    }


    private ApiResponse<ASNResponse> asnGetWithHttpInfo(@javax.annotation.Nullable String ip, @javax.annotation.Nullable Integer asn, @javax.annotation.Nullable String include, @javax.annotation.Nullable String excludes, @javax.annotation.Nullable String fields) throws ApiException {
        okhttp3.Call localVarCall = asnGetValidateBeforeCall(ip, asn, include, excludes, fields, null);
        Type localVarReturnType = new TypeToken<ASNResponse>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call asnGetAsync(@javax.annotation.Nullable String ip, @javax.annotation.Nullable Integer asn, @javax.annotation.Nullable String include, @javax.annotation.Nullable String excludes, @javax.annotation.Nullable String fields, final ApiCallback<ASNResponse> _callback) throws ApiException {

        okhttp3.Call localVarCall = asnGetValidateBeforeCall(ip, asn, include, excludes, fields, _callback);
        Type localVarReturnType = new TypeToken<ASNResponse>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class APIasnGetRequest {
        @javax.annotation.Nullable
        private String ip;
        @javax.annotation.Nullable
        private Integer asn;
        @javax.annotation.Nullable
        private String include;
        @javax.annotation.Nullable
        private String excludes;
        @javax.annotation.Nullable
        private String fields;

        private APIasnGetRequest() {
        }

        /**
         * Set ip
         * @param ip query parameter &#39;ip&#39;. (optional)
         * @return APIasnGetRequest
         */
        public APIasnGetRequest ip(@javax.annotation.Nullable String ip) {
            this.ip = ip;
            return this;
        }

        /**
         * Set asn
         * @param asn query paramter &#39;asn&#39;. (optional)
         * @return APIasnGetRequest
         */
        public APIasnGetRequest asn(@javax.annotation.Nullable Integer asn) {
            this.asn = asn;
            return this;
        }

        /**
         * Set include
         * @param include This parameter can have four options: a) peers b) downstreams c) upstreams d) routes e) whois_response. You may add any of them in comma-separated way. In order to get the ASN details with peering data, pass peers string in the include parameter like mentioned below. (optional)
         * @return APIasnGetRequest
         */
        public APIasnGetRequest include(@javax.annotation.Nullable String include) {
            this.include = include;
            return this;
        }

        /**
         * Set excludes
         * @param excludes You can exclude fields from the response according to you requirement with the exception of ip field. For example, you want to remove date_allocated and allocation_status from api response, you can put the keys in excludes parameter like this. (optional)
         * @return APIasnGetRequest
         */
        public APIasnGetRequest excludes(@javax.annotation.Nullable String excludes) {
            this.excludes = excludes;
            return this;
        }

        /**
         * Set fields
         * @param fields You can filter out only those fields which you want to see in the response by using the fields parameter. To retrieve only the AS organization, its country and downstreams in api response, you can put the keys in fields parameter like this. API will combine these fields with the default ASN response. Note: Parameters &#x60;peers, downstreams, upstreams, routes, whois_response&#x60; can be used in both &#x60;include&#x60; , and &#x60;fields&#x60;. If you use include and fields at the same time, fields parameter will be considered only. (optional)
         * @return APIasnGetRequest
         */
        public APIasnGetRequest fields(@javax.annotation.Nullable String fields) {
            this.fields = fields;
            return this;
        }

        /**
         * Build call for asnGet
         * @param _callback ApiCallback API callback
         * @return Call to execute
         * @throws ApiException If fail to serialize the request body object
         * @http.response.details
         <table border="1">
       <caption>Response Details</caption>
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> Successful response </td><td>  -  </td></tr>
            <tr><td> 400 </td><td> Bad Request – Possible reasons include:   - If the provided IPv4, IPv6 address, or ASN is invalid.    - If special character(s) ( ) [ ] { } | ^ &#x60; is passed in the API URL either as paramter or its value. Specially in case of API key.        </td><td>  -  </td></tr>
            <tr><td> 401 </td><td> Unauthorized – Possible reasons include:   - Missing or invalid API key   - Account unverified, locked, or disabled   - Accessing API with an unauthorized key   - Subscription expired or downgraded   - If your account has been disabled or locked to use by the admin due to abuse or illegal activity.   - When the request to IP ASN API is made using API key for a database subscription   - When the request to IP ASN API is made on the &#39;paused&#39; subscription.   - If you’re making API requests after your subscription trial has been expired.   - If your active until date has passed and you need to upgrade your account.  </td><td>  -  </td></tr>
            <tr><td> 404 </td><td> Not Found – Possible reasons include:   - If the IPv4, IPv6, or ASN name does not exist in our database.    - If the IPv4, IPv6, or ASN  is passed as a path variable, instead of url parameter as ip&#x3D;.      - If the wrong endpoint is called, that does not exist in our API.  </td><td>  -  </td></tr>
            <tr><td> 405 </td><td> Method Not Allowed – Only GET is allowed for &#x60;/asn&#x60; endpoint </td><td>  -  </td></tr>
            <tr><td> 429 </td><td> Too Many Requests – Possible reasons include:   - If the API usage limit has reached for the free subscriptions, or paid subscriptions with the status &#39;past due&#39;, &#39;deleted&#39; or &#39;trial expired&#39;.    - If the surcharge API usage limit has reached against the subscribed plan.     </td><td>  -  </td></tr>
            <tr><td> 499 </td><td> Client Closed Request – Client terminated connection before completion </td><td>  -  </td></tr>
            <tr><td> 500 </td><td> Internal Server Error – Something went wrong on our end </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call buildCall(final ApiCallback _callback) throws ApiException {
            return asnGetCall(ip, asn, include, excludes, fields, _callback);
        }

        /**
         * Execute asnGet request
         * @return ASNResponse
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table border="1">
       <caption>Response Details</caption>
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> Successful response </td><td>  -  </td></tr>
            <tr><td> 400 </td><td> Bad Request – Possible reasons include:   - If the provided IPv4, IPv6 address, or ASN is invalid.    - If special character(s) ( ) [ ] { } | ^ &#x60; is passed in the API URL either as paramter or its value. Specially in case of API key.        </td><td>  -  </td></tr>
            <tr><td> 401 </td><td> Unauthorized – Possible reasons include:   - Missing or invalid API key   - Account unverified, locked, or disabled   - Accessing API with an unauthorized key   - Subscription expired or downgraded   - If your account has been disabled or locked to use by the admin due to abuse or illegal activity.   - When the request to IP ASN API is made using API key for a database subscription   - When the request to IP ASN API is made on the &#39;paused&#39; subscription.   - If you’re making API requests after your subscription trial has been expired.   - If your active until date has passed and you need to upgrade your account.  </td><td>  -  </td></tr>
            <tr><td> 404 </td><td> Not Found – Possible reasons include:   - If the IPv4, IPv6, or ASN name does not exist in our database.    - If the IPv4, IPv6, or ASN  is passed as a path variable, instead of url parameter as ip&#x3D;.      - If the wrong endpoint is called, that does not exist in our API.  </td><td>  -  </td></tr>
            <tr><td> 405 </td><td> Method Not Allowed – Only GET is allowed for &#x60;/asn&#x60; endpoint </td><td>  -  </td></tr>
            <tr><td> 429 </td><td> Too Many Requests – Possible reasons include:   - If the API usage limit has reached for the free subscriptions, or paid subscriptions with the status &#39;past due&#39;, &#39;deleted&#39; or &#39;trial expired&#39;.    - If the surcharge API usage limit has reached against the subscribed plan.     </td><td>  -  </td></tr>
            <tr><td> 499 </td><td> Client Closed Request – Client terminated connection before completion </td><td>  -  </td></tr>
            <tr><td> 500 </td><td> Internal Server Error – Something went wrong on our end </td><td>  -  </td></tr>
         </table>
         */
        public ASNResponse execute() throws ApiException {
            ApiResponse<ASNResponse> localVarResp = asnGetWithHttpInfo(ip, asn, include, excludes, fields);
            return localVarResp.getData();
        }

        /**
         * Execute asnGet request with HTTP info returned
         * @return ApiResponse&lt;ASNResponse&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table border="1">
       <caption>Response Details</caption>
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> Successful response </td><td>  -  </td></tr>
            <tr><td> 400 </td><td> Bad Request – Possible reasons include:   - If the provided IPv4, IPv6 address, or ASN is invalid.    - If special character(s) ( ) [ ] { } | ^ &#x60; is passed in the API URL either as paramter or its value. Specially in case of API key.        </td><td>  -  </td></tr>
            <tr><td> 401 </td><td> Unauthorized – Possible reasons include:   - Missing or invalid API key   - Account unverified, locked, or disabled   - Accessing API with an unauthorized key   - Subscription expired or downgraded   - If your account has been disabled or locked to use by the admin due to abuse or illegal activity.   - When the request to IP ASN API is made using API key for a database subscription   - When the request to IP ASN API is made on the &#39;paused&#39; subscription.   - If you’re making API requests after your subscription trial has been expired.   - If your active until date has passed and you need to upgrade your account.  </td><td>  -  </td></tr>
            <tr><td> 404 </td><td> Not Found – Possible reasons include:   - If the IPv4, IPv6, or ASN name does not exist in our database.    - If the IPv4, IPv6, or ASN  is passed as a path variable, instead of url parameter as ip&#x3D;.      - If the wrong endpoint is called, that does not exist in our API.  </td><td>  -  </td></tr>
            <tr><td> 405 </td><td> Method Not Allowed – Only GET is allowed for &#x60;/asn&#x60; endpoint </td><td>  -  </td></tr>
            <tr><td> 429 </td><td> Too Many Requests – Possible reasons include:   - If the API usage limit has reached for the free subscriptions, or paid subscriptions with the status &#39;past due&#39;, &#39;deleted&#39; or &#39;trial expired&#39;.    - If the surcharge API usage limit has reached against the subscribed plan.     </td><td>  -  </td></tr>
            <tr><td> 499 </td><td> Client Closed Request – Client terminated connection before completion </td><td>  -  </td></tr>
            <tr><td> 500 </td><td> Internal Server Error – Something went wrong on our end </td><td>  -  </td></tr>
         </table>
         */
        public ApiResponse<ASNResponse> executeWithHttpInfo() throws ApiException {
            return asnGetWithHttpInfo(ip, asn, include, excludes, fields);
        }

        /**
         * Execute asnGet request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table border="1">
       <caption>Response Details</caption>
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> Successful response </td><td>  -  </td></tr>
            <tr><td> 400 </td><td> Bad Request – Possible reasons include:   - If the provided IPv4, IPv6 address, or ASN is invalid.    - If special character(s) ( ) [ ] { } | ^ &#x60; is passed in the API URL either as paramter or its value. Specially in case of API key.        </td><td>  -  </td></tr>
            <tr><td> 401 </td><td> Unauthorized – Possible reasons include:   - Missing or invalid API key   - Account unverified, locked, or disabled   - Accessing API with an unauthorized key   - Subscription expired or downgraded   - If your account has been disabled or locked to use by the admin due to abuse or illegal activity.   - When the request to IP ASN API is made using API key for a database subscription   - When the request to IP ASN API is made on the &#39;paused&#39; subscription.   - If you’re making API requests after your subscription trial has been expired.   - If your active until date has passed and you need to upgrade your account.  </td><td>  -  </td></tr>
            <tr><td> 404 </td><td> Not Found – Possible reasons include:   - If the IPv4, IPv6, or ASN name does not exist in our database.    - If the IPv4, IPv6, or ASN  is passed as a path variable, instead of url parameter as ip&#x3D;.      - If the wrong endpoint is called, that does not exist in our API.  </td><td>  -  </td></tr>
            <tr><td> 405 </td><td> Method Not Allowed – Only GET is allowed for &#x60;/asn&#x60; endpoint </td><td>  -  </td></tr>
            <tr><td> 429 </td><td> Too Many Requests – Possible reasons include:   - If the API usage limit has reached for the free subscriptions, or paid subscriptions with the status &#39;past due&#39;, &#39;deleted&#39; or &#39;trial expired&#39;.    - If the surcharge API usage limit has reached against the subscribed plan.     </td><td>  -  </td></tr>
            <tr><td> 499 </td><td> Client Closed Request – Client terminated connection before completion </td><td>  -  </td></tr>
            <tr><td> 500 </td><td> Internal Server Error – Something went wrong on our end </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<ASNResponse> _callback) throws ApiException {
            return asnGetAsync(ip, asn, include, excludes, fields, _callback);
        }
    }

    /**
     * 
     * ASN API provides comprehensive details for an ASN including the as name,  organization name, the country of registration, associated domain, and its  type (ISP, host provider, or business). The API also shows the allocation  date of provided ASN and if it is currently allocated or not. It also contains  the routing information including peering, upstreams, and downstreams to help  understand the relationship between different ASNs.  Example Use Cases:  - Looking up ASN information for an IP address (e.g., &#x60;GET /asn?ip&#x3D;8.8.8.8&#x60;)  - Retrieving ASN information for a specific ASN number (e.g., &#x60;GET /asn?asn&#x3D;12345&#x60;)  - Getting peering relationships for an ASN (e.g., &#x60;GET /asn?asn&#x3D;12345&amp;include&#x3D;peers&#x60;) 
     * @return APIasnGetRequest
     * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Successful response </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Bad Request – Possible reasons include:   - If the provided IPv4, IPv6 address, or ASN is invalid.    - If special character(s) ( ) [ ] { } | ^ &#x60; is passed in the API URL either as paramter or its value. Specially in case of API key.        </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized – Possible reasons include:   - Missing or invalid API key   - Account unverified, locked, or disabled   - Accessing API with an unauthorized key   - Subscription expired or downgraded   - If your account has been disabled or locked to use by the admin due to abuse or illegal activity.   - When the request to IP ASN API is made using API key for a database subscription   - When the request to IP ASN API is made on the &#39;paused&#39; subscription.   - If you’re making API requests after your subscription trial has been expired.   - If your active until date has passed and you need to upgrade your account.  </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found – Possible reasons include:   - If the IPv4, IPv6, or ASN name does not exist in our database.    - If the IPv4, IPv6, or ASN  is passed as a path variable, instead of url parameter as ip&#x3D;.      - If the wrong endpoint is called, that does not exist in our API.  </td><td>  -  </td></tr>
        <tr><td> 405 </td><td> Method Not Allowed – Only GET is allowed for &#x60;/asn&#x60; endpoint </td><td>  -  </td></tr>
        <tr><td> 429 </td><td> Too Many Requests – Possible reasons include:   - If the API usage limit has reached for the free subscriptions, or paid subscriptions with the status &#39;past due&#39;, &#39;deleted&#39; or &#39;trial expired&#39;.    - If the surcharge API usage limit has reached against the subscribed plan.     </td><td>  -  </td></tr>
        <tr><td> 499 </td><td> Client Closed Request – Client terminated connection before completion </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> Internal Server Error – Something went wrong on our end </td><td>  -  </td></tr>
     </table>
     */
    public APIasnGetRequest getAsnDetails() {
        return new APIasnGetRequest();
    }
}
