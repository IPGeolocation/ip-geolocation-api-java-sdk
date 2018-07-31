package io.ipgeolocation.api;

import java.util.Map;

public class GeolocationTimezone {
    private String name;
    private Double offset;
    private String currentTime;
    private Boolean isDST;
    private Double dstSavings;

    GeolocationTimezone(Map json) {
        this.name = (String) json.get("name");
        this.offset = (Double) json.get("offset");
        this.currentTime = (String) json.get("current_time");
        this.isDST = (Boolean) json.get("is_dst");
        this.dstSavings = (Double) json.get("dst_savings");
    }

    public String getName() {
        return name;
    }

    public Double getOffset() {
        return offset;
    }

    public String getCurrentTime() {
        return currentTime;
    }

    public Boolean isDST() {
        return isDST;
    }

    public Double getDstSavings() {
        return dstSavings;
    }
}
