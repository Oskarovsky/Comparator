package com.oskarro.comparator.exception;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String property, String parameter, String value) {
        super(String.format("Cannot find resource %s for parameter %s with value %s", property, parameter, value));
    }
}
