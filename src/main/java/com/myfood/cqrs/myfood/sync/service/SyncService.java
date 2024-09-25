package com.myfood.cqrs.myfood.sync.service;

import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.myfood.cqrs.myfood.command.infrastucture.MySQL.entities.OrderEntity;
import com.myfood.cqrs.myfood.command.infrastucture.MySQL.repository.OrderMySqlRepository;
import com.myfood.cqrs.myfood.query.infraestructure.mongo.documents.DishDocument;
import com.myfood.cqrs.myfood.query.infraestructure.mongo.documents.OrderDateDocument;
import com.myfood.cqrs.myfood.query.infraestructure.mongo.documents.OrderDocument;
import com.myfood.cqrs.myfood.query.infraestructure.mongo.documents.OrderStateDocument;
import com.myfood.cqrs.myfood.query.infraestructure.mongo.documents.TotalPriceDocument;
import com.myfood.cqrs.myfood.query.infraestructure.mongo.repository.OrderRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SyncService {
    Date lastSyncDate = new Date();
    private final OrderRepository queryRepository;
    private final OrderMySqlRepository commandRepository;
    private final MongoOperations mongoOps;
    private final ModelMapper mapper;

    public void sync() {
        this.updateOrders();
        this.lastSyncDate = new Date();
    }

    private void updateOrders() {
        List<OrderEntity> modifieds = this.commandRepository.findAllByActualDateAfter(lastSyncDate);
        for (OrderEntity order : modifieds) {
            this.queryRepository.deleteById(order.getId());
            OrderDocument mongoOrder = new OrderDocument(
                    order.getId(),
                    mapper.map(order.getDate(), OrderDateDocument.class),
                    mapper.map(order.getState(), OrderStateDocument.class),
                    mapper.map(order.getDishes(), new TypeToken<List<DishDocument>>() {
                    }.getType()),
                    mapper.map(order.getTotalPrice(), TotalPriceDocument.class));
            this.queryRepository.save(mongoOrder);
        }
    }
}
