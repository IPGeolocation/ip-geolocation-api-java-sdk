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
 * NetworkMinimalAsn
 */

public class NetworkMinimalAsn {
  public static final String SERIALIZED_NAME_AS_NUMBER = "as_number";
  @SerializedName(SERIALIZED_NAME_AS_NUMBER)
  @javax.annotation.Nullable
  private String asNumber;

  public static final String SERIALIZED_NAME_ORGANIZATION = "organization";
  @SerializedName(SERIALIZED_NAME_ORGANIZATION)
  @javax.annotation.Nullable
  private String organization;

  public static final String SERIALIZED_NAME_COUNTRY = "country";
  @SerializedName(SERIALIZED_NAME_COUNTRY)
  @javax.annotation.Nullable
  private String country;

  public NetworkMinimalAsn() {
  }

  public NetworkMinimalAsn asNumber(@javax.annotation.Nullable String asNumber) {
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


  public NetworkMinimalAsn organization(@javax.annotation.Nullable String organization) {
    this.organization = organization;
    return this;
  }

  /**
   * Get organization
   * @return organization
   */
  @javax.annotation.Nullable
  public String getOrganization() {
    return organization;
  }

  public void setOrganization(@javax.annotation.Nullable String organization) {
    this.organization = organization;
  }


  public NetworkMinimalAsn country(@javax.annotation.Nullable String country) {
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
    NetworkMinimalAsn networkMinimalAsn = (NetworkMinimalAsn) o;
    return Objects.equals(this.asNumber, networkMinimalAsn.asNumber) &&
        Objects.equals(this.organization, networkMinimalAsn.organization) &&
        Objects.equals(this.country, networkMinimalAsn.country);
  }

  @Override
  public int hashCode() {
    return Objects.hash(asNumber, organization, country);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class NetworkMinimalAsn {\n");
    sb.append("    asNumber: ").append(toIndentedString(asNumber)).append("\n");
    sb.append("    organization: ").append(toIndentedString(organization)).append("\n");
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
    ipGeoFields.add("organization");
    ipGeoFields.add("country");

    // a set of required properties/fields (JSON key names)
    ipGeoRequiredFields = new HashSet<String>();
  }

  /**
   * Validates the JSON Element and throws an exception if issues found
   *
   * @param jsonElement JSON Element
   * @throws IOException if the JSON Element is invalid with respect to NetworkMinimalAsn
   */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!NetworkMinimalAsn.ipGeoRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in NetworkMinimalAsn is not found in the empty JSON string", NetworkMinimalAsn.ipGeoRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!NetworkMinimalAsn.ipGeoFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `NetworkMinimalAsn` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
      if ((jsonObj.get("as_number") != null && !jsonObj.get("as_number").isJsonNull()) && !jsonObj.get("as_number").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `as_number` to be a primitive type in the JSON string but got `%s`", jsonObj.get("as_number").toString()));
      }
      if ((jsonObj.get("organization") != null && !jsonObj.get("organization").isJsonNull()) && !jsonObj.get("organization").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `organization` to be a primitive type in the JSON string but got `%s`", jsonObj.get("organization").toString()));
      }
      if ((jsonObj.get("country") != null && !jsonObj.get("country").isJsonNull()) && !jsonObj.get("country").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `country` to be a primitive type in the JSON string but got `%s`", jsonObj.get("country").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!NetworkMinimalAsn.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'NetworkMinimalAsn' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<NetworkMinimalAsn> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(NetworkMinimalAsn.class));

       return (TypeAdapter<T>) new TypeAdapter<NetworkMinimalAsn>() {
           @Override
           public void write(JsonWriter out, NetworkMinimalAsn value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public NetworkMinimalAsn read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

  /**
   * Create an instance of NetworkMinimalAsn given an JSON string
   *
   * @param jsonString JSON string
   * @return An instance of NetworkMinimalAsn
   * @throws IOException if the JSON string is invalid with respect to NetworkMinimalAsn
   */
  public static NetworkMinimalAsn fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, NetworkMinimalAsn.class);
  }

  /**
   * Convert an instance of NetworkMinimalAsn to an JSON string
   *
   * @return JSON string
   */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

