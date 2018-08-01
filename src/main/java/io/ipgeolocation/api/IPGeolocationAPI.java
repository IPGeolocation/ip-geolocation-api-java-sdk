package io.ipgeolocation.api;

import java.io.*;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

//import static com.google.common.base.Strings.isNullOrEmpty;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sun.istack.internal.Nullable;

public class IPGeolocationAPI {
    private String apiKey;

    public IPGeolocationAPI(String apiKey) throws IllegalArgumentException {
        if(Strings.isNullOrEmpty(apiKey)) {
            throw new IllegalArgumentException("API key must not be null or empty");
        } else {
            this.apiKey = apiKey;
        }
    }

    public Timezone getTimezone() {
        Map<String, Object> apiResponse = getTimezoneResponse(null);
        return new Timezone(apiResponse);
    }

    public Timezone getTimezone(TimezoneParams params) {
        Map<String, Object> apiResponse = getTimezoneResponse(params);
        return new Timezone(apiResponse);
    }

    private Map<String, Object> getTimezoneResponse(TimezoneParams params) {
        String urlParams = buildTimezoneUrlParams(params);
        return getApiResponse("timezone", urlParams);
    }

    private String buildTimezoneUrlParams(TimezoneParams params) {
        String urlParams = "apiKey=" + apiKey;

        if(params != null) {
            String param = params.getIp();
            if(!param.equals("")) {
                urlParams = urlParams + "&ip=" + param;
            }

            param = params.getTimezone();
            if(!param.equals("")) {
                urlParams = urlParams + "&tz=" + param;
            }

            Double latitude = params.getLatitude();
            Double longitude = params.getLongitude();
            if(latitude != 1000.0 && longitude != 1000.0) {
                urlParams = urlParams + "&lat=" + latitude + "&long=" + longitude;
            }
        }
        return urlParams;
    }

    public Geolocation getGeolocation() {
        Map<String, Object> apiResponse = getGeolocationResponse(null);
        return new Geolocation(apiResponse);
    }

    public Geolocation getGeolocation(GeolocationParams params) {
        Map<String, Object> apiResponse = getGeolocationResponse(params);
        return new Geolocation(apiResponse);
    }

    private Map<String, Object> getGeolocationResponse(GeolocationParams params) {
        String urlParams = buildGeolocationUrlParams(params);
        return getApiResponse("ipgeo", urlParams);
    }

    private String buildGeolocationUrlParams(GeolocationParams params) {
        String urlParams = "apiKey=" + apiKey;

        if(params != null) {
            String param = params.getIp();
            if(!param.equals("")) {
                urlParams = urlParams + "&ip=" + param;
            }

            param = params.getFields();
            if(!param.equals("")) {
                urlParams = urlParams + "&fields=" + param;
            }
        }
        return urlParams;
    }

    private Map<String, Object> getApiResponse(String api, String params) {
        String url = "https://api.ipgeolocation.io/" + api + "?" + params;
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
            System.out.print(jsonString);
            if(Strings.isNullOrEmpty(jsonString)) {
                jsonString = "{\"message\":\"Incorrect parameters\"}";
            }
        } catch (Exception e) {
            System.err.println("Please check your internet connection:");
            e.printStackTrace();
        }
        return convertStringToMap(responseCode, jsonString);
    }

    public List<Geolocation> getBulkGeolocation(Map<String, Object> ips,  Map<String, Object> params) {
        Gson gson = new Gson();
        List<Map<String, Object>> apiResponse = getBulkApiResponse(gson.toJson(ips), params);
        List<Geolocation> geolocationList = new ArrayList<Geolocation>();
        for(Map<String, Object> response : apiResponse){
            geolocationList.add(new Geolocation(response));
        }
        return geolocationList;
    }

    // Not working
    private List<Map<String, Object>> getBulkApiResponse(String ips, Map<String, Object> params) {
        String query = buildQuery(params);
        String url = "https://api.ipgeolocation.io/ipgeo-bulk" + "?" + query;
        int responseCode = 0;
        String jsonString = null;
        try {
            URL obj = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) obj.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            // Send post request
            connection.setDoOutput(true);
            DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
            wr.writeBytes(ips);
            wr.flush();
            wr.close();
            responseCode = connection.getResponseCode();
            if(responseCode == 200) {
                jsonString = new Scanner(connection.getInputStream()).useDelimiter("\\A").next();
            } else {
                jsonString = new Scanner(connection.getErrorStream()).useDelimiter("\\A").next();
            }
            if(Strings.isNullOrEmpty(jsonString)) {
                jsonString = "[{\"message\":\"Incorrect parameters\"}]";
            }
        } catch (Exception e) {
            System.err.println("Please check your internet connection:");
            e.printStackTrace();
        }
        return convertStringToListMap(responseCode, jsonString);
    }

    private String buildQuery(Map<String, Object> params) {
        String query = "apiKey=" + apiKey;

        if(params != null && params.size() > 0) {
            Set<String> paramNames = params.keySet();
            for(String paramName: paramNames) {
                query = query.concat("&" + paramName + "=" + params.get(paramName));
            }
        }
        return query;
    }

    private Map<String, Object> convertStringToMap(int responseCode, String response){
        Gson gson = new Gson();
        Map<String,Object> map = new HashMap<String,Object>();
        map = (Map<String,Object>) gson.fromJson(response, map.getClass());
        map.put("status", String.valueOf(responseCode));
        System.out.println(map);
        return map;
    }

    private List<Map<String, Object>>  convertStringToListMap(int responseCode, String response) {
        Gson gson = new Gson();
        List<Map<String, Object>> finalResult = new ArrayList<Map<String, Object>>();
        List<Map<String, Object>> result = (List<Map<String, Object>>) gson.fromJson(response, List.class);
        for(Map<String, Object> map: result){
            map.put("status", String.valueOf(responseCode));
            finalResult.add(map);
        }
        return finalResult;
    }

    private Map<String, Object> getBadRequestResponse() {
        Map<String, Object> response = new HashMap<String, Object>();

        response.put("status", "404");
        response.put("message", "Incorrect parameters");
        return response;
    }
}
