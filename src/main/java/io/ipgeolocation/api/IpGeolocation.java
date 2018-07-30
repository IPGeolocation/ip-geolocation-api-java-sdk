package io.ipgeolocation.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.google.gson.Gson;

public class IpGeolocation {
    private String apiKey;

    public IpGeolocation(String apiKey) {
        this.apiKey = apiKey;
    }

    public Map<String, String> getTimezone() {
        return getApiResponse("/timezone", null);
    }

    public Map<String, String> getTimezone(Map<String, String> parameters) {
        return getApiResponse("/timezone", parameters);
    }

    public Map<String, String> getIpgeo() {
        return getApiResponse("/ipgeo", null);
    }

    public Map<String, String> getIpgeo(Map<String, String> parameters) {
        return getApiResponse("/ipgeo", parameters);
    }

    private Map<String, String> getApiResponse(String subUrl, Map<String, String> parameters) {
        String query = buildQuery(parameters);
        if(query != null) {
            return openConnection("https://api.ipgeolocation.io" + subUrl + "?" + query);
        }
        return getBadRequestResponse();
    }

    private String buildQuery(Map<String, String> params) {
        String query = "";

        if(this.apiKey != null && this.apiKey.trim().length() > 0) {
            query = "apiKey=" + this.apiKey;
        }

        if(params != null && params.size() > 0) {
            Set<String> paramNames = params.keySet();

            for(String paramName: paramNames) {
                query = query.concat("&" + paramName + "=" + params.get(paramName));
            }
        }
        return query;
    }

    private Map<String, String> openConnection(String url) {
        StringBuilder response = new StringBuilder();
        int responseCode = 0;
        try {
            URL obj = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) obj.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-Type", "application/json");
            responseCode = connection.getResponseCode();
            BufferedReader reader;

            if(responseCode == 200) {
                reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            } else {
                reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
            }

            String inputLine;
            while ((inputLine = reader.readLine()) != null) {
                response.append(inputLine);
            }
            reader.close();

            if(response.toString().equals("")) {
                response.append("{\"message\":\"Incorrect parameters\"}");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return getResponse(responseCode, response.toString());
    }

    private Map<String, String> getResponse(int responseCode, String response) {
        Gson gson = new Gson();
        Map<String, String> map = new HashMap<String, String>();
        map = (Map<String, String>) gson.fromJson(response, map.getClass());
        map.put("status", String.valueOf(responseCode));
        return map;
    }

    private Map<String, String> getBadRequestResponse() {
        Map<String, String> response = new HashMap<String, String>();
        response.put("status", "404");
        response.put("message", "Incorrect parameters");
        return response;
    }
}
