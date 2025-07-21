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
 * TimeConversionXMLResponse
 */

public class TimeConversionXMLResponse {
  public static final String SERIALIZED_NAME_ORIGINAL_TIME = "original_time";
  @SerializedName(SERIALIZED_NAME_ORIGINAL_TIME)
  @javax.annotation.Nullable
  private String originalTime;

  public static final String SERIALIZED_NAME_CONVERTED_TIME = "converted_time";
  @SerializedName(SERIALIZED_NAME_CONVERTED_TIME)
  @javax.annotation.Nullable
  private String convertedTime;

  public static final String SERIALIZED_NAME_DIFF_HOUR = "diff_hour";
  @SerializedName(SERIALIZED_NAME_DIFF_HOUR)
  @javax.annotation.Nullable
  private Float diffHour;

  public static final String SERIALIZED_NAME_DIFF_MIN = "diff_min";
  @SerializedName(SERIALIZED_NAME_DIFF_MIN)
  @javax.annotation.Nullable
  private Integer diffMin;

  public TimeConversionXMLResponse() {
  }

  public TimeConversionXMLResponse originalTime(@javax.annotation.Nullable String originalTime) {
    this.originalTime = originalTime;
    return this;
  }

  /**
   * Get originalTime
   * @return originalTime
   */
  @javax.annotation.Nullable
  public String getOriginalTime() {
    return originalTime;
  }

  public void setOriginalTime(@javax.annotation.Nullable String originalTime) {
    this.originalTime = originalTime;
  }


  public TimeConversionXMLResponse convertedTime(@javax.annotation.Nullable String convertedTime) {
    this.convertedTime = convertedTime;
    return this;
  }

  /**
   * Get convertedTime
   * @return convertedTime
   */
  @javax.annotation.Nullable
  public String getConvertedTime() {
    return convertedTime;
  }

  public void setConvertedTime(@javax.annotation.Nullable String convertedTime) {
    this.convertedTime = convertedTime;
  }


  public TimeConversionXMLResponse diffHour(@javax.annotation.Nullable Float diffHour) {
    this.diffHour = diffHour;
    return this;
  }

  /**
   * Get diffHour
   * @return diffHour
   */
  @javax.annotation.Nullable
  public Float getDiffHour() {
    return diffHour;
  }

  public void setDiffHour(@javax.annotation.Nullable Float diffHour) {
    this.diffHour = diffHour;
  }


  public TimeConversionXMLResponse diffMin(@javax.annotation.Nullable Integer diffMin) {
    this.diffMin = diffMin;
    return this;
  }

  /**
   * Get diffMin
   * @return diffMin
   */
  @javax.annotation.Nullable
  public Integer getDiffMin() {
    return diffMin;
  }

  public void setDiffMin(@javax.annotation.Nullable Integer diffMin) {
    this.diffMin = diffMin;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TimeConversionXMLResponse timeConversionXMLResponse = (TimeConversionXMLResponse) o;
    return Objects.equals(this.originalTime, timeConversionXMLResponse.originalTime) &&
        Objects.equals(this.convertedTime, timeConversionXMLResponse.convertedTime) &&
        Objects.equals(this.diffHour, timeConversionXMLResponse.diffHour) &&
        Objects.equals(this.diffMin, timeConversionXMLResponse.diffMin);
  }

  @Override
  public int hashCode() {
    return Objects.hash(originalTime, convertedTime, diffHour, diffMin);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TimeConversionXMLResponse {\n");
    sb.append("    originalTime: ").append(toIndentedString(originalTime)).append("\n");
    sb.append("    convertedTime: ").append(toIndentedString(convertedTime)).append("\n");
    sb.append("    diffHour: ").append(toIndentedString(diffHour)).append("\n");
    sb.append("    diffMin: ").append(toIndentedString(diffMin)).append("\n");
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
    ipGeoFields.add("original_time");
    ipGeoFields.add("converted_time");
    ipGeoFields.add("diff_hour");
    ipGeoFields.add("diff_min");

    // a set of required properties/fields (JSON key names)
    ipGeoRequiredFields = new HashSet<String>();
  }

  /**
   * Validates the JSON Element and throws an exception if issues found
   *
   * @param jsonElement JSON Element
   * @throws IOException if the JSON Element is invalid with respect to TimeConversionXMLResponse
   */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!TimeConversionXMLResponse.ipGeoRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in TimeConversionXMLResponse is not found in the empty JSON string", TimeConversionXMLResponse.ipGeoRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!TimeConversionXMLResponse.ipGeoFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `TimeConversionXMLResponse` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
      if ((jsonObj.get("original_time") != null && !jsonObj.get("original_time").isJsonNull()) && !jsonObj.get("original_time").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `original_time` to be a primitive type in the JSON string but got `%s`", jsonObj.get("original_time").toString()));
      }
      if ((jsonObj.get("converted_time") != null && !jsonObj.get("converted_time").isJsonNull()) && !jsonObj.get("converted_time").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `converted_time` to be a primitive type in the JSON string but got `%s`", jsonObj.get("converted_time").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!TimeConversionXMLResponse.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'TimeConversionXMLResponse' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<TimeConversionXMLResponse> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(TimeConversionXMLResponse.class));

       return (TypeAdapter<T>) new TypeAdapter<TimeConversionXMLResponse>() {
           @Override
           public void write(JsonWriter out, TimeConversionXMLResponse value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public TimeConversionXMLResponse read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

  /**
   * Create an instance of TimeConversionXMLResponse given an JSON string
   *
   * @param jsonString JSON string
   * @return An instance of TimeConversionXMLResponse
   * @throws IOException if the JSON string is invalid with respect to TimeConversionXMLResponse
   */
  public static TimeConversionXMLResponse fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, TimeConversionXMLResponse.class);
  }

  /**
   * Convert an instance of TimeConversionXMLResponse to an JSON string
   *
   * @return JSON string
   */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

