package org.demo.doctorappointment.controller;

import org.demo.doctorappointment.dto.PatientDTO;
import org.demo.doctorappointment.model.Doctor;
import org.demo.doctorappointment.service.DoctorService;
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

    @PutMapping("/{id}/availability")
    public Doctor updateAvailability(@PathVariable Long id, @RequestBody List<String> slots) {
        return doctorService.updateAvailability(id, slots);
    }

    @GetMapping("/appointments/{doctorId},{date}")
    public List<PatientDTO> getAllPatientsByDate(@PathVariable Long doctorId, @PathVariable LocalDate date){
        return doctorService.getAllPatientsByDate(doctorId, date);
    }

}
