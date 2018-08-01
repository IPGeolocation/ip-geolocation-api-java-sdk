package io.ipgeolocation.api;

public class Strings {

    public static String nullToEmpty(String s) {
        if(s == null) {
            s = "";
        }
        return s;
    }
}
