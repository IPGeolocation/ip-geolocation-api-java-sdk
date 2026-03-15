package io.ipgeolocation.sdk.model;

import static org.assertj.core.api.Assertions.assertThat;

import io.ipgeolocation.sdk.TestSupport;
import org.junit.jupiter.api.Test;

class ModelRecordSmokeTest {

  @Test
  void coreModelRecordsCanBeConstructed() {
    Abuse abuse =
        new Abuse(
            "192.0.2.0/24",
            "US",
            "Abuse Desk",
            "Example ISP",
            "abuse",
            "Street 1",
            TestSupport.list("abuse@example.com"),
            TestSupport.list("+1-555-0101"));
    Asn asn = new Asn("AS15169", "Example ASN", "US", "isp", "example.com", "2020-01-01", "ARIN");
    Company company = new Company("Example Inc", "hosting", "example.com");
    Currency currency = new Currency("USD", "US Dollar", "$");
    DstTransition dstTransition =
        new DstTransition("2026-03-08T07:00:00Z", "PT1H", true, "03:00", "02:00", false);
    Network network = new Network("wired", "192.0.2.0/24", false);
    Security security =
        new Security(
            0.1d,
            false,
            false,
            TestSupport.list(),
            0.0d,
            null,
            false,
            false,
            TestSupport.list(),
            0.0d,
            null,
            false,
            null,
            false,
            false,
            false,
            false,
            false,
            null);
    UserAgentDevice device = new UserAgentDevice("Pixel", "mobile", "Google", "arm64");
    UserAgentEngine engine = new UserAgentEngine("Blink", "browser", "126.0", "126");
    UserAgentOperatingSystem os =
        new UserAgentOperatingSystem("Android", "mobile", "14", "14", "UP1A");
    UserAgent userAgent = new UserAgent("ua", "Chrome", "browser", "126.0", "126", device, engine, os);

    assertThat(abuse.emails()).containsExactly("abuse@example.com");
    assertThat(asn.asNumber()).isEqualTo("AS15169");
    assertThat(company.domain()).isEqualTo("example.com");
    assertThat(currency.code()).isEqualTo("USD");
    assertThat(dstTransition.gap()).isTrue();
    assertThat(network.route()).isEqualTo("192.0.2.0/24");
    assertThat(security.isVpn()).isFalse();
    assertThat(userAgent.device()).isEqualTo(device);
  }

  @Test
  void bulkResultSuccessFlagsAreAccurate() {
    IpGeolocationResponse response =
        new IpGeolocationResponse(
            "8.8.8.8",
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null);

    BulkLookupSuccess success = new BulkLookupSuccess(response);
    BulkLookupError error = new BulkLookupError("failed");

    assertThat(success.success()).isTrue();
    assertThat(error.success()).isFalse();
  }
}
