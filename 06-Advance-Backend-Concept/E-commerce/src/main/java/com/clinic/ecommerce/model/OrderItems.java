package com.clinic.ecommerce.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.engine.jdbc.batch.spi.Batch;

import java.math.BigDecimal;

@Entity
@Table(name = "order_items")
@Getter
@Setter
public class OrderItems {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="order_id",nullable = false)
    private Orders order;

    @ManyToOne
    @JoinColumn(name = "product_id",nullable = false)
    private Products product;

    @ManyToOne
    @JoinColumn(name = "batch_id",nullable = false)
    private MedicineBatches medicineBatches;

    @Column(nullable = false)
    @Positive
    private Integer quantity;

    @Column(nullable = false)
    @Positive
    private BigDecimal price;
}
