package com.myplace.myplace.common;

import lombok.Getter;

@Getter
public enum ErrorType {
    NOT_VALID_TOKEN(400, "토큰이 유효하지 않습니다."),
    NOT_TOKEN(400, "토큰이 없습니다."),
    NOT_FOUND_USER(400, "등록된 사용자가 없습니다."),
    DUPLICATED_MEMBER_ID(400, "중복된 아이디입니다."),
    DUPLICATED_MEMBER_NAME(400, "중복된 닉네임입니다."),
    NOT_MATCHING_INFO(400, " 아이디 또는 비밀번호를 잘못 입력했습니다."),
    NOT_FOUND_REVIEW(400, "등록된 리뷰가 없습니다."),
    NOT_FOUND_RESTAURANT(400, "등록된 음식점이 없습니다.")
    ;

    private int code;
    private String message;

    ErrorType(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
