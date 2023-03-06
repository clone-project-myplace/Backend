package com.myplace.myplace.review.service;


import com.myplace.myplace.common.ErrorType;
import com.myplace.myplace.common.SuccessResponseDto;
import com.myplace.myplace.member.entity.Member;
import com.myplace.myplace.member.repository.MemberRepository;
import com.myplace.myplace.review.dto.ReviewRequestDto;
import com.myplace.myplace.review.dto.ReviewResponseDto;
import com.myplace.myplace.review.entity.Review;
import com.myplace.myplace.review.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final MemberRepository memberRepository;


    // 리뷰 작성 기능
    @Transactional
    public SuccessResponseDto<ReviewResponseDto> reviewCreate(ReviewRequestDto reviewRequestDto,
                                                              Member member){
        // 사용자 확인
        Optional<Member> finduser = memberRepository.findByMemberId(member.getMemberId());
        if(finduser.isPresent()){
            throw new IllegalArgumentException(ErrorType.NOT_FOUND_USER.getMessage());
        }

        Review review = reviewRepository.save(Review.builder()
                .reviewRequestDto(reviewRequestDto)
                .)

    }
}
