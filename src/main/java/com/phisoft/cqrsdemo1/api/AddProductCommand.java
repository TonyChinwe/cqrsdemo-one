package com.phisoft.cqrsdemo1.api;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data
@AllArgsConstructor
public class AddProductCommand {

    @TargetAggregateIdentifier
    private final String id;
    private final Double price;
    private final Integer stock;
    private final String description;

}
