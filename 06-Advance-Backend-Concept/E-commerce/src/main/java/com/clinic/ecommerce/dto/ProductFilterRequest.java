package com.clinic.ecommerce.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductFilterRequest {
    private String search;
    private Long categoryId;
    private Boolean requiresPrescription;
    private int page = 0;
    private int size = 10;
}