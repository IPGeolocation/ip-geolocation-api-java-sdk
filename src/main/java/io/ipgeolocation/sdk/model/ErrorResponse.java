package io.ipgeolocation.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * Error payload with a message field returned by the API.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public final class ErrorResponse {
  private final String message;

  @JsonCreator
  public ErrorResponse(@JsonProperty("message") String message) {
    this.message = message;
  }

  public String message() {
    return message;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) {
      return true;
    }
    if (!(other instanceof ErrorResponse)) {
      return false;
    }
    ErrorResponse that = (ErrorResponse) other;
    return Objects.equals(message, that.message);
  }

  @Override
  public int hashCode() {
    return Objects.hash(message);
  }

  @Override
  public String toString() {
    return "ErrorResponse{message='" + message + "'}";
  }
}
