package com.simfinity.backend.Controller;

import com.simfinity.backend.Model.User;
import com.simfinity.backend.Repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/students") // ✅ Students namespace
public class UserController {

    @Autowired
    private UserRepository studentRepository;

    @PostMapping("/register")
    public ResponseEntity<?> registerStudent(@RequestBody User student) {
        if (studentRepository.findByEmail(student.getEmail()).isPresent()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Email is already registered!");
        }
        User savedStudent = studentRepository.save(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedStudent);
    }
}
