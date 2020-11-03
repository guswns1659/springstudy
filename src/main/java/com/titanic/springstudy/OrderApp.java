package com.titanic.springstudy;

import com.titanic.springstudy.member.Grade;
import com.titanic.springstudy.member.Member;
import com.titanic.springstudy.member.MemberService;
import com.titanic.springstudy.order.Order;
import com.titanic.springstudy.order.OrderService;

public class OrderApp {

    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);
        System.out.println("order = " + order);
        System.out.println("order = " + order.calculatePrice());
    }
}
