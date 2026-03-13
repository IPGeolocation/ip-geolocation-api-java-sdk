package io.ipgeolocation.sdk.model;

import java.util.List;

/**
 * Wire body sent to bulk lookup endpoint.
 *
 * @param ips list of IP/domain values to resolve
 */
public record BulkGeolocationRequestBody(List<String> ips) {}
