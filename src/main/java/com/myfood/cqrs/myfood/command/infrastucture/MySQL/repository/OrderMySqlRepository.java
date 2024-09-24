package com.myfood.cqrs.myfood.command.infrastucture.MySQL.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myfood.cqrs.myfood.command.infrastucture.MySQL.entities.OrderEntity;

@Repository
public interface OrderMySqlRepository extends JpaRepository<OrderEntity, String> {
    public List<OrderEntity> findAllByActualDateAfter(Date date);
}
