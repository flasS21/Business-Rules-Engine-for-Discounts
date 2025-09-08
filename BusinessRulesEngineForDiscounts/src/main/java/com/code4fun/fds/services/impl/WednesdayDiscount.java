package com.code4fun.fds.services.impl;

import com.code4fun.fds.entities.Order;
import com.code4fun.fds.services.DiscountRule;

import java.time.DayOfWeek;

public class WednesdayDiscount implements DiscountRule {

    @Override
    public boolean isApplicable(Order order) {
        return order.getDayOfWeek() == DayOfWeek.WEDNESDAY;
    }

    @Override
    public double applyDiscount(Order order) {
        return order.getOrderTotal() * 0.05;
    }

    @Override
    public int getPriority() {
        return 3;
    }

    @Override
    public String getDiscountRule() {
        return "Rule 3: On Wednesdays, all orders get 5% discount.";
    }

}
