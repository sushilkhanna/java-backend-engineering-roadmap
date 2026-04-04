package org.demo.doctorappointment.service;

import org.demo.doctorappointment.dto.PatientDTO;
import org.demo.doctorappointment.model.Doctor;
import org.demo.doctorappointment.repository.AppointmentRepo;
import org.demo.doctorappointment.repository.DoctorRepo;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;

@Service
public class DoctorService {
    private final DoctorRepo doctorRepo;
    private final AppointmentRepo appointmentRepo;

    public DoctorService(DoctorRepo doctorRepo,  AppointmentRepo appointmentRepo) {
        this.doctorRepo = doctorRepo;
        this.appointmentRepo = appointmentRepo;
    }

    public Doctor updateAvailability(String email, List<String> slots) {
        // Find the doctor whose user has this email
        Doctor doctor = doctorRepo.findByUser_Email(email)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Doctor not found"));

        doctor.setAvailableSlots(slots);
        return doctorRepo.save(doctor);
    }

    public List<PatientDTO> getAllPatientsByDate(String email, LocalDate date) {
        Doctor doctor = doctorRepo.findByUser_Email(email)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Doctor not found"));

        return appointmentRepo.findByDoctor_IdAndDate(doctor.getId(), date)
                .stream()
                .map(a -> new PatientDTO(
                        a.getPatient().getName(),
                        a.getPatient().getEmail(),
                        a.getTime()
                ))
                .toList();
    }


}
