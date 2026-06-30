package com.simfinity.backend.Repository;

import com.simfinity.backend.Model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {}
