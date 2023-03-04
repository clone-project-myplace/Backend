package com.myplace.myplace.member.service;

import com.myplace.myplace.common.ErrorType;
import com.myplace.myplace.common.MessageType;
import com.myplace.myplace.common.ResponseUtils;
import com.myplace.myplace.common.SuccessResponseDto;
import com.myplace.myplace.jwt.JwtUtil;
import com.myplace.myplace.member.dto.SignupRequestDto;
import com.myplace.myplace.member.entity.Member;
import com.myplace.myplace.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;

    public SuccessResponseDto<Void> signup(SignupRequestDto requestDto) {

        String encodePw = passwordEncoder.encode(requestDto.getMemberPw());

        // 아이디 중복 확인
        Optional<Member> foundById = memberRepository.findByMemberId(requestDto.getMemberId());
        if (foundById.isPresent()) {
            throw new IllegalArgumentException(ErrorType.DUPLICATED_MEMBER_ID.getMessage());
        }

        // 닉네임 중복 확인
        Optional<Member> foundByName = memberRepository.findByMemberName(requestDto.getMemberName());
        if (foundByName.isPresent()) {
            throw new IllegalArgumentException(ErrorType.DUPLICATED_MEMBER_NAME.getMessage());
        }

        Member member = Member.of(requestDto, encodePw);
        memberRepository.save(member);

        return ResponseUtils.ok(MessageType.SIGNUP_SUCCESSFULLY);
    }
}
