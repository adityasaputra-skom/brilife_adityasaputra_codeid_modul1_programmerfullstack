package com.codeid.microservices.exceptions;

@SuppressWarnings("serial")
public class AppException extends RuntimeException {

    private final Integer code;

    public AppException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public AppException(String message, Throwable cause, Integer code) {
        super(message, cause);
        this.code = code;
    }
    
    public AppException(Integer code, Throwable cause) {
        super(cause);
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

}