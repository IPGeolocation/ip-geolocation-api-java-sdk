package io.ipgeolocation.api;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;
import java.util.stream.Collectors;

import static io.ipgeolocation.api.Strings.*;
import static java.util.Objects.isNull;

public class IPGeolocationAPI {
    private final String apiKey;

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

    public Map<String, Object> getGeolocation() {
        Map<String, Object> apiResponse = callAPIEndpoint("ipgeo", "apiKey=" + apiKey, "GET", Optional.empty());

        return prepareResponseForUser(apiResponse, "geolocation");
    }

    public Map<String, Object> getGeolocation(GeolocationParams params) {
        Map<String, Object> apiResponse = callAPIEndpoint("ipgeo", buildGeolocationUrlParams(params), "GET", Optional.empty());

        return prepareResponseForUser(apiResponse, "geolocation");
    }

    public Map<String, Object> getBulkGeolocation(GeolocationParams params) {
        String url = "https://api.ipgeolocation.io/ipgeo-bulk" + "?" + buildGeolocationUrlParams(params);
        List<Map<String, Object>> apiResponseList = callBulkAPIEndpoint(url, Optional.of(new JSONObject().put("ips", params.getIPAddresses())));

        return prepareBulkResponseForUser(apiResponseList, "geolocation");
    }

    public Map<String, Object> getTimezone() {
        Map<String, Object> apiResponse = callAPIEndpoint("timezone", "apiKey=" + apiKey, "GET", Optional.empty());

        return prepareResponseForUser(apiResponse, "timezone");
    }

    public Map<String, Object> getTimezone(TimezoneParams params) {
        Map<String, Object> apiResponse = callAPIEndpoint("timezone", buildTimezoneUrlParams(params), "GET", Optional.empty());

        return prepareResponseForUser(apiResponse, "timezone");
    }

    public Map<String, Object> getUserAgent(String uaString) {
        Map<String, Object> apiResponse = new HashMap<>();

        uaString = uaString.trim();

        if (isNullOrEmpty(uaString)) {
            apiResponse.put("status", 400);
            apiResponse.put("message", "User-Agent string must not be empty.");
        } else {
            apiResponse = callAPIEndpoint("user-agent", "apiKey=" + apiKey, "POST", Optional.of(new JSONObject().put("uaString", uaString)));
        }

        return prepareResponseForUser(apiResponse, "useragent");
    }

    public Map<String, Object> getBulkUserAgent(List<String> uaStrings) {
        String url = "https://api.ipgeolocation.io/user-agent-bulk?apiKey=" + apiKey;
        List<Map<String, Object>> apiResponseList = callBulkAPIEndpoint(url, Optional.of(new JSONObject().put("uaStrings", uaStrings)));

        return prepareBulkResponseForUser(apiResponseList, "useragent");
    }

    private Map<String, Object> prepareResponseForUser(Map<String, Object> apiResponse, String type) {
        Integer httpStatus = (Integer) apiResponse.get("status");
        String errorMessage = (String) apiResponse.get("message");
        Map<String, Object> response = new HashMap<>();

        response.put("status", httpStatus);
        response.put("message", nullToEmpty(errorMessage));

        if (httpStatus == 200 && type.equals("geolocation")) {
            response.put("response", new Geolocation(apiResponse));
        } else if (httpStatus == 200 && type.equals("timezone")) {
            response.put("response", new Timezone(apiResponse));
        } else if (httpStatus == 200 && type.equals("useragent")) {
            response.put("response", new UserAgent(apiResponse));
        }

        return response;
    }

    private Map<String, Object> prepareBulkResponseForUser(List<Map<String, Object>> apiResponseList, String type) {
        Map<String, Object> firstApiResponse = apiResponseList.get(0);
        Integer httpStatus = (Integer) firstApiResponse.get("status");
        String errorMessage = (String) firstApiResponse.get("message");
        Map<String, Object> response = new HashMap<>();

        response.put("status", httpStatus);
        response.put("message", nullToEmpty(errorMessage));

        if (httpStatus == 200 && type.equals("geolocation")) {
            response.put("response", apiResponseList.stream().map(Geolocation::new).collect(Collectors.toList()));
        } else if (httpStatus == 200 && type.equals("useragent")) {
            response.put("response", apiResponseList.stream().map(UserAgent::new).collect(Collectors.toList()));
        }

        return response;
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

            boolean includeHost = false;

            if (params.isIncludeHostname()) {
                urlParams.append("&include=hostname");
                includeHost = true;
            } else if (params.isIncludeHostnameFallbackLive()) {
                urlParams.append("&include=hostnameFallbackLive");
                includeHost = true;
            } else if (params.isIncludeLiveHostname()) {
                urlParams.append("&include=liveHostname");
                includeHost = true;
            }

            if (params.isIncludeSecurity()) {
                if (includeHost) {
                    urlParams.append(",security");
                } else {
                    urlParams.append("&include=security");
                }
            }

            if (params.isIncludeUserAgentDetail()) {
                if (includeHost || params.isIncludeSecurity()) {
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

    private String buildTimezoneUrlParams(TimezoneParams params) {
        StringBuilder urlParams = new StringBuilder();

        urlParams.append("apiKey=");
        urlParams.append(apiKey);

        if (!isNull(params)) {
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

    private Map<String, Object> callAPIEndpoint(String endpoint, String urlParams, String requestType, Optional<JSONObject> requestBody) {
        String url = "https://api.ipgeolocation.io/" + endpoint + "?" + urlParams;

        int responseCode;
        String jsonString;

        try {
            Map<String, String> responseMap = getResponseMap(url, requestType, requestBody);

            responseCode = Integer.parseInt(responseMap.get("code"));
            jsonString = responseMap.get("json");

            if (responseCode == 0 || isNullOrEmpty(jsonString)) {
                responseCode = 422;
                jsonString = "{\"message\":\"Could not get any response from ipgeolocation.io API.\"}";
            } else if (!isJsonString(jsonString)) {
                responseCode = 422;
                jsonString = "{\"message\":\"Got invalid response from ipgeolocation.io API.\"}";
            }
        } catch (Exception e) {
            responseCode = 422;
            jsonString = "{\"message\":\"Could not connect to ipgeolocation.io API.\"}";
        }

        return convertJSONStringToMap(responseCode, jsonString);
    }

    private List<Map<String, Object>> callBulkAPIEndpoint(String url, Optional<JSONObject> requestBody) {
        int responseCode;
        String jsonString;

        try {
            Map<String, String> responseMap = getResponseMap(url, "POST", requestBody);

            responseCode = Integer.parseInt(responseMap.get("code"));
            jsonString = responseMap.get("json");

            if (responseCode == 0 || isNullOrEmpty(jsonString)) {
                responseCode = 422;
                jsonString = "{\"message\":\"Could not get any response from ipgeolocation.io API.\"}";
            }
        } catch (Exception e) {
            responseCode = 422;
            jsonString = "{\"message\":\"Could not connect to ipgeolocation.io API.\"}";
        }

        return convertJSONStringToListMap(responseCode, jsonString);
    }

    private Map<String, String> getResponseMap(String url, String requestType, Optional<JSONObject> requestBody) {
        Map<String, String> responseMap = null;

        try {
            URL obj = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) obj.openConnection();

            connection.setReadTimeout(10000);
            connection.setConnectTimeout(10000);
            connection.setRequestMethod(requestType);
            connection.setRequestProperty("Accept", "application/json");

            if (requestType.equalsIgnoreCase("post")) {
                connection.setRequestProperty("Content-Type", "application/json");
                connection.setDoOutput(true);

                requestBody.ifPresent(
                        body -> {
                            try {
                                DataOutputStream outputStream = new DataOutputStream(connection.getOutputStream());
                                outputStream.writeBytes(body.toString());
                                outputStream.flush();
                                outputStream.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        });
            }

            responseMap = parseConnectionResponse(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseMap;
    }

    private Map<String, String> parseConnectionResponse(HttpURLConnection connection) {
        if (isNull(connection)) {
            throw new IllegalArgumentException("Pre-condition violated: connection must not be null");
        }

        Map<String, String> responseMap = new HashMap<>();

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
                responseMap.put("json", "{\"message\":\"Could not get any response from ipgeolocation.io API.\"}");
            } else {
                responseMap.put("code", String.valueOf(responseCode));
                responseMap.put("json", jsonString);
            }
        } catch (IOException e) {
            responseMap.put("code", String.valueOf(422));
            responseMap.put("json", "{\"message\":\"Could not connect to ipgeolocation.io API.\"}");
        }

        return responseMap;
    }

    private Map<String, Object> convertJSONStringToMap(int responseCode, String response) {
        Map<String, Object> map = new JSONObject(response).toMap();

        map.put("status", responseCode);
        return map;
    }

    private List<Map<String, Object>> convertJSONStringToListMap(int responseCode, String response) {
        if (responseCode != 200) {
            response = "[" + response + "]";
        }

        return new JSONArray(response)
                .toList().stream().map(it -> {
                    Map<String, Object> apiResponse = (Map<String, Object>) it;

                    apiResponse.put("status", responseCode);
                    return apiResponse;
                }).collect(Collectors.toList());
    }
}
