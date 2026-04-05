package org.demo.doctorappointment.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.demo.doctorappointment.enums.Role;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserSyncDTO {
    private String name;
    private String email;
    private Role role;
}