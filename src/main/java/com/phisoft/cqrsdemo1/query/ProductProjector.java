package com.phisoft.cqrsdemo1.query;

import com.phisoft.cqrsdemo1.api.AddProductEvent;
import com.phisoft.cqrsdemo1.api.UpdateStockEvent;
import com.phisoft.cqrsdemo1.read_model.ProductSummary;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductProjector {

 private final  ProductSummaryRepo summaryRepo;


    public ProductProjector(ProductSummaryRepo summaryRepo) {
        this.summaryRepo = summaryRepo;
    }


    @EventHandler
    public  void on(AddProductEvent event){
        ProductSummary productSummary=new ProductSummary(
          event.getId(),
          event.getPrice(),
          event.getStock(),
          event.getDescription()
        );
     summaryRepo.save(productSummary);
    }

    @EventHandler
    public void on(UpdateStockEvent event){

        ProductSummary productSummary=summaryRepo.findById(event.getId()).orElse(null);
        productSummary.setStock(productSummary.getStock()-event.getStock());
        summaryRepo.save(productSummary);
    }

    @QueryHandler
    public List<ProductSummary> on(GetProductQuery query){
        return summaryRepo.findAll();
    }
}
