package io.ipgeolocation.api;

import java.util.Map;

public class UserAgentOperatingSystem {
    private final String name;
    private final String type;
    private final String version;
    private final String versionMajor;

    public UserAgentOperatingSystem(Map<String, Object> json) {
        this.name = (String) json.get("name");
        this.type = (String) json.get("type");
        this.version = (String) json.get("version");
        this.versionMajor = (String) json.get("versionMajor");
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getVersion() {
        return version;
    }

    public String getVersionMajor() {
        return versionMajor;
    }
}
