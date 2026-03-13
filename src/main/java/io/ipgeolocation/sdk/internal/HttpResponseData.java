package io.ipgeolocation.sdk.internal;

import java.util.List;
import java.util.Map;

public record HttpResponseData(int statusCode, String body, Map<String, List<String>> headers) {
  public HttpResponseData {
    body = body == null ? "" : body;
    headers = headers == null ? Map.of() : Map.copyOf(headers);
  }
}
