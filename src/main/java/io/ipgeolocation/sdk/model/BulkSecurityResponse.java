/*
 * IPGeolocation.io - IP intelligence products
 * Ipgeolocation provides a set of APIs to make ip based decisions.
 */


package io.ipgeolocation.sdk.model;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;


import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.JsonElement;

import io.ipgeolocation.sdk.invoker.JSON;


public class BulkSecurityResponse extends AbstractSchema {
    private static final Logger log = Logger.getLogger(BulkSecurityResponse.class.getName());

    public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
        @SuppressWarnings("unchecked")
        @Override
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
            if (!BulkSecurityResponse.class.isAssignableFrom(type.getRawType())) {
                return null; // this class only serializes 'SecurityBulkPost200ResponseInner' and its subtypes
            }
            final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
            final TypeAdapter<SecurityAPIResponse> adapterSecurityAPIResponse = gson.getDelegateAdapter(this, TypeToken.get(SecurityAPIResponse.class));
            final TypeAdapter<ErrorResponse> adapterErrorResponse = gson.getDelegateAdapter(this, TypeToken.get(ErrorResponse.class));

            return (TypeAdapter<T>) new TypeAdapter<BulkSecurityResponse>() {
                @Override
                public void write(JsonWriter out, BulkSecurityResponse value) throws IOException {
                    if (value == null || value.getActualInstance() == null) {
                        elementAdapter.write(out, null);
                        return;
                    }

                    // check if the actual instance is of the type `SecurityAPIResponse`
                    if (value.getActualInstance() instanceof SecurityAPIResponse) {
                        JsonElement element = adapterSecurityAPIResponse.toJsonTree((SecurityAPIResponse)value.getActualInstance());
                        elementAdapter.write(out, element);
                        return;
                    }
                    // check if the actual instance is of the type `ErrorResponse`
                    if (value.getActualInstance() instanceof ErrorResponse) {
                        JsonElement element = adapterErrorResponse.toJsonTree((ErrorResponse)value.getActualInstance());
                        elementAdapter.write(out, element);
                        return;
                    }
                    throw new IOException("Failed to serialize as the type doesn't match oneOf schemas: ErrorResponse, SecurityAPIResponse");
                }

                @Override
                public BulkSecurityResponse read(JsonReader in) throws IOException {
                    Object deserialized = null;
                    JsonElement jsonElement = elementAdapter.read(in);

                    int match = 0;
                    ArrayList<String> errorMessages = new ArrayList<>();
                    TypeAdapter actualAdapter = elementAdapter;

                    // deserialize SecurityAPIResponse
                    try {
                        // validate the JSON object to see if any exception is thrown
                        SecurityAPIResponse.validateJsonElement(jsonElement);
                        actualAdapter = adapterSecurityAPIResponse;
                        match++;
                        log.log(Level.FINER, "Input data matches schema 'SecurityAPIResponse'");
                    } catch (Exception e) {
                        // deserialization failed, continue
                        errorMessages.add(String.format("Deserialization for SecurityAPIResponse failed with `%s`.", e.getMessage()));
                        log.log(Level.FINER, "Input data does not match schema 'SecurityAPIResponse'", e);
                    }
                    // deserialize ErrorResponse
                    try {
                        // validate the JSON object to see if any exception is thrown
                        ErrorResponse.validateJsonElement(jsonElement);
                        actualAdapter = adapterErrorResponse;
                        match++;
                        log.log(Level.FINER, "Input data matches schema 'ErrorResponse'");
                    } catch (Exception e) {
                        // deserialization failed, continue
                        errorMessages.add(String.format("Deserialization for ErrorResponse failed with `%s`.", e.getMessage()));
                        log.log(Level.FINER, "Input data does not match schema 'ErrorResponse'", e);
                    }

                    if (match == 1) {
                        BulkSecurityResponse ret = new BulkSecurityResponse();
                        ret.setActualInstance(actualAdapter.fromJsonTree(jsonElement));
                        return ret;
                    }

                    throw new IOException(String.format("Failed deserialization for SecurityBulkPost200ResponseInner: %d classes match result, expected 1. Detailed failure message for oneOf schemas: %s. JSON: %s", match, errorMessages, jsonElement.toString()));
                }
            }.nullSafe();
        }
    }

    // store a list of schema names defined in oneOf
    public static final Map<String, Class<?>> schemas = new HashMap<String, Class<?>>();

    public BulkSecurityResponse() {
        super("oneOf", Boolean.FALSE);
    }

    public BulkSecurityResponse(Object o) {
        super("oneOf", Boolean.FALSE);
        setActualInstance(o);
    }

    static {
        schemas.put("SecurityAPIResponse", SecurityAPIResponse.class);
        schemas.put("ErrorResponse", ErrorResponse.class);
    }

    @Override
    public Map<String, Class<?>> getSchemas() {
        return BulkSecurityResponse.schemas;
    }

    /**
     * Set the instance that matches the oneOf child schema, check
     * the instance parameter is valid against the oneOf child schemas:
     * ErrorResponse, SecurityAPIResponse
     *
     * It could be an instance of the 'oneOf' schemas.
     */
    @Override
    public void setActualInstance(Object instance) {
        if (instance instanceof SecurityAPIResponse) {
            super.setActualInstance(instance);
            return;
        }

        if (instance instanceof ErrorResponse) {
            super.setActualInstance(instance);
            return;
        }

        throw new RuntimeException("Invalid instance type. Must be ErrorResponse, SecurityAPIResponse");
    }

    /**
     * Get the actual instance, which can be the following:
     * ErrorResponse, SecurityAPIResponse
     *
     * @return The actual instance (ErrorResponse, SecurityAPIResponse)
     */
    @SuppressWarnings("unchecked")
    @Override
    public Object getActualInstance() {
        return super.getActualInstance();
    }

    /**
     * Get the actual instance of `SecurityAPIResponse`. If the actual instance is not `SecurityAPIResponse`,
     * the ClassCastException will be thrown.
     *
     * @return The actual instance of `SecurityAPIResponse`
     * @throws ClassCastException if the instance is not `SecurityAPIResponse`
     */
    public SecurityAPIResponse getSecurityAPIResponse() throws ClassCastException {
        return (SecurityAPIResponse)super.getActualInstance();
    }

    /**
     * Get the actual instance of `ErrorResponse`. If the actual instance is not `ErrorResponse`,
     * the ClassCastException will be thrown.
     *
     * @return The actual instance of `ErrorResponse`
     * @throws ClassCastException if the instance is not `ErrorResponse`
     */
    public ErrorResponse getErrorResponse() throws ClassCastException {
        return (ErrorResponse)super.getActualInstance();
    }

    /**
     * Validates the JSON Element and throws an exception if issues found
     *
     * @param jsonElement JSON Element
     * @throws IOException if the JSON Element is invalid with respect to SecurityBulkPost200ResponseInner
     */
    public static void validateJsonElement(JsonElement jsonElement) throws IOException {
        // validate oneOf schemas one by one
        int validCount = 0;
        ArrayList<String> errorMessages = new ArrayList<>();
        // validate the json string with SecurityAPIResponse
        try {
            SecurityAPIResponse.validateJsonElement(jsonElement);
            validCount++;
        } catch (Exception e) {
            errorMessages.add(String.format("Deserialization for SecurityAPIResponse failed with `%s`.", e.getMessage()));
            // continue to the next one
        }
        // validate the json string with ErrorResponse
        try {
            ErrorResponse.validateJsonElement(jsonElement);
            validCount++;
        } catch (Exception e) {
            errorMessages.add(String.format("Deserialization for ErrorResponse failed with `%s`.", e.getMessage()));
            // continue to the next one
        }
        if (validCount != 1) {
            throw new IOException(String.format("The JSON string is invalid for SecurityBulkPost200ResponseInner with oneOf schemas: ErrorResponse, SecurityAPIResponse. %d class(es) match the result, expected 1. Detailed failure message for oneOf schemas: %s. JSON: %s", validCount, errorMessages, jsonElement.toString()));
        }
    }

    /**
     * Create an instance of SecurityBulkPost200ResponseInner given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of SecurityBulkPost200ResponseInner
     * @throws IOException if the JSON string is invalid with respect to SecurityBulkPost200ResponseInner
     */
    public static BulkSecurityResponse fromJson(String jsonString) throws IOException {
        return JSON.getGson().fromJson(jsonString, BulkSecurityResponse.class);
    }

    /**
     * Convert an instance of SecurityBulkPost200ResponseInner to an JSON string
     *
     * @return JSON string
     */
    public String toJson() {
        return JSON.getGson().toJson(this);
    }
}

