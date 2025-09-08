package com.code4fun.fds;

import com.code4fun.fds.controllers.DiscountController;
import com.code4fun.fds.entities.Order;
import com.code4fun.fds.repositories.DiscountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class BusinessRulesEngineForDiscountsApplication implements CommandLineRunner {

    private final DiscountController discountController;

    public static void main(String[] args) {
        SpringApplication.run(BusinessRulesEngineForDiscountsApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Order order = DiscountRepository.getOrder();
        discountController.calculateDiscount(order);
    }
}
