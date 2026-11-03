package io.ipgeolocation.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.ipgeolocation.sdk.internal.Compat;
import java.util.List;
import java.util.Objects;

/**
 * Security and risk signals returned for {@code include=security}.
 *
 * <p>Fields in this model support use cases such as VPN detection, proxy detection, threat
 * scoring, Tor detection, anonymous IP checks, residential proxy checks, attacker or bot
 * detection, spam signals, relay detection, and cloud or hosting or data center IP
 * identification.
 *
 * <p>Provider-name, confidence-score, and last-seen fields are returned when the API has
 * supporting evidence for the matched VPN, proxy, relay, or hosting signal.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public final class Security {
  private final Double threatScore;
  private final Boolean isTor;
  private final Boolean isProxy;
  private final List<String> proxyProviderNames;
  private final Double proxyConfidenceScore;
  private final String proxyLastSeen;
  private final Boolean isResidentialProxy;
  private final Boolean isVpn;
  private final List<String> vpnProviderNames;
  private final Double vpnConfidenceScore;
  private final String vpnLastSeen;
  private final Boolean isRelay;
  private final String relayProviderName;
  private final Boolean isAnonymous;
  private final Boolean isKnownAttacker;
  private final Boolean isBot;
  private final Boolean isSpam;
  private final Boolean isCloudProvider;
  private final String cloudProviderName;

  @JsonProperty("proxy_days_seen_30d")
  private final Integer proxyDaysSeen30d;
  @JsonProperty("proxy_days_seen_7d")
  private final Integer proxyDaysSeen7d;
  @JsonProperty("proxy_provider_count_30d")
  private final Integer proxyProviderCount30d;
  private final Double botConfidenceScore;
  private final String botOperatorName;
  private final String botType;
  private final Boolean isKnownGoodBot;
  private final String botLastSeen;
  private final Boolean isCorporateGateway;
  private final String corporateGatewayType;
  private final String corporateGatewayProviderName;

  public Security(
      Double threatScore,
      Boolean isTor,
      Boolean isProxy,
      List<String> proxyProviderNames,
      Double proxyConfidenceScore,
      String proxyLastSeen,
      Boolean isResidentialProxy,
      Boolean isVpn,
      List<String> vpnProviderNames,
      Double vpnConfidenceScore,
      String vpnLastSeen,
      Boolean isRelay,
      String relayProviderName,
      Boolean isAnonymous,
      Boolean isKnownAttacker,
      Boolean isBot,
      Boolean isSpam,
      Boolean isCloudProvider,
      String cloudProviderName) {
    this(threatScore, isTor, isProxy, proxyProviderNames, proxyConfidenceScore, proxyLastSeen,
        isResidentialProxy, isVpn, vpnProviderNames, vpnConfidenceScore, vpnLastSeen, isRelay,
        relayProviderName, isAnonymous, isKnownAttacker, isBot, isSpam, isCloudProvider, cloudProviderName,
        null, null, null, null, null, null, null, null, null, null, null);
  }

  @JsonCreator
  public Security(
      @JsonProperty("threat_score") Double threatScore,
      @JsonProperty("is_tor") Boolean isTor,
      @JsonProperty("is_proxy") Boolean isProxy,
      @JsonProperty("proxy_provider_names") List<String> proxyProviderNames,
      @JsonProperty("proxy_confidence_score") Double proxyConfidenceScore,
      @JsonProperty("proxy_last_seen") String proxyLastSeen,
      @JsonProperty("is_residential_proxy") Boolean isResidentialProxy,
      @JsonProperty("is_vpn") Boolean isVpn,
      @JsonProperty("vpn_provider_names") List<String> vpnProviderNames,
      @JsonProperty("vpn_confidence_score") Double vpnConfidenceScore,
      @JsonProperty("vpn_last_seen") String vpnLastSeen,
      @JsonProperty("is_relay") Boolean isRelay,
      @JsonProperty("relay_provider_name") String relayProviderName,
      @JsonProperty("is_anonymous") Boolean isAnonymous,
      @JsonProperty("is_known_attacker") Boolean isKnownAttacker,
      @JsonProperty("is_bot") Boolean isBot,
      @JsonProperty("is_spam") Boolean isSpam,
      @JsonProperty("is_cloud_provider") Boolean isCloudProvider,
      @JsonProperty("cloud_provider_name") String cloudProviderName,
      @JsonProperty("proxy_days_seen_30d") Integer proxyDaysSeen30d,
      @JsonProperty("proxy_days_seen_7d") Integer proxyDaysSeen7d,
      @JsonProperty("proxy_provider_count_30d") Integer proxyProviderCount30d,
      @JsonProperty("bot_confidence_score") Double botConfidenceScore,
      @JsonProperty("bot_operator_name") String botOperatorName,
      @JsonProperty("bot_type") String botType,
      @JsonProperty("is_known_good_bot") Boolean isKnownGoodBot,
      @JsonProperty("bot_last_seen") String botLastSeen,
      @JsonProperty("is_corporate_gateway") Boolean isCorporateGateway,
      @JsonProperty("corporate_gateway_type") String corporateGatewayType,
      @JsonProperty("corporate_gateway_provider_name") String corporateGatewayProviderName) {
    this.threatScore = threatScore;
    this.isTor = isTor;
    this.isProxy = isProxy;
    this.proxyProviderNames = Compat.immutableList(proxyProviderNames);
    this.proxyConfidenceScore = proxyConfidenceScore;
    this.proxyLastSeen = proxyLastSeen;
    this.isResidentialProxy = isResidentialProxy;
    this.isVpn = isVpn;
    this.vpnProviderNames = Compat.immutableList(vpnProviderNames);
    this.vpnConfidenceScore = vpnConfidenceScore;
    this.vpnLastSeen = vpnLastSeen;
    this.isRelay = isRelay;
    this.relayProviderName = relayProviderName;
    this.isAnonymous = isAnonymous;
    this.isKnownAttacker = isKnownAttacker;
    this.isBot = isBot;
    this.isSpam = isSpam;
    this.isCloudProvider = isCloudProvider;
    this.cloudProviderName = cloudProviderName;
    this.proxyDaysSeen30d = proxyDaysSeen30d;
    this.proxyDaysSeen7d = proxyDaysSeen7d;
    this.proxyProviderCount30d = proxyProviderCount30d;
    this.botConfidenceScore = botConfidenceScore;
    this.botOperatorName = botOperatorName;
    this.botType = botType;
    this.isKnownGoodBot = isKnownGoodBot;
    this.botLastSeen = botLastSeen;
    this.isCorporateGateway = isCorporateGateway;
    this.corporateGatewayType = corporateGatewayType;
    this.corporateGatewayProviderName = corporateGatewayProviderName;
  }

  public Double threatScore() { return threatScore; }
  public Boolean isTor() { return isTor; }
  public Boolean isProxy() { return isProxy; }
  public List<String> proxyProviderNames() { return proxyProviderNames; }
  public Double proxyConfidenceScore() { return proxyConfidenceScore; }
  /**
   * @return last observed proxy activity date in {@code YYYY-MM-DD} format, when available
   */
  public String proxyLastSeen() { return proxyLastSeen; }
  public Boolean isResidentialProxy() { return isResidentialProxy; }
  public Boolean isVpn() { return isVpn; }
  public List<String> vpnProviderNames() { return vpnProviderNames; }
  public Double vpnConfidenceScore() { return vpnConfidenceScore; }
  /**
   * @return last observed VPN activity date in {@code YYYY-MM-DD} format, when available
   */
  public String vpnLastSeen() { return vpnLastSeen; }
  public Boolean isRelay() { return isRelay; }
  public String relayProviderName() { return relayProviderName; }
  public Boolean isAnonymous() { return isAnonymous; }
  public Boolean isKnownAttacker() { return isKnownAttacker; }
  public Boolean isBot() { return isBot; }
  public Boolean isSpam() { return isSpam; }
  public Boolean isCloudProvider() { return isCloudProvider; }
  public String cloudProviderName() { return cloudProviderName; }

  public Integer proxyDaysSeen30d() { return proxyDaysSeen30d; }
  public Integer proxyDaysSeen7d() { return proxyDaysSeen7d; }
  public Integer proxyProviderCount30d() { return proxyProviderCount30d; }
  public Double botConfidenceScore() { return botConfidenceScore; }
  public String botOperatorName() { return botOperatorName; }
  public String botType() { return botType; }
  public Boolean isKnownGoodBot() { return isKnownGoodBot; }
  public String botLastSeen() { return botLastSeen; }
  public Boolean isCorporateGateway() { return isCorporateGateway; }
  public String corporateGatewayType() { return corporateGatewayType; }
  public String corporateGatewayProviderName() { return corporateGatewayProviderName; }

  @Override
  public boolean equals(Object other) {
    if (this == other) {
      return true;
    }
    if (!(other instanceof Security)) {
      return false;
    }
    Security that = (Security) other;
    return Objects.equals(threatScore, that.threatScore)
        && Objects.equals(isTor, that.isTor)
        && Objects.equals(isProxy, that.isProxy)
        && Objects.equals(proxyProviderNames, that.proxyProviderNames)
        && Objects.equals(proxyConfidenceScore, that.proxyConfidenceScore)
        && Objects.equals(proxyLastSeen, that.proxyLastSeen)
        && Objects.equals(isResidentialProxy, that.isResidentialProxy)
        && Objects.equals(isVpn, that.isVpn)
        && Objects.equals(vpnProviderNames, that.vpnProviderNames)
        && Objects.equals(vpnConfidenceScore, that.vpnConfidenceScore)
        && Objects.equals(vpnLastSeen, that.vpnLastSeen)
        && Objects.equals(isRelay, that.isRelay)
        && Objects.equals(relayProviderName, that.relayProviderName)
        && Objects.equals(isAnonymous, that.isAnonymous)
        && Objects.equals(isKnownAttacker, that.isKnownAttacker)
        && Objects.equals(isBot, that.isBot)
        && Objects.equals(isSpam, that.isSpam)
        && Objects.equals(isCloudProvider, that.isCloudProvider)
        && Objects.equals(cloudProviderName, that.cloudProviderName)
        && Objects.equals(proxyDaysSeen30d, that.proxyDaysSeen30d)
        && Objects.equals(proxyDaysSeen7d, that.proxyDaysSeen7d)
        && Objects.equals(proxyProviderCount30d, that.proxyProviderCount30d)
        && Objects.equals(botConfidenceScore, that.botConfidenceScore)
        && Objects.equals(botOperatorName, that.botOperatorName)
        && Objects.equals(botType, that.botType)
        && Objects.equals(isKnownGoodBot, that.isKnownGoodBot)
        && Objects.equals(botLastSeen, that.botLastSeen)
        && Objects.equals(isCorporateGateway, that.isCorporateGateway)
        && Objects.equals(corporateGatewayType, that.corporateGatewayType)
        && Objects.equals(corporateGatewayProviderName, that.corporateGatewayProviderName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        threatScore,
        isTor,
        isProxy,
        proxyProviderNames,
        proxyConfidenceScore,
        proxyLastSeen,
        isResidentialProxy,
        isVpn,
        vpnProviderNames,
        vpnConfidenceScore,
        vpnLastSeen,
        isRelay,
        relayProviderName,
        isAnonymous,
        isKnownAttacker,
        isBot,
        isSpam,
        isCloudProvider,
        cloudProviderName,
        proxyDaysSeen30d,
        proxyDaysSeen7d,
        proxyProviderCount30d,
        botConfidenceScore,
        botOperatorName,
        botType,
        isKnownGoodBot,
        botLastSeen,
        isCorporateGateway,
        corporateGatewayType,
        corporateGatewayProviderName);
  }

  @Override
  public String toString() {
    return "Security{threatScore="
        + threatScore
        + ", isTor="
        + isTor
        + ", isProxy="
        + isProxy
        + ", proxyProviderNames="
        + proxyProviderNames
        + ", proxyConfidenceScore="
        + proxyConfidenceScore
        + ", proxyLastSeen='"
        + proxyLastSeen
        + "', isResidentialProxy="
        + isResidentialProxy
        + ", isVpn="
        + isVpn
        + ", vpnProviderNames="
        + vpnProviderNames
        + ", vpnConfidenceScore="
        + vpnConfidenceScore
        + ", vpnLastSeen='"
        + vpnLastSeen
        + "', isRelay="
        + isRelay
        + ", relayProviderName='"
        + relayProviderName
        + "', isAnonymous="
        + isAnonymous
        + ", isKnownAttacker="
        + isKnownAttacker
        + ", isBot="
        + isBot
        + ", isSpam="
        + isSpam
        + ", isCloudProvider="
        + isCloudProvider
        + ", cloudProviderName='"
        + cloudProviderName
        + "', proxyDaysSeen30d="
        + proxyDaysSeen30d
        + ", proxyDaysSeen7d="
        + proxyDaysSeen7d
        + ", proxyProviderCount30d="
        + proxyProviderCount30d
        + ", botConfidenceScore="
        + botConfidenceScore
        + ", botOperatorName="
        + botOperatorName
        + ", botType="
        + botType
        + ", isKnownGoodBot="
        + isKnownGoodBot
        + ", botLastSeen="
        + botLastSeen
        + ", isCorporateGateway="
        + isCorporateGateway
        + ", corporateGatewayType="
        + corporateGatewayType
        + ", corporateGatewayProviderName="
        + corporateGatewayProviderName
        + "}";
  }
}
