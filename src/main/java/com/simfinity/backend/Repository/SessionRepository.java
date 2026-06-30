package com.simfinity.backend.Repository;

import com.simfinity.backend.Model.Session;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionRepository extends JpaRepository<Session, Long> {}
