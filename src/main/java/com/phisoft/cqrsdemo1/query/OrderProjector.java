package com.phisoft.cqrsdemo1.query;

import com.phisoft.cqrsdemo1.api.CreateOrderEvent;
import com.phisoft.cqrsdemo1.api.UpdateStockEvent;
import com.phisoft.cqrsdemo1.read_model.OrderSummary;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.eventhandling.gateway.EventGateway;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderProjector {


    private EventGateway eventGateway;
    private OrderSummaryRepo orderSummaryRepo;

    public OrderProjector(EventGateway eventGateway, OrderSummaryRepo orderSummaryRepo) {
        this.eventGateway = eventGateway;
        this.orderSummaryRepo = orderSummaryRepo;
    }


    @EventHandler
    public void on(CreateOrderEvent evt){
        OrderSummary summary=new OrderSummary(
                evt.getOrderId(),
                evt.getPrice(),
                evt.getNumber(),
                evt.getProductId()
        );
        orderSummaryRepo.save(summary);

        //fire a new stockupdatedevent
        UpdateStockEvent updateStockEvent=new UpdateStockEvent(
                evt.getProductId(),
                evt.getNumber()

        );
        eventGateway.publish(updateStockEvent);

    }

    @QueryHandler
    public List<OrderSummary> handle(GetOrderQuery query){
        return orderSummaryRepo.findAll();
    }

}
