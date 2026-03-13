package io.ipgeolocation.sdk.exceptions;

/**
 * API error for HTTP 404 Not Found.
 */
public final class NotFoundException extends ApiException {
  /**
   * Creates exception for a {@code 404 Not Found} API response.
   *
   * @param message SDK-generated exception message
   * @param statusCode HTTP status code
   * @param apiMessage API response message when available
   */
  public NotFoundException(String message, int statusCode, String apiMessage) {
    super(message, statusCode, apiMessage);
  }
}
