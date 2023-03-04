package com.myplace.myplace.visit.entity;

import com.myplace.myplace.member.entity.Member;
import com.myplace.myplace.restaurant.entity.Restaurant;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Visit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

    @Column(nullable = false, length = 30)
    private String visitDate;

    @Builder
    private Visit(Member member, Restaurant restaurant, String visitDate) {
        this.member = member;
        this.restaurant = restaurant;
        this.visitDate = visitDate;
    }

    public static Visit of(Member member, Restaurant restaurant, String visitDate) {
        return Visit.builder()
                .member(member)
                .restaurant(restaurant)
                .visitDate(visitDate)
                .build();
    }
}
