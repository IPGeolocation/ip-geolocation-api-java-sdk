/*
 * IPGeolocation.io - IP intelligence products
 * Ipgeolocation provides a set of APIs to make ip based decisions.
 */


package io.ipgeolocation.sdk.api;

import io.ipgeolocation.sdk.invoker.ApiClient;
import io.ipgeolocation.sdk.invoker.ApiException;
import io.ipgeolocation.sdk.invoker.Configuration;
import io.ipgeolocation.sdk.invoker.auth.ApiKeyAuth;
import io.ipgeolocation.sdk.model.BulkIPRequest;
import io.ipgeolocation.sdk.model.SecurityAPIResponse;
import io.ipgeolocation.sdk.model.BulkSecurityResponse;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * API tests for SecurityApi
 */
@Disabled
public class IPSecurityAPITest {

    private final IPSecurityAPI api = new IPSecurityAPI();

    /**
     * The Bulk IP Security Lookup API can provide security details for up to &#x60;50,000&#x60; bulk IPs. This API also has parameters to customize the response, just like the single IP Security Lookup API.
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void getBulkIPSecurityTest() throws ApiException {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://api.ipgeolocation.io/v2");

        // Configure API key authorization: ApiKeyAuth
        ApiKeyAuth ApiKeyAuth = (ApiKeyAuth) defaultClient.getAuthentication("ApiKeyAuth");
        ApiKeyAuth.setApiKey("API_KEY");

        BulkIPRequest bulkIPRequest = new BulkIPRequest();
        bulkIPRequest.addIP("2.56.188.34");
        bulkIPRequest.addIP("2.56.188.35");
        String include = null;
        String fields = null;
        String excludes = null;
        String output = null;
        String lang = null;
        List<BulkSecurityResponse> response = api.getBulkIPSecurity(bulkIPRequest)
                .include(include)
                .fields(fields)
                .excludes(excludes)
                .output(output)
                .lang(lang)
                .execute();
        System.out.println(response);
    }

    /**
     * IP Security API provides security details of a given IP. It detects whether the IP is proxy, tor or bot. It also shows the proxy types of the IP (like VPN, PROXY, RELAY etc.) with it&#39;s VPN/proxy service provider making our API powerful VPN checker. It finds the IPs that are involved in spam activities. It also checks whether the IP links to a cloud provider and includes the provider&#39;s name.
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void getIPSecurityTest() throws ApiException {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://api.ipgeolocation.io/v2");

        // Configure API key authorization: ApiKeyAuth
        ApiKeyAuth ApiKeyAuth = (ApiKeyAuth) defaultClient.getAuthentication("ApiKeyAuth");
        ApiKeyAuth.setApiKey("API_KEY");

        String ip = null;
        String include = null;
        String fields = null;
        String excludes = null;
        String output = null;
        String lang = null;
        SecurityAPIResponse response = api.getIPSecurity()
                .ip(ip)
                .include(include)
                .fields(fields)
                .excludes(excludes)
                .output(output)
                .lang(lang)
                .execute();
        System.out.println(response);
    }

}
