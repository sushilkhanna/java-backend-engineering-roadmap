package org.demo.doctorappointment.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalTime;

@AllArgsConstructor
@Getter
public class PatientDTO {
    private String name;
    private String email;
    private LocalTime time;
}
