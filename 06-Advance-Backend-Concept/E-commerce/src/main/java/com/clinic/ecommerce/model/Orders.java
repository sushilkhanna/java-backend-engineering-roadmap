package com.clinic.ecommerce.model;

import com.clinic.ecommerce.enums.OrderStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "orders")
@Getter
@Setter
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="user_id",nullable = false)
    private Users users;

    @ManyToOne
    @JoinColumn(name="prescription_id",nullable = true)
    private Prescriptions prescription;

    @Column(nullable = false)
    private OrderStatus orderStatus = OrderStatus.PENDING;

    @Column(nullable = false)
    @DecimalMin(value = "0.0", inclusive = true)
    private float totalAmount;

    @Column(nullable = false)
    private String deliveryAddress;

    @CreationTimestamp
    @Column(nullable = false,updatable = false)
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "order")
    private List<OrderItems> orderItems;
}
