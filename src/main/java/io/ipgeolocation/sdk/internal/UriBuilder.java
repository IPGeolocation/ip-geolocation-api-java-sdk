package io.ipgeolocation.sdk.internal;

import java.net.URI;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.StringJoiner;

public final class UriBuilder {
  private final String baseUrl;
  private final String path;
  private final Map<String, String> queryParams = new LinkedHashMap<>();

  private UriBuilder(String baseUrl, String path) {
    this.baseUrl = baseUrl;
    this.path = path;
  }

  public static UriBuilder of(String baseUrl, String path) {
    return new UriBuilder(baseUrl, path);
  }

  public UriBuilder queryParam(String name, String value) {
    if (name == null || name.isBlank() || value == null || value.isBlank()) {
      return this;
    }
    queryParams.put(name, value);
    return this;
  }

  public URI build() {
    StringBuilder full = new StringBuilder(baseUrl).append(path);
    if (!queryParams.isEmpty()) {
      StringJoiner joiner = new StringJoiner("&");
      queryParams.forEach((k, v) -> joiner.add(encode(k) + "=" + encode(v)));
      full.append('?').append(joiner);
    }
    return URI.create(full.toString());
  }

  private static String encode(String value) {
    return URLEncoder.encode(value, StandardCharsets.UTF_8).replace("+", "%20");
  }
}
