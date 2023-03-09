package com.myplace.myplace.review.dto;

import com.myplace.myplace.review.entity.Review;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class FeedReviewResponseDto {

    private Long reviewId;
    private String memberName;
    private String profileImgUrl;
    private String restaurantName;
    private String restaurantAddress;
    private String reviewContents;
    private String reviewImgUrl;
    private int likeCount;
    private List<String> keywordList;
    private int reviewCount;
    private LocalDateTime createdDate;
    private Boolean isPushed;


    @Builder
    private FeedReviewResponseDto(Long reviewId, String memberName, String profileImgUrl, String restaurantName, String restaurantAddress, String reviewContents,
                                  String reviewImgUrl, int likeCount, List<String> keywordList, int reviewCount, LocalDateTime createdDate, boolean isPushed) {

        this.reviewId = reviewId;
        this.memberName = memberName;
        this.profileImgUrl = profileImgUrl;
        this.restaurantName = restaurantName;
        this.restaurantAddress = restaurantAddress;
        this.reviewContents = reviewContents;
        this.reviewImgUrl = reviewImgUrl;
        this.likeCount = likeCount;
        this.keywordList = keywordList;
        this.reviewCount = reviewCount;
        this.createdDate = createdDate;
        this.isPushed = isPushed;
    }

    public static FeedReviewResponseDto of(Review review, int likeCount, int reviewCount, List<String> keywordList, boolean isPushed){

        return FeedReviewResponseDto.builder()
                .reviewId(review.getId())
                .memberName(review.getMember().getMemberName())
                .profileImgUrl(review.getMember().getImgUrl())
                .restaurantName(review.getRestaurant().getName())
                .restaurantAddress(review.getRestaurant().getAddress())
                .reviewContents(review.getContents())
                .reviewImgUrl(review.getImgUrl())
                .likeCount(likeCount)
                .keywordList(keywordList)
                .reviewCount(reviewCount)
                .createdDate(review.getCreatedAt())
                .isPushed(isPushed)
                .build();
    }


}
