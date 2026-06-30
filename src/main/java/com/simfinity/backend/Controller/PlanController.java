package com.simfinity.backend.Controller;

import com.simfinity.backend.Model.Plan;
import com.simfinity.backend.Repository.PlanRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/plans")
public class PlanController {
    private final PlanRepository planRepository;

    public PlanController(PlanRepository planRepository) {
        this.planRepository = planRepository;
    }

    @GetMapping
    public List<Plan> getAllPlans() {
        return planRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<?> createPlan(@RequestBody Plan plan) {
        return ResponseEntity.ok(planRepository.save(plan));
    }
}
