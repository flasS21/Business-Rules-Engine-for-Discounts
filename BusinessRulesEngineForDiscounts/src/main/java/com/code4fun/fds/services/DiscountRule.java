package com.code4fun.fds.services;

import com.code4fun.fds.entities.Order;

public interface DiscountRule {

    boolean isApplicable(Order order);

    double applyDiscount(Order order);

    int getPriority();

    String getDiscountRule();

}
