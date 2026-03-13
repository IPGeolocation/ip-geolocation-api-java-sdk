package io.ipgeolocation.sdk.exceptions;

/**
 * API error for HTTP 423 Locked.
 */
public final class LockedException extends ApiException {
  /**
   * Creates exception for a {@code 423 Locked} API response.
   *
   * @param message SDK-generated exception message
   * @param statusCode HTTP status code
   * @param apiMessage API response message when available
   */
  public LockedException(String message, int statusCode, String apiMessage) {
    super(message, statusCode, apiMessage);
  }
}
