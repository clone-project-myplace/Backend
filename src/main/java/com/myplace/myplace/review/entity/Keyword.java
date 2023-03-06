package com.myplace.myplace.review.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Keyword {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private KeywordType type;

    @Builder
    private Keyword(KeywordType type) {
        this.type = type;
    }

    public static Keyword of(KeywordType type) {
        return Keyword.builder()
                .type(type)
                .build();
    }

}
