package com.myfood.cqrs.myfood.query.application;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.myfood.cqrs.myfood.query.infraestructure.mongo.documents.OrderDocument;
import com.myfood.cqrs.myfood.query.infraestructure.mongo.repository.OrderRepository;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

import com.myfood.cqrs.myfood.query.domain.Order;
import com.myfood.cqrs.myfood.query.domain.constants.OrderStateConstans;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;

@Service
@RequiredArgsConstructor
public class OrderService implements IOrderService {
    @Autowired
    private final ModelMapper mapper;
    @Autowired
    private final OrderRepository db;

    @Override
    public List<Order> getAll() {
        List<OrderDocument> dataDB = this.db.findAll();
        return this.mapper.map(dataDB, new TypeToken<List<Order>>() {
        }.getType());
    }

    @Override
    public Order getById(String id) {

        Optional<OrderDocument> dataDB = this.db.findById(id);
        if (!dataDB.isPresent())
            return null;
        return this.mapper.map(dataDB.get(), Order.class);
    }

    // public List<Order> getAllByStatus(OrderStateConstans state) {
    // // TODO: cambiar
    // }

    // public List<Order> getByDate(Date date) {
    // // TODO: cambiar
    // }
}
