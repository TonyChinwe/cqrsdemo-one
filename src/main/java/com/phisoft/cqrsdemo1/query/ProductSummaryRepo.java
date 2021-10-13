package com.phisoft.cqrsdemo1.query;

import com.phisoft.cqrsdemo1.read_model.ProductSummary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductSummaryRepo extends JpaRepository<ProductSummary,String> {
}
