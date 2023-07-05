package io.ipgeolocation.api;

import io.ipgeolocation.api.exceptions.IPGeolocationError;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONObject;

public class IPGeolocationAPI {
  private final List<String> NON_BODY_HTTP_METHODS =
      Arrays.asList("GET", "DELETE", "TRACE", "OPTIONS", "HEAD");
  private final String apiKey;

  public IPGeolocationAPI(String apiKey) throws IllegalArgumentException {
    if (Strings.isNullOrEmpty(apiKey)) {
      throw new IllegalArgumentException("API key must not be null or empty");
    } else {
      this.apiKey = apiKey.trim();
    }
  }

  public String getApiKey() {
    return apiKey;
  }

  public Geolocation getGeolocation() {
    return getGeolocation(null);
  }

  public Geolocation getGeolocation(GeolocationParams params) {
    final JSONObject apiResponse =
        (JSONObject)
            callAPIEndpoint("ipgeo", buildGeolocationUrlParams(params), "GET", null, false);
    final Geolocation geolocation;

    try {
      geolocation = new Geolocation(apiResponse);
    } catch (IllegalArgumentException e) {
      throw new IPGeolocationError(e);
    }

    return geolocation;
  }

  public List<Geolocation> getBulkGeolocation(String[] ipAddresses) {
    return getBulkGeolocation(ipAddresses, null);
  }

  public List<Geolocation> getBulkGeolocation(String[] ipAddresses, GeolocationParams params) {
    if (Objects.isNull(ipAddresses) || ipAddresses.length == 0) {
      throw new IPGeolocationError("IP addresses list must not be null or empty");
    }

    if (ipAddresses.length > 50) {
      throw new IPGeolocationError("Maximum number of IP addresses cannot be more than 50");
    }

    final JSONArray apiResponseList =
        (JSONArray)
            callAPIEndpoint(
                "ipgeo-bulk",
                buildGeolocationUrlParams(params),
                "POST",
                new JSONObject().put("ips", ipAddresses),
                true);
    final List<Geolocation> geolocations = new ArrayList<>(apiResponseList.length());
    int i = 0;

    while (i < apiResponseList.length()) {
      try {
        geolocations.add(new Geolocation(apiResponseList.getJSONObject(i++)));
      } catch (IllegalArgumentException e) {
        throw new IPGeolocationError(e);
      }
    }

    return geolocations;
  }

  public Timezone getTimezone() {
    return getTimezone(null);
  }

  public Timezone getTimezone(TimezoneParams params) {
    final JSONObject apiResponse =
        (JSONObject)
            callAPIEndpoint("timezone", buildTimezoneUrlParams(params), "GET", null, false);
    final Timezone timezone;

    try {
      timezone = new Timezone(apiResponse);
    } catch (IllegalArgumentException e) {
      throw new IPGeolocationError(e);
    }

    return timezone;
  }

  public UserAgent getUserAgent(String uaString) {
    uaString = uaString.trim();

    if (Strings.isNullOrEmpty(uaString)) {
      throw new IPGeolocationError("User-Agent string must not be empty or null");
    }

    final JSONObject apiResponse =
        (JSONObject)
            callAPIEndpoint(
                "user-agent",
                buildGeolocationUrlParams(null),
                "POST",
                new JSONObject().put("uaString", uaString),
                false);
    final UserAgent userAgent;

    try {
      userAgent = new UserAgent(apiResponse);
    } catch (IllegalArgumentException e) {
      throw new IPGeolocationError(e);
    }

    return userAgent;
  }

  public List<UserAgent> getBulkUserAgent(String[] uaStrings) {
    if (Objects.isNull(uaStrings) || uaStrings.length == 0) {
      throw new IPGeolocationError("User-Agents list must not be null or empty");
    }

    if (uaStrings.length > 50) {
      throw new IPGeolocationError("Maximum number of User-Agents cannot be more than 50");
    }

    final JSONArray apiResponseList =
        (JSONArray)
            callAPIEndpoint(
                "user-agent-bulk",
                buildGeolocationUrlParams(null),
                "POST",
                new JSONObject().put("uaStrings", uaStrings),
                true);
    final List<UserAgent> userAgents = new ArrayList<>(apiResponseList.length());
    int i = 0;

    while (i < apiResponseList.length()) {
      try {
        userAgents.add(new UserAgent(apiResponseList.getJSONObject(i++)));
      } catch (IllegalArgumentException e) {
        throw new IPGeolocationError(e);
      }
    }

    return userAgents;
  }

  private String buildGeolocationUrlParams(final GeolocationParams params) {
    final StringBuilder urlParams = new StringBuilder();

    urlParams.append("apiKey=");
    urlParams.append(apiKey);

    if (!Objects.isNull(params)) {
      if (!Strings.isNullOrEmpty(params.getIPAddress())) {
        urlParams.append("&ip=");
        urlParams.append(params.getIPAddress());
      }

      if (!Strings.isNullOrEmpty(params.getFields())) {
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

      if (!Strings.isNullOrEmpty(params.getLang())) {
        urlParams.append("&lang=");
        urlParams.append(params.getLang());
      }

      if (!Strings.isNullOrEmpty(params.getExcludes())) {
        urlParams.append("&excludes=");
        urlParams.append(params.getExcludes());
      }
    }

    return urlParams.toString();
  }

  private String buildTimezoneUrlParams(final TimezoneParams params) {
    final StringBuilder urlParams = new StringBuilder();

    urlParams.append("apiKey=");
    urlParams.append(apiKey);

    if (!Objects.isNull(params)) {
      if (!Strings.isNullOrEmpty(params.getIPAddress())) {
        urlParams.append("&ip=");
        urlParams.append(params.getIPAddress());
      }

      if (!Strings.isNullOrEmpty(params.getTimeZone())) {
        urlParams.append("&tz=");
        urlParams.append(params.getTimeZone());
      }

      if (!Objects.isNull(params.getLatitude()) && !Objects.isNull(params.getLongitude())) {
        urlParams.append("&lat=");
        urlParams.append(params.getLatitude());
        urlParams.append("&long=");
        urlParams.append(params.getLongitude());
      }

      if (!Strings.isNullOrEmpty(params.getLang())) {
        urlParams.append("&lang=");
        urlParams.append(params.getLang());
      }

      if (!Strings.isNullOrEmpty(params.getLocation())) {
        urlParams.append("&location=");
        urlParams.append(params.getLocation());
      }
    }

    return urlParams.toString();
  }

  private Object callAPIEndpoint(
      final String endpoint,
      final String requestParams,
      final String requestMethod,
      final JSONObject requestBody,
      final boolean arrayResponseExpected) {
    final String uri = String.format("https://api.ipgeolocation.io/%s?%s", endpoint, requestParams);
    final Object response;

    try {
      final URL url = new URL(uri);
      final HttpURLConnection connection = (HttpURLConnection) url.openConnection();

      connection.setRequestMethod(requestMethod);
      connection.setRequestProperty("Accept", "application/json");
      connection.setReadTimeout(60000);
      connection.setConnectTimeout(60000);

      if (!NON_BODY_HTTP_METHODS.contains(requestMethod.toUpperCase())
          && !Objects.isNull(requestBody)) {
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setDoOutput(true);

        DataOutputStream dataOutputStream = new DataOutputStream(connection.getOutputStream());
        dataOutputStream.writeBytes(requestBody.toString());
        dataOutputStream.flush();
        dataOutputStream.close();
      }

      final int responseCode = connection.getResponseCode();
      final StringBuilder responseBuilder = new StringBuilder();
      final BufferedReader reader;

      if (responseCode == HttpURLConnection.HTTP_OK) {
        reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String line;

        while (!Objects.isNull(line = reader.readLine())) {
          responseBuilder.append(line);
        }

        if (arrayResponseExpected) {
          response = new JSONArray(responseBuilder.toString());
        } else {
          response = new JSONObject(responseBuilder.toString());
        }
      } else {
        reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
        String line;

        while (!Objects.isNull(line = reader.readLine())) {
          responseBuilder.append(line);
        }

        throw new IPGeolocationError(
            responseCode, new JSONObject(responseBuilder.toString()).getString("message"));
      }

      reader.close();

      if (responseBuilder.length() == 0) {
        throw new IPGeolocationError(
            "There was an error in reading response from ipgeolocation.io API. Please open an issue at https://github.com/IPGeolocation/ip-geolocation-api-java-sdk");
      }
    } catch (IOException e) {
      throw new IPGeolocationError(e);
    }

    return response;
  }
}
