package com.myplace.myplace.review.controller;


import com.myplace.myplace.common.SuccessResponseDto;
import com.myplace.myplace.review.dto.ReviewRequestDto;
import com.myplace.myplace.review.dto.ReviewResponseDto;
import com.myplace.myplace.review.service.ReviewService;
import com.myplace.myplace.security.UserDetailsImpl;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ReviewController {

    private final ReviewService reviewService;

    public SuccessResponseDto<ReviewResponseDto> reviewCreate(@ModelAttribute ReviewRequestDto reviewRequestDto,
                                                              @AuthenticationPrincipal UserDetailsImpl userDetails){
        return reviewService.reviewCreate(reviewRequestDto, userDetails.getUser());
    }
}
