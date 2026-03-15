package io.ipgeolocation.sdk;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import io.ipgeolocation.sdk.exceptions.BadRequestException;
import io.ipgeolocation.sdk.exceptions.ValidationException;
import io.ipgeolocation.sdk.internal.ObjectMapperFactory;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Test;

class IpGeolocationClientCoverageTest {

  @Test
  void rawSingleLookupMapsNon2xxResponses() {
    TestHttpExecutor executor = new TestHttpExecutor();
    executor.enqueueResponse(400, "{\"message\":\"invalid request\"}");

    IpGeolocationClient client = newClient(executor);

    assertThatThrownBy(
            () -> client.lookupIpGeolocationRaw(LookupIpGeolocationRequest.builder().build()))
        .isInstanceOf(BadRequestException.class)
        .hasMessageContaining("invalid request");
  }

  @Test
  void typedBulkLookupMapsNon2xxResponses() {
    TestHttpExecutor executor = new TestHttpExecutor();
    executor.enqueueResponse(400, "{\"message\":\"bulk request failed\"}");

    IpGeolocationClient client = newClient(executor);

    assertThatThrownBy(
            () ->
                client.bulkLookupIpGeolocation(
                    BulkLookupIpGeolocationRequest.builder().addIp("8.8.8.8").build()))
        .isInstanceOf(BadRequestException.class)
        .hasMessageContaining("bulk request failed");
  }

  @Test
  void rawBulkLookupMapsNon2xxResponses() {
    TestHttpExecutor executor = new TestHttpExecutor();
    executor.enqueueResponse(400, "{\"message\":\"bulk raw failed\"}");

    IpGeolocationClient client = newClient(executor);

    assertThatThrownBy(
            () ->
                client.bulkLookupIpGeolocationRaw(
                    BulkLookupIpGeolocationRequest.builder().addIp("8.8.8.8").build()))
        .isInstanceOf(BadRequestException.class)
        .hasMessageContaining("bulk raw failed");
  }

  @Test
  void privateHelpersHandleNullFormatsAndNullCsvLists() throws Exception {
    IpGeolocationClient client = newClient(new TestHttpExecutor());

    assertThat(invokeResolveFormat(client, null)).isEqualTo(ResponseFormat.JSON);
    assertThat(invokeJoinCsv(client, null)).isNull();
  }

  @Test
  void reflectiveInvalidBulkRequestsStillTripClientValidation() throws Exception {
    IpGeolocationClient client = newClient(new TestHttpExecutor());

    assertThatThrownBy(
            () -> invokeValidateBulkRequestBase(client, reflectiveBulkRequest(Collections.<String>emptyList())))
        .isInstanceOf(ValidationException.class)
        .hasMessageContaining("ips must not be empty");

    List<String> tooManyIps = new ArrayList<String>(Collections.nCopies(50_001, "8.8.8.8"));
    assertThatThrownBy(() -> invokeValidateBulkRequestBase(client, reflectiveBulkRequest(tooManyIps)))
        .isInstanceOf(ValidationException.class)
        .hasMessageContaining("at most 50000");
  }

  private static IpGeolocationClient newClient(TestHttpExecutor executor) {
    return new IpGeolocationClient(
        IpGeolocationClientConfig.builder("coverage-key").build(),
        executor,
        ObjectMapperFactory.create());
  }

  private static ResponseFormat invokeResolveFormat(
      IpGeolocationClient client, ResponseFormat output) throws Exception {
    Method method = IpGeolocationClient.class.getDeclaredMethod("resolveFormat", ResponseFormat.class);
    method.setAccessible(true);
    return (ResponseFormat) method.invoke(client, output);
  }

  private static String invokeJoinCsv(IpGeolocationClient client, List<String> values) throws Exception {
    Method method = IpGeolocationClient.class.getDeclaredMethod("joinCsv", List.class);
    method.setAccessible(true);
    return (String) method.invoke(client, values);
  }

  private static void invokeValidateBulkRequestBase(
      IpGeolocationClient client, BulkLookupIpGeolocationRequest request) throws Exception {
    Method method =
        IpGeolocationClient.class.getDeclaredMethod(
            "validateBulkRequestBase", BulkLookupIpGeolocationRequest.class);
    method.setAccessible(true);
    try {
      method.invoke(client, request);
    } catch (java.lang.reflect.InvocationTargetException e) {
      throw (Exception) e.getTargetException();
    }
  }

  private static BulkLookupIpGeolocationRequest reflectiveBulkRequest(List<String> ips) throws Exception {
    BulkLookupIpGeolocationRequest.Builder builder = BulkLookupIpGeolocationRequest.builder();
    Field ipsField = BulkLookupIpGeolocationRequest.Builder.class.getDeclaredField("ips");
    ipsField.setAccessible(true);
    @SuppressWarnings("unchecked")
    List<String> builderIps = (List<String>) ipsField.get(builder);
    builderIps.clear();
    builderIps.addAll(ips);

    Constructor<BulkLookupIpGeolocationRequest> constructor =
        BulkLookupIpGeolocationRequest.class.getDeclaredConstructor(
            BulkLookupIpGeolocationRequest.Builder.class);
    constructor.setAccessible(true);
    return constructor.newInstance(builder);
  }
}
