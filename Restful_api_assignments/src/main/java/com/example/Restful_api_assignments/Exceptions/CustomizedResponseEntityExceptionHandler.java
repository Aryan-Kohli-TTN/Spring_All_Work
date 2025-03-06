package com.example.Restful_api_assignments.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleUserNotFound(Exception ex , WebRequest webRequest){

        ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(),ex.getMessage(),webRequest.getDescription(false));
        ResponseEntity<ErrorDetails> responseEntity = new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
        return responseEntity;
    }
}
