package com.myplace.myplace.common;

import lombok.Getter;

@Getter
public enum MessageType {

    signupSuccessfully("회원가입이 완료되었습니다."),
    loginSuccessfully ("로그인이 완료되었습니다."),
    profileRegisterSuccessfully("사진 등록이 완료되었습니다."),
    reviewWriteSuccessfully("리뷰 작성이 완료되었습니다."),
    reviewModifySuccessfully("리뷰 수정이 완료되었습니다."),
    reviewDeleteSuccessfully("리뷰 삭제가 완료되었습니다.");

    private  String message;
    MessageType(String message) {
        this.message = message;
    }
}
