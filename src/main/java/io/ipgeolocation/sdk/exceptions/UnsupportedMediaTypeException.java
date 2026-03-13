package io.ipgeolocation.sdk.exceptions;

/**
 * API error for HTTP 415 Unsupported Media Type.
 */
public final class UnsupportedMediaTypeException extends ApiException {
  /**
   * Creates exception for a {@code 415 Unsupported Media Type} API response.
   *
   * @param message SDK-generated exception message
   * @param statusCode HTTP status code
   * @param apiMessage API response message when available
   */
  public UnsupportedMediaTypeException(String message, int statusCode, String apiMessage) {
    super(message, statusCode, apiMessage);
  }
}
