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
 * UserAgentXMLDataArray
 */

public class UserAgentXMLDataArray {
  public static final String SERIALIZED_NAME_USER_AGENT_STRING = "user_agent_string";
  @SerializedName(SERIALIZED_NAME_USER_AGENT_STRING)
  @javax.annotation.Nullable
  private String userAgentString;

  public static final String SERIALIZED_NAME_NAME = "name";
  @SerializedName(SERIALIZED_NAME_NAME)
  @javax.annotation.Nullable
  private String name;

  public static final String SERIALIZED_NAME_TYPE = "type";
  @SerializedName(SERIALIZED_NAME_TYPE)
  @javax.annotation.Nullable
  private String type;

  public static final String SERIALIZED_NAME_VERSION = "version";
  @SerializedName(SERIALIZED_NAME_VERSION)
  @javax.annotation.Nullable
  private String version;

  public static final String SERIALIZED_NAME_VERSION_MAJOR = "version_major";
  @SerializedName(SERIALIZED_NAME_VERSION_MAJOR)
  @javax.annotation.Nullable
  private String versionMajor;

  public static final String SERIALIZED_NAME_DEVICE = "device";
  @SerializedName(SERIALIZED_NAME_DEVICE)
  @javax.annotation.Nullable
  private UserAgentDataDevice device;

  public static final String SERIALIZED_NAME_ENGINE = "engine";
  @SerializedName(SERIALIZED_NAME_ENGINE)
  @javax.annotation.Nullable
  private UserAgentDataEngine engine;

  public static final String SERIALIZED_NAME_OPERATING_SYSTEM = "operating_system";
  @SerializedName(SERIALIZED_NAME_OPERATING_SYSTEM)
  @javax.annotation.Nullable
  private UserAgentDataOperatingSystem operatingSystem;

  public UserAgentXMLDataArray() {
  }

  public UserAgentXMLDataArray userAgentString(@javax.annotation.Nullable String userAgentString) {
    this.userAgentString = userAgentString;
    return this;
  }

  /**
   * Get userAgentString
   * @return userAgentString
   */
  @javax.annotation.Nullable
  public String getUserAgentString() {
    return userAgentString;
  }

  public void setUserAgentString(@javax.annotation.Nullable String userAgentString) {
    this.userAgentString = userAgentString;
  }


  public UserAgentXMLDataArray name(@javax.annotation.Nullable String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
   */
  @javax.annotation.Nullable
  public String getName() {
    return name;
  }

  public void setName(@javax.annotation.Nullable String name) {
    this.name = name;
  }


  public UserAgentXMLDataArray type(@javax.annotation.Nullable String type) {
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


  public UserAgentXMLDataArray version(@javax.annotation.Nullable String version) {
    this.version = version;
    return this;
  }

  /**
   * Get version
   * @return version
   */
  @javax.annotation.Nullable
  public String getVersion() {
    return version;
  }

  public void setVersion(@javax.annotation.Nullable String version) {
    this.version = version;
  }


  public UserAgentXMLDataArray versionMajor(@javax.annotation.Nullable String versionMajor) {
    this.versionMajor = versionMajor;
    return this;
  }

  /**
   * Get versionMajor
   * @return versionMajor
   */
  @javax.annotation.Nullable
  public String getVersionMajor() {
    return versionMajor;
  }

  public void setVersionMajor(@javax.annotation.Nullable String versionMajor) {
    this.versionMajor = versionMajor;
  }


  public UserAgentXMLDataArray device(@javax.annotation.Nullable UserAgentDataDevice device) {
    this.device = device;
    return this;
  }

  /**
   * Get device
   * @return device
   */
  @javax.annotation.Nullable
  public UserAgentDataDevice getDevice() {
    return device;
  }

  public void setDevice(@javax.annotation.Nullable UserAgentDataDevice device) {
    this.device = device;
  }


  public UserAgentXMLDataArray engine(@javax.annotation.Nullable UserAgentDataEngine engine) {
    this.engine = engine;
    return this;
  }

  /**
   * Get engine
   * @return engine
   */
  @javax.annotation.Nullable
  public UserAgentDataEngine getEngine() {
    return engine;
  }

  public void setEngine(@javax.annotation.Nullable UserAgentDataEngine engine) {
    this.engine = engine;
  }


  public UserAgentXMLDataArray operatingSystem(@javax.annotation.Nullable UserAgentDataOperatingSystem operatingSystem) {
    this.operatingSystem = operatingSystem;
    return this;
  }

  /**
   * Get operatingSystem
   * @return operatingSystem
   */
  @javax.annotation.Nullable
  public UserAgentDataOperatingSystem getOperatingSystem() {
    return operatingSystem;
  }

  public void setOperatingSystem(@javax.annotation.Nullable UserAgentDataOperatingSystem operatingSystem) {
    this.operatingSystem = operatingSystem;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UserAgentXMLDataArray userAgentXMLDataArray = (UserAgentXMLDataArray) o;
    return Objects.equals(this.userAgentString, userAgentXMLDataArray.userAgentString) &&
        Objects.equals(this.name, userAgentXMLDataArray.name) &&
        Objects.equals(this.type, userAgentXMLDataArray.type) &&
        Objects.equals(this.version, userAgentXMLDataArray.version) &&
        Objects.equals(this.versionMajor, userAgentXMLDataArray.versionMajor) &&
        Objects.equals(this.device, userAgentXMLDataArray.device) &&
        Objects.equals(this.engine, userAgentXMLDataArray.engine) &&
        Objects.equals(this.operatingSystem, userAgentXMLDataArray.operatingSystem);
  }

  @Override
  public int hashCode() {
    return Objects.hash(userAgentString, name, type, version, versionMajor, device, engine, operatingSystem);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserAgentXMLDataArray {\n");
    sb.append("    userAgentString: ").append(toIndentedString(userAgentString)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    version: ").append(toIndentedString(version)).append("\n");
    sb.append("    versionMajor: ").append(toIndentedString(versionMajor)).append("\n");
    sb.append("    device: ").append(toIndentedString(device)).append("\n");
    sb.append("    engine: ").append(toIndentedString(engine)).append("\n");
    sb.append("    operatingSystem: ").append(toIndentedString(operatingSystem)).append("\n");
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
    ipGeoFields.add("user_agent_string");
    ipGeoFields.add("name");
    ipGeoFields.add("type");
    ipGeoFields.add("version");
    ipGeoFields.add("version_major");
    ipGeoFields.add("device");
    ipGeoFields.add("engine");
    ipGeoFields.add("operating_system");

    // a set of required properties/fields (JSON key names)
    ipGeoRequiredFields = new HashSet<String>();
  }

  /**
   * Validates the JSON Element and throws an exception if issues found
   *
   * @param jsonElement JSON Element
   * @throws IOException if the JSON Element is invalid with respect to UserAgentXMLDataArray
   */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!UserAgentXMLDataArray.ipGeoRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in UserAgentXMLDataArray is not found in the empty JSON string", UserAgentXMLDataArray.ipGeoRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!UserAgentXMLDataArray.ipGeoFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `UserAgentXMLDataArray` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
      if ((jsonObj.get("user_agent_string") != null && !jsonObj.get("user_agent_string").isJsonNull()) && !jsonObj.get("user_agent_string").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `user_agent_string` to be a primitive type in the JSON string but got `%s`", jsonObj.get("user_agent_string").toString()));
      }
      if ((jsonObj.get("name") != null && !jsonObj.get("name").isJsonNull()) && !jsonObj.get("name").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `name` to be a primitive type in the JSON string but got `%s`", jsonObj.get("name").toString()));
      }
      if ((jsonObj.get("type") != null && !jsonObj.get("type").isJsonNull()) && !jsonObj.get("type").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `type` to be a primitive type in the JSON string but got `%s`", jsonObj.get("type").toString()));
      }
      if ((jsonObj.get("version") != null && !jsonObj.get("version").isJsonNull()) && !jsonObj.get("version").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `version` to be a primitive type in the JSON string but got `%s`", jsonObj.get("version").toString()));
      }
      if ((jsonObj.get("version_major") != null && !jsonObj.get("version_major").isJsonNull()) && !jsonObj.get("version_major").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `version_major` to be a primitive type in the JSON string but got `%s`", jsonObj.get("version_major").toString()));
      }
      // validate the optional field `device`
      if (jsonObj.get("device") != null && !jsonObj.get("device").isJsonNull()) {
        UserAgentDataDevice.validateJsonElement(jsonObj.get("device"));
      }
      // validate the optional field `engine`
      if (jsonObj.get("engine") != null && !jsonObj.get("engine").isJsonNull()) {
        UserAgentDataEngine.validateJsonElement(jsonObj.get("engine"));
      }
      // validate the optional field `operating_system`
      if (jsonObj.get("operating_system") != null && !jsonObj.get("operating_system").isJsonNull()) {
        UserAgentDataOperatingSystem.validateJsonElement(jsonObj.get("operating_system"));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!UserAgentXMLDataArray.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'UserAgentXMLDataArray' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<UserAgentXMLDataArray> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(UserAgentXMLDataArray.class));

       return (TypeAdapter<T>) new TypeAdapter<UserAgentXMLDataArray>() {
           @Override
           public void write(JsonWriter out, UserAgentXMLDataArray value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public UserAgentXMLDataArray read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

  /**
   * Create an instance of UserAgentXMLDataArray given an JSON string
   *
   * @param jsonString JSON string
   * @return An instance of UserAgentXMLDataArray
   * @throws IOException if the JSON string is invalid with respect to UserAgentXMLDataArray
   */
  public static UserAgentXMLDataArray fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, UserAgentXMLDataArray.class);
  }

  /**
   * Convert an instance of UserAgentXMLDataArray to an JSON string
   *
   * @return JSON string
   */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

