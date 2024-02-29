package io.ipgeolocation.api;

import org.json.JSONObject;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * The Astronomy class represents astronomical data for a specific date and location, including information
 * about sunrise, sunset, moonrise, moonset, sun and moon positions, and other related details.
 *
 * <p>The Astronomy class provides methods to access the information stored in the {@code Astronomy} object,
 * For Example, you can get the sunrise time by calling {@link Astronomy#getSunrise()}.
 */
public class Astronomy {
    private final String date;
    private final String currentTime;
    private final String sunrise;
    private final String sunset;
    private final String sunStatus;
    private final String solarNoon;
    private final String dayLength;
    private final BigDecimal sunAltitude;
    private final BigDecimal sunDistance;
    private final BigDecimal sunAzimuth;
    private final String moonrise;
    private final String moonset;
    private final String moonStatus;
    private final BigDecimal moonAltitude;
    private final BigDecimal moonDistance;
    private final BigDecimal moonAzimuth;
    private final BigDecimal moonParallacticAngle;
    private AstronomyLocation location;
    private final JSONObject json;

    /**
     * Constructs an Astronomy object based on the provided JSON data.
     *
     * @param json the JSON object containing astronomical data
     * @throws IllegalArgumentException if the provided JSON object is null or empty
     */
    Astronomy(JSONObject json) {
        if (Objects.isNull(json)) {
            throw new IllegalArgumentException("'json' must not be null");
        }

        if (json.isEmpty()) {
            throw new IllegalArgumentException("'json' must not be empty");
        }

        this.date = json.getString("date");
        this.currentTime = json.getString("current_time");
        this.sunrise = json.getString("sunrise");
        this.sunset = json.getString("sunset");
        this.sunStatus = json.getString("sun_status");
        this.solarNoon = json.getString("solar_noon");
        this.dayLength = json.getString("day_length");
        this.sunAltitude = json.getBigDecimal("sun_altitude");
        this.sunDistance = json.getBigDecimal("sun_distance");
        this.sunAzimuth = json.getBigDecimal("sun_azimuth");
        this.moonrise = json.getString("moonrise");
        this.moonset = json.getString("moonset");
        this.moonStatus = json.getString("moon_status");
        this.moonAltitude = json.getBigDecimal("moon_altitude");
        this.moonDistance = json.getBigDecimal("moon_distance");
        this.moonAzimuth = json.getBigDecimal("moon_azimuth");
        this.moonParallacticAngle = json.getBigDecimal("moon_parallactic_angle");

        if (json.has("location")) {
            this.location = new AstronomyLocation(json.getJSONObject("location"));
        }
        this.json = json;
    }

    /**
     * Returns the date for which astronomical data is provided.
     *
     * @return The date as String.
     */
    public String getDate() {
        return date;
    }

    /**
     * Returns the current time at the location in the format "HH:mm:ss".
     *
     * @return The current time as String.
     */
    public String getCurrentTime() {
        return currentTime;
    }

    /**
     * Returns the time of sunrise in the format "HH:mm".
     *
     * @return The time of sunrise as String.
     */
    public String getSunrise() {
        return sunrise;
    }

    /**
     * Returns the time of sunset in the format "HH:mm".
     *
     * @return The time of sunset as String.
     */
    public String getSunset() {
        return sunset;
    }

    /**
     * Returns the status of sunrise and sunset as "-", if these values are not available.
     *
     * @return The status of the sun.
     */
    public String getSunStatus() {
        return sunStatus;
    }

    /**
     * Returns the time of solar noon in the format "HH:mm".
     *
     * @return The time of solar noon as String.
     */
    public String getSolarNoon() {
        return solarNoon;
    }

    /**
     * Returns the duration of daylight in the format "HH:mm".
     *
     * @return The duration of daylight.
     */
    public String getDayLength() {
        return dayLength;
    }

    /**
     * Returns the altitude of the sun.
     *
     * @return The altitude of the sun in degrees.
     */
    public BigDecimal getSunAltitude() {
        return sunAltitude;
    }

    /**
     * Returns the distance to the sun.
     *
     * @return The distance to the sun in km.
     */
    public BigDecimal getSunDistance() {
        return sunDistance;
    }

    /**
     * Returns the azimuth of the sun.
     *
     * @return The azimuth of the sun in degrees.
     */
    public BigDecimal getSunAzimuth() {
        return sunAzimuth;
    }

    /**
     * Returns the time of moonrise in the format "HH:mm".
     *
     * @return The time of moonrise.
     */
    public String getMoonrise() {
        return moonrise;
    }

    /**
     * Returns the time of moonset in the format "HH:mm".
     *
     * @return The time of moonset.
     */
    public String getMoonset() {
        return moonset;
    }

    /**
     * Returns the status of moon rise and moon set as "-", if these values are not available.
     *
     * @return The status of the moon.
     */
    public String getMoonStatus() {
        return moonStatus;
    }

    /**
     * Returns the altitude of the moon.
     *
     * @return The altitude of the moon in degrees.
     */
    public BigDecimal getMoonAltitude() {
        return moonAltitude;
    }

    /**
     * Returns the distance to the moon.
     *
     * @return The distance to the moon in km.
     */
    public BigDecimal getMoonDistance() {
        return moonDistance;
    }

    /**
     * Returns the azimuth of the moon.
     *
     * @return The azimuth of the moon in degrees.
     */
    public BigDecimal getMoonAzimuth() {
        return moonAzimuth;
    }

    /**
     * Returns the parallactic angle of the moon.
     *
     * @return The parallactic angle of the moon in degrees.
     */
    public BigDecimal getMoonParallacticAngle() {
        return moonParallacticAngle;
    }

    /**
     * Returns the location associated with the astronomical data.
     *
     * @return The {@code AstronomyLocation} object.
     */
    public AstronomyLocation getLocation() {
        return location;
    }

    /**
     * Returns a string representation of the Astronomy object, in JSON format.
     *
     * @return A JSON string representing the astronomical data.
     */
    @Override
    public String toString() {
        return json.toString(2);
    }
}
