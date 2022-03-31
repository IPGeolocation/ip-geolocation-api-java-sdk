package io.ipgeolocation.api;

public class TimezoneParams {
    private String timezone;
    private String ip;
    private String lang;
    private Double latitude;
    private Double longitude;
    private String location;

    public TimezoneParams() {
        this.timezone = "";
        this.ip = "";
        this.lang = "en";
        this.location = "";
        this.latitude = 1000.00;
        this.longitude = 1000.00;
    }

    public void setTimezone(String timezone) {
        this.timezone = Strings.nullToEmpty(timezone);
    }

    public String getTimezone() {
        return this.timezone;
    }

    public void setIPAddress(String ip) {
        this.ip = Strings.nullToEmpty(ip);
    }

    public String getIPAddress() {
        return this.ip;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getLang() {
        return this.lang;
    }

    public void setCoordinates(Double latitude, Double longitude) {
        if ((latitude >= -90 && latitude <= 90) && (longitude >= -180 && longitude <= 180)) {
            this.latitude = latitude;
            this.longitude = longitude;
        } else {
            throw new IllegalArgumentException("Coordinate value is out of range!");
        }
    }

    public Double getLatitude() {
        return this.latitude;
    }

    public Double getLongitude() {
        return this.longitude;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

}
