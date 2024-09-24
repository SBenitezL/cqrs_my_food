package com.myfood.cqrs.myfood.query.infraestructure.mongo.documents;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.AllArgsConstructor;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDateDocument {
    private String id_date;
    private String date;
    private String hour;
}