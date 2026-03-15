package io.ipgeolocation.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * Geographic and political location data.
 *
 * <p>This model includes standard country, state, city, and coordinate fields. When
 * {@code include=geo_accuracy} is requested and supported by the plan, the API can also return
 * finer-grained fields such as {@code locality}, {@code accuracy_radius}, and
 * {@code confidence}. When {@code include=dma_code} is requested, {@code dma_code} may also be
 * returned.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public final class Location {
  private final String continentCode;
  private final String continentName;
  private final String countryCode2;
  private final String countryCode3;
  private final String countryName;
  private final String countryNameOfficial;
  private final String countryCapital;
  private final String stateProv;
  private final String stateCode;
  private final String district;
  private final String city;
  private final String locality;
  private final String accuracyRadius;
  private final Confidence confidence;
  private final String dmaCode;
  private final String zipcode;
  private final String latitude;
  private final String longitude;
  private final Boolean isEu;
  private final String countryFlag;
  private final String geonameId;
  private final String countryEmoji;

  @JsonCreator
  public Location(
      @JsonProperty("continent_code") String continentCode,
      @JsonProperty("continent_name") String continentName,
      @JsonProperty("country_code2") String countryCode2,
      @JsonProperty("country_code3") String countryCode3,
      @JsonProperty("country_name") String countryName,
      @JsonProperty("country_name_official") String countryNameOfficial,
      @JsonProperty("country_capital") String countryCapital,
      @JsonProperty("state_prov") String stateProv,
      @JsonProperty("state_code") String stateCode,
      @JsonProperty("district") String district,
      @JsonProperty("city") String city,
      @JsonProperty("locality") String locality,
      @JsonProperty("accuracy_radius") String accuracyRadius,
      @JsonProperty("confidence") Confidence confidence,
      @JsonProperty("dma_code") String dmaCode,
      @JsonProperty("zipcode") String zipcode,
      @JsonProperty("latitude") String latitude,
      @JsonProperty("longitude") String longitude,
      @JsonProperty("is_eu") Boolean isEu,
      @JsonProperty("country_flag") String countryFlag,
      @JsonProperty("geoname_id") String geonameId,
      @JsonProperty("country_emoji") String countryEmoji) {
    this.continentCode = continentCode;
    this.continentName = continentName;
    this.countryCode2 = countryCode2;
    this.countryCode3 = countryCode3;
    this.countryName = countryName;
    this.countryNameOfficial = countryNameOfficial;
    this.countryCapital = countryCapital;
    this.stateProv = stateProv;
    this.stateCode = stateCode;
    this.district = district;
    this.city = city;
    this.locality = locality;
    this.accuracyRadius = accuracyRadius;
    this.confidence = confidence;
    this.dmaCode = dmaCode;
    this.zipcode = zipcode;
    this.latitude = latitude;
    this.longitude = longitude;
    this.isEu = isEu;
    this.countryFlag = countryFlag;
    this.geonameId = geonameId;
    this.countryEmoji = countryEmoji;
  }

  public String continentCode() { return continentCode; }
  public String continentName() { return continentName; }
  public String countryCode2() { return countryCode2; }
  public String countryCode3() { return countryCode3; }
  public String countryName() { return countryName; }
  public String countryNameOfficial() { return countryNameOfficial; }
  public String countryCapital() { return countryCapital; }
  public String stateProv() { return stateProv; }
  public String stateCode() { return stateCode; }
  public String district() { return district; }
  public String city() { return city; }
  /**
   * @return smaller area within the city, such as a neighborhood or suburb; may match {@code city}
   */
  public String locality() { return locality; }

  /**
   * @return estimated accuracy radius in kilometers as a numeric string around {@code latitude}
   *     and {@code longitude}
   */
  public String accuracyRadius() { return accuracyRadius; }
  public Confidence confidence() { return confidence; }
  public String dmaCode() { return dmaCode; }
  public String zipcode() { return zipcode; }
  public String latitude() { return latitude; }
  public String longitude() { return longitude; }
  public Boolean isEu() { return isEu; }
  public String countryFlag() { return countryFlag; }
  public String geonameId() { return geonameId; }
  public String countryEmoji() { return countryEmoji; }

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

  @Override
  public boolean equals(Object other) {
    if (this == other) {
      return true;
    }
    if (!(other instanceof Location)) {
      return false;
    }
    Location that = (Location) other;
    return Objects.equals(continentCode, that.continentCode)
        && Objects.equals(continentName, that.continentName)
        && Objects.equals(countryCode2, that.countryCode2)
        && Objects.equals(countryCode3, that.countryCode3)
        && Objects.equals(countryName, that.countryName)
        && Objects.equals(countryNameOfficial, that.countryNameOfficial)
        && Objects.equals(countryCapital, that.countryCapital)
        && Objects.equals(stateProv, that.stateProv)
        && Objects.equals(stateCode, that.stateCode)
        && Objects.equals(district, that.district)
        && Objects.equals(city, that.city)
        && Objects.equals(locality, that.locality)
        && Objects.equals(accuracyRadius, that.accuracyRadius)
        && Objects.equals(confidence, that.confidence)
        && Objects.equals(dmaCode, that.dmaCode)
        && Objects.equals(zipcode, that.zipcode)
        && Objects.equals(latitude, that.latitude)
        && Objects.equals(longitude, that.longitude)
        && Objects.equals(isEu, that.isEu)
        && Objects.equals(countryFlag, that.countryFlag)
        && Objects.equals(geonameId, that.geonameId)
        && Objects.equals(countryEmoji, that.countryEmoji);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        continentCode,
        continentName,
        countryCode2,
        countryCode3,
        countryName,
        countryNameOfficial,
        countryCapital,
        stateProv,
        stateCode,
        district,
        city,
        locality,
        accuracyRadius,
        confidence,
        dmaCode,
        zipcode,
        latitude,
        longitude,
        isEu,
        countryFlag,
        geonameId,
        countryEmoji);
  }

  @Override
  public String toString() {
    return "Location{continentCode='"
        + continentCode
        + "', continentName='"
        + continentName
        + "', countryCode2='"
        + countryCode2
        + "', countryCode3='"
        + countryCode3
        + "', countryName='"
        + countryName
        + "', countryNameOfficial='"
        + countryNameOfficial
        + "', countryCapital='"
        + countryCapital
        + "', stateProv='"
        + stateProv
        + "', stateCode='"
        + stateCode
        + "', district='"
        + district
        + "', city='"
        + city
        + "', locality='"
        + locality
        + "', accuracyRadius='"
        + accuracyRadius
        + "', confidence="
        + confidence
        + ", dmaCode='"
        + dmaCode
        + "', zipcode='"
        + zipcode
        + "', latitude='"
        + latitude
        + "', longitude='"
        + longitude
        + "', isEu="
        + isEu
        + ", countryFlag='"
        + countryFlag
        + "', geonameId='"
        + geonameId
        + "', countryEmoji='"
        + countryEmoji
        + "'}";
  }
}
