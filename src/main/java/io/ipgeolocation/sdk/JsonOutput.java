package io.ipgeolocation.sdk;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.ipgeolocation.sdk.exceptions.SerializationException;
import io.ipgeolocation.sdk.internal.ObjectMapperFactory;
import java.util.Objects;

/**
 * Utility for serializing SDK objects into JSON.
 *
 * <p>Default mode is {@link JsonOutputMode#COMPACT}, which omits null-valued fields.
 */
public final class JsonOutput {
  private static final ObjectMapper FULL_MAPPER = ObjectMapperFactory.create();
  private static final ObjectMapper COMPACT_MAPPER = createCompactMapper();

  private JsonOutput() {}

  /**
   * Serializes a value as JSON using compact mode.
   *
   * @param value object to serialize; may be {@code null}
   * @return JSON string
   * @throws SerializationException when serialization fails
   */
  public static String toJson(Object value) {
    return toJson(value, JsonOutputMode.COMPACT);
  }

  /**
   * Serializes a value as JSON with explicit null-output mode.
   *
   * @param value object to serialize; may be {@code null}
   * @param mode compact or full mode
   * @return JSON string
   * @throws NullPointerException when mode is null
   * @throws SerializationException when serialization fails
   */
  public static String toJson(Object value, JsonOutputMode mode) {
    return write(value, mode, false);
  }

  /**
   * Serializes a value as pretty JSON using compact mode.
   *
   * @param value object to serialize; may be {@code null}
   * @return pretty JSON string
   * @throws SerializationException when serialization fails
   */
  public static String toPrettyJson(Object value) {
    return toPrettyJson(value, JsonOutputMode.COMPACT);
  }

  /**
   * Serializes a value as pretty JSON with explicit null-output mode.
   *
   * @param value object to serialize; may be {@code null}
   * @param mode compact or full mode
   * @return pretty JSON string
   * @throws NullPointerException when mode is null
   * @throws SerializationException when serialization fails
   */
  public static String toPrettyJson(Object value, JsonOutputMode mode) {
    return write(value, mode, true);
  }

  private static ObjectMapper createCompactMapper() {
    ObjectMapper mapper = ObjectMapperFactory.create();
    mapper.setDefaultPropertyInclusion(JsonInclude.Include.NON_NULL);
    return mapper;
  }

  private static String write(Object value, JsonOutputMode mode, boolean pretty) {
    Objects.requireNonNull(mode, "mode must not be null");
    ObjectMapper mapper = mode == JsonOutputMode.FULL ? FULL_MAPPER : COMPACT_MAPPER;
    try {
      return pretty
          ? mapper.writerWithDefaultPrettyPrinter().writeValueAsString(value)
          : mapper.writeValueAsString(value);
    } catch (JsonProcessingException e) {
      throw new SerializationException("Failed to serialize output as JSON", e);
    }
  }
}
