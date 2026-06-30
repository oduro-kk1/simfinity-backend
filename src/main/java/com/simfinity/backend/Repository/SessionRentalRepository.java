package com.simfinity.backend.Repository;

import com.simfinity.backend.Model.SessionRental;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SessionRentalRepository extends JpaRepository<SessionRental, Long> {
    // Example custom query:
    // List<SessionRental> findByStudentId(Long studentId);
}
