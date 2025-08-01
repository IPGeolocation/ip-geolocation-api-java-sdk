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
 * ASNConnection
 */

public class ASNConnection {
  public static final String SERIALIZED_NAME_AS_NUMBER = "as_number";
  @SerializedName(SERIALIZED_NAME_AS_NUMBER)
  @javax.annotation.Nullable
  private String asNumber;

  public static final String SERIALIZED_NAME_DESCRIPTION = "description";
  @SerializedName(SERIALIZED_NAME_DESCRIPTION)
  @javax.annotation.Nullable
  private String description;

  public static final String SERIALIZED_NAME_COUNTRY = "country";
  @SerializedName(SERIALIZED_NAME_COUNTRY)
  @javax.annotation.Nullable
  private String country;

  public ASNConnection() {
  }

  public ASNConnection asNumber(@javax.annotation.Nullable String asNumber) {
    this.asNumber = asNumber;
    return this;
  }

  /**
   * Get asNumber
   * @return asNumber
   */
  @javax.annotation.Nullable
  public String getAsNumber() {
    return asNumber;
  }

  public void setAsNumber(@javax.annotation.Nullable String asNumber) {
    this.asNumber = asNumber;
  }


  public ASNConnection description(@javax.annotation.Nullable String description) {
    this.description = description;
    return this;
  }

  /**
   * Get description
   * @return description
   */
  @javax.annotation.Nullable
  public String getDescription() {
    return description;
  }

  public void setDescription(@javax.annotation.Nullable String description) {
    this.description = description;
  }


  public ASNConnection country(@javax.annotation.Nullable String country) {
    this.country = country;
    return this;
  }

  /**
   * Get country
   * @return country
   */
  @javax.annotation.Nullable
  public String getCountry() {
    return country;
  }

  public void setCountry(@javax.annotation.Nullable String country) {
    this.country = country;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ASNConnection asNConnection = (ASNConnection) o;
    return Objects.equals(this.asNumber, asNConnection.asNumber) &&
        Objects.equals(this.description, asNConnection.description) &&
        Objects.equals(this.country, asNConnection.country);
  }

  @Override
  public int hashCode() {
    return Objects.hash(asNumber, description, country);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ASNConnection {\n");
    sb.append("    asNumber: ").append(toIndentedString(asNumber)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    country: ").append(toIndentedString(country)).append("\n");
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
    ipGeoFields.add("as_number");
    ipGeoFields.add("description");
    ipGeoFields.add("country");

    // a set of required properties/fields (JSON key names)
    ipGeoRequiredFields = new HashSet<String>();
  }

  /**
   * Validates the JSON Element and throws an exception if issues found
   *
   * @param jsonElement JSON Element
   * @throws IOException if the JSON Element is invalid with respect to ASNConnection
   */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!ASNConnection.ipGeoRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in ASNConnection is not found in the empty JSON string", ASNConnection.ipGeoRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!ASNConnection.ipGeoFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `ASNConnection` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
      if ((jsonObj.get("as_number") != null && !jsonObj.get("as_number").isJsonNull()) && !jsonObj.get("as_number").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `as_number` to be a primitive type in the JSON string but got `%s`", jsonObj.get("as_number").toString()));
      }
      if ((jsonObj.get("description") != null && !jsonObj.get("description").isJsonNull()) && !jsonObj.get("description").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `description` to be a primitive type in the JSON string but got `%s`", jsonObj.get("description").toString()));
      }
      if ((jsonObj.get("country") != null && !jsonObj.get("country").isJsonNull()) && !jsonObj.get("country").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `country` to be a primitive type in the JSON string but got `%s`", jsonObj.get("country").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!ASNConnection.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'ASNConnection' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<ASNConnection> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(ASNConnection.class));

       return (TypeAdapter<T>) new TypeAdapter<ASNConnection>() {
           @Override
           public void write(JsonWriter out, ASNConnection value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public ASNConnection read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

  /**
   * Create an instance of ASNConnection given an JSON string
   *
   * @param jsonString JSON string
   * @return An instance of ASNConnection
   * @throws IOException if the JSON string is invalid with respect to ASNConnection
   */
  public static ASNConnection fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, ASNConnection.class);
  }

  /**
   * Convert an instance of ASNConnection to an JSON string
   *
   * @return JSON string
   */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

