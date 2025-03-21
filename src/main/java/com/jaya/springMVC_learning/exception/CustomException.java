package com.jaya.springMVC_learning.exception;

import org.springframework.http.HttpStatus;

/**
 * Custom Exception class for setting the fields for our exception - Http Status and message for the exception
 */
public class CustomException extends RuntimeException{
    private final HttpStatus status;
    private final String message;

    public CustomException(HttpStatus status, String message){
        this.status = status;
        this.message = message;
    }

    public HttpStatus getStatus(){
        return status;
    }

    @Override
    public String getMessage(){
        return message;
    }
}
