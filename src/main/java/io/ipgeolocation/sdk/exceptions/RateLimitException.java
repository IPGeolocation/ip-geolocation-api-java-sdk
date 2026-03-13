package io.ipgeolocation.sdk.exceptions;

/**
 * API error for HTTP 429 Too Many Requests.
 */
public final class RateLimitException extends ApiException {
  /**
   * Creates exception for a {@code 429 Too Many Requests} API response.
   *
   * @param message SDK-generated exception message
   * @param statusCode HTTP status code
   * @param apiMessage API response message when available
   */
  public RateLimitException(String message, int statusCode, String apiMessage) {
    super(message, statusCode, apiMessage);
  }
}
