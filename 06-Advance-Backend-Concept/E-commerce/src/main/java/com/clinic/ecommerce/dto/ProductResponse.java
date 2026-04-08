package com.clinic.ecommerce.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponse {
    private Long id;
    private String name;
    private String genericName;
    private String manufacturer;
    private String categoryName;
    private String dosageForm;
    private String strength;
    private Boolean requiresPrescription;
    private BigDecimal price;
    private Boolean isActive;
}
