package com.simfinity.backend.Controller;

import com.simfinity.backend.Model.User;
import com.simfinity.backend.Repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/rentals") // ✅ Rentals namespace
public class RentalController {

    @Autowired
    private UserRepository rentalRepository;

    @PostMapping("/register")
    public ResponseEntity<?> registerRental(@RequestBody User rentalUser) {
        if (rentalRepository.findByEmail(rentalUser.getEmail()).isPresent()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Email is already registered for rental!");
        }
        User savedRentalUser = rentalRepository.save(rentalUser);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedRentalUser);
    }
}
