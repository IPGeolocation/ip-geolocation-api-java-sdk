package io.ipgeolocation.sdk.internal;

import java.net.URI;
import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public final class HttpRequestData {
  private final URI uri;
  private final String method;
  private final Map<String, List<String>> headers;
  private final String body;
  private final Duration timeout;

  public HttpRequestData(
      URI uri, String method, Map<String, List<String>> headers, String body, Duration timeout) {
    this.uri = Objects.requireNonNull(uri, "uri must not be null");
    this.method = Objects.requireNonNull(method, "method must not be null");
    this.headers = Compat.immutableMultiMap(headers);
    this.body = body == null ? "" : body;
    this.timeout = Objects.requireNonNull(timeout, "timeout must not be null");
  }

  public URI uri() {
    return uri;
  }

  public String method() {
    return method;
  }

  public Map<String, List<String>> headers() {
    return headers;
  }

  public String body() {
    return body;
  }

  public Duration timeout() {
    return timeout;
  }

  public String firstHeaderValue(String name) {
    if (Compat.isBlank(name)) {
      return null;
    }
    for (Map.Entry<String, List<String>> entry : headers.entrySet()) {
      if (entry.getKey().equalsIgnoreCase(name)) {
        List<String> values = entry.getValue();
        if (values != null && !values.isEmpty()) {
          return values.get(0);
        }
      }
    }
    return null;
  }
}
