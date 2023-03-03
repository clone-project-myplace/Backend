package com.myplace.myplace.member.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 30)
    private String memberId;

    @Column(nullable = false, length = 30)
    private String memberPw;

    @Column(nullable = false, length = 30)
    private String memberName;

    @Column(nullable = false)
    private String imgUrl;

    @Builder
    private Member(String memberId, String memberPw, String memberName, String imgUrl) {
        this.memberId = memberId;
        this.memberPw = memberPw;
        this.memberName = memberName;
        this.imgUrl = imgUrl;
    }

    public static Member of(String memberId, String memberPw, String memberName, String imgUrl) {
        return Member.builder()
                .memberId(memberId)
                .memberPw(memberPw)
                .memberName(memberName)
                .imgUrl(imgUrl)
                .build();
    }
}
