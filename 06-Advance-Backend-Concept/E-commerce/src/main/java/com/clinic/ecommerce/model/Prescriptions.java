package com.clinic.ecommerce.model;

import com.clinic.ecommerce.enums.PrescriptionStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="prescriptions")
@Getter
@Setter
public class Prescriptions {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="user_id",nullable = false)
    private Users users;

    @Column(nullable = false)
    private String doctorName;

    private String hospital;

    @Column(nullable = false)
    private String imageUrl;

    @Column(nullable = false)
    private PrescriptionStatus status = PrescriptionStatus.PENDING;

    @Column(nullable = false)
    private LocalDate validUntil;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDate uploadedAt;

    @OneToMany(mappedBy = "prescription")
    private List<Orders> orders;
}
