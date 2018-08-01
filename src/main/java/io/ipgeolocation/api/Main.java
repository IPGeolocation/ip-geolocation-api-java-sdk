package io.ipgeolocation.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        IPGeolocationAPI api = new IPGeolocationAPI("ea91e4a4159247fdb0926feae70c2911");
        GeolocationParams geolocationParams = new GeolocationParams();
        geolocationParams.setFields("time_zone,languages,city,country_name");
        geolocationParams.setIps(new String[]{"1.1.1.1", "2.2.22.2", "34.1.1.3"});
        List<Geolocation> l = api.getBulkGeolocation(geolocationParams);
        //        GeolocationParams geolocationParams = new GeolocationParams();
//        geolocationParams.setIp("2.3.4.5");
//        geolocationParams.setFields("time_zone,languages,city,country_name");
//        Timezone timezone = api.getTimezone(params);
//        System.out.println(timezone.getTimezone());
//        System.out.println(timezone.getTimezoneOffset());
//        System.out.println(timezone.getDateTimeWti());
//        System.out.println(timezone.getTime24());
//        System.out.println(timezone.getTimezoneGeo().getCity());

//        Geolocation geolocation = api.getGeolocation(geolocationParams);
//        System.out.println(geolocation.getTimezone().getName());
//        System.out.println(geolocation.getIp());
//        System.out.println(geolocation.getLanguages());
//        System.out.println(geolocation.getCity());
//        System.out.println(geolocation.getCountryName());
    }
}
