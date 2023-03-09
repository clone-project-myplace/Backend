package com.myplace.myplace.common;

import lombok.Getter;

@Getter
public enum MessageType {

    SIGNUP_SUCCESSFULLY("회원가입이 완료되었습니다."),
    LOGIN_SUCCESSFULLY ("로그인이 완료되었습니다."),
    PROFILE_REGISTER_SUCCESSFULLY("사진 등록이 완료되었습니다."),
    REVIEW_WRITE_SUCCESSFULLY("리뷰 작성이 완료되었습니다."),
    REVIEW_MODIFY_SUCCESSFULLY("리뷰 수정이 완료되었습니다."),
    REVIEW_DELETE_SUCCESSFULLY("리뷰 삭제가 완료되었습니다."),
    LIKE_ADD_SUCCESSFULLY("좋아요가 등록되었습니다."),
    LIKE_DELETE_SUCCESSFULLY("좋아요가 취소되었습니다."),
    REVIEW_INQUIRY_SUCCESSFULLY("조회 성공")
    ;

    private final String message;

    MessageType(String message) {
        this.message = message;
    }
}
