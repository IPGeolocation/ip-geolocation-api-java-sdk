/*
 * IPGeolocation.io - IP intelligence products
 * Ipgeolocation provides a set of APIs to make ip based decisions.
 */


package io.ipgeolocation.sdk.model;

import java.util.Objects;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import io.ipgeolocation.sdk.invoker.JSON;

/**
 * TimezoneDetailDstEnd
 */

public class TimezoneDetailDstEnd {
  public static final String SERIALIZED_NAME_UTC_TIME = "utc_time";
  @SerializedName(SERIALIZED_NAME_UTC_TIME)
  @javax.annotation.Nullable
  private String utcTime;

  public static final String SERIALIZED_NAME_DURATION = "duration";
  @SerializedName(SERIALIZED_NAME_DURATION)
  @javax.annotation.Nullable
  private String duration;

  public static final String SERIALIZED_NAME_GAP = "gap";
  @SerializedName(SERIALIZED_NAME_GAP)
  @javax.annotation.Nullable
  private Boolean gap;

  public static final String SERIALIZED_NAME_DATE_TIME_AFTER = "date_time_after";
  @SerializedName(SERIALIZED_NAME_DATE_TIME_AFTER)
  @javax.annotation.Nullable
  private String dateTimeAfter;

  public static final String SERIALIZED_NAME_DATE_TIME_BEFORE = "date_time_before";
  @SerializedName(SERIALIZED_NAME_DATE_TIME_BEFORE)
  @javax.annotation.Nullable
  private String dateTimeBefore;

  public static final String SERIALIZED_NAME_OVERLAP = "overlap";
  @SerializedName(SERIALIZED_NAME_OVERLAP)
  @javax.annotation.Nullable
  private Boolean overlap;

  public TimezoneDetailDstEnd() {
  }

  public TimezoneDetailDstEnd utcTime(@javax.annotation.Nullable String utcTime) {
    this.utcTime = utcTime;
    return this;
  }

  /**
   * Get utcTime
   * @return utcTime
   */
  @javax.annotation.Nullable
  public String getUtcTime() {
    return utcTime;
  }

  public void setUtcTime(@javax.annotation.Nullable String utcTime) {
    this.utcTime = utcTime;
  }


  public TimezoneDetailDstEnd duration(@javax.annotation.Nullable String duration) {
    this.duration = duration;
    return this;
  }

  /**
   * Get duration
   * @return duration
   */
  @javax.annotation.Nullable
  public String getDuration() {
    return duration;
  }

  public void setDuration(@javax.annotation.Nullable String duration) {
    this.duration = duration;
  }


  public TimezoneDetailDstEnd gap(@javax.annotation.Nullable Boolean gap) {
    this.gap = gap;
    return this;
  }

  /**
   * Get gap
   * @return gap
   */
  @javax.annotation.Nullable
  public Boolean getGap() {
    return gap;
  }

  public void setGap(@javax.annotation.Nullable Boolean gap) {
    this.gap = gap;
  }


  public TimezoneDetailDstEnd dateTimeAfter(@javax.annotation.Nullable String dateTimeAfter) {
    this.dateTimeAfter = dateTimeAfter;
    return this;
  }

  /**
   * Get dateTimeAfter
   * @return dateTimeAfter
   */
  @javax.annotation.Nullable
  public String getDateTimeAfter() {
    return dateTimeAfter;
  }

  public void setDateTimeAfter(@javax.annotation.Nullable String dateTimeAfter) {
    this.dateTimeAfter = dateTimeAfter;
  }


  public TimezoneDetailDstEnd dateTimeBefore(@javax.annotation.Nullable String dateTimeBefore) {
    this.dateTimeBefore = dateTimeBefore;
    return this;
  }

  /**
   * Get dateTimeBefore
   * @return dateTimeBefore
   */
  @javax.annotation.Nullable
  public String getDateTimeBefore() {
    return dateTimeBefore;
  }

  public void setDateTimeBefore(@javax.annotation.Nullable String dateTimeBefore) {
    this.dateTimeBefore = dateTimeBefore;
  }


  public TimezoneDetailDstEnd overlap(@javax.annotation.Nullable Boolean overlap) {
    this.overlap = overlap;
    return this;
  }

  /**
   * Get overlap
   * @return overlap
   */
  @javax.annotation.Nullable
  public Boolean getOverlap() {
    return overlap;
  }

  public void setOverlap(@javax.annotation.Nullable Boolean overlap) {
    this.overlap = overlap;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TimezoneDetailDstEnd timezoneDetailDstEnd = (TimezoneDetailDstEnd) o;
    return Objects.equals(this.utcTime, timezoneDetailDstEnd.utcTime) &&
        Objects.equals(this.duration, timezoneDetailDstEnd.duration) &&
        Objects.equals(this.gap, timezoneDetailDstEnd.gap) &&
        Objects.equals(this.dateTimeAfter, timezoneDetailDstEnd.dateTimeAfter) &&
        Objects.equals(this.dateTimeBefore, timezoneDetailDstEnd.dateTimeBefore) &&
        Objects.equals(this.overlap, timezoneDetailDstEnd.overlap);
  }

  @Override
  public int hashCode() {
    return Objects.hash(utcTime, duration, gap, dateTimeAfter, dateTimeBefore, overlap);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TimezoneDetailDstEnd {\n");
    sb.append("    utcTime: ").append(toIndentedString(utcTime)).append("\n");
    sb.append("    duration: ").append(toIndentedString(duration)).append("\n");
    sb.append("    gap: ").append(toIndentedString(gap)).append("\n");
    sb.append("    dateTimeAfter: ").append(toIndentedString(dateTimeAfter)).append("\n");
    sb.append("    dateTimeBefore: ").append(toIndentedString(dateTimeBefore)).append("\n");
    sb.append("    overlap: ").append(toIndentedString(overlap)).append("\n");
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
    ipGeoFields.add("utc_time");
    ipGeoFields.add("duration");
    ipGeoFields.add("gap");
    ipGeoFields.add("date_time_after");
    ipGeoFields.add("date_time_before");
    ipGeoFields.add("overlap");

    // a set of required properties/fields (JSON key names)
    ipGeoRequiredFields = new HashSet<String>();
  }

  /**
   * Validates the JSON Element and throws an exception if issues found
   *
   * @param jsonElement JSON Element
   * @throws IOException if the JSON Element is invalid with respect to TimezoneDetailDstEnd
   */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!TimezoneDetailDstEnd.ipGeoRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in TimezoneDetailDstEnd is not found in the empty JSON string", TimezoneDetailDstEnd.ipGeoRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!TimezoneDetailDstEnd.ipGeoFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `TimezoneDetailDstEnd` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
      if ((jsonObj.get("utc_time") != null && !jsonObj.get("utc_time").isJsonNull()) && !jsonObj.get("utc_time").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `utc_time` to be a primitive type in the JSON string but got `%s`", jsonObj.get("utc_time").toString()));
      }
      if ((jsonObj.get("duration") != null && !jsonObj.get("duration").isJsonNull()) && !jsonObj.get("duration").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `duration` to be a primitive type in the JSON string but got `%s`", jsonObj.get("duration").toString()));
      }
      if ((jsonObj.get("date_time_after") != null && !jsonObj.get("date_time_after").isJsonNull()) && !jsonObj.get("date_time_after").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `date_time_after` to be a primitive type in the JSON string but got `%s`", jsonObj.get("date_time_after").toString()));
      }
      if ((jsonObj.get("date_time_before") != null && !jsonObj.get("date_time_before").isJsonNull()) && !jsonObj.get("date_time_before").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `date_time_before` to be a primitive type in the JSON string but got `%s`", jsonObj.get("date_time_before").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!TimezoneDetailDstEnd.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'TimezoneDetailDstEnd' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<TimezoneDetailDstEnd> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(TimezoneDetailDstEnd.class));

       return (TypeAdapter<T>) new TypeAdapter<TimezoneDetailDstEnd>() {
           @Override
           public void write(JsonWriter out, TimezoneDetailDstEnd value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public TimezoneDetailDstEnd read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

  /**
   * Create an instance of TimezoneDetailDstEnd given an JSON string
   *
   * @param jsonString JSON string
   * @return An instance of TimezoneDetailDstEnd
   * @throws IOException if the JSON string is invalid with respect to TimezoneDetailDstEnd
   */
  public static TimezoneDetailDstEnd fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, TimezoneDetailDstEnd.class);
  }

  /**
   * Convert an instance of TimezoneDetailDstEnd to an JSON string
   *
   * @return JSON string
   */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

