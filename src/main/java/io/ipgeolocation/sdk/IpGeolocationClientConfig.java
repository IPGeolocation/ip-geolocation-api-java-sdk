package io.ipgeolocation.sdk;

import io.ipgeolocation.sdk.internal.Compat;
import java.time.Duration;
import java.util.Objects;

/**
 * Immutable configuration for {@link IpGeolocationClient}.
 *
 * <p>Use this configuration when calling the IPGeolocation API at https://ipgeolocation.io.
 */
public final class IpGeolocationClientConfig {
  private final String apiKey;
  private final String baseUrl;
  private final Duration connectTimeout;
  private final Duration readTimeout;

  private IpGeolocationClientConfig(Builder builder) {
    this.apiKey = builder.apiKey;
    this.baseUrl = builder.baseUrl;
    this.connectTimeout = builder.connectTimeout;
    this.readTimeout = builder.readTimeout;
  }

  /**
   * Creates a builder initialized with an API key.
   *
   * @param apiKey API key sent as {@code apiKey} query parameter
   * @return config builder
   */
  public static Builder builder(String apiKey) {
    return new Builder().apiKey(apiKey);
  }

  /**
   * Creates a builder without an API key.
   *
   * <p>Use this only for single lookup calls to {@code /v3/ipgeo} from an allowlisted request
   * origin where the API key is not required in the query string. Bulk lookups to
   * {@code /v3/ipgeo-bulk} always require an API key. If request-origin authorization is not
   * configured on the account, single lookup API calls will fail with {@code 401 Unauthorized}.
   *
   * @return config builder
   */
  public static Builder builder() {
    return new Builder();
  }

  /**
   * @return API key used as query parameter, or {@code null} when omitted
   */
  public String apiKey() {
    return apiKey;
  }

  /**
   * @return base URL for API requests, without trailing slash
   */
  public String baseUrl() {
    return baseUrl;
  }

  /**
   * @return connection timeout used for HTTP client socket establishment
   */
  public Duration connectTimeout() {
    return connectTimeout;
  }

  /**
   * @return default per-request read timeout
   */
  public Duration readTimeout() {
    return readTimeout;
  }

  /**
   * Mutable builder for {@link IpGeolocationClientConfig}.
   *
   * <p>Defaults:
   * <ul>
   *   <li>{@code baseUrl=https://api.ipgeolocation.io}</li>
   *   <li>{@code connectTimeout=10s}</li>
   *   <li>{@code readTimeout=30s}</li>
   * </ul>
   */
  public static final class Builder {
    private String apiKey;
    private String baseUrl = "https://api.ipgeolocation.io";
    private Duration connectTimeout = Duration.ofSeconds(10);
    private Duration readTimeout = Duration.ofSeconds(30);

    private Builder() {}

    /**
     * Sets the API key used as the {@code apiKey} query parameter.
     *
     * <p>For request-origin allowlisted single lookup usage, omit this value. Bulk lookup always
     * requires an API key.
     *
     * @param apiKey non-blank API key, or {@code null} to omit
     * @return this builder
     * @throws IllegalArgumentException when value is blank
     */
    public Builder apiKey(String apiKey) {
      if (apiKey == null) {
        this.apiKey = null;
        return this;
      }
      if (Compat.isBlank(apiKey)) {
        throw new IllegalArgumentException("apiKey must not be blank");
      }
      this.apiKey = apiKey;
      return this;
    }

    /**
     * Sets the API base URL.
     *
     * <p>The default points to the production IPGeolocation API hosted by
     * https://ipgeolocation.io.
     *
     * @param baseUrl non-blank base URL
     * @return this builder
     * @throws IllegalArgumentException when value is blank
     */
    public Builder baseUrl(String baseUrl) {
      if (Compat.isBlank(baseUrl)) {
        throw new IllegalArgumentException("baseUrl must not be blank");
      }
      this.baseUrl = trimTrailingSlash(baseUrl);
      return this;
    }

    /**
     * Sets socket connection timeout.
     *
     * @param connectTimeout positive duration
     * @return this builder
     * @throws IllegalArgumentException when duration is zero or negative
     * @throws NullPointerException when duration is null
     */
    public Builder connectTimeout(Duration connectTimeout) {
      this.connectTimeout = requirePositiveDuration(connectTimeout, "connectTimeout");
      return this;
    }

    /**
     * Sets default per-request timeout.
     *
     * @param readTimeout positive duration
     * @return this builder
     * @throws IllegalArgumentException when duration is zero or negative
     * @throws NullPointerException when duration is null
     */
    public Builder readTimeout(Duration readTimeout) {
      this.readTimeout = requirePositiveDuration(readTimeout, "readTimeout");
      return this;
    }

    /**
     * Builds an immutable client configuration.
     *
     * @return immutable configuration
     * @throws IllegalArgumentException when {@code connectTimeout > readTimeout}
     */
    public IpGeolocationClientConfig build() {
      if (connectTimeout.compareTo(readTimeout) > 0) {
        throw new IllegalArgumentException("connectTimeout must be <= readTimeout");
      }
      return new IpGeolocationClientConfig(this);
    }

    private static String trimTrailingSlash(String value) {
      int index = value.length();
      while (index > 0 && value.charAt(index - 1) == '/') {
        index--;
      }
      return value.substring(0, index);
    }

    private static Duration requirePositiveDuration(Duration value, String field) {
      Objects.requireNonNull(value, field + " must not be null");
      if (value.isNegative() || value.isZero()) {
        throw new IllegalArgumentException(field + " must be greater than zero");
      }
      return value;
    }
  }
}
