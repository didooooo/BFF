package com.tinqinacademy.bff.api.exceptions.customExceptions;

public class NotValidDateException extends RuntimeException {
    public NotValidDateException(String message) {
        super(message);
    }

}
