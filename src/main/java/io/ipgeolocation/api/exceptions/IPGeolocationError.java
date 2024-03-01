package io.ipgeolocation.api.exceptions;

/**
 * This exception class represents errors that may occur during the execution of IP Geolocation API requests.
 * It extends the RuntimeException class.
 */
public class IPGeolocationError extends RuntimeException {
  private int status = -1;

  /**
   * Constructs a new IPGeolocationError with the specified cause.
   *
   * @param e The cause of the error.
   */
  public IPGeolocationError(Throwable e) {
    super(e);
  }

  /**
   * Constructs a new IPGeolocationError with the specified detail message.
   *
   * @param message The detail message.
   */
  public IPGeolocationError(String message) {
    super(message);
  }

  /**
   * Constructs a new IPGeolocationError with the specified HTTP status code and detail message.
   *
   * @param status  The HTTP status code indicating the type of error.
   * @param message The detail message describing the error.
   */
  public IPGeolocationError(int status, String message) {
    super(message);

    this.status = status;
  }

  /**
   * Returns the HTTP status code associated with this error. All the possible error codes
   * are listed <a href="https://ipgeolocation.io/documentation/ip-geolocation-api.html">here</a> with the possible cause.
   *
   * @return The HTTP status code.
   */
  public int getStatus() {
    return status;
  }
}
