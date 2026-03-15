package io.ipgeolocation.sdk.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.ipgeolocation.sdk.TestSupport;
import java.net.URI;
import java.time.Duration;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

class HttpRequestDataTest {

  @Test
  void firstHeaderValueIsCaseInsensitiveAndHandlesMissingOrBlankNames() {
    HttpRequestData data =
        new HttpRequestData(
            URI.create("https://api.ipgeolocation.io/v3/ipgeo"),
            "GET",
            TestSupport.headers("X-Test", "value"),
            null,
            Duration.ofSeconds(3));

    assertThat(data.firstHeaderValue("x-test")).isEqualTo("value");
    assertThat(data.firstHeaderValue("Missing")).isNull();
    assertThat(data.firstHeaderValue(" ")).isNull();
  }

  @Test
  void normalizesNullBodyAndHandlesEmptyHeaderLists() {
    Map<String, List<String>> headers = new LinkedHashMap<String, List<String>>();
    headers.put(null, TestSupport.list("ignored"));
    headers.put("X-Empty", Collections.<String>emptyList());
    headers.put("X-Null", null);

    HttpRequestData data =
        new HttpRequestData(
            URI.create("https://api.ipgeolocation.io/v3/ipgeo"),
            "POST",
            headers,
            null,
            Duration.ofSeconds(3));

    assertThat(data.body()).isEmpty();
    assertThat(data.headers()).doesNotContainKey(null);
    assertThat(data.firstHeaderValue("X-Empty")).isNull();
    assertThat(data.firstHeaderValue("X-Null")).isNull();
  }
}
