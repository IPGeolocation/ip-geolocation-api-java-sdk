package io.ipgeolocation.api;

public class TimezoneParams {
    private String timezone;
    private String ip;
    private Double latitude;
    private Double longitude;

    public TimezoneParams() {
        timezone = "";
        ip = "";
        latitude = 1000.0;
        latitude = 1000.0;
    }

    public void setTimezone(String timezone) {
        this.timezone = Strings.nullToEmpty(timezone);
    }

    public String getTimezone() {
        return this.timezone;
    }

    public void setIp(String ip) {
        this.ip = Strings.nullToEmpty(ip);
    }

    public String getIp() {
        return this.ip;
    }

    public void setLocation(Double latitude, Double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return this.latitude;
    }

    public Double getLongitude() {
        return this.longitude;
    }
}
