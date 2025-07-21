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
 * NetworkMinimal
 */

public class NetworkMinimal {
  public static final String SERIALIZED_NAME_ASN = "asn";
  @SerializedName(SERIALIZED_NAME_ASN)
  @javax.annotation.Nullable
  private NetworkMinimalAsn asn;

  public static final String SERIALIZED_NAME_COMPANY = "company";
  @SerializedName(SERIALIZED_NAME_COMPANY)
  @javax.annotation.Nullable
  private NetworkMinimalCompany company;

  public NetworkMinimal() {
  }

  public NetworkMinimal asn(@javax.annotation.Nullable NetworkMinimalAsn asn) {
    this.asn = asn;
    return this;
  }

  /**
   * Get asn
   * @return asn
   */
  @javax.annotation.Nullable
  public NetworkMinimalAsn getAsn() {
    return asn;
  }

  public void setAsn(@javax.annotation.Nullable NetworkMinimalAsn asn) {
    this.asn = asn;
  }


  public NetworkMinimal company(@javax.annotation.Nullable NetworkMinimalCompany company) {
    this.company = company;
    return this;
  }

  /**
   * Get company
   * @return company
   */
  @javax.annotation.Nullable
  public NetworkMinimalCompany getCompany() {
    return company;
  }

  public void setCompany(@javax.annotation.Nullable NetworkMinimalCompany company) {
    this.company = company;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    NetworkMinimal networkMinimal = (NetworkMinimal) o;
    return Objects.equals(this.asn, networkMinimal.asn) &&
        Objects.equals(this.company, networkMinimal.company);
  }

  @Override
  public int hashCode() {
    return Objects.hash(asn, company);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class NetworkMinimal {\n");
    sb.append("    asn: ").append(toIndentedString(asn)).append("\n");
    sb.append("    company: ").append(toIndentedString(company)).append("\n");
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
    ipGeoFields.add("asn");
    ipGeoFields.add("company");

    // a set of required properties/fields (JSON key names)
    ipGeoRequiredFields = new HashSet<String>();
  }

  /**
   * Validates the JSON Element and throws an exception if issues found
   *
   * @param jsonElement JSON Element
   * @throws IOException if the JSON Element is invalid with respect to NetworkMinimal
   */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!NetworkMinimal.ipGeoRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in NetworkMinimal is not found in the empty JSON string", NetworkMinimal.ipGeoRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!NetworkMinimal.ipGeoFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `NetworkMinimal` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
      // validate the optional field `asn`
      if (jsonObj.get("asn") != null && !jsonObj.get("asn").isJsonNull()) {
        NetworkMinimalAsn.validateJsonElement(jsonObj.get("asn"));
      }
      // validate the optional field `company`
      if (jsonObj.get("company") != null && !jsonObj.get("company").isJsonNull()) {
        NetworkMinimalCompany.validateJsonElement(jsonObj.get("company"));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!NetworkMinimal.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'NetworkMinimal' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<NetworkMinimal> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(NetworkMinimal.class));

       return (TypeAdapter<T>) new TypeAdapter<NetworkMinimal>() {
           @Override
           public void write(JsonWriter out, NetworkMinimal value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public NetworkMinimal read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

  /**
   * Create an instance of NetworkMinimal given an JSON string
   *
   * @param jsonString JSON string
   * @return An instance of NetworkMinimal
   * @throws IOException if the JSON string is invalid with respect to NetworkMinimal
   */
  public static NetworkMinimal fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, NetworkMinimal.class);
  }

  /**
   * Convert an instance of NetworkMinimal to an JSON string
   *
   * @return JSON string
   */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

