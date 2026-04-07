package com.clinic.ecommerce.model;

import com.clinic.ecommerce.enums.PaymentMethods;
import com.clinic.ecommerce.enums.PaymentStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "payments")
@Getter
@Setter
public class Payments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "order_id",nullable = false)
    private Orders order;

    @Column(nullable = false)
    private PaymentMethods methods;

    @Column(nullable = false)
    private PaymentStatus status =  PaymentStatus.PENDING;

    @Column(nullable = false)
    private float amount;

    @Column(nullable = true)
    private String transactionId;

    @Column(nullable = true)
    private LocalDateTime paidAt;
}
