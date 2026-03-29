package org.demo.doctorappointment.service;

import org.demo.doctorappointment.model.Doctor;
import org.demo.doctorappointment.repository.DoctorRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {
    private final DoctorRepo doctorRepo;
    public DoctorService(DoctorRepo doctorRepo) {
        this.doctorRepo = doctorRepo;
    }

    public Doctor addDoctor(Doctor doctor){
        return doctorRepo.save(doctor);
    }

    public List<Doctor> getAllDoctors(){
        return doctorRepo.findAll();
    }

    public Optional<Doctor> getDoctorById(Long id){
        return doctorRepo.findById(id);
    }

    public Doctor updateAvailability(Long id, String slots){
        Doctor doctor = doctorRepo.findById(id)
                .orElseThrow(()->new RuntimeException("Doctor Not Found"));
        doctor.setAvailableSlots(slots);
        return doctorRepo.save(doctor);
    }
}
