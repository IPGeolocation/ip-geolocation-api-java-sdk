package io.ipgeolocation.api;

public class GeolocationBulkParams {
    private String fields;

    public GeolocationBulkParams() {
        this.fields = "";
    }

    public void setFields(String fields) {
        this.fields = Strings.nullToEmpty(fields);
    }

    public String getFields() {
        return fields;
    }
}
