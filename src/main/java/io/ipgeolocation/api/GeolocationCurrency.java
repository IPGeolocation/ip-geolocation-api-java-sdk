package io.ipgeolocation.api;

public class GeolocationCurrency {
    private String name;
    private String code;

    GeolocationCurrency(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }
}
