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
 * UserAgentBulkPostRequest
 */

public class UserAgentBulkRequest {
  public static final String SERIALIZED_NAME_UA_STRINGS = "uaStrings";
  @SerializedName(SERIALIZED_NAME_UA_STRINGS)
  @javax.annotation.Nullable
  private List<String> uaStrings = new ArrayList<>();

  public UserAgentBulkRequest() {
  }

  public UserAgentBulkRequest uaStrings(@javax.annotation.Nullable List<String> uaStrings) {
    this.uaStrings = uaStrings;
    return this;
  }

  public UserAgentBulkRequest addUaString(String uaStringsItem) {
    if (this.uaStrings == null) {
      this.uaStrings = new ArrayList<>();
    }
    this.uaStrings.add(uaStringsItem);
    return this;
  }

  /**
   * Get uaStrings
   * @return uaStrings
   */
  @javax.annotation.Nullable
  public List<String> getUaStrings() {
    return uaStrings;
  }

  public void setUaStrings(@javax.annotation.Nullable List<String> uaStrings) {
    this.uaStrings = uaStrings;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UserAgentBulkRequest userAgentBulkRequest = (UserAgentBulkRequest) o;
    return Objects.equals(this.uaStrings, userAgentBulkRequest.uaStrings);
  }

  @Override
  public int hashCode() {
    return Objects.hash(uaStrings);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserAgentBulkPostRequest {\n");
    sb.append("    uaStrings: ").append(toIndentedString(uaStrings)).append("\n");
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
    ipGeoFields.add("uaStrings");

    // a set of required properties/fields (JSON key names)
    ipGeoRequiredFields = new HashSet<String>();
  }

  /**
   * Validates the JSON Element and throws an exception if issues found
   *
   * @param jsonElement JSON Element
   * @throws IOException if the JSON Element is invalid with respect to UserAgentBulkPostRequest
   */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!UserAgentBulkRequest.ipGeoRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in UserAgentBulkPostRequest is not found in the empty JSON string", UserAgentBulkRequest.ipGeoRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!UserAgentBulkRequest.ipGeoFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `UserAgentBulkPostRequest` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
      // ensure the optional json data is an array if present
      if (jsonObj.get("uaStrings") != null && !jsonObj.get("uaStrings").isJsonNull() && !jsonObj.get("uaStrings").isJsonArray()) {
        throw new IllegalArgumentException(String.format("Expected the field `uaStrings` to be an array in the JSON string but got `%s`", jsonObj.get("uaStrings").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!UserAgentBulkRequest.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'UserAgentBulkPostRequest' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<UserAgentBulkRequest> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(UserAgentBulkRequest.class));

       return (TypeAdapter<T>) new TypeAdapter<UserAgentBulkRequest>() {
           @Override
           public void write(JsonWriter out, UserAgentBulkRequest value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public UserAgentBulkRequest read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

  /**
   * Create an instance of UserAgentBulkPostRequest given an JSON string
   *
   * @param jsonString JSON string
   * @return An instance of UserAgentBulkPostRequest
   * @throws IOException if the JSON string is invalid with respect to UserAgentBulkPostRequest
   */
  public static UserAgentBulkRequest fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, UserAgentBulkRequest.class);
  }

  /**
   * Convert an instance of UserAgentBulkPostRequest to an JSON string
   *
   * @return JSON string
   */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

