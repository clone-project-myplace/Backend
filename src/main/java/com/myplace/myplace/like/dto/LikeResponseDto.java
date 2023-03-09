package com.myplace.myplace.like.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class LikeResponseDto {

    private int likeCount;
    private Boolean isPushed;

    @Builder
    private LikeResponseDto(int likeCount, Boolean isPushed){
        this.likeCount = likeCount;
        this.isPushed = isPushed;
    }

    public static LikeResponseDto from(int likeCount, Boolean isPushed){
        return LikeResponseDto.builder()
                .likeCount(likeCount)
                .isPushed(isPushed)
                .build();
    }
}
