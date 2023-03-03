package com.myplace.myplace.security;

import com.myplace.myplace.member.entity.Member;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;


public class UserDetailsImpl implements UserDetails {

    private final Member member;
    private final String memberName;

    // 인증이 완료된 사용자 추가하기
    public UserDetailsImpl(Member member, String memberName) {
        this.member = member;
        this.memberName = memberName;
    }

    public Member getUser() {
        return member;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority("ROLE_USER");
        Collection<GrantedAuthority> authorities = new ArrayList<>();   // 사용자 권한을 GrantedAuthority 로 추상화
        authorities.add(simpleGrantedAuthority);

        return authorities; // GrantedAuthority 로 추상화된 사용자 권한 반환
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return this.memberName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

}
