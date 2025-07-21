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


public class IpgeoBulkPost200ResponseInner1 extends AbstractSchema {
    private static final Logger log = Logger.getLogger(IpgeoBulkPost200ResponseInner1.class.getName());

    public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
        @SuppressWarnings("unchecked")
        @Override
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
            if (!IpgeoBulkPost200ResponseInner1.class.isAssignableFrom(type.getRawType())) {
                return null; // this class only serializes 'IpgeoBulkPost200ResponseInner1' and its subtypes
            }
            final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
            final TypeAdapter<GeolocationXMLResponseArray> adapterGeolocationXMLResponseArray = gson.getDelegateAdapter(this, TypeToken.get(GeolocationXMLResponseArray.class));
            final TypeAdapter<ErrorXMLResponseArray> adapterErrorXMLResponseArray = gson.getDelegateAdapter(this, TypeToken.get(ErrorXMLResponseArray.class));

            return (TypeAdapter<T>) new TypeAdapter<IpgeoBulkPost200ResponseInner1>() {
                @Override
                public void write(JsonWriter out, IpgeoBulkPost200ResponseInner1 value) throws IOException {
                    if (value == null || value.getActualInstance() == null) {
                        elementAdapter.write(out, null);
                        return;
                    }

                    // check if the actual instance is of the type `GeolocationXMLResponseArray`
                    if (value.getActualInstance() instanceof GeolocationXMLResponseArray) {
                        JsonElement element = adapterGeolocationXMLResponseArray.toJsonTree((GeolocationXMLResponseArray)value.getActualInstance());
                        elementAdapter.write(out, element);
                        return;
                    }
                    // check if the actual instance is of the type `ErrorXMLResponseArray`
                    if (value.getActualInstance() instanceof ErrorXMLResponseArray) {
                        JsonElement element = adapterErrorXMLResponseArray.toJsonTree((ErrorXMLResponseArray)value.getActualInstance());
                        elementAdapter.write(out, element);
                        return;
                    }
                    throw new IOException("Failed to serialize as the type doesn't match oneOf schemas: ErrorXMLResponseArray, GeolocationXMLResponseArray");
                }

                @Override
                public IpgeoBulkPost200ResponseInner1 read(JsonReader in) throws IOException {
                    Object deserialized = null;
                    JsonElement jsonElement = elementAdapter.read(in);

                    int match = 0;
                    ArrayList<String> errorMessages = new ArrayList<>();
                    TypeAdapter actualAdapter = elementAdapter;

                    // deserialize GeolocationXMLResponseArray
                    try {
                        // validate the JSON object to see if any exception is thrown
                        GeolocationXMLResponseArray.validateJsonElement(jsonElement);
                        actualAdapter = adapterGeolocationXMLResponseArray;
                        match++;
                        log.log(Level.FINER, "Input data matches schema 'GeolocationXMLResponseArray'");
                    } catch (Exception e) {
                        // deserialization failed, continue
                        errorMessages.add(String.format("Deserialization for GeolocationXMLResponseArray failed with `%s`.", e.getMessage()));
                        log.log(Level.FINER, "Input data does not match schema 'GeolocationXMLResponseArray'", e);
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
                        IpgeoBulkPost200ResponseInner1 ret = new IpgeoBulkPost200ResponseInner1();
                        ret.setActualInstance(actualAdapter.fromJsonTree(jsonElement));
                        return ret;
                    }

                    throw new IOException(String.format("Failed deserialization for IpgeoBulkPost200ResponseInner1: %d classes match result, expected 1. Detailed failure message for oneOf schemas: %s. JSON: %s", match, errorMessages, jsonElement.toString()));
                }
            }.nullSafe();
        }
    }

    // store a list of schema names defined in oneOf
    public static final Map<String, Class<?>> schemas = new HashMap<String, Class<?>>();

    public IpgeoBulkPost200ResponseInner1() {
        super("oneOf", Boolean.FALSE);
    }

    public IpgeoBulkPost200ResponseInner1(Object o) {
        super("oneOf", Boolean.FALSE);
        setActualInstance(o);
    }

    static {
        schemas.put("GeolocationXMLResponseArray", GeolocationXMLResponseArray.class);
        schemas.put("ErrorXMLResponseArray", ErrorXMLResponseArray.class);
    }

    @Override
    public Map<String, Class<?>> getSchemas() {
        return IpgeoBulkPost200ResponseInner1.schemas;
    }

    /**
     * Set the instance that matches the oneOf child schema, check
     * the instance parameter is valid against the oneOf child schemas:
     * ErrorXMLResponseArray, GeolocationXMLResponseArray
     *
     * It could be an instance of the 'oneOf' schemas.
     */
    @Override
    public void setActualInstance(Object instance) {
        if (instance instanceof GeolocationXMLResponseArray) {
            super.setActualInstance(instance);
            return;
        }

        if (instance instanceof ErrorXMLResponseArray) {
            super.setActualInstance(instance);
            return;
        }

        throw new RuntimeException("Invalid instance type. Must be ErrorXMLResponseArray, GeolocationXMLResponseArray");
    }

    /**
     * Get the actual instance, which can be the following:
     * ErrorXMLResponseArray, GeolocationXMLResponseArray
     *
     * @return The actual instance (ErrorXMLResponseArray, GeolocationXMLResponseArray)
     */
    @SuppressWarnings("unchecked")
    @Override
    public Object getActualInstance() {
        return super.getActualInstance();
    }

    /**
     * Get the actual instance of `GeolocationXMLResponseArray`. If the actual instance is not `GeolocationXMLResponseArray`,
     * the ClassCastException will be thrown.
     *
     * @return The actual instance of `GeolocationXMLResponseArray`
     * @throws ClassCastException if the instance is not `GeolocationXMLResponseArray`
     */
    public GeolocationXMLResponseArray getGeolocationXMLResponseArray() throws ClassCastException {
        return (GeolocationXMLResponseArray)super.getActualInstance();
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
     * @throws IOException if the JSON Element is invalid with respect to IpgeoBulkPost200ResponseInner1
     */
    public static void validateJsonElement(JsonElement jsonElement) throws IOException {
        // validate oneOf schemas one by one
        int validCount = 0;
        ArrayList<String> errorMessages = new ArrayList<>();
        // validate the json string with GeolocationXMLResponseArray
        try {
            GeolocationXMLResponseArray.validateJsonElement(jsonElement);
            validCount++;
        } catch (Exception e) {
            errorMessages.add(String.format("Deserialization for GeolocationXMLResponseArray failed with `%s`.", e.getMessage()));
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
            throw new IOException(String.format("The JSON string is invalid for IpgeoBulkPost200ResponseInner1 with oneOf schemas: ErrorXMLResponseArray, GeolocationXMLResponseArray. %d class(es) match the result, expected 1. Detailed failure message for oneOf schemas: %s. JSON: %s", validCount, errorMessages, jsonElement.toString()));
        }
    }

    /**
     * Create an instance of IpgeoBulkPost200ResponseInner1 given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of IpgeoBulkPost200ResponseInner1
     * @throws IOException if the JSON string is invalid with respect to IpgeoBulkPost200ResponseInner1
     */
    public static IpgeoBulkPost200ResponseInner1 fromJson(String jsonString) throws IOException {
        return JSON.getGson().fromJson(jsonString, IpgeoBulkPost200ResponseInner1.class);
    }

    /**
     * Convert an instance of IpgeoBulkPost200ResponseInner1 to an JSON string
     *
     * @return JSON string
     */
    public String toJson() {
        return JSON.getGson().toJson(this);
    }
}

