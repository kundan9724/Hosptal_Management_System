package com.hospital.management.staff.repository;

import com.hospital.management.staff.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository  extends JpaRepository<Patient,Long> {
    List<Patient> findByStatus(String status);
}
