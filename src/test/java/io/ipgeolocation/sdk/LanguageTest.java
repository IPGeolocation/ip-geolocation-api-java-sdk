package io.ipgeolocation.sdk;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Locale;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

class LanguageTest {

  @Test
  void fromCodeIsCaseInsensitive() {
    assertThat(Language.fromCode("EN")).isEqualTo(Language.EN);
    assertThat(Language.fromCode("pT")).isEqualTo(Language.PT);
    assertThat(Language.fromCode("aR")).isEqualTo(Language.AR);
    assertThat(Language.AR.code()).isEqualTo("ar");
  }

  @ParameterizedTest
  @EnumSource(Language.class)
  void everyLanguageRetainsItsWireCode(Language language) {
    assertThat(language.code()).isEqualTo(language.name().toLowerCase(Locale.ROOT));
    assertThat(Language.fromCode(language.code())).isEqualTo(language);
  }

  @Test
  void fromCodeRejectsUnsupportedLanguage() {
    assertThatThrownBy(() -> Language.fromCode("zz"))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("Unsupported language code: zz");
    assertThatThrownBy(() -> Language.fromCode(null)).isInstanceOf(IllegalArgumentException.class);
    assertThatThrownBy(() -> Language.fromCode("")).isInstanceOf(IllegalArgumentException.class);
  }
}
