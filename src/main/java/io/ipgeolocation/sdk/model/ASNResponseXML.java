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
 * ASNResponseXML
 */

public class ASNResponseXML {
  public static final String SERIALIZED_NAME_IP = "ip";
  @SerializedName(SERIALIZED_NAME_IP)
  @javax.annotation.Nullable
  private String ip;

  public static final String SERIALIZED_NAME_ASN = "asn";
  @SerializedName(SERIALIZED_NAME_ASN)
  @javax.annotation.Nullable
  private ASNResponseXMLAsn asn;

  public ASNResponseXML() {
  }

  public ASNResponseXML ip(@javax.annotation.Nullable String ip) {
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


  public ASNResponseXML asn(@javax.annotation.Nullable ASNResponseXMLAsn asn) {
    this.asn = asn;
    return this;
  }

  /**
   * Get asn
   * @return asn
   */
  @javax.annotation.Nullable
  public ASNResponseXMLAsn getAsn() {
    return asn;
  }

  public void setAsn(@javax.annotation.Nullable ASNResponseXMLAsn asn) {
    this.asn = asn;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ASNResponseXML asNResponseXML = (ASNResponseXML) o;
    return Objects.equals(this.ip, asNResponseXML.ip) &&
        Objects.equals(this.asn, asNResponseXML.asn);
  }

  @Override
  public int hashCode() {
    return Objects.hash(ip, asn);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ASNResponseXML {\n");
    sb.append("    ip: ").append(toIndentedString(ip)).append("\n");
    sb.append("    asn: ").append(toIndentedString(asn)).append("\n");
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
    ipGeoFields.add("asn");

    // a set of required properties/fields (JSON key names)
    ipGeoRequiredFields = new HashSet<String>();
  }

  /**
   * Validates the JSON Element and throws an exception if issues found
   *
   * @param jsonElement JSON Element
   * @throws IOException if the JSON Element is invalid with respect to ASNResponseXML
   */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!ASNResponseXML.ipGeoRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in ASNResponseXML is not found in the empty JSON string", ASNResponseXML.ipGeoRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!ASNResponseXML.ipGeoFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `ASNResponseXML` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
      if ((jsonObj.get("ip") != null && !jsonObj.get("ip").isJsonNull()) && !jsonObj.get("ip").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `ip` to be a primitive type in the JSON string but got `%s`", jsonObj.get("ip").toString()));
      }
      // validate the optional field `asn`
      if (jsonObj.get("asn") != null && !jsonObj.get("asn").isJsonNull()) {
        ASNResponseXMLAsn.validateJsonElement(jsonObj.get("asn"));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!ASNResponseXML.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'ASNResponseXML' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<ASNResponseXML> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(ASNResponseXML.class));

       return (TypeAdapter<T>) new TypeAdapter<ASNResponseXML>() {
           @Override
           public void write(JsonWriter out, ASNResponseXML value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public ASNResponseXML read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

  /**
   * Create an instance of ASNResponseXML given an JSON string
   *
   * @param jsonString JSON string
   * @return An instance of ASNResponseXML
   * @throws IOException if the JSON string is invalid with respect to ASNResponseXML
   */
  public static ASNResponseXML fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, ASNResponseXML.class);
  }

  /**
   * Convert an instance of ASNResponseXML to an JSON string
   *
   * @return JSON string
   */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

