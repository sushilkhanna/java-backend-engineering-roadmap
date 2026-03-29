package org.demo.doctorappointment.service;

import org.demo.doctorappointment.enums.AppointmentStatus;
import org.demo.doctorappointment.model.Appointment;
import org.demo.doctorappointment.model.Doctor;
import org.demo.doctorappointment.model.User;
import org.demo.doctorappointment.repository.AppointmentRepo;
import org.demo.doctorappointment.repository.DoctorRepo;
import org.demo.doctorappointment.repository.UserRepo;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
public class AppointmentService {
    private final AppointmentRepo appointmentRepo;
    private final DoctorRepo doctorRepo;
    private final UserRepo userRepo;

    public AppointmentService(AppointmentRepo appointmentRepo, DoctorRepo doctorRepo, UserRepo userRepo) {
        this.appointmentRepo=appointmentRepo;
        this.doctorRepo=doctorRepo;
        this.userRepo=userRepo;
    }

    public Appointment bookAppointment(Long patientId, Long doctorId, LocalDate  date, LocalTime time){
        User patient =  userRepo.findById(patientId)
                .orElseThrow(()->new RuntimeException("Patient Not Found"));
        Doctor doctor =  doctorRepo.findById(doctorId)
                .orElseThrow(()->new RuntimeException("Doctor Not Found"));

        Appointment appointment = Appointment.builder()
                .patient(patient)
                .doctor(doctor)
                .date(date)
                .time(time)
                .status(AppointmentStatus.PENDING)
                .build();

        return appointmentRepo.save(appointment);
    }

    public List<Appointment> getAppointmentsByPatient(Long patientId) {
        return appointmentRepo.findByPatientId(patientId);
    }

    public Appointment updateStatus(Long appointmentId, AppointmentStatus status) {
        Appointment appointment = appointmentRepo.findById(appointmentId)
                .orElseThrow(() -> new RuntimeException("Appointment not found"));
        appointment.setStatus(status);
        return appointmentRepo.save(appointment);
    }

}
