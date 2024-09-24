package com.myfood.cqrs.myfood.query.infraestructure.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myfood.cqrs.myfood.query.application.IOrderServiceQuery;
import com.myfood.cqrs.myfood.query.domain.Order;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/orders")
public class OrderQueryRestController {
    @Autowired
    private final IOrderServiceQuery service;

    @GetMapping("")
    public ResponseEntity<List<Order>> getAll() {
        List<Order> response = this.service.getAll();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getById(@PathVariable String id) {
        Order response = this.service.getById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
