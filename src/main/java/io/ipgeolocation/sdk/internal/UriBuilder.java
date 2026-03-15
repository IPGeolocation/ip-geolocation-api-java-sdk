package io.ipgeolocation.sdk.internal;

import java.net.URI;
import java.net.URLEncoder;
import java.io.UnsupportedEncodingException;
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
    if (Compat.isBlank(name) || Compat.isBlank(value)) {
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
    return encode(value, "UTF-8");
  }

  static String encode(String value, String charsetName) {
    try {
      return URLEncoder.encode(value, charsetName).replace("+", "%20");
    } catch (UnsupportedEncodingException e) {
      throw new IllegalStateException("UTF-8 must be supported", e);
    }
  }
}
