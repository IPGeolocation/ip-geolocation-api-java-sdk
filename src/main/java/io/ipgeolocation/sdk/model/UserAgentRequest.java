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
 * UserAgentPostRequest
 */

public class UserAgentRequest {
  public static final String SERIALIZED_NAME_UA_STRING = "uaString";
  @SerializedName(SERIALIZED_NAME_UA_STRING)
  @javax.annotation.Nullable
  private String uaString;

  public UserAgentRequest() {
  }

  public UserAgentRequest uaString(@javax.annotation.Nullable String uaString) {
    this.uaString = uaString;
    return this;
  }

  /**
   * Get uaString
   * @return uaString
   */
  @javax.annotation.Nullable
  public String getUaString() {
    return uaString;
  }

  public void setUaString(@javax.annotation.Nullable String uaString) {
    this.uaString = uaString;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UserAgentRequest userAgentRequest = (UserAgentRequest) o;
    return Objects.equals(this.uaString, userAgentRequest.uaString);
  }

  @Override
  public int hashCode() {
    return Objects.hash(uaString);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserAgentPostRequest {\n");
    sb.append("    uaString: ").append(toIndentedString(uaString)).append("\n");
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
    ipGeoFields.add("uaString");

    // a set of required properties/fields (JSON key names)
    ipGeoRequiredFields = new HashSet<String>();
  }

  /**
   * Validates the JSON Element and throws an exception if issues found
   *
   * @param jsonElement JSON Element
   * @throws IOException if the JSON Element is invalid with respect to UserAgentPostRequest
   */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!UserAgentRequest.ipGeoRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in UserAgentPostRequest is not found in the empty JSON string", UserAgentRequest.ipGeoRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!UserAgentRequest.ipGeoFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `UserAgentPostRequest` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
      if ((jsonObj.get("uaString") != null && !jsonObj.get("uaString").isJsonNull()) && !jsonObj.get("uaString").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `uaString` to be a primitive type in the JSON string but got `%s`", jsonObj.get("uaString").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!UserAgentRequest.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'UserAgentPostRequest' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<UserAgentRequest> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(UserAgentRequest.class));

       return (TypeAdapter<T>) new TypeAdapter<UserAgentRequest>() {
           @Override
           public void write(JsonWriter out, UserAgentRequest value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public UserAgentRequest read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

  /**
   * Create an instance of UserAgentPostRequest given an JSON string
   *
   * @param jsonString JSON string
   * @return An instance of UserAgentPostRequest
   * @throws IOException if the JSON string is invalid with respect to UserAgentPostRequest
   */
  public static UserAgentRequest fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, UserAgentRequest.class);
  }

  /**
   * Convert an instance of UserAgentPostRequest to an JSON string
   *
   * @return JSON string
   */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

