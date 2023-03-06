package com.myplace.myplace.review.controller;

import com.myplace.myplace.common.SuccessResponseDto;
import com.myplace.myplace.review.dto.ReviewRequestDto;
import com.myplace.myplace.review.dto.ReviewUpdateDto;
import com.myplace.myplace.review.service.ReviewService;
import com.myplace.myplace.security.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ReviewController {

    private final ReviewService reviewService;

    // 리뷰 작성
    @PostMapping("/reviews/restaurants/{id}")
    public SuccessResponseDto<Void> createReview(@PathVariable Long id, @RequestBody ReviewRequestDto requestDto, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        return reviewService.createReview(id, requestDto, userDetails.getUser());
    }

    @PutMapping("/reviews/{id}")
    public SuccessResponseDto<Void> updateReview(@PathVariable Long id, @RequestBody ReviewUpdateDto requestDto, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        return reviewService.updateReview(id, requestDto, userDetails.getUser());
    }

    @DeleteMapping("/reviews/{id}")
    public SuccessResponseDto<Void> deleteReview(@PathVariable Long id, @AuthenticationPrincipal UserDetailsImpl userDetails){
        return reviewService.deleteReview(id, userDetails.getUser());
    }
}
