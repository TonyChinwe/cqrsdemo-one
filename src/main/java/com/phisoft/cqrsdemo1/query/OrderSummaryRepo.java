package com.phisoft.cqrsdemo1.query;

import com.phisoft.cqrsdemo1.read_model.OrderSummary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface OrderSummaryRepo extends JpaRepository<OrderSummary,String> {
}
