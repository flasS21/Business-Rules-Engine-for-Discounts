package com.code4fun.fds.services.impl;

import com.code4fun.fds.entities.Order;
import com.code4fun.fds.services.DiscountRule;

public class OrderAbove10KDiscount implements DiscountRule {

    @Override
    public boolean isApplicable(Order order) {
        return order.getOrderTotal() > 10_000;
    }

    @Override
    public double applyDiscount(Order order) {
        return 500.00;
    }

    @Override
    public int getPriority() {
        return 2;
    }

    @Override
    public String getDiscountRule() {
        return "Rule 2: Orders above ₹10,000 get a flat ₹500 discount.";
    }
}
