package io.ipgeolocation.api.exceptions;

public class IPGeolocationError extends RuntimeException {
  private int status = -1;

  public IPGeolocationError(Throwable e) {
    super(e);
  }

  public IPGeolocationError(String message) {
    super(message);
  }

  public IPGeolocationError(int status, String message) {
    super(message);

    this.status = status;
  }

  public int getStatus() {
    return status;
  }
}
