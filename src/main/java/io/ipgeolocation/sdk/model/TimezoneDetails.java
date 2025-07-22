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
import java.time.LocalDate;
import java.time.OffsetDateTime;

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
 * TimezoneDetail
 */

public class TimezoneDetails {
  public static final String SERIALIZED_NAME_NAME = "name";
  @SerializedName(SERIALIZED_NAME_NAME)
  @javax.annotation.Nullable
  private String name;

  public static final String SERIALIZED_NAME_OFFSET = "offset";
  @SerializedName(SERIALIZED_NAME_OFFSET)
  @javax.annotation.Nullable
  private Integer offset;

  public static final String SERIALIZED_NAME_OFFSET_WITH_DST = "offset_with_dst";
  @SerializedName(SERIALIZED_NAME_OFFSET_WITH_DST)
  @javax.annotation.Nullable
  private Integer offsetWithDst;

  public static final String SERIALIZED_NAME_DATE = "date";
  @SerializedName(SERIALIZED_NAME_DATE)
  @javax.annotation.Nullable
  private String date;

  public static final String SERIALIZED_NAME_DATE_TIME = "date_time";
  @SerializedName(SERIALIZED_NAME_DATE_TIME)
  @javax.annotation.Nullable
  private String dateTime;

  public static final String SERIALIZED_NAME_DATE_TIME_TXT = "date_time_txt";
  @SerializedName(SERIALIZED_NAME_DATE_TIME_TXT)
  @javax.annotation.Nullable
  private String dateTimeTxt;

  public static final String SERIALIZED_NAME_DATE_TIME_WTI = "date_time_wti";
  @SerializedName(SERIALIZED_NAME_DATE_TIME_WTI)
  @javax.annotation.Nullable
  private String dateTimeWti;

  public static final String SERIALIZED_NAME_DATE_TIME_YMD = "date_time_ymd";
  @SerializedName(SERIALIZED_NAME_DATE_TIME_YMD)
  @javax.annotation.Nullable
  private String dateTimeYmd;

  public static final String SERIALIZED_NAME_DATE_TIME_UNIX = "date_time_unix";
  @SerializedName(SERIALIZED_NAME_DATE_TIME_UNIX)
  @javax.annotation.Nullable
  private Double dateTimeUnix;

  public static final String SERIALIZED_NAME_TIME24 = "time_24";
  @SerializedName(SERIALIZED_NAME_TIME24)
  @javax.annotation.Nullable
  private String time24;

  public static final String SERIALIZED_NAME_TIME12 = "time_12";
  @SerializedName(SERIALIZED_NAME_TIME12)
  @javax.annotation.Nullable
  private String time12;

  public static final String SERIALIZED_NAME_WEEK = "week";
  @SerializedName(SERIALIZED_NAME_WEEK)
  @javax.annotation.Nullable
  private Integer week;

  public static final String SERIALIZED_NAME_MONTH = "month";
  @SerializedName(SERIALIZED_NAME_MONTH)
  @javax.annotation.Nullable
  private Integer month;

  public static final String SERIALIZED_NAME_YEAR = "year";
  @SerializedName(SERIALIZED_NAME_YEAR)
  @javax.annotation.Nullable
  private Integer year;

  public static final String SERIALIZED_NAME_YEAR_ABBR = "year_abbr";
  @SerializedName(SERIALIZED_NAME_YEAR_ABBR)
  @javax.annotation.Nullable
  private String yearAbbr;

  public static final String SERIALIZED_NAME_IS_DST = "is_dst";
  @SerializedName(SERIALIZED_NAME_IS_DST)
  @javax.annotation.Nullable
  private Boolean isDst;

  public static final String SERIALIZED_NAME_DST_SAVINGS = "dst_savings";
  @SerializedName(SERIALIZED_NAME_DST_SAVINGS)
  @javax.annotation.Nullable
  private Integer dstSavings;

  public static final String SERIALIZED_NAME_DST_EXISTS = "dst_exists";
  @SerializedName(SERIALIZED_NAME_DST_EXISTS)
  @javax.annotation.Nullable
  private Boolean dstExists;

  public static final String SERIALIZED_NAME_DST_START = "dst_start";
  @SerializedName(SERIALIZED_NAME_DST_START)
  @javax.annotation.Nullable
  private TimezoneDetailDstStart dstStart;

  public static final String SERIALIZED_NAME_DST_END = "dst_end";
  @SerializedName(SERIALIZED_NAME_DST_END)
  @javax.annotation.Nullable
  private TimezoneDetailDstEnd dstEnd;

  public TimezoneDetails() {
  }

  public TimezoneDetails name(@javax.annotation.Nullable String name) {
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


  public TimezoneDetails offset(@javax.annotation.Nullable Integer offset) {
    this.offset = offset;
    return this;
  }

  /**
   * Get offset
   * @return offset
   */
  @javax.annotation.Nullable
  public Integer getOffset() {
    return offset;
  }

  public void setOffset(@javax.annotation.Nullable Integer offset) {
    this.offset = offset;
  }


  public TimezoneDetails offsetWithDst(@javax.annotation.Nullable Integer offsetWithDst) {
    this.offsetWithDst = offsetWithDst;
    return this;
  }

  /**
   * Get offsetWithDst
   * @return offsetWithDst
   */
  @javax.annotation.Nullable
  public Integer getOffsetWithDst() {
    return offsetWithDst;
  }

  public void setOffsetWithDst(@javax.annotation.Nullable Integer offsetWithDst) {
    this.offsetWithDst = offsetWithDst;
  }

  public TimezoneDetails date(@javax.annotation.Nullable String date) {
    this.date = date;
    return this;
  }

  /**
   * Get date
   * @return date
   */
  @javax.annotation.Nullable
  public String getDate() {
    return date;
  }

  public void setDate(@javax.annotation.Nullable String date) {
    this.date = date;
  }


  public TimezoneDetails dateTime(@javax.annotation.Nullable String dateTime) {
    this.dateTime = dateTime;
    return this;
  }

  /**
   * Get dateTime
   * @return dateTime
   */
  @javax.annotation.Nullable
  public String getDateTime() {
    return dateTime;
  }

  public void setDateTime(@javax.annotation.Nullable String dateTime) {
    this.dateTime = dateTime;
  }


  public TimezoneDetails dateTimeTxt(@javax.annotation.Nullable String dateTimeTxt) {
    this.dateTimeTxt = dateTimeTxt;
    return this;
  }

  /**
   * Get dateTimeTxt
   * @return dateTimeTxt
   */
  @javax.annotation.Nullable
  public String getDateTimeTxt() {
    return dateTimeTxt;
  }

  public void setDateTimeTxt(@javax.annotation.Nullable String dateTimeTxt) {
    this.dateTimeTxt = dateTimeTxt;
  }


  public TimezoneDetails dateTimeWti(@javax.annotation.Nullable String dateTimeWti) {
    this.dateTimeWti = dateTimeWti;
    return this;
  }

  /**
   * Get dateTimeWti
   * @return dateTimeWti
   */
  @javax.annotation.Nullable
  public String getDateTimeWti() {
    return dateTimeWti;
  }

  public void setDateTimeWti(@javax.annotation.Nullable String dateTimeWti) {
    this.dateTimeWti = dateTimeWti;
  }


  public TimezoneDetails dateTimeYmd(@javax.annotation.Nullable String dateTimeYmd) {
    this.dateTimeYmd = dateTimeYmd;
    return this;
  }

  /**
   * Get dateTimeYmd
   * @return dateTimeYmd
   */
  @javax.annotation.Nullable
  public String getDateTimeYmd() {
    return dateTimeYmd;
  }

  public void setDateTimeYmd(@javax.annotation.Nullable String dateTimeYmd) {
    this.dateTimeYmd = dateTimeYmd;
  }


  public TimezoneDetails dateTimeUnix(@javax.annotation.Nullable Double dateTimeUnix) {
    this.dateTimeUnix = dateTimeUnix;
    return this;
  }

  /**
   * Get dateTimeUnix
   * @return dateTimeUnix
   */
  @javax.annotation.Nullable
  public Double getDateTimeUnix() {
    return dateTimeUnix;
  }

  public void setDateTimeUnix(@javax.annotation.Nullable Double dateTimeUnix) {
    this.dateTimeUnix = dateTimeUnix;
  }


  public TimezoneDetails time24(@javax.annotation.Nullable String time24) {
    this.time24 = time24;
    return this;
  }

  /**
   * Get time24
   * @return time24
   */
  @javax.annotation.Nullable
  public String getTime24() {
    return time24;
  }

  public void setTime24(@javax.annotation.Nullable String time24) {
    this.time24 = time24;
  }


  public TimezoneDetails time12(@javax.annotation.Nullable String time12) {
    this.time12 = time12;
    return this;
  }

  /**
   * Get time12
   * @return time12
   */
  @javax.annotation.Nullable
  public String getTime12() {
    return time12;
  }

  public void setTime12(@javax.annotation.Nullable String time12) {
    this.time12 = time12;
  }


  public TimezoneDetails week(@javax.annotation.Nullable Integer week) {
    this.week = week;
    return this;
  }

  /**
   * Get week
   * @return week
   */
  @javax.annotation.Nullable
  public Integer getWeek() {
    return week;
  }

  public void setWeek(@javax.annotation.Nullable Integer week) {
    this.week = week;
  }


  public TimezoneDetails month(@javax.annotation.Nullable Integer month) {
    this.month = month;
    return this;
  }

  /**
   * Get month
   * @return month
   */
  @javax.annotation.Nullable
  public Integer getMonth() {
    return month;
  }

  public void setMonth(@javax.annotation.Nullable Integer month) {
    this.month = month;
  }


  public TimezoneDetails year(@javax.annotation.Nullable Integer year) {
    this.year = year;
    return this;
  }

  /**
   * Get year
   * @return year
   */
  @javax.annotation.Nullable
  public Integer getYear() {
    return year;
  }

  public void setYear(@javax.annotation.Nullable Integer year) {
    this.year = year;
  }


  public TimezoneDetails yearAbbr(@javax.annotation.Nullable String yearAbbr) {
    this.yearAbbr = yearAbbr;
    return this;
  }

  /**
   * Get yearAbbr
   * @return yearAbbr
   */
  @javax.annotation.Nullable
  public String getYearAbbr() {
    return yearAbbr;
  }

  public void setYearAbbr(@javax.annotation.Nullable String yearAbbr) {
    this.yearAbbr = yearAbbr;
  }


  public TimezoneDetails isDst(@javax.annotation.Nullable Boolean isDst) {
    this.isDst = isDst;
    return this;
  }

  /**
   * Get isDst
   * @return isDst
   */
  @javax.annotation.Nullable
  public Boolean getIsDst() {
    return isDst;
  }

  public void setIsDst(@javax.annotation.Nullable Boolean isDst) {
    this.isDst = isDst;
  }


  public TimezoneDetails dstSavings(@javax.annotation.Nullable Integer dstSavings) {
    this.dstSavings = dstSavings;
    return this;
  }

  /**
   * Get dstSavings
   * @return dstSavings
   */
  @javax.annotation.Nullable
  public Integer getDstSavings() {
    return dstSavings;
  }

  public void setDstSavings(@javax.annotation.Nullable Integer dstSavings) {
    this.dstSavings = dstSavings;
  }


  public TimezoneDetails dstExists(@javax.annotation.Nullable Boolean dstExists) {
    this.dstExists = dstExists;
    return this;
  }

  /**
   * Get dstExists
   * @return dstExists
   */
  @javax.annotation.Nullable
  public Boolean getDstExists() {
    return dstExists;
  }

  public void setDstExists(@javax.annotation.Nullable Boolean dstExists) {
    this.dstExists = dstExists;
  }


  public TimezoneDetails dstStart(@javax.annotation.Nullable TimezoneDetailDstStart dstStart) {
    this.dstStart = dstStart;
    return this;
  }

  /**
   * Get dstStart
   * @return dstStart
   */
  @javax.annotation.Nullable
  public TimezoneDetailDstStart getDstStart() {
    return dstStart;
  }

  public void setDstStart(@javax.annotation.Nullable TimezoneDetailDstStart dstStart) {
    this.dstStart = dstStart;
  }


  public TimezoneDetails dstEnd(@javax.annotation.Nullable TimezoneDetailDstEnd dstEnd) {
    this.dstEnd = dstEnd;
    return this;
  }

  /**
   * Get dstEnd
   * @return dstEnd
   */
  @javax.annotation.Nullable
  public TimezoneDetailDstEnd getDstEnd() {
    return dstEnd;
  }

  public void setDstEnd(@javax.annotation.Nullable TimezoneDetailDstEnd dstEnd) {
    this.dstEnd = dstEnd;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TimezoneDetails timezoneDetails = (TimezoneDetails) o;
    return Objects.equals(this.name, timezoneDetails.name) &&
        Objects.equals(this.offset, timezoneDetails.offset) &&
        Objects.equals(this.offsetWithDst, timezoneDetails.offsetWithDst) &&
        Objects.equals(this.date, timezoneDetails.date) &&
        Objects.equals(this.dateTime, timezoneDetails.dateTime) &&
        Objects.equals(this.dateTimeTxt, timezoneDetails.dateTimeTxt) &&
        Objects.equals(this.dateTimeWti, timezoneDetails.dateTimeWti) &&
        Objects.equals(this.dateTimeYmd, timezoneDetails.dateTimeYmd) &&
        Objects.equals(this.dateTimeUnix, timezoneDetails.dateTimeUnix) &&
        Objects.equals(this.time24, timezoneDetails.time24) &&
        Objects.equals(this.time12, timezoneDetails.time12) &&
        Objects.equals(this.week, timezoneDetails.week) &&
        Objects.equals(this.month, timezoneDetails.month) &&
        Objects.equals(this.year, timezoneDetails.year) &&
        Objects.equals(this.yearAbbr, timezoneDetails.yearAbbr) &&
        Objects.equals(this.isDst, timezoneDetails.isDst) &&
        Objects.equals(this.dstSavings, timezoneDetails.dstSavings) &&
        Objects.equals(this.dstExists, timezoneDetails.dstExists) &&
        Objects.equals(this.dstStart, timezoneDetails.dstStart) &&
        Objects.equals(this.dstEnd, timezoneDetails.dstEnd);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, offset, offsetWithDst, date, dateTime, dateTimeTxt, dateTimeWti, dateTimeYmd, dateTimeUnix, time24, time12, week, month, year, yearAbbr, isDst, dstSavings, dstExists, dstStart, dstEnd);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TimezoneDetails {\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    offset: ").append(toIndentedString(offset)).append("\n");
    sb.append("    offsetWithDst: ").append(toIndentedString(offsetWithDst)).append("\n");
    sb.append("    date: ").append(toIndentedString(date)).append("\n");
    sb.append("    dateTime: ").append(toIndentedString(dateTime)).append("\n");
    sb.append("    dateTimeTxt: ").append(toIndentedString(dateTimeTxt)).append("\n");
    sb.append("    dateTimeWti: ").append(toIndentedString(dateTimeWti)).append("\n");
    sb.append("    dateTimeYmd: ").append(toIndentedString(dateTimeYmd)).append("\n");
    sb.append("    dateTimeUnix: ").append(toIndentedString(dateTimeUnix)).append("\n");
    sb.append("    time24: ").append(toIndentedString(time24)).append("\n");
    sb.append("    time12: ").append(toIndentedString(time12)).append("\n");
    sb.append("    week: ").append(toIndentedString(week)).append("\n");
    sb.append("    month: ").append(toIndentedString(month)).append("\n");
    sb.append("    year: ").append(toIndentedString(year)).append("\n");
    sb.append("    yearAbbr: ").append(toIndentedString(yearAbbr)).append("\n");
    sb.append("    isDst: ").append(toIndentedString(isDst)).append("\n");
    sb.append("    dstSavings: ").append(toIndentedString(dstSavings)).append("\n");
    sb.append("    dstExists: ").append(toIndentedString(dstExists)).append("\n");
    sb.append("    dstStart: ").append(toIndentedString(dstStart)).append("\n");
    sb.append("    dstEnd: ").append(toIndentedString(dstEnd)).append("\n");
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
    ipGeoFields.add("offset");
    ipGeoFields.add("offset_with_dst");
    ipGeoFields.add("date");
    ipGeoFields.add("date_time");
    ipGeoFields.add("date_time_txt");
    ipGeoFields.add("date_time_wti");
    ipGeoFields.add("date_time_ymd");
    ipGeoFields.add("date_time_unix");
    ipGeoFields.add("time_24");
    ipGeoFields.add("time_12");
    ipGeoFields.add("week");
    ipGeoFields.add("month");
    ipGeoFields.add("year");
    ipGeoFields.add("year_abbr");
    ipGeoFields.add("is_dst");
    ipGeoFields.add("dst_savings");
    ipGeoFields.add("dst_exists");
    ipGeoFields.add("dst_start");
    ipGeoFields.add("dst_end");

    // a set of required properties/fields (JSON key names)
    ipGeoRequiredFields = new HashSet<String>();
  }

  /**
   * Validates the JSON Element and throws an exception if issues found
   *
   * @param jsonElement JSON Element
   * @throws IOException if the JSON Element is invalid with respect to TimezoneDetail
   */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!TimezoneDetails.ipGeoRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in TimezoneDetail is not found in the empty JSON string", TimezoneDetails.ipGeoRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!TimezoneDetails.ipGeoFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `TimezoneDetail` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
      if ((jsonObj.get("name") != null && !jsonObj.get("name").isJsonNull()) && !jsonObj.get("name").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `name` to be a primitive type in the JSON string but got `%s`", jsonObj.get("name").toString()));
      }
      if ((jsonObj.get("date_time") != null && !jsonObj.get("date_time").isJsonNull()) && !jsonObj.get("date_time").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `date_time` to be a primitive type in the JSON string but got `%s`", jsonObj.get("date_time").toString()));
      }
      if ((jsonObj.get("date_time_txt") != null && !jsonObj.get("date_time_txt").isJsonNull()) && !jsonObj.get("date_time_txt").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `date_time_txt` to be a primitive type in the JSON string but got `%s`", jsonObj.get("date_time_txt").toString()));
      }
      if ((jsonObj.get("date_time_wti") != null && !jsonObj.get("date_time_wti").isJsonNull()) && !jsonObj.get("date_time_wti").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `date_time_wti` to be a primitive type in the JSON string but got `%s`", jsonObj.get("date_time_wti").toString()));
      }
      if ((jsonObj.get("time_24") != null && !jsonObj.get("time_24").isJsonNull()) && !jsonObj.get("time_24").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `time_24` to be a primitive type in the JSON string but got `%s`", jsonObj.get("time_24").toString()));
      }
      if ((jsonObj.get("time_12") != null && !jsonObj.get("time_12").isJsonNull()) && !jsonObj.get("time_12").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `time_12` to be a primitive type in the JSON string but got `%s`", jsonObj.get("time_12").toString()));
      }
      if ((jsonObj.get("year_abbr") != null && !jsonObj.get("year_abbr").isJsonNull()) && !jsonObj.get("year_abbr").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `year_abbr` to be a primitive type in the JSON string but got `%s`", jsonObj.get("year_abbr").toString()));
      }
      // validate the optional field `dst_start`
      if (jsonObj.get("dst_start") != null && !jsonObj.get("dst_start").isJsonNull()) {
        TimezoneDetailDstStart.validateJsonElement(jsonObj.get("dst_start"));
      }
      // validate the optional field `dst_end`
      if (jsonObj.get("dst_end") != null && !jsonObj.get("dst_end").isJsonNull()) {
        TimezoneDetailDstEnd.validateJsonElement(jsonObj.get("dst_end"));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!TimezoneDetails.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'TimezoneDetail' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<TimezoneDetails> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(TimezoneDetails.class));

       return (TypeAdapter<T>) new TypeAdapter<TimezoneDetails>() {
           @Override
           public void write(JsonWriter out, TimezoneDetails value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public TimezoneDetails read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

  /**
   * Create an instance of TimezoneDetail given an JSON string
   *
   * @param jsonString JSON string
   * @return An instance of TimezoneDetail
   * @throws IOException if the JSON string is invalid with respect to TimezoneDetail
   */
  public static TimezoneDetails fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, TimezoneDetails.class);
  }

  /**
   * Convert an instance of TimezoneDetail to an JSON string
   *
   * @return JSON string
   */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

