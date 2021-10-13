package com.phisoft.cqrsdemo1.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.util.UUID;

@Data
@AllArgsConstructor
public class CreateOrderCommand {

    @TargetAggregateIdentifier
    private final UUID orderId;
    private final Double price;
    private final Integer number;
    private final String productId;




    }
