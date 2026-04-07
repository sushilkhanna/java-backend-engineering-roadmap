package com.clinic.ecommerce.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="suppliers")
@Getter
@Setter
public class Suppliers {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @NotBlank(message="Phone number is required")
    @Pattern(regexp="^[0-9]{10}$",message="Phone number must be exactly 10 digits")
    @Column(nullable = false,unique = true)
    private String phone;

    @Column(unique = true)
    private String email;

    private String address;
}
