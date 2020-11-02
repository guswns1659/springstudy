package com.titanic.springstudy.order;

import com.titanic.springstudy.discount.DiscountPolicy;
import com.titanic.springstudy.discount.FixDiscountPolicy;
import com.titanic.springstudy.member.Member;
import com.titanic.springstudy.member.MemberRepository;
import com.titanic.springstudy.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
