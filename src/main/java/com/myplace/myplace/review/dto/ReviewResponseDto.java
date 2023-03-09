package com.myplace.myplace.review.dto;

import com.myplace.myplace.review.entity.Review;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ReviewResponseDto {

    private Long reviewId;
    private String restaurantName;
    private String restaurantAddress;
    private String reviewImgUrl;
    private int reviewCount;

    @Builder
    private ReviewResponseDto(Long reviewId, String restaurantName, String restaurantAddress, String reviewImgUrl, int reviewCount) {

        this.reviewId = reviewId;
        this.restaurantName = restaurantName;
        this.restaurantAddress = restaurantAddress;
        this.reviewImgUrl = reviewImgUrl;
        this.reviewCount = reviewCount;
    }

    public static ReviewResponseDto of(Review review, int reviewCount) {

        return ReviewResponseDto.builder()
                .reviewId(review.getId())
                .restaurantName(review.getRestaurant().getName())
                .restaurantAddress(review.getRestaurant().getAddress())
                .reviewImgUrl(review.getImgUrl())
                .reviewCount(reviewCount)
                .build();
    }
}
