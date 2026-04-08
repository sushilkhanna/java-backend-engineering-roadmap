package com.clinic.ecommerce.repository;

import com.clinic.ecommerce.model.Products;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductsRepo extends JpaRepository<Products,Long>, JpaSpecificationExecutor<Products> {
}
