package io.ipgeolocation.sdk;

import io.ipgeolocation.sdk.internal.HttpExecutor;
import io.ipgeolocation.sdk.internal.HttpResponseData;
import java.io.IOException;
import java.net.http.HttpRequest;
import java.time.Duration;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

final class TestHttpExecutor implements HttpExecutor {
  private final Queue<Object> scripted = new ArrayDeque<>();
  private final List<HttpRequest> capturedRequests = new ArrayList<>();
  private final List<Duration> capturedTimeouts = new ArrayList<>();

  void enqueueResponse(int statusCode, String body) {
    enqueueResponse(statusCode, body, Map.of());
  }

  void enqueueResponse(int statusCode, String body, Map<String, List<String>> headers) {
    scripted.add(new HttpResponseData(statusCode, body, headers));
  }

  void enqueueIOException(IOException exception) {
    scripted.add(exception);
  }

  void enqueueInterruptedException(InterruptedException exception) {
    scripted.add(exception);
  }

  List<HttpRequest> capturedRequests() {
    return capturedRequests;
  }

  List<Duration> capturedTimeouts() {
    return capturedTimeouts;
  }

  @Override
  public HttpResponseData send(HttpRequest request, Duration timeout)
      throws IOException, InterruptedException {
    capturedRequests.add(request);
    capturedTimeouts.add(timeout);
    if (scripted.isEmpty()) {
      throw new IllegalStateException("No scripted response configured");
    }
    Object next = scripted.remove();
    if (next instanceof IOException e) {
      throw e;
    }
    if (next instanceof InterruptedException e) {
      throw e;
    }
    return (HttpResponseData) next;
  }
}
