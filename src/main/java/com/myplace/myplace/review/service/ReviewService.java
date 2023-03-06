package com.myplace.myplace.review.service;

import com.myplace.myplace.common.ErrorType;
import com.myplace.myplace.common.MessageType;
import com.myplace.myplace.common.ResponseUtils;
import com.myplace.myplace.common.SuccessResponseDto;
import com.myplace.myplace.like.repository.LikeRepository;
import com.myplace.myplace.member.entity.Member;
import com.myplace.myplace.member.repository.MemberRepository;
import com.myplace.myplace.restaurant.entity.Restaurant;
import com.myplace.myplace.restaurant.repository.RestaurantRepository;
import com.myplace.myplace.review.dto.ReviewRequestDto;
import com.myplace.myplace.review.dto.ReviewResponseDto;
import com.myplace.myplace.review.dto.ReviewUpdateDto;
import com.myplace.myplace.review.entity.Keyword;
import com.myplace.myplace.review.entity.KeywordType;
import com.myplace.myplace.review.entity.Review;
import com.myplace.myplace.review.entity.ReviewKeyword;
import com.myplace.myplace.review.repository.KeywordRepository;
import com.myplace.myplace.review.repository.ReviewKeywordRepository;
import com.myplace.myplace.review.repository.ReviewRepository;
import com.myplace.myplace.s3.service.S3Uploader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final RestaurantRepository restaurantRepository;
    private final KeywordRepository keywordRepository;
    private final ReviewKeywordRepository reviewKeywordRepository;
    private final LikeRepository likeRepository;
    private final MemberRepository memberRepository;

    private final S3Uploader s3Uploader;


    // 리뷰 작성
    @Transactional
    public SuccessResponseDto<Void> createReview(Long id, ReviewRequestDto requestDto, Member member) throws IOException {

        Restaurant restaurant = restaurantRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException(ErrorType.NOT_FOUND_RESTAURANT.getMessage())
        );

        String imgUrl = s3Uploader.upload(requestDto.getReviewPhotoUrl());

        member.update(imgUrl);
        memberRepository.save(member);

        Review review = Review.of(requestDto, imgUrl, member, restaurant);

        List<ReviewKeyword> reviewKeywordList = new ArrayList<>();

        for (String keywordStr : requestDto.getKeywordList()) {

            KeywordType type = KeywordType.valueOf(keywordStr);
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


    // [피드, 리뷰] 상세 조회
    @Transactional(readOnly = true)
    public SuccessResponseDto<ReviewResponseDto> reviewDetail(Long id) {


        Review review = reviewRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException(ErrorType.NOT_FOUND_REVIEW.getMessage())
        );

        int likeCount = likeRepository.countById(id);
        int reviewCount = reviewRepository.countById(id);

        ReviewResponseDto reviewResponseDto = ReviewResponseDto.of(review, likeCount, reviewCount);

        return ResponseUtils.ok(reviewResponseDto, MessageType.REVIEW_INQUIRY_SUCCESSFULLY);
   }


    @Transactional
    public SuccessResponseDto<Void> updateReview(Long id, ReviewUpdateDto requestDto, Member member) {

        if(!review.getMember().getMemberId().equals(member.getMemberId())) {
            throw new IllegalArgumentException(ErrorType.NOT_WRITER.getMessage());
        }

        review.updateReview(requestDto);

        return ResponseUtils.ok(MessageType.REVIEW_MODIFY_SUCCESSFULLY);
    }

    @Transactional
    public SuccessResponseDto<Void> deleteReview(Long id, Member member) {

        Review review = reviewRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException(ErrorType.NOT_FOUND_REVIEW.getMessage())
        );
        if(!review.getMember().getMemberId().equals(member.getMemberId())){
            throw new IllegalArgumentException(ErrorType.NOT_WRITER.getMessage());
        }

        reviewRepository.deleteById(id);

        return ResponseUtils.ok(MessageType.REVIEW_DELETE_SUCCESSFULLY);
    }
}
