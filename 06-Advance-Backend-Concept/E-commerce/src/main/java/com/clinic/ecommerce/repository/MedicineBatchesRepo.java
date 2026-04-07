package com.clinic.ecommerce.repository;

import com.clinic.ecommerce.model.MedicineBatches;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicineBatchesRepo extends JpaRepository<MedicineBatches,Long> {
}
