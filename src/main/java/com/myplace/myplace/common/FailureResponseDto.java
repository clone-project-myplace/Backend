package com.myplace.myplace.common;

import lombok.Getter;

@Getter
public class FailureResponseDto {

    private ErrorResponse error;

    public FailureResponseDto(ErrorResponse error) {
        this.error = error;
    }

}
