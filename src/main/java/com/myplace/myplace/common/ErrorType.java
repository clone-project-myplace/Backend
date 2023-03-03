package com.myplace.myplace.common;

import lombok.Getter;

@Getter
public enum ErrorType {
    NOT_VALID_TOKEN(400, "토큰이 유효하지 않습니다."),
    NOT_TOKEN(400, "토큰이 없습니다."),
    NOT_FOUND_USER(400, "등록된 사용자가 없습니다.");

    private int code;
    private String message;

    ErrorType(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
