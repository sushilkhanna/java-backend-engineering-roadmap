package org.demo.doctorappointment.repository;

import org.demo.doctorappointment.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AppointmentRepo extends JpaRepository<Appointment,Long> {
    List<Appointment> findByPatient_Id(Long patientId);
    List<Appointment> findByDoctor_IdAndDate(Long doctorId, LocalDate date);
    List<Appointment> findByPatient_Email(String email);
}
