package com.myfood.cqrs.myfood.command.domain.order_consumption.value_objects;

import java.util.List;

import com.myfood.cqrs.myfood.command.infrastucture.exceptionHandler.ownException.BusinessRuleException;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TotalPrice {
    private String id_total_price;
    private double totalPrice;

    public TotalPrice() {
        this.totalPrice = 0;
    }

    public double calculateTotalPrice(List<Dish> dishes) {
        if (dishes.isEmpty())
            throw new BusinessRuleException("there are no dish to calculate a total price...");

        this.totalPrice = 0;
        dishes.forEach(dish -> this.totalPrice = this.totalPrice + dish.getPrice());
        return this.totalPrice;
    }

}
