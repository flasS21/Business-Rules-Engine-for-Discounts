package com.code4fun.fds;

import com.code4fun.fds.controllers.DiscountController;
import com.code4fun.fds.entities.CustomerType;
import com.code4fun.fds.entities.Item;
import com.code4fun.fds.entities.Order;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.DayOfWeek;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
@RequiredArgsConstructor
public class DiscountControllerTest {

    @Autowired
    private DiscountController discountController;

    @Test
    void NewCustomer__LargeOrder__Wednesday() {

        List<Item> items = Arrays.asList(
//                new Item("P1", "LAPTOP", 49999),
//                new Item("P2", "LAPTOP", 49999),
                new Item("P3", "CLOTHING", 1999),
                new Item("P4", "CLOTHING", 1999)
        );

//        TODO:: RULE-1 WILL BE APPLICABLE WITH 10% DISCOUNT FOR NEW CUSTOMER
//        Order order = Order.builder()
//                .customerType(CustomerType.NEW)
//                .items(items)
//                .dayOfWeek(DayOfWeek.WEDNESDAY)
//                .orderTotal(items.stream().mapToDouble(Item::getPrice).sum())
//                .build();

//        TODO:: RULE-2 WILL BE APPLICABLE WITH ORDER ABOVE 10K, 500/- FLAT DISCOUNT
//        Order order = Order.builder()
//                .customerType(CustomerType.PREMIUM)
//                .items(items)
//                .dayOfWeek(DayOfWeek.WEDNESDAY)
//                .orderTotal(items.stream().mapToDouble(Item::getPrice).sum())
//                .build();

//        TODO:: RULE-2 WILL BE APPLICABLE WITH ORDER ABOVE 10K, GETS 500/- FLAT DISCOUNT
        Order order = Order.builder()
                .customerType(CustomerType.REGULAR)
                .items(items)
                .dayOfWeek(DayOfWeek.WEDNESDAY)
                .orderTotal(items.stream().mapToDouble(Item::getPrice).sum())
                .build();

        discountController.calculateDiscount(order);

    }


    @Test
    void RegularCustomer__12KOrder__Friday() {

        List<Item> items = Arrays.asList(
                new Item("PRD_01", "HOME_APPLIANCES", 2_000),
                new Item("PRD_02", "SMARTWATCHES", 4_000),
                new Item("PRD_03", "STORAGE_DEVICES", 6_000)
        );

        Order order = new Order(
                CustomerType.REGULAR,
                items,
                DayOfWeek.FRIDAY
        );

        discountController.calculateDiscount(order);

    }


    @Test
    void PremiumCustomer__8000KOrder__Wednesday() {

        // HARDCODING VALUES DIRECTLY INTO ORDER
        Order order = new Order(
                CustomerType.PREMIUM,
                List.of(new Item("SUB01", "SUBSCRIPTION", 8000)),
                DayOfWeek.WEDNESDAY
        );

        discountController.calculateDiscount(order);

    }

    // TODO :: LET'S DO AN NEGATIVE TEST --- "NO DISCOUNT APPLICABLE"
    @Test
    void No__Discount__Applicable() {

        Order order = new Order(
                CustomerType.REGULAR,
                List.of(new Item("AMZN-007", "AMAZON-FIRE-STICK", 2999)),
                DayOfWeek.MONDAY
        );

        discountController.calculateDiscount(order);

    }

}
