package io.ipgeolocation.api;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import static java.util.Objects.isNull;

public class Timezone {
    private final String timezone;
    private final Integer timezoneOffset;
    private final Integer timezoneOffsetWithDST;
    private final String date;
    private final String dateTime;
    private final String dateTimeTxt;
    private final String dateTimeWti;
    private final String dateTimeYmd;
    private final BigDecimal dateTimeUnix;
    private final String time24;
    private final String time12;
    private final Integer week;
    private final Integer month;
    private final Integer year;
    private final String yearAbbr;
    private final Boolean isDST;
    private final Integer dstSavings;
    private TimezoneGeo timezoneGeo;

    Timezone(Map<String, Object> json) {
        if (isNull(json)) {
            throw new IllegalArgumentException("'json' must not be null.");
        }

        if (json.isEmpty()) {
            throw new IllegalArgumentException("'json' must not be empty.");
        }

        this.timezone = (String) json.get("timezone");
        this.timezoneOffset = (Integer) json.get("timezone_offset");
        this.timezoneOffsetWithDST = (Integer) json.get("timezone_offset_with_dst");
        this.date = (String) json.get("date");
        this.dateTime = (String) json.get("date_time");
        this.dateTimeTxt = (String) json.get("date_time_txt");
        this.dateTimeWti = (String) json.get("date_time_wti");
        this.dateTimeYmd = (String) json.get("date_time_ymd");
        this.dateTimeUnix = (BigDecimal) json.get("date_time_unix");
        this.time24 = (String) json.get("time_24");
        this.time12 = (String) json.get("time_12");
        this.week = (Integer) json.get("week");
        this.month = (Integer) json.get("month");
        this.year = (Integer) json.get("year");
        this.yearAbbr = (String) json.get("year_abbr");
        this.isDST = (Boolean) json.get("is_dst");
        this.dstSavings = (Integer) json.get("dst_savings");
        if (json.get("geo") instanceof HashMap) {
            Map<String, Object> geoJson = (HashMap) json.get("geo");
            this.timezoneGeo = new TimezoneGeo(geoJson);
        }
    }

    public String getTimezone() {
        return timezone;
    }

    public Integer getTimezoneOffset() {
        return timezoneOffset;
    }

    public Integer getTimezoneOffsetWithDST() {
        return timezoneOffsetWithDST;
    }

    public String getDate() {
        return date;
    }

    public String getDateTime() {
        return dateTime;
    }

    public String getDateTimeTxt() {
        return dateTimeTxt;
    }

    public String getDateTimeWti() {
        return dateTimeWti;
    }

    public String getDateTimeYmd() {
        return dateTimeYmd;
    }

    public BigDecimal getDateTimeUnix() {
        return dateTimeUnix;
    }

    public String getTime24() {
        return time24;
    }

    public String getTime12() {
        return time12;
    }

    public Integer getWeek() {
        return week;
    }

    public Integer getMonth() {
        return month;
    }

    public Integer getYear() {
        return year;
    }

    public String getYearAbbr() {
        return yearAbbr;
    }

    public Boolean isDST() {
        return isDST;
    }

    public Integer getDSTSavings() {
        return dstSavings;
    }

    public TimezoneGeo getTimezoneGeo() {
        return timezoneGeo;
    }

}
