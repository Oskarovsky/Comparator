package com.oskarro.comparator.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@AllArgsConstructor
public class ServiceExceptionResponse {

    private Date timestamp;
    private String message;
    private String details;

}
