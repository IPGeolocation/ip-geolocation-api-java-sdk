package io.ipgeolocation.sdk;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class TestSupport {
  private TestSupport() {}

  @SafeVarargs
  public static <T> List<T> list(T... values) {
    if (values == null || values.length == 0) {
      return Collections.emptyList();
    }
    return Arrays.asList(values);
  }

  public static Map<String, List<String>> headers(String... keyValues) {
    if (keyValues == null || keyValues.length == 0) {
      return Collections.emptyMap();
    }
    if (keyValues.length % 2 != 0) {
      throw new IllegalArgumentException("headers requires an even number of key/value arguments");
    }
    Map<String, List<String>> headers = new LinkedHashMap<String, List<String>>();
    for (int i = 0; i < keyValues.length; i += 2) {
      headers.put(keyValues[i], Collections.singletonList(keyValues[i + 1]));
    }
    return headers;
  }

  public static boolean isBlank(String value) {
    return value == null || value.trim().isEmpty();
  }
}
