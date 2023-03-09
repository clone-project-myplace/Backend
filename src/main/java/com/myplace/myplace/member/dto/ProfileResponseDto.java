package com.myplace.myplace.member.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class ProfileResponseDto {

    private String profileImgUrl;

    @Builder
    private ProfileResponseDto(String profileImgUrl) {
        this.profileImgUrl = profileImgUrl;
    }

    public static ProfileResponseDto from(String profileImgUrl) {
        return ProfileResponseDto.builder()
                .profileImgUrl(profileImgUrl)
                .build();
    }
}
