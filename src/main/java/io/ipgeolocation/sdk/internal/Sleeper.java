package io.ipgeolocation.sdk.internal;

@FunctionalInterface
public interface Sleeper {
  void sleep(long millis) throws InterruptedException;
}
