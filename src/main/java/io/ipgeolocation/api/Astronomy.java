package io.ipgeolocation.api;

import org.json.JSONObject;

import java.math.BigDecimal;
import java.util.Objects;

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

    public String getDate() {
        return date;
    }

    public String getCurrentTime() {
        return currentTime;
    }

    public String getSunrise() {
        return sunrise;
    }

    public String getSunset() {
        return sunset;
    }

    public String getSunStatus() {
        return sunStatus;
    }

    public String getSolarNoon() {
        return solarNoon;
    }

    public String getDayLength() {
        return dayLength;
    }

    public BigDecimal getSunAltitude() {
        return sunAltitude;
    }

    public BigDecimal getSunDistance() {
        return sunDistance;
    }

    public BigDecimal getSunAzimuth() {
        return sunAzimuth;
    }

    public String getMoonrise() {
        return moonrise;
    }

    public String getMoonset() {
        return moonset;
    }

    public String getMoonStatus() {
        return moonStatus;
    }

    public BigDecimal getMoonAltitude() {
        return moonAltitude;
    }

    public BigDecimal getMoonDistance() {
        return moonDistance;
    }

    public BigDecimal getMoonAzimuth() {
        return moonAzimuth;
    }

    public BigDecimal getMoonParallacticAngle() {
        return moonParallacticAngle;
    }

    public AstronomyLocation getLocation() {
        return location;
    }

    @Override
    public String toString() {
        return json.toString(2);
    }
}
