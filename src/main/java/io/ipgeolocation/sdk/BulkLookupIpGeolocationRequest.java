package io.ipgeolocation.sdk;

import io.ipgeolocation.sdk.exceptions.ValidationException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Request payload and query parameters for the Unified IPGeolocation API bulk-lookup endpoint
 * {@code POST /v3/ipgeo-bulk}.
 *
 * <p>Use this type with the IP Geolocation API at https://ipgeolocation.io.
 *
 * <p>Use {@link Builder} to construct instances. Query values for {@code include},
 * {@code fields}, and {@code excludes} are passed through as provided and validated by the API.
 * Optional request-level header overrides such as {@code User-Agent} can also be set.
 */
public final class BulkLookupIpGeolocationRequest {
  private final List<String> ips;
  private final Language lang;
  private final List<String> include;
  private final List<String> fields;
  private final List<String> excludes;
  private final String userAgent;
  private final ResponseFormat output;

  private BulkLookupIpGeolocationRequest(Builder builder) {
    this.ips = List.copyOf(builder.ips);
    this.lang = builder.lang;
    this.include = List.copyOf(builder.include);
    this.fields = List.copyOf(builder.fields);
    this.excludes = List.copyOf(builder.excludes);
    this.userAgent = builder.userAgent;
    this.output = builder.output;
  }

  /**
   * @return immutable list of IPs or domains submitted in the bulk request body
   */
  public List<String> ips() {
    return ips;
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
   * @return builder for bulk request parameters
   */
  public static Builder builder() {
    return new Builder();
  }

  /**
   * Builder for {@link BulkLookupIpGeolocationRequest}.
   *
   * <p>Default output format is {@link ResponseFormat#JSON}. The SDK enforces the documented bulk
   * body size range of 1..50,000 records at build time.
   */
  public static final class Builder {
    private final List<String> ips = new ArrayList<>();
    private Language lang;
    private final List<String> include = new ArrayList<>();
    private final List<String> fields = new ArrayList<>();
    private final List<String> excludes = new ArrayList<>();
    private String userAgent;
    private ResponseFormat output = ResponseFormat.JSON;

    /**
     * Adds one IP address or domain entry.
     *
     * @param ipOrDomain non-blank value
     * @return this builder
     * @throws ValidationException when value is null or blank
     */
    public Builder addIp(String ipOrDomain) {
      ips.add(requireToken(ipOrDomain, "ips"));
      return this;
    }

    /**
     * Replaces the current input list with the provided values.
     *
     * @param ips non-null list of IP/domain values
     * @return this builder
     * @throws NullPointerException when list is null
     * @throws ValidationException when any item is null or blank
     */
    public Builder ips(List<String> ips) {
      Objects.requireNonNull(ips, "ips must not be null");
      this.ips.clear();
      ips.forEach(ip -> this.ips.add(requireToken(ip, "ips")));
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
     * @throws ValidationException when token is null or blank
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
     * @throws ValidationException when token is null or blank
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
     * @throws ValidationException when token is null or blank
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
     * @throws ValidationException when value is blank
     */
    public Builder userAgent(String userAgent) {
      if (userAgent == null) {
        this.userAgent = null;
        return this;
      }
      if (userAgent.isBlank()) {
        throw new ValidationException("userAgent must not be blank");
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
     * Builds an immutable bulk-lookup request.
     *
     * <p>Validates documented API bulk limits before the request is sent.
     *
     * @return immutable bulk request
     * @throws ValidationException when input list is empty or exceeds 50,000 entries
     */
    public BulkLookupIpGeolocationRequest build() {
      if (ips.isEmpty()) {
        throw new ValidationException("ips must not be empty");
      }
      if (ips.size() > 50_000) {
        throw new ValidationException("ips must contain at most 50000 entries");
      }
      return new BulkLookupIpGeolocationRequest(this);
    }

    private static String requireToken(String value, String field) {
      if (value == null || value.isBlank()) {
        throw new ValidationException(field + " value must not be blank");
      }
      return value;
    }
  }
}
