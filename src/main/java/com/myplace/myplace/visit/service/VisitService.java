package com.myplace.myplace.visit.service;

import com.myplace.myplace.common.MessageType;
import com.myplace.myplace.common.ResponseUtils;
import com.myplace.myplace.common.SuccessResponseDto;
import com.myplace.myplace.member.entity.Member;
import com.myplace.myplace.review.entity.Review;
import com.myplace.myplace.review.repository.ReviewRepository;
import com.myplace.myplace.visit.dto.VisitResponseDto;
import com.myplace.myplace.visit.entity.Visit;
import com.myplace.myplace.visit.repository.VisitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VisitService {

    private final VisitRepository visitRepository;
    private final ReviewRepository reviewRepository;

    // [방문] 조회
    @Transactional
    public SuccessResponseDto<List<VisitResponseDto>> visitedRestaurants(Member member) {

        List<VisitResponseDto> visitResponseDtoList = new ArrayList<>();

        if (member == null) {
            return ResponseUtils.ok(visitResponseDtoList, MessageType.REVIEW_INQUIRY_SUCCESSFULLY);
        }

        List<Visit> visitList = visitRepository.findAllByMember_MemberId(member.getMemberId());

        for(Visit v : visitList) {

            Optional<List<Review>> review = reviewRepository.findByMemberAndRestaurant(member, v.getRestaurant());

            boolean isReviewed = false;

            if(review.get().size() != 0) {
                isReviewed = true;
            }

            VisitResponseDto visitResponseDto = VisitResponseDto.of(v.getRestaurant().getId(), v.getRestaurant().getName(), v.getVisitDate(), isReviewed);

            visitResponseDtoList.add(visitResponseDto);

        }

        return ResponseUtils.ok(visitResponseDtoList, MessageType.REVIEW_INQUIRY_SUCCESSFULLY);

    }
}
