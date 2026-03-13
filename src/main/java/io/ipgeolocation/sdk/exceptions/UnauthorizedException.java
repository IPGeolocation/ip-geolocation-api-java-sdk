package io.ipgeolocation.sdk.exceptions;

/**
 * API error for HTTP 401 Unauthorized.
 */
public final class UnauthorizedException extends ApiException {
  /**
   * Creates exception for a {@code 401 Unauthorized} API response.
   *
   * @param message SDK-generated exception message
   * @param statusCode HTTP status code
   * @param apiMessage API response message when available
   */
  public UnauthorizedException(String message, int statusCode, String apiMessage) {
    super(message, statusCode, apiMessage);
  }
}
