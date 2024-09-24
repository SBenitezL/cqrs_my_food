package com.myfood.cqrs.myfood.query.domain.value_objects;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;

@Getter
@Setter
@AllArgsConstructor
public class OrderState {
    private String id_state;
    private String state;

    public OrderState() {
    }
}
