package io.ipgeolocation.sdk.internal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class Compat {
  private Compat() {}

  public static boolean isBlank(String value) {
    return value == null || value.trim().isEmpty();
  }

  public static <T> List<T> immutableList(List<T> values) {
    if (values == null || values.isEmpty()) {
      return Collections.emptyList();
    }
    return Collections.unmodifiableList(new ArrayList<T>(values));
  }

  public static <K, V> Map<K, V> immutableMap(Map<K, V> values) {
    if (values == null || values.isEmpty()) {
      return Collections.emptyMap();
    }
    return Collections.unmodifiableMap(new LinkedHashMap<K, V>(values));
  }

  public static <K, V> Map<K, List<V>> immutableMultiMap(Map<K, List<V>> values) {
    if (values == null || values.isEmpty()) {
      return Collections.emptyMap();
    }
    Map<K, List<V>> copy = new LinkedHashMap<K, List<V>>(values.size());
    for (Map.Entry<K, List<V>> entry : values.entrySet()) {
      if (entry.getKey() == null) {
        continue;
      }
      copy.put(entry.getKey(), immutableList(entry.getValue()));
    }
    if (copy.isEmpty()) {
      return Collections.emptyMap();
    }
    return Collections.unmodifiableMap(copy);
  }
}
