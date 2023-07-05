package io.ipgeolocation.api;

import java.util.Objects;
import org.json.JSONObject;

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

  public int getThreatScore() {
    return threatScore;
  }

  public boolean isTor() {
    return tor;
  }

  public boolean isProxy() {
    return proxy;
  }

  public String getProxyType() {
    return proxyType;
  }

  public boolean isAnonymous() {
    return anonymous;
  }

  public boolean isKnownAttacker() {
    return knownAttacker;
  }

  public boolean isBot() {
    return bot;
  }

  public boolean isSpam() {
    return spam;
  }

  public boolean isCloudProvider() {
    return cloudProvider;
  }

  @Override
  public String toString() {
    return json.toString(2);
  }
}
