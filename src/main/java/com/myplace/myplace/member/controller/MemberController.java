package com.myplace.myplace.member.controller;

import com.myplace.myplace.common.SuccessResponseDto;
import com.myplace.myplace.member.dto.SignupRequestDto;
import com.myplace.myplace.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/members")
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/signup")
    public SuccessResponseDto<Void> signup(@Valid @RequestBody SignupRequestDto requestDto) {
        return memberService.signup(requestDto);
    }
}
