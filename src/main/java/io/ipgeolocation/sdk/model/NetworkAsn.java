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
 * NetworkAsn
 */

public class NetworkAsn {
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

  public static final String SERIALIZED_NAME_ASN_NAME = "asn_name";
  @SerializedName(SERIALIZED_NAME_ASN_NAME)
  @javax.annotation.Nullable
  private String asnName;

  public static final String SERIALIZED_NAME_TYPE = "type";
  @SerializedName(SERIALIZED_NAME_TYPE)
  @javax.annotation.Nullable
  private String type;

  public static final String SERIALIZED_NAME_DOMAIN = "domain";
  @SerializedName(SERIALIZED_NAME_DOMAIN)
  @javax.annotation.Nullable
  private String domain;

  public static final String SERIALIZED_NAME_DATE_ALLOCATED = "date_allocated";
  @SerializedName(SERIALIZED_NAME_DATE_ALLOCATED)
  @javax.annotation.Nullable
  private String dateAllocated;

  public static final String SERIALIZED_NAME_ALLOCATION_STATUS = "allocation_status";
  @SerializedName(SERIALIZED_NAME_ALLOCATION_STATUS)
  @javax.annotation.Nullable
  private String allocationStatus;

  public static final String SERIALIZED_NAME_NUM_OF_IPV4_ROUTES = "num_of_ipv4_routes";
  @SerializedName(SERIALIZED_NAME_NUM_OF_IPV4_ROUTES)
  @javax.annotation.Nullable
  private String numOfIpv4Routes;

  public static final String SERIALIZED_NAME_NUM_OF_IPV6_ROUTES = "num_of_ipv6_routes";
  @SerializedName(SERIALIZED_NAME_NUM_OF_IPV6_ROUTES)
  @javax.annotation.Nullable
  private String numOfIpv6Routes;

  public static final String SERIALIZED_NAME_RIR = "rir";
  @SerializedName(SERIALIZED_NAME_RIR)
  @javax.annotation.Nullable
  private String rir;

  public NetworkAsn() {
  }

  public NetworkAsn asNumber(@javax.annotation.Nullable String asNumber) {
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


  public NetworkAsn organization(@javax.annotation.Nullable String organization) {
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


  public NetworkAsn country(@javax.annotation.Nullable String country) {
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


  public NetworkAsn asnName(@javax.annotation.Nullable String asnName) {
    this.asnName = asnName;
    return this;
  }

  /**
   * Get asnName
   * @return asnName
   */
  @javax.annotation.Nullable
  public String getAsnName() {
    return asnName;
  }

  public void setAsnName(@javax.annotation.Nullable String asnName) {
    this.asnName = asnName;
  }


  public NetworkAsn type(@javax.annotation.Nullable String type) {
    this.type = type;
    return this;
  }

  /**
   * Get type
   * @return type
   */
  @javax.annotation.Nullable
  public String getType() {
    return type;
  }

  public void setType(@javax.annotation.Nullable String type) {
    this.type = type;
  }


  public NetworkAsn domain(@javax.annotation.Nullable String domain) {
    this.domain = domain;
    return this;
  }

  /**
   * Get domain
   * @return domain
   */
  @javax.annotation.Nullable
  public String getDomain() {
    return domain;
  }

  public void setDomain(@javax.annotation.Nullable String domain) {
    this.domain = domain;
  }


  public NetworkAsn dateAllocated(@javax.annotation.Nullable String dateAllocated) {
    this.dateAllocated = dateAllocated;
    return this;
  }

  /**
   * Get dateAllocated
   * @return dateAllocated
   */
  @javax.annotation.Nullable
  public String getDateAllocated() {
    return dateAllocated;
  }

  public void setDateAllocated(@javax.annotation.Nullable String dateAllocated) {
    this.dateAllocated = dateAllocated;
  }


  public NetworkAsn allocationStatus(@javax.annotation.Nullable String allocationStatus) {
    this.allocationStatus = allocationStatus;
    return this;
  }

  /**
   * Get allocationStatus
   * @return allocationStatus
   */
  @javax.annotation.Nullable
  public String getAllocationStatus() {
    return allocationStatus;
  }

  public void setAllocationStatus(@javax.annotation.Nullable String allocationStatus) {
    this.allocationStatus = allocationStatus;
  }


  public NetworkAsn numOfIpv4Routes(@javax.annotation.Nullable String numOfIpv4Routes) {
    this.numOfIpv4Routes = numOfIpv4Routes;
    return this;
  }

  /**
   * Get numOfIpv4Routes
   * @return numOfIpv4Routes
   */
  @javax.annotation.Nullable
  public String getNumOfIpv4Routes() {
    return numOfIpv4Routes;
  }

  public void setNumOfIpv4Routes(@javax.annotation.Nullable String numOfIpv4Routes) {
    this.numOfIpv4Routes = numOfIpv4Routes;
  }


  public NetworkAsn numOfIpv6Routes(@javax.annotation.Nullable String numOfIpv6Routes) {
    this.numOfIpv6Routes = numOfIpv6Routes;
    return this;
  }

  /**
   * Get numOfIpv6Routes
   * @return numOfIpv6Routes
   */
  @javax.annotation.Nullable
  public String getNumOfIpv6Routes() {
    return numOfIpv6Routes;
  }

  public void setNumOfIpv6Routes(@javax.annotation.Nullable String numOfIpv6Routes) {
    this.numOfIpv6Routes = numOfIpv6Routes;
  }


  public NetworkAsn rir(@javax.annotation.Nullable String rir) {
    this.rir = rir;
    return this;
  }

  /**
   * Get rir
   * @return rir
   */
  @javax.annotation.Nullable
  public String getRir() {
    return rir;
  }

  public void setRir(@javax.annotation.Nullable String rir) {
    this.rir = rir;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    NetworkAsn networkAsn = (NetworkAsn) o;
    return Objects.equals(this.asNumber, networkAsn.asNumber) &&
        Objects.equals(this.organization, networkAsn.organization) &&
        Objects.equals(this.country, networkAsn.country) &&
        Objects.equals(this.asnName, networkAsn.asnName) &&
        Objects.equals(this.type, networkAsn.type) &&
        Objects.equals(this.domain, networkAsn.domain) &&
        Objects.equals(this.dateAllocated, networkAsn.dateAllocated) &&
        Objects.equals(this.allocationStatus, networkAsn.allocationStatus) &&
        Objects.equals(this.numOfIpv4Routes, networkAsn.numOfIpv4Routes) &&
        Objects.equals(this.numOfIpv6Routes, networkAsn.numOfIpv6Routes) &&
        Objects.equals(this.rir, networkAsn.rir);
  }

  @Override
  public int hashCode() {
    return Objects.hash(asNumber, organization, country, asnName, type, domain, dateAllocated, allocationStatus, numOfIpv4Routes, numOfIpv6Routes, rir);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class NetworkAsn {\n");
    sb.append("    asNumber: ").append(toIndentedString(asNumber)).append("\n");
    sb.append("    organization: ").append(toIndentedString(organization)).append("\n");
    sb.append("    country: ").append(toIndentedString(country)).append("\n");
    sb.append("    asnName: ").append(toIndentedString(asnName)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    domain: ").append(toIndentedString(domain)).append("\n");
    sb.append("    dateAllocated: ").append(toIndentedString(dateAllocated)).append("\n");
    sb.append("    allocationStatus: ").append(toIndentedString(allocationStatus)).append("\n");
    sb.append("    numOfIpv4Routes: ").append(toIndentedString(numOfIpv4Routes)).append("\n");
    sb.append("    numOfIpv6Routes: ").append(toIndentedString(numOfIpv6Routes)).append("\n");
    sb.append("    rir: ").append(toIndentedString(rir)).append("\n");
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
    ipGeoFields.add("asn_name");
    ipGeoFields.add("type");
    ipGeoFields.add("domain");
    ipGeoFields.add("date_allocated");
    ipGeoFields.add("allocation_status");
    ipGeoFields.add("num_of_ipv4_routes");
    ipGeoFields.add("num_of_ipv6_routes");
    ipGeoFields.add("rir");

    // a set of required properties/fields (JSON key names)
    ipGeoRequiredFields = new HashSet<String>();
  }

  /**
   * Validates the JSON Element and throws an exception if issues found
   *
   * @param jsonElement JSON Element
   * @throws IOException if the JSON Element is invalid with respect to NetworkAsn
   */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!NetworkAsn.ipGeoRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in NetworkAsn is not found in the empty JSON string", NetworkAsn.ipGeoRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!NetworkAsn.ipGeoFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `NetworkAsn` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
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
      if ((jsonObj.get("asn_name") != null && !jsonObj.get("asn_name").isJsonNull()) && !jsonObj.get("asn_name").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `asn_name` to be a primitive type in the JSON string but got `%s`", jsonObj.get("asn_name").toString()));
      }
      if ((jsonObj.get("type") != null && !jsonObj.get("type").isJsonNull()) && !jsonObj.get("type").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `type` to be a primitive type in the JSON string but got `%s`", jsonObj.get("type").toString()));
      }
      if ((jsonObj.get("domain") != null && !jsonObj.get("domain").isJsonNull()) && !jsonObj.get("domain").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `domain` to be a primitive type in the JSON string but got `%s`", jsonObj.get("domain").toString()));
      }
      if ((jsonObj.get("date_allocated") != null && !jsonObj.get("date_allocated").isJsonNull()) && !jsonObj.get("date_allocated").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `date_allocated` to be a primitive type in the JSON string but got `%s`", jsonObj.get("date_allocated").toString()));
      }
      if ((jsonObj.get("allocation_status") != null && !jsonObj.get("allocation_status").isJsonNull()) && !jsonObj.get("allocation_status").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `allocation_status` to be a primitive type in the JSON string but got `%s`", jsonObj.get("allocation_status").toString()));
      }
      if ((jsonObj.get("num_of_ipv4_routes") != null && !jsonObj.get("num_of_ipv4_routes").isJsonNull()) && !jsonObj.get("num_of_ipv4_routes").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `num_of_ipv4_routes` to be a primitive type in the JSON string but got `%s`", jsonObj.get("num_of_ipv4_routes").toString()));
      }
      if ((jsonObj.get("num_of_ipv6_routes") != null && !jsonObj.get("num_of_ipv6_routes").isJsonNull()) && !jsonObj.get("num_of_ipv6_routes").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `num_of_ipv6_routes` to be a primitive type in the JSON string but got `%s`", jsonObj.get("num_of_ipv6_routes").toString()));
      }
      if ((jsonObj.get("rir") != null && !jsonObj.get("rir").isJsonNull()) && !jsonObj.get("rir").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `rir` to be a primitive type in the JSON string but got `%s`", jsonObj.get("rir").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!NetworkAsn.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'NetworkAsn' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<NetworkAsn> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(NetworkAsn.class));

       return (TypeAdapter<T>) new TypeAdapter<NetworkAsn>() {
           @Override
           public void write(JsonWriter out, NetworkAsn value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public NetworkAsn read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

  /**
   * Create an instance of NetworkAsn given an JSON string
   *
   * @param jsonString JSON string
   * @return An instance of NetworkAsn
   * @throws IOException if the JSON string is invalid with respect to NetworkAsn
   */
  public static NetworkAsn fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, NetworkAsn.class);
  }

  /**
   * Convert an instance of NetworkAsn to an JSON string
   *
   * @return JSON string
   */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

