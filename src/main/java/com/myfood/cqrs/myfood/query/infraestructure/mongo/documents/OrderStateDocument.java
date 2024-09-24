package com.myfood.cqrs.myfood.query.infraestructure.mongo.documents;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.AllArgsConstructor;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderStateDocument {
    private String id_state;
    private String state;
}
