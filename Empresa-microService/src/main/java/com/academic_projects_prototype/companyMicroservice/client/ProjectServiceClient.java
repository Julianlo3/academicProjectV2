package com.academic_projects_prototype.companyMicroservice.client;

import com.academic_projects_prototype.companyMicroservice.infra.dto.projectDTO.ProjectRequestDTO;
import com.academic_projects_prototype.companyMicroservice.infra.dto.projectDTO.ProjectResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "project-microservice", url = "http://localhost:8085/api/projects") // Configuración del endpoint del microservicio de proyecto

public interface ProjectServiceClient {
    @PostMapping
    ResponseEntity<ProjectResponseDTO> createProject(@RequestBody ProjectRequestDTO projectRequestDTO);

    @GetMapping("/{projectId}")
    ResponseEntity<ProjectResponseDTO> getProjectById(@PathVariable("projectId") Long projectId);

    @GetMapping
    ResponseEntity<List<ProjectResponseDTO>> getAllProjects();

    @GetMapping("/status/{status}")
    ResponseEntity<List<ProjectResponseDTO>> getProjectsByStatus(@PathVariable("status") String status);

    @PutMapping("/{projectId}")
    ResponseEntity<ProjectResponseDTO> updateProject(@PathVariable("projectId") Long projectId,
                                                     @RequestBody ProjectRequestDTO projectRequestDTO);

    @DeleteMapping("/{projectId}")
    ResponseEntity<Void> deleteProject(@PathVariable("projectId") Long projectId);

}
