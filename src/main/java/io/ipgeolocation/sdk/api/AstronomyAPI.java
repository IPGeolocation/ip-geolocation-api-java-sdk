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


import io.ipgeolocation.sdk.model.AstronomyResponse;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AstronomyAPI {
    private ApiClient localVarApiClient;
    private int localHostIndex;
    private String localCustomBaseUrl;

    public AstronomyAPI() {
        this(Configuration.getDefaultApiClient());
    }

    public AstronomyAPI(ApiClient apiClient) {
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

    private okhttp3.Call astronomyGetCall(@javax.annotation.Nullable String ip, @javax.annotation.Nullable String location, @javax.annotation.Nullable String lat, @javax.annotation.Nullable String _long, @javax.annotation.Nullable String date, @javax.annotation.Nullable String output, @javax.annotation.Nullable String lang, final ApiCallback _callback) throws ApiException {
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
        String localVarPath = "/astronomy";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        if (ip != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("ip", ip));
        }

        if (location != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("location", location));
        }

        if (lat != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("lat", lat));
        }

        if (_long != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("long", _long));
        }

        if (date != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("date", date));
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
    private okhttp3.Call astronomyGetValidateBeforeCall(@javax.annotation.Nullable String ip, @javax.annotation.Nullable String location, @javax.annotation.Nullable String lat, @javax.annotation.Nullable String _long, @javax.annotation.Nullable String date, @javax.annotation.Nullable String output, @javax.annotation.Nullable String lang, final ApiCallback _callback) throws ApiException {
        return astronomyGetCall(ip, location, lat, _long, date, output, lang, _callback);

    }


    private ApiResponse<AstronomyResponse> astronomyGetWithHttpInfo(@javax.annotation.Nullable String ip, @javax.annotation.Nullable String location, @javax.annotation.Nullable String lat, @javax.annotation.Nullable String _long, @javax.annotation.Nullable String date, @javax.annotation.Nullable String output, @javax.annotation.Nullable String lang) throws ApiException {
        okhttp3.Call localVarCall = astronomyGetValidateBeforeCall(ip, location, lat, _long, date, output, lang, null);
        Type localVarReturnType = new TypeToken<AstronomyResponse>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call astronomyGetAsync(@javax.annotation.Nullable String ip, @javax.annotation.Nullable String location, @javax.annotation.Nullable String lat, @javax.annotation.Nullable String _long, @javax.annotation.Nullable String date, @javax.annotation.Nullable String output, @javax.annotation.Nullable String lang, final ApiCallback<AstronomyResponse> _callback) throws ApiException {

        okhttp3.Call localVarCall = astronomyGetValidateBeforeCall(ip, location, lat, _long, date, output, lang, _callback);
        Type localVarReturnType = new TypeToken<AstronomyResponse>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class APIastronomyGetRequest {
        @javax.annotation.Nullable
        private String ip;
        @javax.annotation.Nullable
        private String location;
        @javax.annotation.Nullable
        private String lat;
        @javax.annotation.Nullable
        private String _long;
        @javax.annotation.Nullable
        private String date;
        @javax.annotation.Nullable
        private String output;
        @javax.annotation.Nullable
        private String lang;

        private APIastronomyGetRequest() {
        }

        /**
         * Set ip
         * @param ip query paramter &#39;ip&#39;. If not provided, will be your network IP (optional)
         * @return APIastronomyGetRequest
         */
        public APIastronomyGetRequest ip(@javax.annotation.Nullable String ip) {
            this.ip = ip;
            return this;
        }

        /**
         * Set location
         * @param location query paramter &#39;location&#39;. If not provided, will be your ip location (optional)
         * @return APIastronomyGetRequest
         */
        public APIastronomyGetRequest location(@javax.annotation.Nullable String location) {
            this.location = location;
            return this;
        }

        /**
         * Set lat
         * @param lat query paramter &#39;lat&#39;. (optional)
         * @return APIastronomyGetRequest
         */
        public APIastronomyGetRequest lat(@javax.annotation.Nullable String lat) {
            this.lat = lat;
            return this;
        }

        /**
         * Set _long
         * @param _long query paramter &#39;long&#39;. (optional)
         * @return APIastronomyGetRequest
         */
        public APIastronomyGetRequest _long(@javax.annotation.Nullable String _long) {
            this._long = _long;
            return this;
        }

        /**
         * Set date
         * @param date The date (YYYY-MM-DD) to lookup for. default will be the current date (optional)
         * @return APIastronomyGetRequest
         */
        public APIastronomyGetRequest date(@javax.annotation.Nullable String date) {
            this.date = date;
            return this;
        }

        /**
         * Set output
         * @param output Desired output format. (optional)
         * @return APIastronomyGetRequest
         */
        public APIastronomyGetRequest output(@javax.annotation.Nullable String output) {
            this.output = output;
            return this;
        }

        /**
         * Set lang
         * @param lang By default, the API responds in English. You can change the response language by passing the language code as a query parameter &#x60;lang&#x60;. Multi language feature is available only for &#x60;paid users&#x60;. (optional)
         * @return APIastronomyGetRequest
         */
        public APIastronomyGetRequest lang(@javax.annotation.Nullable String lang) {
            this.lang = lang;
            return this;
        }

        /**
         * Build call for astronomyGet
         * @param _callback ApiCallback API callback
         * @return Call to execute
         * @throws ApiException If fail to serialize the request body object
         * @http.response.details
         <table border="1">
       <caption>Response Details</caption>
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> Successful response </td><td>  -  </td></tr>
            <tr><td> 400 </td><td> Bad Request – Possible reasons include:   - Invalid or not found location/address   - Special characters in API key or value   - Invalid date format (expected: yyyy-MM-dd)   - IP not found in the database  </td><td>  -  </td></tr>
            <tr><td> 401 </td><td> Unauthorized – Possible reasons include:   - Missing or invalid API key   - Account unverified, locked, or disabled   - Accessing API with an unauthorized key   - Subscription expired or downgraded  </td><td>  -  </td></tr>
            <tr><td> 405 </td><td> Method Not Allowed – Only GET is allowed for &#x60;/astronomy&#x60; endpoint </td><td>  -  </td></tr>
            <tr><td> 429 </td><td> Too Many Requests – API usage limits exceeded for current plan </td><td>  -  </td></tr>
            <tr><td> 499 </td><td> Client Closed Request – Client terminated connection before completion </td><td>  -  </td></tr>
            <tr><td> 500 </td><td> Internal Server Error – Something went wrong on our end </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call buildCall(final ApiCallback _callback) throws ApiException {
            return astronomyGetCall(ip, location, lat, _long, date, output, lang, _callback);
        }

        /**
         * Execute astronomyGet request
         * @return AstronomyResponse
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table border="1">
       <caption>Response Details</caption>
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> Successful response </td><td>  -  </td></tr>
            <tr><td> 400 </td><td> Bad Request – Possible reasons include:   - Invalid or not found location/address   - Special characters in API key or value   - Invalid date format (expected: yyyy-MM-dd)   - IP not found in the database  </td><td>  -  </td></tr>
            <tr><td> 401 </td><td> Unauthorized – Possible reasons include:   - Missing or invalid API key   - Account unverified, locked, or disabled   - Accessing API with an unauthorized key   - Subscription expired or downgraded  </td><td>  -  </td></tr>
            <tr><td> 405 </td><td> Method Not Allowed – Only GET is allowed for &#x60;/astronomy&#x60; endpoint </td><td>  -  </td></tr>
            <tr><td> 429 </td><td> Too Many Requests – API usage limits exceeded for current plan </td><td>  -  </td></tr>
            <tr><td> 499 </td><td> Client Closed Request – Client terminated connection before completion </td><td>  -  </td></tr>
            <tr><td> 500 </td><td> Internal Server Error – Something went wrong on our end </td><td>  -  </td></tr>
         </table>
         */
        public AstronomyResponse execute() throws ApiException {
            ApiResponse<AstronomyResponse> localVarResp = astronomyGetWithHttpInfo(ip, location, lat, _long, date, output, lang);
            return localVarResp.getData();
        }

        /**
         * Execute astronomyGet request with HTTP info returned
         * @return ApiResponse&lt;AstronomyResponse&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table border="1">
       <caption>Response Details</caption>
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> Successful response </td><td>  -  </td></tr>
            <tr><td> 400 </td><td> Bad Request – Possible reasons include:   - Invalid or not found location/address   - Special characters in API key or value   - Invalid date format (expected: yyyy-MM-dd)   - IP not found in the database  </td><td>  -  </td></tr>
            <tr><td> 401 </td><td> Unauthorized – Possible reasons include:   - Missing or invalid API key   - Account unverified, locked, or disabled   - Accessing API with an unauthorized key   - Subscription expired or downgraded  </td><td>  -  </td></tr>
            <tr><td> 405 </td><td> Method Not Allowed – Only GET is allowed for &#x60;/astronomy&#x60; endpoint </td><td>  -  </td></tr>
            <tr><td> 429 </td><td> Too Many Requests – API usage limits exceeded for current plan </td><td>  -  </td></tr>
            <tr><td> 499 </td><td> Client Closed Request – Client terminated connection before completion </td><td>  -  </td></tr>
            <tr><td> 500 </td><td> Internal Server Error – Something went wrong on our end </td><td>  -  </td></tr>
         </table>
         */
        public ApiResponse<AstronomyResponse> executeWithHttpInfo() throws ApiException {
            return astronomyGetWithHttpInfo(ip, location, lat, _long, date, output, lang);
        }

        /**
         * Execute astronomyGet request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table border="1">
       <caption>Response Details</caption>
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> Successful response </td><td>  -  </td></tr>
            <tr><td> 400 </td><td> Bad Request – Possible reasons include:   - Invalid or not found location/address   - Special characters in API key or value   - Invalid date format (expected: yyyy-MM-dd)   - IP not found in the database  </td><td>  -  </td></tr>
            <tr><td> 401 </td><td> Unauthorized – Possible reasons include:   - Missing or invalid API key   - Account unverified, locked, or disabled   - Accessing API with an unauthorized key   - Subscription expired or downgraded  </td><td>  -  </td></tr>
            <tr><td> 405 </td><td> Method Not Allowed – Only GET is allowed for &#x60;/astronomy&#x60; endpoint </td><td>  -  </td></tr>
            <tr><td> 429 </td><td> Too Many Requests – API usage limits exceeded for current plan </td><td>  -  </td></tr>
            <tr><td> 499 </td><td> Client Closed Request – Client terminated connection before completion </td><td>  -  </td></tr>
            <tr><td> 500 </td><td> Internal Server Error – Something went wrong on our end </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<AstronomyResponse> _callback) throws ApiException {
            return astronomyGetAsync(ip, location, lat, _long, date, output, lang, _callback);
        }
    }

    /**
     * 
     * The Astronomy API provides the location-based rise and set times for the Sun and Moon along with the current position, distance from earth, and azimuth of the Sun and the Moon for a specific date at the queried time. 
     * @return APIastronomyGetRequest
     * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Successful response </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Bad Request – Possible reasons include:   - Invalid or not found location/address   - Special characters in API key or value   - Invalid date format (expected: yyyy-MM-dd)   - IP not found in the database  </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized – Possible reasons include:   - Missing or invalid API key   - Account unverified, locked, or disabled   - Accessing API with an unauthorized key   - Subscription expired or downgraded  </td><td>  -  </td></tr>
        <tr><td> 405 </td><td> Method Not Allowed – Only GET is allowed for &#x60;/astronomy&#x60; endpoint </td><td>  -  </td></tr>
        <tr><td> 429 </td><td> Too Many Requests – API usage limits exceeded for current plan </td><td>  -  </td></tr>
        <tr><td> 499 </td><td> Client Closed Request – Client terminated connection before completion </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> Internal Server Error – Something went wrong on our end </td><td>  -  </td></tr>
     </table>
     */
    public APIastronomyGetRequest getAstronomy() {
        return new APIastronomyGetRequest();
    }
}
