package com.hospital.management.staff.model;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name = "staff")
@Data
public class Staff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userName;

    private String password;

    private String name;

    private String role;

}
