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
 * Network
 */

public class Network {
  public static final String SERIALIZED_NAME_ASN = "asn";
  @SerializedName(SERIALIZED_NAME_ASN)
  @javax.annotation.Nullable
  private NetworkAsn asn;

  public static final String SERIALIZED_NAME_CONNECTION_TYPE = "connection_type";
  @SerializedName(SERIALIZED_NAME_CONNECTION_TYPE)
  @javax.annotation.Nullable
  private String connectionType;

  public static final String SERIALIZED_NAME_COMPANY = "company";
  @SerializedName(SERIALIZED_NAME_COMPANY)
  @javax.annotation.Nullable
  private NetworkCompany company;

  public Network() {
  }

  public Network asn(@javax.annotation.Nullable NetworkAsn asn) {
    this.asn = asn;
    return this;
  }

  /**
   * Get asn
   * @return asn
   */
  @javax.annotation.Nullable
  public NetworkAsn getAsn() {
    return asn;
  }

  public void setAsn(@javax.annotation.Nullable NetworkAsn asn) {
    this.asn = asn;
  }


  public Network connectionType(@javax.annotation.Nullable String connectionType) {
    this.connectionType = connectionType;
    return this;
  }

  /**
   * Get connectionType
   * @return connectionType
   */
  @javax.annotation.Nullable
  public String getConnectionType() {
    return connectionType;
  }

  public void setConnectionType(@javax.annotation.Nullable String connectionType) {
    this.connectionType = connectionType;
  }


  public Network company(@javax.annotation.Nullable NetworkCompany company) {
    this.company = company;
    return this;
  }

  /**
   * Get company
   * @return company
   */
  @javax.annotation.Nullable
  public NetworkCompany getCompany() {
    return company;
  }

  public void setCompany(@javax.annotation.Nullable NetworkCompany company) {
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
    Network network = (Network) o;
    return Objects.equals(this.asn, network.asn) &&
        Objects.equals(this.connectionType, network.connectionType) &&
        Objects.equals(this.company, network.company);
  }

  @Override
  public int hashCode() {
    return Objects.hash(asn, connectionType, company);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Network {\n");
    sb.append("    asn: ").append(toIndentedString(asn)).append("\n");
    sb.append("    connectionType: ").append(toIndentedString(connectionType)).append("\n");
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
    ipGeoFields.add("connection_type");
    ipGeoFields.add("company");

    // a set of required properties/fields (JSON key names)
    ipGeoRequiredFields = new HashSet<String>();
  }

  /**
   * Validates the JSON Element and throws an exception if issues found
   *
   * @param jsonElement JSON Element
   * @throws IOException if the JSON Element is invalid with respect to Network
   */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!Network.ipGeoRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in Network is not found in the empty JSON string", Network.ipGeoRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!Network.ipGeoFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `Network` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
      // validate the optional field `asn`
      if (jsonObj.get("asn") != null && !jsonObj.get("asn").isJsonNull()) {
        NetworkAsn.validateJsonElement(jsonObj.get("asn"));
      }
      if ((jsonObj.get("connection_type") != null && !jsonObj.get("connection_type").isJsonNull()) && !jsonObj.get("connection_type").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `connection_type` to be a primitive type in the JSON string but got `%s`", jsonObj.get("connection_type").toString()));
      }
      // validate the optional field `company`
      if (jsonObj.get("company") != null && !jsonObj.get("company").isJsonNull()) {
        NetworkCompany.validateJsonElement(jsonObj.get("company"));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!Network.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'Network' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<Network> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(Network.class));

       return (TypeAdapter<T>) new TypeAdapter<Network>() {
           @Override
           public void write(JsonWriter out, Network value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public Network read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

  /**
   * Create an instance of Network given an JSON string
   *
   * @param jsonString JSON string
   * @return An instance of Network
   * @throws IOException if the JSON string is invalid with respect to Network
   */
  public static Network fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, Network.class);
  }

  /**
   * Convert an instance of Network to an JSON string
   *
   * @return JSON string
   */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

