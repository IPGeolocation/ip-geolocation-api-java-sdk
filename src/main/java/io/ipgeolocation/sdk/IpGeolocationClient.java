package io.ipgeolocation.sdk;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.ipgeolocation.sdk.exceptions.ApiException;
import io.ipgeolocation.sdk.exceptions.RequestTimeoutException;
import io.ipgeolocation.sdk.exceptions.SerializationException;
import io.ipgeolocation.sdk.exceptions.TransportException;
import io.ipgeolocation.sdk.exceptions.ValidationException;
import io.ipgeolocation.sdk.internal.HttpExecutor;
import io.ipgeolocation.sdk.internal.HttpRequestData;
import io.ipgeolocation.sdk.internal.HttpResponseData;
import io.ipgeolocation.sdk.internal.JavaNetHttpExecutor;
import io.ipgeolocation.sdk.internal.ObjectMapperFactory;
import io.ipgeolocation.sdk.internal.ResponseMapper;
import io.ipgeolocation.sdk.internal.SdkVersion;
import io.ipgeolocation.sdk.internal.UriBuilder;
import io.ipgeolocation.sdk.model.BulkGeolocationRequestBody;
import io.ipgeolocation.sdk.model.BulkLookupResult;
import io.ipgeolocation.sdk.model.IpGeolocationResponse;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.time.Duration;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Primary client for the IPGeolocation API at https://ipgeolocation.io.
 *
 * <p>This client targets the Unified IPGeolocation API endpoints {@code /v3/ipgeo} and
 * {@code /v3/ipgeo-bulk}. These endpoints can return IP geolocation data, company data, ASN
 * data, timezone data, hostname data, user-agent details, abuse contact details, and security
 * signals such as VPN or proxy flags, threat score, Tor, anonymous IP, relay, and cloud-provider
 * indicators.
 *
 * <p>Instances are immutable after construction and can be reused across multiple requests.
 * Create one instance per API key or configuration and share it in your application.
 */
public final class IpGeolocationClient implements AutoCloseable {
  private static final String SDK_USER_AGENT = SdkVersion.userAgent();

  private final IpGeolocationClientConfig config;
  private final ObjectMapper objectMapper;
  private final HttpExecutor executor;
  private final ResponseMapper responseMapper;

  /**
   * Creates a client that uses the provided SDK configuration.
   *
   * @param config immutable client configuration
   */
  public IpGeolocationClient(IpGeolocationClientConfig config) {
    this(config, buildExecutor(config), ObjectMapperFactory.create());
  }

  IpGeolocationClient(
      IpGeolocationClientConfig config,
      HttpExecutor executor,
      ObjectMapper objectMapper) {
    this.config = Objects.requireNonNull(config, "config must not be null");
    this.executor = Objects.requireNonNull(executor, "executor must not be null");
    this.objectMapper = Objects.requireNonNull(objectMapper, "objectMapper must not be null");
    this.responseMapper = new ResponseMapper(this.objectMapper);
  }
  /**
   * Executes a single-IP lookup request and returns typed data plus response metadata.
   *
   * @param request lookup parameters for {@code /v3/ipgeo}
   * @return parsed geolocation response and SDK metadata
   * @throws ValidationException when request is null or invalid before I/O, including when
   *     {@code output=xml} is used with this typed method
   * @throws ApiException when the API returns a non-2xx response
   * @throws TransportException when network I/O fails
   * @throws SerializationException when response deserialization fails
   */
  public ApiResponse<IpGeolocationResponse> lookupIpGeolocation(
      LookupIpGeolocationRequest request) {
    validateLookupRequestBase(request);
    validateJsonOutput(request.output());

    Duration timeout = config.readTimeout();
    HttpRequestData httpRequest = buildLookupHttpRequest(request, timeout);
    ExecutionResult execution = executeWithMetrics(httpRequest, timeout);
    HttpResponseData response = execution.response();
    if (response.statusCode() / 100 != 2) {
      throw responseMapper.toApiException(response.statusCode(), response.body());
    }

    IpGeolocationResponse parsed = responseMapper.readBody(response.body(), IpGeolocationResponse.class);
    return new ApiResponse<>(
        parsed,
        responseMapper.toMetadata(
            response.statusCode(),
            execution.durationMs(),
            response.headers()));
  }

  /**
   * Executes a single-IP lookup request and returns the raw response body in the requested output
   * format.
   *
   * <p>When {@code output=json} (default), {@code data()} contains raw JSON. When
   * {@code output=xml}, {@code data()} contains raw XML.
   *
   * @param request lookup parameters for {@code /v3/ipgeo}
   * @return raw response body and SDK metadata
   * @throws ValidationException when request is null or invalid before I/O
   * @throws ApiException when the API returns a non-2xx response
   * @throws TransportException when network I/O fails
   */
  public ApiResponse<String> lookupIpGeolocationRaw(LookupIpGeolocationRequest request) {
    validateLookupRequestBase(request);

    Duration timeout = config.readTimeout();
    HttpRequestData httpRequest = buildLookupHttpRequest(request, timeout);
    ExecutionResult execution = executeWithMetrics(httpRequest, timeout);
    HttpResponseData response = execution.response();
    if (response.statusCode() / 100 != 2) {
      throw responseMapper.toApiException(response.statusCode(), response.body());
    }

    return new ApiResponse<>(
        response.body(),
        responseMapper.toMetadata(
            response.statusCode(),
            execution.durationMs(),
            response.headers()));
  }

  /**
   * Executes a bulk lookup request and returns typed data plus response metadata.
   *
   * @param request bulk lookup parameters for {@code /v3/ipgeo-bulk}
   * @return parsed bulk results and SDK metadata
   * @throws ValidationException when request is null or invalid before I/O, including when
   *     {@code output=xml} is used with this typed method or when the client is configured
   *     without an API key
   * @throws ApiException when the API returns a non-2xx response
   * @throws TransportException when network I/O fails
   * @throws SerializationException when response deserialization fails
   */
  public ApiResponse<List<BulkLookupResult>> bulkLookupIpGeolocation(
      BulkLookupIpGeolocationRequest request) {
    validateBulkRequestBase(request);
    validateJsonOutput(request.output());

    Duration timeout = config.readTimeout();
    HttpRequestData httpRequest = buildBulkHttpRequest(request, timeout);
    ExecutionResult execution = executeWithMetrics(httpRequest, timeout);
    HttpResponseData response = execution.response();
    if (response.statusCode() / 100 != 2) {
      throw responseMapper.toApiException(response.statusCode(), response.body());
    }

    List<BulkLookupResult> parsed = responseMapper.parseBulkResponse(response.body());
    return new ApiResponse<>(
        parsed,
        responseMapper.toMetadata(
            response.statusCode(),
            execution.durationMs(),
            response.headers()));
  }

  /**
   * Executes a bulk lookup request and returns the raw response body in the requested output
   * format.
   *
   * <p>When {@code output=json} (default), {@code data()} contains raw JSON. When
   * {@code output=xml}, {@code data()} contains raw XML.
   *
   * @param request bulk lookup parameters for {@code /v3/ipgeo-bulk}
   * @return raw response body and SDK metadata
   * @throws ValidationException when request is null or invalid before I/O, including when the
   *     client is configured without an API key
   * @throws ApiException when the API returns a non-2xx response
   * @throws TransportException when network I/O fails
   */
  public ApiResponse<String> bulkLookupIpGeolocationRaw(BulkLookupIpGeolocationRequest request) {
    validateBulkRequestBase(request);

    Duration timeout = config.readTimeout();
    HttpRequestData httpRequest = buildBulkHttpRequest(request, timeout);
    ExecutionResult execution = executeWithMetrics(httpRequest, timeout);
    HttpResponseData response = execution.response();
    if (response.statusCode() / 100 != 2) {
      throw responseMapper.toApiException(response.statusCode(), response.body());
    }

    return new ApiResponse<>(
        response.body(),
        responseMapper.toMetadata(
            response.statusCode(),
            execution.durationMs(),
            response.headers()));
  }

  /**
   * Closes the client.
   *
   * <p>This implementation is currently a no-op because lifecycle is owned by the underlying HTTP
   * client.
   */
  @Override
  public void close() {
    // no-op for now; lifecycle is managed by the underlying HttpClient implementation.
  }

  static String defaultUserAgent() {
    return SDK_USER_AGENT;
  }

  private static HttpExecutor buildExecutor(IpGeolocationClientConfig config) {
    return new JavaNetHttpExecutor(config.connectTimeout());
  }

  private HttpRequestData buildLookupHttpRequest(
      LookupIpGeolocationRequest request, Duration timeout) {
    ResponseFormat output = resolveFormat(request.output());
    UriBuilder uriBuilder = UriBuilder.of(config.baseUrl(), "/v3/ipgeo")
        .queryParam("apiKey", config.apiKey())
        .queryParam("ip", request.ip())
        .queryParam("lang", request.lang() == null ? null : request.lang().code())
        .queryParam("include", joinCsv(request.include()))
        .queryParam("fields", joinCsv(request.fields()))
        .queryParam("excludes", joinCsv(request.excludes()))
        .queryParam("output", output.wireValue());

    Map<String, List<String>> headers = new LinkedHashMap<String, List<String>>();
    headers.put("User-Agent", Collections.singletonList(resolveUserAgent(request.userAgent())));
    headers.put("Accept", Collections.singletonList(acceptHeaderFor(output)));
    return new HttpRequestData(uriBuilder.build(), "GET", headers, null, timeout);
  }

  private HttpRequestData buildBulkHttpRequest(
      BulkLookupIpGeolocationRequest request, Duration timeout) {
    ResponseFormat output = resolveFormat(request.output());
    UriBuilder uriBuilder = UriBuilder.of(config.baseUrl(), "/v3/ipgeo-bulk")
        .queryParam("apiKey", config.apiKey())
        .queryParam("lang", request.lang() == null ? null : request.lang().code())
        .queryParam("include", joinCsv(request.include()))
        .queryParam("fields", joinCsv(request.fields()))
        .queryParam("excludes", joinCsv(request.excludes()))
        .queryParam("output", output.wireValue());

    String payload;
    try {
      payload = objectMapper.writeValueAsString(new BulkGeolocationRequestBody(request.ips()));
    } catch (JsonProcessingException e) {
      throw new SerializationException("Failed to serialize bulk lookup request body", e);
    }

    Map<String, List<String>> headers = new LinkedHashMap<String, List<String>>();
    headers.put("User-Agent", Collections.singletonList(resolveUserAgent(request.userAgent())));
    headers.put("Accept", Collections.singletonList(acceptHeaderFor(output)));
    headers.put("Content-Type", Collections.singletonList("application/json"));
    return new HttpRequestData(uriBuilder.build(), "POST", headers, payload, timeout);
  }

  private String resolveUserAgent(String requestUserAgent) {
    return requestUserAgent == null ? SDK_USER_AGENT : requestUserAgent;
  }

  private String acceptHeaderFor(ResponseFormat output) {
    return output == ResponseFormat.XML ? "application/xml" : "application/json";
  }

  private ResponseFormat resolveFormat(ResponseFormat output) {
    return output == null ? ResponseFormat.JSON : output;
  }

  private void validateLookupRequestBase(LookupIpGeolocationRequest request) {
    if (request == null) {
      throw new ValidationException("request must not be null");
    }
  }

  private void validateBulkRequestBase(BulkLookupIpGeolocationRequest request) {
    if (request == null) {
      throw new ValidationException("request must not be null");
    }
    if (config.apiKey() == null) {
      throw new ValidationException("bulk lookup requires apiKey in client config");
    }
    if (request.ips().isEmpty()) {
      throw new ValidationException("ips must not be empty");
    }
    if (request.ips().size() > 50_000) {
      throw new ValidationException("ips must contain at most 50000 entries");
    }
  }

  private void validateJsonOutput(ResponseFormat output) {
    if (resolveFormat(output) == ResponseFormat.XML) {
      throw new ValidationException(
          "XML output is not supported by typed methods. Use ResponseFormat.JSON.");
    }
  }

  private String joinCsv(List<String> values) {
    if (values == null || values.isEmpty()) {
      return null;
    }
    return String.join(",", values);
  }

  private ExecutionResult executeWithMetrics(HttpRequestData request, Duration timeout) {
    long startedAtNanos = System.nanoTime();
    HttpResponseData response = executeOnce(request, timeout);
    long elapsedNanos = System.nanoTime() - startedAtNanos;
    long durationMs = Duration.ofNanos(Math.max(0L, elapsedNanos)).toMillis();
    return new ExecutionResult(response, durationMs);
  }

  private HttpResponseData executeOnce(HttpRequestData request, Duration timeout) {
    try {
      return executor.send(request);
    } catch (SocketTimeoutException e) {
      throw new RequestTimeoutException("HTTP request timed out", e);
    } catch (IOException e) {
      throw new TransportException("HTTP transport error", e);
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      throw new TransportException("Request execution was interrupted", e);
    }
  }

  private static final class ExecutionResult {
    private final HttpResponseData response;
    private final long durationMs;

    private ExecutionResult(HttpResponseData response, long durationMs) {
      this.response = response;
      this.durationMs = durationMs;
    }

    private HttpResponseData response() {
      return response;
    }

    private long durationMs() {
      return durationMs;
    }
  }
}
