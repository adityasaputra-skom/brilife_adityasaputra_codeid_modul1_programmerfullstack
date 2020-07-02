package com.codeid.microservices.models;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ResponseMessage<T> {
    
    private int code;
    private String message;
    private T data;

    @JsonFormat(pattern = "dd-MM-yyyy (HH:mm)")
    private LocalDateTime timestamp;

    private ResponseMessage(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
        this.timestamp = LocalDateTime.now();
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public static <T> ResponseMessage<T> success(T data) {
        return new ResponseMessage<T>(0, null, data);
    }

    public static <T> ResponseMessage<T> successEdit(T data) {
        return new ResponseMessage<T>(0, "Edit data Successfully", data);
    }

    public static <T> ResponseMessage<T> successDelete(T data) {
        return new ResponseMessage<T>(0, "Delete data Successfully", data);
    }

    public static ResponseMessage<?> error(int code, String message) {
        return error(code, message, null);
    }

    public static <T> ResponseMessage<T> error(int code, String message, T data) {
        return new ResponseMessage<T>(code, message, data);
    }

    

    
    
}