package com.ogzaitsev.digitalchief.exception;

public class ExceptionResponse {

    private String message;

    private String timestamp;

    public ExceptionResponse(String message, String timestamp) {
        this.message = message;
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public String getTimestamp() {
        return timestamp;
    }
}
