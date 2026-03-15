package io.ipgeolocation.sdk.internal;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.ipgeolocation.sdk.ApiResponseMetadata;
import io.ipgeolocation.sdk.exceptions.ApiException;
import io.ipgeolocation.sdk.exceptions.BadRequestException;
import io.ipgeolocation.sdk.exceptions.ClientClosedRequestException;
import io.ipgeolocation.sdk.exceptions.LockedException;
import io.ipgeolocation.sdk.exceptions.MethodNotAllowedException;
import io.ipgeolocation.sdk.exceptions.NotFoundException;
import io.ipgeolocation.sdk.exceptions.PayloadTooLargeException;
import io.ipgeolocation.sdk.exceptions.RateLimitException;
import io.ipgeolocation.sdk.exceptions.SerializationException;
import io.ipgeolocation.sdk.exceptions.ServerErrorException;
import io.ipgeolocation.sdk.exceptions.UnauthorizedException;
import io.ipgeolocation.sdk.exceptions.UnsupportedMediaTypeException;
import io.ipgeolocation.sdk.model.BulkLookupError;
import io.ipgeolocation.sdk.model.BulkLookupResult;
import io.ipgeolocation.sdk.model.BulkLookupSuccess;
import io.ipgeolocation.sdk.model.ErrorResponse;
import io.ipgeolocation.sdk.model.IpGeolocationResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public final class ResponseMapper {
  private final ObjectMapper objectMapper;

  public ResponseMapper(ObjectMapper objectMapper) {
    this.objectMapper = Objects.requireNonNull(objectMapper, "objectMapper must not be null");
  }

  public <T> T readBody(String body, Class<T> type) {
    try {
      return objectMapper.readValue(body, type);
    } catch (IOException e) {
      throw new SerializationException("Failed to deserialize API response", e);
    }
  }

  public List<BulkLookupResult> parseBulkResponse(String body) {
    try {
      JsonNode root = objectMapper.readTree(body);
      if (!root.isArray()) {
        throw new SerializationException(
            "Failed to deserialize bulk response: expected an array payload",
            new IllegalArgumentException("Unexpected JSON token"));
      }

      List<BulkLookupResult> result = new ArrayList<>(root.size());
      for (JsonNode node : root) {
        if (node.has("message") && !node.has("ip")) {
          ErrorResponse error = objectMapper.treeToValue(node, ErrorResponse.class);
          result.add(new BulkLookupError(error.message()));
        } else {
          IpGeolocationResponse item = objectMapper.treeToValue(node, IpGeolocationResponse.class);
          result.add(new BulkLookupSuccess(item));
        }
      }
      return result;
    } catch (IOException e) {
      throw new SerializationException("Failed to deserialize bulk lookup response", e);
    }
  }

  public ApiException toApiException(int statusCode, String body) {
    String apiMessage = extractApiMessage(body);
    String message =
        Compat.isBlank(apiMessage)
            ? "API request failed with HTTP status " + statusCode
            : "API request failed with HTTP status " + statusCode + ": " + apiMessage;

    switch (statusCode) {
      case 400:
        return new BadRequestException(message, statusCode, apiMessage);
      case 401:
        return new UnauthorizedException(message, statusCode, apiMessage);
      case 404:
        return new NotFoundException(message, statusCode, apiMessage);
      case 405:
        return new MethodNotAllowedException(message, statusCode, apiMessage);
      case 413:
        return new PayloadTooLargeException(message, statusCode, apiMessage);
      case 415:
        return new UnsupportedMediaTypeException(message, statusCode, apiMessage);
      case 423:
        return new LockedException(message, statusCode, apiMessage);
      case 429:
        return new RateLimitException(message, statusCode, apiMessage);
      case 499:
        return new ClientClosedRequestException(message, statusCode, apiMessage);
      default:
        if (statusCode >= 500 && statusCode <= 599) {
          return new ServerErrorException(message, statusCode, apiMessage);
        }
        return new ApiException(message, statusCode, apiMessage);
    }
  }

  public ApiResponseMetadata toMetadata(
      int statusCode, long durationMs, Map<String, List<String>> rawHeaders) {
    Integer credits = parseIntHeader(firstHeaderIgnoreCase(rawHeaders, "X-Credits-Charged"));
    Integer successCount = parseIntHeader(firstHeaderIgnoreCase(rawHeaders, "X-Successful-Record"));

    return new ApiResponseMetadata(
        credits,
        successCount,
        statusCode,
        durationMs,
        rawHeaders);
  }

  private Integer parseIntHeader(String value) {
    if (Compat.isBlank(value)) {
      return null;
    }
    try {
      return Integer.parseInt(value.trim());
    } catch (NumberFormatException ignored) {
      return null;
    }
  }

  private String firstHeaderIgnoreCase(Map<String, List<String>> headers, String headerName) {
    if (headers == null || headers.isEmpty()) {
      return null;
    }
    for (Map.Entry<String, List<String>> entry : headers.entrySet()) {
      if (entry.getKey() != null && entry.getKey().equalsIgnoreCase(headerName)) {
        List<String> values = entry.getValue();
        if (values != null && !values.isEmpty()) {
          return values.get(0);
        }
      }
    }
    return null;
  }

  private String extractApiMessage(String body) {
    if (Compat.isBlank(body)) {
      return null;
    }
    try {
      ErrorResponse err = objectMapper.readValue(body, ErrorResponse.class);
      return err.message();
    } catch (IOException ignored) {
      return body.length() > 512 ? body.substring(0, 512) : body;
    }
  }
}
