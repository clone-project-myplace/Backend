package com.myplace.myplace.member.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class LoginResponseDto {

    private String memberName;

    @Builder
    private LoginResponseDto(String memberName) {
        this.memberName = memberName;
    }

    public static LoginResponseDto from(String memberName) {
        return LoginResponseDto.builder()
                .memberName(memberName)
                .build();
    }
}
