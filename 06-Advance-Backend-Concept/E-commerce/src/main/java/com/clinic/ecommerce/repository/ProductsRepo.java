package com.clinic.ecommerce.repository;

import com.clinic.ecommerce.model.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsRepo extends JpaRepository<Products,Long> {
}
