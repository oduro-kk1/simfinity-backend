package com.simfinity.backend.Controller;

import com.simfinity.backend.Model.Payment;
import com.simfinity.backend.Repository.PaymentRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payments")
public class PaymentController {
    private final PaymentRepository paymentRepository;

    public PaymentController(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @GetMapping
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<?> createPayment(@RequestBody Payment payment) {
        return ResponseEntity.ok(paymentRepository.save(payment));
    }
}
