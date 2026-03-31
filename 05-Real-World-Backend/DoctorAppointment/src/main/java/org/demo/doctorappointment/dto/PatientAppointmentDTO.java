package org.demo.doctorappointment.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.demo.doctorappointment.enums.AppointmentStatus;

import java.time.LocalDate;
import java.time.LocalTime;

@AllArgsConstructor
@Getter
public class PatientAppointmentDTO {
    private String doctorName;
    private String specialization;
    private LocalDate date;
    private LocalTime time;
    private AppointmentStatus status;
}
