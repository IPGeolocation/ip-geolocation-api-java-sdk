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
import java.util.ArrayList;
import java.util.List;

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
 * IpgeoBulkPostRequest
 */

public class BulkIPRequest {
  public static final String SERIALIZED_NAME_IPS = "ips";
  @SerializedName(SERIALIZED_NAME_IPS)
  @javax.annotation.Nullable
  private List<String> ips = new ArrayList<>();

  public BulkIPRequest() {
  }

  public BulkIPRequest ips(@javax.annotation.Nullable List<String> ips) {
    this.ips = ips;
    return this;
  }

  public BulkIPRequest addIP(String ipsItem) {
    if (this.ips == null) {
      this.ips = new ArrayList<>();
    }
    this.ips.add(ipsItem);
    return this;
  }

  /**
   * Get ips
   * @return ips
   */
  @javax.annotation.Nullable
  public List<String> getIps() {
    return ips;
  }

  public void setIps(@javax.annotation.Nullable List<String> ips) {
    this.ips = ips;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BulkIPRequest bulkIpRequest = (BulkIPRequest) o;
    return Objects.equals(this.ips, bulkIpRequest.ips);
  }

  @Override
  public int hashCode() {
    return Objects.hash(ips);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class IpgeoBulkPostRequest {\n");
    sb.append("    ips: ").append(toIndentedString(ips)).append("\n");
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
    ipGeoFields.add("ips");

    // a set of required properties/fields (JSON key names)
    ipGeoRequiredFields = new HashSet<String>();
  }

  /**
   * Validates the JSON Element and throws an exception if issues found
   *
   * @param jsonElement JSON Element
   * @throws IOException if the JSON Element is invalid with respect to IpgeoBulkPostRequest
   */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!BulkIPRequest.ipGeoRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in IpgeoBulkPostRequest is not found in the empty JSON string", BulkIPRequest.ipGeoRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!BulkIPRequest.ipGeoFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `IpgeoBulkPostRequest` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
      // ensure the optional json data is an array if present
      if (jsonObj.get("ips") != null && !jsonObj.get("ips").isJsonNull() && !jsonObj.get("ips").isJsonArray()) {
        throw new IllegalArgumentException(String.format("Expected the field `ips` to be an array in the JSON string but got `%s`", jsonObj.get("ips").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!BulkIPRequest.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'IpgeoBulkPostRequest' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<BulkIPRequest> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(BulkIPRequest.class));

       return (TypeAdapter<T>) new TypeAdapter<BulkIPRequest>() {
           @Override
           public void write(JsonWriter out, BulkIPRequest value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public BulkIPRequest read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

  /**
   * Create an instance of IpgeoBulkPostRequest given an JSON string
   *
   * @param jsonString JSON string
   * @return An instance of IpgeoBulkPostRequest
   * @throws IOException if the JSON string is invalid with respect to IpgeoBulkPostRequest
   */
  public static BulkIPRequest fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, BulkIPRequest.class);
  }

  /**
   * Convert an instance of IpgeoBulkPostRequest to an JSON string
   *
   * @return JSON string
   */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

