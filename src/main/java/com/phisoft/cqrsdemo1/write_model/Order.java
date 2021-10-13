package com.phisoft.cqrsdemo1.write_model;

import com.phisoft.cqrsdemo1.api.CreateOrderCommand;
import com.phisoft.cqrsdemo1.api.CreateOrderEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

import java.util.UUID;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

@Aggregate
public class Order {

    @AggregateIdentifier
    private UUID orderId;
    private Double price;
    private Integer number;
    private String productId;

    public Order() {
    }

    @CommandHandler
    public Order(CreateOrderCommand cm){
      apply(new CreateOrderEvent(
       cm.getOrderId(),
       cm.getPrice(),
       cm.getNumber(),
       cm.getProductId()
      ));
    }

    @EventSourcingHandler
    public void on(CreateOrderEvent event){
        orderId=event.getOrderId();
        price=event.getPrice();
        number=event.getNumber();
        productId=event.getProductId();
    }

}
