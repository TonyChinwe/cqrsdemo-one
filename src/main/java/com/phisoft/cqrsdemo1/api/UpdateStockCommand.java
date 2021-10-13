package com.phisoft.cqrsdemo1.api;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data
@AllArgsConstructor
public class UpdateStockCommand {
    @TargetAggregateIdentifier
    private final String id;
    private final Integer stock;

}
