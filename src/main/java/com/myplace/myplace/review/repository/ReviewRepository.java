package com.myplace.myplace.review.repository;

import com.myplace.myplace.review.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
