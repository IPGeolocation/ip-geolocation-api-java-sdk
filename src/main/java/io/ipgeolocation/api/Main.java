package io.ipgeolocation.api;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        IPGeolocationAPI api = new IPGeolocationAPI("ea91e4a4159247fdb0926feae70c2911");
        GeolocationParams geolocationParams = new GeolocationParams();
        geolocationParams.setFields("time_zone,languages,city,country_name");
        geolocationParams.setIps(new String[]{"1.1.1.1", "2.2.22.2", "34.1.1.3"});
        List<Geolocation> geolocations = api.getBulkGeolocation(geolocationParams);
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
        System.out.println(geolocations.size());
        System.out.println(geolocations.get(0).getLanguages());
        System.out.println(geolocations.get(1).getCity());
        System.out.println(geolocations.get(2).getCountryName());
    }
}
