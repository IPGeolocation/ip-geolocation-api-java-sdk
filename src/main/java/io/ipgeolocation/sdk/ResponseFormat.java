package io.ipgeolocation.sdk;

/**
 * Response format accepted by the IPGeolocation API query parameter {@code output}.
 */
public enum ResponseFormat {
  JSON("json"),
  XML("xml");

  private final String wireValue;

  ResponseFormat(String wireValue) {
    this.wireValue = wireValue;
  }

  /**
   * @return wire value sent to API query parameter {@code output}
   */
  public String wireValue() {
    return wireValue;
  }
}
