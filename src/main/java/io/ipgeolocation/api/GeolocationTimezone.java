package io.ipgeolocation.api;

import java.math.BigDecimal;
import java.util.Map;

public class GeolocationTimezone {
    private final String name;
    private final Integer offset;
    private final String currentTime;
    private final BigDecimal currentTimeUnix;
    private final Boolean isDST;
    private final Integer dstSavings;

    GeolocationTimezone(Map<String, Object> json) {
        this.name = (String) json.get("name");
        this.offset = (Integer) json.get("offset");
        this.currentTime = (String) json.get("current_time");
        this.currentTimeUnix = (BigDecimal) json.get("current_time_unix");
        this.isDST = (Boolean) json.get("is_dst");
        this.dstSavings = (Integer) json.get("dst_savings");
    }

    public String getName() {
        return name;
    }

    public Integer getOffset() {
        return offset;
    }

    public String getCurrentTime() {
        return currentTime;
    }

    public BigDecimal getCurrentTimeUnix() {
        return currentTimeUnix;
    }

    public Boolean isDST() {
        return isDST;
    }

    public Integer getDSTSavings() {
        return dstSavings;
    }

}
