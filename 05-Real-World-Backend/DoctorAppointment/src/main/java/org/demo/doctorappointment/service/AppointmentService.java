package org.demo.doctorappointment.service;

import org.demo.doctorappointment.dto.DoctorDTO;
import org.demo.doctorappointment.dto.PatientAppointmentDTO;
import org.demo.doctorappointment.enums.AppointmentStatus;
import org.demo.doctorappointment.model.Appointment;
import org.demo.doctorappointment.model.Doctor;
import org.demo.doctorappointment.model.User;
import org.demo.doctorappointment.repository.AppointmentRepo;
import org.demo.doctorappointment.repository.DoctorRepo;
import org.demo.doctorappointment.repository.UserRepo;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
public class AppointmentService {

    private final AppointmentRepo appointmentRepo;
    private final DoctorRepo doctorRepo;
    private final UserRepo userRepo;

    public AppointmentService(AppointmentRepo appointmentRepo,
                              DoctorRepo doctorRepo,
                              UserRepo userRepo) {
        this.appointmentRepo = appointmentRepo;
        this.doctorRepo = doctorRepo;
        this.userRepo = userRepo;
    }

    public Appointment bookAppointment(String email, Long doctorId,
                                       String date, String time) {
        // ✅ FIX #3: This now works correctly ONLY after user sync is in place.
        //            If auth service doesn't sync user data here, this will always throw 404.
        User patient = userRepo.findByEmail(email)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Patient not found. Ensure user is synced from auth service."));

        Doctor doctor = doctorRepo.findById(doctorId)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Doctor not found"));

        Appointment appointment = Appointment.builder()
                .patient(patient)
                .doctor(doctor)
                .date(LocalDate.parse(date))
                .time(LocalTime.parse(time))
                .status(AppointmentStatus.PENDING)
                .build();

        return appointmentRepo.save(appointment);
    }

    public List<DoctorDTO> getAllDoctors() {
        return doctorRepo.findAll().stream()
                .map(doctor -> new DoctorDTO(
                        doctor.getUser().getName(),
                        doctor.getSpecialization(),
                        doctor.getAvailableSlots()
                ))
                .toList();
    }

    public List<DoctorDTO> getAllDoctorsBySpecialization(String specialization) {
        return doctorRepo.findBySpecialization(specialization).stream()
                .map(doctor -> new DoctorDTO(
                        doctor.getUser().getName(),
                        doctor.getSpecialization(),
                        doctor.getAvailableSlots()
                ))
                .toList();
    }

    // ✅ FIX #4: Replaced patientId param with email so patient can only see their OWN appointments
    public List<PatientAppointmentDTO> getMyAppointments(String email) {
        return appointmentRepo.findByPatient_Email(email).stream()
                .map(appt -> new PatientAppointmentDTO(
                        appt.getDoctor().getUser().getName(),
                        appt.getDoctor().getSpecialization(),
                        appt.getDate(),
                        appt.getTime(),
                        appt.getStatus()
                ))
                .toList();
    }
}