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
import io.ipgeolocation.sdk.model.GeolocationResponse;
import io.ipgeolocation.sdk.model.BulkGeolocationResponse;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * API tests for IpLocationApi
 */
@Disabled
public class IPGeolocationAPITest {

    private final IPGeolocationAPI api = new IPGeolocationAPI();

    /**
     * This feature is available only on our paid API subscriptions (STANDARD or ADVANCED). This endpoint allows you to perform the geolocation lookup for multiple IPv4, IPv6 addresses or domain names (maximum 50,000) at the same time. The requests count per lookup is equal to total IP addresses or domain names passed. To perform bulk IP Geolocation Lookup, send a POST request and pass the \&quot;ips\&quot; array as JSON data along with it.  
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void getBulkIPGeolocationTest() throws ApiException {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://api.ipgeolocation.io/v2");

        // Configure API key authorization: ApiKeyAuth
        ApiKeyAuth ApiKeyAuth = (ApiKeyAuth) defaultClient.getAuthentication("ApiKeyAuth");
        ApiKeyAuth.setApiKey("API_KEY");

        BulkIPRequest bulkIPRequest = new BulkIPRequest();
        bulkIPRequest.addIP("1.1.1.1");
        bulkIPRequest.addIP("8.8.8.8");
        String lang = null;
        String fields = null;
        String excludes = null;
        String include = null;
        List<BulkGeolocationResponse> response = api.getBulkIPGeolocation(bulkIPRequest)
                .fields(fields)
                .lang(lang)
                .excludes(excludes)
                .include(include)
                .execute();
        System.out.println(response);
    }

    /**
     * IP Geolocation API provides real-time and accurate geolocation, network, abuse, and security information for any IPv4 or IPv6 address and domain name along with the user-agent detail for the provided user-agent string. You can geolocate your online visitors and provide them the customized user-experience accordingly.
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void getIPGeolocationTest() throws ApiException {
        String ip = null;
        String lang = null;
        String fields = null;
        String excludes = null;
        String include = null;
        String output = null;
        GeolocationResponse response = api.getIPGeolocation()
                .ip(ip)
                .lang(lang)
                .fields(fields)
                .excludes(excludes)
                .include(include)
                .output(output)
                .execute();
        System.out.println(response);
    }

}
