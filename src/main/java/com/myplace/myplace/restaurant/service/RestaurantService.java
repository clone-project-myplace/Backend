package com.myplace.myplace.restaurant.service;

import com.myplace.myplace.restaurant.entity.Restaurant;
import com.myplace.myplace.restaurant.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
@RequiredArgsConstructor
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;

    @PostConstruct
    public void saveSampleRestaurant() {

        restaurantRepository.save(Restaurant.of("북경", "서울특별시 마포구 서교동"));
        restaurantRepository.save(Restaurant.of("카라멘야", "서울특별시 서대문구 창천동"));
        restaurantRepository.save(Restaurant.of("틈새라면 공덕점", "서울특별시 마포구 도화동"));
        restaurantRepository.save(Restaurant.of("고삼이 신촌점", "서울특별시 서대문구 창천동"));
        restaurantRepository.save(Restaurant.of("상해소흘", "서울특별시 마포구 연남동"));
        restaurantRepository.save(Restaurant.of("온실 다이닝 & 와인바", "서울특별시 마포구 연남"));
        restaurantRepository.save(Restaurant.of("청수산", "경기도 파주시 동패동"));
        restaurantRepository.save(Restaurant.of("에그앤플라워", "서울특별시 용산구 용산동"));
        restaurantRepository.save(Restaurant.of("웍셔너리", "서울특별시 강남구 신사동"));
        restaurantRepository.save(Restaurant.of("남녘들밥상", "전라남도 순천시 풍덕동"));
        restaurantRepository.save(Restaurant.of("환장라멘", "울산광역시 북구 송정동"));
        restaurantRepository.save(Restaurant.of("한스드림베이커리", "경북 포항시 북구 두호동"));
        restaurantRepository.save(Restaurant.of("덕클", "울산광역시 중구 태화동"));
        restaurantRepository.save(Restaurant.of("그라파 피자리아", "울산광역시 동구 방어동"));

    }
}
