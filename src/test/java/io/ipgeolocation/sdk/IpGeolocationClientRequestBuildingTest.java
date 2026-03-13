package io.ipgeolocation.sdk;

import static org.assertj.core.api.Assertions.assertThat;

import io.ipgeolocation.sdk.internal.ObjectMapperFactory;
import java.net.URI;
import java.net.http.HttpRequest;
import java.time.Duration;
import org.junit.jupiter.api.Test;

class IpGeolocationClientRequestBuildingTest {

  @Test
  void lookupBuildsExpectedQueryAndHeaders() {
    TestHttpExecutor executor = new TestHttpExecutor();
    executor.enqueueResponse(200, """
        {"ip":"8.8.8.8"}
        """);

    IpGeolocationClientConfig config =
        IpGeolocationClientConfig.builder("test-key")
            .baseUrl("https://api.ipgeolocation.io/")
            .connectTimeout(Duration.ofSeconds(2))
            .readTimeout(Duration.ofSeconds(4))
            .build();

    IpGeolocationClient client =
        new IpGeolocationClient(config, executor, millis -> {}, ObjectMapperFactory.create());

    LookupIpGeolocationRequest request =
        LookupIpGeolocationRequest.builder()
            .ip("8.8.8.8")
            .lang(Language.EN)
            .include("security")
            .fields("location.city")
            .excludes("currency")
            .output(ResponseFormat.JSON)
            .build();

    client.lookupIpGeolocation(request);

    HttpRequest sent = executor.capturedRequests().getFirst();
    URI uri = sent.uri();
    assertThat(uri.getPath()).isEqualTo("/v3/ipgeo");
    assertThat(uri.getQuery()).contains("apiKey=test-key");
    assertThat(uri.getQuery()).contains("ip=8.8.8.8");
    assertThat(uri.getQuery()).contains("lang=en");
    assertThat(uri.getQuery()).contains("include=security");
    assertThat(uri.getQuery()).contains("fields=location.city");
    assertThat(uri.getQuery()).contains("excludes=currency");
    assertThat(uri.getQuery()).contains("output=json");
    assertThat(sent.headers().firstValue("User-Agent")).hasValue(IpGeolocationClient.defaultUserAgent());
    assertThat(sent.headers().firstValue("Accept")).hasValue("application/json");
    assertThat(sent.timeout()).contains(Duration.ofSeconds(4));
  }

  @Test
  void bulkLookupBuildsPayloadAndPath() {
    TestHttpExecutor executor = new TestHttpExecutor();
    executor.enqueueResponse(200, """
        [{"ip":"8.8.8.8"}]
        """);

    IpGeolocationClientConfig config = IpGeolocationClientConfig.builder("bulk-key").build();
    IpGeolocationClient client =
        new IpGeolocationClient(config, executor, millis -> {}, ObjectMapperFactory.create());

    BulkLookupIpGeolocationRequest request =
        BulkLookupIpGeolocationRequest.builder().addIp("8.8.8.8").addIp("1.1.1.1").build();

    client.bulkLookupIpGeolocation(request);

    HttpRequest sent = executor.capturedRequests().getFirst();
    assertThat(sent.uri().getPath()).isEqualTo("/v3/ipgeo-bulk");
    assertThat(sent.uri().getQuery()).contains("apiKey=bulk-key");
    assertThat(sent.headers().firstValue("Content-Type")).hasValue("application/json");
    assertThat(sent.headers().firstValue("Accept")).hasValue("application/json");
  }

  @Test
  void lookupOmitsApiKeyWhenConfigIsBuiltWithoutApiKey() {
    TestHttpExecutor executor = new TestHttpExecutor();
    executor.enqueueResponse(200, """
        {"ip":"8.8.8.8"}
        """);

    IpGeolocationClient client =
        new IpGeolocationClient(
            IpGeolocationClientConfig.builder().build(),
            executor,
            millis -> {},
            ObjectMapperFactory.create());

    client.lookupIpGeolocation(
        LookupIpGeolocationRequest.builder().ip("8.8.8.8").build());

    HttpRequest sent = executor.capturedRequests().getFirst();
    String query = sent.uri().getQuery();
    assertThat(query).doesNotContain("apiKey=");
  }

  @Test
  void bulkLookupIncludesOptionalQueryParamsWhenConfigured() {
    TestHttpExecutor executor = new TestHttpExecutor();
    executor.enqueueResponse(200, """
        [{"ip":"8.8.8.8"}]
        """);

    IpGeolocationClient client =
        new IpGeolocationClient(
            IpGeolocationClientConfig.builder("bulk-key").build(),
            executor,
            millis -> {},
            ObjectMapperFactory.create());

    client.bulkLookupIpGeolocation(
        BulkLookupIpGeolocationRequest.builder()
            .addIp("8.8.8.8")
            .lang(Language.DE)
            .include("hostname")
            .fields("location.city")
            .excludes("currency")
            .build());

    HttpRequest sent = executor.capturedRequests().getFirst();
    String query = sent.uri().getQuery();
    assertThat(query).contains("apiKey=bulk-key");
    assertThat(query).contains("lang=de");
    assertThat(query).contains("include=hostname");
    assertThat(query).contains("fields=location.city");
    assertThat(query).contains("excludes=currency");
  }

  @Test
  void lookupTreatsBlankIpAsOmittedAndDoesNotSendIpParam() {
    TestHttpExecutor executor = new TestHttpExecutor();
    executor.enqueueResponse(200, """
        {"ip":"1.2.3.4"}
        """);

    IpGeolocationClient client =
        new IpGeolocationClient(
            IpGeolocationClientConfig.builder("k").build(),
            executor,
            millis -> {},
            ObjectMapperFactory.create());

    client.lookupIpGeolocation(
        LookupIpGeolocationRequest.builder().ip("   ").build());

    HttpRequest sent = executor.capturedRequests().getFirst();
    assertThat(sent.uri().getQuery()).doesNotContain("ip=");
  }

  @Test
  void sdkManagedHeadersAreSetByDefault() {
    TestHttpExecutor executor = new TestHttpExecutor();
    executor.enqueueResponse(200, """
        {"ip":"8.8.8.8"}
        """);

    IpGeolocationClient client =
        new IpGeolocationClient(
            IpGeolocationClientConfig.builder("k").build(),
            executor,
            millis -> {},
            ObjectMapperFactory.create());

    client.lookupIpGeolocation(
        LookupIpGeolocationRequest.builder().ip("8.8.8.8").build());

    HttpRequest sent = executor.capturedRequests().getFirst();
    assertThat(sent.headers().firstValue("User-Agent")).hasValue(IpGeolocationClient.defaultUserAgent());
    assertThat(sent.headers().firstValue("Accept")).hasValue("application/json");
  }

  @Test
  void sdkDefaultUserAgentIncludesResolvedVersionMetadata() {
    assertThat(IpGeolocationClient.defaultUserAgent())
        .startsWith("ipgeolocation-java-sdk/")
        .doesNotContain("${")
        .isNotEqualTo("ipgeolocation-java-sdk/unknown");
  }

  @Test
  void lookupRequestUserAgentOverridesSdkDefaultUserAgent() {
    TestHttpExecutor executor = new TestHttpExecutor();
    executor.enqueueResponse(200, """
        {"ip":"8.8.8.8"}
        """);

    IpGeolocationClient client =
        new IpGeolocationClient(
            IpGeolocationClientConfig.builder("k").build(),
            executor,
            millis -> {},
            ObjectMapperFactory.create());

    client.lookupIpGeolocation(
        LookupIpGeolocationRequest.builder()
            .ip("8.8.8.8")
            .userAgent("python-requests/2.32.5")
            .build());

    HttpRequest sent = executor.capturedRequests().getFirst();
    assertThat(sent.headers().firstValue("User-Agent")).hasValue("python-requests/2.32.5");
  }

  @Test
  void bulkRequestUserAgentOverridesSdkDefaultUserAgent() {
    TestHttpExecutor executor = new TestHttpExecutor();
    executor.enqueueResponse(200, """
        [{"ip":"8.8.8.8"}]
        """);

    IpGeolocationClient client =
        new IpGeolocationClient(
            IpGeolocationClientConfig.builder("k").build(),
            executor,
            millis -> {},
            ObjectMapperFactory.create());

    client.bulkLookupIpGeolocation(
        BulkLookupIpGeolocationRequest.builder()
            .addIp("8.8.8.8")
            .userAgent("python-requests/2.32.5")
            .build());

    HttpRequest sent = executor.capturedRequests().getFirst();
    assertThat(sent.headers().firstValue("User-Agent")).hasValue("python-requests/2.32.5");
  }

  @Test
  void rawSingleLookupWithXmlSetsOutputAndAcceptHeaders() {
    TestHttpExecutor executor = new TestHttpExecutor();
    executor.enqueueResponse(200, "<ipgeo><ip>8.8.8.8</ip></ipgeo>");

    IpGeolocationClient client =
        new IpGeolocationClient(
            IpGeolocationClientConfig.builder("k").build(),
            executor,
            millis -> {},
            ObjectMapperFactory.create());

    client.lookupIpGeolocationRaw(
        LookupIpGeolocationRequest.builder()
            .ip("8.8.8.8")
            .output(ResponseFormat.XML)
            .build());

    HttpRequest sent = executor.capturedRequests().getFirst();
    assertThat(sent.uri().getQuery()).contains("output=xml");
    assertThat(sent.headers().firstValue("Accept")).hasValue("application/xml");
  }

  @Test
  void rawBulkLookupWithXmlSetsOutputAndAcceptHeaders() {
    TestHttpExecutor executor = new TestHttpExecutor();
    executor.enqueueResponse(200, "<items><item><ip>8.8.8.8</ip></item></items>");

    IpGeolocationClient client =
        new IpGeolocationClient(
            IpGeolocationClientConfig.builder("k").build(),
            executor,
            millis -> {},
            ObjectMapperFactory.create());

    client.bulkLookupIpGeolocationRaw(
        BulkLookupIpGeolocationRequest.builder()
            .addIp("8.8.8.8")
            .output(ResponseFormat.XML)
            .build());

    HttpRequest sent = executor.capturedRequests().getFirst();
    assertThat(sent.uri().getQuery()).contains("output=xml");
    assertThat(sent.headers().firstValue("Accept")).hasValue("application/xml");
  }
}
