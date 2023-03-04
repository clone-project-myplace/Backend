package com.myplace.myplace.member.dto;

import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
public class SignupRequestDto {

    @NotBlank(message = "필수 정보입니다.")
    @Pattern(regexp = "^[a-z0-9_-]{5,20}$", message = "5~20자의 영문 소문자, 숫자와 특수기호(_),(-)만 사용 가능합니다.")
    private String memberId;

    @NotBlank(message = "필수 정보입니다.")
    @Pattern(regexp = "^[a-zA-Z0-9~!@#$%^&*()_+=?,./<>{}\\[\\]\\-]{8,16}$", message = "8~16자 영문 대 소문자, 숫자, 특수문자를 사용하세요.")
    private String memberPw;

    @NotBlank(message = "필수 정보입니다.")
    @Pattern(regexp = "^[a-zA-Z가-힣0-9]{2,20}$", message = "2~20자의 한글, 영문 대 소문자, 숫자를 사용하세요.")
    private String memberName;
}
