package com.myfood.cqrs.myfood.query.infraestructure.mongo.documents;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class IngredientDocument {
    private String id_date;
    private String name;
}
