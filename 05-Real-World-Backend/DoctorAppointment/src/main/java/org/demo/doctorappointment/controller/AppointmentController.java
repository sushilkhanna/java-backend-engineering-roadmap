package org.demo.doctorappointment.controller;

import org.demo.doctorappointment.dto.DoctorDTO;
import org.demo.doctorappointment.dto.PatientAppointmentDTO;
import org.demo.doctorappointment.model.Appointment;
import org.demo.doctorappointment.service.AppointmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {

    private final AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @PostMapping("/book")
    public ResponseEntity<Map<String, Object>> bookAppointment(
            @RequestParam Long doctorId,
            @RequestParam String date,
            @RequestParam String time) {

        String email = SecurityContextHolder.getContext()
                .getAuthentication().getName();

        Appointment appt = appointmentService.bookAppointment(email, doctorId, date, time);

        return ResponseEntity.ok(Map.of(
                "appointmentId", appt.getId(),
                "status", appt.getStatus(),
                "date", appt.getDate(),
                "time", appt.getTime()
        ));
    }

    @GetMapping("/doctorList")
    public List<DoctorDTO> doctorList() {
        return appointmentService.getAllDoctors();
    }

    @GetMapping("/doctor/by-specialization/{specialization}")
    public List<DoctorDTO> getDoctorBySpecialization(
            @PathVariable("specialization") String specialization) {
        return appointmentService.getAllDoctorsBySpecialization(specialization);
    }

    // ✅ FIX #4: Removed @RequestParam Long patientId — now derives identity from JWT
    //            Previously any patient could pass someone else's patientId and see their appointments
    @GetMapping("/my-appointments")
    public List<PatientAppointmentDTO> getMyAppointments() {
        String email = SecurityContextHolder.getContext()
                .getAuthentication().getName();
        return appointmentService.getMyAppointments(email);
    }
}