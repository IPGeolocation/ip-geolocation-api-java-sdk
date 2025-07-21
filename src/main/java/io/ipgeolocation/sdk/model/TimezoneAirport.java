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
 * TimezoneAirport
 */

public class TimezoneAirport {
  public static final String SERIALIZED_NAME_TYPE = "type";
  @SerializedName(SERIALIZED_NAME_TYPE)
  @javax.annotation.Nullable
  private String type;

  public static final String SERIALIZED_NAME_NAME = "name";
  @SerializedName(SERIALIZED_NAME_NAME)
  @javax.annotation.Nullable
  private String name;

  public static final String SERIALIZED_NAME_LATITUDE = "latitude";
  @SerializedName(SERIALIZED_NAME_LATITUDE)
  @javax.annotation.Nullable
  private String latitude;

  public static final String SERIALIZED_NAME_LONGITUDE = "longitude";
  @SerializedName(SERIALIZED_NAME_LONGITUDE)
  @javax.annotation.Nullable
  private String longitude;

  public static final String SERIALIZED_NAME_ELEVATION_FT = "elevation_ft";
  @SerializedName(SERIALIZED_NAME_ELEVATION_FT)
  @javax.annotation.Nullable
  private Integer elevationFt;

  public static final String SERIALIZED_NAME_CONTINENT_CODE = "continent_code";
  @SerializedName(SERIALIZED_NAME_CONTINENT_CODE)
  @javax.annotation.Nullable
  private String continentCode;

  public static final String SERIALIZED_NAME_COUNTRY_CODE = "country_code";
  @SerializedName(SERIALIZED_NAME_COUNTRY_CODE)
  @javax.annotation.Nullable
  private String countryCode;

  public static final String SERIALIZED_NAME_STATE_CODE = "state_code";
  @SerializedName(SERIALIZED_NAME_STATE_CODE)
  @javax.annotation.Nullable
  private String stateCode;

  public static final String SERIALIZED_NAME_CITY = "city";
  @SerializedName(SERIALIZED_NAME_CITY)
  @javax.annotation.Nullable
  private String city;

  public static final String SERIALIZED_NAME_MUNICIPALITY = "municipality";
  @SerializedName(SERIALIZED_NAME_MUNICIPALITY)
  @javax.annotation.Nullable
  private String municipality;

  public static final String SERIALIZED_NAME_IATA_CODE = "iata_code";
  @SerializedName(SERIALIZED_NAME_IATA_CODE)
  @javax.annotation.Nullable
  private String iataCode;

  public static final String SERIALIZED_NAME_ICAO_CODE = "icao_code";
  @SerializedName(SERIALIZED_NAME_ICAO_CODE)
  @javax.annotation.Nullable
  private String icaoCode;

  public static final String SERIALIZED_NAME_FAA_CODE = "faa_code";
  @SerializedName(SERIALIZED_NAME_FAA_CODE)
  @javax.annotation.Nullable
  private String faaCode;

  public TimezoneAirport() {
  }

  public TimezoneAirport type(@javax.annotation.Nullable String type) {
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


  public TimezoneAirport name(@javax.annotation.Nullable String name) {
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


  public TimezoneAirport latitude(@javax.annotation.Nullable String latitude) {
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


  public TimezoneAirport longitude(@javax.annotation.Nullable String longitude) {
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


  public TimezoneAirport elevationFt(@javax.annotation.Nullable Integer elevationFt) {
    this.elevationFt = elevationFt;
    return this;
  }

  /**
   * Get elevationFt
   * @return elevationFt
   */
  @javax.annotation.Nullable
  public Integer getElevationFt() {
    return elevationFt;
  }

  public void setElevationFt(@javax.annotation.Nullable Integer elevationFt) {
    this.elevationFt = elevationFt;
  }


  public TimezoneAirport continentCode(@javax.annotation.Nullable String continentCode) {
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


  public TimezoneAirport countryCode(@javax.annotation.Nullable String countryCode) {
    this.countryCode = countryCode;
    return this;
  }

  /**
   * Get countryCode
   * @return countryCode
   */
  @javax.annotation.Nullable
  public String getCountryCode() {
    return countryCode;
  }

  public void setCountryCode(@javax.annotation.Nullable String countryCode) {
    this.countryCode = countryCode;
  }


  public TimezoneAirport stateCode(@javax.annotation.Nullable String stateCode) {
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

  public TimezoneAirport city(@javax.annotation.Nullable String city) {
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


  public TimezoneAirport municipality(@javax.annotation.Nullable String municipality) {
    this.municipality = municipality;
    return this;
  }

  /**
   * Get municipality
   * @return municipality
   */
  @javax.annotation.Nullable
  public String getMunicipality() {
    return municipality;
  }

  public void setMunicipality(@javax.annotation.Nullable String municipality) {
    this.municipality = municipality;
  }


  public TimezoneAirport iataCode(@javax.annotation.Nullable String iataCode) {
    this.iataCode = iataCode;
    return this;
  }

  /**
   * Get iataCode
   * @return iataCode
   */
  @javax.annotation.Nullable
  public String getIataCode() {
    return iataCode;
  }

  public void setIataCode(@javax.annotation.Nullable String iataCode) {
    this.iataCode = iataCode;
  }


  public TimezoneAirport icaoCode(@javax.annotation.Nullable String icaoCode) {
    this.icaoCode = icaoCode;
    return this;
  }

  /**
   * Get icaoCode
   * @return icaoCode
   */
  @javax.annotation.Nullable
  public String getIcaoCode() {
    return icaoCode;
  }

  public void setIcaoCode(@javax.annotation.Nullable String icaoCode) {
    this.icaoCode = icaoCode;
  }


  public TimezoneAirport faaCode(@javax.annotation.Nullable String faaCode) {
    this.faaCode = faaCode;
    return this;
  }

  /**
   * Get faaCode
   * @return faaCode
   */
  @javax.annotation.Nullable
  public String getFaaCode() {
    return faaCode;
  }

  public void setFaaCode(@javax.annotation.Nullable String faaCode) {
    this.faaCode = faaCode;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TimezoneAirport timezoneAirport = (TimezoneAirport) o;
    return Objects.equals(this.type, timezoneAirport.type) &&
        Objects.equals(this.name, timezoneAirport.name) &&
        Objects.equals(this.latitude, timezoneAirport.latitude) &&
        Objects.equals(this.longitude, timezoneAirport.longitude) &&
        Objects.equals(this.elevationFt, timezoneAirport.elevationFt) &&
        Objects.equals(this.continentCode, timezoneAirport.continentCode) &&
        Objects.equals(this.countryCode, timezoneAirport.countryCode) &&
        Objects.equals(this.stateCode, timezoneAirport.stateCode) &&
        Objects.equals(this.city, timezoneAirport.city) &&
        Objects.equals(this.municipality, timezoneAirport.municipality) &&
        Objects.equals(this.iataCode, timezoneAirport.iataCode) &&
        Objects.equals(this.icaoCode, timezoneAirport.icaoCode) &&
        Objects.equals(this.faaCode, timezoneAirport.faaCode);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, name, latitude, longitude, elevationFt, continentCode, countryCode, stateCode, city, municipality, iataCode, icaoCode, faaCode);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TimezoneAirport {\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    latitude: ").append(toIndentedString(latitude)).append("\n");
    sb.append("    longitude: ").append(toIndentedString(longitude)).append("\n");
    sb.append("    elevationFt: ").append(toIndentedString(elevationFt)).append("\n");
    sb.append("    continentCode: ").append(toIndentedString(continentCode)).append("\n");
    sb.append("    countryCode: ").append(toIndentedString(countryCode)).append("\n");
    sb.append("    stateCode: ").append(toIndentedString(stateCode)).append("\n");
    sb.append("    city: ").append(toIndentedString(city)).append("\n");
    sb.append("    municipality: ").append(toIndentedString(municipality)).append("\n");
    sb.append("    iataCode: ").append(toIndentedString(iataCode)).append("\n");
    sb.append("    icaoCode: ").append(toIndentedString(icaoCode)).append("\n");
    sb.append("    faaCode: ").append(toIndentedString(faaCode)).append("\n");
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
    ipGeoFields.add("type");
    ipGeoFields.add("name");
    ipGeoFields.add("latitude");
    ipGeoFields.add("longitude");
    ipGeoFields.add("elevation_ft");
    ipGeoFields.add("continent_code");
    ipGeoFields.add("country_code");
    ipGeoFields.add("state_code");
    ipGeoFields.add("city");
    ipGeoFields.add("municipality");
    ipGeoFields.add("iata_code");
    ipGeoFields.add("icao_code");
    ipGeoFields.add("faa_code");

    // a set of required properties/fields (JSON key names)
    ipGeoRequiredFields = new HashSet<String>();
  }

  /**
   * Validates the JSON Element and throws an exception if issues found
   *
   * @param jsonElement JSON Element
   * @throws IOException if the JSON Element is invalid with respect to TimezoneAirport
   */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!TimezoneAirport.ipGeoRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in TimezoneAirport is not found in the empty JSON string", TimezoneAirport.ipGeoRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!TimezoneAirport.ipGeoFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `TimezoneAirport` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
      if ((jsonObj.get("type") != null && !jsonObj.get("type").isJsonNull()) && !jsonObj.get("type").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `type` to be a primitive type in the JSON string but got `%s`", jsonObj.get("type").toString()));
      }
      if ((jsonObj.get("name") != null && !jsonObj.get("name").isJsonNull()) && !jsonObj.get("name").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `name` to be a primitive type in the JSON string but got `%s`", jsonObj.get("name").toString()));
      }
      if ((jsonObj.get("latitude") != null && !jsonObj.get("latitude").isJsonNull()) && !jsonObj.get("latitude").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `latitude` to be a primitive type in the JSON string but got `%s`", jsonObj.get("latitude").toString()));
      }
      if ((jsonObj.get("longitude") != null && !jsonObj.get("longitude").isJsonNull()) && !jsonObj.get("longitude").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `longitude` to be a primitive type in the JSON string but got `%s`", jsonObj.get("longitude").toString()));
      }
      if ((jsonObj.get("continent_code") != null && !jsonObj.get("continent_code").isJsonNull()) && !jsonObj.get("continent_code").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `continent_code` to be a primitive type in the JSON string but got `%s`", jsonObj.get("continent_code").toString()));
      }
      if ((jsonObj.get("country_code") != null && !jsonObj.get("country_code").isJsonNull()) && !jsonObj.get("country_code").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `country_code` to be a primitive type in the JSON string but got `%s`", jsonObj.get("country_code").toString()));
      }
      if ((jsonObj.get("state_code") != null && !jsonObj.get("state_code").isJsonNull()) && !jsonObj.get("state_code").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `state_code` to be a primitive type in the JSON string but got `%s`", jsonObj.get("state_code").toString()));
      }
    if ((jsonObj.get("city") != null && !jsonObj.get("city").isJsonNull()) && !jsonObj.get("city").isJsonPrimitive()) {
      throw new IllegalArgumentException(String.format("Expected the field `state_code` to be a primitive type in the JSON string but got `%s`", jsonObj.get("city").toString()));
    }
      if ((jsonObj.get("municipality") != null && !jsonObj.get("municipality").isJsonNull()) && !jsonObj.get("municipality").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `municipality` to be a primitive type in the JSON string but got `%s`", jsonObj.get("municipality").toString()));
      }
      if ((jsonObj.get("iata_code") != null && !jsonObj.get("iata_code").isJsonNull()) && !jsonObj.get("iata_code").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `iata_code` to be a primitive type in the JSON string but got `%s`", jsonObj.get("iata_code").toString()));
      }
      if ((jsonObj.get("icao_code") != null && !jsonObj.get("icao_code").isJsonNull()) && !jsonObj.get("icao_code").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `icao_code` to be a primitive type in the JSON string but got `%s`", jsonObj.get("icao_code").toString()));
      }
      if ((jsonObj.get("faa_code") != null && !jsonObj.get("faa_code").isJsonNull()) && !jsonObj.get("faa_code").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `faa_code` to be a primitive type in the JSON string but got `%s`", jsonObj.get("faa_code").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!TimezoneAirport.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'TimezoneAirport' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<TimezoneAirport> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(TimezoneAirport.class));

       return (TypeAdapter<T>) new TypeAdapter<TimezoneAirport>() {
           @Override
           public void write(JsonWriter out, TimezoneAirport value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public TimezoneAirport read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

  /**
   * Create an instance of TimezoneAirport given an JSON string
   *
   * @param jsonString JSON string
   * @return An instance of TimezoneAirport
   * @throws IOException if the JSON string is invalid with respect to TimezoneAirport
   */
  public static TimezoneAirport fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, TimezoneAirport.class);
  }

  /**
   * Convert an instance of TimezoneAirport to an JSON string
   *
   * @return JSON string
   */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

