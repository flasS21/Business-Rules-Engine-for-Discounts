package com.code4fun.fds.entities;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
public class Item {

    private String productId;
    private String category;
    private double price;

    public Item(String productId, String category, double price) {
        this.productId = productId;
        this.category = category;
        this.price = price;
    }

}
