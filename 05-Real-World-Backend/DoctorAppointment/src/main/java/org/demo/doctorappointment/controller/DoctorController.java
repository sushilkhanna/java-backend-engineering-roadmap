package org.demo.doctorappointment.controller;

import org.demo.doctorappointment.dto.DoctorAvailabilityDTO;
import org.demo.doctorappointment.dto.PatientDTO;
import org.demo.doctorappointment.service.DoctorService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {

    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    // ✅ FIX #10: Now returns DoctorAvailabilityDTO instead of raw Doctor entity
    @PutMapping("/availability")
    public DoctorAvailabilityDTO updateAvailability(@RequestBody List<String> slots) {
        String email = SecurityContextHolder.getContext()
                .getAuthentication().getName();
        return doctorService.updateAvailability(email, slots);
    }

    @GetMapping("/my-patients")
    public List<PatientDTO> getAllPatientsByDate(@RequestParam String date) {
        String email = SecurityContextHolder.getContext()
                .getAuthentication().getName();
        return doctorService.getAllPatientsByDate(email, LocalDate.parse(date));
    }
}