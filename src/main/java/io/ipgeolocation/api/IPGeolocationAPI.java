package io.ipgeolocation.api;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

import static io.ipgeolocation.api.Strings.isJsonString;
import static io.ipgeolocation.api.Strings.isNullOrEmpty;

public class IPGeolocationAPI {

    private String apiKey;

    public IPGeolocationAPI(String apiKey) throws IllegalArgumentException {
        if (isNullOrEmpty(apiKey)) {
            throw new IllegalArgumentException("API key must not be null or empty");
        } else {
            this.apiKey = apiKey.trim();
        }
    }

    public String getApiKey() {
        return this.apiKey;
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
        return callAPIEndpoint("ipgeo", urlParams);
    }

    private String buildGeolocationUrlParams(GeolocationParams params) {
        StringBuilder urlParams = new StringBuilder();
        urlParams.append("apiKey=");
        urlParams.append(apiKey);
        if (params != null) {
            if (!isNullOrEmpty(params.getIPAddress())) {
                urlParams.append("&ip=");
                urlParams.append(params.getIPAddress());
            }
            if (!isNullOrEmpty(params.getFields())) {
                urlParams.append("&fields=");
                urlParams.append(params.getFields());
            }
            if (params.isIncludeHostname()) {
                urlParams.append("&include=hostname");
            }
            if (params.isIncludeSecurity()) {
                if (params.isIncludeHostname()) {
                    urlParams.append(",security");
                } else {
                    urlParams.append("&include=security");
                }
            }
            if (params.isIncludeUserAgentDetail()) {
                if (params.isIncludeHostname() || params.isIncludeSecurity()) {
                    urlParams.append(",useragent");
                } else {
                    urlParams.append("&include=useragent");
                }
            }
            if (!isNullOrEmpty(params.getLang())) {
                urlParams.append("&lang=");
                urlParams.append(params.getLang());
            }
            if (!isNullOrEmpty(params.getExcludes())) {
                urlParams.append("&excludes=");
                urlParams.append(params.getExcludes());
            }
        }
        return urlParams.toString();
    }

    public List<Geolocation> getBulkGeolocation(GeolocationParams params) {
        Gson gson = new Gson();
        Map<String, String[]> data = new HashMap<String, String[]>();
        data.put("ips", params.getIPAddresses());
        String urlParams = buildGeolocationUrlParams(params);
        List<Map<String, Object>> apiResponse = callBulkGeolocationAPIEndpoint(gson.toJson(data), urlParams);
        List<Geolocation> geolocations = new ArrayList<Geolocation>();
        for (Map<String, Object> response : apiResponse) {
            geolocations.add(new Geolocation(response));
        }
        return geolocations;
    }

    private List<Map<String, Object>> callBulkGeolocationAPIEndpoint(String ipAddresses, String urlParams) {
        String url = "https://api.ipgeolocation.io/ipgeo-bulk" + "?" + urlParams;
        String responseCode;
        String jsonString;
        try {
            URL obj = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) obj.openConnection();
            connection.setReadTimeout(10000);
            connection.setConnectTimeout(10000);
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Accept", "application/json");
            connection.setDoOutput(true);
            DataOutputStream outputStream = new DataOutputStream(connection.getOutputStream());
            outputStream.writeBytes(ipAddresses);
            outputStream.flush();
            outputStream.close();
            Map<String, String> responseMap = parseConnectionResponse(connection);
            responseCode = responseMap.get("code");
            jsonString = responseMap.get("json");
            if (isNullOrEmpty(responseCode) || isNullOrEmpty(jsonString)) {
                responseCode = "422";
                jsonString = "{\"message\":\"Something went wrong while parsing IP Geolocation API response\"}";
            }
        } catch (IOException e) {
            responseCode = "422";
            jsonString = "{\"message\":\"Something went wrong while connecting to IP Geolocation API\"}";
        } catch (IllegalArgumentException e) {
            responseCode = "422";
            jsonString = "{\"message\":\"Something went wrong while parsing IP Geolocation API response\"}";
        }
        return convertStringToListMap(responseCode, jsonString);
    }

    private List<Map<String, Object>> convertStringToListMap(String responseCode, String response) {
        Gson gson = new Gson();
        List<Map<String, Object>> finalResult = new ArrayList<Map<String, Object>>();
        List<Map<String, Object>> result;
        if (!responseCode.equals("200")) {
            response = "[" + response + "]";
            result = (List<Map<String, Object>>) gson.fromJson(response, List.class);
        } else {
            result = (List<Map<String, Object>>) gson.fromJson(response, List.class);
        }
        for (Map<String, Object> map : result) {
            map.put("status", responseCode);
            finalResult.add(map);
        }
        return finalResult;
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
        return callAPIEndpoint("timezone", urlParams);
    }

    private String buildTimezoneUrlParams(TimezoneParams params) {
        StringBuilder urlParams = new StringBuilder();
        urlParams.append("apiKey=");
        urlParams.append(apiKey);
        if (params != null) {
            if (!isNullOrEmpty(params.getIPAddress())) {
                urlParams.append("&ip=");
                urlParams.append(params.getIPAddress());
            }
            if (!isNullOrEmpty(params.getTimezone())) {
                urlParams.append("&tz=");
                urlParams.append(params.getTimezone());
            }
            Double latitude = params.getLatitude();
            Double longitude = params.getLongitude();
            if ((latitude >= -90 && latitude <= 90) && (longitude >= -180 && longitude <= 180)) {
                urlParams.append("&lat=");
                urlParams.append(latitude);
                urlParams.append("&long=");
                urlParams.append(longitude);
            }
            if (!isNullOrEmpty(params.getLang())) {
                urlParams.append("&lang=");
                urlParams.append(params.getLang());
            }
            if (!isNullOrEmpty(params.getLocation())) {
                urlParams.append("&location=");
                urlParams.append(params.getLocation());
            }
        }
        return urlParams.toString();
    }

    private Map<String, Object> callAPIEndpoint(String endpoint, String urlParams) {
        String url = "https://api.ipgeolocation.io/" + endpoint + "?" + urlParams;
        String responseCode;
        String jsonString;
        try {
            URL obj = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) obj.openConnection();
            connection.setReadTimeout(10000);
            connection.setConnectTimeout(10000);
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept", "application/json");
            Map<String, String> responseMap = parseConnectionResponse(connection);
            responseCode = responseMap.get("code");
            jsonString = responseMap.get("json");
            if (isNullOrEmpty(responseCode) || isNullOrEmpty(jsonString)) {
                responseCode = "422";
                jsonString = "{\"message\":\"Something went wrong while parsing IP Geolocation API response\"}";
            } else if (!isJsonString(jsonString)) {
                responseCode = "422";
                jsonString = "{\"message\":\"Connection problem or Invalid response by IP Geolocation API\"}";
            }
        } catch (IOException e) {
            responseCode = "422";
            jsonString = "{\"message\":\"Something went wrong while connecting to IP Geolocation API\"}";
        } catch (IllegalArgumentException e) {
            responseCode = "422";
            jsonString = "{\"message\":\"Something went wrong while parsing IP Geolocation API response\"}";
        }
        return convertJSONStringToMap(responseCode, jsonString);
    }

    private Map<String, String> parseConnectionResponse(HttpURLConnection connection) {
        if (connection == null) {
            throw new IllegalArgumentException("Pre-condition violated: connection must not be null");
        }
        Map<String, String> responseMap = new HashMap<String, String>();
        try {
            int responseCode = connection.getResponseCode();
            String jsonString = null;
            if (responseCode == 200) {
                jsonString = new Scanner(connection.getInputStream()).useDelimiter("\\A").next();
            } else {
                Scanner scanner = new Scanner(connection.getErrorStream());
                if (scanner.useDelimiter("\\A").hasNextLine()) {
                    jsonString = scanner.useDelimiter("\\A").next();
                }
            }
            if (isNullOrEmpty(jsonString)) {
                responseMap.put("code", String.valueOf(422));
                responseMap.put("json", "{\"message\":\"Incorrect parameters\"}");
            } else {
                responseMap.put("code", String.valueOf(responseCode));
                responseMap.put("json", jsonString);
            }
        } catch (IOException e) {
            System.err.println("Something went wrong while getting response from IP Geolocation API");
            responseMap.put("code", String.valueOf(422));
            responseMap.put("json", "{\"message\":\"Internet is not connected\"}");
        }
        return responseMap;
    }

    private Map<String, Object> convertJSONStringToMap(String responseCode, String response) {
        Gson gson = new Gson();
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        map = (Map<String, Object>) gson.fromJson(response, map.getClass());
        map.put("status", responseCode);
        return map;
    }

    public UserAgent getUserAgent(String uaString) {
        Map<String, Object> apiResponse = new HashMap<>();
        UserAgent userAgent = new UserAgent();
        try {
            uaString = uaString.trim();
            if (uaString.isEmpty()) {
                apiResponse.put("status", 400);
                apiResponse.put("message", "User-Agent string must not be null.");
                userAgent = new UserAgent(apiResponse);
            } else {
                Gson gson = new Gson();
                Map<String, String> data = new HashMap<String, String>();
                data.put("uaString", uaString);
                String urlParams = "https://api.ipgeolocation.io/user-agent?apiKey=" + apiKey;
                apiResponse = callUserAgentAPIEndpoint(gson.toJson(data), urlParams);
                userAgent = new UserAgent(apiResponse);
            }
        } catch (Exception e) {
            apiResponse.put("status", 400);
            apiResponse.put("message", "User-Agent string must not be null.");
            userAgent = new UserAgent(apiResponse);
        }
        return userAgent;
    }

    private Map<String, Object> callUserAgentAPIEndpoint(String jsonBody, String url) {
        int responseCode = 0;
        String jsonString;
        try {
            URL obj = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) obj.openConnection();
            connection.setReadTimeout(10000);
            connection.setConnectTimeout(10000);
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Accept", "application/json");
            connection.setDoOutput(true);
            DataOutputStream outputStream = new DataOutputStream(connection.getOutputStream());
            outputStream.writeBytes(jsonBody);
            outputStream.flush();
            outputStream.close();
            Map<String, String> responseMap = parseConnectionResponse(connection);
            responseCode = Integer.parseInt((String) responseMap.get("code"));
            jsonString = responseMap.get("json");
            if (responseCode == 0 || isNullOrEmpty(jsonString)) {
                responseCode = 422;
                jsonString = "{\"message\":\"Something went wrong while parsing IP Geolocation API response\"}";
            }
        } catch (IOException e) {
            responseCode = 422;
            jsonString = "{\"message\":\"Something went wrong while connecting to IP Geolocation API\"}";
        } catch (IllegalArgumentException e) {
            responseCode = 422;
            jsonString = "{\"message\":\"Something went wrong while parsing IP Geolocation API response\"}";
        }
        return convertUserAgentStringToListMap(responseCode, jsonString);
    }

    private Map<String, Object> convertUserAgentStringToListMap(int responseCode, String response) {
        Map<String, Object> result;
        if (responseCode != 200) {
            response = "{" + response + "}";
            result = new Gson().fromJson(response, new TypeToken<HashMap<String, Object>>() {
            }.getType());
        } else {
            result = new Gson().fromJson(response, new TypeToken<HashMap<String, Object>>() {
            }.getType());
        }
        return result;
    }

    public List<UserAgent> getBulkUserAgent(List<String> uaStrings) {
        List<Map<String, Object>> apiResponses = new ArrayList<>();
        List<UserAgent> userAgents = new ArrayList<>();
        try {
            Gson gson = new Gson();
            Map<String, List<String>> data = new HashMap<>();
            data.put("uaStrings", uaStrings);
            String urlParams = "https://api.ipgeolocation.io/user-agent-bulk?apiKey=" + apiKey;
            apiResponses = callBulkUserAgentAPIEndpoint(gson.toJson(data), urlParams);
            userAgents = new ArrayList<UserAgent>();
            for (Map<String, Object> response : apiResponses) {
                userAgents.add(new UserAgent(response));
            }
            return userAgents;
        } catch (Exception e) {
            Map<String, Object> apiResponse = new HashMap<>();
            apiResponse.put("status", 400);
            apiResponse.put("message", "Something went wrong!.");
            userAgents = new ArrayList<>();
            userAgents.add(new UserAgent(apiResponse));
        }
        return userAgents;
    }

    private List<Map<String, Object>> callBulkUserAgentAPIEndpoint(String jsonBody, String url) {
        int responseCode = 0;
        String jsonString;
        try {
            URL obj = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) obj.openConnection();
            connection.setReadTimeout(10000);
            connection.setConnectTimeout(10000);
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Accept", "application/json");
            connection.setDoOutput(true);
            DataOutputStream outputStream = new DataOutputStream(connection.getOutputStream());
            outputStream.writeBytes(jsonBody);
            outputStream.flush();
            outputStream.close();
            Map<String, String> responseMap = parseConnectionResponse(connection);
            responseCode = Integer.parseInt((String) responseMap.get("code"));
            jsonString = responseMap.get("json");
            if (responseCode == 0 || isNullOrEmpty(jsonString)) {
                responseCode = 422;
                jsonString = "{\"message\":\"Something went wrong while parsing IP Geolocation API response\"}";
            }
        } catch (IOException e) {
            responseCode = 422;
            jsonString = "{\"message\":\"Something went wrong while connecting to IP Geolocation API\"}";
        } catch (IllegalArgumentException e) {
            responseCode = 422;
            jsonString = "{\"message\":\"Something went wrong while parsing IP Geolocation API response\"}";
        }
        return convertBulkUserAgentStringToListMap(responseCode, jsonString);
    }

    private List<Map<String, Object>> convertBulkUserAgentStringToListMap(int responseCode, String response) {
        List<Map<String, Object>> finalResult = new ArrayList<Map<String, Object>>();
        List<Map<String, Object>> result;
        if (responseCode != 200) {
            response = "[" + response + "]";
            result = new Gson().fromJson(response, new TypeToken<HashMap<String, Object>>() {
            }.getType());
        } else {
            result = new Gson().fromJson(response, new TypeToken<HashMap<String, Object>>() {
            }.getType());
        }
        for (Map<String, Object> map : result) {
            map.put("status", responseCode);
            finalResult.add(map);
        }
        return finalResult;
    }

}
