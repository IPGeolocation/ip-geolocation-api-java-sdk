package io.ipgeolocation.api;

public class GeolocationParams {
    private String ip;
    private String fields;

    public GeolocationParams() {
        this.ip = "";
        this.fields = "";
    }

    public void setIp(String ip) {
        this.ip = Strings.nullToEmpty(ip);
    }

    public String getIp() {
        return ip;
    }

    public void setFields(String fields) {
        this.fields = Strings.nullToEmpty(fields);
    }

    public String getFields() {
        return fields;
    }
}
