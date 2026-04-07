package com.clinic.ecommerce.model;

import com.clinic.ecommerce.enums.DosageForm;
import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "products")
@Getter
@Setter
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="category_id",nullable = false)
    private Categories categories;

    @ManyToOne
    @JoinColumn(name="supplier_id",nullable = false)
    private Suppliers suppliers;

    @Column(nullable = false)
    private String name;

    private String genericName;

    @Column(nullable = false)
    private String manufacturer;

    @Column(nullable = false)
    private boolean requiresPrescription = false;

    @Column(nullable = false)
    private DosageForm dosageForm;

    private String strength;

    @Column(nullable = false)
    @Positive(message = "Price should be greater than 0")
    private BigDecimal price;

    @Column(nullable = false)
    private boolean isActive = true;

    @OneToMany(mappedBy = "product")
    private List<MedicineBatches> medicineBatches;

    @OneToMany(mappedBy = "product")
    private List<OrderItems> orderItems;
}
