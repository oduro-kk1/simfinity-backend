package com.simfinity.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication(scanBasePackages = {"com.simfinity.backend"})
@EnableAsync
public class SimfinityBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimfinityBackendApplication.class, args);
	}
}
