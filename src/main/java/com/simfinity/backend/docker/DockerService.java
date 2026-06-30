package com.simfinity.backend.docker;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.model.Container;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DockerService {

    private final DockerClient dockerClient;

    public DockerService(DockerClient dockerClient) {
        this.dockerClient = dockerClient;
    }

    public List<Container> listContainers() {
        return dockerClient.listContainersCmd().exec();
    }

    public void printContainers() {
        listContainers().forEach(container ->
                System.out.println("Container ID: " + container.getId())
        );
    }
}
