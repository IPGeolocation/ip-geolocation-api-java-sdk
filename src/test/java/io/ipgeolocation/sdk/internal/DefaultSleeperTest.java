package io.ipgeolocation.sdk.internal;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class DefaultSleeperTest {

  @Test
  void sleepWithZeroMillisReturnsImmediately() throws InterruptedException {
    DefaultSleeper sleeper = new DefaultSleeper();
    sleeper.sleep(0L);
  }

  @Test
  void interruptedThreadCausesSleepToThrowInterruptedException() {
    DefaultSleeper sleeper = new DefaultSleeper();
    Thread.currentThread().interrupt();

    try {
      assertThatThrownBy(() -> sleeper.sleep(1L)).isInstanceOf(InterruptedException.class);
    } finally {
      Thread.interrupted();
    }
  }
}
