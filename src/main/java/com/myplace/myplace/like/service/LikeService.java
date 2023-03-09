package com.myplace.myplace.like.service;

import com.myplace.myplace.common.ErrorType;
import com.myplace.myplace.common.MessageType;
import com.myplace.myplace.common.ResponseUtils;
import com.myplace.myplace.common.SuccessResponseDto;
import com.myplace.myplace.like.dto.LikeResponseDto;
import com.myplace.myplace.like.entity.Like;
import com.myplace.myplace.like.repository.LikeRepository;
import com.myplace.myplace.member.entity.Member;
import com.myplace.myplace.review.entity.Review;
import com.myplace.myplace.review.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LikeService {

    private final LikeRepository likeRepository;
    private final ReviewRepository reviewRepository;

    @Transactional
    public SuccessResponseDto<LikeResponseDto> likeReview(Long id, Member member){

        Optional<Review> review = reviewRepository.findById(id);
        if(review.isEmpty()){
            throw new IllegalArgumentException(ErrorType.NOT_FOUND_REVIEW.getMessage());
        }

        Boolean isPushed = false;

        Optional<Like> findLike = likeRepository.findByMemberAndReview(member, review.get());
        int likeCount = likeRepository.findByReviewId(review.get().getId()).size();
        if(findLike.isEmpty()){
            Like like = Like.of(member, review.get());
            likeRepository.save(like);
        } else {
            likeRepository.delete(findLike.get());
            return ResponseUtils.ok(LikeResponseDto.from(likeCount-1, isPushed), MessageType.LIKE_DELETE_SUCCESSFULLY );
        }

        isPushed = true;
        return ResponseUtils.ok(LikeResponseDto.from(likeCount+1, isPushed), MessageType.LIKE_ADD_SUCCESSFULLY);
    }
}
