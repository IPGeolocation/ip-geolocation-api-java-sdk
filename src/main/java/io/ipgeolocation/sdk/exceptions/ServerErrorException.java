package io.ipgeolocation.sdk.exceptions;

/**
 * API error for HTTP 5xx server failures.
 */
public final class ServerErrorException extends ApiException {
  /**
   * Creates exception for a {@code 5xx} API response.
   *
   * @param message SDK-generated exception message
   * @param statusCode HTTP status code
   * @param apiMessage API response message when available
   */
  public ServerErrorException(String message, int statusCode, String apiMessage) {
    super(message, statusCode, apiMessage);
  }
}
