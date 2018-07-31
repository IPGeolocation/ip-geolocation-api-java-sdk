package io.ipgeolocation.api;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        IPGeolocationAPI api = new IPGeolocationAPI("ea91e4a4159247fdb0926feae70c2911");
        Map<String, String> params = new HashMap<String, String>();
        params.put("fields", "geo");
        GeolocationResult geolocationResult = api.getGeolocation(params);
//        Timezone timezone = geolocationResult.getTimezone();
//        System.out.println(timezone.getCurrentTime());
        System.out.println(geolocationResult.getCity());
        System.out.println(geolocationResult.getCountryCode2());
    }
}
