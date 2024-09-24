package com.myfood.cqrs.myfood.query.domain.value_objects;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Dish {
    private String id_dish;
    private String name;
    private List<Ingredient> ingredients;
    private double price;

    public Dish(String name, double price) {
        this.id_dish = UUID.randomUUID().toString();
        this.name = name;
        this.price = price;
        this.ingredients = new ArrayList<>();
    }

}
