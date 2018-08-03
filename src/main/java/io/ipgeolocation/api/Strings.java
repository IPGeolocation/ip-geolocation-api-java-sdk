package io.ipgeolocation.api;

class Strings {

    static String nullToEmpty(String s) {
        if(s == null) {
            s = "";
        }
        return s;
    }

    static Boolean isNullOrEmpty(String string) {
        return string == null || string.equals("");
    }
}
