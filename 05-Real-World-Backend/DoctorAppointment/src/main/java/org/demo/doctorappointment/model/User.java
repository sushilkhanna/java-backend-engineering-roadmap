package org.demo.doctorappointment.model;

import jakarta.persistence.*;
import lombok.*;
import org.demo.doctorappointment.enums.Role;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String Name;
    @Column(unique = true,nullable = false)
    private String Email;
    private String Password;
    @Enumerated(EnumType.STRING)
    private Role role;

}
