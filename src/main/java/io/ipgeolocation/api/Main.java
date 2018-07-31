package io.ipgeolocation.api;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        IPGeolocationAPI api = new IPGeolocationAPI("ea91e4a4159247fdb0926feae70c2911");
        Map<String, String> params = new HashMap<String, String>();
        params.put("fields", "geo,time_zone");
        Geolocation geolocation = api.getGeolocation(params);
        GeolocationTimezone timezone = geolocation.getTimezone();
        System.out.println(timezone.getCurrentTime());
        System.out.println(geolocation.getCity());
        System.out.println(geolocation.getCountryCode2());
    }
}
