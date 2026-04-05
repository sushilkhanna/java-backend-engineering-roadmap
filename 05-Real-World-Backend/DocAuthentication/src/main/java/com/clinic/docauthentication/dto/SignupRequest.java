package com.clinic.docauthentication.dto;

import com.clinic.docauthentication.enums.Role;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignupRequest {
    private String name;
    private String email;
    private String password;
    private Role role;  // PATIENT, DOCTOR, ADMIN
}