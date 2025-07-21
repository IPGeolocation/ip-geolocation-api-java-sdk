/*
 * IPGeolocation.io - IP intelligence products
 * Ipgeolocation provides a set of APIs to make ip based decisions.
 */


package io.ipgeolocation.sdk.model;

import com.google.gson.*;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.ipgeolocation.sdk.invoker.JSON;

import java.io.IOException;
import java.util.*;

/**
 * Abuse
 */

public class Abuse {
  public static final String SERIALIZED_NAME_ROUTE = "route";
  @SerializedName(SERIALIZED_NAME_ROUTE)
  @javax.annotation.Nullable
  private String route;

  public static final String SERIALIZED_NAME_COUNTRY = "country";
  @SerializedName(SERIALIZED_NAME_COUNTRY)
  @javax.annotation.Nullable
  private String country;

  public static final String SERIALIZED_NAME_HANDLE = "handle";
  @SerializedName(SERIALIZED_NAME_HANDLE)
  @javax.annotation.Nullable
  private String handle;

  public static final String SERIALIZED_NAME_NAME = "name";
  @SerializedName(SERIALIZED_NAME_NAME)
  @javax.annotation.Nullable
  private String name;

  public static final String SERIALIZED_NAME_ORGANIZATION = "organization";
  @SerializedName(SERIALIZED_NAME_ORGANIZATION)
  @javax.annotation.Nullable
  private String organization;

  public static final String SERIALIZED_NAME_ROLE = "role";
  @SerializedName(SERIALIZED_NAME_ROLE)
  @javax.annotation.Nullable
  private String role;

  public static final String SERIALIZED_NAME_KIND = "kind";
  @SerializedName(SERIALIZED_NAME_KIND)
  @javax.annotation.Nullable
  private String kind;

  public static final String SERIALIZED_NAME_ADDRESS = "address";
  @SerializedName(SERIALIZED_NAME_ADDRESS)
  @javax.annotation.Nullable
  private String address;

  public static final String SERIALIZED_NAME_EMAILS = "emails";
  @SerializedName(SERIALIZED_NAME_EMAILS)
  @javax.annotation.Nullable
  private List<String> emails = new ArrayList<>();

  public static final String SERIALIZED_NAME_PHONE_NUMBERS = "phone_numbers";
  @SerializedName(SERIALIZED_NAME_PHONE_NUMBERS)
  @javax.annotation.Nullable
  private List<String> phoneNumbers = new ArrayList<>();

  public Abuse() {
  }

  public Abuse route(@javax.annotation.Nullable String route) {
    this.route = route;
    return this;
  }

  /**
   * Get route
   * @return route
   */
  @javax.annotation.Nullable
  public String getRoute() {
    return route;
  }

  public void setRoute(@javax.annotation.Nullable String route) {
    this.route = route;
  }


  public Abuse country(@javax.annotation.Nullable String country) {
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


  public Abuse handle(@javax.annotation.Nullable String handle) {
    this.handle = handle;
    return this;
  }

  /**
   * Get handle
   * @return handle
   */
  @javax.annotation.Nullable
  public String getHandle() {
    return handle;
  }

  public void setHandle(@javax.annotation.Nullable String handle) {
    this.handle = handle;
  }


  public Abuse name(@javax.annotation.Nullable String name) {
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


  public Abuse organization(@javax.annotation.Nullable String organization) {
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


  public Abuse role(@javax.annotation.Nullable String role) {
    this.role = role;
    return this;
  }

  /**
   * Get role
   * @return role
   */
  @javax.annotation.Nullable
  public String getRole() {
    return role;
  }

  public void setRole(@javax.annotation.Nullable String role) {
    this.role = role;
  }


  public Abuse kind(@javax.annotation.Nullable String kind) {
    this.kind = kind;
    return this;
  }

  /**
   * Get kind
   * @return kind
   */
  @javax.annotation.Nullable
  public String getKind() {
    return kind;
  }

  public void setKind(@javax.annotation.Nullable String kind) {
    this.kind = kind;
  }


  public Abuse address(@javax.annotation.Nullable String address) {
    this.address = address;
    return this;
  }

  /**
   * Get address
   * @return address
   */
  @javax.annotation.Nullable
  public String getAddress() {
    return address;
  }

  public void setAddress(@javax.annotation.Nullable String address) {
    this.address = address;
  }


  public Abuse emails(@javax.annotation.Nullable List<String> emails) {
    this.emails = emails;
    return this;
  }

  public Abuse addEmailsItem(String emailsItem) {
    if (this.emails == null) {
      this.emails = new ArrayList<>();
    }
    this.emails.add(emailsItem);
    return this;
  }

  /**
   * Get emails
   * @return emails
   */
  @javax.annotation.Nullable
  public List<String> getEmails() {
    return emails;
  }

  public void setEmails(@javax.annotation.Nullable List<String> emails) {
    this.emails = emails;
  }


  public Abuse phoneNumbers(@javax.annotation.Nullable List<String> phoneNumbers) {
    this.phoneNumbers = phoneNumbers;
    return this;
  }

  public Abuse addPhoneNumbersItem(String phoneNumbersItem) {
    if (this.phoneNumbers == null) {
      this.phoneNumbers = new ArrayList<>();
    }
    this.phoneNumbers.add(phoneNumbersItem);
    return this;
  }

  /**
   * Get phoneNumbers
   * @return phoneNumbers
   */
  @javax.annotation.Nullable
  public List<String> getPhoneNumbers() {
    return phoneNumbers;
  }

  public void setPhoneNumbers(@javax.annotation.Nullable List<String> phoneNumbers) {
    this.phoneNumbers = phoneNumbers;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Abuse abuse = (Abuse) o;
    return Objects.equals(this.route, abuse.route) &&
        Objects.equals(this.country, abuse.country) &&
        Objects.equals(this.handle, abuse.handle) &&
        Objects.equals(this.name, abuse.name) &&
        Objects.equals(this.organization, abuse.organization) &&
        Objects.equals(this.role, abuse.role) &&
        Objects.equals(this.kind, abuse.kind) &&
        Objects.equals(this.address, abuse.address) &&
        Objects.equals(this.emails, abuse.emails) &&
        Objects.equals(this.phoneNumbers, abuse.phoneNumbers);
  }

  @Override
  public int hashCode() {
    return Objects.hash(route, country, handle, name, organization, role, kind, address, emails, phoneNumbers);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Abuse {\n");
    sb.append("    route: ").append(toIndentedString(route)).append("\n");
    sb.append("    country: ").append(toIndentedString(country)).append("\n");
    sb.append("    handle: ").append(toIndentedString(handle)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    organization: ").append(toIndentedString(organization)).append("\n");
    sb.append("    role: ").append(toIndentedString(role)).append("\n");
    sb.append("    kind: ").append(toIndentedString(kind)).append("\n");
    sb.append("    address: ").append(toIndentedString(address)).append("\n");
    sb.append("    emails: ").append(toIndentedString(emails)).append("\n");
    sb.append("    phoneNumbers: ").append(toIndentedString(phoneNumbers)).append("\n");
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
    ipGeoFields.add("route");
    ipGeoFields.add("country");
    ipGeoFields.add("handle");
    ipGeoFields.add("name");
    ipGeoFields.add("organization");
    ipGeoFields.add("role");
    ipGeoFields.add("kind");
    ipGeoFields.add("address");
    ipGeoFields.add("emails");
    ipGeoFields.add("phone_numbers");

    // a set of required properties/fields (JSON key names)
    ipGeoRequiredFields = new HashSet<String>();
  }

  /**
   * Validates the JSON Element and throws an exception if issues found
   *
   * @param jsonElement JSON Element
   * @throws IOException if the JSON Element is invalid with respect to Abuse
   */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!Abuse.ipGeoRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in Abuse is not found in the empty JSON string", Abuse.ipGeoRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!Abuse.ipGeoFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `Abuse` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
      if ((jsonObj.get("route") != null && !jsonObj.get("route").isJsonNull()) && !jsonObj.get("route").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `route` to be a primitive type in the JSON string but got `%s`", jsonObj.get("route").toString()));
      }
      if ((jsonObj.get("country") != null && !jsonObj.get("country").isJsonNull()) && !jsonObj.get("country").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `country` to be a primitive type in the JSON string but got `%s`", jsonObj.get("country").toString()));
      }
      if ((jsonObj.get("handle") != null && !jsonObj.get("handle").isJsonNull()) && !jsonObj.get("handle").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `handle` to be a primitive type in the JSON string but got `%s`", jsonObj.get("handle").toString()));
      }
      if ((jsonObj.get("name") != null && !jsonObj.get("name").isJsonNull()) && !jsonObj.get("name").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `name` to be a primitive type in the JSON string but got `%s`", jsonObj.get("name").toString()));
      }
      if ((jsonObj.get("organization") != null && !jsonObj.get("organization").isJsonNull()) && !jsonObj.get("organization").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `organization` to be a primitive type in the JSON string but got `%s`", jsonObj.get("organization").toString()));
      }
      if ((jsonObj.get("role") != null && !jsonObj.get("role").isJsonNull()) && !jsonObj.get("role").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `role` to be a primitive type in the JSON string but got `%s`", jsonObj.get("role").toString()));
      }
      if ((jsonObj.get("kind") != null && !jsonObj.get("kind").isJsonNull()) && !jsonObj.get("kind").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `kind` to be a primitive type in the JSON string but got `%s`", jsonObj.get("kind").toString()));
      }
      if ((jsonObj.get("address") != null && !jsonObj.get("address").isJsonNull()) && !jsonObj.get("address").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `address` to be a primitive type in the JSON string but got `%s`", jsonObj.get("address").toString()));
      }
      // ensure the optional json data is an array if present
      if (jsonObj.get("emails") != null && !jsonObj.get("emails").isJsonNull() && !jsonObj.get("emails").isJsonArray()) {
        throw new IllegalArgumentException(String.format("Expected the field `emails` to be an array in the JSON string but got `%s`", jsonObj.get("emails").toString()));
      }
      // ensure the optional json data is an array if present
      if (jsonObj.get("phone_numbers") != null && !jsonObj.get("phone_numbers").isJsonNull() && !jsonObj.get("phone_numbers").isJsonArray()) {
        throw new IllegalArgumentException(String.format("Expected the field `phone_numbers` to be an array in the JSON string but got `%s`", jsonObj.get("phone_numbers").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!Abuse.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'Abuse' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<Abuse> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(Abuse.class));

       return (TypeAdapter<T>) new TypeAdapter<Abuse>() {
           @Override
           public void write(JsonWriter out, Abuse value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public Abuse read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

  /**
   * Create an instance of Abuse given an JSON string
   *
   * @param jsonString JSON string
   * @return An instance of Abuse
   * @throws IOException if the JSON string is invalid with respect to Abuse
   */
  public static Abuse fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, Abuse.class);
  }

  /**
   * Convert an instance of Abuse to an JSON string
   *
   * @return JSON string
   */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

