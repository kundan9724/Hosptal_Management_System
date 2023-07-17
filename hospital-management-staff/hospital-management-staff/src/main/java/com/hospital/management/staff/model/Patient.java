package com.hospital.management.staff.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "patients")
@Data
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int age;
    private String room;
    private String doctorName;
    private LocalDate admitDate;
    private double expenses;
    private String status;
}
