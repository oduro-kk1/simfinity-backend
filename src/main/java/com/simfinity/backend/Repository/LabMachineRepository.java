package com.simfinity.backend.Repository;

import com.simfinity.backend.Model.LabMachine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LabMachineRepository extends JpaRepository<LabMachine, Long> {
    // Example custom query:
    // List<LabMachine> findByIsAvailable(Boolean isAvailable);
}
