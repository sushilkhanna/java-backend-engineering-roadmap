package org.demo.doctorappointment.service;

import org.demo.doctorappointment.dto.PatientDTO;
import org.demo.doctorappointment.model.Doctor;
import org.demo.doctorappointment.repository.AppointmentRepo;
import org.demo.doctorappointment.repository.DoctorRepo;
import org.springframework.stereotype.Service;

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

    public Doctor updateAvailability(Long id, List<String> slots){
        Doctor doctor = doctorRepo.findById(id)
                .orElseThrow(()->new RuntimeException("Doctor Not Found"));
        doctor.setAvailableSlots(slots);
        return doctorRepo.save(doctor);
    }

    public List<PatientDTO> getAllPatientsByDate(Long doctorId, LocalDate date){
        return appointmentRepo.findByDoctor_IdAndDate(doctorId, date).stream()
                .map(appointment -> new PatientDTO(
                        appointment.getPatient().getName(),
                        appointment.getPatient().getEmail(),
                        appointment.getTime()
                ))
                .toList();
    }


}
