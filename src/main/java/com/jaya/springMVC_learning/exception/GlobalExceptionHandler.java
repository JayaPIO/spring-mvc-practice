package com.jaya.springMVC_learning.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Exception for handling same type of handled exception coming from different controllers
     *
     * @param exception
     * @return ResponseEntity with custom message
     */
    @ExceptionHandler(CustomException.class)
    public ResponseEntity<String> handleCustomException(CustomException exception) {
        return new ResponseEntity<>(exception.getMessage() + ": from Global ExceptionHandler " + exception.getStatus(), exception.getStatus());
    }

    /**
     * General exception it will handle all the uncaught exception
     *
     * @param exception
     * @return ResponseEntity with message
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> generalException(Exception exception) {
        return ResponseEntity.status(500).body(exception.getMessage() + ": from Global ExceptionHandler");
    }
}
