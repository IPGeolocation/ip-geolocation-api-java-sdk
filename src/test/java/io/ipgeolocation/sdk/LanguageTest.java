package io.ipgeolocation.sdk;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class LanguageTest {

  @Test
  void fromCodeIsCaseInsensitive() {
    assertThat(Language.fromCode("EN")).isEqualTo(Language.EN);
    assertThat(Language.fromCode("pT")).isEqualTo(Language.PT);
  }

  @Test
  void fromCodeRejectsUnsupportedLanguage() {
    assertThatThrownBy(() -> Language.fromCode("zz"))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("Unsupported language code: zz");
  }
}
