package com.tinqinacademy.bff.api.exceptions.customExceptions;

import com.tinqinacademy.bff.api.exceptions.Errors;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@NoArgsConstructor
public class BlankStringException extends Errors {
    private final String UNIQUE = "1";

    public BlankStringException(HttpStatus status, String message, Integer statusCode) {
        super(status, message, statusCode);
    }

    @Override
    public String toString() {
        return UNIQUE;
    }
}
