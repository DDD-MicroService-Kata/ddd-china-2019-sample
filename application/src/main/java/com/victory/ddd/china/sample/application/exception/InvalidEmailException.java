package com.victory.ddd.china.sample.application.exception;

public class InvalidEmailException extends RuntimeException {
    public InvalidEmailException(String email) {
        super(String.format("Invalid Email for login: %s", email));
    }
}
