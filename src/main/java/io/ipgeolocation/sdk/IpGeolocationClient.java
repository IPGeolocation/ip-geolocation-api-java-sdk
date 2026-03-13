package io.ipgeolocation.sdk;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.ipgeolocation.sdk.exceptions.ApiException;
import io.ipgeolocation.sdk.exceptions.RequestTimeoutException;
import io.ipgeolocation.sdk.exceptions.SerializationException;
import io.ipgeolocation.sdk.exceptions.TransportException;
import io.ipgeolocation.sdk.exceptions.ValidationException;
import io.ipgeolocation.sdk.internal.HttpExecutor;
import io.ipgeolocation.sdk.internal.HttpResponseData;
import io.ipgeolocation.sdk.internal.JavaNetHttpExecutor;
import io.ipgeolocation.sdk.internal.ObjectMapperFactory;
import io.ipgeolocation.sdk.internal.ResponseMapper;
import io.ipgeolocation.sdk.internal.SdkVersion;
import io.ipgeolocation.sdk.internal.Sleeper;
import io.ipgeolocation.sdk.internal.UriBuilder;
import io.ipgeolocation.sdk.model.BulkGeolocationRequestBody;
import io.ipgeolocation.sdk.model.BulkLookupResult;
import io.ipgeolocation.sdk.model.IpGeolocationResponse;
import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpTimeoutException;
import java.time.Duration;
import java.util.List;
import java.util.Objects;

/**
 * Primary client for the IP Geolocation API at https://ipgeolocation.io.
 *
 * <p>This client currently targets the Unified IPGeolocation API endpoints
 * {@code /v3/ipgeo} and {@code /v3/ipgeo-bulk}.
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

  // Maintained for package-level test compatibility.
  IpGeolocationClient(
      IpGeolocationClientConfig config,
      HttpExecutor executor,
      Sleeper sleeper,
      ObjectMapper objectMapper) {
    this(config, executor, objectMapper);
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
    HttpRequest httpRequest = buildLookupHttpRequest(request, timeout);
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
    HttpRequest httpRequest = buildLookupHttpRequest(request, timeout);
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
    HttpRequest httpRequest = buildBulkHttpRequest(request, timeout);
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
    HttpRequest httpRequest = buildBulkHttpRequest(request, timeout);
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
    HttpClient.Builder builder = HttpClient.newBuilder().connectTimeout(config.connectTimeout());
    return new JavaNetHttpExecutor(builder.build());
  }

  private HttpRequest buildLookupHttpRequest(
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

    HttpRequest.Builder builder =
        HttpRequest.newBuilder(uriBuilder.build())
            .GET()
            .timeout(timeout);

    builder.setHeader("User-Agent", resolveUserAgent(request.userAgent()));
    builder.setHeader("Accept", acceptHeaderFor(output));
    return builder.build();
  }

  private HttpRequest buildBulkHttpRequest(
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

    HttpRequest.Builder builder =
        HttpRequest.newBuilder(uriBuilder.build())
            .timeout(timeout)
            .POST(HttpRequest.BodyPublishers.ofString(payload));

    builder.setHeader("User-Agent", resolveUserAgent(request.userAgent()));
    builder.setHeader("Accept", acceptHeaderFor(output));
    builder.setHeader("Content-Type", "application/json");
    return builder.build();
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

  private ExecutionResult executeWithMetrics(HttpRequest request, Duration timeout) {
    long startedAtNanos = System.nanoTime();
    HttpResponseData response = executeOnce(request, timeout);
    long elapsedNanos = System.nanoTime() - startedAtNanos;
    long durationMs = Duration.ofNanos(Math.max(0L, elapsedNanos)).toMillis();
    return new ExecutionResult(response, durationMs);
  }

  private HttpResponseData executeOnce(HttpRequest request, Duration timeout) {
    try {
      return executor.send(request, timeout);
    } catch (HttpTimeoutException e) {
      throw new RequestTimeoutException("HTTP request timed out", e);
    } catch (IOException e) {
      throw new TransportException("HTTP transport error", e);
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      throw new TransportException("Request execution was interrupted", e);
    }
  }

  private record ExecutionResult(HttpResponseData response, long durationMs) {}
}
