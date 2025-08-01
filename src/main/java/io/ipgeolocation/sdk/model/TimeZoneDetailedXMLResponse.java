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
 * TimeZoneDetailedXMLResponse
 */

public class TimeZoneDetailedXMLResponse {
  public static final String SERIALIZED_NAME_IP = "ip";
  @SerializedName(SERIALIZED_NAME_IP)
  @javax.annotation.Nullable
  private String ip;

  public static final String SERIALIZED_NAME_AIRPORT_DETAILS = "airport_details";
  @SerializedName(SERIALIZED_NAME_AIRPORT_DETAILS)
  @javax.annotation.Nullable
  private TimezoneAirport airportDetails;

  public static final String SERIALIZED_NAME_LO_CODE_DETAILS = "lo_code_details";
  @SerializedName(SERIALIZED_NAME_LO_CODE_DETAILS)
  @javax.annotation.Nullable
  private TimezoneLocode loCodeDetails;

  public static final String SERIALIZED_NAME_LOCATION = "location";
  @SerializedName(SERIALIZED_NAME_LOCATION)
  @javax.annotation.Nullable
  private TimezoneLocation location;

  public static final String SERIALIZED_NAME_TIME_ZONE = "time_zone";
  @SerializedName(SERIALIZED_NAME_TIME_ZONE)
  @javax.annotation.Nullable
  private TimezoneDetails timeZone;

  public TimeZoneDetailedXMLResponse() {
  }

  public TimeZoneDetailedXMLResponse ip(@javax.annotation.Nullable String ip) {
    this.ip = ip;
    return this;
  }

  /**
   * Get ip
   * @return ip
   */
  @javax.annotation.Nullable
  public String getIp() {
    return ip;
  }

  public void setIp(@javax.annotation.Nullable String ip) {
    this.ip = ip;
  }


  public TimeZoneDetailedXMLResponse airportDetails(@javax.annotation.Nullable TimezoneAirport airportDetails) {
    this.airportDetails = airportDetails;
    return this;
  }

  /**
   * Get airportDetails
   * @return airportDetails
   */
  @javax.annotation.Nullable
  public TimezoneAirport getAirportDetails() {
    return airportDetails;
  }

  public void setAirportDetails(@javax.annotation.Nullable TimezoneAirport airportDetails) {
    this.airportDetails = airportDetails;
  }


  public TimeZoneDetailedXMLResponse loCodeDetails(@javax.annotation.Nullable TimezoneLocode loCodeDetails) {
    this.loCodeDetails = loCodeDetails;
    return this;
  }

  /**
   * Get loCodeDetails
   * @return loCodeDetails
   */
  @javax.annotation.Nullable
  public TimezoneLocode getLoCodeDetails() {
    return loCodeDetails;
  }

  public void setLoCodeDetails(@javax.annotation.Nullable TimezoneLocode loCodeDetails) {
    this.loCodeDetails = loCodeDetails;
  }


  public TimeZoneDetailedXMLResponse location(@javax.annotation.Nullable TimezoneLocation location) {
    this.location = location;
    return this;
  }

  /**
   * Get location
   * @return location
   */
  @javax.annotation.Nullable
  public TimezoneLocation getLocation() {
    return location;
  }

  public void setLocation(@javax.annotation.Nullable TimezoneLocation location) {
    this.location = location;
  }


  public TimeZoneDetailedXMLResponse timeZone(@javax.annotation.Nullable TimezoneDetails timeZone) {
    this.timeZone = timeZone;
    return this;
  }

  /**
   * Get timeZone
   * @return timeZone
   */
  @javax.annotation.Nullable
  public TimezoneDetails getTimeZone() {
    return timeZone;
  }

  public void setTimeZone(@javax.annotation.Nullable TimezoneDetails timeZone) {
    this.timeZone = timeZone;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TimeZoneDetailedXMLResponse timeZoneDetailedXMLResponse = (TimeZoneDetailedXMLResponse) o;
    return Objects.equals(this.ip, timeZoneDetailedXMLResponse.ip) &&
        Objects.equals(this.airportDetails, timeZoneDetailedXMLResponse.airportDetails) &&
        Objects.equals(this.loCodeDetails, timeZoneDetailedXMLResponse.loCodeDetails) &&
        Objects.equals(this.location, timeZoneDetailedXMLResponse.location) &&
        Objects.equals(this.timeZone, timeZoneDetailedXMLResponse.timeZone);
  }

  @Override
  public int hashCode() {
    return Objects.hash(ip, airportDetails, loCodeDetails, location, timeZone);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TimeZoneDetailedXMLResponse {\n");
    sb.append("    ip: ").append(toIndentedString(ip)).append("\n");
    sb.append("    airportDetails: ").append(toIndentedString(airportDetails)).append("\n");
    sb.append("    loCodeDetails: ").append(toIndentedString(loCodeDetails)).append("\n");
    sb.append("    location: ").append(toIndentedString(location)).append("\n");
    sb.append("    timeZone: ").append(toIndentedString(timeZone)).append("\n");
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
    ipGeoFields.add("ip");
    ipGeoFields.add("airport_details");
    ipGeoFields.add("lo_code_details");
    ipGeoFields.add("location");
    ipGeoFields.add("time_zone");

    // a set of required properties/fields (JSON key names)
    ipGeoRequiredFields = new HashSet<String>();
  }

  /**
   * Validates the JSON Element and throws an exception if issues found
   *
   * @param jsonElement JSON Element
   * @throws IOException if the JSON Element is invalid with respect to TimeZoneDetailedXMLResponse
   */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!TimeZoneDetailedXMLResponse.ipGeoRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in TimeZoneDetailedXMLResponse is not found in the empty JSON string", TimeZoneDetailedXMLResponse.ipGeoRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!TimeZoneDetailedXMLResponse.ipGeoFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `TimeZoneDetailedXMLResponse` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
      if ((jsonObj.get("ip") != null && !jsonObj.get("ip").isJsonNull()) && !jsonObj.get("ip").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `ip` to be a primitive type in the JSON string but got `%s`", jsonObj.get("ip").toString()));
      }
      // validate the optional field `airport_details`
      if (jsonObj.get("airport_details") != null && !jsonObj.get("airport_details").isJsonNull()) {
        TimezoneAirport.validateJsonElement(jsonObj.get("airport_details"));
      }
      // validate the optional field `lo_code_details`
      if (jsonObj.get("lo_code_details") != null && !jsonObj.get("lo_code_details").isJsonNull()) {
        TimezoneLocode.validateJsonElement(jsonObj.get("lo_code_details"));
      }
      // validate the optional field `location`
      if (jsonObj.get("location") != null && !jsonObj.get("location").isJsonNull()) {
        TimezoneLocation.validateJsonElement(jsonObj.get("location"));
      }
      // validate the optional field `time_zone`
      if (jsonObj.get("time_zone") != null && !jsonObj.get("time_zone").isJsonNull()) {
        TimezoneDetails.validateJsonElement(jsonObj.get("time_zone"));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!TimeZoneDetailedXMLResponse.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'TimeZoneDetailedXMLResponse' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<TimeZoneDetailedXMLResponse> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(TimeZoneDetailedXMLResponse.class));

       return (TypeAdapter<T>) new TypeAdapter<TimeZoneDetailedXMLResponse>() {
           @Override
           public void write(JsonWriter out, TimeZoneDetailedXMLResponse value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public TimeZoneDetailedXMLResponse read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

  /**
   * Create an instance of TimeZoneDetailedXMLResponse given an JSON string
   *
   * @param jsonString JSON string
   * @return An instance of TimeZoneDetailedXMLResponse
   * @throws IOException if the JSON string is invalid with respect to TimeZoneDetailedXMLResponse
   */
  public static TimeZoneDetailedXMLResponse fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, TimeZoneDetailedXMLResponse.class);
  }

  /**
   * Convert an instance of TimeZoneDetailedXMLResponse to an JSON string
   *
   * @return JSON string
   */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

