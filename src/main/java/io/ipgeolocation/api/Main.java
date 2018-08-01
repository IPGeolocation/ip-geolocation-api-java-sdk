package io.ipgeolocation.api;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        IPGeolocationAPI api = new IPGeolocationAPI("ea91e4a4159247fdb0926feae70c2911");
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("ip", "45.2.44.5");
            String[] ips = {"1.1.1.1", "2.2.22.2", "34.1.1.3"};
            Map<String, Object> data = new HashMap<String, Object>();
            data.put("ips",ips);
            api.getBulkGeolocation(data,params);
//        Timezone timezone = api.getTimezone(params);
//        System.out.println(timezone.getTimezone());
//        System.out.println(timezone.getTimezoneOffset());
//        System.out.println(timezone.getDateTimeWti());
//        System.out.println(timezone.getTime24());
//        System.out.println(timezone.getTimezoneGeo().getCity());
    }
}
