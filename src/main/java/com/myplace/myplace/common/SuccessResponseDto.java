package com.myplace.myplace.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SuccessResponseDto<T>  {

    private T data;
    private String message;

    @Builder
    public SuccessResponseDto(T data, String message) {
        this.data = data;
        this.message = message;
    }
}
