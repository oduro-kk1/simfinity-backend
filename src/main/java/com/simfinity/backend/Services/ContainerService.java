package com.simfinity.backend.Services;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.command.CreateContainerResponse;
import com.github.dockerjava.api.model.HostConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class ContainerService {

    @Autowired
    private DockerClient dockerClient;

    @Async
    public void provisionContainer(Long studentId, Long machineId) {
        try {
            System.out.println("Provisioning for Student ID: " + studentId);

            HostConfig hostConfig = HostConfig.newHostConfig()
                    .withMemory(4294967296L) // 4GB RAM
                    .withCpuPeriod(100000L)  // 100ms scheduler window
                    .withCpuQuota(200000L);  // 2 cores max

            CreateContainerResponse container = dockerClient.createContainerCmd("codercom/code-server:latest")
                    .withHostConfig(hostConfig)
                    .exec();

            dockerClient.startContainerCmd(container.getId()).exec();

            System.out.println("Provisioned container ID: " + container.getId());
        } catch (Exception e) {
            System.err.println("Error provisioning container: " + e.getMessage());
        }
    }
}
