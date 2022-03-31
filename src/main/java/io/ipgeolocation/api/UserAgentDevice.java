package io.ipgeolocation.api;

import java.util.Map;

public class UserAgentDevice {
    private final String name;
    private final String type;
    private final String brand;
    private final String cpu;

    public UserAgentDevice(Map<String, Object> json) {
        this.name = (String) json.get("name");
        this.type = (String) json.get("type");
        this.brand = (String) json.get("brand");
        this.cpu = (String) json.get("CPU");
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getBrand() {
        return brand;
    }

    public String getCpu() {
        return cpu;
    }
}
