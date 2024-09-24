package com.myfood.cqrs.myfood.query.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.myfood.cqrs.myfood.query.domain.value_objects.Dish;
import com.myfood.cqrs.myfood.query.domain.value_objects.OrderDate;
import com.myfood.cqrs.myfood.query.domain.value_objects.OrderState;
import com.myfood.cqrs.myfood.query.domain.value_objects.TotalPrice;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;

@Getter
@Setter
@AllArgsConstructor
public class Order {
    private String id_order;
    private OrderDate date;
    private OrderState state;
    private List<Dish> dishes;
    private TotalPrice totalPrice;

    public Order() {
        this.id_order = UUID.randomUUID().toString();
        this.date = new OrderDate();
        this.state = new OrderState();
        this.dishes = new ArrayList<>();
        this.totalPrice = new TotalPrice();
    }
}
