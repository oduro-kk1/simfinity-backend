package com.simfinity.backend.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "session_rentals")
public class SessionRental {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long studentId;
    private Long machineId;
    private Integer durationHours;
    private String paymentStatus = "pending"; // pending, success, failed
    private String containerLink;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getStudentId() { return studentId; }
    public void setStudentId(Long studentId) { this.studentId = studentId; }

    public Long getMachineId() { return machineId; }
    public void setMachineId(Long machineId) { this.machineId = machineId; }

    public Integer getDurationHours() { return durationHours; }
    public void setDurationHours(Integer durationHours) { this.durationHours = durationHours; }

    public String getPaymentStatus() { return paymentStatus; }
    public void setPaymentStatus(String paymentStatus) { this.paymentStatus = paymentStatus; }

    public String getContainerLink() { return containerLink; }
    public void setContainerLink(String containerLink) { this.containerLink = containerLink; }
}
