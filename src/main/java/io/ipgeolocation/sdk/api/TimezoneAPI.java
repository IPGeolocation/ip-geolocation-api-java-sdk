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


import io.ipgeolocation.sdk.model.TimezoneResponse;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TimezoneAPI {
    private ApiClient localVarApiClient;
    private int localHostIndex;
    private String localCustomBaseUrl;

    public TimezoneAPI() {
        this(Configuration.getDefaultApiClient());
    }

    public TimezoneAPI(ApiClient apiClient) {
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

    private okhttp3.Call timezoneGetCall(@javax.annotation.Nullable String tz, @javax.annotation.Nullable String location, @javax.annotation.Nullable Float lat, @javax.annotation.Nullable Float _long, @javax.annotation.Nullable String ip, @javax.annotation.Nullable String iataCode, @javax.annotation.Nullable String icaoCode, @javax.annotation.Nullable String loCode, @javax.annotation.Nullable String output, @javax.annotation.Nullable String lang, final ApiCallback _callback) throws ApiException {
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
        String localVarPath = "/timezone";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        if (tz != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("tz", tz));
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

        if (ip != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("ip", ip));
        }

        if (iataCode != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("iata_code", iataCode));
        }

        if (icaoCode != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("icao_code", icaoCode));
        }

        if (loCode != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("lo_code", loCode));
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
    private okhttp3.Call timezoneGetValidateBeforeCall(@javax.annotation.Nullable String tz, @javax.annotation.Nullable String location, @javax.annotation.Nullable Float lat, @javax.annotation.Nullable Float _long, @javax.annotation.Nullable String ip, @javax.annotation.Nullable String iataCode, @javax.annotation.Nullable String icaoCode, @javax.annotation.Nullable String loCode, @javax.annotation.Nullable String output, @javax.annotation.Nullable String lang, final ApiCallback _callback) throws ApiException {
        return timezoneGetCall(tz, location, lat, _long, ip, iataCode, icaoCode, loCode, output, lang, _callback);

    }


    private ApiResponse<TimezoneResponse> timezoneGetWithHttpInfo(@javax.annotation.Nullable String tz, @javax.annotation.Nullable String location, @javax.annotation.Nullable Float lat, @javax.annotation.Nullable Float _long, @javax.annotation.Nullable String ip, @javax.annotation.Nullable String iataCode, @javax.annotation.Nullable String icaoCode, @javax.annotation.Nullable String loCode, @javax.annotation.Nullable String output, @javax.annotation.Nullable String lang) throws ApiException {
        okhttp3.Call localVarCall = timezoneGetValidateBeforeCall(tz, location, lat, _long, ip, iataCode, icaoCode, loCode, output, lang, null);
        Type localVarReturnType = new TypeToken<TimezoneResponse>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call timezoneGetAsync(@javax.annotation.Nullable String tz, @javax.annotation.Nullable String location, @javax.annotation.Nullable Float lat, @javax.annotation.Nullable Float _long, @javax.annotation.Nullable String ip, @javax.annotation.Nullable String iataCode, @javax.annotation.Nullable String icaoCode, @javax.annotation.Nullable String loCode, @javax.annotation.Nullable String output, @javax.annotation.Nullable String lang, final ApiCallback<TimezoneResponse> _callback) throws ApiException {

        okhttp3.Call localVarCall = timezoneGetValidateBeforeCall(tz, location, lat, _long, ip, iataCode, icaoCode, loCode, output, lang, _callback);
        Type localVarReturnType = new TypeToken<TimezoneResponse>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class APItimezoneGetRequest {
        @javax.annotation.Nullable
        private String tz;
        @javax.annotation.Nullable
        private String location;
        @javax.annotation.Nullable
        private Float lat;
        @javax.annotation.Nullable
        private Float _long;
        @javax.annotation.Nullable
        private String ip;
        @javax.annotation.Nullable
        private String iataCode;
        @javax.annotation.Nullable
        private String icaoCode;
        @javax.annotation.Nullable
        private String loCode;
        @javax.annotation.Nullable
        private String output;
        @javax.annotation.Nullable
        private String lang;

        private APItimezoneGetRequest() {
        }

        /**
         * Set tz
         * @param tz pass a valid time zone name as a query parameter tz to get the time zone information. (optional)
         * @return APItimezoneGetRequest
         */
        public APItimezoneGetRequest tz(@javax.annotation.Nullable String tz) {
            this.tz = tz;
            return this;
        }

        /**
         * Set location
         * @param location pass any address of a location as the query parameter location to get the time zone information. (optional)
         * @return APItimezoneGetRequest
         */
        public APItimezoneGetRequest location(@javax.annotation.Nullable String location) {
            this.location = location;
            return this;
        }

        /**
         * Set lat
         * @param lat pass the latitude of a location as query parameters to get the time zone information. (optional)
         * @return APItimezoneGetRequest
         */
        public APItimezoneGetRequest lat(@javax.annotation.Nullable Float lat) {
            this.lat = lat;
            return this;
        }

        /**
         * Set _long
         * @param _long pass the longitude of a location as query parameters to get the time zone information. (optional)
         * @return APItimezoneGetRequest
         */
        public APItimezoneGetRequest _long(@javax.annotation.Nullable Float _long) {
            this._long = _long;
            return this;
        }

        /**
         * Set ip
         * @param ip You can pass any IPv4 or IPv6 address as a query parameter ip to get the regional timezone information. (optional)
         * @return APItimezoneGetRequest
         */
        public APItimezoneGetRequest ip(@javax.annotation.Nullable String ip) {
            this.ip = ip;
            return this;
        }

        /**
         * Set iataCode
         * @param iataCode pass any 3 letter IATA code as a query paramter iata_code to get the comprehensive airport details along with the time zone information, in which that airport exists. (optional)
         * @return APItimezoneGetRequest
         */
        public APItimezoneGetRequest iataCode(@javax.annotation.Nullable String iataCode) {
            this.iataCode = iataCode;
            return this;
        }

        /**
         * Set icaoCode
         * @param icaoCode pass any 4 letter ICAO code as a query paramter icao_code to get the comprehensive airport details along with the time zone information, in which that airport exists. (optional)
         * @return APItimezoneGetRequest
         */
        public APItimezoneGetRequest icaoCode(@javax.annotation.Nullable String icaoCode) {
            this.icaoCode = icaoCode;
            return this;
        }

        /**
         * Set loCode
         * @param loCode pass any 5 letter UNLOCODE as a query paramter lo_code to get the comprehensive lo code/city details along with the time zone information of the concerned city. (optional)
         * @return APItimezoneGetRequest
         */
        public APItimezoneGetRequest loCode(@javax.annotation.Nullable String loCode) {
            this.loCode = loCode;
            return this;
        }

        /**
         * Set output
         * @param output Desired output format (json or xml). (optional)
         * @return APItimezoneGetRequest
         */
        public APItimezoneGetRequest output(@javax.annotation.Nullable String output) {
            this.output = output;
            return this;
        }

        /**
         * Set lang
         * @param lang By default, the API responds in English. You can change the response language by passing the language code as a query parameter &#x60;lang&#x60;. Multi language feature is available only for &#x60;paid users&#x60;. (optional)
         * @return APItimezoneGetRequest
         */
        public APItimezoneGetRequest lang(@javax.annotation.Nullable String lang) {
            this.lang = lang;
            return this;
        }

        /**
         * Build call for timezoneGet
         * @param _callback ApiCallback API callback
         * @return Call to execute
         * @throws ApiException If fail to serialize the request body object
         * @http.response.details
         <table border="1">
       <caption>Response Details</caption>
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> Successful response </td><td>  -  </td></tr>
            <tr><td> 400 </td><td> Bad Request – Possible reasons include:   - If the provided IPv4, IPv6 address, or domain name is invalid.    - If special character(s) ( ) [ ] { } | ^ &#x60; is passed in the API URL either as paramter or its value. Specially in case of API key.      - If the provided IATA code to the request paramter iata_code is not in the format as three letter code AAA.      - If the provided ICAO code to the request paramter icao_code is not in the format as four letter code AAAA.      - If the provided UN/LOCODE to the request paramter lo_code is not in format as first two characters of country code, followed by the three alphanumeric characters of the city/region.      - If the provided values to the request parameters lat andlong are not numbers, or the values fall outside the acceptable latitude and longitude ranges. The valid range for latitude is between -90 and 90, and for longitude, it is between -180 and 180.      - If the bogon or private IP address is provided to query the Time Zone information.      - If the provided time zone name to the query paramter tz is wrong or not registered in the IANA time zone database.  </td><td>  -  </td></tr>
            <tr><td> 401 </td><td> Unauthorized – Possible reasons include:   - Missing or invalid API key   - Account unverified, locked, or disabled   - Accessing API with an unauthorized key   - Subscription expired or downgraded   - If your account has been disabled or locked to use by the admin due to abuse or illegal activity.   - When the request to IP Geolocation API is made using API key for a database subscription   - When the request to IP Geolocation API is made on the &#39;paused&#39; subscription.   - If you’re making API requests after your subscription trial has been expired.   - If your active until date has passed and you need to upgrade your account.  </td><td>  -  </td></tr>
            <tr><td> 404 </td><td> Not Found – Possible reasons include:   - If the IPv4, IPv6, or domain name does not not exists in our database.    - If the IPv4, IPv6, or domain name is passed as a path variable, instead of url parameter as ip&#x3D;.      - If the location address provided to the request paramters location is invalid. City or state level address must be provided.      - If the provided ICAO code to the request paramter icao_code is not in the format as four letter code AAAA.      - If the provided UN/LOCODE, IATA code or ICAO code to the query paramters lo_code, iata_code, or icao_code does not exists in our database.      - If the wrong endpoint is called, that does not exists in our API.  </td><td>  -  </td></tr>
            <tr><td> 405 </td><td> Method Not Allowed – Only GET is allowed for &#x60;/timezone&#x60; endpoint </td><td>  -  </td></tr>
            <tr><td> 429 </td><td> Too Many Requests – Possible reasons include:   - If the API usage limit has reached for the free subscriptions, or paid subscriptions with the status &#39;past due&#39;, &#39;deleted&#39; or &#39;trial expired&#39;.    - If the surcharge API usage limit has reached against the subscribed plan.     </td><td>  -  </td></tr>
            <tr><td> 499 </td><td> Client Closed Request – Client terminated connection before completion </td><td>  -  </td></tr>
            <tr><td> 500 </td><td> Internal Server Error – Something went wrong on our end </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call buildCall(final ApiCallback _callback) throws ApiException {
            return timezoneGetCall(tz, location, lat, _long, ip, iataCode, icaoCode, loCode, output, lang, _callback);
        }

        /**
         * Execute timezoneGet request
         * @return TimeZoneDetailedResponse
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table border="1">
       <caption>Response Details</caption>
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> Successful response </td><td>  -  </td></tr>
            <tr><td> 400 </td><td> Bad Request – Possible reasons include:   - If the provided IPv4, IPv6 address, or domain name is invalid.    - If special character(s) ( ) [ ] { } | ^ &#x60; is passed in the API URL either as paramter or its value. Specially in case of API key.      - If the provided IATA code to the request paramter iata_code is not in the format as three letter code AAA.      - If the provided ICAO code to the request paramter icao_code is not in the format as four letter code AAAA.      - If the provided UN/LOCODE to the request paramter lo_code is not in format as first two characters of country code, followed by the three alphanumeric characters of the city/region.      - If the provided values to the request parameters lat andlong are not numbers, or the values fall outside the acceptable latitude and longitude ranges. The valid range for latitude is between -90 and 90, and for longitude, it is between -180 and 180.      - If the bogon or private IP address is provided to query the Time Zone information.      - If the provided time zone name to the query paramter tz is wrong or not registered in the IANA time zone database.  </td><td>  -  </td></tr>
            <tr><td> 401 </td><td> Unauthorized – Possible reasons include:   - Missing or invalid API key   - Account unverified, locked, or disabled   - Accessing API with an unauthorized key   - Subscription expired or downgraded   - If your account has been disabled or locked to use by the admin due to abuse or illegal activity.   - When the request to IP Geolocation API is made using API key for a database subscription   - When the request to IP Geolocation API is made on the &#39;paused&#39; subscription.   - If you’re making API requests after your subscription trial has been expired.   - If your active until date has passed and you need to upgrade your account.  </td><td>  -  </td></tr>
            <tr><td> 404 </td><td> Not Found – Possible reasons include:   - If the IPv4, IPv6, or domain name does not not exists in our database.    - If the IPv4, IPv6, or domain name is passed as a path variable, instead of url parameter as ip&#x3D;.      - If the location address provided to the request paramters location is invalid. City or state level address must be provided.      - If the provided ICAO code to the request paramter icao_code is not in the format as four letter code AAAA.      - If the provided UN/LOCODE, IATA code or ICAO code to the query paramters lo_code, iata_code, or icao_code does not exists in our database.      - If the wrong endpoint is called, that does not exists in our API.  </td><td>  -  </td></tr>
            <tr><td> 405 </td><td> Method Not Allowed – Only GET is allowed for &#x60;/timezone&#x60; endpoint </td><td>  -  </td></tr>
            <tr><td> 429 </td><td> Too Many Requests – Possible reasons include:   - If the API usage limit has reached for the free subscriptions, or paid subscriptions with the status &#39;past due&#39;, &#39;deleted&#39; or &#39;trial expired&#39;.    - If the surcharge API usage limit has reached against the subscribed plan.     </td><td>  -  </td></tr>
            <tr><td> 499 </td><td> Client Closed Request – Client terminated connection before completion </td><td>  -  </td></tr>
            <tr><td> 500 </td><td> Internal Server Error – Something went wrong on our end </td><td>  -  </td></tr>
         </table>
         */
        public TimezoneResponse execute() throws ApiException {
            ApiResponse<TimezoneResponse> localVarResp = timezoneGetWithHttpInfo(tz, location, lat, _long, ip, iataCode, icaoCode, loCode, output, lang);
            return localVarResp.getData();
        }

        /**
         * Execute timezoneGet request with HTTP info returned
         * @return ApiResponse&lt;TimeZoneDetailedResponse&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table border="1">
       <caption>Response Details</caption>
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> Successful response </td><td>  -  </td></tr>
            <tr><td> 400 </td><td> Bad Request – Possible reasons include:   - If the provided IPv4, IPv6 address, or domain name is invalid.    - If special character(s) ( ) [ ] { } | ^ &#x60; is passed in the API URL either as paramter or its value. Specially in case of API key.      - If the provided IATA code to the request paramter iata_code is not in the format as three letter code AAA.      - If the provided ICAO code to the request paramter icao_code is not in the format as four letter code AAAA.      - If the provided UN/LOCODE to the request paramter lo_code is not in format as first two characters of country code, followed by the three alphanumeric characters of the city/region.      - If the provided values to the request parameters lat andlong are not numbers, or the values fall outside the acceptable latitude and longitude ranges. The valid range for latitude is between -90 and 90, and for longitude, it is between -180 and 180.      - If the bogon or private IP address is provided to query the Time Zone information.      - If the provided time zone name to the query paramter tz is wrong or not registered in the IANA time zone database.  </td><td>  -  </td></tr>
            <tr><td> 401 </td><td> Unauthorized – Possible reasons include:   - Missing or invalid API key   - Account unverified, locked, or disabled   - Accessing API with an unauthorized key   - Subscription expired or downgraded   - If your account has been disabled or locked to use by the admin due to abuse or illegal activity.   - When the request to IP Geolocation API is made using API key for a database subscription   - When the request to IP Geolocation API is made on the &#39;paused&#39; subscription.   - If you’re making API requests after your subscription trial has been expired.   - If your active until date has passed and you need to upgrade your account.  </td><td>  -  </td></tr>
            <tr><td> 404 </td><td> Not Found – Possible reasons include:   - If the IPv4, IPv6, or domain name does not not exists in our database.    - If the IPv4, IPv6, or domain name is passed as a path variable, instead of url parameter as ip&#x3D;.      - If the location address provided to the request paramters location is invalid. City or state level address must be provided.      - If the provided ICAO code to the request paramter icao_code is not in the format as four letter code AAAA.      - If the provided UN/LOCODE, IATA code or ICAO code to the query paramters lo_code, iata_code, or icao_code does not exists in our database.      - If the wrong endpoint is called, that does not exists in our API.  </td><td>  -  </td></tr>
            <tr><td> 405 </td><td> Method Not Allowed – Only GET is allowed for &#x60;/timezone&#x60; endpoint </td><td>  -  </td></tr>
            <tr><td> 429 </td><td> Too Many Requests – Possible reasons include:   - If the API usage limit has reached for the free subscriptions, or paid subscriptions with the status &#39;past due&#39;, &#39;deleted&#39; or &#39;trial expired&#39;.    - If the surcharge API usage limit has reached against the subscribed plan.     </td><td>  -  </td></tr>
            <tr><td> 499 </td><td> Client Closed Request – Client terminated connection before completion </td><td>  -  </td></tr>
            <tr><td> 500 </td><td> Internal Server Error – Something went wrong on our end </td><td>  -  </td></tr>
         </table>
         */
        public ApiResponse<TimezoneResponse> executeWithHttpInfo() throws ApiException {
            return timezoneGetWithHttpInfo(tz, location, lat, _long, ip, iataCode, icaoCode, loCode, output, lang);
        }

        /**
         * Execute timezoneGet request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table border="1">
       <caption>Response Details</caption>
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> Successful response </td><td>  -  </td></tr>
            <tr><td> 400 </td><td> Bad Request – Possible reasons include:   - If the provided IPv4, IPv6 address, or domain name is invalid.    - If special character(s) ( ) [ ] { } | ^ &#x60; is passed in the API URL either as paramter or its value. Specially in case of API key.      - If the provided IATA code to the request paramter iata_code is not in the format as three letter code AAA.      - If the provided ICAO code to the request paramter icao_code is not in the format as four letter code AAAA.      - If the provided UN/LOCODE to the request paramter lo_code is not in format as first two characters of country code, followed by the three alphanumeric characters of the city/region.      - If the provided values to the request parameters lat andlong are not numbers, or the values fall outside the acceptable latitude and longitude ranges. The valid range for latitude is between -90 and 90, and for longitude, it is between -180 and 180.      - If the bogon or private IP address is provided to query the Time Zone information.      - If the provided time zone name to the query paramter tz is wrong or not registered in the IANA time zone database.  </td><td>  -  </td></tr>
            <tr><td> 401 </td><td> Unauthorized – Possible reasons include:   - Missing or invalid API key   - Account unverified, locked, or disabled   - Accessing API with an unauthorized key   - Subscription expired or downgraded   - If your account has been disabled or locked to use by the admin due to abuse or illegal activity.   - When the request to IP Geolocation API is made using API key for a database subscription   - When the request to IP Geolocation API is made on the &#39;paused&#39; subscription.   - If you’re making API requests after your subscription trial has been expired.   - If your active until date has passed and you need to upgrade your account.  </td><td>  -  </td></tr>
            <tr><td> 404 </td><td> Not Found – Possible reasons include:   - If the IPv4, IPv6, or domain name does not not exists in our database.    - If the IPv4, IPv6, or domain name is passed as a path variable, instead of url parameter as ip&#x3D;.      - If the location address provided to the request paramters location is invalid. City or state level address must be provided.      - If the provided ICAO code to the request paramter icao_code is not in the format as four letter code AAAA.      - If the provided UN/LOCODE, IATA code or ICAO code to the query paramters lo_code, iata_code, or icao_code does not exists in our database.      - If the wrong endpoint is called, that does not exists in our API.  </td><td>  -  </td></tr>
            <tr><td> 405 </td><td> Method Not Allowed – Only GET is allowed for &#x60;/timezone&#x60; endpoint </td><td>  -  </td></tr>
            <tr><td> 429 </td><td> Too Many Requests – Possible reasons include:   - If the API usage limit has reached for the free subscriptions, or paid subscriptions with the status &#39;past due&#39;, &#39;deleted&#39; or &#39;trial expired&#39;.    - If the surcharge API usage limit has reached against the subscribed plan.     </td><td>  -  </td></tr>
            <tr><td> 499 </td><td> Client Closed Request – Client terminated connection before completion </td><td>  -  </td></tr>
            <tr><td> 500 </td><td> Internal Server Error – Something went wrong on our end </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<TimezoneResponse> _callback) throws ApiException {
            return timezoneGetAsync(tz, location, lat, _long, ip, iataCode, icaoCode, loCode, output, lang, _callback);
        }
    }

    /**
     * Timezone information details
     * The Time Zone API provides current time, date, and time zone-related information. It supports various input types including time zone name, geographic coordinates, addresses, IPs, and location codes.  The API determines the time zone based on the following priority order if multiple parameters are provided:   1. Time Zone Name   2. Geographic Coordinates (latitude &amp; longitude)   3. Location Address   4. IP Address   5. IATA Code   6. ICAO Code   7. UN/LOCODE  Enriched response data is returned based on the type of input: - IP: includes geolocation info - Address: includes location metadata - IATA/ICAO: includes airport info - UN/LOCODE: includes city details  You can call the time zone API without passing any time zone, coordinates, IATA, ICAO, LO code or IP address as well. It will use the calling machine&#39;s IP address to return the regional time zone information. 
     * @return APItimezoneGetRequest
     * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Successful response </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Bad Request – Possible reasons include:   - If the provided IPv4, IPv6 address, or domain name is invalid.    - If special character(s) ( ) [ ] { } | ^ &#x60; is passed in the API URL either as paramter or its value. Specially in case of API key.      - If the provided IATA code to the request paramter iata_code is not in the format as three letter code AAA.      - If the provided ICAO code to the request paramter icao_code is not in the format as four letter code AAAA.      - If the provided UN/LOCODE to the request paramter lo_code is not in format as first two characters of country code, followed by the three alphanumeric characters of the city/region.      - If the provided values to the request parameters lat andlong are not numbers, or the values fall outside the acceptable latitude and longitude ranges. The valid range for latitude is between -90 and 90, and for longitude, it is between -180 and 180.      - If the bogon or private IP address is provided to query the Time Zone information.      - If the provided time zone name to the query paramter tz is wrong or not registered in the IANA time zone database.  </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized – Possible reasons include:   - Missing or invalid API key   - Account unverified, locked, or disabled   - Accessing API with an unauthorized key   - Subscription expired or downgraded   - If your account has been disabled or locked to use by the admin due to abuse or illegal activity.   - When the request to IP Geolocation API is made using API key for a database subscription   - When the request to IP Geolocation API is made on the &#39;paused&#39; subscription.   - If you’re making API requests after your subscription trial has been expired.   - If your active until date has passed and you need to upgrade your account.  </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found – Possible reasons include:   - If the IPv4, IPv6, or domain name does not not exists in our database.    - If the IPv4, IPv6, or domain name is passed as a path variable, instead of url parameter as ip&#x3D;.      - If the location address provided to the request paramters location is invalid. City or state level address must be provided.      - If the provided ICAO code to the request paramter icao_code is not in the format as four letter code AAAA.      - If the provided UN/LOCODE, IATA code or ICAO code to the query paramters lo_code, iata_code, or icao_code does not exists in our database.      - If the wrong endpoint is called, that does not exists in our API.  </td><td>  -  </td></tr>
        <tr><td> 405 </td><td> Method Not Allowed – Only GET is allowed for &#x60;/timezone&#x60; endpoint </td><td>  -  </td></tr>
        <tr><td> 429 </td><td> Too Many Requests – Possible reasons include:   - If the API usage limit has reached for the free subscriptions, or paid subscriptions with the status &#39;past due&#39;, &#39;deleted&#39; or &#39;trial expired&#39;.    - If the surcharge API usage limit has reached against the subscribed plan.     </td><td>  -  </td></tr>
        <tr><td> 499 </td><td> Client Closed Request – Client terminated connection before completion </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> Internal Server Error – Something went wrong on our end </td><td>  -  </td></tr>
     </table>
     */
    public APItimezoneGetRequest getTimezone() {
        return new APItimezoneGetRequest();
    }
}
