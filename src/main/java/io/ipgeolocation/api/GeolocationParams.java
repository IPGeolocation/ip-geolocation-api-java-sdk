package io.ipgeolocation.api;

import java.util.Arrays;

public class GeolocationParams {
    private String ip;
    private String fields;
    private String lang;
    private boolean includeHostname;
    private String[] ips;

    public GeolocationParams() {
        this.ip = "";
        this.fields = "";
        this.lang = "en";
        this.includeHostname = false;
        this.ips = new String[0];
    }

    public void setIPAddress(String ip) {
        this.ip = Strings.nullToEmpty(ip);
    }

    public String getIPAddress() {
        return ip;
    }

    public void setFields(String fields) {
        this.fields = Strings.nullToEmpty(fields);
    }

    public String getFields() {
        return fields;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getLang() {
        return lang;
    }

    public void setIncludeHostname(boolean includeHostname) {
        this.includeHostname = includeHostname;
    }

    public boolean isIncludeHostname() {
        return includeHostname;
    }

    public void setIPAddresses(String[] ips) throws IllegalArgumentException {
        if(ips.length > 50) {
            throw new IllegalArgumentException("Max. number of IP addresses cannot be more than 50.");
        } else {
            this.ips = ips;
        }
    }

    public String[] getIPAddresses() {
        return ips;
    }

    @Override
    public String toString() {
        return String.format("IP address: '%s', Fields: '%s', Lang: '%s', IP addresses: '%s'", ip, fields, lang, Arrays.toString(ips));
    }
}
