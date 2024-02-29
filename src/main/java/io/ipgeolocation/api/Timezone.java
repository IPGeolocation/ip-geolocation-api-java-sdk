package io.ipgeolocation.api;

import java.math.BigDecimal;
import java.util.Objects;
import org.json.JSONObject;

/**
 * The {@code Timezone} class represents timezone information.
 * <p>It contains various attributes such as timezone name, offset, date, and time-related details.
 *
 * <p>The Timezone class provides several methods to access the attributes of the
 * Timezone object. For example, the {@link #getDateTimeTxt()} method returns the date and time.
 *
 */
public class Timezone {
  private final String timezone;
  private final int timezoneOffset;
  private final int timezoneOffsetWithDST;
  private final String date;
  private final String dateTime;
  private final String dateTimeTxt;
  private final String dateTimeWti;
  private final String dateTimeYmd;
  private final BigDecimal dateTimeUnix;
  private final String time24;
  private final String time12;
  private final int week;
  private final int month;
  private final int year;
  private final String yearAbbr;
  private final boolean isDST;
  private final int dstSavings;
  private TimezoneGeo geo;
  private final JSONObject json;

  /**
   * Constructs a new {@code Timezone} object with the provided JSON data.
   *
   * @param json The JSON object containing timezone data.
   * @throws IllegalArgumentException If the JSON object is null or empty.
   */
  Timezone(JSONObject json) {
    if (Objects.isNull(json)) {
      throw new IllegalArgumentException("'json' must not be null");
    }

    if (json.isEmpty()) {
      throw new IllegalArgumentException("'json' must not be empty");
    }

    this.timezone = json.getString("timezone");
    this.timezoneOffset = json.getInt("timezone_offset");
    this.timezoneOffsetWithDST = json.getInt("timezone_offset_with_dst");
    this.date = json.getString("date");
    this.dateTime = json.getString("date_time");
    this.dateTimeTxt = json.getString("date_time_txt");
    this.dateTimeWti = json.getString("date_time_wti");
    this.dateTimeYmd = json.getString("date_time_ymd");
    this.dateTimeUnix = json.getBigDecimal("date_time_unix");
    this.time24 = json.getString("time_24");
    this.time12 = json.getString("time_12");
    this.week = json.getInt("week");
    this.month = json.getInt("month");
    this.year = json.getInt("year");
    this.yearAbbr = json.getString("year_abbr");
    this.isDST = json.getBoolean("is_dst");
    this.dstSavings = json.getInt("dst_savings");

    if (json.has("geo")) {
      this.geo = new TimezoneGeo(json.getJSONObject("geo"));
    }

    this.json = json;
  }

  /**
   * Returns the timezone ID.
   *
   * @return The timezone ID as String.
   */
  public String getTimezone() {
    return timezone;
  }

  /**
   * Returns the timezone offset from UTC.
   *
   * @return The timezone offset from UTC as String.
   */
  public int getTimezoneOffset() {
    return timezoneOffset;
  }

  /**
   * Returns the timezone offset with daylight saving time (DST) from UTC.
   *
   * @return The timezone offset with DST as int.
   */
  public int getTimezoneOffsetWithDST() {
    return timezoneOffsetWithDST;
  }

  /**
   * Returns the current date in the format "yyyy-MM-dd"..
   *
   * @return the current date as int.
   */
  public String getDate() {
    return date;
  }

  /**
   * Returns the current date and time in the format "yyyy-MM-dd HH:mm:ss".
   *
   * @return the current date and time as String.
   */
  public String getDateTime() {
    return dateTime;
  }

  /**
   * Returns date and time in the format "EEEE, MMMM dd, yyyy HH:mm:ss".
   *
   * @return Formatted string for the date and time as String.
   */
  public String getDateTimeTxt() {
    return dateTimeTxt;
  }

  /**
   * Returns date and time in the format "EEE, dd MMM yyyy HH:mm:ss Z".
   *
   * @return Formatted String for the date and time as String.
   */
  public String getDateTimeWti() {
    return dateTimeWti;
  }

  /**
   * Returns date and time in the format "yyyy-MM-dd'T'HH:mm:ssZ".
   *
   * @return Formatted String for the date and time as String.
   */
  public String getDateTimeYmd() {
    return dateTimeYmd;
  }

  /**
   * Returns the current date and time in Unix timestamp format.
   *
   * @return The current date and time in Unix timestamp format as BigDecimal.
   */
  public BigDecimal getDateTimeUnix() {
    return dateTimeUnix;
  }

  /**
   * Returns the current time in 24-hour format.
   *
   * @return The current time in 24-hour format as String.
   */
  public String getTime24() {
    return time24;
  }

  /**
   * Returns the current time in 12-hour format.
   *
   * @return The current time in 12-hour format as String.
   */
  public String getTime12() {
    return time12;
  }

  /**
   * Returns the current week number.
   *
   * @return The current week number as int.
   */
  public int getWeek() {
    return week;
  }

  /**
   * Returns the current month.
   *
   * @return The current month as int.
   */
  public int getMonth() {
    return month;
  }

  /**
   * Returns the current year.
   *
   * @return The current year as int.
   */
  public int getYear() {
    return year;
  }

  /**
   * Returns the abbreviated form of the current year like "24".
   *
   * @return The abbreviated form of the current year as int.
   */
  public String getYearAbbr() {
    return yearAbbr;
  }

  /**
   * Indicates whether Daylight Saving Time (DST) is observed.
   *
   * @return {@code True} if DST is observed, otherwise {@code false}.
   */
  public boolean isDST() {
    return isDST;
  }

  /**
   * Returns the amount of time saved during DST.
   *
   * @return The amount of time saved during DST.
   */
  public int getDSTSavings() {
    return dstSavings;
  }

  /**
   * Returns the Geolocation associated with the timezone.
   *
   * @return The {@link TimezoneGeo} associated with the timezone.
   */
  public TimezoneGeo getGeo() {
    return geo;
  }

  /**
   * Returns a JSON representation of the user agent data.
   *
   * @return The JSON representation of the user agent data as a string.
   */
  @Override
  public String toString() {
    return json.toString(2);
  }
}
