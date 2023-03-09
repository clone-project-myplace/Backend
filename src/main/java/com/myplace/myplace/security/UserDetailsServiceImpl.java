package com.myplace.myplace.security;

import com.myplace.myplace.common.ErrorType;
import com.myplace.myplace.member.entity.Member;
import com.myplace.myplace.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String memberName) throws UsernameNotFoundException {
        Member member = memberRepository.findByMemberName(memberName)
                .orElseThrow(() -> new UsernameNotFoundException(ErrorType.NOT_FOUND_USER.getMessage()));   // 사용자가 DB 에 없으면 예외처리

        return new UserDetailsImpl(member, member.getMemberName());   // 사용자 정보를 UserDetails 로 반환
    }

}
