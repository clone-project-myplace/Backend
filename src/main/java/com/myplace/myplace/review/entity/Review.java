package com.myplace.myplace.review.entity;


import com.myplace.myplace.member.entity.Member;
import com.myplace.myplace.restaurant.entity.Restaurant;
import com.myplace.myplace.review.dto.ReviewRequestDto;
import com.myplace.myplace.review.dto.ReviewUpdateDto;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Review extends Timestamped {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String contents;

    @Column(nullable = false)
    private String imgUrl;

    @ManyToOne
    @JoinColumn(name = "memberId", nullable = false)
    private Member member;

    @ManyToOne
    @JoinColumn(name = "restaurantId", nullable = false)
    private Restaurant restaurant;

    @OneToMany
    private List<ReviewKeyword> reviewKeywordList = new ArrayList<>();

    @Builder
    private Review(String contents, String imgUrl, Member member, Restaurant restaurant, List<ReviewKeyword> reviewKeywordList){
        this.contents = contents;
        this.imgUrl = imgUrl;
        this.member = member;
        this.restaurant = restaurant;
        this.reviewKeywordList = reviewKeywordList;
    }

    public static Review of(ReviewRequestDto requestDto, String imgUrl, Member member, Restaurant restaurant){
        return Review.builder()
                .contents(requestDto.getReviewContents())
                .imgUrl(imgUrl)
                .member(member)
                .restaurant(restaurant)
                .reviewKeywordList(new ArrayList<>())
                .build();
    }

    public void updateKeyword(List<ReviewKeyword> reviewKeywordList) {
        this.reviewKeywordList = reviewKeywordList;
    }

    public void updateReview(ReviewUpdateDto reviewUpdateDto){
        this.contents = reviewUpdateDto.getContents();
    }

}
