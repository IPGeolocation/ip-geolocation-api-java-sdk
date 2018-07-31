package io.ipgeolocation.api;

public class GeolocationTimezone {
    private String name;
    private Double offset;
    private String currentTime;
    private Boolean isDST;
    private Double dstSavings;

    GeolocationTimezone(String name, Double offset, String currentTime, Boolean isDST, Double dstSavings) {
        this.name = name;
        this.offset = offset;
        this.currentTime = currentTime;
        this.isDST = isDST;
        this.dstSavings = dstSavings;
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
