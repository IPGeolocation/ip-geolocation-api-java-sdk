package io.ipgeolocation.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * Company details associated with the IP address.
 *
 * <p>This is the company or organization attribution returned by the API for the resolved IP.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public final class Company {
  private final String name;
  private final String type;
  private final String domain;

  @JsonCreator
  public Company(
      @JsonProperty("name") String name,
      @JsonProperty("type") String type,
      @JsonProperty("domain") String domain) {
    this.name = name;
    this.type = type;
    this.domain = domain;
  }

  public String name() {
    return name;
  }

  public String type() {
    return type;
  }

  public String domain() {
    return domain;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) {
      return true;
    }
    if (!(other instanceof Company)) {
      return false;
    }
    Company that = (Company) other;
    return Objects.equals(name, that.name)
        && Objects.equals(type, that.type)
        && Objects.equals(domain, that.domain);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, type, domain);
  }

  @Override
  public String toString() {
    return "Company{name='" + name + "', type='" + type + "', domain='" + domain + "'}";
  }
}
