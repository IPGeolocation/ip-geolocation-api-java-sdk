package io.ipgeolocation.sdk.model;

import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Geographic and political location data.
 *
 * @param continentCode continent code
 * @param continentName continent name
 * @param countryCode2 ISO alpha-2 country code
 * @param countryCode3 ISO alpha-3 country code
 * @param countryName country name
 * @param countryNameOfficial official country name
 * @param countryCapital country capital city
 * @param stateProv state or province
 * @param stateCode state or province code
 * @param district district name
 * @param city city name
 * @param locality locality name
 * @param accuracyRadius location accuracy radius
 * @param confidence confidence category
 * @param dmaCode DMA code
 * @param zipcode postal code
 * @param latitude latitude value
 * @param longitude longitude value
 * @param isEu true when country is in EU
 * @param countryFlag country flag URL
 * @param geonameId GeoNames identifier
 * @param countryEmoji country emoji
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record Location(
    String continentCode,
    String continentName,
    String countryCode2,
    String countryCode3,
    String countryName,
    String countryNameOfficial,
    String countryCapital,
    String stateProv,
    String stateCode,
    String district,
    String city,
    String locality,
    String accuracyRadius,
    Confidence confidence,
    String dmaCode,
    String zipcode,
    String latitude,
    String longitude,
    @JsonProperty("is_eu") Boolean isEu,
    String countryFlag,
    String geonameId,
    String countryEmoji) {

  /**
   * API confidence category for geolocation precision.
   */
  public enum Confidence {
    @JsonProperty("high")
    HIGH,
    @JsonProperty("medium")
    MEDIUM,
    @JsonProperty("low")
    LOW,
    @JsonEnumDefaultValue
    UNKNOWN
  }
}
