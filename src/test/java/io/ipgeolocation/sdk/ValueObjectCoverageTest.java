package io.ipgeolocation.sdk;

import static org.assertj.core.api.Assertions.assertThat;

import io.ipgeolocation.sdk.internal.HttpRequestData;
import io.ipgeolocation.sdk.internal.HttpResponseData;
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
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.net.URI;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

class ValueObjectCoverageTest {

  @Test
  void valueObjectsSupportAccessorsEqualityHashCodeAndToString() throws Exception {
    for (Class<?> type : coveredTypes()) {
      assertValueObjectContract(type);
    }
  }

  private static List<Class<?>> coveredTypes() {
    return Arrays.<Class<?>>asList(
        ApiResponse.class,
        ApiResponseMetadata.class,
        HttpRequestData.class,
        HttpResponseData.class,
        Abuse.class,
        Asn.class,
        BulkGeolocationRequestBody.class,
        BulkLookupError.class,
        BulkLookupSuccess.class,
        Company.class,
        CountryMetadata.class,
        Currency.class,
        DstTransition.class,
        ErrorResponse.class,
        IpGeolocationResponse.class,
        Location.class,
        Network.class,
        Security.class,
        TimeZoneInfo.class,
        UserAgent.class,
        UserAgentDevice.class,
        UserAgentEngine.class,
        UserAgentOperatingSystem.class);
  }

  private void assertValueObjectContract(Class<?> type) throws Exception {
    if (type.isEnum()) {
      assertEnumContract(type);
      return;
    }

    Object sample = newInstance(type, 1);

    invokeAccessors(sample);

    assertThat(sample).as(type.getSimpleName()).isEqualTo(sample);
    assertThat(sample).as(type.getSimpleName()).isNotEqualTo(null);
    assertThat(sample).as(type.getSimpleName()).isNotEqualTo("other");
    assertThat(sample.toString()).as(type.getSimpleName()).isNotBlank();

    if (!hasDeclaredValueSemantics(type)) {
      return;
    }

    Object equal = newInstance(type, 1);
    assertThat(sample).as(type.getSimpleName()).isEqualTo(equal);
    assertThat(sample.hashCode()).as(type.getSimpleName()).isEqualTo(equal.hashCode());

    Constructor<?> constructor = constructorFor(type);
    Class<?>[] parameterTypes = constructor.getParameterTypes();
    Object[] baseArgs = createArgs(parameterTypes, 1);

    for (int i = 0; i < parameterTypes.length; i++) {
      Object[] variantArgs = baseArgs.clone();
      variantArgs[i] = alternateValue(parameterTypes[i], baseArgs[i], i + 1);
      Object variant = constructor.newInstance(variantArgs);
      assertThat(sample)
          .as(type.getSimpleName() + " differs at constructor argument " + i)
          .isNotEqualTo(variant);
    }
  }

  private void assertEnumContract(Class<?> type) {
    Object[] constants = type.getEnumConstants();
    assertThat(constants).as(type.getSimpleName()).isNotEmpty();
    assertThat(constants[0]).as(type.getSimpleName()).isEqualTo(constants[0]);
    assertThat(constants[0]).as(type.getSimpleName()).isNotEqualTo(null);
    assertThat(constants[0]).as(type.getSimpleName()).isNotEqualTo("other");
    assertThat(constants[0].toString()).as(type.getSimpleName()).isNotBlank();
    if (constants.length > 1) {
      assertThat(constants[0]).as(type.getSimpleName()).isNotEqualTo(constants[1]);
    }
  }

  private boolean hasDeclaredValueSemantics(Class<?> type) throws Exception {
    return !Object.class.equals(type.getMethod("equals", Object.class).getDeclaringClass())
        && !Object.class.equals(type.getMethod("hashCode").getDeclaringClass());
  }

  private void invokeAccessors(Object value) throws Exception {
    for (Method method : value.getClass().getDeclaredMethods()) {
      if (!Modifier.isPublic(method.getModifiers()) || Modifier.isStatic(method.getModifiers())) {
        continue;
      }
      if (method.getParameterTypes().length != 0 || method.getReturnType() == Void.TYPE) {
        continue;
      }
      String name = method.getName();
      if ("wait".equals(name) || "notify".equals(name) || "notifyAll".equals(name)) {
        continue;
      }
      method.invoke(value);
    }
  }

  private Constructor<?> constructorFor(Class<?> type) {
    Constructor<?>[] constructors = type.getConstructors();
    if (constructors.length != 1) {
      throw new IllegalStateException("Expected exactly one public constructor for " + type);
    }
    return constructors[0];
  }

  private Object newInstance(Class<?> type, int seed) throws Exception {
    Constructor<?> constructor = constructorFor(type);
    return constructor.newInstance(createArgs(constructor.getParameterTypes(), seed));
  }

  private Object[] createArgs(Class<?>[] parameterTypes, int seed) throws Exception {
    Object[] args = new Object[parameterTypes.length];
    for (int i = 0; i < parameterTypes.length; i++) {
      args[i] = sampleValue(parameterTypes[i], seed + i);
    }
    return args;
  }

  private Object sampleValue(Class<?> type, int seed) throws Exception {
    if (type.isEnum()) {
      Object[] constants = type.getEnumConstants();
      return constants[Math.abs(seed) % constants.length];
    }
    if (type == Object.class) {
      return "value-" + seed;
    }
    if (type == String.class) {
      return "value-" + seed;
    }
    if (type == Integer.class || type == int.class) {
      return Integer.valueOf(200 + seed);
    }
    if (type == Long.class || type == long.class) {
      return Long.valueOf(seed);
    }
    if (type == Boolean.class || type == boolean.class) {
      return Boolean.valueOf(seed % 2 == 0);
    }
    if (type == Double.class || type == double.class) {
      return Double.valueOf(seed + 0.25d);
    }
    if (type == List.class) {
      return TestSupport.list("value-" + seed);
    }
    if (type == Map.class) {
      return TestSupport.headers("X-Seed", "value-" + seed);
    }
    if (type == URI.class) {
      return URI.create("https://example.com/" + seed);
    }
    if (type == Duration.class) {
      return Duration.ofMillis(seed + 1L);
    }
    if (type.getName().startsWith("io.ipgeolocation.sdk")) {
      return newInstance(type, seed + 10);
    }
    throw new IllegalArgumentException("Unsupported constructor parameter type: " + type);
  }

  private Object alternateValue(Class<?> type, Object originalValue, int seed) throws Exception {
    if (type.isEnum()) {
      Object[] constants = type.getEnumConstants();
      if (constants.length == 1) {
        return constants[0];
      }
      Object candidate = constants[(Math.abs(seed) + 1) % constants.length];
      return candidate.equals(originalValue) ? constants[0] : candidate;
    }
    if (type == Object.class) {
      return "alt-" + seed;
    }
    if (type == String.class) {
      return "alt-" + seed;
    }
    if (type == Integer.class || type == int.class) {
      return Integer.valueOf(500 + seed);
    }
    if (type == Long.class || type == long.class) {
      return Long.valueOf(10_000L + seed);
    }
    if (type == Boolean.class || type == boolean.class) {
      return Boolean.valueOf(!((Boolean) originalValue).booleanValue());
    }
    if (type == Double.class || type == double.class) {
      return Double.valueOf(1000.0d + seed);
    }
    if (type == List.class) {
      List<String> values = new ArrayList<String>();
      values.add("alt-" + seed);
      values.add("alt-" + seed + "-b");
      return values;
    }
    if (type == Map.class) {
      return TestSupport.headers("X-Alt", "value-" + seed);
    }
    if (type == URI.class) {
      return URI.create("https://alt.example.com/" + seed);
    }
    if (type == Duration.class) {
      return Duration.ofSeconds(seed + 1L);
    }
    if (type.getName().startsWith("io.ipgeolocation.sdk")) {
      return newInstance(type, seed + 100);
    }
    throw new IllegalArgumentException("Unsupported alternate constructor parameter type: " + type);
  }
}
