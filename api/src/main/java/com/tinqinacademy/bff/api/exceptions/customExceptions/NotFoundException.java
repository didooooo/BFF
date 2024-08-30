package com.tinqinacademy.bff.api.exceptions.customExceptions;

import com.tinqinacademy.bff.api.exceptions.Errors;
import org.springframework.http.HttpStatus;

public class NotFoundException extends Errors {
    public NotFoundException(HttpStatus status, String message, Integer statusCode) {
        super(status, message, statusCode);
    }

    public NotFoundException() {
    }
}
