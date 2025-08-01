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


import io.ipgeolocation.sdk.model.TimezoneConversionResponse;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TimezoneConversionAPI {
    private ApiClient localVarApiClient;
    private int localHostIndex;
    private String localCustomBaseUrl;

    public TimezoneConversionAPI() {
        this(Configuration.getDefaultApiClient());
    }

    public TimezoneConversionAPI(ApiClient apiClient) {
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

    private okhttp3.Call timezoneConvertGetCall(@javax.annotation.Nullable String time, @javax.annotation.Nullable String tzFrom, @javax.annotation.Nullable String tzTo, @javax.annotation.Nullable Float latFrom, @javax.annotation.Nullable Float longFrom, @javax.annotation.Nullable Float latTo, @javax.annotation.Nullable Float longTo, @javax.annotation.Nullable String locationFrom, @javax.annotation.Nullable String locationTo, @javax.annotation.Nullable String icaoFrom, @javax.annotation.Nullable String icaoTo, @javax.annotation.Nullable String iataFrom, @javax.annotation.Nullable String iataTo, @javax.annotation.Nullable String locodeFrom, @javax.annotation.Nullable String locodeTo, final ApiCallback _callback) throws ApiException {
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
        String localVarPath = "/timezone/convert";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        if (time != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("time", time));
        }

        if (tzFrom != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("tz_from", tzFrom));
        }

        if (tzTo != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("tz_to", tzTo));
        }

        if (latFrom != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("lat_from", latFrom));
        }

        if (longFrom != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("long_from", longFrom));
        }

        if (latTo != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("lat_to", latTo));
        }

        if (longTo != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("long_to", longTo));
        }

        if (locationFrom != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("location_from", locationFrom));
        }

        if (locationTo != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("location_to", locationTo));
        }

        if (icaoFrom != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("icao_from", icaoFrom));
        }

        if (icaoTo != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("icao_to", icaoTo));
        }

        if (iataFrom != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("iata_from", iataFrom));
        }

        if (iataTo != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("iata_to", iataTo));
        }

        if (locodeFrom != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("locode_from", locodeFrom));
        }

        if (locodeTo != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("locode_to", locodeTo));
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
    private okhttp3.Call timezoneConvertGetValidateBeforeCall(@javax.annotation.Nullable String time, @javax.annotation.Nullable String tzFrom, @javax.annotation.Nullable String tzTo, @javax.annotation.Nullable Float latFrom, @javax.annotation.Nullable Float longFrom, @javax.annotation.Nullable Float latTo, @javax.annotation.Nullable Float longTo, @javax.annotation.Nullable String locationFrom, @javax.annotation.Nullable String locationTo, @javax.annotation.Nullable String icaoFrom, @javax.annotation.Nullable String icaoTo, @javax.annotation.Nullable String iataFrom, @javax.annotation.Nullable String iataTo, @javax.annotation.Nullable String locodeFrom, @javax.annotation.Nullable String locodeTo, final ApiCallback _callback) throws ApiException {
        return timezoneConvertGetCall(time, tzFrom, tzTo, latFrom, longFrom, latTo, longTo, locationFrom, locationTo, icaoFrom, icaoTo, iataFrom, iataTo, locodeFrom, locodeTo, _callback);

    }


    private ApiResponse<TimezoneConversionResponse> timezoneConvertGetWithHttpInfo(@javax.annotation.Nullable String time, @javax.annotation.Nullable String tzFrom, @javax.annotation.Nullable String tzTo, @javax.annotation.Nullable Float latFrom, @javax.annotation.Nullable Float longFrom, @javax.annotation.Nullable Float latTo, @javax.annotation.Nullable Float longTo, @javax.annotation.Nullable String locationFrom, @javax.annotation.Nullable String locationTo, @javax.annotation.Nullable String icaoFrom, @javax.annotation.Nullable String icaoTo, @javax.annotation.Nullable String iataFrom, @javax.annotation.Nullable String iataTo, @javax.annotation.Nullable String locodeFrom, @javax.annotation.Nullable String locodeTo) throws ApiException {
        okhttp3.Call localVarCall = timezoneConvertGetValidateBeforeCall(time, tzFrom, tzTo, latFrom, longFrom, latTo, longTo, locationFrom, locationTo, icaoFrom, icaoTo, iataFrom, iataTo, locodeFrom, locodeTo, null);
        Type localVarReturnType = new TypeToken<TimezoneConversionResponse>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call timezoneConvertGetAsync(@javax.annotation.Nullable String time, @javax.annotation.Nullable String tzFrom, @javax.annotation.Nullable String tzTo, @javax.annotation.Nullable Float latFrom, @javax.annotation.Nullable Float longFrom, @javax.annotation.Nullable Float latTo, @javax.annotation.Nullable Float longTo, @javax.annotation.Nullable String locationFrom, @javax.annotation.Nullable String locationTo, @javax.annotation.Nullable String icaoFrom, @javax.annotation.Nullable String icaoTo, @javax.annotation.Nullable String iataFrom, @javax.annotation.Nullable String iataTo, @javax.annotation.Nullable String locodeFrom, @javax.annotation.Nullable String locodeTo, final ApiCallback<TimezoneConversionResponse> _callback) throws ApiException {

        okhttp3.Call localVarCall = timezoneConvertGetValidateBeforeCall(time, tzFrom, tzTo, latFrom, longFrom, latTo, longTo, locationFrom, locationTo, icaoFrom, icaoTo, iataFrom, iataTo, locodeFrom, locodeTo, _callback);
        Type localVarReturnType = new TypeToken<TimezoneConversionResponse>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class APItimezoneConvertGetRequest {
        @javax.annotation.Nullable
        private String time;
        @javax.annotation.Nullable
        private String tzFrom;
        @javax.annotation.Nullable
        private String tzTo;
        @javax.annotation.Nullable
        private Float latFrom;
        @javax.annotation.Nullable
        private Float longFrom;
        @javax.annotation.Nullable
        private Float latTo;
        @javax.annotation.Nullable
        private Float longTo;
        @javax.annotation.Nullable
        private String locationFrom;
        @javax.annotation.Nullable
        private String locationTo;
        @javax.annotation.Nullable
        private String icaoFrom;
        @javax.annotation.Nullable
        private String icaoTo;
        @javax.annotation.Nullable
        private String iataFrom;
        @javax.annotation.Nullable
        private String iataTo;
        @javax.annotation.Nullable
        private String locodeFrom;
        @javax.annotation.Nullable
        private String locodeTo;

        private APItimezoneConvertGetRequest() {
        }

        /**
         * Set time
         * @param time time parameter takes the input in the following two formats: i) &#39;yyyy-MM-dd HH:mm&#39;, and ii) &#39;yyyy-MM-dd HH:mm:ss&#39;. This parameter is optional and you can omit it to convert the current time between two coordinates, time zones or locations. (optional)
         * @return APItimezoneConvertGetRequest
         */
        public APItimezoneConvertGetRequest time(@javax.annotation.Nullable String time) {
            this.time = time;
            return this;
        }

        /**
         * Set tzFrom
         * @param tzFrom timezone to convert from (optional)
         * @return APItimezoneConvertGetRequest
         */
        public APItimezoneConvertGetRequest tzFrom(@javax.annotation.Nullable String tzFrom) {
            this.tzFrom = tzFrom;
            return this;
        }

        /**
         * Set tzTo
         * @param tzTo timezone to convert to (optional)
         * @return APItimezoneConvertGetRequest
         */
        public APItimezoneConvertGetRequest tzTo(@javax.annotation.Nullable String tzTo) {
            this.tzTo = tzTo;
            return this;
        }

        /**
         * Set latFrom
         * @param latFrom latitude to convert from (optional)
         * @return APItimezoneConvertGetRequest
         */
        public APItimezoneConvertGetRequest latFrom(@javax.annotation.Nullable Float latFrom) {
            this.latFrom = latFrom;
            return this;
        }

        /**
         * Set longFrom
         * @param longFrom longitude to convert from (optional)
         * @return APItimezoneConvertGetRequest
         */
        public APItimezoneConvertGetRequest longFrom(@javax.annotation.Nullable Float longFrom) {
            this.longFrom = longFrom;
            return this;
        }

        /**
         * Set latTo
         * @param latTo latitude to convert to (optional)
         * @return APItimezoneConvertGetRequest
         */
        public APItimezoneConvertGetRequest latTo(@javax.annotation.Nullable Float latTo) {
            this.latTo = latTo;
            return this;
        }

        /**
         * Set longTo
         * @param longTo longitude to convert to (optional)
         * @return APItimezoneConvertGetRequest
         */
        public APItimezoneConvertGetRequest longTo(@javax.annotation.Nullable Float longTo) {
            this.longTo = longTo;
            return this;
        }

        /**
         * Set locationFrom
         * @param locationFrom location to convert from (optional)
         * @return APItimezoneConvertGetRequest
         */
        public APItimezoneConvertGetRequest locationFrom(@javax.annotation.Nullable String locationFrom) {
            this.locationFrom = locationFrom;
            return this;
        }

        /**
         * Set locationTo
         * @param locationTo location to convert to (optional)
         * @return APItimezoneConvertGetRequest
         */
        public APItimezoneConvertGetRequest locationTo(@javax.annotation.Nullable String locationTo) {
            this.locationTo = locationTo;
            return this;
        }

        /**
         * Set icaoFrom
         * @param icaoFrom location to convert from (optional)
         * @return APItimezoneConvertGetRequest
         */
        public APItimezoneConvertGetRequest icaoFrom(@javax.annotation.Nullable String icaoFrom) {
            this.icaoFrom = icaoFrom;
            return this;
        }

        /**
         * Set icaoTo
         * @param icaoTo location to convert to (optional)
         * @return APItimezoneConvertGetRequest
         */
        public APItimezoneConvertGetRequest icaoTo(@javax.annotation.Nullable String icaoTo) {
            this.icaoTo = icaoTo;
            return this;
        }

        /**
         * Set iataFrom
         * @param iataFrom location to convert from (optional)
         * @return APItimezoneConvertGetRequest
         */
        public APItimezoneConvertGetRequest iataFrom(@javax.annotation.Nullable String iataFrom) {
            this.iataFrom = iataFrom;
            return this;
        }

        /**
         * Set iataTo
         * @param iataTo location to convert to (optional)
         * @return APItimezoneConvertGetRequest
         */
        public APItimezoneConvertGetRequest iataTo(@javax.annotation.Nullable String iataTo) {
            this.iataTo = iataTo;
            return this;
        }

        /**
         * Set locodeFrom
         * @param locodeFrom location to convert from (optional)
         * @return APItimezoneConvertGetRequest
         */
        public APItimezoneConvertGetRequest locodeFrom(@javax.annotation.Nullable String locodeFrom) {
            this.locodeFrom = locodeFrom;
            return this;
        }

        /**
         * Set locodeTo
         * @param locodeTo location to convert to (optional)
         * @return APItimezoneConvertGetRequest
         */
        public APItimezoneConvertGetRequest locodeTo(@javax.annotation.Nullable String locodeTo) {
            this.locodeTo = locodeTo;
            return this;
        }

        /**
         * Build call for timezoneConvertGet
         * @param _callback ApiCallback API callback
         * @return Call to execute
         * @throws ApiException If fail to serialize the request body object
         * @http.response.details
         <table border="1">
       <caption>Response Details</caption>
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> Successful response </td><td>  -  </td></tr>
            <tr><td> 400 </td><td> Bad Request – Possible reasons include:   - If one of the query paramters tz_from and tz_to is provided and other is missing, for time conversion.    - If one of the query paramters location_from and location_to is provided and other is missing, for time conversion.      - If one of the query paramters lat_from, long_from, lat_to, and long_to is provided and other(s) is/are missing, for time conversion.      - If the location address provided to one of the paramters location_from and location_to is invalid, for time conversion. City or state level address must be provided.      - If the geographic coordinates provided to one of the paramters lat_from, long_from, lat_to, and long_to is/are not numbers, or the values fall outside the acceptable latitude and longitude ranges. The valid range for latitude is between -90 and 90, and for longitude, it is between -180 and 180.      - If the time zone names provided to one of the paramters tz_from and tz_to is/are wrong or not registered in the IANA time zone database.      - If none of the query parameter combination is provided for time conversion. tz_from and tz_to or location_from and location_to or lat_from, long_from, lat_to, long_to combination must be provided.  </td><td>  -  </td></tr>
            <tr><td> 401 </td><td> Unauthorized – Possible reasons include:   - Missing or invalid API key   - Account unverified, locked, or disabled   - Accessing API with an unauthorized key   - Subscription expired or downgraded   - If your account has been disabled or locked to use by the admin due to abuse or illegal activity.   - When the request to IP Geolocation API is made using API key for a database subscription   - When the request to IP Geolocation API is made on the &#39;paused&#39; subscription.   - If you’re making API requests after your subscription trial has been expired.   - If your active until date has passed and you need to upgrade your account.  </td><td>  -  </td></tr>
            <tr><td> 404 </td><td> Not Found – Possible reasons include:   - If the IPv4, IPv6, or domain name does not not exists in our database.    - If the IPv4, IPv6, or domain name is passed as a path variable, instead of url parameter as ip&#x3D;.      - If the location address provided to the request paramters location is invalid. City or state level address must be provided.      - If the provided ICAO code to the request paramter icao_code is not in the format as four letter code AAAA.      - If the provided UN/LOCODE, IATA code or ICAO code to the query paramters lo_code, iata_code, or icao_code does not exists in our database.      - If the wrong endpoint is called, that does not exists in our API.  </td><td>  -  </td></tr>
            <tr><td> 405 </td><td> Method Not Allowed – Only GET is allowed for &#x60;/timezone/convert&#x60; endpoint </td><td>  -  </td></tr>
            <tr><td> 429 </td><td> Too Many Requests – Possible reasons include:   - If the API usage limit has reached for the free subscriptions, or paid subscriptions with the status &#39;past due&#39;, &#39;deleted&#39; or &#39;trial expired&#39;.    - If the surcharge API usage limit has reached against the subscribed plan.     </td><td>  -  </td></tr>
            <tr><td> 499 </td><td> Client Closed Request – Client terminated connection before completion </td><td>  -  </td></tr>
            <tr><td> 500 </td><td> Internal Server Error – Something went wrong on our end </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call buildCall(final ApiCallback _callback) throws ApiException {
            return timezoneConvertGetCall(time, tzFrom, tzTo, latFrom, longFrom, latTo, longTo, locationFrom, locationTo, icaoFrom, icaoTo, iataFrom, iataTo, locodeFrom, locodeTo, _callback);
        }

        /**
         * Execute timezoneConvertGet request
         * @return TimeConversionResponse
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table border="1">
       <caption>Response Details</caption>
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> Successful response </td><td>  -  </td></tr>
            <tr><td> 400 </td><td> Bad Request – Possible reasons include:   - If one of the query paramters tz_from and tz_to is provided and other is missing, for time conversion.    - If one of the query paramters location_from and location_to is provided and other is missing, for time conversion.      - If one of the query paramters lat_from, long_from, lat_to, and long_to is provided and other(s) is/are missing, for time conversion.      - If the location address provided to one of the paramters location_from and location_to is invalid, for time conversion. City or state level address must be provided.      - If the geographic coordinates provided to one of the paramters lat_from, long_from, lat_to, and long_to is/are not numbers, or the values fall outside the acceptable latitude and longitude ranges. The valid range for latitude is between -90 and 90, and for longitude, it is between -180 and 180.      - If the time zone names provided to one of the paramters tz_from and tz_to is/are wrong or not registered in the IANA time zone database.      - If none of the query parameter combination is provided for time conversion. tz_from and tz_to or location_from and location_to or lat_from, long_from, lat_to, long_to combination must be provided.  </td><td>  -  </td></tr>
            <tr><td> 401 </td><td> Unauthorized – Possible reasons include:   - Missing or invalid API key   - Account unverified, locked, or disabled   - Accessing API with an unauthorized key   - Subscription expired or downgraded   - If your account has been disabled or locked to use by the admin due to abuse or illegal activity.   - When the request to IP Geolocation API is made using API key for a database subscription   - When the request to IP Geolocation API is made on the &#39;paused&#39; subscription.   - If you’re making API requests after your subscription trial has been expired.   - If your active until date has passed and you need to upgrade your account.  </td><td>  -  </td></tr>
            <tr><td> 404 </td><td> Not Found – Possible reasons include:   - If the IPv4, IPv6, or domain name does not not exists in our database.    - If the IPv4, IPv6, or domain name is passed as a path variable, instead of url parameter as ip&#x3D;.      - If the location address provided to the request paramters location is invalid. City or state level address must be provided.      - If the provided ICAO code to the request paramter icao_code is not in the format as four letter code AAAA.      - If the provided UN/LOCODE, IATA code or ICAO code to the query paramters lo_code, iata_code, or icao_code does not exists in our database.      - If the wrong endpoint is called, that does not exists in our API.  </td><td>  -  </td></tr>
            <tr><td> 405 </td><td> Method Not Allowed – Only GET is allowed for &#x60;/timezone/convert&#x60; endpoint </td><td>  -  </td></tr>
            <tr><td> 429 </td><td> Too Many Requests – Possible reasons include:   - If the API usage limit has reached for the free subscriptions, or paid subscriptions with the status &#39;past due&#39;, &#39;deleted&#39; or &#39;trial expired&#39;.    - If the surcharge API usage limit has reached against the subscribed plan.     </td><td>  -  </td></tr>
            <tr><td> 499 </td><td> Client Closed Request – Client terminated connection before completion </td><td>  -  </td></tr>
            <tr><td> 500 </td><td> Internal Server Error – Something went wrong on our end </td><td>  -  </td></tr>
         </table>
         */
        public TimezoneConversionResponse execute() throws ApiException {
            ApiResponse<TimezoneConversionResponse> localVarResp = timezoneConvertGetWithHttpInfo(time, tzFrom, tzTo, latFrom, longFrom, latTo, longTo, locationFrom, locationTo, icaoFrom, icaoTo, iataFrom, iataTo, locodeFrom, locodeTo);
            return localVarResp.getData();
        }

        /**
         * Execute timezoneConvertGet request with HTTP info returned
         * @return ApiResponse&lt;TimeConversionResponse&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table border="1">
       <caption>Response Details</caption>
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> Successful response </td><td>  -  </td></tr>
            <tr><td> 400 </td><td> Bad Request – Possible reasons include:   - If one of the query paramters tz_from and tz_to is provided and other is missing, for time conversion.    - If one of the query paramters location_from and location_to is provided and other is missing, for time conversion.      - If one of the query paramters lat_from, long_from, lat_to, and long_to is provided and other(s) is/are missing, for time conversion.      - If the location address provided to one of the paramters location_from and location_to is invalid, for time conversion. City or state level address must be provided.      - If the geographic coordinates provided to one of the paramters lat_from, long_from, lat_to, and long_to is/are not numbers, or the values fall outside the acceptable latitude and longitude ranges. The valid range for latitude is between -90 and 90, and for longitude, it is between -180 and 180.      - If the time zone names provided to one of the paramters tz_from and tz_to is/are wrong or not registered in the IANA time zone database.      - If none of the query parameter combination is provided for time conversion. tz_from and tz_to or location_from and location_to or lat_from, long_from, lat_to, long_to combination must be provided.  </td><td>  -  </td></tr>
            <tr><td> 401 </td><td> Unauthorized – Possible reasons include:   - Missing or invalid API key   - Account unverified, locked, or disabled   - Accessing API with an unauthorized key   - Subscription expired or downgraded   - If your account has been disabled or locked to use by the admin due to abuse or illegal activity.   - When the request to IP Geolocation API is made using API key for a database subscription   - When the request to IP Geolocation API is made on the &#39;paused&#39; subscription.   - If you’re making API requests after your subscription trial has been expired.   - If your active until date has passed and you need to upgrade your account.  </td><td>  -  </td></tr>
            <tr><td> 404 </td><td> Not Found – Possible reasons include:   - If the IPv4, IPv6, or domain name does not not exists in our database.    - If the IPv4, IPv6, or domain name is passed as a path variable, instead of url parameter as ip&#x3D;.      - If the location address provided to the request paramters location is invalid. City or state level address must be provided.      - If the provided ICAO code to the request paramter icao_code is not in the format as four letter code AAAA.      - If the provided UN/LOCODE, IATA code or ICAO code to the query paramters lo_code, iata_code, or icao_code does not exists in our database.      - If the wrong endpoint is called, that does not exists in our API.  </td><td>  -  </td></tr>
            <tr><td> 405 </td><td> Method Not Allowed – Only GET is allowed for &#x60;/timezone/convert&#x60; endpoint </td><td>  -  </td></tr>
            <tr><td> 429 </td><td> Too Many Requests – Possible reasons include:   - If the API usage limit has reached for the free subscriptions, or paid subscriptions with the status &#39;past due&#39;, &#39;deleted&#39; or &#39;trial expired&#39;.    - If the surcharge API usage limit has reached against the subscribed plan.     </td><td>  -  </td></tr>
            <tr><td> 499 </td><td> Client Closed Request – Client terminated connection before completion </td><td>  -  </td></tr>
            <tr><td> 500 </td><td> Internal Server Error – Something went wrong on our end </td><td>  -  </td></tr>
         </table>
         */
        public ApiResponse<TimezoneConversionResponse> executeWithHttpInfo() throws ApiException {
            return timezoneConvertGetWithHttpInfo(time, tzFrom, tzTo, latFrom, longFrom, latTo, longTo, locationFrom, locationTo, icaoFrom, icaoTo, iataFrom, iataTo, locodeFrom, locodeTo);
        }

        /**
         * Execute timezoneConvertGet request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table border="1">
       <caption>Response Details</caption>
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> Successful response </td><td>  -  </td></tr>
            <tr><td> 400 </td><td> Bad Request – Possible reasons include:   - If one of the query paramters tz_from and tz_to is provided and other is missing, for time conversion.    - If one of the query paramters location_from and location_to is provided and other is missing, for time conversion.      - If one of the query paramters lat_from, long_from, lat_to, and long_to is provided and other(s) is/are missing, for time conversion.      - If the location address provided to one of the paramters location_from and location_to is invalid, for time conversion. City or state level address must be provided.      - If the geographic coordinates provided to one of the paramters lat_from, long_from, lat_to, and long_to is/are not numbers, or the values fall outside the acceptable latitude and longitude ranges. The valid range for latitude is between -90 and 90, and for longitude, it is between -180 and 180.      - If the time zone names provided to one of the paramters tz_from and tz_to is/are wrong or not registered in the IANA time zone database.      - If none of the query parameter combination is provided for time conversion. tz_from and tz_to or location_from and location_to or lat_from, long_from, lat_to, long_to combination must be provided.  </td><td>  -  </td></tr>
            <tr><td> 401 </td><td> Unauthorized – Possible reasons include:   - Missing or invalid API key   - Account unverified, locked, or disabled   - Accessing API with an unauthorized key   - Subscription expired or downgraded   - If your account has been disabled or locked to use by the admin due to abuse or illegal activity.   - When the request to IP Geolocation API is made using API key for a database subscription   - When the request to IP Geolocation API is made on the &#39;paused&#39; subscription.   - If you’re making API requests after your subscription trial has been expired.   - If your active until date has passed and you need to upgrade your account.  </td><td>  -  </td></tr>
            <tr><td> 404 </td><td> Not Found – Possible reasons include:   - If the IPv4, IPv6, or domain name does not not exists in our database.    - If the IPv4, IPv6, or domain name is passed as a path variable, instead of url parameter as ip&#x3D;.      - If the location address provided to the request paramters location is invalid. City or state level address must be provided.      - If the provided ICAO code to the request paramter icao_code is not in the format as four letter code AAAA.      - If the provided UN/LOCODE, IATA code or ICAO code to the query paramters lo_code, iata_code, or icao_code does not exists in our database.      - If the wrong endpoint is called, that does not exists in our API.  </td><td>  -  </td></tr>
            <tr><td> 405 </td><td> Method Not Allowed – Only GET is allowed for &#x60;/timezone/convert&#x60; endpoint </td><td>  -  </td></tr>
            <tr><td> 429 </td><td> Too Many Requests – Possible reasons include:   - If the API usage limit has reached for the free subscriptions, or paid subscriptions with the status &#39;past due&#39;, &#39;deleted&#39; or &#39;trial expired&#39;.    - If the surcharge API usage limit has reached against the subscribed plan.     </td><td>  -  </td></tr>
            <tr><td> 499 </td><td> Client Closed Request – Client terminated connection before completion </td><td>  -  </td></tr>
            <tr><td> 500 </td><td> Internal Server Error – Something went wrong on our end </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<TimezoneConversionResponse> _callback) throws ApiException {
            return timezoneConvertGetAsync(time, tzFrom, tzTo, latFrom, longFrom, latTo, longTo, locationFrom, locationTo, icaoFrom, icaoTo, iataFrom, iataTo, locodeFrom, locodeTo, _callback);
        }
    }

    /**
     * 
     * You can convert a timestamp provided as a query paramter time from one time zone to another time zone.
     * @return APItimezoneConvertGetRequest
     * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Successful response </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Bad Request – Possible reasons include:   - If one of the query paramters tz_from and tz_to is provided and other is missing, for time conversion.    - If one of the query paramters location_from and location_to is provided and other is missing, for time conversion.      - If one of the query paramters lat_from, long_from, lat_to, and long_to is provided and other(s) is/are missing, for time conversion.      - If the location address provided to one of the paramters location_from and location_to is invalid, for time conversion. City or state level address must be provided.      - If the geographic coordinates provided to one of the paramters lat_from, long_from, lat_to, and long_to is/are not numbers, or the values fall outside the acceptable latitude and longitude ranges. The valid range for latitude is between -90 and 90, and for longitude, it is between -180 and 180.      - If the time zone names provided to one of the paramters tz_from and tz_to is/are wrong or not registered in the IANA time zone database.      - If none of the query parameter combination is provided for time conversion. tz_from and tz_to or location_from and location_to or lat_from, long_from, lat_to, long_to combination must be provided.  </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized – Possible reasons include:   - Missing or invalid API key   - Account unverified, locked, or disabled   - Accessing API with an unauthorized key   - Subscription expired or downgraded   - If your account has been disabled or locked to use by the admin due to abuse or illegal activity.   - When the request to IP Geolocation API is made using API key for a database subscription   - When the request to IP Geolocation API is made on the &#39;paused&#39; subscription.   - If you’re making API requests after your subscription trial has been expired.   - If your active until date has passed and you need to upgrade your account.  </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found – Possible reasons include:   - If the IPv4, IPv6, or domain name does not not exists in our database.    - If the IPv4, IPv6, or domain name is passed as a path variable, instead of url parameter as ip&#x3D;.      - If the location address provided to the request paramters location is invalid. City or state level address must be provided.      - If the provided ICAO code to the request paramter icao_code is not in the format as four letter code AAAA.      - If the provided UN/LOCODE, IATA code or ICAO code to the query paramters lo_code, iata_code, or icao_code does not exists in our database.      - If the wrong endpoint is called, that does not exists in our API.  </td><td>  -  </td></tr>
        <tr><td> 405 </td><td> Method Not Allowed – Only GET is allowed for &#x60;/timezone/convert&#x60; endpoint </td><td>  -  </td></tr>
        <tr><td> 429 </td><td> Too Many Requests – Possible reasons include:   - If the API usage limit has reached for the free subscriptions, or paid subscriptions with the status &#39;past due&#39;, &#39;deleted&#39; or &#39;trial expired&#39;.    - If the surcharge API usage limit has reached against the subscribed plan.     </td><td>  -  </td></tr>
        <tr><td> 499 </td><td> Client Closed Request – Client terminated connection before completion </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> Internal Server Error – Something went wrong on our end </td><td>  -  </td></tr>
     </table>
     */
    public APItimezoneConvertGetRequest convertTimezone() {
        return new APItimezoneConvertGetRequest();
    }
}
