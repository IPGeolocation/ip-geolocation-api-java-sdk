package io.ipgeolocation.sdk.internal;

import java.io.IOException;

public final class ErrorSanitizer {
  private final String apiKey;
  private final String encodedApiKey;

  public ErrorSanitizer(String apiKey) {
    this.apiKey = apiKey;
    this.encodedApiKey = Compat.isBlank(apiKey) ? null : UriBuilder.encode(apiKey, "UTF-8");
  }

  public String message(String value) {
    if (value == null || encodedApiKey == null) {
      return value;
    }
    return value.replace(encodedApiKey, "[REDACTED]").replace(apiKey, "[REDACTED]");
  }

  public Throwable cause(Throwable error) {
    if (encodedApiKey == null) {
      return error;
    }
    IOException sanitized = new IOException(error.getClass().getName());
    sanitized.setStackTrace(error.getStackTrace());
    return sanitized;
  }
}
