package com.code4fun.fds.services.impl;

import com.code4fun.fds.entities.CustomerType;
import com.code4fun.fds.entities.Order;
import com.code4fun.fds.services.DiscountRule;

public class NewCustomerDiscount implements DiscountRule {

    @Override
    public boolean isApplicable(Order order) {
        return order.getCustomerType().equals(CustomerType.NEW);
    }

    @Override
    public double applyDiscount(Order order) {
        return order.getOrderTotal() * 0.10;
    }

    @Override
    public int getPriority() {
        return 1;
    }

    @Override
    public String getDiscountRule() {
        return "Rule 1: New customers get a 10% discount on their first order.";
    }

}
