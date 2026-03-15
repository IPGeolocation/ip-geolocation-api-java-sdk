package io.ipgeolocation.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * Time-zone and daylight-saving details for the resolved location.
 *
 * <p>{@code offset} is the standard UTC offset returned by the API. {@code offsetWithDst} is the
 * effective offset when daylight saving applies. {@code currentTime} and
 * {@code currentTimeUnix} represent the current local time values returned for the location.
 * {@code dstStart} and {@code dstEnd} describe daylight-saving transition boundaries when the
 * time zone observes DST.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public final class TimeZoneInfo {
  private final String name;
  private final Double offset;
  private final Double offsetWithDst;
  private final String currentTime;
  private final Double currentTimeUnix;
  private final String currentTzAbbreviation;
  private final String currentTzFullName;
  private final String standardTzAbbreviation;
  private final String standardTzFullName;
  private final Boolean isDst;
  private final Double dstSavings;
  private final Boolean dstExists;
  private final String dstTzAbbreviation;
  private final String dstTzFullName;
  private final DstTransition dstStart;
  private final DstTransition dstEnd;

  @JsonCreator
  public TimeZoneInfo(
      @JsonProperty("name") String name,
      @JsonProperty("offset") Double offset,
      @JsonProperty("offset_with_dst") Double offsetWithDst,
      @JsonProperty("current_time") String currentTime,
      @JsonProperty("current_time_unix") Double currentTimeUnix,
      @JsonProperty("current_tz_abbreviation") String currentTzAbbreviation,
      @JsonProperty("current_tz_full_name") String currentTzFullName,
      @JsonProperty("standard_tz_abbreviation") String standardTzAbbreviation,
      @JsonProperty("standard_tz_full_name") String standardTzFullName,
      @JsonProperty("is_dst") Boolean isDst,
      @JsonProperty("dst_savings") Double dstSavings,
      @JsonProperty("dst_exists") Boolean dstExists,
      @JsonProperty("dst_tz_abbreviation") String dstTzAbbreviation,
      @JsonProperty("dst_tz_full_name") String dstTzFullName,
      @JsonProperty("dst_start") DstTransition dstStart,
      @JsonProperty("dst_end") DstTransition dstEnd) {
    this.name = name;
    this.offset = offset;
    this.offsetWithDst = offsetWithDst;
    this.currentTime = currentTime;
    this.currentTimeUnix = currentTimeUnix;
    this.currentTzAbbreviation = currentTzAbbreviation;
    this.currentTzFullName = currentTzFullName;
    this.standardTzAbbreviation = standardTzAbbreviation;
    this.standardTzFullName = standardTzFullName;
    this.isDst = isDst;
    this.dstSavings = dstSavings;
    this.dstExists = dstExists;
    this.dstTzAbbreviation = dstTzAbbreviation;
    this.dstTzFullName = dstTzFullName;
    this.dstStart = dstStart;
    this.dstEnd = dstEnd;
  }

  public String name() { return name; }
  public Double offset() { return offset; }
  public Double offsetWithDst() { return offsetWithDst; }
  public String currentTime() { return currentTime; }
  /**
   * @return current local time as a Unix timestamp value returned by the API
   */
  public Double currentTimeUnix() { return currentTimeUnix; }
  public String currentTzAbbreviation() { return currentTzAbbreviation; }
  public String currentTzFullName() { return currentTzFullName; }
  public String standardTzAbbreviation() { return standardTzAbbreviation; }
  public String standardTzFullName() { return standardTzFullName; }
  public Boolean isDst() { return isDst; }
  /**
   * @return daylight-saving offset savings in hours
   */
  public Double dstSavings() { return dstSavings; }
  public Boolean dstExists() { return dstExists; }
  public String dstTzAbbreviation() { return dstTzAbbreviation; }
  public String dstTzFullName() { return dstTzFullName; }
  public DstTransition dstStart() { return dstStart; }
  public DstTransition dstEnd() { return dstEnd; }

  @Override
  public boolean equals(Object other) {
    if (this == other) {
      return true;
    }
    if (!(other instanceof TimeZoneInfo)) {
      return false;
    }
    TimeZoneInfo that = (TimeZoneInfo) other;
    return Objects.equals(name, that.name)
        && Objects.equals(offset, that.offset)
        && Objects.equals(offsetWithDst, that.offsetWithDst)
        && Objects.equals(currentTime, that.currentTime)
        && Objects.equals(currentTimeUnix, that.currentTimeUnix)
        && Objects.equals(currentTzAbbreviation, that.currentTzAbbreviation)
        && Objects.equals(currentTzFullName, that.currentTzFullName)
        && Objects.equals(standardTzAbbreviation, that.standardTzAbbreviation)
        && Objects.equals(standardTzFullName, that.standardTzFullName)
        && Objects.equals(isDst, that.isDst)
        && Objects.equals(dstSavings, that.dstSavings)
        && Objects.equals(dstExists, that.dstExists)
        && Objects.equals(dstTzAbbreviation, that.dstTzAbbreviation)
        && Objects.equals(dstTzFullName, that.dstTzFullName)
        && Objects.equals(dstStart, that.dstStart)
        && Objects.equals(dstEnd, that.dstEnd);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        name,
        offset,
        offsetWithDst,
        currentTime,
        currentTimeUnix,
        currentTzAbbreviation,
        currentTzFullName,
        standardTzAbbreviation,
        standardTzFullName,
        isDst,
        dstSavings,
        dstExists,
        dstTzAbbreviation,
        dstTzFullName,
        dstStart,
        dstEnd);
  }

  @Override
  public String toString() {
    return "TimeZoneInfo{name='"
        + name
        + "', offset="
        + offset
        + ", offsetWithDst="
        + offsetWithDst
        + ", currentTime='"
        + currentTime
        + "', currentTimeUnix="
        + currentTimeUnix
        + ", currentTzAbbreviation='"
        + currentTzAbbreviation
        + "', currentTzFullName='"
        + currentTzFullName
        + "', standardTzAbbreviation='"
        + standardTzAbbreviation
        + "', standardTzFullName='"
        + standardTzFullName
        + "', isDst="
        + isDst
        + ", dstSavings="
        + dstSavings
        + ", dstExists="
        + dstExists
        + ", dstTzAbbreviation='"
        + dstTzAbbreviation
        + "', dstTzFullName='"
        + dstTzFullName
        + "', dstStart="
        + dstStart
        + ", dstEnd="
        + dstEnd
        + '}';
  }
}
