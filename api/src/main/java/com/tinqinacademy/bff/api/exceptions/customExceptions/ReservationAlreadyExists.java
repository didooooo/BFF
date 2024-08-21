package com.tinqinacademy.bff.api.exceptions.customExceptions;

import com.tinqinacademy.bff.api.exceptions.Errors;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@NoArgsConstructor
public class ReservationAlreadyExists extends Errors {
    public ReservationAlreadyExists(HttpStatus status, String message, Integer statusCode) {
        super(status, message, statusCode);
    }
}
