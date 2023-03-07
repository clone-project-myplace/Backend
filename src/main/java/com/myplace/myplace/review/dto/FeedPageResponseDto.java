package com.myplace.myplace.review.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
public class FeedPageResponseDto {

    private Boolean isLastPage;
    private List<FeedReviewResponseDto> reviewList;

    @Builder
    private FeedPageResponseDto(Boolean isLastPage, List<FeedReviewResponseDto> reviewList) {
        this.isLastPage = isLastPage;
        this.reviewList = reviewList;
    }

    public static FeedPageResponseDto of(Boolean isLastPage, List<FeedReviewResponseDto> reviewList) {
        return FeedPageResponseDto.builder()
                .isLastPage(isLastPage)
                .reviewList(reviewList)
                .build();
    }
}
