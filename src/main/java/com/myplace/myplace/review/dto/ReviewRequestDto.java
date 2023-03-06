package com.myplace.myplace.review.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class ReviewRequestDto {

    private String[] reviewKeywordList;
    private String reviewPhotoUrl;
    private String reviewContents;
    private Long restaurantId;
}
