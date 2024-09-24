package com.myfood.cqrs.myfood.query.domain.value_objects;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;

@Getter
@Setter
@AllArgsConstructor
public class TotalPrice {
    private String id_total_price;
    private double totalPrice;

    public TotalPrice() {
        this.totalPrice = 0;
    }
}
