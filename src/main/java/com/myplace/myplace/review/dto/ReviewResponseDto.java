package com.myplace.myplace.review.dto;


import com.myplace.myplace.review.entity.Review;
import lombok.Builder;
import lombok.Getter;

@Getter
public class ReviewResponseDto {

    private Review review;



    @Builder
    private ReviewResponseDto(Review review){
        this.review = review;
    }

    public static ReviewResponseDto from(Review review){
        return ReviewResponseDto.builder()
                .review(review)
                .build();
    }
}
