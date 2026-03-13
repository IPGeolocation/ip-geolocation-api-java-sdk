package io.ipgeolocation.sdk.exceptions;

/**
 * Raised when request or response payload serialization fails.
 */
public final class SerializationException extends IpGeolocationException {
  /**
   * Creates serialization exception.
   *
   * @param message failure description
   * @param cause underlying serialization cause
   */
  public SerializationException(String message, Throwable cause) {
    super(message, cause);
  }
}
