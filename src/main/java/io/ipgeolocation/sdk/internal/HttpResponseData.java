package io.ipgeolocation.sdk.internal;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public final class HttpResponseData {
  private final int statusCode;
  private final String body;
  private final Map<String, List<String>> headers;

  public HttpResponseData(int statusCode, String body, Map<String, List<String>> headers) {
    this.statusCode = statusCode;
    this.body = body == null ? "" : body;
    this.headers = Compat.immutableMultiMap(headers);
  }

  public int statusCode() {
    return statusCode;
  }

  public String body() {
    return body;
  }

  public Map<String, List<String>> headers() {
    return headers;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) {
      return true;
    }
    if (!(other instanceof HttpResponseData)) {
      return false;
    }
    HttpResponseData that = (HttpResponseData) other;
    return statusCode == that.statusCode
        && Objects.equals(body, that.body)
        && Objects.equals(headers, that.headers);
  }

  @Override
  public int hashCode() {
    return Objects.hash(statusCode, body, headers);
  }

  @Override
  public String toString() {
    return "HttpResponseData{statusCode=" + statusCode + ", body='" + body + "', headers=" + headers + '}';
  }
}
