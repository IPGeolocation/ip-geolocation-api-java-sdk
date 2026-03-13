package io.ipgeolocation.sdk.exceptions;

/**
 * API error for HTTP 400 Bad Request.
 */
public final class BadRequestException extends ApiException {
  /**
   * Creates exception for a {@code 400 Bad Request} API response.
   *
   * @param message SDK-generated exception message
   * @param statusCode HTTP status code
   * @param apiMessage API response message when available
   */
  public BadRequestException(String message, int statusCode, String apiMessage) {
    super(message, statusCode, apiMessage);
  }
}
