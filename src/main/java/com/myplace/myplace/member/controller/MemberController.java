package com.myplace.myplace.member.controller;

import com.myplace.myplace.common.SuccessResponseDto;
import com.myplace.myplace.member.dto.LoginRequestDto;
import com.myplace.myplace.member.dto.LoginResponseDto;
import com.myplace.myplace.member.dto.ProfileRequestDto;
import com.myplace.myplace.member.dto.SignupRequestDto;
import com.myplace.myplace.member.service.MemberService;
import com.myplace.myplace.security.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/members")
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/signup")
    public SuccessResponseDto<Void> signup(@Valid @RequestBody SignupRequestDto requestDto) {
        return memberService.signup(requestDto);
    }

    @PostMapping("/login")
    public SuccessResponseDto<LoginResponseDto> login(@RequestBody LoginRequestDto requestDto, HttpServletResponse response) {
        return memberService.login(requestDto, response);
    }

    @PostMapping(value = "/profile")
    public SuccessResponseDto<Void> uploadProfile(@ModelAttribute ProfileRequestDto requestDto,
                                                  @AuthenticationPrincipal UserDetailsImpl userDetails) throws IOException {
        return memberService.uploadPhoto(requestDto, userDetails.getUser());
    }
}
