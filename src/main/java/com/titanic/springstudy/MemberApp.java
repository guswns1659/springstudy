package com.titanic.springstudy;

import com.titanic.springstudy.member.Grade;
import com.titanic.springstudy.member.Member;
import com.titanic.springstudy.member.MemberService;
import com.titanic.springstudy.member.MemberServiceImpl;

public class MemberApp {

    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("find Member = " + findMember.getName());
    }
}
