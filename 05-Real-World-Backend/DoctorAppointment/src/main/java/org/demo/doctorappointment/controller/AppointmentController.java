package org.demo.doctorappointment.controller;

import org.demo.doctorappointment.dto.DoctorDTO;
import org.demo.doctorappointment.dto.PatientAppointmentDTO;
import org.demo.doctorappointment.model.Appointment;
import org.demo.doctorappointment.enums.AppointmentStatus;
import org.demo.doctorappointment.model.Doctor;
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

    @GetMapping("/doctorList")
    public List<DoctorDTO> doctorList(){
        return appointmentService.getAllDoctors();
    }

    @GetMapping("/doctor/{specialization}")
    public List<DoctorDTO> getDoctorBySpecialization(@PathVariable("specialization") String specialization){
        return appointmentService.getAllDoctorsBySpecialization(specialization);
    }

    @GetMapping("/doctor/appointments")
    public List<PatientAppointmentDTO> getAppointmentsByPatientId(@RequestParam Long patientId){
        return appointmentService.getAppointmentsByPatientId(patientId);
    }
}
