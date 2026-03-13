package io.ipgeolocation.sdk.internal;

import java.io.IOException;
import java.net.http.HttpRequest;
import java.time.Duration;

public interface HttpExecutor {
  HttpResponseData send(HttpRequest request, Duration timeout) throws IOException, InterruptedException;
}
