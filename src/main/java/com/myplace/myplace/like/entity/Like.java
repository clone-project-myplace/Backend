package com.myplace.myplace.like.entity;


import com.myplace.myplace.member.entity.Member;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Like {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "memberId", nullable = false)
    private Member member;

    @ManyToOne
    @JoinColumn(name = "reviewId", nullable = false)
    private Review review;

    @Builder
    private Like(Member member, Review review){
        this.member = member;
        this.review = review;
    }

    public static Like of(Member member, Review review){
        return Like.builder()
                .member(member)
                .review(review)
                .build();
    }
}
