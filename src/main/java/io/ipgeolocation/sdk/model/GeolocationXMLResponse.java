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
 * GeolocationXMLResponse
 */

public class GeolocationXMLResponse {
  public static final String SERIALIZED_NAME_IP = "ip";
  @SerializedName(SERIALIZED_NAME_IP)
  @javax.annotation.Nullable
  private String ip;

  public static final String SERIALIZED_NAME_HOSTNAME = "hostname";
  @SerializedName(SERIALIZED_NAME_HOSTNAME)
  @javax.annotation.Nullable
  private String hostname;

  public static final String SERIALIZED_NAME_DOMAIN = "domain";
  @SerializedName(SERIALIZED_NAME_DOMAIN)
  @javax.annotation.Nullable
  private String domain;

  public static final String SERIALIZED_NAME_LOCATION = "location";
  @SerializedName(SERIALIZED_NAME_LOCATION)
  @javax.annotation.Nullable
  private Location location;

  public static final String SERIALIZED_NAME_COUNTRY_METADATA = "country_metadata";
  @SerializedName(SERIALIZED_NAME_COUNTRY_METADATA)
  @javax.annotation.Nullable
  private CountryMetadata countryMetadata;

  public static final String SERIALIZED_NAME_NETWORK = "network";
  @SerializedName(SERIALIZED_NAME_NETWORK)
  @javax.annotation.Nullable
  private Network network;

  public static final String SERIALIZED_NAME_CURRENCY = "currency";
  @SerializedName(SERIALIZED_NAME_CURRENCY)
  @javax.annotation.Nullable
  private Currency currency;

  public static final String SERIALIZED_NAME_SECURITY = "security";
  @SerializedName(SERIALIZED_NAME_SECURITY)
  @javax.annotation.Nullable
  private Security security;

  public static final String SERIALIZED_NAME_ABUSE = "abuse";
  @SerializedName(SERIALIZED_NAME_ABUSE)
  @javax.annotation.Nullable
  private Abuse abuse;

  public static final String SERIALIZED_NAME_TIME_ZONE = "time_zone";
  @SerializedName(SERIALIZED_NAME_TIME_ZONE)
  @javax.annotation.Nullable
  private TimeZone timeZone;

  public static final String SERIALIZED_NAME_USER_AGENT = "user_agent";
  @SerializedName(SERIALIZED_NAME_USER_AGENT)
  @javax.annotation.Nullable
  private UserAgentData userAgent;

  public GeolocationXMLResponse() {
  }

  public GeolocationXMLResponse ip(@javax.annotation.Nullable String ip) {
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


  public GeolocationXMLResponse hostname(@javax.annotation.Nullable String hostname) {
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


  public GeolocationXMLResponse domain(@javax.annotation.Nullable String domain) {
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


  public GeolocationXMLResponse location(@javax.annotation.Nullable Location location) {
    this.location = location;
    return this;
  }

  /**
   * Get location
   * @return location
   */
  @javax.annotation.Nullable
  public Location getLocation() {
    return location;
  }

  public void setLocation(@javax.annotation.Nullable Location location) {
    this.location = location;
  }


  public GeolocationXMLResponse countryMetadata(@javax.annotation.Nullable CountryMetadata countryMetadata) {
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


  public GeolocationXMLResponse network(@javax.annotation.Nullable Network network) {
    this.network = network;
    return this;
  }

  /**
   * Get network
   * @return network
   */
  @javax.annotation.Nullable
  public Network getNetwork() {
    return network;
  }

  public void setNetwork(@javax.annotation.Nullable Network network) {
    this.network = network;
  }


  public GeolocationXMLResponse currency(@javax.annotation.Nullable Currency currency) {
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


  public GeolocationXMLResponse security(@javax.annotation.Nullable Security security) {
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


  public GeolocationXMLResponse abuse(@javax.annotation.Nullable Abuse abuse) {
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


  public GeolocationXMLResponse timeZone(@javax.annotation.Nullable TimeZone timeZone) {
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


  public GeolocationXMLResponse userAgent(@javax.annotation.Nullable UserAgentData userAgent) {
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



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GeolocationXMLResponse geolocationXMLResponse = (GeolocationXMLResponse) o;
    return Objects.equals(this.ip, geolocationXMLResponse.ip) &&
        Objects.equals(this.hostname, geolocationXMLResponse.hostname) &&
        Objects.equals(this.domain, geolocationXMLResponse.domain) &&
        Objects.equals(this.location, geolocationXMLResponse.location) &&
        Objects.equals(this.countryMetadata, geolocationXMLResponse.countryMetadata) &&
        Objects.equals(this.network, geolocationXMLResponse.network) &&
        Objects.equals(this.currency, geolocationXMLResponse.currency) &&
        Objects.equals(this.security, geolocationXMLResponse.security) &&
        Objects.equals(this.abuse, geolocationXMLResponse.abuse) &&
        Objects.equals(this.timeZone, geolocationXMLResponse.timeZone) &&
        Objects.equals(this.userAgent, geolocationXMLResponse.userAgent);
  }

  @Override
  public int hashCode() {
    return Objects.hash(ip, hostname, domain, location, countryMetadata, network, currency, security, abuse, timeZone, userAgent);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GeolocationXMLResponse {\n");
    sb.append("    ip: ").append(toIndentedString(ip)).append("\n");
    sb.append("    hostname: ").append(toIndentedString(hostname)).append("\n");
    sb.append("    domain: ").append(toIndentedString(domain)).append("\n");
    sb.append("    location: ").append(toIndentedString(location)).append("\n");
    sb.append("    countryMetadata: ").append(toIndentedString(countryMetadata)).append("\n");
    sb.append("    network: ").append(toIndentedString(network)).append("\n");
    sb.append("    currency: ").append(toIndentedString(currency)).append("\n");
    sb.append("    security: ").append(toIndentedString(security)).append("\n");
    sb.append("    abuse: ").append(toIndentedString(abuse)).append("\n");
    sb.append("    timeZone: ").append(toIndentedString(timeZone)).append("\n");
    sb.append("    userAgent: ").append(toIndentedString(userAgent)).append("\n");
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
    ipGeoFields.add("domain");
    ipGeoFields.add("location");
    ipGeoFields.add("country_metadata");
    ipGeoFields.add("network");
    ipGeoFields.add("currency");
    ipGeoFields.add("security");
    ipGeoFields.add("abuse");
    ipGeoFields.add("time_zone");
    ipGeoFields.add("user_agent");

    // a set of required properties/fields (JSON key names)
    ipGeoRequiredFields = new HashSet<String>();
  }

  /**
   * Validates the JSON Element and throws an exception if issues found
   *
   * @param jsonElement JSON Element
   * @throws IOException if the JSON Element is invalid with respect to GeolocationXMLResponse
   */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!GeolocationXMLResponse.ipGeoRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in GeolocationXMLResponse is not found in the empty JSON string", GeolocationXMLResponse.ipGeoRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!GeolocationXMLResponse.ipGeoFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `GeolocationXMLResponse` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
      if ((jsonObj.get("ip") != null && !jsonObj.get("ip").isJsonNull()) && !jsonObj.get("ip").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `ip` to be a primitive type in the JSON string but got `%s`", jsonObj.get("ip").toString()));
      }
      if ((jsonObj.get("hostname") != null && !jsonObj.get("hostname").isJsonNull()) && !jsonObj.get("hostname").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `hostname` to be a primitive type in the JSON string but got `%s`", jsonObj.get("hostname").toString()));
      }
      if ((jsonObj.get("domain") != null && !jsonObj.get("domain").isJsonNull()) && !jsonObj.get("domain").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `domain` to be a primitive type in the JSON string but got `%s`", jsonObj.get("domain").toString()));
      }
      // validate the optional field `location`
      if (jsonObj.get("location") != null && !jsonObj.get("location").isJsonNull()) {
        Location.validateJsonElement(jsonObj.get("location"));
      }
      // validate the optional field `country_metadata`
      if (jsonObj.get("country_metadata") != null && !jsonObj.get("country_metadata").isJsonNull()) {
        CountryMetadata.validateJsonElement(jsonObj.get("country_metadata"));
      }
      // validate the optional field `network`
      if (jsonObj.get("network") != null && !jsonObj.get("network").isJsonNull()) {
        Network.validateJsonElement(jsonObj.get("network"));
      }
      // validate the optional field `currency`
      if (jsonObj.get("currency") != null && !jsonObj.get("currency").isJsonNull()) {
        Currency.validateJsonElement(jsonObj.get("currency"));
      }
      // validate the optional field `security`
      if (jsonObj.get("security") != null && !jsonObj.get("security").isJsonNull()) {
        Security.validateJsonElement(jsonObj.get("security"));
      }
      // validate the optional field `abuse`
      if (jsonObj.get("abuse") != null && !jsonObj.get("abuse").isJsonNull()) {
        Abuse.validateJsonElement(jsonObj.get("abuse"));
      }
      // validate the optional field `time_zone`
      if (jsonObj.get("time_zone") != null && !jsonObj.get("time_zone").isJsonNull()) {
        TimeZone.validateJsonElement(jsonObj.get("time_zone"));
      }
      // validate the optional field `user_agent`
      if (jsonObj.get("user_agent") != null && !jsonObj.get("user_agent").isJsonNull()) {
        UserAgentData.validateJsonElement(jsonObj.get("user_agent"));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!GeolocationXMLResponse.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'GeolocationXMLResponse' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<GeolocationXMLResponse> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(GeolocationXMLResponse.class));

       return (TypeAdapter<T>) new TypeAdapter<GeolocationXMLResponse>() {
           @Override
           public void write(JsonWriter out, GeolocationXMLResponse value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public GeolocationXMLResponse read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

  /**
   * Create an instance of GeolocationXMLResponse given an JSON string
   *
   * @param jsonString JSON string
   * @return An instance of GeolocationXMLResponse
   * @throws IOException if the JSON string is invalid with respect to GeolocationXMLResponse
   */
  public static GeolocationXMLResponse fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, GeolocationXMLResponse.class);
  }

  /**
   * Convert an instance of GeolocationXMLResponse to an JSON string
   *
   * @return JSON string
   */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

