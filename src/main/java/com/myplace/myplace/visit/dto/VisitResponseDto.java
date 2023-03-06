package com.myplace.myplace.visit.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class VisitResponseDto {

    private Long visitedRestaurantId;
    private String visitedRestaurantName;
    private String visitedDate;
    private Boolean IsReviewed;

    @Builder
    private VisitResponseDto(Long visitedRestaurantId, String visitedRestaurantName, String visitedDate, Boolean IsReviewed) {

        this.visitedRestaurantId = visitedRestaurantId;
        this.visitedRestaurantName = visitedRestaurantName;
        this.visitedDate = visitedDate;
        this.IsReviewed = IsReviewed;
    }

    // [방문] 조회
    public static VisitResponseDto of(Long visitedRestaurantId, String visitedRestaurantName, String visitedDate, Boolean IsReviewed) {

        return VisitResponseDto.builder()
                .visitedRestaurantId(visitedRestaurantId)
                .visitedRestaurantName(visitedRestaurantName)
                .visitedDate(visitedDate)
                .IsReviewed(IsReviewed)
                .build();
    }
}
