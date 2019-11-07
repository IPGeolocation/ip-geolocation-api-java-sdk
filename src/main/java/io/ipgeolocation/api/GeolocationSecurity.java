package io.ipgeolocation.api;

import java.util.Map;

public class GeolocationSecurity {
    private Double threatScore;
    private Boolean isTor;
    private Boolean isProxy;
    private String proxyType;
    private Boolean isAnonymous;
    private Boolean isKnownAttacker;
    private Boolean isCloudProvider;

    GeolocationSecurity(Map json){
        this.threatScore = (Double) json.get("threat_score");
        this.isTor = (Boolean) json.get("is_tor");
        this.isProxy = (Boolean) json.get("is_proxy");
        this.proxyType = (String) json.get("proxy_type");
        this.isAnonymous = (Boolean) json.get("is_anonymous");
        this.isKnownAttacker = (Boolean) json.get("is_known_attacker");
        this.isCloudProvider = (Boolean) json.get("is_cloud_provider");
    }

    public Double getThreatScore() {
        return threatScore;
    }

    public void setThreatScore(Double threatScore) {
        this.threatScore = threatScore;
    }

    public Boolean getTor() {
        return isTor;
    }

    public void setTor(Boolean tor) {
        isTor = tor;
    }

    public Boolean getProxy() {
        return isProxy;
    }

    public void setProxy(Boolean proxy) {
        isProxy = proxy;
    }

    public String getProxyType() {
        return proxyType;
    }

    public void setProxyType(String proxyType) {
        this.proxyType = proxyType;
    }

    public Boolean getAnonymous() {
        return isAnonymous;
    }

    public void setAnonymous(Boolean anonymous) {
        isAnonymous = anonymous;
    }

    public Boolean getKnownAttacker() {
        return isKnownAttacker;
    }

    public void setKnownAttacker(Boolean knownAttacker) {
        isKnownAttacker = knownAttacker;
    }

    public Boolean getCloudProvider() {
        return isCloudProvider;
    }

    public void setCloudProvider(Boolean cloudProvider) {
        isCloudProvider = cloudProvider;
    }
}
