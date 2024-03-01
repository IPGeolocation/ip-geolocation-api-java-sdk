package io.ipgeolocation.api;

import io.ipgeolocation.api.exceptions.IPGeolocationError;

import java.math.BigDecimal;

/**
 * The {@code AstronomyParams} class represents parameters used for querying Astronomy
 * information from the IP Geolocation API.
 *
 * <p>The {@code AstronomyParams} class provides methods for setting the IP address, location, date, etc. for
 * retrieving Astronomy information. This class also provides methods for retrieving the IP address, location, languages, etc.
 *
 * <p>It also includes a builder pattern to facilitate the construction of {@code AstronomyParams} objects
 * with various parameters.
 *
 * <p>The class is immutable and thread-safe.</p>
 *
 * <p>Example usage:
 *
 * <pre>{@code
 * AstronomyParams params = AstronomyParams.Builder()
 *     .withLocation("New York")
 *     .withDate("2024-02-28")
 *     .withLang("en")
 *     .build();
 * }
 * </pre>
 * </p>
 */
public class AstronomyParams {
    private final String location;
    private final BigDecimal latitude;
    private final BigDecimal longitude;
    private final String ipAddress;
    private final String date;
    private final String lang;

    /**
     * Constructs an AstronomyParams object with the specified parameters.
     *
     * @param location   The location for which astronomy data is requested.
     * @param latitude   The latitude coordinate of the location.
     * @param longitude  The longitude coordinate of the location.
     * @param ipAddress  The IP address for location-based data retrieval.
     * @param date       The date for which astronomy data is requested.
     * @param lang       The language code for localized data.
     */
    private AstronomyParams(
            String location,
            BigDecimal latitude,
            BigDecimal longitude,
            String ipAddress,
            String date,
            String lang) {
        this.location = location;
        this.latitude = latitude;
        this.longitude = longitude;
        this.ipAddress = ipAddress;
        this.date = date;
        this.lang = lang;
    }

    /**
     * Returns the location for which astronomy data is requested.
     *
     * @return The location as String.
     */
    public String getLocation() {
        return location;
    }

    /**
     * Returns the latitude coordinate of the location.
     *
     * @return The latitude coordinate as BigDecimal.
     */
    public BigDecimal getLatitude() {
        return latitude;
    }

    /**
     * Returns the longitude coordinate of the location.
     *
     * @return The longitude coordinate as BigDecimal.
     */
    public BigDecimal getLongitude() {
        return longitude;
    }

    /**
     * Returns the IP address for location-based data retrieval.
     *
     * @return The IP address.
     */
    public String getIpAddress() {
        return ipAddress;
    }

    /**
     * Returns the date for which astronomy data is requested.
     *
     * @return The date as String.
     */
    public String getDate() {
        return date;
    }

    /**
     * Returns the language code for which astronomy data is requested.
     *
     * @return The language code as String.
     */
    public String getLang() {
        return lang;
    }

    /**
     * Provides a builder for creating instances of {@code AstronomyParams} with specified parameters.
     *
     * @return An instance of {@code AstronomyParamsBuilder}.
     */
    public static AstronomyParamsBuilder builder() {
        return new AstronomyParamsBuilder();
    }

    /**
     * The AstronomyParamsBuilder class facilitates the creation of AstronomyParams instances
     * with specified parameters.
     */
    public static class AstronomyParamsBuilder {
        private String location;
        private BigDecimal latitude;
        private BigDecimal longitude;
        private String ipAddress;
        private String date;
        private String lang;

        /**
         * Constructs a new {@code AstronomyParamsBuilder} with default values for optional parameters.
         */
        private AstronomyParamsBuilder() {
            location = "";
            ipAddress = "";
            latitude = null;
            longitude = null;
            lang = "en";
            date = "";
        }

        /**
         * Sets the location for the astronomy data.
         *
         * @param location The location. (e.g. city, country)
         * @return The updated AstronomyParamsBuilder instance for method chaining.
         */
        public AstronomyParamsBuilder withLocation(String location) {
            this.location = location;
            return this;
        }

        /**
         * Sets the latitude and longitude coordinates for the astronomy data.
         *
         * @param latitude  The latitude coordinate.
         * @param longitude The longitude coordinate.
         * @return The updated AstronomyParamsBuilder instance for method chaining.
         * @throws IPGeolocationError if the latitude or longitude is out of range.
         */
        public AstronomyParamsBuilder withCoordinates(BigDecimal latitude, BigDecimal longitude) {
            if (latitude.compareTo(BigDecimal.valueOf(-90.0)) < 0
                    || latitude.compareTo(BigDecimal.valueOf(90.0)) > 0) {
                throw new IPGeolocationError("'latitude' must be between -90.0 and 90.0");
            }

            if (longitude.compareTo(BigDecimal.valueOf(-180.0)) < 0
                || longitude.compareTo(BigDecimal.valueOf(180.0)) > 0) {
                throw new IPGeolocationError("'longitude' must be between -180.0 and 180.0");
            }

            this.latitude = latitude;
            this.longitude = longitude;
            return this;
        }

        /**
         * Sets the IP address for the astronomy data retrieval.
         *
         * @param ipAddress The IP address.
         * @return The updated AstronomyParamsBuilder instance for method chaining.
         */
        public AstronomyParamsBuilder withIPAddress(String ipAddress) {
            this.ipAddress = ipAddress;
            return this;
        }

        /**
         * Sets the date for which astronomy data is requested.
         *
         * @param date The date in "YYYY-MM-DD" format.
         * @return The updated AstronomyParamsBuilder instance for method chaining.
         * @throws IPGeolocationError if the date format is invalid.
         */
        public AstronomyParamsBuilder withDate(String date) {
            if (Strings.isNullOrEmpty(date) || !Strings.isValidDateFormatForAstronomy(date)) {
                throw new IPGeolocationError("'date' must be in YYYY-MM-DD format");
            }
            this.date = date;
            return this;
        }

        /**
         * Sets the language code for localized data.
         *
         * @param lang The language code.
         * @return The updated AstronomyParamsBuilder instance for method chaining.
         */
        public AstronomyParamsBuilder withLang(String lang) {
            this.lang = lang;
            return this;
        }

        /**
         * Constructs a new {@code AstronomyParams} instance with the provided parameters.
         *
         * @return A new instance of {@code AstronomyParams}.
         */
        public AstronomyParams build() {
            return new AstronomyParams(location, latitude, longitude, ipAddress, date, lang);
        }
    }
}
