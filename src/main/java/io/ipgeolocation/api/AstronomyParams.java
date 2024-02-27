package io.ipgeolocation.api;

import io.ipgeolocation.api.exceptions.IPGeolocationError;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AstronomyParams {
    private final String location;
    private final BigDecimal latitude;
    private final BigDecimal longitude;
    private final String ipAddress;
    private final String date;
    private final String lang;

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

    public String getLocation() {
        return location;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public String getDate() {
        return date;
    }

    public String getLang() {
        return lang;
    }

    public static AstronomyParamsBuilder builder() {
        return new AstronomyParamsBuilder();
    }

    public static class AstronomyParamsBuilder {
        private String location;
        private BigDecimal latitude;
        private BigDecimal longitude;
        private String ipAddress;
        private String date;
        private String lang;
        private AstronomyParamsBuilder() {
            location = "";
            ipAddress = "";
            latitude = null;
            longitude = null;
            lang = "en";
            date = "";
        }

        public AstronomyParamsBuilder withLocation(String location) {
            this.location = location;
            return this;
        }

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

        public AstronomyParamsBuilder withIPAddress(String ipAddress) {
            this.ipAddress = ipAddress;
            return this;
        }

        public AstronomyParamsBuilder withDate(String date) {
            if (Strings.isNullOrEmpty(date) || !isValidDateFormat(date)) {
                throw new IPGeolocationError("'date' must be in YYYY-MM-DD format");
            }
            this.date = date;
            return this;
        }

        public AstronomyParamsBuilder withLang(String lang) {
            this.lang = lang;
            return this;
        }

        public AstronomyParams build() {
            return new AstronomyParams(location, latitude, longitude, ipAddress, date, lang);
        }
    }
    // Method to validate date format
    private static boolean isValidDateFormat(String date) {
        String regex = "\\d{4}-\\d{2}-\\d{2}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(date);
        return matcher.matches();
    }

}
