package com.myplace.myplace.like.repository;

import com.myplace.myplace.like.entity.Like;
import com.myplace.myplace.member.entity.Member;
import com.myplace.myplace.review.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LikeRepository extends JpaRepository<Like, Long> {
    Optional<Like> findByMemberAndReview(Member member, Review review);
    List<Like> findByReviewId(Long id);

    int countById(Long id);
}
