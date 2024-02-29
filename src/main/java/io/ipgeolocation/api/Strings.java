package io.ipgeolocation.api;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * The Strings class provides utility methods for string manipulation and validation.
 */
class Strings {

    /**
     * Replaces null strings with an empty string.
     *
     * @param s the input string
     * @return an empty string if the input string is null, otherwise returns the input string
     */
    static String nullToEmpty(String s) {
        if (s == null) {
            s = "";
        }
        return s;
    }

    /**
     * Checks if a string is null or empty.
     *
     * @param string the string to check
     * @return {@code true} if the string is null or empty, {@code false} otherwise
     */
    static Boolean isNullOrEmpty(String string) {
        return string == null || string.trim().equals("");
    }

    /**
     * Checks if a string is a valid JSON string.
     *
     * @param jsonString the string to check
     * @return {@code true} if the string is a valid JSON string, {@code false} otherwise
     */
    static Boolean isJsonString(String jsonString) {
        try {
            new JSONObject(jsonString);
            return true;
        } catch (JSONException ex) {
            return false;
        }
    }
}
