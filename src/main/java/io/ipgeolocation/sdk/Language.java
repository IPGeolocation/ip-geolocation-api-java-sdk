package io.ipgeolocation.sdk;

import java.util.Arrays;

/**
 * Language codes supported by the IPGeolocation API.
 */
public enum Language {
  EN("en"),
  DE("de"),
  RU("ru"),
  JA("ja"),
  FR("fr"),
  CN("cn"),
  ES("es"),
  CS("cs"),
  IT("it"),
  KO("ko"),
  FA("fa"),
  PT("pt");

  private final String code;

  Language(String code) {
    this.code = code;
  }

  /**
   * @return API language code used in query parameter {@code lang}
   */
  public String code() {
    return code;
  }

  /**
   * Resolves enum value from API language code.
   *
   * @param code language code, case-insensitive
   * @return language enum
   * @throws IllegalArgumentException when code is not supported
   */
  public static Language fromCode(String code) {
    return Arrays.stream(values())
        .filter(v -> v.code.equalsIgnoreCase(code))
        .findFirst()
        .orElseThrow(() -> new IllegalArgumentException("Unsupported language code: " + code));
  }
}
