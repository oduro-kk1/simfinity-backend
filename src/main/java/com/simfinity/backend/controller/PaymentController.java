package com.simfinity.backend.Controller;

import com.simfinity.backend.Repository.PaymentRepository;
import com.simfinity.backend.Services.PaystackService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.core.userdetails.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

@RestController
@RequestMapping("/payments")
public class PaymentController {
    private final PaymentRepository paymentRepository;
    private final PaystackService paystackService;

    // Secret key for JWT (store safely in env or application.properties)
    private final String jwtSecret = System.getenv("JWT_SECRET");

    public PaymentController(PaymentRepository paymentRepository, PaystackService paystackService) {
        this.paymentRepository = paymentRepository;
        this.paystackService = paystackService;
    }

    @PostMapping("/initiate")
    public ResponseEntity<String> initiatePayment(@RequestParam int amount, @RequestParam String email) {
        return ResponseEntity.ok(paystackService.initiatePayment(amount, email));
    }

    @GetMapping("/verify/{reference}")
    public ResponseEntity<String> verifyPayment(@PathVariable String reference) {
        String result = paystackService.verifyPayment(reference);

        // If Paystack says "success", issue JWT
        if (result.contains("\"status\":true")) {
            String token = Jwts.builder()
                    .setSubject("user") // you can replace with actual user email/ID
                    .setIssuedAt(new Date())
                    .setExpiration(new Date(System.currentTimeMillis() + 86400000)) // 1 day expiry
                    .signWith(SignatureAlgorithm.HS256, jwtSecret)
                    .compact();

            return ResponseEntity.ok("Payment verified. JWT: " + token);
        }

        return ResponseEntity.badRequest().body("Payment verification failed");
    }
}
