package io.ipgeolocation.api;

import java.util.Map;

public class GeolocationSecurity {
    private final Integer threatScore;
    private final Boolean isTor;
    private final Boolean isProxy;
    private final String proxyType;
    private final Boolean isAnonymous;
    private final Boolean isKnownAttacker;
    private final Boolean isBot;
    private final Boolean isSpam;
    private final Boolean isCloudProvider;

    GeolocationSecurity(Map<String, Object> json) {
        this.threatScore = (Integer) json.get("threat_score");
        this.isTor = (Boolean) json.get("is_tor");
        this.isProxy = (Boolean) json.get("is_proxy");
        this.proxyType = (String) json.get("proxy_type");
        this.isAnonymous = (Boolean) json.get("is_anonymous");
        this.isKnownAttacker = (Boolean) json.get("is_known_attacker");
        this.isBot = (Boolean) json.get("is_bot");
        this.isSpam = (Boolean) json.get("is_spam");
        this.isCloudProvider = (Boolean) json.get("is_cloud_provider");
    }

    public Integer getThreatScore() {
        return threatScore;
    }

    public Boolean isTor() {
        return isTor;
    }

    public Boolean isProxy() {
        return isProxy;
    }

    public String getProxyType() {
        return proxyType;
    }

    public Boolean isAnonymous() {
        return isAnonymous;
    }

    public Boolean isKnownAttacker() {
        return isKnownAttacker;
    }

    public Boolean isBot() {
        return isBot;
    }

    public Boolean isSpam() {
        return isSpam;
    }

    public Boolean isCloudProvider() {
        return isCloudProvider;
    }

}
