package com.clinic.ecommerce.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "medicine_batches")
@Getter
@Setter
public class MedicineBatches {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="product_id",nullable = false)
    private Products product;

    @Column(nullable = false, unique = true)
    private String batchNumber;

    private LocalDate manufactureDate;

    @Column(nullable = false)
    private LocalDate expirationDate;

    @Column(nullable = false)
    @PositiveOrZero(message = "Quantity cannot be negative")
    private Integer quantity;

    @Column(nullable = false)
    @Positive
    private BigDecimal price;

    @OneToMany(mappedBy = "medicineBatches")
    private List<OrderItems> orderItems;
}
