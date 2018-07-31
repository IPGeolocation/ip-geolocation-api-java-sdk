package io.ipgeolocation.api;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import static com.google.common.base.Strings.isNullOrEmpty;
import com.google.gson.Gson;

public class IPGeolocationAPI {
    private String apiKey;

    public IPGeolocationAPI(String apiKey) throws IllegalArgumentException {
        if(isNullOrEmpty(apiKey)) {
            throw new IllegalArgumentException("API key must not be null or empty");
        } else {
            this.apiKey = apiKey;
        }
    }

    public Timezone getTimezone() {
        Map<String, Object> apiResponse = getApiResponse("timezone", null);
        return new Timezone(apiResponse);
    }

    public Timezone getTimezone(Map<String, String> params) {
        Map<String, Object> apiResponse = getApiResponse("timezone", params);
        return new Timezone(apiResponse);
    }

    public Geolocation getGeolocation() {
        Map<String, Object> apiResponse = getApiResponse("ipgeo", null);
        return new Geolocation(apiResponse);
    }

    public Geolocation getGeolocation(Map<String, String> params) {
        Map<String, Object> apiResponse = getApiResponse("ipgeo", params);
        return new Geolocation(apiResponse);
    }

    private Map<String, Object> getApiResponse(String api, Map<String, String> params) {
        String query = buildQuery(params);
        String url = "https://api.ipgeolocation.io/" + api + "?" + query;
        int responseCode = 0;
        String jsonString = null;
        try {
            URL obj = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) obj.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-Type", "application/json");
            responseCode = connection.getResponseCode();

            if(responseCode == 200) {
                jsonString = new Scanner(connection.getInputStream()).useDelimiter("\\A").next();
            } else {
                jsonString = new Scanner(connection.getErrorStream()).useDelimiter("\\A").next();
            }

            if(isNullOrEmpty(jsonString)) {
                jsonString = "{\"status\":\"403\",\"message\":\"Incorrect parameters\"}";
            }
        } catch (Exception e) {
            System.err.println("Please check your internet connection:");
            e.printStackTrace();
        }
        return convertStringToMap(responseCode, jsonString);
    }

    public Geolocation getBulkGeolocation(String[] ips) {
//        Map<String, Object> apiResponse = getBulkApiResponse([""], null);
//        return new Geolocation(apiResponse);
        return null;
    }

    public Geolocation getBulkGeolocation(String[] ips, Map<String, String> params) {
//        Map<String, Object> apiResponse = getBulkApiResponse([""], params);
//        return new Geolocation(apiResponse);
        return null;
    }

    // Not working
    private Map<String, Object> getBulkApiResponse(String[] ips, Map<String, String> params) {
        String query = buildQuery(params);
        String url = "https://api.ipgeolocation.io/ipgeo-bulk" + "?" + query;
        int responseCode = 0;
        String jsonString = null;
        try {
            URL obj = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) obj.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");

            responseCode = connection.getResponseCode();

            if(responseCode == 200) {
                jsonString = new Scanner(connection.getInputStream()).useDelimiter("\\A").next();
            } else {
                jsonString = new Scanner(connection.getErrorStream()).useDelimiter("\\A").next();
            }

            if(isNullOrEmpty(jsonString)) {
                jsonString = "{\"status\":\"403\",\"message\":\"Incorrect parameters\"}";
            }
        } catch (Exception e) {
            System.err.println("Please check your internet connection:");
            e.printStackTrace();
        }
        return convertStringToMap(responseCode, jsonString);
    }

    private String buildQuery(Map<String, String> params) {
        String query = "apiKey=" + apiKey;

        if(params != null && params.size() > 0) {
            Set<String> paramNames = params.keySet();
            for(String paramName: paramNames) {
                query = query.concat("&" + paramName + "=" + params.get(paramName));
            }
        }
        return query;
    }

    private Map<String, Object> convertStringToMap(int responseCode, String response) {
        Gson gson = new Gson();
        Map<String, Object> map = new HashMap<String, Object>();

        map = (HashMap<String, Object>) gson.fromJson(response, map.getClass());
        map.put("status", String.valueOf(responseCode));
        return map;
    }

    private Map<String, Object> getBadRequestResponse() {
        Map<String, Object> response = new HashMap<String, Object>();

        response.put("status", "404");
        response.put("message", "Incorrect parameters");
        return response;
    }
}
