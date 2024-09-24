package com.myfood.cqrs.myfood.query.infraestructure.mongo.documents;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DishDocument {
    private String id_dish;
    private String name;
    private List<IngredientDocument> ingredients;
    private double price;

}
