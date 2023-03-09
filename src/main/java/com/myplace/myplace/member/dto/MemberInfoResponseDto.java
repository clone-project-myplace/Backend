package com.myplace.myplace.member.dto;

import com.myplace.myplace.member.entity.Member;
import lombok.Builder;
import lombok.Getter;

@Getter
public class MemberInfoResponseDto {

    private String memberName;
    private String profileImgUrl;

    @Builder
    private MemberInfoResponseDto(String memberName, String profileImgUrl) {
        this.memberName = memberName;
        this.profileImgUrl = profileImgUrl;
    }

    public static MemberInfoResponseDto from(Member member) {
        return MemberInfoResponseDto.builder()
                .memberName(member.getMemberName())
                .profileImgUrl(member.getImgUrl())
                .build();
    }
}
