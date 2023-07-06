package io.ipgeolocation.api;

import java.math.BigDecimal;
import java.util.Objects;
import org.json.JSONObject;

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

  public String getTimezone() {
    return timezone;
  }

  public int getTimezoneOffset() {
    return timezoneOffset;
  }

  public int getTimezoneOffsetWithDST() {
    return timezoneOffsetWithDST;
  }

  public String getDate() {
    return date;
  }

  public String getDateTime() {
    return dateTime;
  }

  public String getDateTimeTxt() {
    return dateTimeTxt;
  }

  public String getDateTimeWti() {
    return dateTimeWti;
  }

  public String getDateTimeYmd() {
    return dateTimeYmd;
  }

  public BigDecimal getDateTimeUnix() {
    return dateTimeUnix;
  }

  public String getTime24() {
    return time24;
  }

  public String getTime12() {
    return time12;
  }

  public int getWeek() {
    return week;
  }

  public int getMonth() {
    return month;
  }

  public int getYear() {
    return year;
  }

  public String getYearAbbr() {
    return yearAbbr;
  }

  public boolean isDST() {
    return isDST;
  }

  public int getDSTSavings() {
    return dstSavings;
  }

  public TimezoneGeo getGeo() {
    return geo;
  }

  @Override
  public String toString() {
    return json.toString(2);
  }
}
