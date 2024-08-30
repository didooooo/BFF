package com.tinqinacademy.bff.rest.controllers;

import io.vavr.control.Either;
import com.tinqinacademy.bff.api.exceptions.Errors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class BaseController {
    public ResponseEntity<?> handleTheEither(Either<Errors, ?> input) {
        if (input.isRight()) {
            return ResponseEntity.ok(input.get());
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(input.getLeft());
    }
}
