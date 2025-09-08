package com.code4fun.fds.entities;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.DayOfWeek;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
public class Order {
    private CustomerType customerType;
    private List<Item> items;
    private double orderTotal;
    private DayOfWeek dayOfWeek;

    public Order(CustomerType customerType, List<Item> items, double orderTotal, DayOfWeek dayOfWeek) {
        this.customerType = customerType;
        this.items = items;
        this.dayOfWeek = dayOfWeek;
        this.orderTotal = items.stream().mapToDouble(Item::getPrice).sum();
    }

    // CUSTOMISED CONSTRUCTOR
    public Order(
            CustomerType customerType,
            List<Item> items,
            DayOfWeek dayOfWeek) {
        this.customerType = customerType;
        this.items = items;
        this.dayOfWeek = dayOfWeek;
        this.orderTotal = items.stream().mapToDouble(Item::getPrice).sum();
    }
}
