/*
 * IPGeolocation.io - IP intelligence products
 * Ipgeolocation provides a set of APIs to make ip based decisions.
 */


package io.ipgeolocation.sdk.api;

import io.ipgeolocation.sdk.invoker.ApiClient;
import io.ipgeolocation.sdk.invoker.ApiException;
import io.ipgeolocation.sdk.invoker.Configuration;
import io.ipgeolocation.sdk.invoker.auth.ApiKeyAuth;
import io.ipgeolocation.sdk.model.AstronomyResponse;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

/**
 * API tests for AstronomyApi
 */
@Disabled
public class AstronomyAPITest {

    private final AstronomyAPI api = new AstronomyAPI();

    /**
     * The Astronomy API provides the location-based rise and set times for the Sun and Moon along with the current position, distance from earth, and azimuth of the Sun and the Moon for a specific date at the queried time. 
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void getAstronomyTest() throws ApiException {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://api.ipgeolocation.io/v2");

        // Configure API key authorization: ApiKeyAuth
        ApiKeyAuth ApiKeyAuth = (ApiKeyAuth) defaultClient.getAuthentication("ApiKeyAuth");
        ApiKeyAuth.setApiKey("API_KEY");

        String ip = null;
        String location = null;
        String lat = null;
        String _long = null;
        String date = null;
        String output = null;
        String lang = null;
        AstronomyResponse response = api.getAstronomy()
                .ip(ip)
                .location(location)
                .lat(lat)
                ._long(_long)
                .date(date)
                .output(output)
                .lang(lang)
                .execute();
        System.out.println(response);
    }

}
