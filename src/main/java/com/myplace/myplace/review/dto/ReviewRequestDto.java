package com.myplace.myplace.review.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ReviewRequestDto {

    private List<String> reviewKeywordList = new ArrayList<>();
    private String reviewPhotoUrl;
    private String reviewContents;

}
