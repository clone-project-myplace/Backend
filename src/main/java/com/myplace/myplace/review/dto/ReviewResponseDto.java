package com.myplace.myplace.review.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ReviewResponseDto {

    private Long reviewId;
    private String memberName;
    private String profileImgUrl;
    private String restaurantName;
    private String restaurantAddress;
    private String reviewContents;
    private String reviewImgUrl;
    private int likeCount;
    private List keywordList;
    private int reviewCount;
    private LocalDateTime createdDate;

    @Builder
    private ReviewResponseDto(Long reviewId, String memberName, String profileImgUrl, String restaurantName, String restaurantAddress, String reviewContents,
                               String reviewImgUrl, int likeCount, List keywordList, int reviewCount, LocalDateTime createdDate) {

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
    }

    // [피드,리뷰] 상세 조회
    public static ReviewResponseDto of(Long reviewId, String memberName, String profileImgUrl, String restaurantName, String restaurantAddress, String reviewContents,
                                       String reviewImgUrl, int likeCount, List keywordList, int reviewCount, LocalDateTime createdDate) {

        return ReviewResponseDto.builder()
                .reviewId(reviewId)
                .memberName(memberName)
                .profileImgUrl(profileImgUrl)
                .restaurantName(restaurantName)
                .restaurantAddress(restaurantAddress)
                .reviewContents(reviewContents)
                .reviewImgUrl(reviewImgUrl)
                .likeCount(likeCount)
                .keywordList(keywordList)
                .reviewCount(reviewCount)
                .createdDate(createdDate)
                .build();
    }

    // [피드] 전체 조회
    public static ReviewResponseDto from(Long reviewId, String memberName, String restaurantName, String restaurantAddress, String reviewContents,
                                       String reviewImgUrl, int likeCount, List keywordList, int reviewCount, LocalDateTime createdDate) {

        return ReviewResponseDto.builder()
                .reviewId(reviewId)
                .memberName(memberName)
                .restaurantName(restaurantName)
                .restaurantAddress(restaurantAddress)
                .reviewContents(reviewContents)
                .reviewImgUrl(reviewImgUrl)
                .likeCount(likeCount)
                .keywordList(keywordList)
                .reviewCount(reviewCount)
                .createdDate(createdDate)
                .build();
    }

    // [리뷰] 조회
    public static ReviewResponseDto of(Long reviewId, String restaurantName, String restaurantAddress, String reviewImgUrl, int reviewCount) {

        return ReviewResponseDto.builder()
                .reviewId(reviewId)
                .restaurantName(restaurantName)
                .restaurantAddress(restaurantAddress)
                .reviewImgUrl(reviewImgUrl)
                .reviewCount(reviewCount)
                .build();
    }
}
