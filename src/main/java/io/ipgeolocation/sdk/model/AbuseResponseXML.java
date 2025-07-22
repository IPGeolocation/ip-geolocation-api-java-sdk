/*
 * IPGeolocation.io - IP intelligence products
 * Ipgeolocation provides a set of APIs to make ip based decisions.
 */


package io.ipgeolocation.sdk.model;

import com.google.gson.*;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.ipgeolocation.sdk.invoker.JSON;

import java.io.IOException;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * AbuseResponseXML
 */

public class AbuseResponseXML {
  public static final String SERIALIZED_NAME_IP = "ip";
  @SerializedName(SERIALIZED_NAME_IP)
  @javax.annotation.Nullable
  private String ip;

  public static final String SERIALIZED_NAME_ABUSE = "abuse";
  @SerializedName(SERIALIZED_NAME_ABUSE)
  @javax.annotation.Nullable
  private Abuse abuse;

  public AbuseResponseXML() {
  }

  public AbuseResponseXML ip(@javax.annotation.Nullable String ip) {
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


  public AbuseResponseXML abuse(@javax.annotation.Nullable Abuse abuse) {
    this.abuse = abuse;
    return this;
  }

  /**
   * Get abuse
   * @return abuse
   */
  @javax.annotation.Nullable
  public Abuse getAbuse() {
    return abuse;
  }

  public void setAbuse(@javax.annotation.Nullable Abuse abuse) {
    this.abuse = abuse;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AbuseResponseXML abuseResponseXML = (AbuseResponseXML) o;
    return Objects.equals(this.ip, abuseResponseXML.ip) &&
        Objects.equals(this.abuse, abuseResponseXML.abuse);
  }

  @Override
  public int hashCode() {
    return Objects.hash(ip, abuse);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AbuseResponseXML {\n");
    sb.append("    ip: ").append(toIndentedString(ip)).append("\n");
    sb.append("    abuse: ").append(toIndentedString(abuse)).append("\n");
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
    ipGeoFields.add("abuse");

    // a set of required properties/fields (JSON key names)
    ipGeoRequiredFields = new HashSet<String>();
  }

  /**
   * Validates the JSON Element and throws an exception if issues found
   *
   * @param jsonElement JSON Element
   * @throws IOException if the JSON Element is invalid with respect to AbuseResponseXML
   */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!AbuseResponseXML.ipGeoRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in AbuseResponseXML is not found in the empty JSON string", AbuseResponseXML.ipGeoRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!AbuseResponseXML.ipGeoFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `AbuseResponseXML` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
      if ((jsonObj.get("ip") != null && !jsonObj.get("ip").isJsonNull()) && !jsonObj.get("ip").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `ip` to be a primitive type in the JSON string but got `%s`", jsonObj.get("ip").toString()));
      }
      // validate the optional field `abuse`
      if (jsonObj.get("abuse") != null && !jsonObj.get("abuse").isJsonNull()) {
        Abuse.validateJsonElement(jsonObj.get("abuse"));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!AbuseResponseXML.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'AbuseResponseXML' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<AbuseResponseXML> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(AbuseResponseXML.class));

       return (TypeAdapter<T>) new TypeAdapter<AbuseResponseXML>() {
           @Override
           public void write(JsonWriter out, AbuseResponseXML value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public AbuseResponseXML read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

  /**
   * Create an instance of AbuseResponseXML given an JSON string
   *
   * @param jsonString JSON string
   * @return An instance of AbuseResponseXML
   * @throws IOException if the JSON string is invalid with respect to AbuseResponseXML
   */
  public static AbuseResponseXML fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, AbuseResponseXML.class);
  }

  /**
   * Convert an instance of AbuseResponseXML to an JSON string
   *
   * @return JSON string
   */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

