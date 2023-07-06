package io.ipgeolocation.api;

public class GeolocationParams {
  private final String ipAddress;
  private final String lang;
  private final String fields;
  private final Boolean includeHostname;
  private final boolean includeLiveHostname;
  private final boolean includeHostnameFallbackLive;
  private final boolean includeSecurity;
  private final boolean includeUserAgentDetail;
  private final String excludes;

  public GeolocationParams(
      String ipAddress,
      String lang,
      String fields,
      String excludes,
      boolean includeHostname,
      boolean includeLiveHostname,
      boolean includeHostnameFallbackLive,
      boolean includeSecurity,
      boolean includeUserAgentDetail) {
    this.ipAddress = ipAddress;
    this.lang = lang;
    this.fields = fields;
    this.includeHostname = includeHostname;
    this.includeLiveHostname = includeLiveHostname;
    this.includeHostnameFallbackLive = includeHostnameFallbackLive;
    this.includeSecurity = includeSecurity;
    this.includeUserAgentDetail = includeUserAgentDetail;
    this.excludes = excludes;
  }

  public String getIPAddress() {
    return ipAddress;
  }

  public String getFields() {
    return fields;
  }

  public String getLang() {
    return lang;
  }

  public boolean isIncludeHostname() {
    return includeHostname;
  }

  public boolean isIncludeLiveHostname() {
    return includeLiveHostname;
  }

  public boolean isIncludeHostnameFallbackLive() {
    return includeHostnameFallbackLive;
  }

  public boolean isIncludeSecurity() {
    return includeSecurity;
  }

  public boolean isIncludeUserAgentDetail() {
    return includeUserAgentDetail;
  }

  public String getExcludes() {
    return excludes;
  }

  public static GeolocationParamsBuilder builder() {
    return new GeolocationParamsBuilder();
  }

  public static class GeolocationParamsBuilder {
    private String ipAddress;
    private String lang;
    private String fields;
    private boolean includeHostname;
    private boolean includeLiveHostname;
    private boolean includeHostnameFallbackLive;
    private boolean includeSecurity;
    private boolean includeUserAgentDetail;
    private String excludes;

    private GeolocationParamsBuilder() {
      ipAddress = "";
      lang = "en";
      fields = "*";
      excludes = "";
    }

    public GeolocationParamsBuilder withIPAddress(String ipAddress) {
      this.ipAddress = ipAddress;
      return this;
    }

    public GeolocationParamsBuilder withLang(String lang) {
      this.lang = lang;
      return this;
    }

    public GeolocationParamsBuilder withFields(String fields) {
      this.fields = fields;
      return this;
    }

    public GeolocationParamsBuilder withExcludes(String excludes) {
      this.excludes = excludes;
      return this;
    }

    public GeolocationParamsBuilder includeHostname() {
      this.includeHostname = Boolean.TRUE;
      return this;
    }

    public GeolocationParamsBuilder includeLiveHostname() {
      this.includeLiveHostname = Boolean.TRUE;
      return this;
    }

    public GeolocationParamsBuilder includeHostnameFallbackLive() {
      this.includeHostnameFallbackLive = Boolean.TRUE;
      return this;
    }

    public GeolocationParamsBuilder includeSecurity() {
      this.includeSecurity = Boolean.TRUE;
      return this;
    }

    public GeolocationParamsBuilder includeUserAgentDetail() {
      this.includeUserAgentDetail = Boolean.TRUE;
      return this;
    }

    public GeolocationParams build() {
      return new GeolocationParams(
          ipAddress,
          lang,
          fields,
          excludes,
          includeHostname,
          includeLiveHostname,
          includeHostnameFallbackLive,
          includeSecurity,
          includeUserAgentDetail);
    }
  }
}
