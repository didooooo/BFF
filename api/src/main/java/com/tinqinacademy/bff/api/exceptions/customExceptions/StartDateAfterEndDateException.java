package com.tinqinacademy.bff.api.exceptions.customExceptions;

import com.tinqinacademy.bff.api.exceptions.Errors;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;


@NoArgsConstructor
public class StartDateAfterEndDateException extends Errors {
    public StartDateAfterEndDateException(HttpStatus status, String message, Integer statusCode) {
        super(status, message, statusCode);
    }
}
