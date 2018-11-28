package io.ipgeolocation.api;

import java.util.Map;

public class GeolocationCurrency {
    private String name;
    private String code;

    GeolocationCurrency(Map json) {
        this.name = (String) json.get("name");
        this.code = (String) json.get("code");
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    @Override
    public String toString() {
        return String.format("name: '%s' \ncode: '%s'", name, code);
    }
}
