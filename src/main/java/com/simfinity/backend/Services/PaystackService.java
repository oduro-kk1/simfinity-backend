package com.simfinity.backend.Services;

import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class PaystackService {
    private final RestTemplate restTemplate = new RestTemplate();
    private final String secret = System.getenv("PAYSTACK_SECRET");
    // Or use @Value("${paystack.secret}") if stored in application.properties

    public String initiatePayment(int amount, String email) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + secret);
        headers.setContentType(MediaType.APPLICATION_JSON);

        Map<String, Object> body = Map.of(
                "amount", amount * 100, // Paystack expects kobo
                "email", email
        );

        HttpEntity<Map<String, Object>> request = new HttpEntity<>(body, headers);

        ResponseEntity<String> response = restTemplate.postForEntity(
                "https://api.paystack.co/transaction/initialize",
                request,
                String.class
        );

        return response.getBody();
    }

    public String verifyPayment(String reference) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + secret);

        HttpEntity<Void> request = new HttpEntity<>(headers);

        ResponseEntity<String> response = restTemplate.exchange(
                "https://api.paystack.co/transaction/verify/" + reference,
                HttpMethod.GET,
                request,
                String.class
        );

        return response.getBody();
    }
}
