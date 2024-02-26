package io.ipgeolocation.api;

import java.math.BigDecimal;
import java.util.Objects;
import org.json.JSONObject;

public class GeolocationTimezone {
  private final String name;
  private final int offset;
  private final String currentTime;
  private final BigDecimal currentTimeUnix;
  private final boolean dst;
  private final int dstSavings;
  private final int offsetWithDst;
  private final JSONObject json;

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

  public String getName() {
    return name;
  }

  public int getOffset() {
    return offset;
  }

  public String getCurrentTime() {
    return currentTime;
  }

  public BigDecimal getCurrentTimeUnix() {
    return currentTimeUnix;
  }

  public boolean isDst() {
    return dst;
  }

  public int getDstSavings() {
    return dstSavings;
  }

  public int getOffsetWithDst() {
    return offsetWithDst;
  }

  @Override
  public String toString() {
    return json.toString(2);
  }
}
