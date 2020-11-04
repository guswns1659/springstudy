package com.titanic.springstudy;

import com.titanic.springstudy.discount.DiscountPolicy;
import com.titanic.springstudy.discount.FixDiscountPolicy;
import com.titanic.springstudy.discount.RateDiscountPolicy;
import com.titanic.springstudy.member.MemberRepository;
import com.titanic.springstudy.member.MemberService;
import com.titanic.springstudy.member.MemberServiceImpl;
import com.titanic.springstudy.member.MemoryMemberRepository;
import com.titanic.springstudy.order.OrderService;
import com.titanic.springstudy.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
