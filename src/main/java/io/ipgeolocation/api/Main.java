package io.ipgeolocation.api;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        IPGeolocationAPI api = new IPGeolocationAPI("ea91e4a4159247fdb0926feae70c2911");

        // Query geolocation for IP address (1.1.1.1) and fields (geo, time_zone and currency)
        GeolocationParams geoParams = new GeolocationParams();
        geoParams.setIp("1.1.1.1");
        geoParams.setFields("geo,time_zone,currency");

        Geolocation geolocation = api.getGeolocation(geoParams);

        if(geolocation.getStatus() == 200) {
            System.out.println(geolocation.getCountryName());
            System.out.println(geolocation.getCurrency().getName());
            System.out.println(geolocation.getTimezone().getCurrentTime());
        } else {
            System.out.println(geolocation.getMessage());
        }

        // Query geolocation for the calling machine's IP address for all fields
        geolocation = api.getGeolocation();

        if(geolocation.getStatus() == 200) {
            System.out.println(geolocation.getCountryCode2());
            System.out.println(geolocation.getCallingCode());
            System.out.println(geolocation.getCurrency().getName());
            System.out.println(geolocation.getTimezone().getCurrentTime());
        } else {
            System.out.println(geolocation.getMessage());
        }

        // Query geolocation for the multiple IP addresses
        String[] ips = new String[]{"1.1.1.1", "2.2.2.256", "3.3.3.3"};
        geoParams = new GeolocationParams();
        geoParams.setIps(ips);

        List<Geolocation> geolocations = api.getBulkGeolocation(geoParams);

        System.out.println(geolocations.size());
        System.out.println(geolocations.get(0).getCountryName());
        System.out.println(geolocations.get(1).getMessage());
        System.out.println(geolocations.get(2).getTimezone());


        // Query time zone information by latitude and longitude of the location
        TimezoneParams tzParams = new TimezoneParams();
        tzParams.setLocation(37.1838139,-123.8105225);

        Timezone tz = api.getTimezone(tzParams);

        if(tz.getStatus() == 200) {
            System.out.println(tz.getTimezone());
            System.out.println(tz.getDateTimeTxt());
        } else {
            System.out.println(tz.getMessage());
        }

        // Query time zone information for IP address (1.1.1.1)
        tzParams = new TimezoneParams();
        tzParams.setIp("1.1.1.1");

        tz = api.getTimezone(tzParams);

        if(tz.getStatus() == 200) {
            System.out.println(tz.getTimezone());
            System.out.println(tz.getWeek());
        } else {
            System.out.println(tz.getMessage());
        }

        // Query time zone information for calling machine’s IP address
        tz = api.getTimezone();

        if(tz.getStatus() == 200) {
            System.out.println(tz.getTimezone());
            System.out.println(tz.getMonth());
        } else {
            System.out.println(tz.getMessage());
        }
    }
}
