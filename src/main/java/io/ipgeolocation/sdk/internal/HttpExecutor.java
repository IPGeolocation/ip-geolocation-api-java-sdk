package io.ipgeolocation.sdk.internal;

import java.io.IOException;

public interface HttpExecutor {
  HttpResponseData send(HttpRequestData request) throws IOException, InterruptedException;
}
