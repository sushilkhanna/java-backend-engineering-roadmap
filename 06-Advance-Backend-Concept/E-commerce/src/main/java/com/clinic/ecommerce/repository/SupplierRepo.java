package com.clinic.ecommerce.repository;

import com.clinic.ecommerce.model.Suppliers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierRepo extends JpaRepository<Suppliers,Long> {

}
