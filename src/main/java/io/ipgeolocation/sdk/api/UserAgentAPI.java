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


import io.ipgeolocation.sdk.model.UserAgentBulkRequest;
import io.ipgeolocation.sdk.model.UserAgentData;
import io.ipgeolocation.sdk.model.UserAgentRequest;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserAgentAPI {
    private ApiClient localVarApiClient;
    private int localHostIndex;
    private String localCustomBaseUrl;

    public UserAgentAPI() {
        this(Configuration.getDefaultApiClient());
    }

    public UserAgentAPI(ApiClient apiClient) {
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

    private okhttp3.Call userAgentBulkPostCall(@javax.annotation.Nullable UserAgentBulkRequest userAgentBulkRequest, final ApiCallback _callback) throws ApiException {
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

        Object localVarPostBody = userAgentBulkRequest;

        // create path and map variables
        String localVarPath = "/user-agent-bulk";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();


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
    private okhttp3.Call userAgentBulkPostValidateBeforeCall(@javax.annotation.Nullable UserAgentBulkRequest userAgentBulkRequest, final ApiCallback _callback) throws ApiException {
        return userAgentBulkPostCall(userAgentBulkRequest, _callback);

    }


    private ApiResponse<List<UserAgentData>> userAgentBulkPostWithHttpInfo(@javax.annotation.Nullable UserAgentBulkRequest userAgentBulkRequest) throws ApiException {
        okhttp3.Call localVarCall = userAgentBulkPostValidateBeforeCall(userAgentBulkRequest, null);
        Type localVarReturnType = new TypeToken<List<UserAgentData>>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call userAgentBulkPostAsync(@javax.annotation.Nullable UserAgentBulkRequest userAgentBulkRequest, final ApiCallback<List<UserAgentData>> _callback) throws ApiException {

        okhttp3.Call localVarCall = userAgentBulkPostValidateBeforeCall(userAgentBulkRequest, _callback);
        Type localVarReturnType = new TypeToken<List<UserAgentData>>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class APIuserAgentBulkPostRequest {
        @javax.annotation.Nullable
        private UserAgentBulkRequest userAgentBulkRequest;

        private APIuserAgentBulkPostRequest() {
        }

        /**
         * Set userAgentBulkPostRequest
         * @param userAgentBulkRequest  (optional)
         * @return APIuserAgentBulkPostRequest
         */
        public APIuserAgentBulkPostRequest userAgentBulkRequest(@javax.annotation.Nullable UserAgentBulkRequest userAgentBulkRequest) {
            this.userAgentBulkRequest = userAgentBulkRequest;
            return this;
        }

        /**
         * Build call for userAgentBulkPost
         * @param _callback ApiCallback API callback
         * @return Call to execute
         * @throws ApiException If fail to serialize the request body object
         * @http.response.details
         <table border="1">
       <caption>Response Details</caption>
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> Success </td><td>  -  </td></tr>
            <tr><td> 400 </td><td> Bad Request – Possible reasons include:   - If the user-agent string is empty/null.   - If the User Agent Strings JSON list is empty, or the provided JSON does not have &#39;uaStrings&#39; field while querying /user-agent-bulk endpoint.   - If more than 50,000 user agent strings are provided while quering from /user-agent-bulk endpoint.  </td><td>  -  </td></tr>
            <tr><td> 401 </td><td> Unauthorized – Possible reasons include:   - If API key (as apiKey URL parameter) is missing from the request to User Agent API.    - If the provided API key is not valid.   - If your account has been disabled or locked by admin because of any illegal activity.   - If you’re making requests after your subscription trial has been expired.   - If you’ve exceeded your requests limit.   - If your subscription is paused or is not active.   - If you’re accessing a paid feature on free subscription.   - If bulk user agent parsing endpoint is called using free subscription API key.  </td><td>  -  </td></tr>
            <tr><td> 405 </td><td> If wrong HTTP request method is used for calling the endpoints. Only POST method is allowed. </td><td>  -  </td></tr>
            <tr><td> 429 </td><td> Too Many Requests – API usage limits exceeded for current plan </td><td>  -  </td></tr>
            <tr><td> 499 </td><td> Client Closed Request – Client terminated connection before completion </td><td>  -  </td></tr>
            <tr><td> 500 </td><td> Internal Server Error – Something went wrong on our end </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call buildCall(final ApiCallback _callback) throws ApiException {
            return userAgentBulkPostCall(userAgentBulkRequest, _callback);
        }

        /**
         * Execute userAgentBulkPost request
         * @return List&lt;UserAgentData&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table border="1">
       <caption>Response Details</caption>
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> Success </td><td>  -  </td></tr>
            <tr><td> 400 </td><td> Bad Request – Possible reasons include:   - If the user-agent string is empty/null.   - If the User Agent Strings JSON list is empty, or the provided JSON does not have &#39;uaStrings&#39; field while querying /user-agent-bulk endpoint.   - If more than 50,000 user agent strings are provided while quering from /user-agent-bulk endpoint.  </td><td>  -  </td></tr>
            <tr><td> 401 </td><td> Unauthorized – Possible reasons include:   - If API key (as apiKey URL parameter) is missing from the request to User Agent API.    - If the provided API key is not valid.   - If your account has been disabled or locked by admin because of any illegal activity.   - If you’re making requests after your subscription trial has been expired.   - If you’ve exceeded your requests limit.   - If your subscription is paused or is not active.   - If you’re accessing a paid feature on free subscription.   - If bulk user agent parsing endpoint is called using free subscription API key.  </td><td>  -  </td></tr>
            <tr><td> 405 </td><td> If wrong HTTP request method is used for calling the endpoints. Only POST method is allowed. </td><td>  -  </td></tr>
            <tr><td> 429 </td><td> Too Many Requests – API usage limits exceeded for current plan </td><td>  -  </td></tr>
            <tr><td> 499 </td><td> Client Closed Request – Client terminated connection before completion </td><td>  -  </td></tr>
            <tr><td> 500 </td><td> Internal Server Error – Something went wrong on our end </td><td>  -  </td></tr>
         </table>
         */
        public List<UserAgentData> execute() throws ApiException {
            ApiResponse<List<UserAgentData>> localVarResp = userAgentBulkPostWithHttpInfo(userAgentBulkRequest);
            return localVarResp.getData();
        }

        /**
         * Execute userAgentBulkPost request with HTTP info returned
         * @return ApiResponse&lt;List&lt;UserAgentData&gt;&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table border="1">
       <caption>Response Details</caption>
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> Success </td><td>  -  </td></tr>
            <tr><td> 400 </td><td> Bad Request – Possible reasons include:   - If the user-agent string is empty/null.   - If the User Agent Strings JSON list is empty, or the provided JSON does not have &#39;uaStrings&#39; field while querying /user-agent-bulk endpoint.   - If more than 50,000 user agent strings are provided while quering from /user-agent-bulk endpoint.  </td><td>  -  </td></tr>
            <tr><td> 401 </td><td> Unauthorized – Possible reasons include:   - If API key (as apiKey URL parameter) is missing from the request to User Agent API.    - If the provided API key is not valid.   - If your account has been disabled or locked by admin because of any illegal activity.   - If you’re making requests after your subscription trial has been expired.   - If you’ve exceeded your requests limit.   - If your subscription is paused or is not active.   - If you’re accessing a paid feature on free subscription.   - If bulk user agent parsing endpoint is called using free subscription API key.  </td><td>  -  </td></tr>
            <tr><td> 405 </td><td> If wrong HTTP request method is used for calling the endpoints. Only POST method is allowed. </td><td>  -  </td></tr>
            <tr><td> 429 </td><td> Too Many Requests – API usage limits exceeded for current plan </td><td>  -  </td></tr>
            <tr><td> 499 </td><td> Client Closed Request – Client terminated connection before completion </td><td>  -  </td></tr>
            <tr><td> 500 </td><td> Internal Server Error – Something went wrong on our end </td><td>  -  </td></tr>
         </table>
         */
        public ApiResponse<List<UserAgentData>> executeWithHttpInfo() throws ApiException {
            return userAgentBulkPostWithHttpInfo(userAgentBulkRequest);
        }

        /**
         * Execute userAgentBulkPost request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table border="1">
       <caption>Response Details</caption>
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> Success </td><td>  -  </td></tr>
            <tr><td> 400 </td><td> Bad Request – Possible reasons include:   - If the user-agent string is empty/null.   - If the User Agent Strings JSON list is empty, or the provided JSON does not have &#39;uaStrings&#39; field while querying /user-agent-bulk endpoint.   - If more than 50,000 user agent strings are provided while quering from /user-agent-bulk endpoint.  </td><td>  -  </td></tr>
            <tr><td> 401 </td><td> Unauthorized – Possible reasons include:   - If API key (as apiKey URL parameter) is missing from the request to User Agent API.    - If the provided API key is not valid.   - If your account has been disabled or locked by admin because of any illegal activity.   - If you’re making requests after your subscription trial has been expired.   - If you’ve exceeded your requests limit.   - If your subscription is paused or is not active.   - If you’re accessing a paid feature on free subscription.   - If bulk user agent parsing endpoint is called using free subscription API key.  </td><td>  -  </td></tr>
            <tr><td> 405 </td><td> If wrong HTTP request method is used for calling the endpoints. Only POST method is allowed. </td><td>  -  </td></tr>
            <tr><td> 429 </td><td> Too Many Requests – API usage limits exceeded for current plan </td><td>  -  </td></tr>
            <tr><td> 499 </td><td> Client Closed Request – Client terminated connection before completion </td><td>  -  </td></tr>
            <tr><td> 500 </td><td> Internal Server Error – Something went wrong on our end </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<List<UserAgentData>> _callback) throws ApiException {
            return userAgentBulkPostAsync(userAgentBulkRequest, _callback);
        }
    }

    /**
     * Handle multiple user-agent string lookups
     * This endpoint allows you to perform the parsing of multiple User-Angent strings (max. 50,000) at the same time. The requests count per round is equal to total User-Agent strings passed. This feature is &#x60;only available for paid plans&#x60;.
     * @return APIuserAgentBulkPostRequest
     * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Success </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Bad Request – Possible reasons include:   - If the user-agent string is empty/null.   - If the User Agent Strings JSON list is empty, or the provided JSON does not have &#39;uaStrings&#39; field while querying /user-agent-bulk endpoint.   - If more than 50,000 user agent strings are provided while quering from /user-agent-bulk endpoint.  </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized – Possible reasons include:   - If API key (as apiKey URL parameter) is missing from the request to User Agent API.    - If the provided API key is not valid.   - If your account has been disabled or locked by admin because of any illegal activity.   - If you’re making requests after your subscription trial has been expired.   - If you’ve exceeded your requests limit.   - If your subscription is paused or is not active.   - If you’re accessing a paid feature on free subscription.   - If bulk user agent parsing endpoint is called using free subscription API key.  </td><td>  -  </td></tr>
        <tr><td> 405 </td><td> If wrong HTTP request method is used for calling the endpoints. Only POST method is allowed. </td><td>  -  </td></tr>
        <tr><td> 429 </td><td> Too Many Requests – API usage limits exceeded for current plan </td><td>  -  </td></tr>
        <tr><td> 499 </td><td> Client Closed Request – Client terminated connection before completion </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> Internal Server Error – Something went wrong on our end </td><td>  -  </td></tr>
     </table>
     */
    public APIuserAgentBulkPostRequest getBulkUserAgent() {
        return new APIuserAgentBulkPostRequest();
    }
    private okhttp3.Call userAgentGetCall(@javax.annotation.Nullable String userAgent, final ApiCallback _callback) throws ApiException {
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
        String localVarPath = "/user-agent";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();


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

        if (userAgent != null) {
            localVarHeaderParams.put("User-Agent", localVarApiClient.parameterToString(userAgent));
        }


        String[] localVarAuthNames = new String[] { "ApiKeyAuth" };
        return localVarApiClient.buildCall(basePath, localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call userAgentGetValidateBeforeCall(@javax.annotation.Nullable String userAgent, final ApiCallback _callback) throws ApiException {
        return userAgentGetCall(userAgent, _callback);

    }


    private ApiResponse<UserAgentData> userAgentGetWithHttpInfo(@javax.annotation.Nullable String userAgent) throws ApiException {
        okhttp3.Call localVarCall = userAgentGetValidateBeforeCall(userAgent, null);
        Type localVarReturnType = new TypeToken<UserAgentData>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call userAgentGetAsync(@javax.annotation.Nullable String userAgent, final ApiCallback<UserAgentData> _callback) throws ApiException {

        okhttp3.Call localVarCall = userAgentGetValidateBeforeCall(userAgent, _callback);
        Type localVarReturnType = new TypeToken<UserAgentData>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class APIuserAgentGetRequest {
        @javax.annotation.Nullable
        private String userAgent;

        private APIuserAgentGetRequest() {
        }

        /**
         * Set userAgent
         * @param userAgent  (optional)
         * @return APIuserAgentGetRequest
         */
        public APIuserAgentGetRequest userAgentString(@javax.annotation.Nullable String userAgent) {
            this.userAgent = userAgent;
            return this;
        }

        /**
         * Build call for userAgentGet
         * @param _callback ApiCallback API callback
         * @return Call to execute
         * @throws ApiException If fail to serialize the request body object
         * @http.response.details
         <table border="1">
       <caption>Response Details</caption>
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> successful response </td><td>  -  </td></tr>
            <tr><td> 400 </td><td> Bad Request – Possible reasons include:   - If the user-agent string is empty/null.  </td><td>  -  </td></tr>
            <tr><td> 401 </td><td> Unauthorized – Possible reasons include:   - If API key (as apiKey URL parameter) is missing from the request to User Agent API.    - If the provided API key is not valid.   - If your account has been disabled or locked by admin because of any illegal activity.   - If you’re making requests after your subscription trial has been expired.   - If you’ve exceeded your requests limit.   - If your subscription is paused or is not active.   - If you’re accessing a paid feature on free subscription.  </td><td>  -  </td></tr>
            <tr><td> 405 </td><td> If wrong HTTP request method is used for calling the endpoints. Only GET and POST methods are allowed. </td><td>  -  </td></tr>
            <tr><td> 429 </td><td> Too Many Requests – API usage limits exceeded for current plan </td><td>  -  </td></tr>
            <tr><td> 499 </td><td> Client Closed Request – Client terminated connection before completion </td><td>  -  </td></tr>
            <tr><td> 500 </td><td> Internal Server Error – Something went wrong on our end </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call buildCall(final ApiCallback _callback) throws ApiException {
            return userAgentGetCall(userAgent, _callback);
        }

        /**
         * Execute userAgentGet request
         * @return UserAgentData
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table border="1">
       <caption>Response Details</caption>
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> successful response </td><td>  -  </td></tr>
            <tr><td> 400 </td><td> Bad Request – Possible reasons include:   - If the user-agent string is empty/null.  </td><td>  -  </td></tr>
            <tr><td> 401 </td><td> Unauthorized – Possible reasons include:   - If API key (as apiKey URL parameter) is missing from the request to User Agent API.    - If the provided API key is not valid.   - If your account has been disabled or locked by admin because of any illegal activity.   - If you’re making requests after your subscription trial has been expired.   - If you’ve exceeded your requests limit.   - If your subscription is paused or is not active.   - If you’re accessing a paid feature on free subscription.  </td><td>  -  </td></tr>
            <tr><td> 405 </td><td> If wrong HTTP request method is used for calling the endpoints. Only GET and POST methods are allowed. </td><td>  -  </td></tr>
            <tr><td> 429 </td><td> Too Many Requests – API usage limits exceeded for current plan </td><td>  -  </td></tr>
            <tr><td> 499 </td><td> Client Closed Request – Client terminated connection before completion </td><td>  -  </td></tr>
            <tr><td> 500 </td><td> Internal Server Error – Something went wrong on our end </td><td>  -  </td></tr>
         </table>
         */
        public UserAgentData execute() throws ApiException {
            ApiResponse<UserAgentData> localVarResp = userAgentGetWithHttpInfo(userAgent);
            return localVarResp.getData();
        }

        /**
         * Execute userAgentGet request with HTTP info returned
         * @return ApiResponse&lt;UserAgentData&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table border="1">
       <caption>Response Details</caption>
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> successful response </td><td>  -  </td></tr>
            <tr><td> 400 </td><td> Bad Request – Possible reasons include:   - If the user-agent string is empty/null.  </td><td>  -  </td></tr>
            <tr><td> 401 </td><td> Unauthorized – Possible reasons include:   - If API key (as apiKey URL parameter) is missing from the request to User Agent API.    - If the provided API key is not valid.   - If your account has been disabled or locked by admin because of any illegal activity.   - If you’re making requests after your subscription trial has been expired.   - If you’ve exceeded your requests limit.   - If your subscription is paused or is not active.   - If you’re accessing a paid feature on free subscription.  </td><td>  -  </td></tr>
            <tr><td> 405 </td><td> If wrong HTTP request method is used for calling the endpoints. Only GET and POST methods are allowed. </td><td>  -  </td></tr>
            <tr><td> 429 </td><td> Too Many Requests – API usage limits exceeded for current plan </td><td>  -  </td></tr>
            <tr><td> 499 </td><td> Client Closed Request – Client terminated connection before completion </td><td>  -  </td></tr>
            <tr><td> 500 </td><td> Internal Server Error – Something went wrong on our end </td><td>  -  </td></tr>
         </table>
         */
        public ApiResponse<UserAgentData> executeWithHttpInfo() throws ApiException {
            return userAgentGetWithHttpInfo(userAgent);
        }

        /**
         * Execute userAgentGet request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table border="1">
       <caption>Response Details</caption>
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> successful response </td><td>  -  </td></tr>
            <tr><td> 400 </td><td> Bad Request – Possible reasons include:   - If the user-agent string is empty/null.  </td><td>  -  </td></tr>
            <tr><td> 401 </td><td> Unauthorized – Possible reasons include:   - If API key (as apiKey URL parameter) is missing from the request to User Agent API.    - If the provided API key is not valid.   - If your account has been disabled or locked by admin because of any illegal activity.   - If you’re making requests after your subscription trial has been expired.   - If you’ve exceeded your requests limit.   - If your subscription is paused or is not active.   - If you’re accessing a paid feature on free subscription.  </td><td>  -  </td></tr>
            <tr><td> 405 </td><td> If wrong HTTP request method is used for calling the endpoints. Only GET and POST methods are allowed. </td><td>  -  </td></tr>
            <tr><td> 429 </td><td> Too Many Requests – API usage limits exceeded for current plan </td><td>  -  </td></tr>
            <tr><td> 499 </td><td> Client Closed Request – Client terminated connection before completion </td><td>  -  </td></tr>
            <tr><td> 500 </td><td> Internal Server Error – Something went wrong on our end </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<UserAgentData> _callback) throws ApiException {
            return userAgentGetAsync(userAgent, _callback);
        }
    }

    /**
     * Get details of user-agent
     * User Agent Parser API provides the accurate browser, device, and operating system details from a User Agent String. It also provides information about crawlers and attack sources. You can use these details to customize user experience, prevent crawlers and attackers from accessing your website. 
     * @return APIuserAgentGetRequest
     * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> successful response </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Bad Request – Possible reasons include:   - If the user-agent string is empty/null.  </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized – Possible reasons include:   - If API key (as apiKey URL parameter) is missing from the request to User Agent API.    - If the provided API key is not valid.   - If your account has been disabled or locked by admin because of any illegal activity.   - If you’re making requests after your subscription trial has been expired.   - If you’ve exceeded your requests limit.   - If your subscription is paused or is not active.   - If you’re accessing a paid feature on free subscription.  </td><td>  -  </td></tr>
        <tr><td> 405 </td><td> If wrong HTTP request method is used for calling the endpoints. Only GET and POST methods are allowed. </td><td>  -  </td></tr>
        <tr><td> 429 </td><td> Too Many Requests – API usage limits exceeded for current plan </td><td>  -  </td></tr>
        <tr><td> 499 </td><td> Client Closed Request – Client terminated connection before completion </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> Internal Server Error – Something went wrong on our end </td><td>  -  </td></tr>
     </table>
     */
    public APIuserAgentGetRequest getUserAgent() {
        return new APIuserAgentGetRequest();
    }
    private okhttp3.Call userAgentPostCall(@javax.annotation.Nullable UserAgentRequest userAgentRequest, final ApiCallback _callback) throws ApiException {
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

        Object localVarPostBody = userAgentRequest;

        // create path and map variables
        String localVarPath = "/user-agent";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

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
    private okhttp3.Call userAgentPostValidateBeforeCall(@javax.annotation.Nullable UserAgentRequest userAgentRequest, final ApiCallback _callback) throws ApiException {
        return userAgentPostCall(userAgentRequest, _callback);

    }


    private ApiResponse<UserAgentData> userAgentPostWithHttpInfo( @javax.annotation.Nullable UserAgentRequest userAgentRequest) throws ApiException {
        okhttp3.Call localVarCall = userAgentPostValidateBeforeCall(userAgentRequest, null);
        Type localVarReturnType = new TypeToken<UserAgentData>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call userAgentPostAsync( @javax.annotation.Nullable UserAgentRequest userAgentRequest, final ApiCallback<UserAgentData> _callback) throws ApiException {

        okhttp3.Call localVarCall = userAgentPostValidateBeforeCall(userAgentRequest, _callback);
        Type localVarReturnType = new TypeToken<UserAgentData>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class APIuserAgentPostRequest {
        @javax.annotation.Nullable
        private UserAgentRequest userAgentRequest;

        private APIuserAgentPostRequest() {
        }

        /**
         * Set userAgentPostRequest
         * @param userAgentRequest  (optional)
         * @return APIuserAgentPostRequest
         */
        public APIuserAgentPostRequest userAgentRequest(@javax.annotation.Nullable UserAgentRequest userAgentRequest) {
            this.userAgentRequest = userAgentRequest;
            return this;
        }

        /**
         * Build call for userAgentPost
         * @param _callback ApiCallback API callback
         * @return Call to execute
         * @throws ApiException If fail to serialize the request body object
         * @http.response.details
         <table border="1">
       <caption>Response Details</caption>
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> Successful request </td><td>  -  </td></tr>
            <tr><td> 400 </td><td> Bad Request – Possible reasons include:   - If the user-agent string is empty/null.  </td><td>  -  </td></tr>
            <tr><td> 401 </td><td> Unauthorized – Possible reasons include:   - If API key (as apiKey URL parameter) is missing from the request to User Agent API.    - If the provided API key is not valid.   - If your account has been disabled or locked by admin because of any illegal activity.   - If you’re making requests after your subscription trial has been expired.   - If you’ve exceeded your requests limit.   - If your subscription is paused or is not active.   - If you’re accessing a paid feature on free subscription.  </td><td>  -  </td></tr>
            <tr><td> 405 </td><td> If wrong HTTP request method is used for calling the endpoints. Only POST Method is acceptable for this endpoint </td><td>  -  </td></tr>
            <tr><td> 429 </td><td> Too Many Requests – API usage limits exceeded for current plan </td><td>  -  </td></tr>
            <tr><td> 499 </td><td> Client Closed Request – Client terminated connection before completion </td><td>  -  </td></tr>
            <tr><td> 500 </td><td> Internal Server Error – Something went wrong on our end </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call buildCall(final ApiCallback _callback) throws ApiException {
            return userAgentPostCall(userAgentRequest, _callback);
        }

        /**
         * Execute userAgentPost request
         * @return UserAgentData
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table border="1">
       <caption>Response Details</caption>
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> Successful request </td><td>  -  </td></tr>
            <tr><td> 400 </td><td> Bad Request – Possible reasons include:   - If the user-agent string is empty/null.  </td><td>  -  </td></tr>
            <tr><td> 401 </td><td> Unauthorized – Possible reasons include:   - If API key (as apiKey URL parameter) is missing from the request to User Agent API.    - If the provided API key is not valid.   - If your account has been disabled or locked by admin because of any illegal activity.   - If you’re making requests after your subscription trial has been expired.   - If you’ve exceeded your requests limit.   - If your subscription is paused or is not active.   - If you’re accessing a paid feature on free subscription.  </td><td>  -  </td></tr>
            <tr><td> 405 </td><td> If wrong HTTP request method is used for calling the endpoints. Only POST Method is acceptable for this endpoint </td><td>  -  </td></tr>
            <tr><td> 429 </td><td> Too Many Requests – API usage limits exceeded for current plan </td><td>  -  </td></tr>
            <tr><td> 499 </td><td> Client Closed Request – Client terminated connection before completion </td><td>  -  </td></tr>
            <tr><td> 500 </td><td> Internal Server Error – Something went wrong on our end </td><td>  -  </td></tr>
         </table>
         */
        public UserAgentData execute() throws ApiException {
            ApiResponse<UserAgentData> localVarResp = userAgentPostWithHttpInfo( userAgentRequest);
            return localVarResp.getData();
        }

        /**
         * Execute userAgentPost request with HTTP info returned
         * @return ApiResponse&lt;UserAgentData&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table border="1">
       <caption>Response Details</caption>
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> Successful request </td><td>  -  </td></tr>
            <tr><td> 400 </td><td> Bad Request – Possible reasons include:   - If the user-agent string is empty/null.  </td><td>  -  </td></tr>
            <tr><td> 401 </td><td> Unauthorized – Possible reasons include:   - If API key (as apiKey URL parameter) is missing from the request to User Agent API.    - If the provided API key is not valid.   - If your account has been disabled or locked by admin because of any illegal activity.   - If you’re making requests after your subscription trial has been expired.   - If you’ve exceeded your requests limit.   - If your subscription is paused or is not active.   - If you’re accessing a paid feature on free subscription.  </td><td>  -  </td></tr>
            <tr><td> 405 </td><td> If wrong HTTP request method is used for calling the endpoints. Only POST Method is acceptable for this endpoint </td><td>  -  </td></tr>
            <tr><td> 429 </td><td> Too Many Requests – API usage limits exceeded for current plan </td><td>  -  </td></tr>
            <tr><td> 499 </td><td> Client Closed Request – Client terminated connection before completion </td><td>  -  </td></tr>
            <tr><td> 500 </td><td> Internal Server Error – Something went wrong on our end </td><td>  -  </td></tr>
         </table>
         */
        public ApiResponse<UserAgentData> executeWithHttpInfo() throws ApiException {
            return userAgentPostWithHttpInfo(userAgentRequest);
        }

        /**
         * Execute userAgentPost request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table border="1">
       <caption>Response Details</caption>
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> Successful request </td><td>  -  </td></tr>
            <tr><td> 400 </td><td> Bad Request – Possible reasons include:   - If the user-agent string is empty/null.  </td><td>  -  </td></tr>
            <tr><td> 401 </td><td> Unauthorized – Possible reasons include:   - If API key (as apiKey URL parameter) is missing from the request to User Agent API.    - If the provided API key is not valid.   - If your account has been disabled or locked by admin because of any illegal activity.   - If you’re making requests after your subscription trial has been expired.   - If you’ve exceeded your requests limit.   - If your subscription is paused or is not active.   - If you’re accessing a paid feature on free subscription.  </td><td>  -  </td></tr>
            <tr><td> 405 </td><td> If wrong HTTP request method is used for calling the endpoints. Only POST Method is acceptable for this endpoint </td><td>  -  </td></tr>
            <tr><td> 429 </td><td> Too Many Requests – API usage limits exceeded for current plan </td><td>  -  </td></tr>
            <tr><td> 499 </td><td> Client Closed Request – Client terminated connection before completion </td><td>  -  </td></tr>
            <tr><td> 500 </td><td> Internal Server Error – Something went wrong on our end </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<UserAgentData> _callback) throws ApiException {
            return userAgentPostAsync( userAgentRequest, _callback);
        }
    }

    /**
     * Handle single User-Agent string
     * You can also provide custom User-Agent string to parse in JSON payload. This endpoint is meant to be called from server-side and is available for paid subscriptions only.
     * @return APIuserAgentPostRequest
     * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Successful request </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Bad Request – Possible reasons include:   - If the user-agent string is empty/null.  </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized – Possible reasons include:   - If API key (as apiKey URL parameter) is missing from the request to User Agent API.    - If the provided API key is not valid.   - If your account has been disabled or locked by admin because of any illegal activity.   - If you’re making requests after your subscription trial has been expired.   - If you’ve exceeded your requests limit.   - If your subscription is paused or is not active.   - If you’re accessing a paid feature on free subscription.  </td><td>  -  </td></tr>
        <tr><td> 405 </td><td> If wrong HTTP request method is used for calling the endpoints. Only POST Method is acceptable for this endpoint </td><td>  -  </td></tr>
        <tr><td> 429 </td><td> Too Many Requests – API usage limits exceeded for current plan </td><td>  -  </td></tr>
        <tr><td> 499 </td><td> Client Closed Request – Client terminated connection before completion </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> Internal Server Error – Something went wrong on our end </td><td>  -  </td></tr>
     </table>
     */
    public APIuserAgentPostRequest getUserAgentOfCustomString() {
        return new APIuserAgentPostRequest();
    }
}
