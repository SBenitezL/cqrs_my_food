package com.myfood.cqrs.myfood.query.infraestructure.mongo.documents;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.myfood.cqrs.myfood.query.domain.value_objects.Dish;
import com.myfood.cqrs.myfood.query.domain.value_objects.OrderDate;
import com.myfood.cqrs.myfood.query.domain.value_objects.OrderState;
import com.myfood.cqrs.myfood.query.domain.value_objects.TotalPrice;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.AllArgsConstructor;

@Document("order")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDocument {
    @Id
    private String id_order;
    private OrderDate date;
    private OrderState state;
    private List<Dish> dishes;
    private TotalPrice totalPrice;
}
