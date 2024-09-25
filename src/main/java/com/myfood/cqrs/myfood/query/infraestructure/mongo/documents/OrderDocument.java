package com.myfood.cqrs.myfood.query.infraestructure.mongo.documents;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.AllArgsConstructor;

@Document("orders")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDocument {
    @Id
    private String id;
    private OrderDateDocument date;
    private OrderStateDocument state;
    private List<DishDocument> dishes;
    private TotalPriceDocument totalPrice;
}
