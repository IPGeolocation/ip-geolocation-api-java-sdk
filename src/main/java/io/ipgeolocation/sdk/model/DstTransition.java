package io.ipgeolocation.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * Daylight-saving transition boundary description.
 *
 * <p>{@code utcTime} is the UTC transition instant returned by the API. {@code duration} is the
 * offset-change duration string, while {@code gap} and {@code overlap} indicate how the local
 * clock behaves around the transition. {@code dateTimeBefore} and {@code dateTimeAfter} are the
 * local date-time values on each side of the transition.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public final class DstTransition {
  private final String utcTime;
  private final String duration;
  private final Boolean gap;
  private final String dateTimeAfter;
  private final String dateTimeBefore;
  private final Boolean overlap;

  @JsonCreator
  public DstTransition(
      @JsonProperty("utc_time") String utcTime,
      @JsonProperty("duration") String duration,
      @JsonProperty("gap") Boolean gap,
      @JsonProperty("date_time_after") String dateTimeAfter,
      @JsonProperty("date_time_before") String dateTimeBefore,
      @JsonProperty("overlap") Boolean overlap) {
    this.utcTime = utcTime;
    this.duration = duration;
    this.gap = gap;
    this.dateTimeAfter = dateTimeAfter;
    this.dateTimeBefore = dateTimeBefore;
    this.overlap = overlap;
  }

  public String utcTime() { return utcTime; }
  public String duration() { return duration; }
  public Boolean gap() { return gap; }
  public String dateTimeAfter() { return dateTimeAfter; }
  public String dateTimeBefore() { return dateTimeBefore; }
  public Boolean overlap() { return overlap; }

  @Override
  public boolean equals(Object other) {
    if (this == other) {
      return true;
    }
    if (!(other instanceof DstTransition)) {
      return false;
    }
    DstTransition that = (DstTransition) other;
    return Objects.equals(utcTime, that.utcTime)
        && Objects.equals(duration, that.duration)
        && Objects.equals(gap, that.gap)
        && Objects.equals(dateTimeAfter, that.dateTimeAfter)
        && Objects.equals(dateTimeBefore, that.dateTimeBefore)
        && Objects.equals(overlap, that.overlap);
  }

  @Override
  public int hashCode() {
    return Objects.hash(utcTime, duration, gap, dateTimeAfter, dateTimeBefore, overlap);
  }

  @Override
  public String toString() {
    return "DstTransition{utcTime='"
        + utcTime
        + "', duration='"
        + duration
        + "', gap="
        + gap
        + ", dateTimeAfter='"
        + dateTimeAfter
        + "', dateTimeBefore='"
        + dateTimeBefore
        + "', overlap="
        + overlap
        + '}';
  }
}
