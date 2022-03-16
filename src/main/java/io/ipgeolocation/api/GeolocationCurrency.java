package io.ipgeolocation.api;

import java.util.Map;

public class GeolocationCurrency {
    private final String name;
    private final String code;
    private final String symbol;

    GeolocationCurrency(Map<String, Object> json) {
        this.name = (String) json.get("name");
        this.code = (String) json.get("code");
        this.symbol = (String) json.get("symbol");
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public String getSymbol() {
        return symbol;
    }

    @Override
    public String toString() {
        return String.format("name: '%s' \ncode: '%s' \nsymbol: '%s'", name, code, symbol);
    }
}
