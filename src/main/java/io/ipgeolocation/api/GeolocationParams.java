package io.ipgeolocation.api;

public class GeolocationParams {
    private String ip;
    private String fields;
    private String lang;
    private String[] ips;

    public GeolocationParams() {
        this.ip = "";
        this.fields = "";
        this.lang = "en";
        this.ips = new String[0];
    }

    public void setIp(String ip) {
        this.ip = Strings.nullToEmpty(ip);
    }

    public String getIp() {
        return this.ip;
    }

    public void setFields(String fields) {
        this.fields = Strings.nullToEmpty(fields);
    }

    public String getFields() {
        return this.fields;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getLang() {
        return this.lang;
    }

    public void setIps(String[] ips) throws IllegalArgumentException {
        if(ips.length > 50) {
            throw new IllegalArgumentException("Max. number of IP addresses cannot be more than 50.");
        } else {
            this.ips = ips;
        }
    }

    public String[] getIps() {
        return this.ips;
    }
}
