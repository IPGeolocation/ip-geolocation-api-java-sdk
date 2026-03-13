package io.ipgeolocation.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Daylight-saving transition boundary description.
 *
 * @param utcTime transition time in UTC
 * @param duration transition duration
 * @param gap true when local time creates a gap
 * @param dateTimeAfter local time after transition
 * @param dateTimeBefore local time before transition
 * @param overlap true when local time overlaps
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record DstTransition(
    String utcTime,
    String duration,
    Boolean gap,
    String dateTimeAfter,
    String dateTimeBefore,
    Boolean overlap) {}
