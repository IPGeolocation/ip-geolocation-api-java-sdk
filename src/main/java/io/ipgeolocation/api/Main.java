package io.ipgeolocation.api;

import java.util.Map;

public class Main {

    public static void main(String[] args) {
        IpGeolocation ipGeolocation = new IpGeolocation("ea91e4a4159247fdb0926feae70c2911");
        Map<String, String> geolocation = ipGeolocation.getIpGeo();
        System.out.println(geolocation.toString());
    }
}
