package com.myplace.myplace.common;

import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ErrorResponse {
    private int status;
    private String msg;

    @Builder
    private ErrorResponse(int status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public static ErrorResponse of(ErrorType errorType) {
        return ErrorResponse.builder()
                .status(errorType.getCode())
                .msg(errorType.getMessage())
                .build();
    }

    public static ErrorResponse of(String msg){
        return ErrorResponse.builder()
                .status(400)
                .msg(msg)
                .build();
    }
}
