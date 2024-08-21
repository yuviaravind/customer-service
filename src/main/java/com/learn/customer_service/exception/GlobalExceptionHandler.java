package com.learn.customer_service.exception;

import com.learn.customer_service.model.ExceptionClass;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = {HandleNotImplementedException.class})
    public ResponseEntity<Object> handleNotImplementedException(HandleNotImplementedException e) {
        HttpStatus badRequest = HttpStatus.NOT_IMPLEMENTED;
        ExceptionClass exceptionClass = new ExceptionClass(
                e.getMessage(),
                badRequest,
                ZonedDateTime.now(ZoneId.of("Z"))
        );
        return new ResponseEntity<>(exceptionClass, badRequest);
    }

    @ExceptionHandler(value = {ResourceNotFoundException.class})
    public ResponseEntity<Object> handleResourceNotFoundException(ResourceNotFoundException e) {
        HttpStatus badRequest = HttpStatus.NOT_FOUND;
        ExceptionClass exceptionClass = new ExceptionClass(
                e.getMessage(),
                badRequest,
                ZonedDateTime.now(ZoneId.of("Z"))
        );
        return new ResponseEntity<>(exceptionClass, badRequest);
    }

}
