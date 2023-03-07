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
import com.myplace.myplace.review.dto.*;
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

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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


    @Transactional
    public SuccessResponseDto<Void> createReview(Long id, ReviewRequestDto requestDto, Member member) throws IOException {

        Restaurant restaurant = restaurantRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException(ErrorType.NOT_FOUND_RESTAURANT.getMessage())
        );

        String imgUrl = s3Uploader.upload(requestDto.getReviewPhotoUrl());

        Review review = Review.of(requestDto, imgUrl, member, restaurant);

        List<ReviewKeyword> reviewKeywordList = new ArrayList<>();

        for (String keywordStr : requestDto.getReviewKeywordList()) {

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

    @Transactional
    public SuccessResponseDto<Void> updateReview(Long id, ReviewUpdateDto requestDto, Member member) {

        Review review = reviewRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException(ErrorType.NOT_FOUND_REVIEW.getMessage())
        );

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

    // [피드, 리뷰] 상세 조회

    @Transactional(readOnly = true)
    public SuccessResponseDto<ReviewDetailDto> reviewDetail(Long id) {


        Review review = reviewRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException(ErrorType.NOT_FOUND_REVIEW.getMessage())
        );

        List<String> reviewKeywordList = new ArrayList<>();

        for(ReviewKeyword r : review.getReviewKeywordList()) {
            String keywordList = r.getKeyword().getType().getMsg();

            reviewKeywordList.add(keywordList);
        }

        int likeCount = likeRepository.findByReviewId(id).size();
        int reviewCount = reviewRepository.findByMember_Id(review.getMember().getId()).size();

        ReviewDetailDto reviewDetailDto = ReviewDetailDto.of(review, likeCount, reviewCount, reviewKeywordList);

        return ResponseUtils.ok(reviewDetailDto, MessageType.REVIEW_INQUIRY_SUCCESSFULLY);
    }

//    // 리뷰 조회
    @Transactional(readOnly = true)
    public SuccessResponseDto<List<ReviewResponseDto>> myreviews(Member member) {

        List<Review> reviewList = reviewRepository.findByMember_Id(member.getId());

        List<ReviewResponseDto> reviewResponseDtoList = new ArrayList<>();

        int reviewCount = reviewRepository.findByMember_Id(member.getId()).size();

        for(Review r : reviewList) {

            ReviewResponseDto reviewResponseDto = ReviewResponseDto.of(r, reviewCount);

            reviewResponseDtoList.add(reviewResponseDto);
        }

        return ResponseUtils.ok(reviewResponseDtoList, MessageType.REVIEW_INQUIRY_SUCCESSFULLY);
    }

//    // 피드 조회
//    @Transactional(readOnly = true)
//    public SuccessResponseDto<List<FeedReviewResponseDto>> feedReviews() {
//
//        List<Review> reviewList = reviewRepository.findAll();
//
//        List<FeedReviewResponseDto> feedreviewResponseDtoList = new ArrayList<>();
//
//        for(Review r : reviewList) {
//
//            int likeCount = likeRepository.findByReviewId(r.getId()).size();
//            int reviewCount = reviewRepository.findByMember_Id(r.getMember().getId()).size();
//
//            FeedReviewResponseDto feedreviewResponseDto = FeedReviewResponseDto.of(r, likeCount, reviewCount, );
//
//            feedreviewResponseDtoList.add(feedreviewResponseDto);
//        }
//
//        return ResponseUtils.ok(feedreviewResponseDtoList, MessageType.REVIEW_INQUIRY_SUCCESSFULLY);
//    }
}
