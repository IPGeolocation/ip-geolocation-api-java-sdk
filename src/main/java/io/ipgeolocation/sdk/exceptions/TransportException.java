package io.ipgeolocation.sdk.exceptions;

/**
 * Raised when transport/network I/O fails.
 */
public class TransportException extends IpGeolocationException {
  /**
   * Creates transport exception.
   *
   * @param message failure description
   * @param cause underlying I/O cause
   */
  public TransportException(String message, Throwable cause) {
    super(message, cause);
  }
}
