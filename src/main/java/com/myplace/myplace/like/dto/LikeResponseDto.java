package com.myplace.myplace.like.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class LikeResponseDto {

    private int likeCount;

    @Builder
    private LikeResponseDto(int likeCount){
        this.likeCount = likeCount;
    }

    public static LikeResponseDto from(int likeCount){
        return LikeResponseDto.builder()
                .likeCount(likeCount)
                .build();
    }
}
