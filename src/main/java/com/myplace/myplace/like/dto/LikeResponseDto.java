package com.myplace.myplace.like.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class LikeResponseDto {

    private int likeCount;
    private boolean isPushed;

    @Builder
    private LikeResponseDto(int likeCount, boolean isPushed){
        this.likeCount = likeCount;
        this.isPushed = isPushed;
    }

    public static LikeResponseDto from(int likeCount, boolean isPushed){
        return LikeResponseDto.builder()
                .likeCount(likeCount)
                .isPushed(isPushed)
                .build();
    }
}
