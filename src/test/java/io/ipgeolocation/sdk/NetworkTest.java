package io.ipgeolocation.sdk;

import static org.assertj.core.api.Assertions.assertThat;

import io.ipgeolocation.sdk.internal.ObjectMapperFactory;
import io.ipgeolocation.sdk.model.Network;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class NetworkTest {
  @ParameterizedTest
  @ValueSource(booleans = {true, false})
  void preservesCdnFlagInTypedResponses(boolean value) throws Exception {
    Network network = ObjectMapperFactory.create().readValue(
        "{\"is_cdn\":" + value + ",\"cdn_provider_name\":\"Example CDN\"}", Network.class);
    assertThat(network.isCdn()).isEqualTo(value);
    assertThat(network.cdnProviderName()).isEqualTo("Example CDN");
    assertThat(ObjectMapperFactory.create().valueToTree(network).get("is_cdn").booleanValue())
        .isEqualTo(value);
  }

  @Test
  void retainsExistingConstructorAndMissingFieldBehavior() throws Exception {
    Network oldConstructor = new Network("corporate", "8.8.8.0/24", true);
    Network parsed = ObjectMapperFactory.create().readValue(
        "{\"connection_type\":\"corporate\",\"route\":\"8.8.8.0/24\",\"is_anycast\":true}", Network.class);
    assertThat(parsed).isEqualTo(oldConstructor).hasSameHashCodeAs(oldConstructor);
    assertThat(parsed.isCdn()).isNull();
    assertThat(parsed.cdnProviderName()).isNull();
  }
}
