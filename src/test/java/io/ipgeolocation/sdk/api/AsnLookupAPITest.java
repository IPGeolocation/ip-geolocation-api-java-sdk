/*
 * IPGeolocation.io - IP intelligence products
 * Ipgeolocation provides a set of APIs to make ip based decisions.
 */


package io.ipgeolocation.sdk.api;

import io.ipgeolocation.sdk.invoker.ApiClient;
import io.ipgeolocation.sdk.invoker.ApiException;
import io.ipgeolocation.sdk.invoker.Configuration;
import io.ipgeolocation.sdk.invoker.auth.ApiKeyAuth;
import io.ipgeolocation.sdk.model.ASNResponse;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

/**
 * API tests for AsnLookupApi
 */
@Disabled
public class AsnLookupAPITest {

    private final AsnLookupAPI api = new AsnLookupAPI();

    /**
     * ASN API provides comprehensive details for an ASN including the as name,  organization name, the country of registration, associated domain, and its  type (ISP, host provider, or business). The API also shows the allocation  date of provided ASN and if it is currently allocated or not. It also contains  the routing information including peering, upstreams, and downstreams to help  understand the relationship between different ASNs.  Example Use Cases:  - Looking up ASN information for an IP address (e.g., &#x60;GET /asn?ip&#x3D;8.8.8.8&#x60;)  - Retrieving ASN information for a specific ASN number (e.g., &#x60;GET /asn?asn&#x3D;12345&#x60;)  - Getting peering relationships for an ASN (e.g., &#x60;GET /asn?asn&#x3D;12345&amp;include&#x3D;peers&#x60;) 
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void getAsnDetailsTest() throws ApiException {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://api.ipgeolocation.io/v2");

        // Configure API key authorization: ApiKeyAuth
        ApiKeyAuth ApiKeyAuth = (ApiKeyAuth) defaultClient.getAuthentication("ApiKeyAuth");
        ApiKeyAuth.setApiKey("API_KEY");

        String ip = null;
        Integer asn = null;
        String include = null;
        String excludes = null;
        String fields = null;
        ASNResponse response = api.getAsnDetails()
                .ip(ip)
                .asn(asn)
                .include(include)
                .excludes(excludes)
                .fields(fields)
                .execute();
        System.out.println(response);
    }

}
