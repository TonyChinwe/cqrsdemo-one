package com.phisoft.cqrsdemo1.write_model;

import com.phisoft.cqrsdemo1.api.AddProductCommand;
import com.phisoft.cqrsdemo1.api.AddProductEvent;
import com.phisoft.cqrsdemo1.api.UpdateStockCommand;
import com.phisoft.cqrsdemo1.api.UpdateStockEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

@Aggregate
public class Product {

    @AggregateIdentifier
    private String id;
    private Double price;
    private String description;
    private Integer stock;

    public Product() {
    }

    @CommandHandler
    public Product(AddProductCommand cmd){
        apply(new AddProductEvent(
              cmd.getId(),
              cmd.getPrice(),
              cmd.getStock(),
              cmd.getDescription()
        ));
    }

    @CommandHandler
    public void handle(UpdateStockCommand cmd){
        if(this.stock>=cmd.getStock()){
            apply(new UpdateStockEvent(
                    cmd.getId(),
                    cmd.getStock()
            ));
        }else {
            throw new RuntimeException("Out of stock");
        }

    }

    @EventSourcingHandler
    public void on(UpdateStockEvent evt){
        id=evt.getId();
        stock=stock-evt.getStock();
    }

    @EventSourcingHandler
    public void on(AddProductEvent evt){
        id=evt.getId();
        price=evt.getPrice();
        stock=evt.getStock();
        description=evt.getDescription();
    }


}
