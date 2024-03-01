package io.ipgeolocation.api;

import java.util.Objects;
import org.json.JSONObject;

/**
 * Represents security information associated with geolocation data.
 */
public class GeolocationSecurity {
  private final int threatScore;
  private final boolean tor;
  private final boolean proxy;
  private final String proxyType;
  private final boolean anonymous;
  private final boolean knownAttacker;
  private final boolean bot;
  private final boolean spam;
  private final boolean cloudProvider;
  private final JSONObject json;

  /**
   * Constructs a new GeolocationSecurity object with the provided JSON data.
   *
   * @param json The JSON object containing security information.
   * @throws IllegalArgumentException If the provided JSON object is null or empty.
   */
  GeolocationSecurity(JSONObject json) {
    if (Objects.isNull(json)) {
      throw new IllegalArgumentException("'json' must not be null");
    }

    if (json.isEmpty()) {
      throw new IllegalArgumentException("'json' must not be empty");
    }

    this.threatScore = json.getInt("threat_score");
    this.tor = json.getBoolean("is_tor");
    this.proxy = json.getBoolean("is_proxy");
    this.proxyType = json.optString("proxy_type");
    this.anonymous = json.getBoolean("is_anonymous");
    this.knownAttacker = json.getBoolean("is_known_attacker");
    this.bot = json.getBoolean("is_bot");
    this.spam = json.getBoolean("is_spam");
    this.cloudProvider = json.getBoolean("is_cloud_provider");
    this.json = json;
  }

  /**
   * Returns the threat score associated with the IP address. It ranges from 0 to 100.
   * 100 indicates highest threat and vice versa for lower score.
   *
   * @return The threat score as an integer.
   */
  public int getThreatScore() {
    return threatScore;
  }

  /**
   * Indicates if the IP address is being consumed on a Tor endpoint.
   *
   * @return {@code true} if the IP address is associated with Tor, {@code false} otherwise.
   */
  public boolean isTor() {
    return tor;
  }

  /**
   * Indicates if the IP address belongs to a proxy network.
   *
   * @return {@code true} if the IP address is a proxy, {@code false} otherwise.
   */
  public boolean isProxy() {
    return proxy;
  }

  /**
   * Returns the type of proxy if the IP address is a proxy.
   *
   * @return The type of proxy as a string, or an empty string if the IP address is not a proxy.
   */
  public String getProxyType() {
    return proxyType;
  }

  /**
   * Indicates if the IP address is being used anonymously.
   *
   * @return {@code true} if the IP address is anonymous, {@code false} otherwise.
   */
  public boolean isAnonymous() {
    return anonymous;
  }

  /**
   * Indicates if the IP address  is enlisted as an attacking IP address.
   *
   * @return {@code true} if the IP address is a known attacker, {@code false} otherwise.
   */
  public boolean isKnownAttacker() {
    return knownAttacker;
  }

  /**
   * Indicates if the IP address is associated with a bot.
   *
   * @return {@code true} if the IP address is associated with a bot, {@code false} otherwise.
   */
  public boolean isBot() {
    return bot;
  }

  /**
   * Indicates if the IP address is associated with spam activity.
   *
   * @return {@code true} if the IP address is associated with spam activity, {@code false} otherwise.
   */
  public boolean isSpam() {
    return spam;
  }

  /**
   * Indicates if the IP address is associated with a cloud provider (computing infrastructure providers).
   *
   * @return {@code true} if the IP address is associated with a cloud provider, {@code false} otherwise.
   */
  public boolean isCloudProvider() {
    return cloudProvider;
  }

  /**
   * Returns a JSON representation of the security data.
   *
   * @return The JSON representation of the security data as a string.
   */
  @Override
  public String toString() {
    return json.toString(2);
  }
}
