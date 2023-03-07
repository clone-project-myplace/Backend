package com.myplace.myplace.review.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ReviewKeyword {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "review_id")
    private Review review;

    @ManyToOne
    @JoinColumn(name = "keyword_id")
    private Keyword keyword;

    @Builder
    private ReviewKeyword(Review review, Keyword keyword) {
        this.review = review;
        this.keyword = keyword;
    }

    public static ReviewKeyword of(Review review, Keyword keyword) {
        return ReviewKeyword.builder()
                .review(review)
                .keyword(keyword)
                .build();
    }
}
