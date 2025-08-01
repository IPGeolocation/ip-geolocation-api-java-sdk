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
import java.math.BigDecimal;

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
 * TimeZone
 */

public class TimeZone {
  public static final String SERIALIZED_NAME_NAME = "name";
  @SerializedName(SERIALIZED_NAME_NAME)
  @javax.annotation.Nullable
  private String name;

  public static final String SERIALIZED_NAME_OFFSET = "offset";
  @SerializedName(SERIALIZED_NAME_OFFSET)
  @javax.annotation.Nullable
  private Integer offset;

  public static final String SERIALIZED_NAME_OFFSET_WITH_DST = "offset_with_dst";
  @SerializedName(SERIALIZED_NAME_OFFSET_WITH_DST)
  @javax.annotation.Nullable
  private Integer offsetWithDst;

  public static final String SERIALIZED_NAME_CURRENT_TIME = "current_time";
  @SerializedName(SERIALIZED_NAME_CURRENT_TIME)
  @javax.annotation.Nullable
  private String currentTime;

  public static final String SERIALIZED_NAME_CURRENT_TIME_UNIX = "current_time_unix";
  @SerializedName(SERIALIZED_NAME_CURRENT_TIME_UNIX)
  @javax.annotation.Nullable
  private BigDecimal currentTimeUnix;

  public static final String SERIALIZED_NAME_IS_DST = "is_dst";
  @SerializedName(SERIALIZED_NAME_IS_DST)
  @javax.annotation.Nullable
  private Boolean isDst;

  public static final String SERIALIZED_NAME_DST_SAVINGS = "dst_savings";
  @SerializedName(SERIALIZED_NAME_DST_SAVINGS)
  @javax.annotation.Nullable
  private Integer dstSavings;

  public static final String SERIALIZED_NAME_DST_EXISTS = "dst_exists";
  @SerializedName(SERIALIZED_NAME_DST_EXISTS)
  @javax.annotation.Nullable
  private Boolean dstExists;

  public static final String SERIALIZED_NAME_DST_START = "dst_start";
  @SerializedName(SERIALIZED_NAME_DST_START)
  @javax.annotation.Nullable
  private TimezoneDstStart dstStart;

  public static final String SERIALIZED_NAME_DST_END = "dst_end";
  @SerializedName(SERIALIZED_NAME_DST_END)
  @javax.annotation.Nullable
  private TimezoneDstEnd dstEnd;

  public TimeZone() {
  }

  public TimeZone name(@javax.annotation.Nullable String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
   */
  @javax.annotation.Nullable
  public String getName() {
    return name;
  }

  public void setName(@javax.annotation.Nullable String name) {
    this.name = name;
  }


  public TimeZone offset(@javax.annotation.Nullable Integer offset) {
    this.offset = offset;
    return this;
  }

  /**
   * Get offset
   * @return offset
   */
  @javax.annotation.Nullable
  public Integer getOffset() {
    return offset;
  }

  public void setOffset(@javax.annotation.Nullable Integer offset) {
    this.offset = offset;
  }


  public TimeZone offsetWithDst(@javax.annotation.Nullable Integer offsetWithDst) {
    this.offsetWithDst = offsetWithDst;
    return this;
  }

  /**
   * Get offsetWithDst
   * @return offsetWithDst
   */
  @javax.annotation.Nullable
  public Integer getOffsetWithDst() {
    return offsetWithDst;
  }

  public void setOffsetWithDst(@javax.annotation.Nullable Integer offsetWithDst) {
    this.offsetWithDst = offsetWithDst;
  }


  public TimeZone currentTime(@javax.annotation.Nullable String currentTime) {
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


  public TimeZone currentTimeUnix(@javax.annotation.Nullable BigDecimal currentTimeUnix) {
    this.currentTimeUnix = currentTimeUnix;
    return this;
  }

  /**
   * Get currentTimeUnix
   * @return currentTimeUnix
   */
  @javax.annotation.Nullable
  public BigDecimal getCurrentTimeUnix() {
    return currentTimeUnix;
  }

  public void setCurrentTimeUnix(@javax.annotation.Nullable BigDecimal currentTimeUnix) {
    this.currentTimeUnix = currentTimeUnix;
  }


  public TimeZone isDst(@javax.annotation.Nullable Boolean isDst) {
    this.isDst = isDst;
    return this;
  }

  /**
   * Get isDst
   * @return isDst
   */
  @javax.annotation.Nullable
  public Boolean getIsDst() {
    return isDst;
  }

  public void setIsDst(@javax.annotation.Nullable Boolean isDst) {
    this.isDst = isDst;
  }


  public TimeZone dstSavings(@javax.annotation.Nullable Integer dstSavings) {
    this.dstSavings = dstSavings;
    return this;
  }

  /**
   * Get dstSavings
   * @return dstSavings
   */
  @javax.annotation.Nullable
  public Integer getDstSavings() {
    return dstSavings;
  }

  public void setDstSavings(@javax.annotation.Nullable Integer dstSavings) {
    this.dstSavings = dstSavings;
  }


  public TimeZone dstExists(@javax.annotation.Nullable Boolean dstExists) {
    this.dstExists = dstExists;
    return this;
  }

  /**
   * Get dstExists
   * @return dstExists
   */
  @javax.annotation.Nullable
  public Boolean getDstExists() {
    return dstExists;
  }

  public void setDstExists(@javax.annotation.Nullable Boolean dstExists) {
    this.dstExists = dstExists;
  }


  public TimeZone dstStart(@javax.annotation.Nullable TimezoneDstStart dstStart) {
    this.dstStart = dstStart;
    return this;
  }

  /**
   * Get dstStart
   * @return dstStart
   */
  @javax.annotation.Nullable
  public TimezoneDstStart getDstStart() {
    return dstStart;
  }

  public void setDstStart(@javax.annotation.Nullable TimezoneDstStart dstStart) {
    this.dstStart = dstStart;
  }


  public TimeZone dstEnd(@javax.annotation.Nullable TimezoneDstEnd dstEnd) {
    this.dstEnd = dstEnd;
    return this;
  }

  /**
   * Get dstEnd
   * @return dstEnd
   */
  @javax.annotation.Nullable
  public TimezoneDstEnd getDstEnd() {
    return dstEnd;
  }

  public void setDstEnd(@javax.annotation.Nullable TimezoneDstEnd dstEnd) {
    this.dstEnd = dstEnd;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TimeZone timeZone = (TimeZone) o;
    return Objects.equals(this.name, timeZone.name) &&
        Objects.equals(this.offset, timeZone.offset) &&
        Objects.equals(this.offsetWithDst, timeZone.offsetWithDst) &&
        Objects.equals(this.currentTime, timeZone.currentTime) &&
        Objects.equals(this.currentTimeUnix, timeZone.currentTimeUnix) &&
        Objects.equals(this.isDst, timeZone.isDst) &&
        Objects.equals(this.dstSavings, timeZone.dstSavings) &&
        Objects.equals(this.dstExists, timeZone.dstExists) &&
        Objects.equals(this.dstStart, timeZone.dstStart) &&
        Objects.equals(this.dstEnd, timeZone.dstEnd);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, offset, offsetWithDst, currentTime, currentTimeUnix, isDst, dstSavings, dstExists, dstStart, dstEnd);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TimeZone {\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    offset: ").append(toIndentedString(offset)).append("\n");
    sb.append("    offsetWithDst: ").append(toIndentedString(offsetWithDst)).append("\n");
    sb.append("    currentTime: ").append(toIndentedString(currentTime)).append("\n");
    sb.append("    currentTimeUnix: ").append(toIndentedString(currentTimeUnix)).append("\n");
    sb.append("    isDst: ").append(toIndentedString(isDst)).append("\n");
    sb.append("    dstSavings: ").append(toIndentedString(dstSavings)).append("\n");
    sb.append("    dstExists: ").append(toIndentedString(dstExists)).append("\n");
    sb.append("    dstStart: ").append(toIndentedString(dstStart)).append("\n");
    sb.append("    dstEnd: ").append(toIndentedString(dstEnd)).append("\n");
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
    ipGeoFields.add("name");
    ipGeoFields.add("offset");
    ipGeoFields.add("offset_with_dst");
    ipGeoFields.add("current_time");
    ipGeoFields.add("current_time_unix");
    ipGeoFields.add("is_dst");
    ipGeoFields.add("dst_savings");
    ipGeoFields.add("dst_exists");
    ipGeoFields.add("dst_start");
    ipGeoFields.add("dst_end");

    // a set of required properties/fields (JSON key names)
    ipGeoRequiredFields = new HashSet<String>();
  }

  /**
   * Validates the JSON Element and throws an exception if issues found
   *
   * @param jsonElement JSON Element
   * @throws IOException if the JSON Element is invalid with respect to TimeZone
   */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!TimeZone.ipGeoRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in TimeZone is not found in the empty JSON string", TimeZone.ipGeoRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!TimeZone.ipGeoFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `TimeZone` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
      if ((jsonObj.get("name") != null && !jsonObj.get("name").isJsonNull()) && !jsonObj.get("name").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `name` to be a primitive type in the JSON string but got `%s`", jsonObj.get("name").toString()));
      }
      if ((jsonObj.get("current_time") != null && !jsonObj.get("current_time").isJsonNull()) && !jsonObj.get("current_time").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `current_time` to be a primitive type in the JSON string but got `%s`", jsonObj.get("current_time").toString()));
      }
      // validate the optional field `dst_start`
      if (jsonObj.get("dst_start") != null && !jsonObj.get("dst_start").isJsonNull()) {
        TimezoneDstStart.validateJsonElement(jsonObj.get("dst_start"));
      }
      // validate the optional field `dst_end`
      if (jsonObj.get("dst_end") != null && !jsonObj.get("dst_end").isJsonNull()) {
        TimezoneDstEnd.validateJsonElement(jsonObj.get("dst_end"));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!TimeZone.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'TimeZone' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<TimeZone> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(TimeZone.class));

       return (TypeAdapter<T>) new TypeAdapter<TimeZone>() {
           @Override
           public void write(JsonWriter out, TimeZone value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public TimeZone read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

  /**
   * Create an instance of TimeZone given an JSON string
   *
   * @param jsonString JSON string
   * @return An instance of TimeZone
   * @throws IOException if the JSON string is invalid with respect to TimeZone
   */
  public static TimeZone fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, TimeZone.class);
  }

  /**
   * Convert an instance of TimeZone to an JSON string
   *
   * @return JSON string
   */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

