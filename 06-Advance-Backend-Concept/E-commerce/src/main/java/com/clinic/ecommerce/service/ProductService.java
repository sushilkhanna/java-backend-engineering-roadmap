package com.clinic.ecommerce.service;

import com.clinic.ecommerce.dto.ProductFilterRequest;
import com.clinic.ecommerce.dto.ProductResponse;
import com.clinic.ecommerce.model.Products;
import com.clinic.ecommerce.repository.ProductsRepo;
import com.clinic.ecommerce.specification.ProductSpecification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final ProductsRepo productsRepo;

    ProductService(ProductsRepo productsRepo) {
        this.productsRepo = productsRepo;
    }

    public Page<ProductResponse> getProducts(ProductFilterRequest filter) {

        Pageable pageable = PageRequest.of(filter.getPage(), filter.getSize());

        Specification<Products> spec = ProductSpecification.withFilters(filter);

        Page<Products> productsPage = productsRepo.findAll(spec, pageable);

        return productsPage.map(this::toResponse);
    }

    private ProductResponse toResponse(Products product) {
        ProductResponse response = new ProductResponse();
        response.setId(product.getId());
        response.setName(product.getName());
        response.setGenericName(product.getGenericName());
        response.setManufacturer(product.getManufacturer());
        response.setCategoryName(product.getCategory().getName());
        response.setDosageForm(product.getDosageForm().name());
        response.setStrength(product.getStrength());
        response.setRequiresPrescription(product.isRequiresPrescription());
        response.setPrice(product.getPrice());
        response.setIsActive(product.isActive());
        return response;
    }
}