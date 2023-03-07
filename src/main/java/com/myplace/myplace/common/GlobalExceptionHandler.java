package com.myplace.myplace.common;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<FailureResponseDto> IllegalArgumentException(IllegalArgumentException ex) {
        ErrorResponse response = ErrorResponse.of(ex.getMessage());

        return ResponseEntity.badRequest().body(ResponseUtils.error(response));
    }
}
