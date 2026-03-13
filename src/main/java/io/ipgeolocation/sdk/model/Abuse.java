package io.ipgeolocation.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

/**
 * Abuse-contact data associated with the resolved IP/network.
 *
 * @param route routed prefix for the reporting network
 * @param country country tied to the abuse contact
 * @param name abuse contact name
 * @param organization abuse contact organization
 * @param kind abuse contact kind/category
 * @param address abuse contact address
 * @param emails abuse contact email addresses
 * @param phoneNumbers abuse contact phone numbers
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record Abuse(
    String route,
    String country,
    String name,
    String organization,
    String kind,
    String address,
    List<String> emails,
    List<String> phoneNumbers) {}
