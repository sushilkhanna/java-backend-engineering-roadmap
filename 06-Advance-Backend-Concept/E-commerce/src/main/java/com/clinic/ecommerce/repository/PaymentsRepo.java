package com.clinic.ecommerce.repository;

import com.clinic.ecommerce.model.Payments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentsRepo extends JpaRepository<Payments,Long> {
}
