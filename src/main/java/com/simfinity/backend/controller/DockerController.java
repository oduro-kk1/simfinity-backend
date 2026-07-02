package com.simfinity.backend.controller;

import com.simfinity.backend.Services.ContainerService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/docker")
public class DockerController {

    private final ContainerService containerService;

    public DockerController(ContainerService containerService) {
        this.containerService = containerService;
    }

    @PostMapping("/provision")
    public String provision(@RequestParam Long studentId, @RequestParam Long machineId) {
        containerService.provisionContainer(studentId, machineId);
        return "Provisioning started for student " + studentId;
    }

    @GetMapping("/ping")
    public String ping() {
        return "Docker API is alive!";
    }
}
