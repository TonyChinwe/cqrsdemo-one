package com.phisoft.cqrsdemo1.api;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UpdateStockEvent {
    private final String id;
    private final Integer stock;
}
