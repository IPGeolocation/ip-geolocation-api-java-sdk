package io.ipgeolocation.sdk.internal;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.time.Duration;

public final class JavaNetHttpExecutor implements HttpExecutor {
  private final HttpClient httpClient;

  public JavaNetHttpExecutor(HttpClient httpClient) {
    this.httpClient = httpClient;
  }

  @Override
  public HttpResponseData send(HttpRequest request, Duration timeout)
      throws IOException, InterruptedException {
    HttpResponse<String> response =
        httpClient.send(request, HttpResponse.BodyHandlers.ofString(StandardCharsets.UTF_8));
    return new HttpResponseData(response.statusCode(), response.body(), response.headers().map());
  }
}
