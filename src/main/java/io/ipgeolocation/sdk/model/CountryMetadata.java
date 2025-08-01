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
import java.util.ArrayList;
import java.util.List;

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
 * CountryMetadata
 */

public class CountryMetadata {
  public static final String SERIALIZED_NAME_CALLING_CODE = "calling_code";
  @SerializedName(SERIALIZED_NAME_CALLING_CODE)
  @javax.annotation.Nullable
  private String callingCode;

  public static final String SERIALIZED_NAME_TLD = "tld";
  @SerializedName(SERIALIZED_NAME_TLD)
  @javax.annotation.Nullable
  private String tld;

  public static final String SERIALIZED_NAME_LANGUAGES = "languages";
  @SerializedName(SERIALIZED_NAME_LANGUAGES)
  @javax.annotation.Nullable
  private List<String> languages = new ArrayList<>();

  public CountryMetadata() {
  }

  public CountryMetadata callingCode(@javax.annotation.Nullable String callingCode) {
    this.callingCode = callingCode;
    return this;
  }

  /**
   * Get callingCode
   * @return callingCode
   */
  @javax.annotation.Nullable
  public String getCallingCode() {
    return callingCode;
  }

  public void setCallingCode(@javax.annotation.Nullable String callingCode) {
    this.callingCode = callingCode;
  }


  public CountryMetadata tld(@javax.annotation.Nullable String tld) {
    this.tld = tld;
    return this;
  }

  /**
   * Get tld
   * @return tld
   */
  @javax.annotation.Nullable
  public String getTld() {
    return tld;
  }

  public void setTld(@javax.annotation.Nullable String tld) {
    this.tld = tld;
  }


  public CountryMetadata languages(@javax.annotation.Nullable List<String> languages) {
    this.languages = languages;
    return this;
  }

  public CountryMetadata addLanguagesItem(String languagesItem) {
    if (this.languages == null) {
      this.languages = new ArrayList<>();
    }
    this.languages.add(languagesItem);
    return this;
  }

  /**
   * Get languages
   * @return languages
   */
  @javax.annotation.Nullable
  public List<String> getLanguages() {
    return languages;
  }

  public void setLanguages(@javax.annotation.Nullable List<String> languages) {
    this.languages = languages;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CountryMetadata countryMetadata = (CountryMetadata) o;
    return Objects.equals(this.callingCode, countryMetadata.callingCode) &&
        Objects.equals(this.tld, countryMetadata.tld) &&
        Objects.equals(this.languages, countryMetadata.languages);
  }

  @Override
  public int hashCode() {
    return Objects.hash(callingCode, tld, languages);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CountryMetadata {\n");
    sb.append("    callingCode: ").append(toIndentedString(callingCode)).append("\n");
    sb.append("    tld: ").append(toIndentedString(tld)).append("\n");
    sb.append("    languages: ").append(toIndentedString(languages)).append("\n");
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
    ipGeoFields.add("calling_code");
    ipGeoFields.add("tld");
    ipGeoFields.add("languages");

    // a set of required properties/fields (JSON key names)
    ipGeoRequiredFields = new HashSet<String>();
  }

  /**
   * Validates the JSON Element and throws an exception if issues found
   *
   * @param jsonElement JSON Element
   * @throws IOException if the JSON Element is invalid with respect to CountryMetadata
   */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!CountryMetadata.ipGeoRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in CountryMetadata is not found in the empty JSON string", CountryMetadata.ipGeoRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!CountryMetadata.ipGeoFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `CountryMetadata` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
      if ((jsonObj.get("calling_code") != null && !jsonObj.get("calling_code").isJsonNull()) && !jsonObj.get("calling_code").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `calling_code` to be a primitive type in the JSON string but got `%s`", jsonObj.get("calling_code").toString()));
      }
      if ((jsonObj.get("tld") != null && !jsonObj.get("tld").isJsonNull()) && !jsonObj.get("tld").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `tld` to be a primitive type in the JSON string but got `%s`", jsonObj.get("tld").toString()));
      }
      // ensure the optional json data is an array if present
      if (jsonObj.get("languages") != null && !jsonObj.get("languages").isJsonNull() && !jsonObj.get("languages").isJsonArray()) {
        throw new IllegalArgumentException(String.format("Expected the field `languages` to be an array in the JSON string but got `%s`", jsonObj.get("languages").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!CountryMetadata.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'CountryMetadata' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<CountryMetadata> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(CountryMetadata.class));

       return (TypeAdapter<T>) new TypeAdapter<CountryMetadata>() {
           @Override
           public void write(JsonWriter out, CountryMetadata value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public CountryMetadata read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

  /**
   * Create an instance of CountryMetadata given an JSON string
   *
   * @param jsonString JSON string
   * @return An instance of CountryMetadata
   * @throws IOException if the JSON string is invalid with respect to CountryMetadata
   */
  public static CountryMetadata fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, CountryMetadata.class);
  }

  /**
   * Convert an instance of CountryMetadata to an JSON string
   *
   * @return JSON string
   */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

