package io.ipgeolocation.sdk;

import static org.assertj.core.api.Assertions.assertThat;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.ipgeolocation.sdk.internal.ObjectMapperFactory;
import io.ipgeolocation.sdk.model.Security;
import java.util.Iterator;
import java.util.Map;
import org.junit.jupiter.api.Test;

class SecurityFieldsTest {
  @Test
  void preservesCurrentProxyBotAndGatewayFields() throws Exception {
    String body = "{\"proxy_days_seen_30d\":30,\"proxy_days_seen_7d\":0,"
        + "\"proxy_provider_count_30d\":2,\"bot_confidence_score\":99.5,"
        + "\"bot_operator_name\":\"Example\",\"bot_type\":\"crawler\","
        + "\"is_known_good_bot\":false,\"bot_last_seen\":\"2026-11-03\","
        + "\"is_corporate_gateway\":true,\"corporate_gateway_type\":\"sase\","
        + "\"corporate_gateway_provider_name\":\"Example Gateway\"}";
    ObjectMapper mapper = ObjectMapperFactory.create();
    Security security = mapper.readValue(body, Security.class);
    JsonNode serialized = mapper.valueToTree(security);
    Iterator<Map.Entry<String, JsonNode>> fields = mapper.readTree(body).fields();
    while (fields.hasNext()) {
      Map.Entry<String, JsonNode> field = fields.next();
      assertThat(serialized.get(field.getKey())).as(field.getKey()).isEqualTo(field.getValue());
    }
    assertThat(security.proxyDaysSeen30d()).isEqualTo(30);
    assertThat(security.proxyDaysSeen7d()).isZero();
    assertThat(security.proxyProviderCount30d()).isEqualTo(2);
    assertThat(security.botConfidenceScore()).isEqualTo(99.5);
    assertThat(security.isKnownGoodBot()).isFalse();
    assertThat(security.isCorporateGateway()).isTrue();
  }

  @Test
  void retainsExistingConstructorAndMissingFieldBehavior() throws Exception {
    Security original = new Security(null, null, null, null, null, null, null,
        null, null, null, null, null, null, null, null, null, null, null, null);
    Security parsed = ObjectMapperFactory.create().readValue("{}", Security.class);
    assertThat(parsed).isEqualTo(original).hasSameHashCodeAs(original);
    assertThat(parsed.proxyDaysSeen30d()).isNull();
    assertThat(parsed.botConfidenceScore()).isNull();
    assertThat(parsed.isKnownGoodBot()).isNull();
    assertThat(parsed.isCorporateGateway()).isNull();
  }
}
