package io.ipgeolocation.sdk.exceptions;

/**
 * Raised when request timeout is reached.
 */
public final class RequestTimeoutException extends TransportException {
  /**
   * Creates timeout exception.
   *
   * @param message failure description
   * @param cause underlying timeout exception
   */
  public RequestTimeoutException(String message, Throwable cause) {
    super(message, cause);
  }
}
