/*
 * IPGeolocation.io - IP intelligence products
 * Ipgeolocation provides a set of APIs to make ip based decisions.
 */


package io.ipgeolocation.sdk.api;

import io.ipgeolocation.sdk.invoker.ApiClient;
import io.ipgeolocation.sdk.invoker.ApiException;
import io.ipgeolocation.sdk.invoker.Configuration;
import io.ipgeolocation.sdk.invoker.auth.ApiKeyAuth;
import io.ipgeolocation.sdk.model.AbuseResponse;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

/**
 * API tests for AbuseContactApi
 */
@Disabled
public class AbuseContactAPITest {

    private final AbuseContactAPI api = new AbuseContactAPI();

    /**
     * The Abuse Contact API provides essential contact information to report abusive activity associated with IP addresses. By querying an IP address (IPv4 or IPv6), users receive detailed abuse contact data, including the responsible organization, abuse handling role, contact emails, phone numbers, and registered address. This enables users to swiftly take action to report and mitigate threats such as spam, DDoS attacks, and phishing.     In addition to abuse-specific contacts, the API also includes registration metadata like the registered country and abuse handle. This empowers cybersecurity teams, hosting providers, and compliance entities to take appropriate legal or administrative action. 
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void getAbuseContactInfoTest() throws ApiException {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://api.ipgeolocation.io/v2");

        // Configure API key authorization: ApiKeyAuth
        ApiKeyAuth ApiKeyAuth = (ApiKeyAuth) defaultClient.getAuthentication("ApiKeyAuth");
        ApiKeyAuth.setApiKey("API_KEY");

        String ip = null;
        String excludes = null;
        String fields = null;
        AbuseResponse response = api.getAbuseContactInfo()
                .ip(ip)
                .excludes(excludes)
                .fields(fields)
                .execute();
        System.out.println(response);
    }

}
