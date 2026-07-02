package com.simfinity.backend.controller;

import com.simfinity.backend.Model.Session;
import com.simfinity.backend.Repository.SessionRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sessions")
public class SessionController {
    private final SessionRepository sessionRepository;

    public SessionController(SessionRepository sessionRepository) {
        this.sessionRepository = sessionRepository;
    }

    @GetMapping
    public List<Session> getAllSessions() {
        return sessionRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<?> createSession(@RequestBody Session session) {
        return ResponseEntity.ok(sessionRepository.save(session));
    }
}
