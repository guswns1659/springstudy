package com.titanic.springstudy.order;

public interface OrderService {

    Order createOrder(Long memberId, String itemName, int itemPrice);
}
