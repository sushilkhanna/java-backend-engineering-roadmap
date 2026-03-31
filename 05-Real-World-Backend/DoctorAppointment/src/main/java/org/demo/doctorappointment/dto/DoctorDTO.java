package org.demo.doctorappointment.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class DoctorDTO {
    private String name;
    private String specialization;
    private List<String> availableSlots;
}
