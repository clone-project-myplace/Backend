package com.myplace.myplace.visit.service;

import com.myplace.myplace.common.MessageType;
import com.myplace.myplace.common.ResponseUtils;
import com.myplace.myplace.common.SuccessResponseDto;
import com.myplace.myplace.member.entity.Member;
import com.myplace.myplace.member.repository.MemberRepository;
import com.myplace.myplace.restaurant.repository.RestaurantRepository;
import com.myplace.myplace.review.entity.Review;
import com.myplace.myplace.review.repository.ReviewRepository;
import com.myplace.myplace.visit.dto.VisitResponseDto;
import com.myplace.myplace.visit.entity.Visit;
import com.myplace.myplace.visit.repository.VisitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VisitService {

    private final VisitRepository visitRepository;
    private final MemberRepository memberRepository;
    private final RestaurantRepository restaurantRepository;
    private final ReviewRepository reviewRepository;

    @PostConstruct
    public void saveSampleVisit() {

        Member member = Member.of("user1", "$2a$10$mx7MQhug9XOtt3vWRRZkPOVDyMzYtYMQXvQVd/Pb3FgpUU3ohTExu", "닉네임1", "sample");
        memberRepository.save(member);

        visitRepository.save(Visit.of(member, restaurantRepository.findById(1L).get(), "23.1.3.화"));
        visitRepository.save(Visit.of(member, restaurantRepository.findById(2L).get(), "23.1.10.목"));
        visitRepository.save(Visit.of(member, restaurantRepository.findById(3L).get(), "23.1.25.수"));
        visitRepository.save(Visit.of(member, restaurantRepository.findById(4L).get(), "23.1.31.화"));
        visitRepository.save(Visit.of(member, restaurantRepository.findById(5L).get(), "23.2.7.화"));
        visitRepository.save(Visit.of(member, restaurantRepository.findById(6L).get(), "23.2.18.토"));
        visitRepository.save(Visit.of(member, restaurantRepository.findById(7L).get(), "23.11.6.일"));
        visitRepository.save(Visit.of(member, restaurantRepository.findById(8L).get(), "22.9.15.목"));
        visitRepository.save(Visit.of(member, restaurantRepository.findById(9L).get(),"22.8.1.월"));
        visitRepository.save(Visit.of(member, restaurantRepository.findById(10L).get(), "22.8.20.토"));
        visitRepository.save(Visit.of(member, restaurantRepository.findById(11L).get(), "22.7.3.일"));
        visitRepository.save(Visit.of(member, restaurantRepository.findById(12L).get(), "22.6.16.목"));
        visitRepository.save(Visit.of(member, restaurantRepository.findById(13L).get(), "22.6.24.금"));
        visitRepository.save(Visit.of(member, restaurantRepository.findById(14L).get(), "22.5.10.화"));

    }

    // [방문] 조회
    @Transactional
    public SuccessResponseDto<List<VisitResponseDto>> visitedRestaurants(Member member) {

        List<Visit> visitList = visitRepository.findAllByMember_MemberId(member.getMemberId());


        List<VisitResponseDto> visitResponseDtoList = new ArrayList<>();

        for(Visit v : visitList) {

            Optional<Review> review = reviewRepository.findByMemberAndRestaurant(member, v.getRestaurant());

            boolean isReviewed = false;

            if(review.isPresent()) {
                isReviewed = true;
            }

            VisitResponseDto visitResponseDto = VisitResponseDto.of(v.getRestaurant().getId(), v.getRestaurant().getName(), v.getVisitDate(), isReviewed);

            visitResponseDtoList.add(visitResponseDto);

        }

        return ResponseUtils.ok(visitResponseDtoList, MessageType.REVIEW_INQUIRY_SUCCESSFULLY);

    }
}
