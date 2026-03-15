package io.ipgeolocation.sdk.internal;

import static org.assertj.core.api.Assertions.assertThat;
import static io.ipgeolocation.sdk.TestSupport.headers;
import static io.ipgeolocation.sdk.TestSupport.list;

import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

class HttpResponseDataTest {

  @Test
  void normalizesNullBodyAndHeaders() {
    HttpResponseData data = new HttpResponseData(200, null, null);
    assertThat(data.body()).isEmpty();
    assertThat(data.headers()).isEmpty();
  }

  @Test
  void keepsBodyAndDefensivelyCopiesHeaders() {
    Map<String, List<String>> headers = headers("X-Trace-Id", "t-1");
    HttpResponseData data = new HttpResponseData(200, "{\"ok\":true}", headers);

    assertThat(data.body()).isEqualTo("{\"ok\":true}");
    assertThat(data.headers()).containsEntry("X-Trace-Id", list("t-1"));
  }
}
