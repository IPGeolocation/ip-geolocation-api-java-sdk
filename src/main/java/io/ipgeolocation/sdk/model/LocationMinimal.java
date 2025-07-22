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
 * LocationMinimal
 */

public class LocationMinimal {
  public static final String SERIALIZED_NAME_CONTINENT_CODE = "continent_code";
  @SerializedName(SERIALIZED_NAME_CONTINENT_CODE)
  @javax.annotation.Nullable
  private String continentCode;

  public static final String SERIALIZED_NAME_CONTINENT_NAME = "continent_name";
  @SerializedName(SERIALIZED_NAME_CONTINENT_NAME)
  @javax.annotation.Nullable
  private String continentName;

  public static final String SERIALIZED_NAME_COUNTRY_CODE2 = "country_code2";
  @SerializedName(SERIALIZED_NAME_COUNTRY_CODE2)
  @javax.annotation.Nullable
  private String countryCode2;

  public static final String SERIALIZED_NAME_COUNTRY_CODE3 = "country_code3";
  @SerializedName(SERIALIZED_NAME_COUNTRY_CODE3)
  @javax.annotation.Nullable
  private String countryCode3;

  public static final String SERIALIZED_NAME_COUNTRY_NAME = "country_name";
  @SerializedName(SERIALIZED_NAME_COUNTRY_NAME)
  @javax.annotation.Nullable
  private String countryName;

  public static final String SERIALIZED_NAME_COUNTRY_NAME_OFFICIAL = "country_name_official";
  @SerializedName(SERIALIZED_NAME_COUNTRY_NAME_OFFICIAL)
  @javax.annotation.Nullable
  private String countryNameOfficial;

  public static final String SERIALIZED_NAME_COUNTRY_CAPITAL = "country_capital";
  @SerializedName(SERIALIZED_NAME_COUNTRY_CAPITAL)
  @javax.annotation.Nullable
  private String countryCapital;

  public static final String SERIALIZED_NAME_STATE_PROV = "state_prov";
  @SerializedName(SERIALIZED_NAME_STATE_PROV)
  @javax.annotation.Nullable
  private String stateProv;

  public static final String SERIALIZED_NAME_STATE_CODE = "state_code";
  @SerializedName(SERIALIZED_NAME_STATE_CODE)
  @javax.annotation.Nullable
  private String stateCode;

  public static final String SERIALIZED_NAME_DISTRICT = "district";
  @SerializedName(SERIALIZED_NAME_DISTRICT)
  @javax.annotation.Nullable
  private String district;

  public static final String SERIALIZED_NAME_CITY = "city";
  @SerializedName(SERIALIZED_NAME_CITY)
  @javax.annotation.Nullable
  private String city;

  public static final String SERIALIZED_NAME_ZIPCODE = "zipcode";
  @SerializedName(SERIALIZED_NAME_ZIPCODE)
  @javax.annotation.Nullable
  private String zipcode;

  public static final String SERIALIZED_NAME_LATITUDE = "latitude";
  @SerializedName(SERIALIZED_NAME_LATITUDE)
  @javax.annotation.Nullable
  private String latitude;

  public static final String SERIALIZED_NAME_LONGITUDE = "longitude";
  @SerializedName(SERIALIZED_NAME_LONGITUDE)
  @javax.annotation.Nullable
  private String longitude;

  public static final String SERIALIZED_NAME_IS_EU = "is_eu";
  @SerializedName(SERIALIZED_NAME_IS_EU)
  @javax.annotation.Nullable
  private Boolean isEu;

  public static final String SERIALIZED_NAME_COUNTRY_FLAG = "country_flag";
  @SerializedName(SERIALIZED_NAME_COUNTRY_FLAG)
  @javax.annotation.Nullable
  private String countryFlag;

  public static final String SERIALIZED_NAME_GEONAME_ID = "geoname_id";
  @SerializedName(SERIALIZED_NAME_GEONAME_ID)
  @javax.annotation.Nullable
  private String geonameId;

  public static final String SERIALIZED_NAME_COUNTRY_EMOJI = "country_emoji";
  @SerializedName(SERIALIZED_NAME_COUNTRY_EMOJI)
  @javax.annotation.Nullable
  private String countryEmoji;

  public LocationMinimal() {
  }

  public LocationMinimal continentCode(@javax.annotation.Nullable String continentCode) {
    this.continentCode = continentCode;
    return this;
  }

  /**
   * Get continentCode
   * @return continentCode
   */
  @javax.annotation.Nullable
  public String getContinentCode() {
    return continentCode;
  }

  public void setContinentCode(@javax.annotation.Nullable String continentCode) {
    this.continentCode = continentCode;
  }


  public LocationMinimal continentName(@javax.annotation.Nullable String continentName) {
    this.continentName = continentName;
    return this;
  }

  /**
   * Get continentName
   * @return continentName
   */
  @javax.annotation.Nullable
  public String getContinentName() {
    return continentName;
  }

  public void setContinentName(@javax.annotation.Nullable String continentName) {
    this.continentName = continentName;
  }


  public LocationMinimal countryCode2(@javax.annotation.Nullable String countryCode2) {
    this.countryCode2 = countryCode2;
    return this;
  }

  /**
   * Get countryCode2
   * @return countryCode2
   */
  @javax.annotation.Nullable
  public String getCountryCode2() {
    return countryCode2;
  }

  public void setCountryCode2(@javax.annotation.Nullable String countryCode2) {
    this.countryCode2 = countryCode2;
  }


  public LocationMinimal countryCode3(@javax.annotation.Nullable String countryCode3) {
    this.countryCode3 = countryCode3;
    return this;
  }

  /**
   * Get countryCode3
   * @return countryCode3
   */
  @javax.annotation.Nullable
  public String getCountryCode3() {
    return countryCode3;
  }

  public void setCountryCode3(@javax.annotation.Nullable String countryCode3) {
    this.countryCode3 = countryCode3;
  }


  public LocationMinimal countryName(@javax.annotation.Nullable String countryName) {
    this.countryName = countryName;
    return this;
  }

  /**
   * Get countryName
   * @return countryName
   */
  @javax.annotation.Nullable
  public String getCountryName() {
    return countryName;
  }

  public void setCountryName(@javax.annotation.Nullable String countryName) {
    this.countryName = countryName;
  }


  public LocationMinimal countryNameOfficial(@javax.annotation.Nullable String countryNameOfficial) {
    this.countryNameOfficial = countryNameOfficial;
    return this;
  }

  /**
   * Get countryNameOfficial
   * @return countryNameOfficial
   */
  @javax.annotation.Nullable
  public String getCountryNameOfficial() {
    return countryNameOfficial;
  }

  public void setCountryNameOfficial(@javax.annotation.Nullable String countryNameOfficial) {
    this.countryNameOfficial = countryNameOfficial;
  }


  public LocationMinimal countryCapital(@javax.annotation.Nullable String countryCapital) {
    this.countryCapital = countryCapital;
    return this;
  }

  /**
   * Get countryCapital
   * @return countryCapital
   */
  @javax.annotation.Nullable
  public String getCountryCapital() {
    return countryCapital;
  }

  public void setCountryCapital(@javax.annotation.Nullable String countryCapital) {
    this.countryCapital = countryCapital;
  }


  public LocationMinimal stateProv(@javax.annotation.Nullable String stateProv) {
    this.stateProv = stateProv;
    return this;
  }

  /**
   * Get stateProv
   * @return stateProv
   */
  @javax.annotation.Nullable
  public String getStateProv() {
    return stateProv;
  }

  public void setStateProv(@javax.annotation.Nullable String stateProv) {
    this.stateProv = stateProv;
  }


  public LocationMinimal stateCode(@javax.annotation.Nullable String stateCode) {
    this.stateCode = stateCode;
    return this;
  }

  /**
   * Get stateCode
   * @return stateCode
   */
  @javax.annotation.Nullable
  public String getStateCode() {
    return stateCode;
  }

  public void setStateCode(@javax.annotation.Nullable String stateCode) {
    this.stateCode = stateCode;
  }


  public LocationMinimal district(@javax.annotation.Nullable String district) {
    this.district = district;
    return this;
  }

  /**
   * Get district
   * @return district
   */
  @javax.annotation.Nullable
  public String getDistrict() {
    return district;
  }

  public void setDistrict(@javax.annotation.Nullable String district) {
    this.district = district;
  }


  public LocationMinimal city(@javax.annotation.Nullable String city) {
    this.city = city;
    return this;
  }

  /**
   * Get city
   * @return city
   */
  @javax.annotation.Nullable
  public String getCity() {
    return city;
  }

  public void setCity(@javax.annotation.Nullable String city) {
    this.city = city;
  }


  public LocationMinimal zipcode(@javax.annotation.Nullable String zipcode) {
    this.zipcode = zipcode;
    return this;
  }

  /**
   * Get zipcode
   * @return zipcode
   */
  @javax.annotation.Nullable
  public String getZipcode() {
    return zipcode;
  }

  public void setZipcode(@javax.annotation.Nullable String zipcode) {
    this.zipcode = zipcode;
  }


  public LocationMinimal latitude(@javax.annotation.Nullable String latitude) {
    this.latitude = latitude;
    return this;
  }

  /**
   * Get latitude
   * @return latitude
   */
  @javax.annotation.Nullable
  public String getLatitude() {
    return latitude;
  }

  public void setLatitude(@javax.annotation.Nullable String latitude) {
    this.latitude = latitude;
  }


  public LocationMinimal longitude(@javax.annotation.Nullable String longitude) {
    this.longitude = longitude;
    return this;
  }

  /**
   * Get longitude
   * @return longitude
   */
  @javax.annotation.Nullable
  public String getLongitude() {
    return longitude;
  }

  public void setLongitude(@javax.annotation.Nullable String longitude) {
    this.longitude = longitude;
  }


  public LocationMinimal isEu(@javax.annotation.Nullable Boolean isEu) {
    this.isEu = isEu;
    return this;
  }

  /**
   * Get isEu
   * @return isEu
   */
  @javax.annotation.Nullable
  public Boolean getIsEu() {
    return isEu;
  }

  public void setIsEu(@javax.annotation.Nullable Boolean isEu) {
    this.isEu = isEu;
  }


  public LocationMinimal countryFlag(@javax.annotation.Nullable String countryFlag) {
    this.countryFlag = countryFlag;
    return this;
  }

  /**
   * Get countryFlag
   * @return countryFlag
   */
  @javax.annotation.Nullable
  public String getCountryFlag() {
    return countryFlag;
  }

  public void setCountryFlag(@javax.annotation.Nullable String countryFlag) {
    this.countryFlag = countryFlag;
  }


  public LocationMinimal geonameId(@javax.annotation.Nullable String geonameId) {
    this.geonameId = geonameId;
    return this;
  }

  /**
   * Get geonameId
   * @return geonameId
   */
  @javax.annotation.Nullable
  public String getGeonameId() {
    return geonameId;
  }

  public void setGeonameId(@javax.annotation.Nullable String geonameId) {
    this.geonameId = geonameId;
  }


  public LocationMinimal countryEmoji(@javax.annotation.Nullable String countryEmoji) {
    this.countryEmoji = countryEmoji;
    return this;
  }

  /**
   * Get countryEmoji
   * @return countryEmoji
   */
  @javax.annotation.Nullable
  public String getCountryEmoji() {
    return countryEmoji;
  }

  public void setCountryEmoji(@javax.annotation.Nullable String countryEmoji) {
    this.countryEmoji = countryEmoji;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LocationMinimal locationMinimal = (LocationMinimal) o;
    return Objects.equals(this.continentCode, locationMinimal.continentCode) &&
        Objects.equals(this.continentName, locationMinimal.continentName) &&
        Objects.equals(this.countryCode2, locationMinimal.countryCode2) &&
        Objects.equals(this.countryCode3, locationMinimal.countryCode3) &&
        Objects.equals(this.countryName, locationMinimal.countryName) &&
        Objects.equals(this.countryNameOfficial, locationMinimal.countryNameOfficial) &&
        Objects.equals(this.countryCapital, locationMinimal.countryCapital) &&
        Objects.equals(this.stateProv, locationMinimal.stateProv) &&
        Objects.equals(this.stateCode, locationMinimal.stateCode) &&
        Objects.equals(this.district, locationMinimal.district) &&
        Objects.equals(this.city, locationMinimal.city) &&
        Objects.equals(this.zipcode, locationMinimal.zipcode) &&
        Objects.equals(this.latitude, locationMinimal.latitude) &&
        Objects.equals(this.longitude, locationMinimal.longitude) &&
        Objects.equals(this.isEu, locationMinimal.isEu) &&
        Objects.equals(this.countryFlag, locationMinimal.countryFlag) &&
        Objects.equals(this.geonameId, locationMinimal.geonameId) &&
        Objects.equals(this.countryEmoji, locationMinimal.countryEmoji);
  }

  @Override
  public int hashCode() {
    return Objects.hash(continentCode, continentName, countryCode2, countryCode3, countryName, countryNameOfficial, countryCapital, stateProv, stateCode, district, city, zipcode, latitude, longitude, isEu, countryFlag, geonameId, countryEmoji);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LocationMinimal {\n");
    sb.append("    continentCode: ").append(toIndentedString(continentCode)).append("\n");
    sb.append("    continentName: ").append(toIndentedString(continentName)).append("\n");
    sb.append("    countryCode2: ").append(toIndentedString(countryCode2)).append("\n");
    sb.append("    countryCode3: ").append(toIndentedString(countryCode3)).append("\n");
    sb.append("    countryName: ").append(toIndentedString(countryName)).append("\n");
    sb.append("    countryNameOfficial: ").append(toIndentedString(countryNameOfficial)).append("\n");
    sb.append("    countryCapital: ").append(toIndentedString(countryCapital)).append("\n");
    sb.append("    stateProv: ").append(toIndentedString(stateProv)).append("\n");
    sb.append("    stateCode: ").append(toIndentedString(stateCode)).append("\n");
    sb.append("    district: ").append(toIndentedString(district)).append("\n");
    sb.append("    city: ").append(toIndentedString(city)).append("\n");
    sb.append("    zipcode: ").append(toIndentedString(zipcode)).append("\n");
    sb.append("    latitude: ").append(toIndentedString(latitude)).append("\n");
    sb.append("    longitude: ").append(toIndentedString(longitude)).append("\n");
    sb.append("    isEu: ").append(toIndentedString(isEu)).append("\n");
    sb.append("    countryFlag: ").append(toIndentedString(countryFlag)).append("\n");
    sb.append("    geonameId: ").append(toIndentedString(geonameId)).append("\n");
    sb.append("    countryEmoji: ").append(toIndentedString(countryEmoji)).append("\n");
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
    ipGeoFields.add("continent_code");
    ipGeoFields.add("continent_name");
    ipGeoFields.add("country_code2");
    ipGeoFields.add("country_code3");
    ipGeoFields.add("country_name");
    ipGeoFields.add("country_name_official");
    ipGeoFields.add("country_capital");
    ipGeoFields.add("state_prov");
    ipGeoFields.add("state_code");
    ipGeoFields.add("district");
    ipGeoFields.add("city");
    ipGeoFields.add("zipcode");
    ipGeoFields.add("latitude");
    ipGeoFields.add("longitude");
    ipGeoFields.add("is_eu");
    ipGeoFields.add("country_flag");
    ipGeoFields.add("geoname_id");
    ipGeoFields.add("country_emoji");

    // a set of required properties/fields (JSON key names)
    ipGeoRequiredFields = new HashSet<String>();
  }

  /**
   * Validates the JSON Element and throws an exception if issues found
   *
   * @param jsonElement JSON Element
   * @throws IOException if the JSON Element is invalid with respect to LocationMinimal
   */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!LocationMinimal.ipGeoRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in LocationMinimal is not found in the empty JSON string", LocationMinimal.ipGeoRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!LocationMinimal.ipGeoFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `LocationMinimal` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
      if ((jsonObj.get("continent_code") != null && !jsonObj.get("continent_code").isJsonNull()) && !jsonObj.get("continent_code").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `continent_code` to be a primitive type in the JSON string but got `%s`", jsonObj.get("continent_code").toString()));
      }
      if ((jsonObj.get("continent_name") != null && !jsonObj.get("continent_name").isJsonNull()) && !jsonObj.get("continent_name").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `continent_name` to be a primitive type in the JSON string but got `%s`", jsonObj.get("continent_name").toString()));
      }
      if ((jsonObj.get("country_code2") != null && !jsonObj.get("country_code2").isJsonNull()) && !jsonObj.get("country_code2").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `country_code2` to be a primitive type in the JSON string but got `%s`", jsonObj.get("country_code2").toString()));
      }
      if ((jsonObj.get("country_code3") != null && !jsonObj.get("country_code3").isJsonNull()) && !jsonObj.get("country_code3").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `country_code3` to be a primitive type in the JSON string but got `%s`", jsonObj.get("country_code3").toString()));
      }
      if ((jsonObj.get("country_name") != null && !jsonObj.get("country_name").isJsonNull()) && !jsonObj.get("country_name").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `country_name` to be a primitive type in the JSON string but got `%s`", jsonObj.get("country_name").toString()));
      }
      if ((jsonObj.get("country_name_official") != null && !jsonObj.get("country_name_official").isJsonNull()) && !jsonObj.get("country_name_official").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `country_name_official` to be a primitive type in the JSON string but got `%s`", jsonObj.get("country_name_official").toString()));
      }
      if ((jsonObj.get("country_capital") != null && !jsonObj.get("country_capital").isJsonNull()) && !jsonObj.get("country_capital").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `country_capital` to be a primitive type in the JSON string but got `%s`", jsonObj.get("country_capital").toString()));
      }
      if ((jsonObj.get("state_prov") != null && !jsonObj.get("state_prov").isJsonNull()) && !jsonObj.get("state_prov").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `state_prov` to be a primitive type in the JSON string but got `%s`", jsonObj.get("state_prov").toString()));
      }
      if ((jsonObj.get("state_code") != null && !jsonObj.get("state_code").isJsonNull()) && !jsonObj.get("state_code").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `state_code` to be a primitive type in the JSON string but got `%s`", jsonObj.get("state_code").toString()));
      }
      if ((jsonObj.get("district") != null && !jsonObj.get("district").isJsonNull()) && !jsonObj.get("district").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `district` to be a primitive type in the JSON string but got `%s`", jsonObj.get("district").toString()));
      }
      if ((jsonObj.get("city") != null && !jsonObj.get("city").isJsonNull()) && !jsonObj.get("city").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `city` to be a primitive type in the JSON string but got `%s`", jsonObj.get("city").toString()));
      }
      if ((jsonObj.get("zipcode") != null && !jsonObj.get("zipcode").isJsonNull()) && !jsonObj.get("zipcode").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `zipcode` to be a primitive type in the JSON string but got `%s`", jsonObj.get("zipcode").toString()));
      }
      if ((jsonObj.get("latitude") != null && !jsonObj.get("latitude").isJsonNull()) && !jsonObj.get("latitude").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `latitude` to be a primitive type in the JSON string but got `%s`", jsonObj.get("latitude").toString()));
      }
      if ((jsonObj.get("longitude") != null && !jsonObj.get("longitude").isJsonNull()) && !jsonObj.get("longitude").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `longitude` to be a primitive type in the JSON string but got `%s`", jsonObj.get("longitude").toString()));
      }
      if ((jsonObj.get("country_flag") != null && !jsonObj.get("country_flag").isJsonNull()) && !jsonObj.get("country_flag").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `country_flag` to be a primitive type in the JSON string but got `%s`", jsonObj.get("country_flag").toString()));
      }
      if ((jsonObj.get("geoname_id") != null && !jsonObj.get("geoname_id").isJsonNull()) && !jsonObj.get("geoname_id").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `geoname_id` to be a primitive type in the JSON string but got `%s`", jsonObj.get("geoname_id").toString()));
      }
      if ((jsonObj.get("country_emoji") != null && !jsonObj.get("country_emoji").isJsonNull()) && !jsonObj.get("country_emoji").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `country_emoji` to be a primitive type in the JSON string but got `%s`", jsonObj.get("country_emoji").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!LocationMinimal.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'LocationMinimal' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<LocationMinimal> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(LocationMinimal.class));

       return (TypeAdapter<T>) new TypeAdapter<LocationMinimal>() {
           @Override
           public void write(JsonWriter out, LocationMinimal value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public LocationMinimal read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

  /**
   * Create an instance of LocationMinimal given an JSON string
   *
   * @param jsonString JSON string
   * @return An instance of LocationMinimal
   * @throws IOException if the JSON string is invalid with respect to LocationMinimal
   */
  public static LocationMinimal fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, LocationMinimal.class);
  }

  /**
   * Convert an instance of LocationMinimal to an JSON string
   *
   * @return JSON string
   */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

