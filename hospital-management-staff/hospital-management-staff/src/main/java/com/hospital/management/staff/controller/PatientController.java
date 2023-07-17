package com.hospital.management.staff.controller;

import com.hospital.management.staff.AppConstants;
import com.hospital.management.staff.model.Patient;
import com.hospital.management.staff.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patients")
public class PatientController {
    @Autowired
    PatientService patientService;

    // Admit the patient with certain details.
    @PostMapping("/admit")
    public ResponseEntity<String> admitPatient(@RequestBody Patient patient) {
        patient.setStatus(AppConstants.ADMITTED);
        patientService.savePatient(patient);
        return ResponseEntity.ok("Patient admitted successfully");
    }

    // Get list of all admit patients
    @GetMapping("/getAllAdmitPatients")
    public ResponseEntity<List<Patient>> getAllAdmittedPatients() {
        List<Patient> admittedPatients = patientService.getAllAdmittedPatients();
        return ResponseEntity.ok(admittedPatients);
    }

    // Discharge patient based on their patientId
    @PostMapping("/{id}/discharge")
    public ResponseEntity<String> dischargePatient(@PathVariable("id") Long patientId) {
        String message = patientService.dischargePatient(patientId);
        return ResponseEntity.ok("Patient discharged successfully");
    }
}
