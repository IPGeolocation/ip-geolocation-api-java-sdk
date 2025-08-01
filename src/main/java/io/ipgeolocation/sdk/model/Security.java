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
 * Security
 */

public class Security {
  public static final String SERIALIZED_NAME_THREAT_SCORE = "threat_score";
  @SerializedName(SERIALIZED_NAME_THREAT_SCORE)
  @javax.annotation.Nullable
  private Integer threatScore;

  public static final String SERIALIZED_NAME_IS_TOR = "is_tor";
  @SerializedName(SERIALIZED_NAME_IS_TOR)
  @javax.annotation.Nullable
  private Boolean isTor;

  public static final String SERIALIZED_NAME_IS_PROXY = "is_proxy";
  @SerializedName(SERIALIZED_NAME_IS_PROXY)
  @javax.annotation.Nullable
  private Boolean isProxy;

  public static final String SERIALIZED_NAME_PROXY_TYPE = "proxy_type";
  @SerializedName(SERIALIZED_NAME_PROXY_TYPE)
  @javax.annotation.Nullable
  private String proxyType;

  public static final String SERIALIZED_NAME_PROXY_PROVIDER = "proxy_provider";
  @SerializedName(SERIALIZED_NAME_PROXY_PROVIDER)
  @javax.annotation.Nullable
  private String proxyProvider;

  public static final String SERIALIZED_NAME_IS_ANONYMOUS = "is_anonymous";
  @SerializedName(SERIALIZED_NAME_IS_ANONYMOUS)
  @javax.annotation.Nullable
  private Boolean isAnonymous;

  public static final String SERIALIZED_NAME_IS_KNOWN_ATTACKER = "is_known_attacker";
  @SerializedName(SERIALIZED_NAME_IS_KNOWN_ATTACKER)
  @javax.annotation.Nullable
  private Boolean isKnownAttacker;

  public static final String SERIALIZED_NAME_IS_SPAM = "is_spam";
  @SerializedName(SERIALIZED_NAME_IS_SPAM)
  @javax.annotation.Nullable
  private Boolean isSpam;

  public static final String SERIALIZED_NAME_IS_BOT = "is_bot";
  @SerializedName(SERIALIZED_NAME_IS_BOT)
  @javax.annotation.Nullable
  private Boolean isBot;

  public static final String SERIALIZED_NAME_IS_CLOUD_PROVIDER = "is_cloud_provider";
  @SerializedName(SERIALIZED_NAME_IS_CLOUD_PROVIDER)
  @javax.annotation.Nullable
  private Boolean isCloudProvider;

  public static final String SERIALIZED_NAME_CLOUD_PROVIDER = "cloud_provider";
  @SerializedName(SERIALIZED_NAME_CLOUD_PROVIDER)
  @javax.annotation.Nullable
  private String cloudProvider;

  public Security() {
  }

  public Security threatScore(@javax.annotation.Nullable Integer threatScore) {
    this.threatScore = threatScore;
    return this;
  }

  /**
   * Get threatScore
   * @return threatScore
   */
  @javax.annotation.Nullable
  public Integer getThreatScore() {
    return threatScore;
  }

  public void setThreatScore(@javax.annotation.Nullable Integer threatScore) {
    this.threatScore = threatScore;
  }


  public Security isTor(@javax.annotation.Nullable Boolean isTor) {
    this.isTor = isTor;
    return this;
  }

  /**
   * Get isTor
   * @return isTor
   */
  @javax.annotation.Nullable
  public Boolean getIsTor() {
    return isTor;
  }

  public void setIsTor(@javax.annotation.Nullable Boolean isTor) {
    this.isTor = isTor;
  }


  public Security isProxy(@javax.annotation.Nullable Boolean isProxy) {
    this.isProxy = isProxy;
    return this;
  }

  /**
   * Get isProxy
   * @return isProxy
   */
  @javax.annotation.Nullable
  public Boolean getIsProxy() {
    return isProxy;
  }

  public void setIsProxy(@javax.annotation.Nullable Boolean isProxy) {
    this.isProxy = isProxy;
  }


  public Security proxyType(@javax.annotation.Nullable String proxyType) {
    this.proxyType = proxyType;
    return this;
  }

  /**
   * Get proxyType
   * @return proxyType
   */
  @javax.annotation.Nullable
  public String getProxyType() {
    return proxyType;
  }

  public void setProxyType(@javax.annotation.Nullable String proxyType) {
    this.proxyType = proxyType;
  }


  public Security proxyProvider(@javax.annotation.Nullable String proxyProvider) {
    this.proxyProvider = proxyProvider;
    return this;
  }

  /**
   * Get proxyProvider
   * @return proxyProvider
   */
  @javax.annotation.Nullable
  public String getProxyProvider() {
    return proxyProvider;
  }

  public void setProxyProvider(@javax.annotation.Nullable String proxyProvider) {
    this.proxyProvider = proxyProvider;
  }


  public Security isAnonymous(@javax.annotation.Nullable Boolean isAnonymous) {
    this.isAnonymous = isAnonymous;
    return this;
  }

  /**
   * Get isAnonymous
   * @return isAnonymous
   */
  @javax.annotation.Nullable
  public Boolean getIsAnonymous() {
    return isAnonymous;
  }

  public void setIsAnonymous(@javax.annotation.Nullable Boolean isAnonymous) {
    this.isAnonymous = isAnonymous;
  }


  public Security isKnownAttacker(@javax.annotation.Nullable Boolean isKnownAttacker) {
    this.isKnownAttacker = isKnownAttacker;
    return this;
  }

  /**
   * Get isKnownAttacker
   * @return isKnownAttacker
   */
  @javax.annotation.Nullable
  public Boolean getIsKnownAttacker() {
    return isKnownAttacker;
  }

  public void setIsKnownAttacker(@javax.annotation.Nullable Boolean isKnownAttacker) {
    this.isKnownAttacker = isKnownAttacker;
  }


  public Security isSpam(@javax.annotation.Nullable Boolean isSpam) {
    this.isSpam = isSpam;
    return this;
  }

  /**
   * Get isSpam
   * @return isSpam
   */
  @javax.annotation.Nullable
  public Boolean getIsSpam() {
    return isSpam;
  }

  public void setIsSpam(@javax.annotation.Nullable Boolean isSpam) {
    this.isSpam = isSpam;
  }


  public Security isBot(@javax.annotation.Nullable Boolean isBot) {
    this.isBot = isBot;
    return this;
  }

  /**
   * Get isBot
   * @return isBot
   */
  @javax.annotation.Nullable
  public Boolean getIsBot() {
    return isBot;
  }

  public void setIsBot(@javax.annotation.Nullable Boolean isBot) {
    this.isBot = isBot;
  }


  public Security isCloudProvider(@javax.annotation.Nullable Boolean isCloudProvider) {
    this.isCloudProvider = isCloudProvider;
    return this;
  }

  /**
   * Get isCloudProvider
   * @return isCloudProvider
   */
  @javax.annotation.Nullable
  public Boolean getIsCloudProvider() {
    return isCloudProvider;
  }

  public void setIsCloudProvider(@javax.annotation.Nullable Boolean isCloudProvider) {
    this.isCloudProvider = isCloudProvider;
  }


  public Security cloudProvider(@javax.annotation.Nullable String cloudProvider) {
    this.cloudProvider = cloudProvider;
    return this;
  }

  /**
   * Get cloudProvider
   * @return cloudProvider
   */
  @javax.annotation.Nullable
  public String getCloudProvider() {
    return cloudProvider;
  }

  public void setCloudProvider(@javax.annotation.Nullable String cloudProvider) {
    this.cloudProvider = cloudProvider;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Security security = (Security) o;
    return Objects.equals(this.threatScore, security.threatScore) &&
        Objects.equals(this.isTor, security.isTor) &&
        Objects.equals(this.isProxy, security.isProxy) &&
        Objects.equals(this.proxyType, security.proxyType) &&
        Objects.equals(this.proxyProvider, security.proxyProvider) &&
        Objects.equals(this.isAnonymous, security.isAnonymous) &&
        Objects.equals(this.isKnownAttacker, security.isKnownAttacker) &&
        Objects.equals(this.isSpam, security.isSpam) &&
        Objects.equals(this.isBot, security.isBot) &&
        Objects.equals(this.isCloudProvider, security.isCloudProvider) &&
        Objects.equals(this.cloudProvider, security.cloudProvider);
  }

  @Override
  public int hashCode() {
    return Objects.hash(threatScore, isTor, isProxy, proxyType, proxyProvider, isAnonymous, isKnownAttacker, isSpam, isBot, isCloudProvider, cloudProvider);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Security {\n");
    sb.append("    threatScore: ").append(toIndentedString(threatScore)).append("\n");
    sb.append("    isTor: ").append(toIndentedString(isTor)).append("\n");
    sb.append("    isProxy: ").append(toIndentedString(isProxy)).append("\n");
    sb.append("    proxyType: ").append(toIndentedString(proxyType)).append("\n");
    sb.append("    proxyProvider: ").append(toIndentedString(proxyProvider)).append("\n");
    sb.append("    isAnonymous: ").append(toIndentedString(isAnonymous)).append("\n");
    sb.append("    isKnownAttacker: ").append(toIndentedString(isKnownAttacker)).append("\n");
    sb.append("    isSpam: ").append(toIndentedString(isSpam)).append("\n");
    sb.append("    isBot: ").append(toIndentedString(isBot)).append("\n");
    sb.append("    isCloudProvider: ").append(toIndentedString(isCloudProvider)).append("\n");
    sb.append("    cloudProvider: ").append(toIndentedString(cloudProvider)).append("\n");
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
    ipGeoFields.add("threat_score");
    ipGeoFields.add("is_tor");
    ipGeoFields.add("is_proxy");
    ipGeoFields.add("proxy_type");
    ipGeoFields.add("proxy_provider");
    ipGeoFields.add("is_anonymous");
    ipGeoFields.add("is_known_attacker");
    ipGeoFields.add("is_spam");
    ipGeoFields.add("is_bot");
    ipGeoFields.add("is_cloud_provider");
    ipGeoFields.add("cloud_provider");

    // a set of required properties/fields (JSON key names)
    ipGeoRequiredFields = new HashSet<String>();
  }

  /**
   * Validates the JSON Element and throws an exception if issues found
   *
   * @param jsonElement JSON Element
   * @throws IOException if the JSON Element is invalid with respect to Security
   */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!Security.ipGeoRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in Security is not found in the empty JSON string", Security.ipGeoRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!Security.ipGeoFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `Security` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
      if ((jsonObj.get("proxy_type") != null && !jsonObj.get("proxy_type").isJsonNull()) && !jsonObj.get("proxy_type").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `proxy_type` to be a primitive type in the JSON string but got `%s`", jsonObj.get("proxy_type").toString()));
      }
      if ((jsonObj.get("proxy_provider") != null && !jsonObj.get("proxy_provider").isJsonNull()) && !jsonObj.get("proxy_provider").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `proxy_provider` to be a primitive type in the JSON string but got `%s`", jsonObj.get("proxy_provider").toString()));
      }
      if ((jsonObj.get("cloud_provider") != null && !jsonObj.get("cloud_provider").isJsonNull()) && !jsonObj.get("cloud_provider").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `cloud_provider` to be a primitive type in the JSON string but got `%s`", jsonObj.get("cloud_provider").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!Security.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'Security' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<Security> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(Security.class));

       return (TypeAdapter<T>) new TypeAdapter<Security>() {
           @Override
           public void write(JsonWriter out, Security value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public Security read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

  /**
   * Create an instance of Security given an JSON string
   *
   * @param jsonString JSON string
   * @return An instance of Security
   * @throws IOException if the JSON string is invalid with respect to Security
   */
  public static Security fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, Security.class);
  }

  /**
   * Convert an instance of Security to an JSON string
   *
   * @return JSON string
   */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

