package io.ipgeolocation.sdk.internal;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import java.io.IOException;
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
}
