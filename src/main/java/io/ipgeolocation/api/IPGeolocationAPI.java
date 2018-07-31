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

    public IPGeolocationAPI(String apiKey) {
        this.apiKey = apiKey;
    }

    public Map<String, Object> getTimezone() {
        return getApiResponse("/timezone", null);
    }

    public Map<String, Object> getTimezone(Map<String, String> parameters) {
        return getApiResponse("/timezone", parameters);
    }

    public Geolocation getGeolocation() {
        Map<String, Object> apiResponse = getApiResponse("/ipgeo", null);
        return new Geolocation(apiResponse);
    }

    public Geolocation getGeolocation(Map<String, String> parameters) {
        Map<String, Object> apiResponse = getApiResponse("/ipgeo", parameters);
        return new Geolocation(apiResponse);
    }

    private Map<String, Object> getApiResponse(String subUrl, Map<String, String> params) {
        String query = buildQuery(params);
        if(query != null) {
            return openConnection("https://api.ipgeolocation.io" + subUrl + "?" + query);
        }
        return getBadRequestResponse();
    }

    private String buildQuery(Map<String, String> params) {
        String query = "";

        if(!isNullOrEmpty(apiKey)) {
            query = "apiKey=" + apiKey;
        }

        if(params != null && params.size() > 0) {
            Set<String> paramNames = params.keySet();
            for(String paramName: paramNames) {
                query = query.concat("&" + paramName + "=" + params.get(paramName));
            }
        }
        return query;
    }

    private Map<String, Object> openConnection(String url) {
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
