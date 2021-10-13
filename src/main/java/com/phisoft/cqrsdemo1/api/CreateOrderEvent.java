package com.phisoft.cqrsdemo1.api;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class CreateOrderEvent {

    private final UUID orderId;
    private final Double price;
    private final Integer number;
    private final String productId;


}
