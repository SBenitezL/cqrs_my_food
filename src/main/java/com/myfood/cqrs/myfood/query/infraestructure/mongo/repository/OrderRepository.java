package com.myfood.cqrs.myfood.query.infraestructure.mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.myfood.cqrs.myfood.query.infraestructure.mongo.documents.OrderDocument;

public interface OrderRepository extends MongoRepository<OrderDocument, String> {

}
