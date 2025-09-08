package com.code4fun.fds.controllers;

import com.code4fun.fds.entities.Order;
import com.code4fun.fds.repositories.DiscountRepository;
import com.code4fun.fds.services.DiscountRule;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DiscountController {

    private final DiscountRepository discountRepository;

    public void calculateDiscount(Order order) {

        DiscountRule bestRule = null;

        // TODO ::  FIND THE BEST RULE 
        for (DiscountRule rule : discountRepository.getDiscountRules()) {
            if (rule.isApplicable(order)) {
                if (bestRule == null || rule.getPriority() < bestRule.getPriority()) {
                    bestRule = rule;
                }
            }
        }

        // TODO :: APPLY THE DISCOUNT (IF ANY RULE FOUND) 
        if (bestRule != null) {

            double discount = bestRule.applyDiscount(order);

            System.out.println("DISCOUNT RULE NAME\t:: " + bestRule.getDiscountRule());
            System.out.println("TOTAL ORDER VALUE\t:: " + order.getOrderTotal());
            System.out.println("DISCOUNT APPLIED\t:: " + discount);
            System.out.println("FINAL PAYABLE AMOUNT\t:: " + (order.getOrderTotal() - discount));

        } else {
            System.out.println("DISCOUNT NOT APPLICABLE!");
        }

    }

}
