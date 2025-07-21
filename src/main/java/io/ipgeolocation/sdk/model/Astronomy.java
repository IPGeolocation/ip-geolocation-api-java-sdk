/*
 * IPGeolocation.io - IP intelligence products
 * Ipgeolocation provides a set of APIs to make ip based decisions.
 */


package io.ipgeolocation.sdk.model;

import com.google.gson.*;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.ipgeolocation.sdk.invoker.JSON;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * Astronomy
 */

public class Astronomy {
  public static final String SERIALIZED_NAME_DATE = "date";
  @SerializedName(SERIALIZED_NAME_DATE)
  @javax.annotation.Nullable
  private String date;

  public static final String SERIALIZED_NAME_CURRENT_TIME = "current_time";
  @SerializedName(SERIALIZED_NAME_CURRENT_TIME)
  @javax.annotation.Nullable
  private String currentTime;

  public static final String SERIALIZED_NAME_MID_NIGHT = "mid_night";
  @SerializedName(SERIALIZED_NAME_MID_NIGHT)
  @javax.annotation.Nullable
  private String midNight;

  public static final String SERIALIZED_NAME_NIGHT_END = "night_end";
  @SerializedName(SERIALIZED_NAME_NIGHT_END)
  @javax.annotation.Nullable
  private String nightEnd;

  public static final String SERIALIZED_NAME_MORNING = "morning";
  @SerializedName(SERIALIZED_NAME_MORNING)
  @javax.annotation.Nullable
  private AstronomyMorning morning;

  public static final String SERIALIZED_NAME_SUNRISE = "sunrise";
  @SerializedName(SERIALIZED_NAME_SUNRISE)
  @javax.annotation.Nullable
  private String sunrise;

  public static final String SERIALIZED_NAME_SUNSET = "sunset";
  @SerializedName(SERIALIZED_NAME_SUNSET)
  @javax.annotation.Nullable
  private String sunset;

  public static final String SERIALIZED_NAME_EVENING = "evening";
  @SerializedName(SERIALIZED_NAME_EVENING)
  @javax.annotation.Nullable
  private AstronomyEvening evening;

  public static final String SERIALIZED_NAME_NIGHT_BEGIN = "night_begin";
  @SerializedName(SERIALIZED_NAME_NIGHT_BEGIN)
  @javax.annotation.Nullable
  private String nightBegin;

  public static final String SERIALIZED_NAME_SUN_STATUS = "sun_status";
  @SerializedName(SERIALIZED_NAME_SUN_STATUS)
  @javax.annotation.Nullable
  private String sunStatus;

  public static final String SERIALIZED_NAME_SOLAR_NOON = "solar_noon";
  @SerializedName(SERIALIZED_NAME_SOLAR_NOON)
  @javax.annotation.Nullable
  private String solarNoon;

  public static final String SERIALIZED_NAME_DAY_LENGTH = "day_length";
  @SerializedName(SERIALIZED_NAME_DAY_LENGTH)
  @javax.annotation.Nullable
  private String dayLength;

  public static final String SERIALIZED_NAME_SUN_ALTITUDE = "sun_altitude";
  @SerializedName(SERIALIZED_NAME_SUN_ALTITUDE)
  @javax.annotation.Nullable
  private BigDecimal sunAltitude;

  public static final String SERIALIZED_NAME_SUN_DISTANCE = "sun_distance";
  @SerializedName(SERIALIZED_NAME_SUN_DISTANCE)
  @javax.annotation.Nullable
  private BigDecimal sunDistance;

  public static final String SERIALIZED_NAME_SUN_AZIMUTH = "sun_azimuth";
  @SerializedName(SERIALIZED_NAME_SUN_AZIMUTH)
  @javax.annotation.Nullable
  private BigDecimal sunAzimuth;

  public static final String SERIALIZED_NAME_MOON_PHASE = "moon_phase";
  @SerializedName(SERIALIZED_NAME_MOON_PHASE)
  @javax.annotation.Nullable
  private String moonPhase;

  public static final String SERIALIZED_NAME_MOONRISE = "moonrise";
  @SerializedName(SERIALIZED_NAME_MOONRISE)
  @javax.annotation.Nullable
  private String moonrise;

  public static final String SERIALIZED_NAME_MOONSET = "moonset";
  @SerializedName(SERIALIZED_NAME_MOONSET)
  @javax.annotation.Nullable
  private String moonset;

  public static final String SERIALIZED_NAME_MOON_STATUS = "moon_status";
  @SerializedName(SERIALIZED_NAME_MOON_STATUS)
  @javax.annotation.Nullable
  private String moonStatus;

  public static final String SERIALIZED_NAME_MOON_ALTITUDE = "moon_altitude";
  @SerializedName(SERIALIZED_NAME_MOON_ALTITUDE)
  @javax.annotation.Nullable
  private BigDecimal moonAltitude;

  public static final String SERIALIZED_NAME_MOON_DISTANCE = "moon_distance";
  @SerializedName(SERIALIZED_NAME_MOON_DISTANCE)
  @javax.annotation.Nullable
  private BigDecimal moonDistance;

  public static final String SERIALIZED_NAME_MOON_AZIMUTH = "moon_azimuth";
  @SerializedName(SERIALIZED_NAME_MOON_AZIMUTH)
  @javax.annotation.Nullable
  private BigDecimal moonAzimuth;

  public static final String SERIALIZED_NAME_MOON_PARALLACTIC_ANGLE = "moon_parallactic_angle";
  @SerializedName(SERIALIZED_NAME_MOON_PARALLACTIC_ANGLE)
  @javax.annotation.Nullable
  private BigDecimal moonParallacticAngle;

  public static final String SERIALIZED_NAME_MOON_ILLUMINATION_PERCENTAGE = "moon_illumination_percentage";
  @SerializedName(SERIALIZED_NAME_MOON_ILLUMINATION_PERCENTAGE)
  @javax.annotation.Nullable
  private String moonIlluminationPercentage;

  public static final String SERIALIZED_NAME_MOON_ANGLE = "moon_angle";
  @SerializedName(SERIALIZED_NAME_MOON_ANGLE)
  @javax.annotation.Nullable
  private BigDecimal moonAngle;

  public Astronomy() {
  }

  public Astronomy date(@javax.annotation.Nullable String date) {
    this.date = date;
    return this;
  }

  /**
   * Get date
   * @return date
   */
  @javax.annotation.Nullable
  public String getDate() {
    return date;
  }

  public void setDate(@javax.annotation.Nullable String date) {
    this.date = date;
  }


  public Astronomy currentTime(@javax.annotation.Nullable String currentTime) {
    this.currentTime = currentTime;
    return this;
  }

  /**
   * Get currentTime
   * @return currentTime
   */
  @javax.annotation.Nullable
  public String getCurrentTime() {
    return currentTime;
  }

  public void setCurrentTime(@javax.annotation.Nullable String currentTime) {
    this.currentTime = currentTime;
  }


  public Astronomy midNight(@javax.annotation.Nullable String midNight) {
    this.midNight = midNight;
    return this;
  }

  /**
   * Get midNight
   * @return midNight
   */
  @javax.annotation.Nullable
  public String getMidNight() {
    return midNight;
  }

  public void setMidNight(@javax.annotation.Nullable String midNight) {
    this.midNight = midNight;
  }


  public Astronomy nightEnd(@javax.annotation.Nullable String nightEnd) {
    this.nightEnd = nightEnd;
    return this;
  }

  /**
   * Get nightEnd
   * @return nightEnd
   */
  @javax.annotation.Nullable
  public String getNightEnd() {
    return nightEnd;
  }

  public void setNightEnd(@javax.annotation.Nullable String nightEnd) {
    this.nightEnd = nightEnd;
  }


  public Astronomy morning(@javax.annotation.Nullable AstronomyMorning morning) {
    this.morning = morning;
    return this;
  }

  /**
   * Get morning
   * @return morning
   */
  @javax.annotation.Nullable
  public AstronomyMorning getMorning() {
    return morning;
  }

  public void setMorning(@javax.annotation.Nullable AstronomyMorning morning) {
    this.morning = morning;
  }


  public Astronomy sunrise(@javax.annotation.Nullable String sunrise) {
    this.sunrise = sunrise;
    return this;
  }

  /**
   * Get sunrise
   * @return sunrise
   */
  @javax.annotation.Nullable
  public String getSunrise() {
    return sunrise;
  }

  public void setSunrise(@javax.annotation.Nullable String sunrise) {
    this.sunrise = sunrise;
  }


  public Astronomy sunset(@javax.annotation.Nullable String sunset) {
    this.sunset = sunset;
    return this;
  }

  /**
   * Get sunset
   * @return sunset
   */
  @javax.annotation.Nullable
  public String getSunset() {
    return sunset;
  }

  public void setSunset(@javax.annotation.Nullable String sunset) {
    this.sunset = sunset;
  }


  public Astronomy evening(@javax.annotation.Nullable AstronomyEvening evening) {
    this.evening = evening;
    return this;
  }

  /**
   * Get evening
   * @return evening
   */
  @javax.annotation.Nullable
  public AstronomyEvening getEvening() {
    return evening;
  }

  public void setEvening(@javax.annotation.Nullable AstronomyEvening evening) {
    this.evening = evening;
  }


  public Astronomy nightBegin(@javax.annotation.Nullable String nightBegin) {
    this.nightBegin = nightBegin;
    return this;
  }

  /**
   * Get nightBegin
   * @return nightBegin
   */
  @javax.annotation.Nullable
  public String getNightBegin() {
    return nightBegin;
  }

  public void setNightBegin(@javax.annotation.Nullable String nightBegin) {
    this.nightBegin = nightBegin;
  }


  public Astronomy sunStatus(@javax.annotation.Nullable String sunStatus) {
    this.sunStatus = sunStatus;
    return this;
  }

  /**
   * Get sunStatus
   * @return sunStatus
   */
  @javax.annotation.Nullable
  public String getSunStatus() {
    return sunStatus;
  }

  public void setSunStatus(@javax.annotation.Nullable String sunStatus) {
    this.sunStatus = sunStatus;
  }


  public Astronomy solarNoon(@javax.annotation.Nullable String solarNoon) {
    this.solarNoon = solarNoon;
    return this;
  }

  /**
   * Get solarNoon
   * @return solarNoon
   */
  @javax.annotation.Nullable
  public String getSolarNoon() {
    return solarNoon;
  }

  public void setSolarNoon(@javax.annotation.Nullable String solarNoon) {
    this.solarNoon = solarNoon;
  }


  public Astronomy dayLength(@javax.annotation.Nullable String dayLength) {
    this.dayLength = dayLength;
    return this;
  }

  /**
   * Get dayLength
   * @return dayLength
   */
  @javax.annotation.Nullable
  public String getDayLength() {
    return dayLength;
  }

  public void setDayLength(@javax.annotation.Nullable String dayLength) {
    this.dayLength = dayLength;
  }


  public Astronomy sunAltitude(@javax.annotation.Nullable BigDecimal sunAltitude) {
    this.sunAltitude = sunAltitude;
    return this;
  }

  /**
   * Get sunAltitude
   * @return sunAltitude
   */
  @javax.annotation.Nullable
  public BigDecimal getSunAltitude() {
    return sunAltitude;
  }

  public void setSunAltitude(@javax.annotation.Nullable BigDecimal sunAltitude) {
    this.sunAltitude = sunAltitude;
  }


  public Astronomy sunDistance(@javax.annotation.Nullable BigDecimal sunDistance) {
    this.sunDistance = sunDistance;
    return this;
  }

  /**
   * Get sunDistance
   * @return sunDistance
   */
  @javax.annotation.Nullable
  public BigDecimal getSunDistance() {
    return sunDistance;
  }

  public void setSunDistance(@javax.annotation.Nullable BigDecimal sunDistance) {
    this.sunDistance = sunDistance;
  }


  public Astronomy sunAzimuth(@javax.annotation.Nullable BigDecimal sunAzimuth) {
    this.sunAzimuth = sunAzimuth;
    return this;
  }

  /**
   * Get sunAzimuth
   * @return sunAzimuth
   */
  @javax.annotation.Nullable
  public BigDecimal getSunAzimuth() {
    return sunAzimuth;
  }

  public void setSunAzimuth(@javax.annotation.Nullable BigDecimal sunAzimuth) {
    this.sunAzimuth = sunAzimuth;
  }


  public Astronomy moonPhase(@javax.annotation.Nullable String moonPhase) {
    this.moonPhase = moonPhase;
    return this;
  }

  /**
   * Get moonPhase
   * @return moonPhase
   */
  @javax.annotation.Nullable
  public String getMoonPhase() {
    return moonPhase;
  }

  public void setMoonPhase(@javax.annotation.Nullable String moonPhase) {
    this.moonPhase = moonPhase;
  }


  public Astronomy moonrise(@javax.annotation.Nullable String moonrise) {
    this.moonrise = moonrise;
    return this;
  }

  /**
   * Get moonrise
   * @return moonrise
   */
  @javax.annotation.Nullable
  public String getMoonrise() {
    return moonrise;
  }

  public void setMoonrise(@javax.annotation.Nullable String moonrise) {
    this.moonrise = moonrise;
  }


  public Astronomy moonset(@javax.annotation.Nullable String moonset) {
    this.moonset = moonset;
    return this;
  }

  /**
   * Get moonset
   * @return moonset
   */
  @javax.annotation.Nullable
  public String getMoonset() {
    return moonset;
  }

  public void setMoonset(@javax.annotation.Nullable String moonset) {
    this.moonset = moonset;
  }


  public Astronomy moonStatus(@javax.annotation.Nullable String moonStatus) {
    this.moonStatus = moonStatus;
    return this;
  }

  /**
   * Get moonStatus
   * @return moonStatus
   */
  @javax.annotation.Nullable
  public String getMoonStatus() {
    return moonStatus;
  }

  public void setMoonStatus(@javax.annotation.Nullable String moonStatus) {
    this.moonStatus = moonStatus;
  }


  public Astronomy moonAltitude(@javax.annotation.Nullable BigDecimal moonAltitude) {
    this.moonAltitude = moonAltitude;
    return this;
  }

  /**
   * Get moonAltitude
   * @return moonAltitude
   */
  @javax.annotation.Nullable
  public BigDecimal getMoonAltitude() {
    return moonAltitude;
  }

  public void setMoonAltitude(@javax.annotation.Nullable BigDecimal moonAltitude) {
    this.moonAltitude = moonAltitude;
  }


  public Astronomy moonDistance(@javax.annotation.Nullable BigDecimal moonDistance) {
    this.moonDistance = moonDistance;
    return this;
  }

  /**
   * Get moonDistance
   * @return moonDistance
   */
  @javax.annotation.Nullable
  public BigDecimal getMoonDistance() {
    return moonDistance;
  }

  public void setMoonDistance(@javax.annotation.Nullable BigDecimal moonDistance) {
    this.moonDistance = moonDistance;
  }


  public Astronomy moonAzimuth(@javax.annotation.Nullable BigDecimal moonAzimuth) {
    this.moonAzimuth = moonAzimuth;
    return this;
  }

  /**
   * Get moonAzimuth
   * @return moonAzimuth
   */
  @javax.annotation.Nullable
  public BigDecimal getMoonAzimuth() {
    return moonAzimuth;
  }

  public void setMoonAzimuth(@javax.annotation.Nullable BigDecimal moonAzimuth) {
    this.moonAzimuth = moonAzimuth;
  }


  public Astronomy moonParallacticAngle(@javax.annotation.Nullable BigDecimal moonParallacticAngle) {
    this.moonParallacticAngle = moonParallacticAngle;
    return this;
  }

  /**
   * Get moonParallacticAngle
   * @return moonParallacticAngle
   */
  @javax.annotation.Nullable
  public BigDecimal getMoonParallacticAngle() {
    return moonParallacticAngle;
  }

  public void setMoonParallacticAngle(@javax.annotation.Nullable BigDecimal moonParallacticAngle) {
    this.moonParallacticAngle = moonParallacticAngle;
  }


  public Astronomy moonIlluminationPercentage(@javax.annotation.Nullable String moonIlluminationPercentage) {
    this.moonIlluminationPercentage = moonIlluminationPercentage;
    return this;
  }

  /**
   * Get moonIlluminationPercentage
   * @return moonIlluminationPercentage
   */
  @javax.annotation.Nullable
  public String getMoonIlluminationPercentage() {
    return moonIlluminationPercentage;
  }

  public void setMoonIlluminationPercentage(@javax.annotation.Nullable String moonIlluminationPercentage) {
    this.moonIlluminationPercentage = moonIlluminationPercentage;
  }


  public Astronomy moonAngle(@javax.annotation.Nullable BigDecimal moonAngle) {
    this.moonAngle = moonAngle;
    return this;
  }

  /**
   * Get moonAngle
   * @return moonAngle
   */
  @javax.annotation.Nullable
  public BigDecimal getMoonAngle() {
    return moonAngle;
  }

  public void setMoonAngle(@javax.annotation.Nullable BigDecimal moonAngle) {
    this.moonAngle = moonAngle;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Astronomy astronomy = (Astronomy) o;
    return Objects.equals(this.date, astronomy.date) &&
        Objects.equals(this.currentTime, astronomy.currentTime) &&
        Objects.equals(this.midNight, astronomy.midNight) &&
        Objects.equals(this.nightEnd, astronomy.nightEnd) &&
        Objects.equals(this.morning, astronomy.morning) &&
        Objects.equals(this.sunrise, astronomy.sunrise) &&
        Objects.equals(this.sunset, astronomy.sunset) &&
        Objects.equals(this.evening, astronomy.evening) &&
        Objects.equals(this.nightBegin, astronomy.nightBegin) &&
        Objects.equals(this.sunStatus, astronomy.sunStatus) &&
        Objects.equals(this.solarNoon, astronomy.solarNoon) &&
        Objects.equals(this.dayLength, astronomy.dayLength) &&
        Objects.equals(this.sunAltitude, astronomy.sunAltitude) &&
        Objects.equals(this.sunDistance, astronomy.sunDistance) &&
        Objects.equals(this.sunAzimuth, astronomy.sunAzimuth) &&
        Objects.equals(this.moonPhase, astronomy.moonPhase) &&
        Objects.equals(this.moonrise, astronomy.moonrise) &&
        Objects.equals(this.moonset, astronomy.moonset) &&
        Objects.equals(this.moonStatus, astronomy.moonStatus) &&
        Objects.equals(this.moonAltitude, astronomy.moonAltitude) &&
        Objects.equals(this.moonDistance, astronomy.moonDistance) &&
        Objects.equals(this.moonAzimuth, astronomy.moonAzimuth) &&
        Objects.equals(this.moonParallacticAngle, astronomy.moonParallacticAngle) &&
        Objects.equals(this.moonIlluminationPercentage, astronomy.moonIlluminationPercentage) &&
        Objects.equals(this.moonAngle, astronomy.moonAngle);
  }

  @Override
  public int hashCode() {
    return Objects.hash(date, currentTime, midNight, nightEnd, morning, sunrise, sunset, evening, nightBegin, sunStatus, solarNoon, dayLength, sunAltitude, sunDistance, sunAzimuth, moonPhase, moonrise, moonset, moonStatus, moonAltitude, moonDistance, moonAzimuth, moonParallacticAngle, moonIlluminationPercentage, moonAngle);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Astronomy {\n");
    sb.append("    date: ").append(toIndentedString(date)).append("\n");
    sb.append("    currentTime: ").append(toIndentedString(currentTime)).append("\n");
    sb.append("    midNight: ").append(toIndentedString(midNight)).append("\n");
    sb.append("    nightEnd: ").append(toIndentedString(nightEnd)).append("\n");
    sb.append("    morning: ").append(toIndentedString(morning)).append("\n");
    sb.append("    sunrise: ").append(toIndentedString(sunrise)).append("\n");
    sb.append("    sunset: ").append(toIndentedString(sunset)).append("\n");
    sb.append("    evening: ").append(toIndentedString(evening)).append("\n");
    sb.append("    nightBegin: ").append(toIndentedString(nightBegin)).append("\n");
    sb.append("    sunStatus: ").append(toIndentedString(sunStatus)).append("\n");
    sb.append("    solarNoon: ").append(toIndentedString(solarNoon)).append("\n");
    sb.append("    dayLength: ").append(toIndentedString(dayLength)).append("\n");
    sb.append("    sunAltitude: ").append(toIndentedString(sunAltitude)).append("\n");
    sb.append("    sunDistance: ").append(toIndentedString(sunDistance)).append("\n");
    sb.append("    sunAzimuth: ").append(toIndentedString(sunAzimuth)).append("\n");
    sb.append("    moonPhase: ").append(toIndentedString(moonPhase)).append("\n");
    sb.append("    moonrise: ").append(toIndentedString(moonrise)).append("\n");
    sb.append("    moonset: ").append(toIndentedString(moonset)).append("\n");
    sb.append("    moonStatus: ").append(toIndentedString(moonStatus)).append("\n");
    sb.append("    moonAltitude: ").append(toIndentedString(moonAltitude)).append("\n");
    sb.append("    moonDistance: ").append(toIndentedString(moonDistance)).append("\n");
    sb.append("    moonAzimuth: ").append(toIndentedString(moonAzimuth)).append("\n");
    sb.append("    moonParallacticAngle: ").append(toIndentedString(moonParallacticAngle)).append("\n");
    sb.append("    moonIlluminationPercentage: ").append(toIndentedString(moonIlluminationPercentage)).append("\n");
    sb.append("    moonAngle: ").append(toIndentedString(moonAngle)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }


  public static HashSet<String> ipGeoFields;
  public static HashSet<String> ipGeoRequiredFields;

  static {
    // a set of all properties/fields (JSON key names)
    ipGeoFields = new HashSet<String>();
    ipGeoFields.add("date");
    ipGeoFields.add("current_time");
    ipGeoFields.add("mid_night");
    ipGeoFields.add("night_end");
    ipGeoFields.add("morning");
    ipGeoFields.add("sunrise");
    ipGeoFields.add("sunset");
    ipGeoFields.add("evening");
    ipGeoFields.add("night_begin");
    ipGeoFields.add("sun_status");
    ipGeoFields.add("solar_noon");
    ipGeoFields.add("day_length");
    ipGeoFields.add("sun_altitude");
    ipGeoFields.add("sun_distance");
    ipGeoFields.add("sun_azimuth");
    ipGeoFields.add("moon_phase");
    ipGeoFields.add("moonrise");
    ipGeoFields.add("moonset");
    ipGeoFields.add("moon_status");
    ipGeoFields.add("moon_altitude");
    ipGeoFields.add("moon_distance");
    ipGeoFields.add("moon_azimuth");
    ipGeoFields.add("moon_parallactic_angle");
    ipGeoFields.add("moon_illumination_percentage");
    ipGeoFields.add("moon_angle");

    // a set of required properties/fields (JSON key names)
    ipGeoRequiredFields = new HashSet<String>();
  }

  /**
   * Validates the JSON Element and throws an exception if issues found
   *
   * @param jsonElement JSON Element
   * @throws IOException if the JSON Element is invalid with respect to Astronomy
   */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!Astronomy.ipGeoRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in Astronomy is not found in the empty JSON string", Astronomy.ipGeoRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!Astronomy.ipGeoFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `Astronomy` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
      if ((jsonObj.get("date") != null && !jsonObj.get("date").isJsonNull()) && !jsonObj.get("date").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `date` to be a primitive type in the JSON string but got `%s`", jsonObj.get("date").toString()));
      }
      if ((jsonObj.get("current_time") != null && !jsonObj.get("current_time").isJsonNull()) && !jsonObj.get("current_time").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `current_time` to be a primitive type in the JSON string but got `%s`", jsonObj.get("current_time").toString()));
      }
      if ((jsonObj.get("mid_night") != null && !jsonObj.get("mid_night").isJsonNull()) && !jsonObj.get("mid_night").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `mid_night` to be a primitive type in the JSON string but got `%s`", jsonObj.get("mid_night").toString()));
      }
      if ((jsonObj.get("night_end") != null && !jsonObj.get("night_end").isJsonNull()) && !jsonObj.get("night_end").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `night_end` to be a primitive type in the JSON string but got `%s`", jsonObj.get("night_end").toString()));
      }
      // validate the optional field `morning`
      if (jsonObj.get("morning") != null && !jsonObj.get("morning").isJsonNull()) {
        AstronomyMorning.validateJsonElement(jsonObj.get("morning"));
      }
      if ((jsonObj.get("sunrise") != null && !jsonObj.get("sunrise").isJsonNull()) && !jsonObj.get("sunrise").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `sunrise` to be a primitive type in the JSON string but got `%s`", jsonObj.get("sunrise").toString()));
      }
      if ((jsonObj.get("sunset") != null && !jsonObj.get("sunset").isJsonNull()) && !jsonObj.get("sunset").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `sunset` to be a primitive type in the JSON string but got `%s`", jsonObj.get("sunset").toString()));
      }
      // validate the optional field `evening`
      if (jsonObj.get("evening") != null && !jsonObj.get("evening").isJsonNull()) {
        AstronomyEvening.validateJsonElement(jsonObj.get("evening"));
      }
      if ((jsonObj.get("night_begin") != null && !jsonObj.get("night_begin").isJsonNull()) && !jsonObj.get("night_begin").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `night_begin` to be a primitive type in the JSON string but got `%s`", jsonObj.get("night_begin").toString()));
      }
      if ((jsonObj.get("sun_status") != null && !jsonObj.get("sun_status").isJsonNull()) && !jsonObj.get("sun_status").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `sun_status` to be a primitive type in the JSON string but got `%s`", jsonObj.get("sun_status").toString()));
      }
      if ((jsonObj.get("solar_noon") != null && !jsonObj.get("solar_noon").isJsonNull()) && !jsonObj.get("solar_noon").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `solar_noon` to be a primitive type in the JSON string but got `%s`", jsonObj.get("solar_noon").toString()));
      }
      if ((jsonObj.get("day_length") != null && !jsonObj.get("day_length").isJsonNull()) && !jsonObj.get("day_length").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `day_length` to be a primitive type in the JSON string but got `%s`", jsonObj.get("day_length").toString()));
      }
      if ((jsonObj.get("moon_phase") != null && !jsonObj.get("moon_phase").isJsonNull()) && !jsonObj.get("moon_phase").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `moon_phase` to be a primitive type in the JSON string but got `%s`", jsonObj.get("moon_phase").toString()));
      }
      if ((jsonObj.get("moonrise") != null && !jsonObj.get("moonrise").isJsonNull()) && !jsonObj.get("moonrise").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `moonrise` to be a primitive type in the JSON string but got `%s`", jsonObj.get("moonrise").toString()));
      }
      if ((jsonObj.get("moonset") != null && !jsonObj.get("moonset").isJsonNull()) && !jsonObj.get("moonset").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `moonset` to be a primitive type in the JSON string but got `%s`", jsonObj.get("moonset").toString()));
      }
      if ((jsonObj.get("moon_status") != null && !jsonObj.get("moon_status").isJsonNull()) && !jsonObj.get("moon_status").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `moon_status` to be a primitive type in the JSON string but got `%s`", jsonObj.get("moon_status").toString()));
      }
      if ((jsonObj.get("moon_illumination_percentage") != null && !jsonObj.get("moon_illumination_percentage").isJsonNull()) && !jsonObj.get("moon_illumination_percentage").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `moon_illumination_percentage` to be a primitive type in the JSON string but got `%s`", jsonObj.get("moon_illumination_percentage").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!Astronomy.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'Astronomy' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<Astronomy> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(Astronomy.class));

       return (TypeAdapter<T>) new TypeAdapter<Astronomy>() {
           @Override
           public void write(JsonWriter out, Astronomy value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public Astronomy read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

  /**
   * Create an instance of Astronomy given an JSON string
   *
   * @param jsonString JSON string
   * @return An instance of Astronomy
   * @throws IOException if the JSON string is invalid with respect to Astronomy
   */
  public static Astronomy fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, Astronomy.class);
  }

  /**
   * Convert an instance of Astronomy to an JSON string
   *
   * @return JSON string
   */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

