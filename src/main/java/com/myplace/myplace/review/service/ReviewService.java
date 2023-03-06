package com.myplace.myplace.review.service;

import com.myplace.myplace.common.ErrorType;
import com.myplace.myplace.common.MessageType;
import com.myplace.myplace.common.ResponseUtils;
import com.myplace.myplace.common.SuccessResponseDto;
import com.myplace.myplace.member.entity.Member;
import com.myplace.myplace.restaurant.entity.Restaurant;
import com.myplace.myplace.restaurant.repository.RestaurantRepository;
import com.myplace.myplace.review.dto.ReviewRequestDto;
import com.myplace.myplace.review.dto.ReviewUpdateDto;
import com.myplace.myplace.review.entity.Keyword;
import com.myplace.myplace.review.entity.KeywordType;
import com.myplace.myplace.review.entity.Review;
import com.myplace.myplace.review.entity.ReviewKeyword;
import com.myplace.myplace.review.repository.KeywordRepository;
import com.myplace.myplace.review.repository.ReviewKeywordRepository;
import com.myplace.myplace.review.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final RestaurantRepository restaurantRepository;
    private final KeywordRepository keywordRepository;
    private final ReviewKeywordRepository reviewKeywordRepository;

    // 리뷰 작성
    @Transactional
    public SuccessResponseDto<Void> createReview(Long id, ReviewRequestDto requestDto, Member member) {

        Restaurant restaurant = restaurantRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException(ErrorType.NOT_FOUND_RESTAURANT.getMessage())
        );

        Review review = Review.of(requestDto, member, restaurant);

        List<KeywordType> typeList = new ArrayList<>();
        for (String keyword : requestDto.getReviewKeywordList()) {
            KeywordType type = KeywordType.valueOf(keyword);
            typeList.add(type);
        }

        List<ReviewKeyword> reviewKeywordList = new ArrayList<>();
        for (KeywordType type : typeList) {
            Keyword keyword = Keyword.of(type);
            keywordRepository.save(keyword);

            ReviewKeyword reviewKeyword = ReviewKeyword.of(review, keyword);
            reviewKeywordList.add(reviewKeyword);
        }
        reviewKeywordRepository.saveAll(reviewKeywordList);

        review.updateKeyword(reviewKeywordList);
        reviewRepository.save(review);

        return ResponseUtils.ok(MessageType.REVIEW_WRITE_SUCCESSFULLY);
    }

    @Transactional
    public SuccessResponseDto<Void> updateReview(Long id, ReviewUpdateDto requestDto, Member member){

        Review review = reviewRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException(ErrorType.NOT_FOUND_REVIEW.getMessage())
        );
        if(!review.getMember().getMemberId().equals(member.getMemberId())){
            throw new IllegalArgumentException(ErrorType.NOT_WRITER.getMessage());
        }

        review.updateReview(requestDto);

        return ResponseUtils.ok(MessageType.REVIEW_MODIFY_SUCCESSFULLY);
    }

}
