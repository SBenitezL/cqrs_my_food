package com.myfood.cqrs.myfood.query.infraestructure.mongo.documents;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.AllArgsConstructor;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TotalPriceDocument {
    private String id_total_price;
    private double totalPrice;
}
