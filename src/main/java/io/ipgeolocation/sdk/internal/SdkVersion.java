package io.ipgeolocation.sdk.internal;

import io.ipgeolocation.sdk.IpGeolocationClient;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class SdkVersion {
  private static final String VERSION_RESOURCE = "/io/ipgeolocation/sdk-version.properties";
  private static final String VERSION_KEY = "version";
  private static final String USER_AGENT_PREFIX = "ipgeolocation-java-sdk/";
  private static final String FALLBACK_VERSION = "unknown";

  private SdkVersion() {}

  public static String userAgent() {
    return USER_AGENT_PREFIX + resolveVersion(detectImplementationVersion(), loadResourceVersion());
  }

  static String resolveVersion(String implementationVersion, String resourceVersion) {
    if (isResolvedVersion(implementationVersion)) {
      return implementationVersion.trim();
    }

    if (isResolvedVersion(resourceVersion)) {
      return resourceVersion.trim();
    }

    return FALLBACK_VERSION;
  }

  static String readVersionProperty(InputStream inputStream) throws IOException {
    if (inputStream == null) {
      return null;
    }

    Properties properties = new Properties();
    properties.load(inputStream);
    return properties.getProperty(VERSION_KEY);
  }

  static String detectImplementationVersion(Package sdkPackage) {
    if (sdkPackage != null) {
      String implementationVersion = sdkPackage.getImplementationVersion();
      return implementationVersion == null ? null : implementationVersion.trim();
    }
    return null;
  }

  static String loadResourceVersion(ResourceStreamSupplier resourceStreamSupplier) {
    try (InputStream inputStream = resourceStreamSupplier.get()) {
      return readVersionProperty(inputStream);
    } catch (IOException ignored) {
      return null;
    }
  }

  private static String detectImplementationVersion() {
    return detectImplementationVersion(IpGeolocationClient.class.getPackage());
  }

  private static String loadResourceVersion() {
    return loadResourceVersion(
        new ResourceStreamSupplier() {
          @Override
          public InputStream get() {
            return SdkVersion.class.getResourceAsStream(VERSION_RESOURCE);
          }
        });
  }

  private static boolean isResolvedVersion(String version) {
    return !Compat.isBlank(version) && !version.contains("${");
  }

  interface ResourceStreamSupplier {
    InputStream get() throws IOException;
  }
}
