package com.clinic.ecommerce.controller;

import com.clinic.ecommerce.dto.ProductFilterRequest;
import com.clinic.ecommerce.dto.ProductResponse;
import com.clinic.ecommerce.service.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService productService;

    ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public Page<ProductResponse> getProducts(ProductFilterRequest filter) {
        return productService.getProducts(filter);
    }
}
