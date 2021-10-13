package com.phisoft.cqrsdemo1.controllers;

import com.phisoft.cqrsdemo1.api.CreateOrderCommand;
import com.phisoft.cqrsdemo1.query.GetOrderQuery;
import com.phisoft.cqrsdemo1.read_model.OrderSummary;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@RestController
public class OrderController {

    private CommandGateway commandGateway;
    private QueryGateway queryGateway;

    @Autowired
    public OrderController(CommandGateway commandGateway, QueryGateway queryGateway) {
        this.commandGateway = commandGateway;
        this.queryGateway = queryGateway;
    }



    @PostMapping("create-order")
    public void handle(@RequestBody OrderSummary orderSummary){
        CreateOrderCommand cmd=new CreateOrderCommand(
                UUID.randomUUID(),
                orderSummary.getPrice(),
                orderSummary.getNumber(),
                orderSummary.getProdId()
        );
        commandGateway.sendAndWait(cmd);
    }

    @GetMapping("/orders")
    public CompletableFuture<List<OrderSummary>> getOrders(){
        return queryGateway.query(new GetOrderQuery(),
                ResponseTypes.multipleInstancesOf(OrderSummary.class));

    }


}
