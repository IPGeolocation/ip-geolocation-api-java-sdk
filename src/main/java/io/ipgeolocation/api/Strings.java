package io.ipgeolocation.api;

import com.google.gson.Gson;

class Strings {

    static String nullToEmpty(String s) {
        if(s == null) {
            s = "";
        }
        return s;
    }

    static Boolean isNullOrEmpty(String string) {
        return string == null || string.trim().equals("");
    }

    static Boolean isJsonString(String jsonString) {
        Gson gson = new Gson();
        try {
            Object jsonObjType = gson.fromJson(jsonString, Object.class).getClass();
            if(jsonObjType.equals(String.class)){
                return false;
            }
            return true;
        } catch (com.google.gson.JsonSyntaxException ex) {
            return false;
        }
    }
}
