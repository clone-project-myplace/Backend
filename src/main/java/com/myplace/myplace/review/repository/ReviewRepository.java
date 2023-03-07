package com.myplace.myplace.review.repository;

import com.myplace.myplace.member.entity.Member;
import com.myplace.myplace.restaurant.entity.Restaurant;
import com.myplace.myplace.review.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    Optional<Review> findByMemberAndRestaurant(Member member, Restaurant restaurant);

    List<Review> findReviewById(Long id);

    List<Review> findByMember_Id(Long id);

}
