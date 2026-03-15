package io.ipgeolocation.sdk.internal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public final class JavaNetHttpExecutor implements HttpExecutor {
  private static final int DEFAULT_MAX_RESPONSE_BODY_CHARS = 128 * 1024 * 1024;

  private final int connectTimeoutMillis;
  private final int maxResponseBodyChars;
  private final ConnectionFactory connectionFactory;

  public JavaNetHttpExecutor(Duration connectTimeout) {
    this(connectTimeout, DEFAULT_MAX_RESPONSE_BODY_CHARS, new DefaultConnectionFactory());
  }

  JavaNetHttpExecutor(Duration connectTimeout, ConnectionFactory connectionFactory) {
    this(connectTimeout, DEFAULT_MAX_RESPONSE_BODY_CHARS, connectionFactory);
  }

  JavaNetHttpExecutor(
      Duration connectTimeout,
      int maxResponseBodyChars,
      ConnectionFactory connectionFactory) {
    Objects.requireNonNull(connectTimeout, "connectTimeout must not be null");
    if (connectTimeout.isNegative() || connectTimeout.isZero()) {
      throw new IllegalArgumentException("connectTimeout must be greater than zero");
    }
    if (maxResponseBodyChars <= 0) {
      throw new IllegalArgumentException("maxResponseBodyChars must be greater than zero");
    }
    this.connectTimeoutMillis = toMillis(connectTimeout);
    this.maxResponseBodyChars = maxResponseBodyChars;
    this.connectionFactory =
        Objects.requireNonNull(connectionFactory, "connectionFactory must not be null");
  }

  @Override
  public HttpResponseData send(HttpRequestData request) throws IOException {
    HttpURLConnection connection = connectionFactory.open(request.uri());
    try {
      connection.setConnectTimeout(connectTimeoutMillis);
      connection.setReadTimeout(toMillis(request.timeout()));
      connection.setRequestMethod(request.method());
      applyHeaders(connection, request.headers());
      writeBodyIfPresent(connection, request);
      int statusCode = connection.getResponseCode();
      return new HttpResponseData(
          statusCode, readBody(connection, statusCode), connection.getHeaderFields());
    } finally {
      connection.disconnect();
    }
  }

  private void applyHeaders(HttpURLConnection connection, Map<String, List<String>> headers) {
    for (Map.Entry<String, List<String>> entry : headers.entrySet()) {
      if (entry.getKey() == null || entry.getValue() == null) {
        continue;
      }
      for (String value : entry.getValue()) {
        if (value != null) {
          connection.addRequestProperty(entry.getKey(), value);
        }
      }
    }
  }

  private void writeBodyIfPresent(HttpURLConnection connection, HttpRequestData request)
      throws IOException {
    if (!"POST".equalsIgnoreCase(request.method()) && !"PUT".equalsIgnoreCase(request.method())) {
      return;
    }
    byte[] payload = request.body().getBytes(StandardCharsets.UTF_8);
    connection.setDoOutput(true);
    if (connection.getRequestProperty("Content-Length") == null) {
      connection.setFixedLengthStreamingMode(payload.length);
    }
    OutputStream outputStream = connection.getOutputStream();
    try {
      outputStream.write(payload);
      outputStream.flush();
    } finally {
      outputStream.close();
    }
  }

  private String readBody(HttpURLConnection connection, int statusCode) throws IOException {
    InputStream stream =
        statusCode >= 400 ? connection.getErrorStream() : connection.getInputStream();
    if (stream == null) {
      return "";
    }
    BufferedReader reader =
        new BufferedReader(new InputStreamReader(stream, StandardCharsets.UTF_8));
    try {
      StringBuilder body = new StringBuilder();
      char[] buffer = new char[2048];
      int read;
      int totalChars = 0;
      while ((read = reader.read(buffer)) != -1) {
        totalChars += read;
        if (totalChars > maxResponseBodyChars) {
          throw new IOException(
              "Response body exceeded max size of " + maxResponseBodyChars + " characters");
        }
        body.append(buffer, 0, read);
      }
      return body.toString();
    } finally {
      reader.close();
    }
  }

  private static int toMillis(Duration duration) {
    long millis = duration.toMillis();
    if (millis > Integer.MAX_VALUE) {
      return Integer.MAX_VALUE;
    }
    return (int) millis;
  }

  interface ConnectionFactory {
    HttpURLConnection open(URI uri) throws IOException;
  }

  private static final class DefaultConnectionFactory implements ConnectionFactory {
    @Override
    public HttpURLConnection open(URI uri) throws IOException {
      return (HttpURLConnection) uri.toURL().openConnection();
    }
  }
}
