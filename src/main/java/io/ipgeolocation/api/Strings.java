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

    /**
     * Validates a date and time string in the format "YYYY-MM-DD HH:mm:ss" or "YYYY-MM-DD HH:mm".
     *
     * @param dateTimeStr The date and time string to validate.
     * @return {@code true} if the input string matches the specified formats and represents a valid date and time,
     *         {@code false} otherwise.
     */
    public static boolean isValidDateTimeFormatForConvertTimeZone(String dateTimeStr) {
        // Regular expression to match the format YYYY-MM-DD HH:mm:ss or YYYY-MM-DD HH:mm
        String dateTimeRegex = "\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}(:\\d{2})?";

        if (dateTimeStr.matches(dateTimeRegex)) {
            String[] parts = dateTimeStr.split(" ");
            String datePart = parts[0];
            String timePart = parts[1];

            String[] dateParts = datePart.split("-");
            String[] timeParts = timePart.split(":");

            // Check if all parts are valid integers
            for (String part : dateParts) {
                try {
                    Integer.parseInt(part);
                } catch (NumberFormatException e) {
                    return false;
                }
            }
            for (String part : timeParts) {
                try {
                    Integer.parseInt(part);
                } catch (NumberFormatException e) {
                    return false;
                }
            }

            // Check if the date and time parts are within valid ranges
            int year = Integer.parseInt(dateParts[0]);
            int month = Integer.parseInt(dateParts[1]);
            int day = Integer.parseInt(dateParts[2]);
            int hour = Integer.parseInt(timeParts[0]);
            int minute = Integer.parseInt(timeParts[1]);
            int second = timeParts.length == 3 ? Integer.parseInt(timeParts[2]) : 0;

            // Basic validation for year, month, and day
            if (year < 0 || month < 1 || month > 12 || day < 1 || day > 31 ||
                    hour < 0 || hour > 23 || minute < 0 || minute > 59 || second < 0 || second > 59) {
                return false;
            }

            // Additional validation for month and day
            if ((month == 4 || month == 6 || month == 9 || month == 11) && day > 30) {
                return false;
            }
            if (month == 2) {
                if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) {
                    return day <= 29;
                } else {
                    return day <= 28;
                }
            }

            return true;
        }
        return false;
    }

    /**
     * Validates a date string in the format "YYYY-MM-DD".
     *
     * @param dateStr The date string to validate.
     * @return {@code true} if the input string matches the specified format and represents a valid date,
     *         {@code false} otherwise.
     */
    public static boolean isValidDateFormatForAstronomy(String dateStr) {
        // Regular expression to match the format YYYY-MM-DD
        String dateRegex = "\\d{4}-\\d{2}-\\d{2}";

        if (dateStr.matches(dateRegex)) {
            String[] dateParts = dateStr.split("-");

            // Check if all parts are valid integers
            for (String part : dateParts) {
                try {
                    Integer.parseInt(part);
                } catch (NumberFormatException e) {
                    return false;
                }
            }

            // Check if the date parts are within valid ranges
            int year = Integer.parseInt(dateParts[0]);
            int month = Integer.parseInt(dateParts[1]);
            int day = Integer.parseInt(dateParts[2]);

            // Basic validation for year, month, and day
            if (year < 0 || month < 1 || month > 12 || day < 1 || day > 31) {
                return false;
            }

            // Additional validation for month and day
            if ((month == 4 || month == 6 || month == 9 || month == 11) && day > 30) {
                return false;
            }
            if (month == 2) {
                if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) {
                    if (day > 29) {
                        return false;
                    }
                } else {
                    if (day > 28) {
                        return false;
                    }
                }
            }

            return true;
        }
        return false;
    }
}
