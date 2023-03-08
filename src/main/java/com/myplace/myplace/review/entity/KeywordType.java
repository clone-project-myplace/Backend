package com.myplace.myplace.review.entity;

import lombok.Getter;

@Getter
public enum KeywordType {
    K1("디저트가 맛있어요"),
    K2("가성비가 좋아요"),
    K3("음료가 맛있어요"),
    K4("특별한 메뉴가 있어요"),
    K5("커피가 맛있어요"),
    K6("대화하기 좋아요"),
    K7("뷰가 좋아요"),
    K8("사진이 잘 나와요"),
    K9("인테리어가 멋져요"),
    K10("집중하기 좋아요"),
    K11("화장실이 깨끗해요"),
    K12("좌석이 편해요"),
    K13("매장이 청결해요"),
    K14("주차하기 편해요"),
    K15("친절해요"),
    K16("선택할 키워드가 없어요")
    ;


    private final String msg;

    KeywordType(String msg) {
        this.msg = msg;
    }
}
