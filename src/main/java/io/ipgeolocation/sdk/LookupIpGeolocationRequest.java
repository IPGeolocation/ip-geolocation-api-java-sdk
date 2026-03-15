package io.ipgeolocation.sdk;

import io.ipgeolocation.sdk.internal.Compat;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Request parameters for the Unified IPGeolocation API single-lookup endpoint
 * {@code GET /v3/ipgeo}.
 *
 * <p>Use this type with the IPGeolocation API at https://ipgeolocation.io.
 *
 * <p>Use {@link Builder} to construct instances. Query values for {@code include},
 * {@code fields}, and {@code excludes} are passed through as provided and validated by the API.
 * Optional request-level header overrides such as {@code User-Agent} can also be set.
 */
public final class LookupIpGeolocationRequest {
  private final String ip;
  private final Language lang;
  private final List<String> include;
  private final List<String> fields;
  private final List<String> excludes;
  private final String userAgent;
  private final ResponseFormat output;

  private LookupIpGeolocationRequest(Builder builder) {
    this.ip = builder.ip;
    this.lang = builder.lang;
    this.include = Compat.immutableList(builder.include);
    this.fields = Compat.immutableList(builder.fields);
    this.excludes = Compat.immutableList(builder.excludes);
    this.userAgent = builder.userAgent;
    this.output = builder.output;
  }

  /**
   * @return IP address or domain to resolve, or {@code null} to resolve the caller IP
   */
  public String ip() {
    return ip;
  }

  /**
   * @return language applied to localized fields, or {@code null} for API default
   */
  public Language lang() {
    return lang;
  }

  /**
   * @return modules requested through {@code include}, in insertion order
   */
  public List<String> include() {
    return include;
  }

  /**
   * @return explicit response field whitelist, in insertion order
   */
  public List<String> fields() {
    return fields;
  }

  /**
   * @return explicit response field blacklist, in insertion order
   */
  public List<String> excludes() {
    return excludes;
  }

  /**
   * @return request-level {@code User-Agent} header override, or {@code null} to use client default
   */
  public String userAgent() {
    return userAgent;
  }

  /**
   * @return requested response format
   */
  public ResponseFormat output() {
    return output;
  }

  /**
   * @return builder for request parameters
   */
  public static Builder builder() {
    return new Builder();
  }

  /**
   * Builder for {@link LookupIpGeolocationRequest}.
   *
   * <p>Default output format is {@link ResponseFormat#JSON}.
   */
  public static final class Builder {
    private String ip;
    private Language lang;
    private final List<String> include = new ArrayList<>();
    private final List<String> fields = new ArrayList<>();
    private final List<String> excludes = new ArrayList<>();
    private String userAgent;
    private ResponseFormat output = ResponseFormat.JSON;

    /**
     * Sets the lookup target.
     *
     * <p>A blank value is treated as omission and resolves the caller IP.
     *
     * @param ip IP address or domain, may be null
     * @return this builder
     */
    public Builder ip(String ip) {
      if (ip != null && Compat.isBlank(ip)) {
        // Mirrors API behavior: blank ip is treated as omission and resolves caller IP.
        this.ip = null;
        return this;
      }
      this.ip = ip;
      return this;
    }

    /**
     * Sets the language code for localized fields.
     *
     * @param lang language enum, or null for API default
     * @return this builder
     */
    public Builder lang(Language lang) {
      this.lang = lang;
      return this;
    }

    /**
     * Adds one module to {@code include}.
     *
     * @param module non-blank include token
     * @return this builder
     * @throws IllegalArgumentException when token is null or blank
     */
    public Builder include(String module) {
      include.add(requireToken(module, "include"));
      return this;
    }

    /**
     * Adds one field path to {@code fields}.
     *
     * @param field non-blank field token
     * @return this builder
     * @throws IllegalArgumentException when token is null or blank
     */
    public Builder fields(String field) {
      fields.add(requireToken(field, "fields"));
      return this;
    }

    /**
     * Adds one field path to {@code excludes}.
     *
     * @param field non-blank field token
     * @return this builder
     * @throws IllegalArgumentException when token is null or blank
     */
    public Builder excludes(String field) {
      excludes.add(requireToken(field, "excludes"));
      return this;
    }

    /**
     * Sets request-level {@code User-Agent} header value.
     *
     * <p>When set, this value is sent as the request {@code User-Agent} header for this call only.
     * Use this when requesting {@code include=user_agent} from server-side applications and
     * forwarding the actual visitor user agent.
     *
     * @param userAgent user-agent value, or {@code null} to use client default
     * @return this builder
     * @throws IllegalArgumentException when value is blank
     */
    public Builder userAgent(String userAgent) {
      if (userAgent == null) {
        this.userAgent = null;
        return this;
      }
      if (Compat.isBlank(userAgent)) {
        throw new IllegalArgumentException("userAgent must not be blank");
      }
      this.userAgent = userAgent;
      return this;
    }

    /**
     * Sets response format.
     *
     * @param output non-null format
     * @return this builder
     * @throws NullPointerException when format is null
     */
    public Builder output(ResponseFormat output) {
      this.output = Objects.requireNonNull(output, "output must not be null");
      return this;
    }

    /**
     * Builds an immutable single-lookup request.
     *
     * @return immutable request
     */
    public LookupIpGeolocationRequest build() {
      return new LookupIpGeolocationRequest(this);
    }

    private static String requireToken(String value, String field) {
      if (Compat.isBlank(value)) {
        throw new IllegalArgumentException(field + " value must not be blank");
      }
      return value;
    }
  }
}
