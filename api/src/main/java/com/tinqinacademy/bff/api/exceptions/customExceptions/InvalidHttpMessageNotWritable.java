package com.tinqinacademy.bff.api.exceptions.customExceptions;

import com.tinqinacademy.bff.api.exceptions.Errors;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@NoArgsConstructor
public class InvalidHttpMessageNotWritable extends Errors {
    public InvalidHttpMessageNotWritable(HttpStatus status, String message, Integer statusCode) {
        super(status, message, statusCode);
    }
}
