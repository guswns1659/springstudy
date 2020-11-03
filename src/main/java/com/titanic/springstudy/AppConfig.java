package com.titanic.springstudy;

import com.titanic.springstudy.discount.DiscountPolicy;
import com.titanic.springstudy.discount.FixDiscountPolicy;
import com.titanic.springstudy.member.MemberRepository;
import com.titanic.springstudy.member.MemberService;
import com.titanic.springstudy.member.MemberServiceImpl;
import com.titanic.springstudy.member.MemoryMemberRepository;
import com.titanic.springstudy.order.OrderService;
import com.titanic.springstudy.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    private MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    public DiscountPolicy discountPolicy() {
        return new FixDiscountPolicy();
    }
}
