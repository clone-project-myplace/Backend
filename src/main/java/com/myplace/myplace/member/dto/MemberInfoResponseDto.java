package com.myplace.myplace.member.dto;

import com.myplace.myplace.member.entity.Member;
import lombok.Builder;
import lombok.Getter;

@Getter
public class MemberInfoResponseDto {

    private String memberName;
    private String profileImgUrl;
    private Integer reviewCount;

    @Builder
    private MemberInfoResponseDto(String memberName, String profileImgUrl, int reviewCount) {
        this.memberName = memberName;
        this.profileImgUrl = profileImgUrl;
        this.reviewCount = reviewCount;
    }

    public static MemberInfoResponseDto from(Member member, int reviewCount) {
        return MemberInfoResponseDto.builder()
                .memberName(member.getMemberName())
                .profileImgUrl(member.getImgUrl())
                .reviewCount(reviewCount)
                .build();
    }
}
