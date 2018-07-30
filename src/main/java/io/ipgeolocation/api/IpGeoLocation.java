package io.ipgeolocation.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import com.google.gson.Gson;

public class IpGeoLocation {
    private String apiKey;

    public IpGeoLocation(String apiKey) {
        this.apiKey = apiKey;
    }

    public Map getTimeZone(Map<String, String> parameters){
        return getIpGeoLocation(parameters, "/timezone");
    }

    public Map getTimeZone(){
        return getIpGeoLocation(null, "/timezone");
    }

    public Map getIpGeo(Map<String, String> parameters){
        return getIpGeoLocation(parameters, "/ipgeo");
    }

    public Map getIpGeo(){
        return getIpGeoLocation(null, "/ipgeo");
    }

    public Map getIpGeoLocation(Map<String, String> parameters, String subUrl){
        String query = buildQuery(parameters);
        if (query != null) {
            return openConnection(getIpGeoLocationURL()+subUrl+"?"+query);
        }
        return getBadRequestResponse();
    }

    public Map<String, String> openConnection(String url){
        StringBuffer response = new StringBuffer();
        int responseCode = 0;
        try {
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("Content-Type", "application/json");
            responseCode = con.getResponseCode();
            BufferedReader in = null;
            if(responseCode == 200){
                in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            }else{
                in = new BufferedReader(new InputStreamReader(con.getErrorStream()));
            }
            String inputLine;

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            if(response.toString().equals("")){
                response.append("{\"message\":\"Incorrect parameters\"}");
            }

            System.out.println(response.toString());
        }catch (IOException e){
            e.printStackTrace();
        }
        return  getResponse(responseCode, response.toString());
    }

    public Map<String, String> getResponse(int responseCode, String response){
        Gson gson = new Gson();
        Map<String,String> map = new HashMap<String,String>();
        map = (Map<String,String>) gson.fromJson(response, map.getClass());
        map.put("status", String.valueOf(responseCode));
        System.out.println(map);
        return map;
    }

    public String buildQuery(Map<String, String> parameters){
        String query = "";
        String ip = null;
        String fields = null;
        String tz = null;
        if(parameters != null){
            ip = parameters.get("ip") != null ? parameters.get("ip") : "";
            fields = parameters.get("fields") !=null ? parameters.get("fields") : "";
            tz = parameters.get("tz") !=null ? parameters.get("tz") : "";
        }

        if(this.apiKey != null && this.apiKey.trim().length()>0){
            query = "apiKey="+this.apiKey;
            if(ip != null && ip.trim().length()>0){
                query = query + ("&ip="+ip);
            }
            if(fields != null && fields.trim().length()>0){
                query = query + ("&fields="+ fields);
            }
            if(tz != null && tz.trim().length()>0){
                query = query + ("&tz="+tz);
            }

        }
        return query;
    }

    public Map getBadRequestResponse(){
        Map<String, String> response = new HashMap<String, String>();
        response.put("status", "404");
        response.put("message", "Incorrect paramater");
        return response;
    }

    public String getIpGeoLocationURL(){
        return "https://api.ipgeolocation.io";
    }
}
