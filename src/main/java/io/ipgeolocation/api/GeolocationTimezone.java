package io.ipgeolocation.api;

import java.util.Map;

public class GeolocationTimezone {
    private final String name;
    private final Double offset;
    private final String currentTime;
    private final Double currentTimeUnix;
    private final Boolean isDST;
    private final Double dstSavings;

    GeolocationTimezone(Map<String, Object> json) {
        this.name = (String) json.get("name");
        this.offset = (Double) json.get("offset");
        this.currentTime = (String) json.get("current_time");
        this.currentTimeUnix = (Double) json.get("current_time_unix");
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

    public Double getCurrentTimeUnix() {
        return currentTimeUnix;
    }

    public Boolean isDST() {
        return isDST;
    }

    public Double getDSTSavings() {
        return dstSavings;
    }

}
