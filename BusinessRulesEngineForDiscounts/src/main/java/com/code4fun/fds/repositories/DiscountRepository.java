package com.code4fun.fds.repositories;

import com.code4fun.fds.entities.CustomerType;
import com.code4fun.fds.entities.Item;
import com.code4fun.fds.entities.Order;
import com.code4fun.fds.services.DiscountRule;
import com.code4fun.fds.services.impl.NewCustomerDiscount;
import com.code4fun.fds.services.impl.OrderAbove10KDiscount;
import com.code4fun.fds.services.impl.WednesdayDiscount;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;
import java.util.List;
import java.util.Set;

@Component
public class DiscountRepository {

    //  TODO :: GENERATE METHODS WHICH RETURNS LIST/SET OF "DISCOUNT-RULES"
    public Set<DiscountRule> getDiscountRules() {

        return Set.of(
                new NewCustomerDiscount(),
                new WednesdayDiscount(),
                new OrderAbove10KDiscount());

    }

    // TODO :: LIST OF ITEMS
    private static List<Item> getItems() {

        Item item1 = Item.builder()
                .productId("CASIO-F91W")
                .category("WRIST-WATCHES")
                .price(999.00).build();

        Item item2 = Item.builder()
                .productId("HP PAVILION 15 N-259TX")
                .category("LAPTOP")
                .price(999.00).build();

        Item item3 = Item.builder()
                .productId("BRUTE-ORIGINAL")
                .category("PERFUME")
                .price(999.00).build();

        return List.of(item1, item2, item3);

    }

    // TODO :: TOTAL ORDER VALUE
    public static double getOrderTotal() {
        return getItems()
                .stream()
                .mapToDouble(Item::getPrice)
                .sum();
    }


    // TODO :: GENERATE METHOD WHICH RETURNS "ORDER"
    public static Order getOrder() {

        return Order.builder()
                .customerType(CustomerType.REGULAR)
                .items(getItems())
                .orderTotal(getOrderTotal())
                .dayOfWeek(DayOfWeek.WEDNESDAY).build();

    }

}
