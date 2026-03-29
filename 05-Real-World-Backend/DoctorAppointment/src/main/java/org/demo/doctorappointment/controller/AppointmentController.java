package org.demo.doctorappointment.controller;

import org.demo.doctorappointment.model.Appointment;
import org.demo.doctorappointment.enums.AppointmentStatus;
import org.demo.doctorappointment.service.AppointmentService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {
    private final AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @PostMapping("/book")
    public Appointment bookAppointment(@RequestParam Long patientId,
                                       @RequestParam Long doctorId,
                                       @RequestParam String date,
                                       @RequestParam String time) {
        return appointmentService.bookAppointment(
                patientId,
                doctorId,
                LocalDate.parse(date),
                LocalTime.parse(time)
        );
    }

    @GetMapping("/patient/{patientId}")
    public List<Appointment> getAppointmentsByPatient(@PathVariable Long patientId) {
        return appointmentService.getAppointmentsByPatient(patientId);
    }

    // Update appointment status (doctor approves/rejects)
    @PutMapping("/{appointmentId}/status")
    public Appointment updateStatus(@PathVariable Long appointmentId,
                                    @RequestParam AppointmentStatus status) {
        return appointmentService.updateStatus(appointmentId, status);
    }

}
