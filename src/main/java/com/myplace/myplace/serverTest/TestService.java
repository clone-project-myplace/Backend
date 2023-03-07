package com.myplace.myplace.serverTest;

import com.myplace.myplace.member.entity.Member;
import com.myplace.myplace.member.repository.MemberRepository;
import com.myplace.myplace.restaurant.repository.RestaurantRepository;
import com.myplace.myplace.visit.entity.Visit;
import com.myplace.myplace.visit.repository.VisitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
@RequiredArgsConstructor
public class TestService {

    private final VisitRepository visitRepository;
    private final MemberRepository memberRepository;
    private final RestaurantRepository restaurantRepository;


    public TestResponseDto test() {
        return new TestResponseDto("hello");
    }

    @PostConstruct
    public void saveSampleVisit() {

        Member member = Member.of("user1", "$2a$10$mx7MQhug9XOtt3vWRRZkPOVDyMzYtYMQXvQVd/Pb3FgpUU3ohTExu", "닉네임1", "https://myplace-bucket.s3.ap-northeast-2.amazonaws.com/default_profile.jpeg");
        Member member2 = Member.of("user2", "$2a$10$mx7MQhug9XOtt3vWRRZkPOVDyMzYtYMQXvQVd/Pb3FgpUU3ohTExu", "닉네임2", "https://myplace-bucket.s3.ap-northeast-2.amazonaws.com/default_profile.jpeg");
        Member member3 = Member.of("user3", "$2a$10$mx7MQhug9XOtt3vWRRZkPOVDyMzYtYMQXvQVd/Pb3FgpUU3ohTExu", "닉네임3", "https://myplace-bucket.s3.ap-northeast-2.amazonaws.com/default_profile.jpeg");

        memberRepository.save(member);
        memberRepository.save(member2);
        memberRepository.save(member3);

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

        visitRepository.save(Visit.of(member2, restaurantRepository.findById(1L).get(), "23.3.7.화"));
        visitRepository.save(Visit.of(member2, restaurantRepository.findById(2L).get(), "23.3.2.목"));
        visitRepository.save(Visit.of(member2, restaurantRepository.findById(3L).get(), "23.2.25.토"));
        visitRepository.save(Visit.of(member2, restaurantRepository.findById(4L).get(), "23.2.7.화"));
        visitRepository.save(Visit.of(member2, restaurantRepository.findById(5L).get(), "23.1.24.화"));

        visitRepository.save(Visit.of(member3, restaurantRepository.findById(9L).get(),"22.8.1.월"));
        visitRepository.save(Visit.of(member3, restaurantRepository.findById(10L).get(), "22.8.20.토"));
        visitRepository.save(Visit.of(member3, restaurantRepository.findById(11L).get(), "22.7.3.일"));
        visitRepository.save(Visit.of(member3, restaurantRepository.findById(12L).get(), "22.6.16.목"));
        visitRepository.save(Visit.of(member3, restaurantRepository.findById(13L).get(), "22.6.24.금"));
        visitRepository.save(Visit.of(member3, restaurantRepository.findById(14L).get(), "22.5.10.화"));

    }
}
