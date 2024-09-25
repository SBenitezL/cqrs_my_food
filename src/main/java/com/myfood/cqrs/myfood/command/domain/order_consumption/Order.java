package com.myfood.cqrs.myfood.command.domain.order_consumption;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.myfood.cqrs.myfood.command.domain.order_consumption.value_objects.Dish;
import com.myfood.cqrs.myfood.command.domain.order_consumption.value_objects.OrderDate;
import com.myfood.cqrs.myfood.command.domain.order_consumption.value_objects.OrderState;
import com.myfood.cqrs.myfood.command.domain.order_consumption.value_objects.TotalPrice;
import com.myfood.cqrs.myfood.command.infrastucture.exceptionHandler.ownException.ObjectNotFoundException;
import com.myfood.cqrs.myfood.command.infrastucture.exceptionHandler.ownException.ObjectNullException;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Order {
    private String id;
    private OrderDate date;
    private OrderState state;
    private List<Dish> dishes;
    private TotalPrice totalPrice;
    private Date actualDate;

    public Order() {
        this.id = UUID.randomUUID().toString();
        this.date = new OrderDate();
        this.state = new OrderState(0);
        this.dishes = new ArrayList<>();
        this.totalPrice = new TotalPrice();
        this.actualDate = new Date();
    }

    public boolean changeState(int state) {
        this.state = new OrderState(state);
        this.getState().setId_state(id);
        this.actualDate = new Date();
        return true;
    }

    public boolean addDish(Dish dish) {
        if (this.dishes == null)
            throw new ObjectNullException("Dishes is null...");

        if (dish == null)
            throw new ObjectNullException("Dish is null...");

        this.dishes.add(dish);
        this.actualDate = new Date();
        return true;
    }

    public boolean removeDish(String id) {
        if (this.dishes == null)
            throw new ObjectNullException("Dishes is null...");

        if (id.isBlank())
            throw new ObjectNullException("Dish's id is null...");

        for (int i = 0; i < this.dishes.size(); i++) {
            if (this.dishes.get(i).getId_dish().equals(id)) {
                this.dishes.remove(i);
                this.actualDate = new Date();
                return true;
            }
        }

        throw new ObjectNotFoundException("Dish was not found...");
    }

}
