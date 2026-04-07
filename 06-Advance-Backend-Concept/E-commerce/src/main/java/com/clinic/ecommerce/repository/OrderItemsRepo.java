package com.clinic.ecommerce.repository;

import com.clinic.ecommerce.model.OrderItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemsRepo extends JpaRepository<OrderItems,Long> {
}
