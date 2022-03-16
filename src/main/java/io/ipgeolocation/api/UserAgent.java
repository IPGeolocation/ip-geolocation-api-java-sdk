package io.ipgeolocation.api;

import com.google.gson.internal.LinkedTreeMap;

import java.util.Map;

public class UserAgent {

    private String userAgentString;
    private String name;
    private String type;
    private String version;
    private String versionMajor;
    public UserAgentDevice device;
    private UserAgentEngine engine;
    private UserAgentOperatingSystem operatingSystem;

    public UserAgent() {
    }

    public UserAgent(Map<String, Object> json) {
        this.userAgentString = (String) json.get("userAgentString");
        this.name = (String) json.get("name");
        this.type = (String) json.get("type");
        this.version = (String) json.get("version");
        this.versionMajor = (String) json.get("versionMajor");
        if (json.get("device") instanceof LinkedTreeMap) {
            Map<String, Object> deviceJson = (LinkedTreeMap) json.get("device");
            this.device = new UserAgentDevice(deviceJson);
        }

        if (json.get("engine") instanceof LinkedTreeMap) {
            Map<String, Object> engineJson = (LinkedTreeMap) json.get("engine");
            this.engine = new UserAgentEngine(engineJson);
        }

        if (json.get("operatingSystem") instanceof LinkedTreeMap) {
            Map<String, Object> operatingSystemJson = (LinkedTreeMap) json.get("operatingSystem");
            this.operatingSystem = new UserAgentOperatingSystem(operatingSystemJson);
        }

    }

    public String getUserAgentString() {
        return userAgentString;
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

    public UserAgentDevice getDevice() {
        return device;
    }

    public UserAgentEngine getEngine() {
        return engine;
    }

    public UserAgentOperatingSystem getOperatingSystem() {
        return operatingSystem;
    }


}
