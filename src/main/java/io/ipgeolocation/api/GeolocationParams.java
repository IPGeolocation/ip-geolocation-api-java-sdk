package io.ipgeolocation.api;

public class GeolocationParams {
    private String ip;
    private String[] ips;
    private String lang;
    private String fields;
    private boolean includeHostname;
    private boolean includeSecurity;
    private boolean includeUserAgentDetail;
    private String excludes;

    public GeolocationParams() {
        this.ip = "";
        this.ips = new String[0];
        this.lang = "en";
        this.fields = "";
        this.includeHostname = false;
        this.includeSecurity = false;
        this.includeUserAgentDetail = false;
        this.excludes = "";
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

    public void setIncludeSecurity(boolean includeSecurity) {
        this.includeSecurity = includeSecurity;
    }

    public boolean isIncludeSecurity() {
        return includeSecurity;
    }

    public void setIncludeUserAgentDetail(boolean includeUserAgentDetail) {
        this.includeUserAgentDetail = includeUserAgentDetail;
    }

    public boolean isIncludeUserAgentDetail() {
        return includeUserAgentDetail;
    }

    public void setExcludes(String excludes) {
        this.excludes = excludes;
    }

    public String getExcludes() {
        return excludes;
    }


    public void setIPAddresses(String[] ips) throws IllegalArgumentException {
        if (ips.length > 50) {
            throw new IllegalArgumentException("Max. number of IP addresses cannot be more than 50.");
        } else {
            this.ips = ips;
        }
    }

    public String[] getIPAddresses() {
        return ips;
    }
}
