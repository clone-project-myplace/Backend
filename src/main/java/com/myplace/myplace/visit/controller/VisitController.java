package com.myplace.myplace.visit.controller;

import com.myplace.myplace.common.SuccessResponseDto;
import com.myplace.myplace.security.UserDetailsImpl;
import com.myplace.myplace.visit.dto.VisitResponseDto;
import com.myplace.myplace.visit.service.VisitService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class VisitController {

    private final VisitService visitService;

    @GetMapping("/reviews/visits")
    public SuccessResponseDto<List<VisitResponseDto>> visitedRestaurants(@AuthenticationPrincipal UserDetailsImpl userDetails) {

        return visitService.visitedRestaurants(userDetails == null ? null : userDetails.getUser());
    }
}
