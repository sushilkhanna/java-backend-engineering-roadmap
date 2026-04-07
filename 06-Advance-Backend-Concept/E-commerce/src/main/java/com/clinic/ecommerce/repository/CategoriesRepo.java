package com.clinic.ecommerce.repository;

import com.clinic.ecommerce.model.Categories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriesRepo extends JpaRepository<Categories,Long> {
}
