package io.ipgeolocation.sdk.exceptions;

/**
 * API error for HTTP 413 Payload Too Large.
 */
public final class PayloadTooLargeException extends ApiException {
  /**
   * Creates exception for a {@code 413 Payload Too Large} API response.
   *
   * @param message SDK-generated exception message
   * @param statusCode HTTP status code
   * @param apiMessage API response message when available
   */
  public PayloadTooLargeException(String message, int statusCode, String apiMessage) {
    super(message, statusCode, apiMessage);
  }
}
