package io.ipgeolocation.api;

import java.math.BigDecimal;
import java.util.Objects;
import org.json.JSONObject;

/**
 * Represents timezone information associated with geolocation data.
 */
public class GeolocationTimezone {
  private final String name;
  private final int offset;
  private final String currentTime;
  private final BigDecimal currentTimeUnix;
  private final boolean dst;
  private final int dstSavings;
  private final int offsetWithDst;
  private final JSONObject json;

  /**
   * Constructs a new GeolocationTimezone object with the provided JSON data.
   *
   * @param json The JSON object containing timezone information.
   * @throws IllegalArgumentException If the provided JSON object is null or empty.
   */
  GeolocationTimezone(JSONObject json) {
    if (Objects.isNull(json)) {
      throw new IllegalArgumentException("'json' must not be null");
    }

    if (json.isEmpty()) {
      throw new IllegalArgumentException("'json' must not be empty");
    }

    this.name = json.getString("name");
    this.offset = json.getInt("offset");
    this.currentTime = json.getString("current_time");
    this.currentTimeUnix = json.getBigDecimal("current_time_unix");
    this.dst = json.getBoolean("is_dst");
    this.dstSavings = json.getInt("dst_savings");
    this.offsetWithDst = json.getInt("offset_with_dst");
    this.json = json;
  }

  /**
   * Returns the name of the timezone (ISO 8601).
   *
   * @return The timezone name as a string.
   */
  public String getName() {
    return name;
  }

  /**
   * Returns the offset from UTC in hours.
   *
   * @return The offset from UTC in hours.
   */
  public int getOffset() {
    return offset;
  }

  /**
   * Returns the current time in 'yyyy-MM-dd HH:mm:ss.SSS+ZZZ' format.
   *
   * @return The current time as a string.
   */
  public String getCurrentTime() {
    return currentTime;
  }

  /**
   * Returns the current time in Unix timestamp format (time in seconds since 1970).
   *
   * @return The current time in Unix timestamp format as a BigDecimal.
   */
  public BigDecimal getCurrentTimeUnix() {
    return currentTimeUnix;
  }

  /**
   * Indicates if the timezone is in the daylight saving time (DST).
   *
   * @return {@code true} if DST is in effect, {@code false} otherwise.
   */
  public boolean isDst() {
    return dst;
  }

  /**
   * Returns the total DST savings.
   *
   * @return The total DST savings as int.
   */
  public int getDstSavings() {
    return dstSavings;
  }

  /**
   * Returns the offset from UTC in hours considering DST.
   *
   * @return The offset from UTC in hours considering DST.
   */
  public int getOffsetWithDst() {
    return offsetWithDst;
  }

  /**
   * Returns a JSON representation of the timezone data.
   *
   * @return The JSON representation of the timezone data as a string.
   */
  @Override
  public String toString() {
    return json.toString(2);
  }
}
