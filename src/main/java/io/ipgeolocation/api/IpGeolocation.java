package io.ipgeolocation.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
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
            return openConnection(getIpGeoLocationURL() + subUrl + "?" + query);
        }
        return getBadRequestResponse();
    }

    private String buildQuery(Map<String, String> parameters) {
        String query = "";
        String ip = null;
        String fields = null;
        String tz = null;
        if(parameters != null) {
            ip = parameters.get("ip") != null ? parameters.get("ip") : "";
            fields = parameters.get("fields") != null ? parameters.get("fields") : "";
            tz = parameters.get("tz") != null ? parameters.get("tz") : "";
        }

        if(this.apiKey != null && this.apiKey.trim().length() > 0) {
            query = "apiKey="+this.apiKey;

            if(ip != null && ip.trim().length() > 0) {
                query = query + ("&ip="+ip);
            }

            if(fields != null && fields.trim().length() > 0) {
                query = query + ("&fields="+ fields);
            }

            if(tz != null && tz.trim().length() > 0) {
                query = query + ("&tz="+tz);
            }
        }
        return query;
    }

    private Map<String, String> openConnection(String url) {
        StringBuilder response = new StringBuilder("");
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
        return  getResponse(responseCode, response.toString());
    }

    private Map<String, String> getResponse(int responseCode, String response){
        Gson gson = new Gson();
        Map<String, String> map = new HashMap<String, String>();
        map = (Map<String, String>) gson.fromJson(response, map.getClass());
        map.put("status", String.valueOf(responseCode));
        return map;
    }

    private Map<String, String> getBadRequestResponse() {
        Map<String, String> response = new HashMap<String, String>();
        response.put("status", "404");
        response.put("message", "Incorrect paramater");
        return response;
    }

    private String getIpGeoLocationURL() {
        return "https://api.ipgeolocation.io";
    }
}
