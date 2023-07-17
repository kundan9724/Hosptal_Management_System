package com.hospital.management.staff.controller;

import com.hospital.management.staff.model.Staff;
import com.hospital.management.staff.repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/staff")
public class StaffController {
   @Autowired
    private StaffRepository staffRepository;

   @Autowired
   private BCryptPasswordEncoder passwordEncoder;

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody Staff staff) {

        // Return Username already exists if try to signup with same username
        if (staffRepository.findByUserName(staff.getUserName()) != null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Username already exists");
        }

        String encodedPassword = passwordEncoder.encode(staff.getPassword());
        staff.setPassword(encodedPassword);
        staffRepository.save(staff);

        return ResponseEntity.status(HttpStatus.CREATED).body("User registered successfully");
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Staff staff) {
        Staff existingUser = staffRepository.findByUserName(staff.getUserName());

        if (existingUser == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
        }

        if (!(passwordEncoder.encode(staff.getPassword())).equals(existingUser.getPassword())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
        }

        return ResponseEntity.ok("Login successful");
    }

}
