package com.myfood.cqrs.myfood.query.application;

import java.util.List;
import java.util.Date;

import com.myfood.cqrs.myfood.query.domain.Order;
import com.myfood.cqrs.myfood.query.domain.constants.OrderStateConstans;

public interface IOrderServiceQuery {
    List<Order> getAll();

    Order getById(String id);

    // List<Order> getAllByStatus(OrderStateConstans state);

    // List<Order> getByDate(Date date);

}
