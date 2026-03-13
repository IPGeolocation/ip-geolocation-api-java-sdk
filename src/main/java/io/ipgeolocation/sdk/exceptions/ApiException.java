package io.ipgeolocation.sdk.exceptions;

/**
 * Base type for non-2xx API responses.
 *
 * <p>This exception keeps the HTTP status and API error message.
 */
public class ApiException extends IpGeolocationException {
  private final int statusCode;
  private final String apiMessage;

  /**
   * Creates an API exception with response details.
   *
   * @param message SDK-generated exception message
   * @param statusCode HTTP status code returned by API
   * @param apiMessage API response message field when available
   */
  public ApiException(String message, int statusCode, String apiMessage) {
    super(message);
    this.statusCode = statusCode;
    this.apiMessage = apiMessage;
  }

  /**
   * @return HTTP status code returned by API
   */
  public int statusCode() {
    return statusCode;
  }

  /**
   * @return API-provided error message when available, otherwise {@code null}
   */
  public String apiMessage() {
    return apiMessage;
  }
}
