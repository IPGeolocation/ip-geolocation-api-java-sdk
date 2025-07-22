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
 * AstronomyXMLResponse
 */

public class AstronomyXMLResponse {
  public static final String SERIALIZED_NAME_IP = "ip";
  @SerializedName(SERIALIZED_NAME_IP)
  @javax.annotation.Nullable
  private String ip;

  public static final String SERIALIZED_NAME_LOCATION = "location";
  @SerializedName(SERIALIZED_NAME_LOCATION)
  @javax.annotation.Nullable
  private TimezoneLocation location;

  public static final String SERIALIZED_NAME_ASTRONOMY = "astronomy";
  @SerializedName(SERIALIZED_NAME_ASTRONOMY)
  @javax.annotation.Nullable
  private Astronomy astronomy;

  public AstronomyXMLResponse() {
  }

  public AstronomyXMLResponse ip(@javax.annotation.Nullable String ip) {
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


  public AstronomyXMLResponse location(@javax.annotation.Nullable TimezoneLocation location) {
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


  public AstronomyXMLResponse astronomy(@javax.annotation.Nullable Astronomy astronomy) {
    this.astronomy = astronomy;
    return this;
  }

  /**
   * Get astronomy
   * @return astronomy
   */
  @javax.annotation.Nullable
  public Astronomy getAstronomy() {
    return astronomy;
  }

  public void setAstronomy(@javax.annotation.Nullable Astronomy astronomy) {
    this.astronomy = astronomy;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AstronomyXMLResponse astronomyXMLResponse = (AstronomyXMLResponse) o;
    return Objects.equals(this.ip, astronomyXMLResponse.ip) &&
        Objects.equals(this.location, astronomyXMLResponse.location) &&
        Objects.equals(this.astronomy, astronomyXMLResponse.astronomy);
  }

  @Override
  public int hashCode() {
    return Objects.hash(ip, location, astronomy);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AstronomyXMLResponse {\n");
    sb.append("    ip: ").append(toIndentedString(ip)).append("\n");
    sb.append("    location: ").append(toIndentedString(location)).append("\n");
    sb.append("    astronomy: ").append(toIndentedString(astronomy)).append("\n");
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
    ipGeoFields.add("location");
    ipGeoFields.add("astronomy");

    // a set of required properties/fields (JSON key names)
    ipGeoRequiredFields = new HashSet<String>();
  }

  /**
   * Validates the JSON Element and throws an exception if issues found
   *
   * @param jsonElement JSON Element
   * @throws IOException if the JSON Element is invalid with respect to AstronomyXMLResponse
   */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!AstronomyXMLResponse.ipGeoRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in AstronomyXMLResponse is not found in the empty JSON string", AstronomyXMLResponse.ipGeoRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!AstronomyXMLResponse.ipGeoFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `AstronomyXMLResponse` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
      if ((jsonObj.get("ip") != null && !jsonObj.get("ip").isJsonNull()) && !jsonObj.get("ip").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `ip` to be a primitive type in the JSON string but got `%s`", jsonObj.get("ip").toString()));
      }
      // validate the optional field `location`
      if (jsonObj.get("location") != null && !jsonObj.get("location").isJsonNull()) {
        TimezoneLocation.validateJsonElement(jsonObj.get("location"));
      }
      // validate the optional field `astronomy`
      if (jsonObj.get("astronomy") != null && !jsonObj.get("astronomy").isJsonNull()) {
        Astronomy.validateJsonElement(jsonObj.get("astronomy"));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!AstronomyXMLResponse.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'AstronomyXMLResponse' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<AstronomyXMLResponse> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(AstronomyXMLResponse.class));

       return (TypeAdapter<T>) new TypeAdapter<AstronomyXMLResponse>() {
           @Override
           public void write(JsonWriter out, AstronomyXMLResponse value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public AstronomyXMLResponse read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

  /**
   * Create an instance of AstronomyXMLResponse given an JSON string
   *
   * @param jsonString JSON string
   * @return An instance of AstronomyXMLResponse
   * @throws IOException if the JSON string is invalid with respect to AstronomyXMLResponse
   */
  public static AstronomyXMLResponse fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, AstronomyXMLResponse.class);
  }

  /**
   * Convert an instance of AstronomyXMLResponse to an JSON string
   *
   * @return JSON string
   */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

