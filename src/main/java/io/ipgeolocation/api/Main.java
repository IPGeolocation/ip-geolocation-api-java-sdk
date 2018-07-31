package io.ipgeolocation.api;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        IPGeolocationAPI api = new IPGeolocationAPI("ea91e4a4159247fdb0926feae70c2911");
        Map<String, String> params = new HashMap<String, String>();
        params.put("ip", "45.2.44.5");
        Timezone timezone = api.getTimezone(params);
        System.out.println(timezone.getTimezone());
        System.out.println(timezone.getTimezoneOffset());
        System.out.println(timezone.getDateTimeWti());
        System.out.println(timezone.getTime24());
        System.out.println(timezone.getTimezoneGeo().getCity());
    }
}
