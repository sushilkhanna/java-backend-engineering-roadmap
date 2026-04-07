package com.clinic.ecommerce.repository;

import com.clinic.ecommerce.model.Prescriptions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrescriptionsRepo extends JpaRepository<Prescriptions,Long> {
}
