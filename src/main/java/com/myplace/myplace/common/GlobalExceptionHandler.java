package com.myplace.myplace.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<FailureResponseDto> IllegalArgumentException(IllegalArgumentException ex) {

        ErrorResponse response = ErrorResponse.of(ex.getMessage());
        log.error(response.getMsg());

        return ResponseEntity.badRequest().body(ResponseUtils.error(response));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<FailureResponseDto> methodValidException(MethodArgumentNotValidException e) {

        ErrorResponse response = ErrorResponse.of(e.getBindingResult());
        log.error(response.getMsg());

        return ResponseEntity.badRequest().body(ResponseUtils.error(response));
    }
}
