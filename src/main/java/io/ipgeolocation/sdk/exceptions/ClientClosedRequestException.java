package io.ipgeolocation.sdk.exceptions;

/**
 * API error for HTTP 499 Client Closed Request.
 */
public final class ClientClosedRequestException extends ApiException {
  /**
   * Creates exception for a {@code 499 Client Closed Request} API response.
   *
   * @param message SDK-generated exception message
   * @param statusCode HTTP status code
   * @param apiMessage API response message when available
   */
  public ClientClosedRequestException(String message, int statusCode, String apiMessage) {
    super(message, statusCode, apiMessage);
  }
}
