package io.ipgeolocation.sdk;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import io.ipgeolocation.sdk.exceptions.SerializationException;
import io.ipgeolocation.sdk.model.CountryMetadata;
import io.ipgeolocation.sdk.model.IpGeolocationResponse;
import io.ipgeolocation.sdk.model.Location;
import java.util.LinkedHashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

class JsonOutputTest {

  @Test
  void compactModeOmitsNullFields() {
    IpGeolocationResponse response = sampleResponse();

    String json = JsonOutput.toJson(response, JsonOutputMode.COMPACT);

    assertThat(json).contains("\"ip\":\"8.8.8.8\"");
    assertThat(json).contains("\"country_name\":\"United States\"");
    assertThat(json).contains("\"country_metadata\":");
    assertThat(json).doesNotContain("\"security\":null");
    assertThat(json).doesNotContain("\"domain\":null");
  }

  @Test
  void fullModeIncludesNullFields() {
    IpGeolocationResponse response = sampleResponse();

    String json = JsonOutput.toJson(response, JsonOutputMode.FULL);

    assertThat(json).contains("\"ip\":\"8.8.8.8\"");
    assertThat(json).contains("\"security\":null");
    assertThat(json).contains("\"domain\":null");
    assertThat(json).contains("\"time_zone\":null");
  }

  @Test
  void prettyJsonUsesCompactByDefault() {
    IpGeolocationResponse response = sampleResponse();

    String json = JsonOutput.toPrettyJson(response);

    assertThat(json).contains("\n");
    assertThat(json).doesNotContain("\"security\" : null");
  }

  @Test
  void toJsonUsesCompactByDefault() {
    IpGeolocationResponse response = sampleResponse();

    String json = JsonOutput.toJson(response);

    assertThat(json).contains("\"ip\":\"8.8.8.8\"");
    assertThat(json).doesNotContain("\"security\":null");
  }

  @Test
  void nullModeIsRejected() {
    assertThatThrownBy(() -> JsonOutput.toJson(sampleResponse(), null))
        .isInstanceOf(NullPointerException.class)
        .hasMessageContaining("mode must not be null");
  }

  @Test
  void nullValueIsSerializedAsJsonNull() {
    assertThat(JsonOutput.toJson(null)).isEqualTo("null");
    assertThat(JsonOutput.toJson(null, JsonOutputMode.FULL)).isEqualTo("null");
    assertThat(JsonOutput.toPrettyJson(null).trim()).isEqualTo("null");
  }

  @Test
  void serializationFailureIsMappedToSerializationException() {
    Map<String, Object> recursive = new LinkedHashMap<>();
    recursive.put("self", recursive);

    assertThatThrownBy(() -> JsonOutput.toJson(recursive))
        .isInstanceOf(SerializationException.class)
        .hasMessageContaining("Failed to serialize output as JSON");
  }

  @Test
  void genericObjectsDoNotExposePrivateFieldsWithoutAccessors() {
    assertThatThrownBy(() -> JsonOutput.toJson(new PrivatePojo(), JsonOutputMode.FULL))
        .isInstanceOf(SerializationException.class)
        .hasMessageContaining("Failed to serialize output as JSON");
  }

  private IpGeolocationResponse sampleResponse() {
    Location location =
        new Location(
            null,
            null,
            null,
            null,
            "United States",
            null,
            null,
            null,
            null,
            null,
            "Mountain View",
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null);

    CountryMetadata countryMetadata = new CountryMetadata("+1", ".us", TestSupport.list("en-US"));

    return new IpGeolocationResponse(
        "8.8.8.8",
        null,
        null,
        location,
        countryMetadata,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null);
  }

  private static final class PrivatePojo {
    private final String secret = "should-not-leak";
  }
}
