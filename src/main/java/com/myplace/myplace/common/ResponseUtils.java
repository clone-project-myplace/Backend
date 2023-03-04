package com.myplace.myplace.common;

public class ResponseUtils {

    public static FailureResponseDto error(ErrorResponse error) {
        return new FailureResponseDto(error);
    }

    public static <T> SuccessResponseDto<T> ok(T data, MessageType message) {
        return new SuccessResponseDto<T>(data, message.getMessage());
    }

    public static <T> SuccessResponseDto<T> ok(MessageType message) {
        return new SuccessResponseDto<T>(null, message.getMessage());
    }
}
