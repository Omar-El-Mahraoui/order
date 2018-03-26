package com.mygroupid.api.customers;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

// copied code from funiversity example

@ControllerAdvice(basePackages = {"com.mygroupid.api.customers"})
public class CustomerControllerAdvice {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> convertIllegalArgumentException(final IllegalArgumentException exception) {
        return new ResponseEntity<>(
                exception.getMessage(),
                HttpStatus.BAD_REQUEST);
    }

}
