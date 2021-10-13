package com.phisoft.cqrsdemo1.api;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddProductEvent {

    private final String id;
    private final Double price;
    private final Integer stock;
    private final String description;

}
