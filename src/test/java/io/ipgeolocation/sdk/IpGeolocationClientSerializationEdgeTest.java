package io.ipgeolocation.sdk;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.ipgeolocation.sdk.exceptions.SerializationException;
import org.junit.jupiter.api.Test;

class IpGeolocationClientSerializationEdgeTest {

  @Test
  void bulkRequestSerializationFailureIsMappedToSerializationException() {
    ObjectMapper failingMapper =
        new ObjectMapper() {
          @Override
          public String writeValueAsString(Object value) throws JsonProcessingException {
            throw new JsonProcessingException("boom") {};
          }
        };

    TestHttpExecutor executor = new TestHttpExecutor();
    IpGeolocationClient client =
        new IpGeolocationClient(
            IpGeolocationClientConfig.builder("k").build(),
            executor,
            millis -> {},
            failingMapper);

    assertThatThrownBy(
            () ->
                client.bulkLookupIpGeolocation(
                    BulkLookupIpGeolocationRequest.builder().addIp("8.8.8.8").build()))
        .isInstanceOf(SerializationException.class)
        .hasMessageContaining("Failed to serialize bulk lookup request body");
  }
}
