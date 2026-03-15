package io.ipgeolocation.sdk;

import io.ipgeolocation.sdk.internal.HttpExecutor;
import io.ipgeolocation.sdk.internal.HttpRequestData;
import io.ipgeolocation.sdk.internal.HttpResponseData;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Queue;

final class TestHttpExecutor implements HttpExecutor {
  private final Queue<Object> scripted = new ArrayDeque<>();
  private final List<HttpRequestData> capturedRequests = new ArrayList<>();
  private final List<Duration> capturedTimeouts = new ArrayList<>();

  void enqueueResponse(int statusCode, String body) {
    enqueueResponse(statusCode, body, Collections.<String, List<String>>emptyMap());
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

  List<HttpRequestData> capturedRequests() {
    return capturedRequests;
  }

  List<Duration> capturedTimeouts() {
    return capturedTimeouts;
  }

  @Override
  public HttpResponseData send(HttpRequestData request) throws IOException, InterruptedException {
    capturedRequests.add(request);
    capturedTimeouts.add(request.timeout());
    if (scripted.isEmpty()) {
      throw new IllegalStateException("No scripted response configured");
    }
    Object next = scripted.remove();
    if (next instanceof IOException) {
      throw (IOException) next;
    }
    if (next instanceof InterruptedException) {
      throw (InterruptedException) next;
    }
    return (HttpResponseData) next;
  }
}
