package io.ipgeolocation.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Time-zone and daylight-saving details for the resolved location.
 *
 * @param name IANA time-zone name
 * @param offset UTC offset in hours
 * @param offsetWithDst UTC offset with DST in hours
 * @param currentTime current local date-time string
 * @param currentTimeUnix current local time in unix seconds
 * @param currentTzAbbreviation current timezone abbreviation
 * @param currentTzFullName current timezone full name
 * @param standardTzAbbreviation standard timezone abbreviation
 * @param standardTzFullName standard timezone full name
 * @param isDst true when daylight-saving is active
 * @param dstSavings daylight-saving offset in hours
 * @param dstExists true when zone uses daylight-saving
 * @param dstTzAbbreviation daylight-saving timezone abbreviation
 * @param dstTzFullName daylight-saving timezone full name
 * @param dstStart daylight-saving start transition
 * @param dstEnd daylight-saving end transition
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record TimeZoneInfo(
    String name,
    Double offset,
    Double offsetWithDst,
    String currentTime,
    Double currentTimeUnix,
    String currentTzAbbreviation,
    String currentTzFullName,
    String standardTzAbbreviation,
    String standardTzFullName,
    @JsonProperty("is_dst") Boolean isDst,
    Double dstSavings,
    Boolean dstExists,
    String dstTzAbbreviation,
    String dstTzFullName,
    DstTransition dstStart,
    DstTransition dstEnd) {}
