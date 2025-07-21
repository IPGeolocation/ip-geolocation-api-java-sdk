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
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * AstronomyMorning
 */

public class AstronomyMorning {
  public static final String SERIALIZED_NAME_ASTRONOMICAL_TWILIGHT_BEGIN = "astronomical_twilight_begin";
  @SerializedName(SERIALIZED_NAME_ASTRONOMICAL_TWILIGHT_BEGIN)
  @javax.annotation.Nullable
  private String astronomicalTwilightBegin;

  public static final String SERIALIZED_NAME_ASTRONOMICAL_TWILIGHT_END = "astronomical_twilight_end";
  @SerializedName(SERIALIZED_NAME_ASTRONOMICAL_TWILIGHT_END)
  @javax.annotation.Nullable
  private String astronomicalTwilightEnd;

  public static final String SERIALIZED_NAME_NAUTICAL_TWILIGHT_BEGIN = "nautical_twilight_begin";
  @SerializedName(SERIALIZED_NAME_NAUTICAL_TWILIGHT_BEGIN)
  @javax.annotation.Nullable
  private String nauticalTwilightBegin;

  public static final String SERIALIZED_NAME_NAUTICAL_TWILIGHT_END = "nautical_twilight_end";
  @SerializedName(SERIALIZED_NAME_NAUTICAL_TWILIGHT_END)
  @javax.annotation.Nullable
  private String nauticalTwilightEnd;

  public static final String SERIALIZED_NAME_CIVIL_TWILIGHT_BEGIN = "civil_twilight_begin";
  @SerializedName(SERIALIZED_NAME_CIVIL_TWILIGHT_BEGIN)
  @javax.annotation.Nullable
  private String civilTwilightBegin;

  public static final String SERIALIZED_NAME_CIVIL_TWILIGHT_END = "civil_twilight_end";
  @SerializedName(SERIALIZED_NAME_CIVIL_TWILIGHT_END)
  @javax.annotation.Nullable
  private String civilTwilightEnd;

  public static final String SERIALIZED_NAME_BLUE_HOUR_BEGIN = "blue_hour_begin";
  @SerializedName(SERIALIZED_NAME_BLUE_HOUR_BEGIN)
  @javax.annotation.Nullable
  private String blueHourBegin;

  public static final String SERIALIZED_NAME_BLUE_HOUR_END = "blue_hour_end";
  @SerializedName(SERIALIZED_NAME_BLUE_HOUR_END)
  @javax.annotation.Nullable
  private String blueHourEnd;

  public static final String SERIALIZED_NAME_GOLDEN_HOUR_BEGIN = "golden_hour_begin";
  @SerializedName(SERIALIZED_NAME_GOLDEN_HOUR_BEGIN)
  @javax.annotation.Nullable
  private String goldenHourBegin;

  public static final String SERIALIZED_NAME_GOLDEN_HOUR_END = "golden_hour_end";
  @SerializedName(SERIALIZED_NAME_GOLDEN_HOUR_END)
  @javax.annotation.Nullable
  private String goldenHourEnd;

  public AstronomyMorning() {
  }

  public AstronomyMorning astronomicalTwilightBegin(@javax.annotation.Nullable String astronomicalTwilightBegin) {
    this.astronomicalTwilightBegin = astronomicalTwilightBegin;
    return this;
  }

  /**
   * Get astronomicalTwilightBegin
   * @return astronomicalTwilightBegin
   */
  @javax.annotation.Nullable
  public String getAstronomicalTwilightBegin() {
    return astronomicalTwilightBegin;
  }

  public void setAstronomicalTwilightBegin(@javax.annotation.Nullable String astronomicalTwilightBegin) {
    this.astronomicalTwilightBegin = astronomicalTwilightBegin;
  }


  public AstronomyMorning astronomicalTwilightEnd(@javax.annotation.Nullable String astronomicalTwilightEnd) {
    this.astronomicalTwilightEnd = astronomicalTwilightEnd;
    return this;
  }

  /**
   * Get astronomicalTwilightEnd
   * @return astronomicalTwilightEnd
   */
  @javax.annotation.Nullable
  public String getAstronomicalTwilightEnd() {
    return astronomicalTwilightEnd;
  }

  public void setAstronomicalTwilightEnd(@javax.annotation.Nullable String astronomicalTwilightEnd) {
    this.astronomicalTwilightEnd = astronomicalTwilightEnd;
  }


  public AstronomyMorning nauticalTwilightBegin(@javax.annotation.Nullable String nauticalTwilightBegin) {
    this.nauticalTwilightBegin = nauticalTwilightBegin;
    return this;
  }

  /**
   * Get nauticalTwilightBegin
   * @return nauticalTwilightBegin
   */
  @javax.annotation.Nullable
  public String getNauticalTwilightBegin() {
    return nauticalTwilightBegin;
  }

  public void setNauticalTwilightBegin(@javax.annotation.Nullable String nauticalTwilightBegin) {
    this.nauticalTwilightBegin = nauticalTwilightBegin;
  }


  public AstronomyMorning nauticalTwilightEnd(@javax.annotation.Nullable String nauticalTwilightEnd) {
    this.nauticalTwilightEnd = nauticalTwilightEnd;
    return this;
  }

  /**
   * Get nauticalTwilightEnd
   * @return nauticalTwilightEnd
   */
  @javax.annotation.Nullable
  public String getNauticalTwilightEnd() {
    return nauticalTwilightEnd;
  }

  public void setNauticalTwilightEnd(@javax.annotation.Nullable String nauticalTwilightEnd) {
    this.nauticalTwilightEnd = nauticalTwilightEnd;
  }


  public AstronomyMorning civilTwilightBegin(@javax.annotation.Nullable String civilTwilightBegin) {
    this.civilTwilightBegin = civilTwilightBegin;
    return this;
  }

  /**
   * Get civilTwilightBegin
   * @return civilTwilightBegin
   */
  @javax.annotation.Nullable
  public String getCivilTwilightBegin() {
    return civilTwilightBegin;
  }

  public void setCivilTwilightBegin(@javax.annotation.Nullable String civilTwilightBegin) {
    this.civilTwilightBegin = civilTwilightBegin;
  }


  public AstronomyMorning civilTwilightEnd(@javax.annotation.Nullable String civilTwilightEnd) {
    this.civilTwilightEnd = civilTwilightEnd;
    return this;
  }

  /**
   * Get civilTwilightEnd
   * @return civilTwilightEnd
   */
  @javax.annotation.Nullable
  public String getCivilTwilightEnd() {
    return civilTwilightEnd;
  }

  public void setCivilTwilightEnd(@javax.annotation.Nullable String civilTwilightEnd) {
    this.civilTwilightEnd = civilTwilightEnd;
  }


  public AstronomyMorning blueHourBegin(@javax.annotation.Nullable String blueHourBegin) {
    this.blueHourBegin = blueHourBegin;
    return this;
  }

  /**
   * Get blueHourBegin
   * @return blueHourBegin
   */
  @javax.annotation.Nullable
  public String getBlueHourBegin() {
    return blueHourBegin;
  }

  public void setBlueHourBegin(@javax.annotation.Nullable String blueHourBegin) {
    this.blueHourBegin = blueHourBegin;
  }


  public AstronomyMorning blueHourEnd(@javax.annotation.Nullable String blueHourEnd) {
    this.blueHourEnd = blueHourEnd;
    return this;
  }

  /**
   * Get blueHourEnd
   * @return blueHourEnd
   */
  @javax.annotation.Nullable
  public String getBlueHourEnd() {
    return blueHourEnd;
  }

  public void setBlueHourEnd(@javax.annotation.Nullable String blueHourEnd) {
    this.blueHourEnd = blueHourEnd;
  }


  public AstronomyMorning goldenHourBegin(@javax.annotation.Nullable String goldenHourBegin) {
    this.goldenHourBegin = goldenHourBegin;
    return this;
  }

  /**
   * Get goldenHourBegin
   * @return goldenHourBegin
   */
  @javax.annotation.Nullable
  public String getGoldenHourBegin() {
    return goldenHourBegin;
  }

  public void setGoldenHourBegin(@javax.annotation.Nullable String goldenHourBegin) {
    this.goldenHourBegin = goldenHourBegin;
  }


  public AstronomyMorning goldenHourEnd(@javax.annotation.Nullable String goldenHourEnd) {
    this.goldenHourEnd = goldenHourEnd;
    return this;
  }

  /**
   * Get goldenHourEnd
   * @return goldenHourEnd
   */
  @javax.annotation.Nullable
  public String getGoldenHourEnd() {
    return goldenHourEnd;
  }

  public void setGoldenHourEnd(@javax.annotation.Nullable String goldenHourEnd) {
    this.goldenHourEnd = goldenHourEnd;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AstronomyMorning astronomyMorning = (AstronomyMorning) o;
    return Objects.equals(this.astronomicalTwilightBegin, astronomyMorning.astronomicalTwilightBegin) &&
        Objects.equals(this.astronomicalTwilightEnd, astronomyMorning.astronomicalTwilightEnd) &&
        Objects.equals(this.nauticalTwilightBegin, astronomyMorning.nauticalTwilightBegin) &&
        Objects.equals(this.nauticalTwilightEnd, astronomyMorning.nauticalTwilightEnd) &&
        Objects.equals(this.civilTwilightBegin, astronomyMorning.civilTwilightBegin) &&
        Objects.equals(this.civilTwilightEnd, astronomyMorning.civilTwilightEnd) &&
        Objects.equals(this.blueHourBegin, astronomyMorning.blueHourBegin) &&
        Objects.equals(this.blueHourEnd, astronomyMorning.blueHourEnd) &&
        Objects.equals(this.goldenHourBegin, astronomyMorning.goldenHourBegin) &&
        Objects.equals(this.goldenHourEnd, astronomyMorning.goldenHourEnd);
  }

  @Override
  public int hashCode() {
    return Objects.hash(astronomicalTwilightBegin, astronomicalTwilightEnd, nauticalTwilightBegin, nauticalTwilightEnd, civilTwilightBegin, civilTwilightEnd, blueHourBegin, blueHourEnd, goldenHourBegin, goldenHourEnd);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AstronomyMorning {\n");
    sb.append("    astronomicalTwilightBegin: ").append(toIndentedString(astronomicalTwilightBegin)).append("\n");
    sb.append("    astronomicalTwilightEnd: ").append(toIndentedString(astronomicalTwilightEnd)).append("\n");
    sb.append("    nauticalTwilightBegin: ").append(toIndentedString(nauticalTwilightBegin)).append("\n");
    sb.append("    nauticalTwilightEnd: ").append(toIndentedString(nauticalTwilightEnd)).append("\n");
    sb.append("    civilTwilightBegin: ").append(toIndentedString(civilTwilightBegin)).append("\n");
    sb.append("    civilTwilightEnd: ").append(toIndentedString(civilTwilightEnd)).append("\n");
    sb.append("    blueHourBegin: ").append(toIndentedString(blueHourBegin)).append("\n");
    sb.append("    blueHourEnd: ").append(toIndentedString(blueHourEnd)).append("\n");
    sb.append("    goldenHourBegin: ").append(toIndentedString(goldenHourBegin)).append("\n");
    sb.append("    goldenHourEnd: ").append(toIndentedString(goldenHourEnd)).append("\n");
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
    ipGeoFields.add("astronomical_twilight_begin");
    ipGeoFields.add("astronomical_twilight_end");
    ipGeoFields.add("nautical_twilight_begin");
    ipGeoFields.add("nautical_twilight_end");
    ipGeoFields.add("civil_twilight_begin");
    ipGeoFields.add("civil_twilight_end");
    ipGeoFields.add("blue_hour_begin");
    ipGeoFields.add("blue_hour_end");
    ipGeoFields.add("golden_hour_begin");
    ipGeoFields.add("golden_hour_end");

    // a set of required properties/fields (JSON key names)
    ipGeoRequiredFields = new HashSet<String>();
  }

  /**
   * Validates the JSON Element and throws an exception if issues found
   *
   * @param jsonElement JSON Element
   * @throws IOException if the JSON Element is invalid with respect to AstronomyMorning
   */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!AstronomyMorning.ipGeoRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in AstronomyMorning is not found in the empty JSON string", AstronomyMorning.ipGeoRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!AstronomyMorning.ipGeoFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `AstronomyMorning` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
      if ((jsonObj.get("astronomical_twilight_begin") != null && !jsonObj.get("astronomical_twilight_begin").isJsonNull()) && !jsonObj.get("astronomical_twilight_begin").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `astronomical_twilight_begin` to be a primitive type in the JSON string but got `%s`", jsonObj.get("astronomical_twilight_begin").toString()));
      }
      if ((jsonObj.get("astronomical_twilight_end") != null && !jsonObj.get("astronomical_twilight_end").isJsonNull()) && !jsonObj.get("astronomical_twilight_end").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `astronomical_twilight_end` to be a primitive type in the JSON string but got `%s`", jsonObj.get("astronomical_twilight_end").toString()));
      }
      if ((jsonObj.get("nautical_twilight_begin") != null && !jsonObj.get("nautical_twilight_begin").isJsonNull()) && !jsonObj.get("nautical_twilight_begin").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `nautical_twilight_begin` to be a primitive type in the JSON string but got `%s`", jsonObj.get("nautical_twilight_begin").toString()));
      }
      if ((jsonObj.get("nautical_twilight_end") != null && !jsonObj.get("nautical_twilight_end").isJsonNull()) && !jsonObj.get("nautical_twilight_end").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `nautical_twilight_end` to be a primitive type in the JSON string but got `%s`", jsonObj.get("nautical_twilight_end").toString()));
      }
      if ((jsonObj.get("civil_twilight_begin") != null && !jsonObj.get("civil_twilight_begin").isJsonNull()) && !jsonObj.get("civil_twilight_begin").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `civil_twilight_begin` to be a primitive type in the JSON string but got `%s`", jsonObj.get("civil_twilight_begin").toString()));
      }
      if ((jsonObj.get("civil_twilight_end") != null && !jsonObj.get("civil_twilight_end").isJsonNull()) && !jsonObj.get("civil_twilight_end").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `civil_twilight_end` to be a primitive type in the JSON string but got `%s`", jsonObj.get("civil_twilight_end").toString()));
      }
      if ((jsonObj.get("blue_hour_begin") != null && !jsonObj.get("blue_hour_begin").isJsonNull()) && !jsonObj.get("blue_hour_begin").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `blue_hour_begin` to be a primitive type in the JSON string but got `%s`", jsonObj.get("blue_hour_begin").toString()));
      }
      if ((jsonObj.get("blue_hour_end") != null && !jsonObj.get("blue_hour_end").isJsonNull()) && !jsonObj.get("blue_hour_end").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `blue_hour_end` to be a primitive type in the JSON string but got `%s`", jsonObj.get("blue_hour_end").toString()));
      }
      if ((jsonObj.get("golden_hour_begin") != null && !jsonObj.get("golden_hour_begin").isJsonNull()) && !jsonObj.get("golden_hour_begin").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `golden_hour_begin` to be a primitive type in the JSON string but got `%s`", jsonObj.get("golden_hour_begin").toString()));
      }
      if ((jsonObj.get("golden_hour_end") != null && !jsonObj.get("golden_hour_end").isJsonNull()) && !jsonObj.get("golden_hour_end").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `golden_hour_end` to be a primitive type in the JSON string but got `%s`", jsonObj.get("golden_hour_end").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!AstronomyMorning.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'AstronomyMorning' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<AstronomyMorning> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(AstronomyMorning.class));

       return (TypeAdapter<T>) new TypeAdapter<AstronomyMorning>() {
           @Override
           public void write(JsonWriter out, AstronomyMorning value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public AstronomyMorning read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

  /**
   * Create an instance of AstronomyMorning given an JSON string
   *
   * @param jsonString JSON string
   * @return An instance of AstronomyMorning
   * @throws IOException if the JSON string is invalid with respect to AstronomyMorning
   */
  public static AstronomyMorning fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, AstronomyMorning.class);
  }

  /**
   * Convert an instance of AstronomyMorning to an JSON string
   *
   * @return JSON string
   */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

