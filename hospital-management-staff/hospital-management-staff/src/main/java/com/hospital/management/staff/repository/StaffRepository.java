package com.hospital.management.staff.repository;

import com.hospital.management.staff.model.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffRepository extends JpaRepository<Staff,Long> {
    Staff findByUserName(String userName);
}
