/*
 * IPGeolocation.io - IP intelligence products
 * Ipgeolocation provides a set of APIs to make ip based decisions.
 */


package io.ipgeolocation.sdk.api;

import io.ipgeolocation.sdk.invoker.ApiClient;
import io.ipgeolocation.sdk.invoker.ApiException;
import io.ipgeolocation.sdk.invoker.Configuration;
import io.ipgeolocation.sdk.invoker.auth.ApiKeyAuth;
import io.ipgeolocation.sdk.model.UserAgentBulkRequest;
import io.ipgeolocation.sdk.model.UserAgentData;
import io.ipgeolocation.sdk.model.UserAgentRequest;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * API tests for UserAgentApi
 */
@Disabled
public class UserAgentAPITest {

    private final UserAgentAPI api = new UserAgentAPI();

    /**
     * Handle multiple user-agent string lookups
     *
     * This endpoint allows you to perform the parsing of multiple User-Angent strings (max. 50,000) at the same time. The requests count per round is equal to total User-Agent strings passed. This feature is &#x60;only available for paid plans&#x60;.
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void getBulkUserAgentTest() throws ApiException {
        UserAgentBulkRequest userAgentBulkRequest = null;
        List<UserAgentData> response = api.getBulkUserAgent()
                .userAgentBulkRequest(userAgentBulkRequest)
                .execute();
        System.out.println(response);
    }

    /**
     * Get details of user-agent
     *
     * User Agent Parser API provides the accurate browser, device, and operating system details from a User Agent String. It also provides information about crawlers and attack sources. You can use these details to customize user experience, prevent crawlers and attackers from accessing your website. 
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void getUserAgentTest() throws ApiException {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://api.ipgeolocation.io/v2");

        // Configure API key authorization: ApiKeyAuth
        ApiKeyAuth ApiKeyAuth = (ApiKeyAuth) defaultClient.getAuthentication("ApiKeyAuth");
        ApiKeyAuth.setApiKey("API_KEY");

        String userAgentString = null;
        UserAgentData response = api.getUserAgent()
                .userAgentString(userAgentString)
                .execute();
        System.out.println(response);
    }

    /**
     * Handle single User-Agent string
     *
     * You can also provide custom User-Agent string to parse in JSON payload. This endpoint is meant to be called from server-side and is available for paid subscriptions only.
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void getUserAgentOfCustomStringTest() throws ApiException {
        UserAgentRequest userAgentRequest = null;
        UserAgentData response = api.getUserAgentOfCustomString()
                .userAgentRequest(userAgentRequest)
                .execute();
        System.out.println(response);
    }

}
