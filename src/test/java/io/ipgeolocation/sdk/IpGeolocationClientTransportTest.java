package io.ipgeolocation.sdk;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import io.ipgeolocation.sdk.exceptions.RequestTimeoutException;
import io.ipgeolocation.sdk.exceptions.TransportException;
import io.ipgeolocation.sdk.internal.ObjectMapperFactory;
import java.net.SocketTimeoutException;
import org.junit.jupiter.api.Test;

class IpGeolocationClientTransportTest {

  @Test
  void timeoutIOExceptionMapsToRequestTimeoutException() {
    TestHttpExecutor executor = new TestHttpExecutor();
    executor.enqueueIOException(new SocketTimeoutException("socket timed out"));

    IpGeolocationClient client =
        new IpGeolocationClient(
            IpGeolocationClientConfig.builder("k").build(),
            executor,
            ObjectMapperFactory.create());

    assertThatThrownBy(
            () -> client.lookupIpGeolocation(LookupIpGeolocationRequest.builder().ip("8.8.8.8").build()))
        .isInstanceOf(RequestTimeoutException.class)
        .hasMessageContaining("timed out");
  }

  @Test
  void genericIOExceptionMapsToTransportException() {
    TestHttpExecutor executor = new TestHttpExecutor();
    executor.enqueueIOException(new java.io.IOException("connection reset"));

    IpGeolocationClient client =
        new IpGeolocationClient(
            IpGeolocationClientConfig.builder("k").build(),
            executor,
            ObjectMapperFactory.create());

    assertThatThrownBy(
            () -> client.lookupIpGeolocation(LookupIpGeolocationRequest.builder().ip("8.8.8.8").build()))
        .isInstanceOf(TransportException.class)
        .hasMessageContaining("HTTP transport error");
  }

  @Test
  void interruptedIOExceptionMapsToTransportExceptionAndPreservesInterruptFlag() {
    TestHttpExecutor executor = new TestHttpExecutor();
    executor.enqueueInterruptedException(new InterruptedException("stop"));

    IpGeolocationClient client =
        new IpGeolocationClient(
            IpGeolocationClientConfig.builder("k").build(),
            executor,
            ObjectMapperFactory.create());

    try {
      assertThatThrownBy(
              () -> client.lookupIpGeolocation(LookupIpGeolocationRequest.builder().ip("8.8.8.8").build()))
          .isInstanceOf(TransportException.class)
          .hasMessageContaining("interrupted");
      assertThat(Thread.currentThread().isInterrupted()).isTrue();
    } finally {
      Thread.interrupted();
    }
  }
}
