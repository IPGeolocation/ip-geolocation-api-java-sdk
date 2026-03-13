package io.ipgeolocation.sdk.exceptions;

/**
 * API error for HTTP 405 Method Not Allowed.
 */
public final class MethodNotAllowedException extends ApiException {
  /**
   * Creates exception for a {@code 405 Method Not Allowed} API response.
   *
   * @param message SDK-generated exception message
   * @param statusCode HTTP status code
   * @param apiMessage API response message when available
   */
  public MethodNotAllowedException(String message, int statusCode, String apiMessage) {
    super(message, statusCode, apiMessage);
  }
}
