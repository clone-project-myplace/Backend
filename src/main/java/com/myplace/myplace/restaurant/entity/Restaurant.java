package com.myplace.myplace.restaurant.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String address;

    @Builder
    private Restaurant(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public static Restaurant of(String name, String address) {
        return Restaurant.builder()
                .name(name)
                .address(address)
                .build();
    }
}
