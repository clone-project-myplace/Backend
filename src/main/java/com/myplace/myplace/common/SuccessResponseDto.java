package com.myplace.myplace.common;

import lombok.Builder;
import lombok.Getter;

@Getter
public class SuccessResponseDto<T>  {

    private T data;
    private String message;

    @Builder
    public SuccessResponseDto(T data, String message) {
        this.data = data;
        this.message = message;
    }
}
