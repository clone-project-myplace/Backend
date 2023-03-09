package com.myplace.myplace.review.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
public class FeedPageResponseDto {

    private Boolean isLastPage;
    private String loginProfileImgUrl;
    private List<FeedReviewResponseDto> reviewList;

    @Builder
    private FeedPageResponseDto(Boolean isLastPage, String loginProfileImgUrl, List<FeedReviewResponseDto> reviewList) {
        this.isLastPage = isLastPage;
        this.loginProfileImgUrl = loginProfileImgUrl;
        this.reviewList = reviewList;
    }

    public static FeedPageResponseDto of(Boolean isLastPage, String loginProfileImgUrl, List<FeedReviewResponseDto> reviewList) {
        return FeedPageResponseDto.builder()
                .isLastPage(isLastPage)
                .loginProfileImgUrl(loginProfileImgUrl)
                .reviewList(reviewList)
                .build();
    }
}
