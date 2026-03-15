package io.ipgeolocation.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.ipgeolocation.sdk.internal.Compat;
import java.util.List;
import java.util.Objects;

/**
 * Country-level metadata returned by the API.
 *
 * <p>This includes the telephone calling code, country top-level domain, and language codes
 * associated with the resolved country.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public final class CountryMetadata {
  private final String callingCode;
  private final String tld;
  private final List<String> languages;

  @JsonCreator
  public CountryMetadata(
      @JsonProperty("calling_code") String callingCode,
      @JsonProperty("tld") String tld,
      @JsonProperty("languages") List<String> languages) {
    this.callingCode = callingCode;
    this.tld = tld;
    this.languages = Compat.immutableList(languages);
  }

  public String callingCode() {
    return callingCode;
  }

  public String tld() {
    return tld;
  }

  public List<String> languages() {
    return languages;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) {
      return true;
    }
    if (!(other instanceof CountryMetadata)) {
      return false;
    }
    CountryMetadata that = (CountryMetadata) other;
    return Objects.equals(callingCode, that.callingCode)
        && Objects.equals(tld, that.tld)
        && Objects.equals(languages, that.languages);
  }

  @Override
  public int hashCode() {
    return Objects.hash(callingCode, tld, languages);
  }

  @Override
  public String toString() {
    return "CountryMetadata{callingCode='"
        + callingCode
        + "', tld='"
        + tld
        + "', languages="
        + languages
        + '}';
  }
}
