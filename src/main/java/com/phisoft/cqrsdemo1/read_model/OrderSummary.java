package com.phisoft.cqrsdemo1.read_model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class OrderSummary {
    @Id
    private UUID id;
    private Double price;
    private Integer number;
    private String prodId;
    @ManyToOne
    @JoinColumn(name = "productid",insertable = false,updatable = false)
    private ProductSummary summary;


    public OrderSummary(UUID id, Double price, Integer number, String productId) {
        this.id = id;
        this.price = price;
        this.number = number;
        this.prodId = productId;
    }




}
