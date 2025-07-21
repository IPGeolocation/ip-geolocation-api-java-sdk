/*
 * IPGeolocation.io - IP intelligence products
 * Ipgeolocation provides a set of APIs to make ip based decisions.
 */


package io.ipgeolocation.sdk.api;

import io.ipgeolocation.sdk.invoker.ApiClient;
import io.ipgeolocation.sdk.invoker.ApiException;
import io.ipgeolocation.sdk.invoker.Configuration;
import io.ipgeolocation.sdk.invoker.auth.ApiKeyAuth;
import io.ipgeolocation.sdk.model.TimezoneConversionResponse;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

/**
 * API tests for TimeConversionAPI
 */
@Disabled
public class TimezoneConversionAPITest {

    private final TimezoneConversionAPI api = new TimezoneConversionAPI();

    /**
     * You can convert a timestamp provided as a query paramter time from one time zone to another time zone.
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void convertTimezoneTest() throws ApiException {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://api.ipgeolocation.io/v2");

        // Configure API key authorization: ApiKeyAuth
        ApiKeyAuth ApiKeyAuth = (ApiKeyAuth) defaultClient.getAuthentication("ApiKeyAuth");
        ApiKeyAuth.setApiKey("API_KEY");

        String time = null;
        String tzFrom = null;
        String tzTo = null;
        Float latFrom = null;
        Float longFrom = null;
        Float latTo = null;
        Float longTo = null;
        String locationFrom = null;
        String locationTo = null;
        String icaoFrom = null;
        String icaoTo = null;
        String iataFrom = null;
        String iataTo = null;
        String locodeFrom = null;
        String locodeTo = null;
        TimezoneConversionResponse response = api.convertTimezone()
                .time(time)
                .tzFrom(tzFrom)
                .tzTo(tzTo)
                .latFrom(latFrom)
                .longFrom(longFrom)
                .latTo(latTo)
                .longTo(longTo)
                .locationFrom(locationFrom)
                .locationTo(locationTo)
                .icaoFrom(icaoFrom)
                .icaoTo(icaoTo)
                .iataFrom(iataFrom)
                .iataTo(iataTo)
                .locodeFrom(locodeFrom)
                .locodeTo(locodeTo)
                .execute();
        System.out.println(response);
    }

}
