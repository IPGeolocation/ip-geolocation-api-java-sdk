package io.ipgeolocation.sdk.internal;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import org.junit.jupiter.api.Test;

class SdkVersionTest {

  @Test
  void resolveVersionPrefersImplementationVersion() {
    assertThat(SdkVersion.resolveVersion(" 3.0.1 ", "3.0.0")).isEqualTo("3.0.1");
  }

  @Test
  void resolveVersionFallsBackToFilteredResourceVersion() {
    assertThat(SdkVersion.resolveVersion(" ", " 3.0.0 ")).isEqualTo("3.0.0");
  }

  @Test
  void resolveVersionFallsBackToUnknownWhenMetadataIsMissingOrPlaceholder() {
    assertThat(SdkVersion.resolveVersion(null, null)).isEqualTo("unknown");
    assertThat(SdkVersion.resolveVersion("", "${project.version}")).isEqualTo("unknown");
  }

  @Test
  void readVersionPropertyReturnsNullWhenResourceIsMissing() throws IOException {
    assertThat(SdkVersion.readVersionProperty(null)).isNull();
  }

  @Test
  void readVersionPropertyReadsVersionFromPropertiesContent() throws IOException {
    ByteArrayInputStream inputStream =
        new ByteArrayInputStream("version=3.0.0\n".getBytes(StandardCharsets.UTF_8));

    assertThat(SdkVersion.readVersionProperty(inputStream)).isEqualTo("3.0.0");
  }

  @Test
  void detectImplementationVersionReturnsNullWhenPackageIsMissing() {
    assertThat(SdkVersion.detectImplementationVersion(null)).isNull();
  }

  @Test
  void detectImplementationVersionTrimsPackageMetadata() {
    assertThat(SdkVersion.detectImplementationVersion(packageWithImplementationVersion(" 3.0.0-test ")))
        .isEqualTo("3.0.0-test");
  }

  @Test
  void loadResourceVersionReturnsNullWhenStreamIsMissing() {
    assertThat(
            SdkVersion.loadResourceVersion(
                new SdkVersion.ResourceStreamSupplier() {
                  @Override
                  public InputStream get() {
                    return null;
                  }
                }))
        .isNull();
  }

  @Test
  void loadResourceVersionReadsVersionFromProperties() {
    assertThat(
            SdkVersion.loadResourceVersion(
                new SdkVersion.ResourceStreamSupplier() {
                  @Override
                  public InputStream get() {
                    return new ByteArrayInputStream(
                        "version=3.0.0\n".getBytes(StandardCharsets.UTF_8));
                  }
                }))
        .isEqualTo("3.0.0");
  }

  @Test
  void loadResourceVersionReturnsNullWhenSupplierThrows() {
    assertThat(
            SdkVersion.loadResourceVersion(
                new SdkVersion.ResourceStreamSupplier() {
                  @Override
                  public InputStream get() throws IOException {
                    throw new IOException("forced read failure");
                  }
                }))
        .isNull();
  }

  @Test
  void userAgentReturnsResolvedSdkPrefix() {
    assertThat(SdkVersion.userAgent()).startsWith("ipgeolocation-java-sdk/").doesNotContain("${");
  }

  private static Package packageWithImplementationVersion(String implementationVersion) {
    return new PackageFactory().create(implementationVersion);
  }

  private static final class PackageFactory extends ClassLoader {
    private Package create(String implementationVersion) {
      return definePackage(
          "io.ipgeolocation.sdk.internal.testmeta." + System.nanoTime(),
          null,
          null,
          null,
          null,
          implementationVersion,
          null,
          null);
    }
  }
}
