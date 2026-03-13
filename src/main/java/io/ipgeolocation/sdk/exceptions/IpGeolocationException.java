package io.ipgeolocation.sdk.exceptions;

/**
 * Base exception type for all SDK failures.
 */
public class IpGeolocationException extends RuntimeException {
  /**
   * Creates exception with message.
   *
   * @param message failure description
   */
  public IpGeolocationException(String message) {
    super(message);
  }

  /**
   * Creates exception with message and cause.
   *
   * @param message failure description
   * @param cause underlying cause
   */
  public IpGeolocationException(String message, Throwable cause) {
    super(message, cause);
  }
}
