package io.ipgeolocation.api;

import org.json.JSONObject;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * The TimezoneConvert class represents the result of a timezone conversion, including the original time, converted time,
 * and the difference in hours and minutes between the two timezones.
 *
 * <p>The TimezoneConvert class provides methods to access the information stored in the TimezoneConvert object.
 * For example, you can use the {@link #getConvertedTime()} method to get the converted time.
 */
public class TimezoneConvert {
    private final String originalTime;
    private final String convertedTime;
    private final BigDecimal diffHour;
    private final BigDecimal diffMin;
    private final JSONObject json;

    /**
     * Constructs a new TimezoneConvert object with the given JSON data.
     *
     * @param json The JSON object containing the timezone conversion information.
     * @throws IllegalArgumentException If the provided JSON object is null or empty.
     */
    TimezoneConvert(JSONObject json) {
        if (Objects.isNull(json)) {
            throw new IllegalArgumentException("'json' must not be null");
        }

        if (json.isEmpty()) {
            throw new IllegalArgumentException("'json' must not be empty");
        }

        this.originalTime = json.optString("original_time");
        this.convertedTime = json.optString("converted_time");
        this.diffHour = json.getBigDecimal("diff_hour");
        this.diffMin = json.getBigDecimal("diff_min");

        this.json = json;
    }

    /**
     * Returns the DateTime for which conversion is performed, if the time is not provided,
     * the time of request will return.
     *
     * @return Queried time or request time as a string.
     */
    public String getOriginalTime() {
        return originalTime;
    }

    /**
     * Returns the dateTime after conversion to the target timezone/location.
     *
     * @return The converted dateTime as a string.
     */
    public String getConvertedTime() {
        return convertedTime;
    }

    /**
     * Gets the difference in hours between the original and converted timezones.
     *
     * @return The difference in hours as a {@code BigDecimal}.
     */
    public BigDecimal getDiffHour() {
        return diffHour;
    }

    /**
     * Gets the difference in minutes between the original and converted timezones.
     *
     * @return The difference in minutes as a {@code BigDecimal}.
     */
    public BigDecimal getDiffMin() {
        return diffMin;
    }

    /**
     * Returns a string representation of the TimezoneConvert object, formatted JSON.
     *
     * @return A string containing the JSON representation of the timezone conversion result.
     */
    @Override
    public String toString() {
        return json.toString(2);
    }
}
