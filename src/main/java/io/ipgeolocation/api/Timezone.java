package io.ipgeolocation.api;

import com.google.gson.internal.LinkedTreeMap;

import java.util.Map;

public class Timezone {
    private Integer status;
    private String message;
    private String timezone;
    private Double timezoneOffset;
    private String date;
    private String dateTime;
    private String dateTimeTxt;
    private String dateTimeWti;
    private String dateTimeYmd;
    private String time24;
    private String time12;
    private String week;
    private String month;
    private String year;
    private String yearAbbr;
    private Boolean isDst;
    private Double dstSavings;
    private TimezoneGeo timezoneGeo;

    Timezone(Map<String, Object> json) {
        if(!json.get("status").equals("200")) {
            this.message = (String) json.get("message");
        } else {
            this.timezone = (String) json.get("timezone");
            this.timezoneOffset = (Double) json.get("timezone_offset");
            this.date = (String) json.get("date");
            this.dateTime = (String) json.get("date_time");
            this.dateTimeTxt = (String) json.get("date_time_txt");
            this.dateTimeWti = (String) json.get("date_time_wti");
            this.dateTimeYmd = (String) json.get("date_time_ymd");
            this.time24 = (String) json.get("time_24");
            this.time12 = (String) json.get("time_12");
            this.week = (String) json.get("week");
            this.month = (String) json.get("month");
            this.year = (String) json.get("year");
            this.yearAbbr = (String) json.get("year_abbr");
            this.isDst = (Boolean) json.get("is_dst");
            this.dstSavings = (Double) json.get("dst_savings");
            if(json.get("geo") instanceof LinkedTreeMap) {
                Map geoJson = (LinkedTreeMap) json.get("geo");
                this.timezoneGeo = new TimezoneGeo(geoJson);
            }
        }
        this.status = Integer.parseInt((String) json.get("status"));
    }

    public Integer getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public String getTimezone() {
        return timezone;
    }

    public Double getTimezoneOffset() {
        return timezoneOffset;
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

    public String getTime24() {
        return time24;
    }

    public String getTime12() {
        return time12;
    }

    public String getWeek() {
        return week;
    }

    public String getMonth() {
        return month;
    }

    public String getYear() {
        return year;
    }

    public String getYearAbbr() {
        return yearAbbr;
    }

    public Boolean getDst() {
        return isDst;
    }

    public Double getDstSavings() {
        return dstSavings;
    }

    public TimezoneGeo getTimezoneGeo() {
        return timezoneGeo;
    }
}
