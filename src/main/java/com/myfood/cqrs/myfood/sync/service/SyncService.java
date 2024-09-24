package com.myfood.cqrs.myfood.sync.service;

import java.util.Date;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Service;

import com.myfood.cqrs.myfood.command.infrastucture.MySQL.repository.OrderMySqlRepository;
import com.myfood.cqrs.myfood.query.infraestructure.mongo.repository.OrderRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SyncService {
    Date lastSyncDate = new Date();
    private final OrderRepository queryRepository;
    private final OrderMySqlRepository commandRepository;
    private final MongoOperations mongoOps;

    public void sync() {
        this.lastSyncDate = new Date();
    }

    private void updateOrders() {

    }
}
