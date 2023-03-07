package com.myplace.myplace.review.controller;

import com.myplace.myplace.common.SuccessResponseDto;
import com.myplace.myplace.review.dto.FeedPageResponseDto;
import com.myplace.myplace.review.dto.ReviewRequestDto;
import com.myplace.myplace.review.dto.ReviewResponseDto;
import com.myplace.myplace.review.dto.ReviewUpdateDto;
import com.myplace.myplace.review.service.ReviewService;
import com.myplace.myplace.security.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ReviewController {

    private final ReviewService reviewService;


    @PostMapping("/reviews/restaurants/{id}")
    public SuccessResponseDto<Void> createReview(@PathVariable Long id, @ModelAttribute ReviewRequestDto requestDto, @AuthenticationPrincipal UserDetailsImpl userDetails) throws IOException {
        return reviewService.createReview(id, requestDto, userDetails.getUser());
    }

    @GetMapping("/reviews/{id}")
    public SuccessResponseDto<ReviewResponseDto> reviewDetail(@PathVariable Long id) {
        return reviewService.reviewDetail(id);
    }

    @PutMapping("/reviews/{id}")
    public SuccessResponseDto<Void> updateReview(@PathVariable Long id, @RequestBody ReviewUpdateDto requestDto, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        return reviewService.updateReview(id, requestDto, userDetails.getUser());
    }

    @DeleteMapping("/reviews/{id}")
    public SuccessResponseDto<Void> deleteReview(@PathVariable Long id, @AuthenticationPrincipal UserDetailsImpl userDetails){
        return reviewService.deleteReview(id, userDetails.getUser());
    }

    @GetMapping("/reviews")
    public SuccessResponseDto<FeedPageResponseDto> feedReviews(@RequestParam(required = false, defaultValue = "0", value = "page") int pageNo) {
        return reviewService.feedReviews(pageNo);
    }
}
