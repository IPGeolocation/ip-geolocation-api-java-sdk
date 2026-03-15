package io.ipgeolocation.sdk.internal;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import io.ipgeolocation.sdk.ApiResponse;
import io.ipgeolocation.sdk.ApiResponseMetadata;
import io.ipgeolocation.sdk.model.Abuse;
import io.ipgeolocation.sdk.model.Asn;
import io.ipgeolocation.sdk.model.BulkGeolocationRequestBody;
import io.ipgeolocation.sdk.model.BulkLookupError;
import io.ipgeolocation.sdk.model.BulkLookupSuccess;
import io.ipgeolocation.sdk.model.Company;
import io.ipgeolocation.sdk.model.CountryMetadata;
import io.ipgeolocation.sdk.model.Currency;
import io.ipgeolocation.sdk.model.DstTransition;
import io.ipgeolocation.sdk.model.ErrorResponse;
import io.ipgeolocation.sdk.model.IpGeolocationResponse;
import io.ipgeolocation.sdk.model.Location;
import io.ipgeolocation.sdk.model.Network;
import io.ipgeolocation.sdk.model.Security;
import io.ipgeolocation.sdk.model.TimeZoneInfo;
import io.ipgeolocation.sdk.model.UserAgent;
import io.ipgeolocation.sdk.model.UserAgentDevice;
import io.ipgeolocation.sdk.model.UserAgentEngine;
import io.ipgeolocation.sdk.model.UserAgentOperatingSystem;

public final class ObjectMapperFactory {
  private ObjectMapperFactory() {}

  public static ObjectMapper create() {
    ObjectMapper mapper = new ObjectMapper();
    mapper.registerModule(new JavaTimeModule());
    mapper.setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE);
    registerFieldVisibilityMixIns(mapper);
    mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    mapper.configure(DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_USING_DEFAULT_VALUE, true);
    return mapper;
  }

  private static void registerFieldVisibilityMixIns(ObjectMapper mapper) {
    mapper.addMixIn(ApiResponse.class, FieldVisibilityMixIn.class);
    mapper.addMixIn(ApiResponseMetadata.class, FieldVisibilityMixIn.class);
    mapper.addMixIn(Abuse.class, FieldVisibilityMixIn.class);
    mapper.addMixIn(Asn.class, FieldVisibilityMixIn.class);
    mapper.addMixIn(BulkGeolocationRequestBody.class, FieldVisibilityMixIn.class);
    mapper.addMixIn(BulkLookupError.class, FieldVisibilityMixIn.class);
    mapper.addMixIn(BulkLookupSuccess.class, FieldVisibilityMixIn.class);
    mapper.addMixIn(Company.class, FieldVisibilityMixIn.class);
    mapper.addMixIn(CountryMetadata.class, FieldVisibilityMixIn.class);
    mapper.addMixIn(Currency.class, FieldVisibilityMixIn.class);
    mapper.addMixIn(DstTransition.class, FieldVisibilityMixIn.class);
    mapper.addMixIn(ErrorResponse.class, FieldVisibilityMixIn.class);
    mapper.addMixIn(IpGeolocationResponse.class, FieldVisibilityMixIn.class);
    mapper.addMixIn(Location.class, FieldVisibilityMixIn.class);
    mapper.addMixIn(Location.Confidence.class, FieldVisibilityMixIn.class);
    mapper.addMixIn(Network.class, FieldVisibilityMixIn.class);
    mapper.addMixIn(Security.class, FieldVisibilityMixIn.class);
    mapper.addMixIn(TimeZoneInfo.class, FieldVisibilityMixIn.class);
    mapper.addMixIn(UserAgent.class, FieldVisibilityMixIn.class);
    mapper.addMixIn(UserAgentDevice.class, FieldVisibilityMixIn.class);
    mapper.addMixIn(UserAgentEngine.class, FieldVisibilityMixIn.class);
    mapper.addMixIn(UserAgentOperatingSystem.class, FieldVisibilityMixIn.class);
  }

  @JsonAutoDetect(
      fieldVisibility = JsonAutoDetect.Visibility.ANY,
      getterVisibility = JsonAutoDetect.Visibility.NONE,
      isGetterVisibility = JsonAutoDetect.Visibility.NONE)
  private abstract static class FieldVisibilityMixIn {}
}
