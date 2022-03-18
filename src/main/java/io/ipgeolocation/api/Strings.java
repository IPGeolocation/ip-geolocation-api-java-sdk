package io.ipgeolocation.api;

import org.json.JSONException;
import org.json.JSONObject;

class Strings {

    static String nullToEmpty(String s) {
        if (s == null) {
            s = "";
        }
        return s;
    }

    static Boolean isNullOrEmpty(String string) {
        return string == null || string.trim().equals("");
    }

    static Boolean isJsonString(String jsonString) {
        try {
            new JSONObject(jsonString);
            return true;
        } catch (JSONException ex) {
            return false;
        }
    }
}
