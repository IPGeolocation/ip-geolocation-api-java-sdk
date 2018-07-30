package io.ipgeolocation.api;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        IpGeolocation ipGeolocation = new IpGeolocation("ea91e4a4159247fdb0926feae70c2911");
        Map<String, String> parameters = new HashMap<String, String>();
        parameters.put("ip", "5.4.3.2");
        parameters.put("fields", "geo,currency");
        Map<String, String> geolocation = ipGeolocation.getIpgeo(parameters);
        System.out.println(geolocation.toString());
    }
}
