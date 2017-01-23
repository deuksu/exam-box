package com.exam.security.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice //(basePackages="com.exam.security")
public class GlobalExceptionHandler { // extends ResponseEntityExceptionHandler

  @ExceptionHandler(NoHandlerFoundException.class)
  public ResponseEntity<Error> noHandlerFoundException(NoHandlerFoundException ex) {
    String message = "HTTP " + ex.getHttpMethod() + " for " + ex.getRequestURL() + " is not supported.";
    Error error = new Error(HttpStatus.NOT_FOUND.value(), message);
    return new ResponseEntity<Error>(error, HttpStatus.NOT_FOUND);
  }
  
  @ExceptionHandler(RuntimeException.class)
  public ResponseEntity<Error> runtimeException(RuntimeException ex) {
    Error error = new Error(HttpStatus.NOT_FOUND.value(), ex.getMessage());
    return new ResponseEntity<Error>(error, HttpStatus.NOT_FOUND);
  }  
  
}


