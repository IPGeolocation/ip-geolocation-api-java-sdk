package io.ipgeolocation.sdk.exceptions;

/**
 * Raised when request inputs are invalid before network I/O.
 */
public final class ValidationException extends IpGeolocationException {
  /**
   * Creates validation exception.
   *
   * @param message validation failure description
   */
  public ValidationException(String message) {
    super(message);
  }
}
