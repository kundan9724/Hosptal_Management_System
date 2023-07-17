package com.hospital.management.staff.service;

import com.hospital.management.staff.model.Patient;

import java.util.List;

public interface PatientService {
    void savePatient(Patient patient);

    List<Patient> getAllAdmittedPatients();

    String dischargePatient(Long patientId);
}

