package com.ogzaitsev.digitalchief.exception;

public class NoSuchEntityException extends RuntimeException{
    public NoSuchEntityException(String message) {
        super(message);
    }

    public NoSuchEntityException() {
        super("There is no such entity");
    }
}
