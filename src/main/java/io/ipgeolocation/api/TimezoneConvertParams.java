package io.ipgeolocation.api;

import io.ipgeolocation.api.exceptions.IPGeolocationError;

import java.math.BigDecimal;

/**
 * The {@code TimezoneConvertParams} class represents the parameters for timezone conversion, including the source and
 * target timezones, time to convert, geographical coordinates, and location names.
 *
 * <p>The {@code TimezoneConvertParams} class provides methods for setting the timezoneFrom/timezoneTo, dateTime, etc.
 * for retrieving the converted time using IP Geolocation API.
 *
 * <p>IT also includes a builder pattern to facilitate the construction of {@code TimezoneConvertParams} objects
 * with various parameters.
 *
 * <p>The class is immutable and thread-safe.
 *
 * <p>Example usage:
 * <pre>{@code
 * TimezoneConvertParams params =
 *     TimezoneConvertParams.builder()
 *         .setDateTime("2024-02-29 23:25:31")
 *         .withTimezone("America/New_York", "Asia/Tokyo")
 *         .build();
 * TimezoneConvert convertedTime = ipGeolocationAPI.convertTimeZone(params);
 * System.out.println(convertedTime);
 * }
 */
public class TimezoneConvertParams {
    private final String timezoneFrom;
    private final String timezoneTo;
    private final String time;
    private final BigDecimal latitudeFrom;
    private final BigDecimal longitudeFrom;
    private final BigDecimal latitudeTo;
    private final BigDecimal longitudeTo;
    private final String locationFrom;
    private final String locationTo;

    /**
     * Constructs a new TimezoneConvertParams object with the given parameters.
     *
     * @param timezoneFrom The timezone of the source location.
     * @param timezoneTo The timezone of the target location.
     * @param time The time to convert in "YYYY-MM-DD HH:mm:ss" or "YYYY-MM-DD HH:mm" format.
     * @param latitudeFrom The latitude of the source location.
     * @param longitudeFrom The longitude of the source location.
     * @param latitudeTo The latitude of the target location.
     * @param longitudeTo The longitude of the target location.
     * @param locationFrom The name of the source location.
     * @param locationTo The name of the target location.
     */
    private TimezoneConvertParams(
            String timezoneFrom,
            String timezoneTo,
            String time,
            BigDecimal latitudeFrom,
            BigDecimal longitudeFrom,
            BigDecimal latitudeTo,
            BigDecimal longitudeTo,
            String locationFrom,
            String locationTo) {
        this.timezoneFrom = timezoneFrom;
        this.timezoneTo = timezoneTo;
        this.time = time;
        this.latitudeFrom = latitudeFrom;
        this.longitudeFrom = longitudeFrom;
        this.latitudeTo = latitudeTo;
        this.longitudeTo = longitudeTo;
        this.locationFrom = locationFrom;
        this.locationTo = locationTo;
    }

    /**
     * Returns the timezone of the source location for which conversion would be performed.
     *
     * @return The timezone of the source location.
     */
    public String getTimezoneFrom() {
        return timezoneFrom;
    }

    /**
     * Returns the timezone of the target location for which conversion would be performed.
     *
     * @return The timezone of the target location.
     */
    public String getTimezoneTo() {
        return timezoneTo;
    }

    /**
     * Returns the time to convert for which conversion would be performed.
     *
     * @return The time to convert as String.
     */
    public String getTime() {
        return time;
    }

    /**
     * Returns the latitude of the source location for which conversion would be performed..
     *
     * @return The latitude of the source location as BigDecimal.
     */
    public BigDecimal getLatitudeFrom() {
        return latitudeFrom;
    }

    /**
     * Gets the longitude of the source location for which conversion would be performed.
     *
     * @return The longitude of the source location as BigDecimal.
     */
    public BigDecimal getLongitudeFrom() {
        return longitudeFrom;
    }

    /**
     * Gets the latitude of the target location for which conversion would be performed.
     *
     * @return The latitude of the target location as BigDecimal.
     */
    public BigDecimal getLatitudeTo() {
        return latitudeTo;
    }

    /**
     * Gets the longitude of the target location for which conversion would be performed.
     *
     * @return The longitude of the target location as BigDecimal.
     */
    public BigDecimal getLongitudeTo() {
        return longitudeTo;
    }

    /**
     * Gets the name of the source location. (i.e., city, country) for which conversion would be performed.
     *
     * @return The name of the source location as String.
     */
    public String getLocationFrom() {
        return locationFrom;
    }

    /**
     * Gets the name of the target location. (i.e., city, country) for which conversion would be performed.
     *
     * @return The name of the target location as String.
     */
    public String getLocationTo() {
        return locationTo;
    }

    /**
     * Provides a builder for creating instances of {@code TimezoneConvertParams} with specific parameters.
     *
     * @return A new instance of {@code TimezoneConvertParamsBuilder}.
     */
    public static TimezoneConvertParamsBuilder builder() {
        return new TimezoneConvertParamsBuilder();
    }

    /**
     * The {@code TimezoneConvertParamsBuilder} class facilitate the creation of TimezoneConvertParams instances
     * with specified parameters.
     * */
    public static class TimezoneConvertParamsBuilder {
        private String timezoneFrom;
        private String timezoneTo;
        private BigDecimal latitudeFrom;
        private BigDecimal longitudeFrom;
        private BigDecimal latitudeTo;
        private BigDecimal longitudeTo;
        private String locationFrom;
        private String locationTo;
        private String time;

        private TimezoneConvertParamsBuilder() {
            timezoneFrom = "";
            timezoneTo = "";
            time = "";
            latitudeFrom = null;
            longitudeFrom = null;
            latitudeTo = null;
            longitudeTo = null;
            locationFrom = "";
            locationTo = "";
        }

        /**
         * Sets the source and target timezone IDs from <a href="https://en.wikipedia.org/wiki/List_of_tz_database_time_zones">here</a>.
         *
         * @param timezoneFrom The timezone of the source location.
         * @param timezoneTo   The timezone of the target location.
         * @return This TimezoneConvertParamsBuilder instance.
         */
        public TimezoneConvertParamsBuilder withTimeZone(String timezoneFrom, String timezoneTo) {
            this.timezoneFrom = timezoneFrom;
            this.timezoneTo = timezoneTo;
            return this;
        }

        /**
         * Sets the dateTime to convert.
         *
         * @param dateTime The time to convert, in "YYYY-MM-DD HH:mm:ss" or "YYYY-MM-DD HH:mm" format.
         * @return {@code this} TimezoneConvertParamsBuilder instance.
         * @throws IPGeolocationError If the provided time is not in the correct format.
         */
        public TimezoneConvertParamsBuilder withDateTime(String dateTime) {
            if (Strings.isNullOrEmpty(dateTime) || !Strings.isValidDateTimeFormatForConvertTimeZone(dateTime)) {
                throw new IPGeolocationError("'date' must be in \"YYYY-MM-DD HH:mm:ss\" or \"YYYY-MM-DD HH:mm\" format");
            }
            this.time = dateTime;
            return this;
        }

        /**
         * Sets the coordinates of the source and target locations.
         *
         * @param latitudeFrom  The latitude of the source location.
         * @param longitudeFrom The longitude of the source location.
         * @param latitudeTo    The latitude of the target location.
         * @param longitudeTo   The longitude of the target location.
         * @return {@code this} TimezoneConvertParamsBuilder instance.
         * @throws IPGeolocationError If any latitude or longitude is out of range.
         */
        public TimezoneConvertParamsBuilder withCoordinates(
                BigDecimal latitudeFrom, BigDecimal longitudeFrom,
                BigDecimal latitudeTo, BigDecimal longitudeTo) {
            if (latitudeFrom.compareTo(BigDecimal.valueOf(-90.0)) < 0
                    || latitudeFrom.compareTo(BigDecimal.valueOf(90.0)) > 0) {
                throw new IPGeolocationError("'latitudeFrom' must be between -90.0 and 90.0");
            }

            if (longitudeFrom.compareTo(BigDecimal.valueOf(-180.0)) < 0
                    || longitudeFrom.compareTo(BigDecimal.valueOf(180.0)) > 0) {
                throw new IPGeolocationError("'longitudeFrom' must be between -180.0 and 180.0");
            }

            if (latitudeTo.compareTo(BigDecimal.valueOf(-90.0)) < 0
                    || latitudeTo.compareTo(BigDecimal.valueOf(90.0)) > 0) {
                throw new IPGeolocationError("'latitudeTo' must be between -90.0 and 90.0");
            }

            if (longitudeTo.compareTo(BigDecimal.valueOf(-180.0)) < 0
                    || longitudeTo.compareTo(BigDecimal.valueOf(180.0)) > 0) {
                throw new IPGeolocationError("'longitudeTo' must be between -180.0 and 180.0");
            }

            this.latitudeFrom = latitudeFrom;
            this.longitudeFrom = longitudeFrom;
            this.latitudeTo = latitudeTo;
            this.longitudeTo = longitudeTo;
            return this;
        }

        /**
         * Sets the names of the source and target locations. (i.e., city, country).
         *
         * @param locationFrom The name of the source location.
         * @param locationTo   The name of the target location.
         * @return This TimezoneConvertParamsBuilder instance.
         */
        public TimezoneConvertParamsBuilder withLocation(String locationFrom, String locationTo) {
            this.locationFrom = locationFrom;
            this.locationTo = locationTo;
            return this;
        }

        /**
         * Builds a new {@code TimezoneConvertParams} object using the builder parameters.
         *
         * @return A new instance of {@code TimezoneConvertParams}.
         */
        public TimezoneConvertParams build() {
            return new TimezoneConvertParams(
                    timezoneFrom,
                    timezoneTo,
                    time,
                    latitudeFrom,
                    longitudeFrom,
                    latitudeTo,
                    longitudeTo,
                    locationFrom,
                    locationTo);
        }
    }
}
