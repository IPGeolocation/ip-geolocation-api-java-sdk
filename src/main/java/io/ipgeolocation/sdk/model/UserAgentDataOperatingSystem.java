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
 * UserAgentDataOperatingSystem
 */

public class UserAgentDataOperatingSystem {
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

  public static final String SERIALIZED_NAME_BUILD = "build";
  @SerializedName(SERIALIZED_NAME_BUILD)
  @javax.annotation.Nullable
  private String build;

  public UserAgentDataOperatingSystem() {
  }

  public UserAgentDataOperatingSystem name(@javax.annotation.Nullable String name) {
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


  public UserAgentDataOperatingSystem type(@javax.annotation.Nullable String type) {
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


  public UserAgentDataOperatingSystem version(@javax.annotation.Nullable String version) {
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


  public UserAgentDataOperatingSystem versionMajor(@javax.annotation.Nullable String versionMajor) {
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


  public UserAgentDataOperatingSystem build(@javax.annotation.Nullable String build) {
    this.build = build;
    return this;
  }

  /**
   * Get build
   * @return build
   */
  @javax.annotation.Nullable
  public String getBuild() {
    return build;
  }

  public void setBuild(@javax.annotation.Nullable String build) {
    this.build = build;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UserAgentDataOperatingSystem userAgentDataOperatingSystem = (UserAgentDataOperatingSystem) o;
    return Objects.equals(this.name, userAgentDataOperatingSystem.name) &&
        Objects.equals(this.type, userAgentDataOperatingSystem.type) &&
        Objects.equals(this.version, userAgentDataOperatingSystem.version) &&
        Objects.equals(this.versionMajor, userAgentDataOperatingSystem.versionMajor) &&
        Objects.equals(this.build, userAgentDataOperatingSystem.build);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, type, version, versionMajor, build);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserAgentDataOperatingSystem {\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    version: ").append(toIndentedString(version)).append("\n");
    sb.append("    versionMajor: ").append(toIndentedString(versionMajor)).append("\n");
    sb.append("    build: ").append(toIndentedString(build)).append("\n");
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
    ipGeoFields.add("name");
    ipGeoFields.add("type");
    ipGeoFields.add("version");
    ipGeoFields.add("version_major");
    ipGeoFields.add("build");

    // a set of required properties/fields (JSON key names)
    ipGeoRequiredFields = new HashSet<String>();
  }

  /**
   * Validates the JSON Element and throws an exception if issues found
   *
   * @param jsonElement JSON Element
   * @throws IOException if the JSON Element is invalid with respect to UserAgentDataOperatingSystem
   */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!UserAgentDataOperatingSystem.ipGeoRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in UserAgentDataOperatingSystem is not found in the empty JSON string", UserAgentDataOperatingSystem.ipGeoRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!UserAgentDataOperatingSystem.ipGeoFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `UserAgentDataOperatingSystem` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
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
      if ((jsonObj.get("build") != null && !jsonObj.get("build").isJsonNull()) && !jsonObj.get("build").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `build` to be a primitive type in the JSON string but got `%s`", jsonObj.get("build").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!UserAgentDataOperatingSystem.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'UserAgentDataOperatingSystem' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<UserAgentDataOperatingSystem> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(UserAgentDataOperatingSystem.class));

       return (TypeAdapter<T>) new TypeAdapter<UserAgentDataOperatingSystem>() {
           @Override
           public void write(JsonWriter out, UserAgentDataOperatingSystem value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public UserAgentDataOperatingSystem read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

  /**
   * Create an instance of UserAgentDataOperatingSystem given an JSON string
   *
   * @param jsonString JSON string
   * @return An instance of UserAgentDataOperatingSystem
   * @throws IOException if the JSON string is invalid with respect to UserAgentDataOperatingSystem
   */
  public static UserAgentDataOperatingSystem fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, UserAgentDataOperatingSystem.class);
  }

  /**
   * Convert an instance of UserAgentDataOperatingSystem to an JSON string
   *
   * @return JSON string
   */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

