package com.titanic.springstudy;

import com.titanic.springstudy.member.Grade;
import com.titanic.springstudy.member.Member;
import com.titanic.springstudy.member.MemberService;
import com.titanic.springstudy.member.MemberServiceImpl;
import com.titanic.springstudy.order.Order;
import com.titanic.springstudy.order.OrderService;
import com.titanic.springstudy.order.OrderServiceImpl;

public class OrderApp {

    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        OrderService orderService = new OrderServiceImpl();

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);
        System.out.println("order = " + order);
        System.out.println("order = " + order.calculatePrice());
    }
}
