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


public class SecurityBulkPost200ResponseInner1 extends AbstractSchema {
    private static final Logger log = Logger.getLogger(SecurityBulkPost200ResponseInner1.class.getName());

    public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
        @SuppressWarnings("unchecked")
        @Override
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
            if (!SecurityBulkPost200ResponseInner1.class.isAssignableFrom(type.getRawType())) {
                return null; // this class only serializes 'SecurityBulkPost200ResponseInner1' and its subtypes
            }
            final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
            final TypeAdapter<SecurityAPIXMLResponseArray> adapterSecurityAPIXMLResponseArray = gson.getDelegateAdapter(this, TypeToken.get(SecurityAPIXMLResponseArray.class));
            final TypeAdapter<ErrorXMLResponseArray> adapterErrorXMLResponseArray = gson.getDelegateAdapter(this, TypeToken.get(ErrorXMLResponseArray.class));

            return (TypeAdapter<T>) new TypeAdapter<SecurityBulkPost200ResponseInner1>() {
                @Override
                public void write(JsonWriter out, SecurityBulkPost200ResponseInner1 value) throws IOException {
                    if (value == null || value.getActualInstance() == null) {
                        elementAdapter.write(out, null);
                        return;
                    }

                    // check if the actual instance is of the type `SecurityAPIXMLResponseArray`
                    if (value.getActualInstance() instanceof SecurityAPIXMLResponseArray) {
                        JsonElement element = adapterSecurityAPIXMLResponseArray.toJsonTree((SecurityAPIXMLResponseArray)value.getActualInstance());
                        elementAdapter.write(out, element);
                        return;
                    }
                    // check if the actual instance is of the type `ErrorXMLResponseArray`
                    if (value.getActualInstance() instanceof ErrorXMLResponseArray) {
                        JsonElement element = adapterErrorXMLResponseArray.toJsonTree((ErrorXMLResponseArray)value.getActualInstance());
                        elementAdapter.write(out, element);
                        return;
                    }
                    throw new IOException("Failed to serialize as the type doesn't match oneOf schemas: ErrorXMLResponseArray, SecurityAPIXMLResponseArray");
                }

                @Override
                public SecurityBulkPost200ResponseInner1 read(JsonReader in) throws IOException {
                    Object deserialized = null;
                    JsonElement jsonElement = elementAdapter.read(in);

                    int match = 0;
                    ArrayList<String> errorMessages = new ArrayList<>();
                    TypeAdapter actualAdapter = elementAdapter;

                    // deserialize SecurityAPIXMLResponseArray
                    try {
                        // validate the JSON object to see if any exception is thrown
                        SecurityAPIXMLResponseArray.validateJsonElement(jsonElement);
                        actualAdapter = adapterSecurityAPIXMLResponseArray;
                        match++;
                        log.log(Level.FINER, "Input data matches schema 'SecurityAPIXMLResponseArray'");
                    } catch (Exception e) {
                        // deserialization failed, continue
                        errorMessages.add(String.format("Deserialization for SecurityAPIXMLResponseArray failed with `%s`.", e.getMessage()));
                        log.log(Level.FINER, "Input data does not match schema 'SecurityAPIXMLResponseArray'", e);
                    }
                    // deserialize ErrorXMLResponseArray
                    try {
                        // validate the JSON object to see if any exception is thrown
                        ErrorXMLResponseArray.validateJsonElement(jsonElement);
                        actualAdapter = adapterErrorXMLResponseArray;
                        match++;
                        log.log(Level.FINER, "Input data matches schema 'ErrorXMLResponseArray'");
                    } catch (Exception e) {
                        // deserialization failed, continue
                        errorMessages.add(String.format("Deserialization for ErrorXMLResponseArray failed with `%s`.", e.getMessage()));
                        log.log(Level.FINER, "Input data does not match schema 'ErrorXMLResponseArray'", e);
                    }

                    if (match == 1) {
                        SecurityBulkPost200ResponseInner1 ret = new SecurityBulkPost200ResponseInner1();
                        ret.setActualInstance(actualAdapter.fromJsonTree(jsonElement));
                        return ret;
                    }

                    throw new IOException(String.format("Failed deserialization for SecurityBulkPost200ResponseInner1: %d classes match result, expected 1. Detailed failure message for oneOf schemas: %s. JSON: %s", match, errorMessages, jsonElement.toString()));
                }
            }.nullSafe();
        }
    }

    // store a list of schema names defined in oneOf
    public static final Map<String, Class<?>> schemas = new HashMap<String, Class<?>>();

    public SecurityBulkPost200ResponseInner1() {
        super("oneOf", Boolean.FALSE);
    }

    public SecurityBulkPost200ResponseInner1(Object o) {
        super("oneOf", Boolean.FALSE);
        setActualInstance(o);
    }

    static {
        schemas.put("SecurityAPIXMLResponseArray", SecurityAPIXMLResponseArray.class);
        schemas.put("ErrorXMLResponseArray", ErrorXMLResponseArray.class);
    }

    @Override
    public Map<String, Class<?>> getSchemas() {
        return SecurityBulkPost200ResponseInner1.schemas;
    }

    /**
     * Set the instance that matches the oneOf child schema, check
     * the instance parameter is valid against the oneOf child schemas:
     * ErrorXMLResponseArray, SecurityAPIXMLResponseArray
     *
     * It could be an instance of the 'oneOf' schemas.
     */
    @Override
    public void setActualInstance(Object instance) {
        if (instance instanceof SecurityAPIXMLResponseArray) {
            super.setActualInstance(instance);
            return;
        }

        if (instance instanceof ErrorXMLResponseArray) {
            super.setActualInstance(instance);
            return;
        }

        throw new RuntimeException("Invalid instance type. Must be ErrorXMLResponseArray, SecurityAPIXMLResponseArray");
    }

    /**
     * Get the actual instance, which can be the following:
     * ErrorXMLResponseArray, SecurityAPIXMLResponseArray
     *
     * @return The actual instance (ErrorXMLResponseArray, SecurityAPIXMLResponseArray)
     */
    @SuppressWarnings("unchecked")
    @Override
    public Object getActualInstance() {
        return super.getActualInstance();
    }

    /**
     * Get the actual instance of `SecurityAPIXMLResponseArray`. If the actual instance is not `SecurityAPIXMLResponseArray`,
     * the ClassCastException will be thrown.
     *
     * @return The actual instance of `SecurityAPIXMLResponseArray`
     * @throws ClassCastException if the instance is not `SecurityAPIXMLResponseArray`
     */
    public SecurityAPIXMLResponseArray getSecurityAPIXMLResponseArray() throws ClassCastException {
        return (SecurityAPIXMLResponseArray)super.getActualInstance();
    }

    /**
     * Get the actual instance of `ErrorXMLResponseArray`. If the actual instance is not `ErrorXMLResponseArray`,
     * the ClassCastException will be thrown.
     *
     * @return The actual instance of `ErrorXMLResponseArray`
     * @throws ClassCastException if the instance is not `ErrorXMLResponseArray`
     */
    public ErrorXMLResponseArray getErrorXMLResponseArray() throws ClassCastException {
        return (ErrorXMLResponseArray)super.getActualInstance();
    }

    /**
     * Validates the JSON Element and throws an exception if issues found
     *
     * @param jsonElement JSON Element
     * @throws IOException if the JSON Element is invalid with respect to SecurityBulkPost200ResponseInner1
     */
    public static void validateJsonElement(JsonElement jsonElement) throws IOException {
        // validate oneOf schemas one by one
        int validCount = 0;
        ArrayList<String> errorMessages = new ArrayList<>();
        // validate the json string with SecurityAPIXMLResponseArray
        try {
            SecurityAPIXMLResponseArray.validateJsonElement(jsonElement);
            validCount++;
        } catch (Exception e) {
            errorMessages.add(String.format("Deserialization for SecurityAPIXMLResponseArray failed with `%s`.", e.getMessage()));
            // continue to the next one
        }
        // validate the json string with ErrorXMLResponseArray
        try {
            ErrorXMLResponseArray.validateJsonElement(jsonElement);
            validCount++;
        } catch (Exception e) {
            errorMessages.add(String.format("Deserialization for ErrorXMLResponseArray failed with `%s`.", e.getMessage()));
            // continue to the next one
        }
        if (validCount != 1) {
            throw new IOException(String.format("The JSON string is invalid for SecurityBulkPost200ResponseInner1 with oneOf schemas: ErrorXMLResponseArray, SecurityAPIXMLResponseArray. %d class(es) match the result, expected 1. Detailed failure message for oneOf schemas: %s. JSON: %s", validCount, errorMessages, jsonElement.toString()));
        }
    }

    /**
     * Create an instance of SecurityBulkPost200ResponseInner1 given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of SecurityBulkPost200ResponseInner1
     * @throws IOException if the JSON string is invalid with respect to SecurityBulkPost200ResponseInner1
     */
    public static SecurityBulkPost200ResponseInner1 fromJson(String jsonString) throws IOException {
        return JSON.getGson().fromJson(jsonString, SecurityBulkPost200ResponseInner1.class);
    }

    /**
     * Convert an instance of SecurityBulkPost200ResponseInner1 to an JSON string
     *
     * @return JSON string
     */
    public String toJson() {
        return JSON.getGson().toJson(this);
    }
}

