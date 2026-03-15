package io.ipgeolocation.sdk.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.ipgeolocation.sdk.TestSupport;
import java.util.Collections;
import java.util.Map;
import org.junit.jupiter.api.Test;

class CompatTest {

  @Test
  void isBlankHandlesNullWhitespaceAndContent() {
    assertThat(Compat.isBlank(null)).isTrue();
    assertThat(Compat.isBlank("   ")).isTrue();
    assertThat(Compat.isBlank("value")).isFalse();
  }

  @Test
  void immutableHelpersHandleNullEmptyAndPopulatedValues() {
    assertThat(Compat.immutableList(null)).isEmpty();
    assertThat(Compat.immutableList(Collections.<String>emptyList())).isEmpty();
    assertThat(Compat.immutableList(TestSupport.list("a"))).containsExactly("a");

    assertThat(Compat.immutableMap(null)).isEmpty();
    assertThat(Compat.immutableMap(Collections.<String, String>emptyMap())).isEmpty();
    assertThat(Compat.immutableMap(Collections.singletonMap("k", "v"))).containsEntry("k", "v");
  }

  @Test
  void immutableMultiMapDropsNullKeysAndNormalizesEmptyValues() {
    Map<String, java.util.List<String>> multiMap =
        new java.util.LinkedHashMap<String, java.util.List<String>>();
    multiMap.put(null, TestSupport.list("skip"));
    multiMap.put("X-Empty", Collections.<String>emptyList());
    multiMap.put("X-Value", TestSupport.list("v"));

    Map<String, java.util.List<String>> normalized = Compat.immutableMultiMap(multiMap);

    assertThat(normalized).doesNotContainKey(null);
    assertThat(normalized).containsEntry("X-Empty", Collections.<String>emptyList());
    assertThat(normalized).containsEntry("X-Value", TestSupport.list("v"));
  }
}
