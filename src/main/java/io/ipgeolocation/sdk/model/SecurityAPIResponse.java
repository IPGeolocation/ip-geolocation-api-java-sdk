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
 * SecurityAPIResponse
 */

public class SecurityAPIResponse {
  public static final String SERIALIZED_NAME_IP = "ip";
  @SerializedName(SERIALIZED_NAME_IP)
  @javax.annotation.Nullable
  private String ip;

  public static final String SERIALIZED_NAME_HOSTNAME = "hostname";
  @SerializedName(SERIALIZED_NAME_HOSTNAME)
  @javax.annotation.Nullable
  private String hostname;

  public static final String SERIALIZED_NAME_SECURITY = "security";
  @SerializedName(SERIALIZED_NAME_SECURITY)
  @javax.annotation.Nullable
  private Security security;

  public static final String SERIALIZED_NAME_LOCATION = "location";
  @SerializedName(SERIALIZED_NAME_LOCATION)
  @javax.annotation.Nullable
  private LocationMinimal location;

  public static final String SERIALIZED_NAME_NETWORK = "network";
  @SerializedName(SERIALIZED_NAME_NETWORK)
  @javax.annotation.Nullable
  private NetworkMinimal network;

  public static final String SERIALIZED_NAME_TIME_ZONE = "time_zone";
  @SerializedName(SERIALIZED_NAME_TIME_ZONE)
  @javax.annotation.Nullable
  private TimeZone timeZone;

  public static final String SERIALIZED_NAME_USER_AGENT = "user_agent";
  @SerializedName(SERIALIZED_NAME_USER_AGENT)
  @javax.annotation.Nullable
  private UserAgentData userAgent;

  public static final String SERIALIZED_NAME_COUNTRY_METADATA = "country_metadata";
  @SerializedName(SERIALIZED_NAME_COUNTRY_METADATA)
  @javax.annotation.Nullable
  private CountryMetadata countryMetadata;

  public static final String SERIALIZED_NAME_CURRENCY = "currency";
  @SerializedName(SERIALIZED_NAME_CURRENCY)
  @javax.annotation.Nullable
  private Currency currency;

  public SecurityAPIResponse() {
  }

  public SecurityAPIResponse ip(@javax.annotation.Nullable String ip) {
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


  public SecurityAPIResponse hostname(@javax.annotation.Nullable String hostname) {
    this.hostname = hostname;
    return this;
  }

  /**
   * Get hostname
   * @return hostname
   */
  @javax.annotation.Nullable
  public String getHostname() {
    return hostname;
  }

  public void setHostname(@javax.annotation.Nullable String hostname) {
    this.hostname = hostname;
  }


  public SecurityAPIResponse security(@javax.annotation.Nullable Security security) {
    this.security = security;
    return this;
  }

  /**
   * Get security
   * @return security
   */
  @javax.annotation.Nullable
  public Security getSecurity() {
    return security;
  }

  public void setSecurity(@javax.annotation.Nullable Security security) {
    this.security = security;
  }


  public SecurityAPIResponse location(@javax.annotation.Nullable LocationMinimal location) {
    this.location = location;
    return this;
  }

  /**
   * Get location
   * @return location
   */
  @javax.annotation.Nullable
  public LocationMinimal getLocation() {
    return location;
  }

  public void setLocation(@javax.annotation.Nullable LocationMinimal location) {
    this.location = location;
  }


  public SecurityAPIResponse network(@javax.annotation.Nullable NetworkMinimal network) {
    this.network = network;
    return this;
  }

  /**
   * Get network
   * @return network
   */
  @javax.annotation.Nullable
  public NetworkMinimal getNetwork() {
    return network;
  }

  public void setNetwork(@javax.annotation.Nullable NetworkMinimal network) {
    this.network = network;
  }


  public SecurityAPIResponse timeZone(@javax.annotation.Nullable TimeZone timeZone) {
    this.timeZone = timeZone;
    return this;
  }

  /**
   * Get timeZone
   * @return timeZone
   */
  @javax.annotation.Nullable
  public TimeZone getTimeZone() {
    return timeZone;
  }

  public void setTimeZone(@javax.annotation.Nullable TimeZone timeZone) {
    this.timeZone = timeZone;
  }


  public SecurityAPIResponse userAgent(@javax.annotation.Nullable UserAgentData userAgent) {
    this.userAgent = userAgent;
    return this;
  }

  /**
   * Get userAgent
   * @return userAgent
   */
  @javax.annotation.Nullable
  public UserAgentData getUserAgent() {
    return userAgent;
  }

  public void setUserAgent(@javax.annotation.Nullable UserAgentData userAgent) {
    this.userAgent = userAgent;
  }


  public SecurityAPIResponse countryMetadata(@javax.annotation.Nullable CountryMetadata countryMetadata) {
    this.countryMetadata = countryMetadata;
    return this;
  }

  /**
   * Get countryMetadata
   * @return countryMetadata
   */
  @javax.annotation.Nullable
  public CountryMetadata getCountryMetadata() {
    return countryMetadata;
  }

  public void setCountryMetadata(@javax.annotation.Nullable CountryMetadata countryMetadata) {
    this.countryMetadata = countryMetadata;
  }


  public SecurityAPIResponse currency(@javax.annotation.Nullable Currency currency) {
    this.currency = currency;
    return this;
  }

  /**
   * Get currency
   * @return currency
   */
  @javax.annotation.Nullable
  public Currency getCurrency() {
    return currency;
  }

  public void setCurrency(@javax.annotation.Nullable Currency currency) {
    this.currency = currency;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SecurityAPIResponse securityAPIResponse = (SecurityAPIResponse) o;
    return Objects.equals(this.ip, securityAPIResponse.ip) &&
        Objects.equals(this.hostname, securityAPIResponse.hostname) &&
        Objects.equals(this.security, securityAPIResponse.security) &&
        Objects.equals(this.location, securityAPIResponse.location) &&
        Objects.equals(this.network, securityAPIResponse.network) &&
        Objects.equals(this.timeZone, securityAPIResponse.timeZone) &&
        Objects.equals(this.userAgent, securityAPIResponse.userAgent) &&
        Objects.equals(this.countryMetadata, securityAPIResponse.countryMetadata) &&
        Objects.equals(this.currency, securityAPIResponse.currency);
  }

  @Override
  public int hashCode() {
    return Objects.hash(ip, hostname, security, location, network, timeZone, userAgent, countryMetadata, currency);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SecurityAPIResponse {\n");
    sb.append("    ip: ").append(toIndentedString(ip)).append("\n");
    sb.append("    hostname: ").append(toIndentedString(hostname)).append("\n");
    sb.append("    security: ").append(toIndentedString(security)).append("\n");
    sb.append("    location: ").append(toIndentedString(location)).append("\n");
    sb.append("    network: ").append(toIndentedString(network)).append("\n");
    sb.append("    timeZone: ").append(toIndentedString(timeZone)).append("\n");
    sb.append("    userAgent: ").append(toIndentedString(userAgent)).append("\n");
    sb.append("    countryMetadata: ").append(toIndentedString(countryMetadata)).append("\n");
    sb.append("    currency: ").append(toIndentedString(currency)).append("\n");
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
    ipGeoFields.add("hostname");
    ipGeoFields.add("security");
    ipGeoFields.add("location");
    ipGeoFields.add("network");
    ipGeoFields.add("time_zone");
    ipGeoFields.add("user_agent");
    ipGeoFields.add("country_metadata");
    ipGeoFields.add("currency");

    // a set of required properties/fields (JSON key names)
    ipGeoRequiredFields = new HashSet<String>();
  }

  /**
   * Validates the JSON Element and throws an exception if issues found
   *
   * @param jsonElement JSON Element
   * @throws IOException if the JSON Element is invalid with respect to SecurityAPIResponse
   */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!SecurityAPIResponse.ipGeoRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in SecurityAPIResponse is not found in the empty JSON string", SecurityAPIResponse.ipGeoRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!SecurityAPIResponse.ipGeoFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `SecurityAPIResponse` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
      if ((jsonObj.get("ip") != null && !jsonObj.get("ip").isJsonNull()) && !jsonObj.get("ip").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `ip` to be a primitive type in the JSON string but got `%s`", jsonObj.get("ip").toString()));
      }
      if ((jsonObj.get("hostname") != null && !jsonObj.get("hostname").isJsonNull()) && !jsonObj.get("hostname").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `hostname` to be a primitive type in the JSON string but got `%s`", jsonObj.get("hostname").toString()));
      }
      // validate the optional field `security`
      if (jsonObj.get("security") != null && !jsonObj.get("security").isJsonNull()) {
        Security.validateJsonElement(jsonObj.get("security"));
      }
      // validate the optional field `location`
      if (jsonObj.get("location") != null && !jsonObj.get("location").isJsonNull()) {
        LocationMinimal.validateJsonElement(jsonObj.get("location"));
      }
      // validate the optional field `network`
      if (jsonObj.get("network") != null && !jsonObj.get("network").isJsonNull()) {
        NetworkMinimal.validateJsonElement(jsonObj.get("network"));
      }
      // validate the optional field `time_zone`
      if (jsonObj.get("time_zone") != null && !jsonObj.get("time_zone").isJsonNull()) {
        TimeZone.validateJsonElement(jsonObj.get("time_zone"));
      }
      // validate the optional field `user_agent`
      if (jsonObj.get("user_agent") != null && !jsonObj.get("user_agent").isJsonNull()) {
        UserAgentData.validateJsonElement(jsonObj.get("user_agent"));
      }
      // validate the optional field `country_metadata`
      if (jsonObj.get("country_metadata") != null && !jsonObj.get("country_metadata").isJsonNull()) {
        CountryMetadata.validateJsonElement(jsonObj.get("country_metadata"));
      }
      // validate the optional field `currency`
      if (jsonObj.get("currency") != null && !jsonObj.get("currency").isJsonNull()) {
        Currency.validateJsonElement(jsonObj.get("currency"));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!SecurityAPIResponse.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'SecurityAPIResponse' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<SecurityAPIResponse> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(SecurityAPIResponse.class));

       return (TypeAdapter<T>) new TypeAdapter<SecurityAPIResponse>() {
           @Override
           public void write(JsonWriter out, SecurityAPIResponse value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public SecurityAPIResponse read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

  /**
   * Create an instance of SecurityAPIResponse given an JSON string
   *
   * @param jsonString JSON string
   * @return An instance of SecurityAPIResponse
   * @throws IOException if the JSON string is invalid with respect to SecurityAPIResponse
   */
  public static SecurityAPIResponse fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, SecurityAPIResponse.class);
  }

  /**
   * Convert an instance of SecurityAPIResponse to an JSON string
   *
   * @return JSON string
   */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

