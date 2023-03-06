package com.myplace.myplace.review.entity;

import lombok.Getter;

@Getter
public enum KeywordType {
    K1("양이 많아요"),
    K2("음식이 맛있어요"),
    K3("재료가 신선해요"),
    K4("가성비가 좋아요"),
    K5("특별한 메뉴가 있어요"),
    K6("단체모임 하기 좋아요"),
    K7("뷰가 좋아요"),
    K8("매장이 넓어요"),
    K9("혼밥하기 좋아요"),
    K10("인테리어가 멋져요"),
    K11("매장이 청결해요"),
    K12("주차하기 편해요"),
    K13("특별한 날 가기 좋아요"),
    K14("화장실이 깨끗해요"),
    K15("친절해요"),
    K16("선택할 키워드가 없어요")
    ;


    private final String msg;

    KeywordType(String msg) {
        this.msg = msg;
    }
}
