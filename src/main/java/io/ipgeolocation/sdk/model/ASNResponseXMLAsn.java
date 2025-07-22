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
import java.net.URI;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import io.ipgeolocation.sdk.invoker.JSON;

/**
 * ASNResponseXMLAsn
 */

public class ASNResponseXMLAsn {
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
  private URI domain;

  public static final String SERIALIZED_NAME_DATE_ALLOCATED = "date_allocated";
  @SerializedName(SERIALIZED_NAME_DATE_ALLOCATED)
  @javax.annotation.Nullable
  private LocalDate dateAllocated;

  public static final String SERIALIZED_NAME_ALLOCATION_STATUS = "allocation_status";
  @SerializedName(SERIALIZED_NAME_ALLOCATION_STATUS)
  @javax.annotation.Nullable
  private String allocationStatus;

  public static final String SERIALIZED_NAME_NUM_OF_IPV4_ROUTES = "num_of_ipv4_routes";
  @SerializedName(SERIALIZED_NAME_NUM_OF_IPV4_ROUTES)
  @javax.annotation.Nullable
  private Integer numOfIpv4Routes;

  public static final String SERIALIZED_NAME_NUM_OF_IPV6_ROUTES = "num_of_ipv6_routes";
  @SerializedName(SERIALIZED_NAME_NUM_OF_IPV6_ROUTES)
  @javax.annotation.Nullable
  private Integer numOfIpv6Routes;

  public static final String SERIALIZED_NAME_RIR = "rir";
  @SerializedName(SERIALIZED_NAME_RIR)
  @javax.annotation.Nullable
  private String rir;

  public static final String SERIALIZED_NAME_ROUTES = "routes";
  @SerializedName(SERIALIZED_NAME_ROUTES)
  @javax.annotation.Nullable
  private List<String> routes = new ArrayList<>();

  public static final String SERIALIZED_NAME_UPSTREAMS = "upstreams";
  @SerializedName(SERIALIZED_NAME_UPSTREAMS)
  @javax.annotation.Nullable
  private List<ASNConnection> upstreams = new ArrayList<>();

  public static final String SERIALIZED_NAME_DOWNSTREAMS = "downstreams";
  @SerializedName(SERIALIZED_NAME_DOWNSTREAMS)
  @javax.annotation.Nullable
  private List<ASNConnection> downstreams = new ArrayList<>();

  public static final String SERIALIZED_NAME_PEERS = "peers";
  @SerializedName(SERIALIZED_NAME_PEERS)
  @javax.annotation.Nullable
  private List<ASNConnection> peers = new ArrayList<>();

  public static final String SERIALIZED_NAME_WHOIS_RESPONSE = "whois_response";
  @SerializedName(SERIALIZED_NAME_WHOIS_RESPONSE)
  @javax.annotation.Nullable
  private String whoisResponse;

  public ASNResponseXMLAsn() {
  }

  public ASNResponseXMLAsn asNumber(@javax.annotation.Nullable String asNumber) {
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


  public ASNResponseXMLAsn organization(@javax.annotation.Nullable String organization) {
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


  public ASNResponseXMLAsn country(@javax.annotation.Nullable String country) {
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


  public ASNResponseXMLAsn asnName(@javax.annotation.Nullable String asnName) {
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


  public ASNResponseXMLAsn type(@javax.annotation.Nullable String type) {
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


  public ASNResponseXMLAsn domain(@javax.annotation.Nullable URI domain) {
    this.domain = domain;
    return this;
  }

  /**
   * Get domain
   * @return domain
   */
  @javax.annotation.Nullable
  public URI getDomain() {
    return domain;
  }

  public void setDomain(@javax.annotation.Nullable URI domain) {
    this.domain = domain;
  }


  public ASNResponseXMLAsn dateAllocated(@javax.annotation.Nullable LocalDate dateAllocated) {
    this.dateAllocated = dateAllocated;
    return this;
  }

  /**
   * Get dateAllocated
   * @return dateAllocated
   */
  @javax.annotation.Nullable
  public LocalDate getDateAllocated() {
    return dateAllocated;
  }

  public void setDateAllocated(@javax.annotation.Nullable LocalDate dateAllocated) {
    this.dateAllocated = dateAllocated;
  }


  public ASNResponseXMLAsn allocationStatus(@javax.annotation.Nullable String allocationStatus) {
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


  public ASNResponseXMLAsn numOfIpv4Routes(@javax.annotation.Nullable Integer numOfIpv4Routes) {
    this.numOfIpv4Routes = numOfIpv4Routes;
    return this;
  }

  /**
   * Get numOfIpv4Routes
   * @return numOfIpv4Routes
   */
  @javax.annotation.Nullable
  public Integer getNumOfIpv4Routes() {
    return numOfIpv4Routes;
  }

  public void setNumOfIpv4Routes(@javax.annotation.Nullable Integer numOfIpv4Routes) {
    this.numOfIpv4Routes = numOfIpv4Routes;
  }


  public ASNResponseXMLAsn numOfIpv6Routes(@javax.annotation.Nullable Integer numOfIpv6Routes) {
    this.numOfIpv6Routes = numOfIpv6Routes;
    return this;
  }

  /**
   * Get numOfIpv6Routes
   * @return numOfIpv6Routes
   */
  @javax.annotation.Nullable
  public Integer getNumOfIpv6Routes() {
    return numOfIpv6Routes;
  }

  public void setNumOfIpv6Routes(@javax.annotation.Nullable Integer numOfIpv6Routes) {
    this.numOfIpv6Routes = numOfIpv6Routes;
  }


  public ASNResponseXMLAsn rir(@javax.annotation.Nullable String rir) {
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


  public ASNResponseXMLAsn routes(@javax.annotation.Nullable List<String> routes) {
    this.routes = routes;
    return this;
  }

  public ASNResponseXMLAsn addRoutesItem(String routesItem) {
    if (this.routes == null) {
      this.routes = new ArrayList<>();
    }
    this.routes.add(routesItem);
    return this;
  }

  /**
   * It will only be included in the response, if you set include&#x3D;routes in the request
   * @return routes
   */
  @javax.annotation.Nullable
  public List<String> getRoutes() {
    return routes;
  }

  public void setRoutes(@javax.annotation.Nullable List<String> routes) {
    this.routes = routes;
  }


  public ASNResponseXMLAsn upstreams(@javax.annotation.Nullable List<ASNConnection> upstreams) {
    this.upstreams = upstreams;
    return this;
  }

  public ASNResponseXMLAsn addUpstreamsItem(ASNConnection upstreamsItem) {
    if (this.upstreams == null) {
      this.upstreams = new ArrayList<>();
    }
    this.upstreams.add(upstreamsItem);
    return this;
  }

  /**
   * Get upstreams
   * @return upstreams
   */
  @javax.annotation.Nullable
  public List<ASNConnection> getUpstreams() {
    return upstreams;
  }

  public void setUpstreams(@javax.annotation.Nullable List<ASNConnection> upstreams) {
    this.upstreams = upstreams;
  }


  public ASNResponseXMLAsn downstreams(@javax.annotation.Nullable List<ASNConnection> downstreams) {
    this.downstreams = downstreams;
    return this;
  }

  public ASNResponseXMLAsn addDownstreamsItem(ASNConnection downstreamsItem) {
    if (this.downstreams == null) {
      this.downstreams = new ArrayList<>();
    }
    this.downstreams.add(downstreamsItem);
    return this;
  }

  /**
   * Get downstreams
   * @return downstreams
   */
  @javax.annotation.Nullable
  public List<ASNConnection> getDownstreams() {
    return downstreams;
  }

  public void setDownstreams(@javax.annotation.Nullable List<ASNConnection> downstreams) {
    this.downstreams = downstreams;
  }


  public ASNResponseXMLAsn peers(@javax.annotation.Nullable List<ASNConnection> peers) {
    this.peers = peers;
    return this;
  }

  public ASNResponseXMLAsn addPeersItem(ASNConnection peersItem) {
    if (this.peers == null) {
      this.peers = new ArrayList<>();
    }
    this.peers.add(peersItem);
    return this;
  }

  /**
   * Get peers
   * @return peers
   */
  @javax.annotation.Nullable
  public List<ASNConnection> getPeers() {
    return peers;
  }

  public void setPeers(@javax.annotation.Nullable List<ASNConnection> peers) {
    this.peers = peers;
  }


  public ASNResponseXMLAsn whoisResponse(@javax.annotation.Nullable String whoisResponse) {
    this.whoisResponse = whoisResponse;
    return this;
  }

  /**
   * Get whoisResponse
   * @return whoisResponse
   */
  @javax.annotation.Nullable
  public String getWhoisResponse() {
    return whoisResponse;
  }

  public void setWhoisResponse(@javax.annotation.Nullable String whoisResponse) {
    this.whoisResponse = whoisResponse;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ASNResponseXMLAsn asNResponseXMLAsn = (ASNResponseXMLAsn) o;
    return Objects.equals(this.asNumber, asNResponseXMLAsn.asNumber) &&
        Objects.equals(this.organization, asNResponseXMLAsn.organization) &&
        Objects.equals(this.country, asNResponseXMLAsn.country) &&
        Objects.equals(this.asnName, asNResponseXMLAsn.asnName) &&
        Objects.equals(this.type, asNResponseXMLAsn.type) &&
        Objects.equals(this.domain, asNResponseXMLAsn.domain) &&
        Objects.equals(this.dateAllocated, asNResponseXMLAsn.dateAllocated) &&
        Objects.equals(this.allocationStatus, asNResponseXMLAsn.allocationStatus) &&
        Objects.equals(this.numOfIpv4Routes, asNResponseXMLAsn.numOfIpv4Routes) &&
        Objects.equals(this.numOfIpv6Routes, asNResponseXMLAsn.numOfIpv6Routes) &&
        Objects.equals(this.rir, asNResponseXMLAsn.rir) &&
        Objects.equals(this.routes, asNResponseXMLAsn.routes) &&
        Objects.equals(this.upstreams, asNResponseXMLAsn.upstreams) &&
        Objects.equals(this.downstreams, asNResponseXMLAsn.downstreams) &&
        Objects.equals(this.peers, asNResponseXMLAsn.peers) &&
        Objects.equals(this.whoisResponse, asNResponseXMLAsn.whoisResponse);
  }

  @Override
  public int hashCode() {
    return Objects.hash(asNumber, organization, country, asnName, type, domain, dateAllocated, allocationStatus, numOfIpv4Routes, numOfIpv6Routes, rir, routes, upstreams, downstreams, peers, whoisResponse);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ASNResponseXMLAsn {\n");
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
    sb.append("    routes: ").append(toIndentedString(routes)).append("\n");
    sb.append("    upstreams: ").append(toIndentedString(upstreams)).append("\n");
    sb.append("    downstreams: ").append(toIndentedString(downstreams)).append("\n");
    sb.append("    peers: ").append(toIndentedString(peers)).append("\n");
    sb.append("    whoisResponse: ").append(toIndentedString(whoisResponse)).append("\n");
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
    ipGeoFields.add("routes");
    ipGeoFields.add("upstreams");
    ipGeoFields.add("downstreams");
    ipGeoFields.add("peers");
    ipGeoFields.add("whois_response");

    // a set of required properties/fields (JSON key names)
    ipGeoRequiredFields = new HashSet<String>();
  }

  /**
   * Validates the JSON Element and throws an exception if issues found
   *
   * @param jsonElement JSON Element
   * @throws IOException if the JSON Element is invalid with respect to ASNResponseXMLAsn
   */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!ASNResponseXMLAsn.ipGeoRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in ASNResponseXMLAsn is not found in the empty JSON string", ASNResponseXMLAsn.ipGeoRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!ASNResponseXMLAsn.ipGeoFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `ASNResponseXMLAsn` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
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
      if ((jsonObj.get("allocation_status") != null && !jsonObj.get("allocation_status").isJsonNull()) && !jsonObj.get("allocation_status").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `allocation_status` to be a primitive type in the JSON string but got `%s`", jsonObj.get("allocation_status").toString()));
      }
      if ((jsonObj.get("rir") != null && !jsonObj.get("rir").isJsonNull()) && !jsonObj.get("rir").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `rir` to be a primitive type in the JSON string but got `%s`", jsonObj.get("rir").toString()));
      }
      // ensure the optional json data is an array if present
      if (jsonObj.get("routes") != null && !jsonObj.get("routes").isJsonNull() && !jsonObj.get("routes").isJsonArray()) {
        throw new IllegalArgumentException(String.format("Expected the field `routes` to be an array in the JSON string but got `%s`", jsonObj.get("routes").toString()));
      }
      if (jsonObj.get("upstreams") != null && !jsonObj.get("upstreams").isJsonNull()) {
        JsonArray jsonArrayupstreams = jsonObj.getAsJsonArray("upstreams");
        if (jsonArrayupstreams != null) {
          // ensure the json data is an array
          if (!jsonObj.get("upstreams").isJsonArray()) {
            throw new IllegalArgumentException(String.format("Expected the field `upstreams` to be an array in the JSON string but got `%s`", jsonObj.get("upstreams").toString()));
          }

          // validate the optional field `upstreams` (array)
          for (int i = 0; i < jsonArrayupstreams.size(); i++) {
            ASNConnection.validateJsonElement(jsonArrayupstreams.get(i));
          };
        }
      }
      if (jsonObj.get("downstreams") != null && !jsonObj.get("downstreams").isJsonNull()) {
        JsonArray jsonArraydownstreams = jsonObj.getAsJsonArray("downstreams");
        if (jsonArraydownstreams != null) {
          // ensure the json data is an array
          if (!jsonObj.get("downstreams").isJsonArray()) {
            throw new IllegalArgumentException(String.format("Expected the field `downstreams` to be an array in the JSON string but got `%s`", jsonObj.get("downstreams").toString()));
          }

          // validate the optional field `downstreams` (array)
          for (int i = 0; i < jsonArraydownstreams.size(); i++) {
            ASNConnection.validateJsonElement(jsonArraydownstreams.get(i));
          };
        }
      }
      if (jsonObj.get("peers") != null && !jsonObj.get("peers").isJsonNull()) {
        JsonArray jsonArraypeers = jsonObj.getAsJsonArray("peers");
        if (jsonArraypeers != null) {
          // ensure the json data is an array
          if (!jsonObj.get("peers").isJsonArray()) {
            throw new IllegalArgumentException(String.format("Expected the field `peers` to be an array in the JSON string but got `%s`", jsonObj.get("peers").toString()));
          }

          // validate the optional field `peers` (array)
          for (int i = 0; i < jsonArraypeers.size(); i++) {
            ASNConnection.validateJsonElement(jsonArraypeers.get(i));
          };
        }
      }
      if ((jsonObj.get("whois_response") != null && !jsonObj.get("whois_response").isJsonNull()) && !jsonObj.get("whois_response").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `whois_response` to be a primitive type in the JSON string but got `%s`", jsonObj.get("whois_response").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!ASNResponseXMLAsn.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'ASNResponseXMLAsn' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<ASNResponseXMLAsn> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(ASNResponseXMLAsn.class));

       return (TypeAdapter<T>) new TypeAdapter<ASNResponseXMLAsn>() {
           @Override
           public void write(JsonWriter out, ASNResponseXMLAsn value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public ASNResponseXMLAsn read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

  /**
   * Create an instance of ASNResponseXMLAsn given an JSON string
   *
   * @param jsonString JSON string
   * @return An instance of ASNResponseXMLAsn
   * @throws IOException if the JSON string is invalid with respect to ASNResponseXMLAsn
   */
  public static ASNResponseXMLAsn fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, ASNResponseXMLAsn.class);
  }

  /**
   * Convert an instance of ASNResponseXMLAsn to an JSON string
   *
   * @return JSON string
   */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

