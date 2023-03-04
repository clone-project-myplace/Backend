package com.myplace.myplace.review.entity;


import com.myplace.myplace.member.entity.Member;
import com.myplace.myplace.restaurant.entity.Restaurant;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Review extends Timestamp {

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

    @Builder
    private Review(String contents, String imgUrl, Member member, Restaurant restaurant){
        this.contents = contents;
        this.imgUrl = imgUrl;
        this.member = member;
        this.restaurant = restaurant;
    }

    public static Review of(String contents, String imgUrl, Member member, Restaurant restaurant){
        return Review.builder()
                .contents(contents)
                .imgUrl(imgUrl)
                .member(member)
                .restaurant(restaurant)
                .build();
    }

}
