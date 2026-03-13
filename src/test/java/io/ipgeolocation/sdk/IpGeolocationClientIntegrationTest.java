package io.ipgeolocation.sdk;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.sun.net.httpserver.HttpServer;
import io.ipgeolocation.sdk.exceptions.UnauthorizedException;
import io.ipgeolocation.sdk.exceptions.ValidationException;
import io.ipgeolocation.sdk.model.BulkLookupError;
import io.ipgeolocation.sdk.model.BulkLookupResult;
import io.ipgeolocation.sdk.model.BulkLookupSuccess;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.List;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;

class IpGeolocationClientIntegrationTest {

  @Test
  void performsLookupAgainstLocalHttpServer() throws IOException {
    HttpServer server = createServerOrSkip();
    if (server == null) {
      return;
    }

    server.createContext(
        "/v3/ipgeo",
        exchange -> {
          String query = exchange.getRequestURI().getQuery();
          if (query == null || !query.contains("apiKey=local-key")) {
            exchange.sendResponseHeaders(401, 0);
            exchange.close();
            return;
          }

          byte[] body = "{\"ip\":\"8.8.8.8\"}".getBytes(StandardCharsets.UTF_8);
          exchange.getResponseHeaders().add("Content-Type", "application/json");
          exchange.getResponseHeaders().add("X-Credits-Charged", "1");
          exchange.sendResponseHeaders(200, body.length);
          try (OutputStream os = exchange.getResponseBody()) {
            os.write(body);
          }
        });
    server.start();

    try {
      IpGeolocationClient client = buildClient(server);

      ApiResponse<io.ipgeolocation.sdk.model.IpGeolocationResponse> response =
          client.lookupIpGeolocation(LookupIpGeolocationRequest.builder().build());

      assertThat(response.data().ip()).isEqualTo("8.8.8.8");
      assertThat(response.metadata().creditsCharged()).isEqualTo(1);
    } finally {
      server.stop(0);
    }
  }

  @Test
  void performsBulkLookupAgainstLocalHttpServer() throws IOException {
    HttpServer server = createServerOrSkip();
    if (server == null) {
      return;
    }

    server.createContext(
        "/v3/ipgeo-bulk",
        exchange -> {
          String query = exchange.getRequestURI().getQuery();
          String body = new String(exchange.getRequestBody().readAllBytes(), StandardCharsets.UTF_8);
          if (query == null || !query.contains("apiKey=local-key") || !body.contains("\"ips\"")) {
            exchange.sendResponseHeaders(400, 0);
            exchange.close();
            return;
          }

          byte[] responseBody =
              """
              [
                {"ip":"8.8.8.8"},
                {"message":"'invalid-ip' is invalid."}
              ]
              """
                  .getBytes(StandardCharsets.UTF_8);

          exchange.getResponseHeaders().add("Content-Type", "application/json");
          exchange.getResponseHeaders().add("X-Credits-Charged", "2");
          exchange.getResponseHeaders().add("X-Successful-Record", "1");
          exchange.sendResponseHeaders(200, responseBody.length);
          try (OutputStream os = exchange.getResponseBody()) {
            os.write(responseBody);
          }
        });
    server.start();

    try {
      IpGeolocationClient client = buildClient(server);
      ApiResponse<List<BulkLookupResult>> response =
          client.bulkLookupIpGeolocation(
              BulkLookupIpGeolocationRequest.builder()
                  .addIp("8.8.8.8")
                  .addIp("invalid-ip")
                  .build());

      assertThat(response.data()).hasSize(2);
      assertThat(response.data().get(0)).isInstanceOf(BulkLookupSuccess.class);
      assertThat(response.data().get(1)).isInstanceOf(BulkLookupError.class);
      assertThat(response.metadata().creditsCharged()).isEqualTo(2);
      assertThat(response.metadata().successfulRecords()).isEqualTo(1);
      assertThat(response.metadata().firstHeaderValue("X-Credits-Charged")).isEqualTo("2");
    } finally {
      server.stop(0);
    }
  }

  @Test
  void rejectsXmlOutputForSingleAndBulkTypedMethods() throws IOException {
    HttpServer server = createServerOrSkip();
    if (server == null) {
      return;
    }
    server.start();

    try {
      IpGeolocationClient client = buildClient(server);

      assertThatThrownBy(
              () ->
                  client.lookupIpGeolocation(
                      LookupIpGeolocationRequest.builder()
                          .ip("8.8.8.8")
                          .output(ResponseFormat.XML)
                          .build()))
          .isInstanceOf(ValidationException.class)
          .hasMessageContaining("XML output is not supported");

      assertThatThrownBy(
              () ->
                  client.bulkLookupIpGeolocation(
                      BulkLookupIpGeolocationRequest.builder()
                          .addIp("8.8.8.8")
                          .output(ResponseFormat.XML)
                          .build()))
          .isInstanceOf(ValidationException.class)
          .hasMessageContaining("XML output is not supported");
    } finally {
      server.stop(0);
    }
  }

  @Test
  void mapsNon2xxFromLocalHttpServerToTypedException() throws IOException {
    HttpServer server = createServerOrSkip();
    if (server == null) {
      return;
    }

    server.createContext(
        "/v3/ipgeo",
        exchange -> {
          byte[] body = "{\"message\":\"invalid key\"}".getBytes(StandardCharsets.UTF_8);
          exchange.getResponseHeaders().add("Content-Type", "application/json");
          exchange.sendResponseHeaders(401, body.length);
          try (OutputStream os = exchange.getResponseBody()) {
            os.write(body);
          }
        });
    server.start();

    try {
      IpGeolocationClient client = buildClient(server);

      assertThatThrownBy(
              () -> client.lookupIpGeolocation(LookupIpGeolocationRequest.builder().ip("8.8.8.8").build()))
          .isInstanceOfSatisfying(
              UnauthorizedException.class,
              ex -> {
                assertThat(ex.statusCode()).isEqualTo(401);
                assertThat(ex.apiMessage()).isEqualTo("invalid key");
              });
    } finally {
      server.stop(0);
    }
  }

  @Test
  void supportsXmlOutputOnRawMethods() throws IOException {
    HttpServer server = createServerOrSkip();
    if (server == null) {
      return;
    }

    server.createContext(
        "/v3/ipgeo",
        exchange -> {
          String query = exchange.getRequestURI().getQuery();
          if (query == null || !query.contains("output=xml")) {
            exchange.sendResponseHeaders(400, 0);
            exchange.close();
            return;
          }
          byte[] body = "<ipgeo><ip>8.8.8.8</ip></ipgeo>".getBytes(StandardCharsets.UTF_8);
          exchange.getResponseHeaders().add("Content-Type", "application/xml");
          exchange.getResponseHeaders().add("X-Credits-Charged", "1");
          exchange.sendResponseHeaders(200, body.length);
          try (OutputStream os = exchange.getResponseBody()) {
            os.write(body);
          }
        });

    server.createContext(
        "/v3/ipgeo-bulk",
        exchange -> {
          String query = exchange.getRequestURI().getQuery();
          if (query == null || !query.contains("output=xml")) {
            exchange.sendResponseHeaders(400, 0);
            exchange.close();
            return;
          }
          byte[] body =
              "<items><item><ip>8.8.8.8</ip></item><item><message>invalid</message></item></items>"
                  .getBytes(StandardCharsets.UTF_8);
          exchange.getResponseHeaders().add("Content-Type", "application/xml");
          exchange.getResponseHeaders().add("X-Credits-Charged", "2");
          exchange.sendResponseHeaders(200, body.length);
          try (OutputStream os = exchange.getResponseBody()) {
            os.write(body);
          }
        });
    server.start();

    try {
      IpGeolocationClient client = buildClient(server);

      ApiResponse<String> single =
          client.lookupIpGeolocationRaw(
              LookupIpGeolocationRequest.builder()
                  .ip("8.8.8.8")
                  .output(ResponseFormat.XML)
                  .build());
      assertThat(single.data()).contains("<ipgeo>").contains("<ip>8.8.8.8</ip>");
      assertThat(single.metadata().creditsCharged()).isEqualTo(1);

      ApiResponse<String> bulk =
          client.bulkLookupIpGeolocationRaw(
              BulkLookupIpGeolocationRequest.builder()
                  .addIp("8.8.8.8")
                  .output(ResponseFormat.XML)
                  .build());
      assertThat(bulk.data()).contains("<items>").contains("<message>invalid</message>");
      assertThat(bulk.metadata().creditsCharged()).isEqualTo(2);
    } finally {
      server.stop(0);
    }
  }

  private HttpServer createServerOrSkip() throws IOException {
    try {
      return HttpServer.create(new InetSocketAddress(0), 0);
    } catch (SocketException e) {
      Assumptions.assumeTrue(false, "Local TCP bind is unavailable");
      return null;
    }
  }

  private IpGeolocationClient buildClient(HttpServer server) {
    String baseUrl = "http://127.0.0.1:" + server.getAddress().getPort();
    return new IpGeolocationClient(
        IpGeolocationClientConfig.builder("local-key")
            .baseUrl(baseUrl)
            .connectTimeout(Duration.ofSeconds(2))
            .readTimeout(Duration.ofSeconds(5))
            .build());
  }
}
