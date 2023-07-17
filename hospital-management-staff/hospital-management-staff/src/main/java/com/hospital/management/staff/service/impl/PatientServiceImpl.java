package com.hospital.management.staff.service.impl;

import com.hospital.management.staff.AppConstants;
import com.hospital.management.staff.model.Patient;
import com.hospital.management.staff.repository.PatientRepository;
import com.hospital.management.staff.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Override
    public void savePatient(Patient patient) {
        // save details of patient in the database
        patientRepository.save(patient);
    }

    @Override
    public List<Patient> getAllAdmittedPatients() {
        // Fetching list of patient who all are admitted
        return patientRepository.findByStatus(AppConstants.ADMITTED);
    }

    @Override
    public String dischargePatient(Long patientId) {
        // Discharge patient on the basis of patientId and throws error if no patient found with the patientId
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new NoSuchElementException("Patient not found"));

        // Return the meessage if patient is already discharged
        if (AppConstants.DISCHARGED.equalsIgnoreCase(patient.getStatus())) {
            return AppConstants.PATIENT_ALREADY_DISCHARGED;
        }

        // Set the status of patient to be discharged if not already discharged
        patient.setStatus(AppConstants.DISCHARGED);
        patientRepository.save(patient);
        return AppConstants.PATIENT_DISCHARGED;
    }
}

