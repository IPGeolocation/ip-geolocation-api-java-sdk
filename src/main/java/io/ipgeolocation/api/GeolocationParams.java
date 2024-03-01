package io.ipgeolocation.api;

/**
 * The {@code GeolocationParams} class represents parameters used for querying Geolocation information
 * from the IP Geolocation API.
 *
 * <p>The class provides methods for setting the IP address, language, fields, and excludes for
 * retrieving Geolocation information. The class also provides methods for retrieving the IP
 * address, language, fields, and excludes.
 *
 * <p>
 * It also includes a builder pattern to facilitate the construction of {@code TimezoneParams} objects
 * with various parameters.
 *
 * <p>The class is immutable and thread-safe.
 *
 * <p>Example usage:
 *
 * <pre>{@code
 * GeolocationParams params = GeolocationParams.Builder()
 *     .withIPAddress("8.8.8.8")
 *     .withLang("en")
 *     .withFields("geo,time_zone")
 *     .build();
 *     }
 * </pre>
 *
 * </p>
 */
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

  /**
   * Constructs a new {@code GeolocationParams} object with the specified parameters.
   * @param ipAddress                   The IP address.
   * @param lang                        The language preference.
   * @param fields                      The fields to include in the response.
   * @param excludes                    The fields to exclude from the response.
   * @param includeHostname             Whether to include hostname information in the response.
   * @param includeLiveHostname         Whether to include live hostname information in the response.
   * @param includeHostnameFallbackLive Whether to include fallback live hostname information in the response.
   * @param includeSecurity             Whether to include security information in the response.
   * @param includeUserAgentDetail      Whether to include user agent detail in the response.
   * */
  private GeolocationParams(
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

  /**
   * Returns the IP address for which geolocation information will be retrieved.
   *
   * @return The IP address as a {@code String}.
   */
  public String getIPAddress() {
    return ipAddress;
  }

  /**
   * Returns the fields to include in the response.
   *
   * @return The fields as a {@code String}.
   */
  public String getFields() {
    return fields;
  }

  /**
   * Returns the language for the response.
   *
   * @return The language as a {@code String}.
   */
  public String getLang() {
    return lang;
  }

  /**
   * Returns whether to include hostname information in the response.
   *
   * @return {@code true} if hostname information should be included, {@code false} otherwise.
   */
  public boolean isIncludeHostname() {
    return includeHostname;
  }

  /**
   * Returns whether to include live hostname information in the response.
   *
   * @return {@code true} if live hostname information should be included, {@code false} otherwise.
   */
  public boolean isIncludeLiveHostname() {
    return includeLiveHostname;
  }

  /**
   * Returns whether to include fallback live hostname information in the response.
   *
   * @return {@code true} if fallback live hostname information should be included, {@code false} otherwise.
   */
  public boolean isIncludeHostnameFallbackLive() {
    return includeHostnameFallbackLive;
  }

  /**
   * Returns whether to include security information in the response.
   *
   * @return {@code true} if security information should be included, {@code false} otherwise.
   */
  public boolean isIncludeSecurity() {
    return includeSecurity;
  }

  /**
   * Returns whether to include user agent detail in the response.
   *
   * @return {@code true} if user agent detail should be included, {@code false} otherwise.
   */
  public boolean isIncludeUserAgentDetail() {
    return includeUserAgentDetail;
  }

  /**
   * Returns the fields set to exclude from the response.
   *
   * @return The excluded fields as a {@code String}.
   */
  public String getExcludes() {
    return excludes;
  }

  /**
   * Creates a new builder instance for constructing GeolocationParams objects.
   *
   * @return A new GeolocationParamsBuilder instance.
   */
  public static GeolocationParamsBuilder builder() {
    return new GeolocationParamsBuilder();
  }

  /**
   * The {@code GeolocationParamsBuilder} class is a builder pattern for constructing {@code GeolocationParams}
   * objects with various parameters.
   */
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

    /**
     * Sets the IPv4, IPv6 address or domain name for which geolocation information will be retrieved.
     *
     * @param ipAddress The IPv4, IPv6 address or domain name as a {@code String}.
     * @return The {@code GeolocationParamsBuilder} instance for method chaining.
     */
    public GeolocationParamsBuilder withIPAddress(String ipAddress) {
      this.ipAddress = ipAddress;
      return this;
    }

    /**
     * Sets the language for the response. Default is set to {@code en}.
     *
     * @param lang The language as a {@code String}.
     * @return The {@code GeolocationParamsBuilder} instance for method chaining.
     */
    public GeolocationParamsBuilder withLang(String lang) {
      this.lang = lang;
      return this;
    }

    /**
     * Sets the fields to include in the response. All the available fields can be found
     * <a href="https://ipgeolocation.io/documentation/ip-geolocation-api.html">here</a>.
     *
     * @param fields The fields as a {@code String} like "geo,time_zone,currency".
     * @return The {@code GeolocationParamsBuilder} instance for method chaining.
     */
    public GeolocationParamsBuilder withFields(String fields) {
      this.fields = fields;
      return this;
    }

    /**
     * Sets the fields to exclude from the response.
     *
     * @param excludes The excluded fields as a {@code String}.
     * @return The {@code GeolocationParamsBuilder} instance for method chaining.
     */
    public GeolocationParamsBuilder withExcludes(String excludes) {
      this.excludes = excludes;
      return this;
    }

    /**
     * Sets whether to include hostname information in the response.
     *
     * <p>
     * This method enables the IPGeolocation API to lookup hostname from our IP-Hostname database and
     * returns the same IP address if there is no hostname found for the queried IP address.
     * Lookup through the IP-Hostname database is faster than other options but is experimental and under process
     * and can produce unwanted output.
     * </p>
     * <p>
     * Note: use one of {@code includeHostname}, {@code includeLiveHostname} or {@code includeHostnameFallbackLive}
     * </p>
     *
     * @return The {@code GeolocationParamsBuilder} instance for method chaining.
     */
    public GeolocationParamsBuilder includeHostname() {
      this.includeHostname = Boolean.TRUE;
      return this;
    }

    /**
     * Sets whether to include live hostname information in the response.
     * <p>
     * This method enables the IPGeolocation API to lookup hostname from live sources.
     * Lookup through live sources is accurate but can introduce more latency to your query to IPGeolocation API.
     * </p>
     *
     * <p>
     * Note: use one of {@code includeHostname}, {@code includeLiveHostname} or {@code includeHostnameFallbackLive}
     * </p>
     *
     * @return The {@code GeolocationParamsBuilder} instance for method chaining.
     */
    public GeolocationParamsBuilder includeLiveHostname() {
      this.includeLiveHostname = Boolean.TRUE;
      return this;
    }

    /**
     * Sets whether to include fallback live hostname information in the response.
     * <p>
     * This method enables the IPGeolocation API to lookup hostname from our IP-Hostname database and
     * if there is no hostname found for the queried IP address, then lookup through the live sources.
     * This option has been introduced for faster and accurate lookup.
     * </p>
     *
     * <p>
     * Note: use one of {@code includeHostname}, {@code includeLiveHostname} or {@code includeHostnameFallbackLive}
     * </p>
     *
     * @return The {@code GeolocationParamsBuilder} instance for method chaining.
     */
    public GeolocationParamsBuilder includeHostnameFallbackLive() {
      this.includeHostnameFallbackLive = Boolean.TRUE;
      return this;
    }

    /**
     * Specifies to include security information in the response.
     *
     * @return The {@code GeolocationParamsBuilder} instance for method chaining.
     */
    public GeolocationParamsBuilder includeSecurity() {
      this.includeSecurity = Boolean.TRUE;
      return this;
    }

    /**
     * Specifies to include user agent detail in the response.
     *
     * @return The {@code GeolocationParamsBuilder} instance for method chaining.
     */
    public GeolocationParamsBuilder includeUserAgentDetail() {
      this.includeUserAgentDetail = Boolean.TRUE;
      return this;
    }

    /**
     * Constructs a new {@code GeolocationParams} object using the builder's parameters.
     *
     * @return A new {@code GeolocationParams} object.
     */
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
