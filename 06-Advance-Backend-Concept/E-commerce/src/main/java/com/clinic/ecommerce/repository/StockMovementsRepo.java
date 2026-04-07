package com.clinic.ecommerce.repository;

import com.clinic.ecommerce.model.StockMovements;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockMovementsRepo extends JpaRepository<StockMovements,Long> {
}
