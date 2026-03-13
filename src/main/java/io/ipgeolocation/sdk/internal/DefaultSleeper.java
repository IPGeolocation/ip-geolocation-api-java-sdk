package io.ipgeolocation.sdk.internal;

public final class DefaultSleeper implements Sleeper {
  @Override
  public void sleep(long millis) throws InterruptedException {
    Thread.sleep(millis);
  }
}
