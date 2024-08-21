package com.tinqinacademy.bff.api.exceptions;

import org.springframework.stereotype.Component;


@Component
public class ErrorMapper {
    private final ErrorMappings errorMappings;

    public ErrorMapper(ErrorMappings errorMappings) {
        this.errorMappings = errorMappings;
    }

    public <T extends Throwable> Errors mapError(T exception) {
        Errors errors = errorMappings.getExceptionToError().get(exception.getClass());
        return errors;
    }



}
