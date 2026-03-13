package io.ipgeolocation.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/**
 * Security and risk signals available when security module is requested.
 *
 * @param threatScore aggregate threat score
 * @param isTor true when IP belongs to Tor network
 * @param isProxy true when IP is detected as proxy
 * @param proxyProviderNames detected proxy provider names
 * @param proxyConfidenceScore proxy detection confidence score
 * @param proxyLastSeen last-seen timestamp for proxy activity
 * @param isResidentialProxy true when proxy is residential
 * @param isVpn true when IP is detected as VPN
 * @param vpnProviderNames detected VPN provider names
 * @param vpnConfidenceScore VPN detection confidence score
 * @param vpnLastSeen last-seen timestamp for VPN activity
 * @param isRelay true when IP is detected as relay
 * @param relayProviderName relay provider name
 * @param isAnonymous true when IP is anonymous
 * @param isKnownAttacker true when IP is linked to attacks
 * @param isBot true when IP is linked to bot activity
 * @param isSpam true when IP is linked to spam activity
 * @param isCloudProvider true when IP belongs to cloud provider
 * @param cloudProviderName cloud provider name
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record Security(
    Double threatScore,
    @JsonProperty("is_tor") Boolean isTor,
    @JsonProperty("is_proxy") Boolean isProxy,
    List<String> proxyProviderNames,
    Double proxyConfidenceScore,
    String proxyLastSeen,
    @JsonProperty("is_residential_proxy") Boolean isResidentialProxy,
    @JsonProperty("is_vpn") Boolean isVpn,
    List<String> vpnProviderNames,
    Double vpnConfidenceScore,
    String vpnLastSeen,
    @JsonProperty("is_relay") Boolean isRelay,
    String relayProviderName,
    @JsonProperty("is_anonymous") Boolean isAnonymous,
    @JsonProperty("is_known_attacker") Boolean isKnownAttacker,
    @JsonProperty("is_bot") Boolean isBot,
    @JsonProperty("is_spam") Boolean isSpam,
    @JsonProperty("is_cloud_provider") Boolean isCloudProvider,
    String cloudProviderName) {}
