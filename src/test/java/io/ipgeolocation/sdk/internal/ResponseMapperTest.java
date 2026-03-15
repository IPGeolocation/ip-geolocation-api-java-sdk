package io.ipgeolocation.sdk.internal;

import static org.assertj.core.api.Assertions.assertThat;
import static io.ipgeolocation.sdk.TestSupport.list;

import io.ipgeolocation.sdk.ApiResponseMetadata;
import io.ipgeolocation.sdk.exceptions.ApiException;
import io.ipgeolocation.sdk.exceptions.ServerErrorException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

class ResponseMapperTest {

  @Test
  void genericApiExceptionHandlesBlankBody() {
    ResponseMapper mapper = new ResponseMapper(ObjectMapperFactory.create());

    ApiException exception = mapper.toApiException(418, "");

    assertThat(exception.statusCode()).isEqualTo(418);
    assertThat(exception.apiMessage()).isNull();
    assertThat(exception.getMessage()).isEqualTo("API request failed with HTTP status 418");
  }

  @Test
  void metadataParsingHandlesInvalidAndMissingHeaderValues() {
    ResponseMapper mapper = new ResponseMapper(ObjectMapperFactory.create());
    Map<String, List<String>> rawHeaders = new LinkedHashMap<>();
    rawHeaders.put(null, list("ignored"));
    rawHeaders.put("X-Credits-Charged", null);
    rawHeaders.put("X-Successful-Record", list("7"));
    rawHeaders.put("X-Trace-Id", list());

    ApiResponseMetadata metadata =
        mapper.toMetadata(200, 15L, rawHeaders);

    assertThat(metadata.creditsCharged()).isNull();
    assertThat(metadata.successfulRecords()).isEqualTo(7);
    assertThat(metadata.statusCode()).isEqualTo(200);
    assertThat(metadata.durationMs()).isEqualTo(15L);
    assertThat(metadata.rawHeaders()).containsKeys("X-Credits-Charged", "X-Successful-Record", "X-Trace-Id");
  }

  @Test
  void serverErrorsMapToTypedServerException() {
    ResponseMapper mapper = new ResponseMapper(ObjectMapperFactory.create());

    ApiException exception = mapper.toApiException(502, "{\"message\":\"upstream\"}");

    assertThat(exception).isInstanceOf(ServerErrorException.class);
    assertThat(exception.apiMessage()).isEqualTo("upstream");
  }

  @Test
  void nullBodyAndNullHeaderMapsAreHandled() {
    ResponseMapper mapper = new ResponseMapper(ObjectMapperFactory.create());

    ApiException exception = mapper.toApiException(400, null);
    ApiResponseMetadata metadata = mapper.toMetadata(200, 0L, null);

    assertThat(exception.apiMessage()).isNull();
    assertThat(metadata.creditsCharged()).isNull();
    assertThat(metadata.successfulRecords()).isNull();
    assertThat(metadata.rawHeaders()).isEmpty();
  }
}
