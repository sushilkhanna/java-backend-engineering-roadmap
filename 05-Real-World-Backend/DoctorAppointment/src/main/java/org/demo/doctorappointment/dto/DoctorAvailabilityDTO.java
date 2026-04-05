package org.demo.doctorappointment.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class DoctorAvailabilityDTO {
    private Long doctorId;
    private String doctorName;
    private String specialization;
    private List<String> availableSlots;
}
