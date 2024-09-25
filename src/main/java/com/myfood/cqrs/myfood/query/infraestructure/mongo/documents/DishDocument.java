package com.myfood.cqrs.myfood.query.infraestructure.mongo.documents;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document("dishes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DishDocument {
    @Id
    private String id_dish;
    private String name;
    private List<IngredientDocument> ingredients;
    private double price;

}
