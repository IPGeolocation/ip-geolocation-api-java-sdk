/*
 * IPGeolocation.io - IP intelligence products
 * Ipgeolocation provides a set of APIs to make ip based decisions.
 */


package io.ipgeolocation.sdk.api;

import io.ipgeolocation.sdk.invoker.ApiClient;
import io.ipgeolocation.sdk.invoker.ApiException;
import io.ipgeolocation.sdk.invoker.Configuration;
import io.ipgeolocation.sdk.invoker.auth.ApiKeyAuth;
import io.ipgeolocation.sdk.model.TimezoneResponse;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

/**
 * API tests for TimezoneApi
 */
@Disabled
public class TimezoneAPITest {

    private final TimezoneAPI api = new TimezoneAPI();

    /**
     * Timezone information details
     *
     * The Time Zone API provides current time, date, and time zone-related information. It supports various input types including time zone name, geographic coordinates, addresses, IPs, and location codes.  The API determines the time zone based on the following priority order if multiple parameters are provided:   1. Time Zone Name   2. Geographic Coordinates (latitude &amp; longitude)   3. Location Address   4. IP Address   5. IATA Code   6. ICAO Code   7. UN/LOCODE  Enriched response data is returned based on the type of input: - IP: includes geolocation info - Address: includes location metadata - IATA/ICAO: includes airport info - UN/LOCODE: includes city details  You can call the time zone API without passing any time zone, coordinates, IATA, ICAO, LO code or IP address as well. It will use the calling machine&#39;s IP address to return the regional time zone information. 
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void getTimezoneTest() throws ApiException {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://api.ipgeolocation.io/v2");

        // Configure API key authorization: ApiKeyAuth
        ApiKeyAuth ApiKeyAuth = (ApiKeyAuth) defaultClient.getAuthentication("ApiKeyAuth");
        ApiKeyAuth.setApiKey("API_KEY");

        String tz = null;
        String location = null;
        Float lat = null;
        Float _long = null;
        String ip = null;
        String iataCode = null;
        String icaoCode = null;
        String loCode = null;
        String output = null;
        String lang = null;
        TimezoneResponse response = api.getTimezone()
                .tz(tz)
                .location(location)
                .lat(lat)
                ._long(_long)
                .ip(ip)
                .iataCode(iataCode)
                .icaoCode(icaoCode)
                .loCode(loCode)
                .output(output)
                .lang(lang)
                .execute();
        System.out.println(response);
    }

}
