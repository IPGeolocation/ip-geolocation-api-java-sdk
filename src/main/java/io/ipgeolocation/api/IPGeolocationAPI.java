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

/**
 * The IPGeolocationAPI class provides a client for accessing the <a href="https://ipgeolocation.io">IPGeolocation API</a>.
 * This class allows users to retrieve geolocation information based on IP addresses.
 *
 * <p>
 * Usage:
 * <pre>{@code
 * // Instantiate IPGeolocationAPI with your API key
 * IPGeolocationAPI ipGeolocationAPI = new IPGeolocationAPI("YOUR_API_KEY");
 *
 * // Use the API to retrieve geolocation information
 * GeolocationParams geolocationParams =
 *         GeolocationParams.builder()
 *             .withIPAddress("1.1.1.1")
 *             .build();
 * Geolocation geolocation = ipGeolocationAPI.getGeolocation(geolocationParams);
 * System.out.println(geolocation);
 * }</pre>
 * </p>
 *
 * <p>
 * Additional examples and documentation can be found at the following locations:
 * <ul>
 *     <li><a href="https://github.com/IPGeolocation/ip-geolocation-api-java-sdk">Github Readme</a></li>
 *     <li><a href="https://ipgeolocation.io/documentation/ip-geolocation-api-java-sdk.html">Official Website Documentation</a></li>
 * </ul>
 * </p>
 *
 * <p>
 * This class requires a valid API key for authentication. The API key must be obtained
 * from the IP Geolocation website. Without a valid API key, the class methods
 * will throw an IllegalArgumentException.
 * </p>
 */
public class IPGeolocationAPI {
  private final List<String> NON_BODY_HTTP_METHODS =
      Arrays.asList("GET", "DELETE", "TRACE", "OPTIONS", "HEAD");
  private final String apiKey;

  /**
   * Constructs a new IPGeolocationAPI object with the specified API key.
   *
   * @param apiKey The API key to authenticate access to the IPGeolocationAPI.
   * @throws IllegalArgumentException if the provided API key is null or empty.
   */
  public IPGeolocationAPI(String apiKey) throws IllegalArgumentException {
    if (Strings.isNullOrEmpty(apiKey)) {
      throw new IllegalArgumentException("API key must not be null or empty");
    } else {
      this.apiKey = apiKey.trim();
    }
  }

  /**
   * Returns the API key used for authentication.
   *
   * @return The API key as a {@code String}.
   */
  public String getApiKey() {
    return apiKey;
  }

  /**
   * Retrieves geolocation information based on the IP address of the current client.
   * This method is a shorthand for {@code getGeolocation(null)}.
   *
   * @return The geolocation information for the IP address of the current client.
   * @throws IPGeolocationError if an error occurs during the retrieval of geolocation information.
   */
  public Geolocation getGeolocation() {
    return getGeolocation(null);
  }

  /**
   * Retrieves geolocation information based on the provided parameters.
   *
   * @param params The parameters to customize the geolocation retrieval. Pass {@code null} to use default settings.
   * @return The {@link Geolocation} information based on the provided parameters.
   * @throws IPGeolocationError if an error occurs during the retrieval of geolocation information.
   */
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

  /**
   * Retrieves geolocation information for a batch of IP addresses (maximum 50) using default settings.
   * This method is a shorthand for {@code getBulkGeolocation(ipAddresses, null)}.
   *
   * @param ipAddresses An array of IP addresses for which geolocation information will be retrieved.
   * @return A list of {@link Geolocation} information for the provided IP addresses.
   * @throws IPGeolocationError if an error occurs during the retrieval of geolocation information.
   */
  public List<Geolocation> getBulkGeolocation(String[] ipAddresses) {
    return getBulkGeolocation(ipAddresses, null);
  }

  /**
   * Retrieves geolocation information for a batch of IP addresses (maximum 50) using custom settings.
   *
   * @param ipAddresses An array of IP addresses for which geolocation information will be retrieved.
   * @param params      The parameters to customize the geolocation retrieval. Pass {@code null} to use default settings.
   * @return A list of {@link Geolocation} information for the provided IP addresses.
   * @throws IPGeolocationError if an error occurs during the retrieval of geolocation information.
   */
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

  /**
   * Retrieves timezone information based on the current client's IP address.
   * This method is a shorthand for {@code getTimezone(null)}.
   *
   * @return The timezone information for the current client's IP address.
   * @throws IPGeolocationError if an error occurs during the retrieval of timezone information.
   */
  public Timezone getTimezone() {
    return getTimezone(null);
  }

  /**
   * Retrieves timezone information based on the provided parameters.
   *
   * @param params The parameters to customize the timezone retrieval. Pass {@code null} to use default settings.
   * @return The timezone information based on the provided parameters.
   * @throws IPGeolocationError if an error occurs during the retrieval of timezone information.
   */
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

  /**
   * Converts a time from one timezone to another using the IP Geolocation API.
   *
   * @param params The parameters for timezone conversion, including the source and target timezones,
   *               as well as the time to convert.
   * @return A {@code TimezoneConvert} object representing the converted time.
   * @throws IPGeolocationError If an error occurs during the timezone conversion process,
   *                            such as an invalid API response or parameters.
   * @see TimezoneConvertParams
   * @see TimezoneConvert
   */
  public TimezoneConvert convertTimeZone(TimezoneConvertParams params) {
    final JSONObject apiResponse =
        (JSONObject)
            callAPIEndpoint(
                "timezone/convert",
                buildTimezoneConvertUrlParams(params),
                "GET",
                null,
                false);
    final TimezoneConvert timezoneConvert;

    try {
      timezoneConvert = new TimezoneConvert(apiResponse);
    } catch (IllegalArgumentException e) {
      throw new IPGeolocationError(e);
    }

    return timezoneConvert;
  }

  /**
   * Retrieves user-agent information based on the provided user-agent string.
   *
   * @param uaString The user-agent string for which information will be retrieved.
   * @return The parsed user-agent information corresponding to the provided user-agent string.
   * @throws IPGeolocationError if the provided user-agent string is empty or null, or if an error occurs during the retrieval of user-agent information.
   */
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

  /**
   * Retrieves user-agent information for a batch of user-agent strings (maximum 50).
   *
   * @param uaStrings An array of user-agent strings for which information will be retrieved.
   * @return A list of user-agent parsed information for the provided user-agent strings.
   * @throws IPGeolocationError if the provided list of user-agent strings is empty or null, or if an error occurs during the retrieval of user-agent information.
   */
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

  /**
   * Retrieves astronomy information based on the current client's IP address.
   * This method is a shorthand for {@code getAstronomy(null)}.
   *
   * @return The astronomy information for the current client's IP address.
   * @throws IPGeolocationError if an error occurs during the retrieval of astronomy information.
   */
  public Astronomy getAstronomy() {
    return getAstronomy(null);
  }

  /**
   * Retrieves astronomy information based on the provided parameters.
   *
   * @param params The parameters to customize the astronomy retrieval. Pass {@code null} to use default settings.
   * @return The astronomy information based on the provided parameters.
   * @throws IPGeolocationError if an error occurs during the retrieval of astronomy information.
   */
  public Astronomy getAstronomy(AstronomyParams params) {
    final JSONObject apiResponse =
            (JSONObject)
                    callAPIEndpoint("astronomy",
                            buildAstronomyUrlParams(params),
                            "GET",
                            null,
                            false);
    final Astronomy astronomy;

    try {
      astronomy = new Astronomy(apiResponse);
    } catch (IllegalArgumentException e) {
      throw new IPGeolocationError(e);
    }
    return astronomy;
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

  private String buildTimezoneConvertUrlParams(final TimezoneConvertParams params) {
    final StringBuilder urlParams = new StringBuilder();

    urlParams.append("apiKey=");
    urlParams.append(apiKey);

    if (!Objects.isNull(params)) {
      if ((!Strings.isNullOrEmpty(params.getTimezoneFrom())) && (!Strings.isNullOrEmpty(params.getTimezoneTo()))) {
        urlParams.append("&tz_from=");
        urlParams.append(params.getTimezoneFrom());

        urlParams.append("&tz_to=");
        urlParams.append(params.getTimezoneTo());
      }

      if ((!Objects.isNull(params.getLatitudeFrom()) && !Objects.isNull(params.getLongitudeFrom()))
              && ((!Objects.isNull(params.getLatitudeTo()) && !Objects.isNull(params.getLongitudeTo())))) {
        urlParams.append("&lat_from=");
        urlParams.append(params.getLatitudeFrom());
        urlParams.append("&long_from=");
        urlParams.append(params.getLongitudeFrom());

        urlParams.append("&lat_to=");
        urlParams.append(params.getLatitudeTo());
        urlParams.append("&long_to=");
        urlParams.append(params.getLongitudeTo());
      }

      if ((!Strings.isNullOrEmpty(params.getLocationFrom())) && (!Strings.isNullOrEmpty(params.getLocationTo()))) {
        urlParams.append("&location_from=");
        urlParams.append(params.getLocationFrom());

        urlParams.append("&location_to=");
        urlParams.append(params.getLocationTo());
      }

      if (!Strings.isNullOrEmpty(params.getTime())) {
        urlParams.append("&time=");
        urlParams.append(params.getTime());
      }
    }

    return urlParams.toString();
  }

  private String buildAstronomyUrlParams(final AstronomyParams params) {
    final StringBuilder urlParams = new StringBuilder();

    urlParams.append("apiKey=");
    urlParams.append(apiKey);

    if (!Objects.isNull(params)) {
      if (!Strings.isNullOrEmpty(params.getIpAddress())) {
        urlParams.append("&ip=");
        urlParams.append(params.getIpAddress());
      }

      if (!Strings.isNullOrEmpty(params.getLocation())) {
        urlParams.append("&location=");
        urlParams.append(params.getLocation());
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

      if (!Strings.isNullOrEmpty(params.getDate())) {
        urlParams.append("&date=");
        urlParams.append(params.getDate());
      }
    }
    return urlParams.toString();
  }

  /**
   * Calls the specified API endpoint with the provided parameters and returns the response.
   *
   * @param endpoint              The endpoint to call.
   * @param requestParams         The parameters to include in the request URL.
   * @param requestMethod         The HTTP request method (e.g., GET, POST).
   * @param requestBody           The body of the HTTP request.
   * @param arrayResponseExpected Indicates whether the expected response is an array.
   * @return The response from the API endpoint.
   * @throws IPGeolocationError if an error occurs during the API call or processing the response.
   */
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
