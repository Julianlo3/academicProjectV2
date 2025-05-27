package com.projectMicroservice.presentation.controller;

import com.projectMicroservice.application.port.in.ProjectServicePort;
import com.projectMicroservice.application.port.out.ProjectRepositoryPort;
import com.projectMicroservice.domain.model.Project;

import com.projectMicroservice.presentation.dto.ProjectDTO;
import com.projectMicroservice.presentation.dto.ProjectDTOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/project")
public class ProjectController {
    @Autowired
    private ProjectServicePort projectService;
    @Autowired
    private ProjectRepositoryPort projectRepository;
    @Autowired
    private ProjectDTOMapper dtoMapper;

    @PostMapping
    @PreAuthorize("hasAnyRole('company', 'coordinator')")
    public ResponseEntity<ProjectDTO> createProject(@RequestBody ProjectDTO dto) {
        Project created = projectService.createProject(dtoMapper.toDomain(dto));
        return ResponseEntity
                .created(URI.create("/projects/" + created.getProjectId()))
                .body(dtoMapper.toDto(created));
    }

    @PutMapping("/{id}/approve")
    @PreAuthorize("hasRole('coordinator')")
    public ResponseEntity<Void> approveProject(@PathVariable Long id) throws Exception {
        projectService.approveProject(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}/reject")
    @PreAuthorize("hasRole('coordinator')")
    public ResponseEntity<Void> rejectProject(@PathVariable Long id) throws Exception {
        projectService.rejectProject(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}/assign")
    @PreAuthorize("hasRole('coordinator')")
    public ResponseEntity<Void> assignProject(@PathVariable Long id) throws Exception {
        projectService.assignProject(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}/complete")
    @PreAuthorize("hasRole('coordinator')")
    public ResponseEntity<Void> completeProject(@PathVariable Long id) throws Exception {
        projectService.completeProject(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}/details")
    @PreAuthorize("hasAnyRole('company', 'coordinator')")
    public ResponseEntity<Void> editDetails(@PathVariable Long id, @RequestBody ProjectDTO dto) throws Exception {
        projectService.editProjectDetails(id, dto.getName(), dto.getSummary(), dto.getObjectives(), dto.getDescription());
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}/timeline")
    @PreAuthorize("hasAnyRole('company', 'coordinator')")
    public ResponseEntity<Void> editTimeline(@PathVariable Long id, @RequestBody ProjectDTO dto) throws Exception {
        projectService.editProjectTimeline(id, dto.getMaxDurationInMonths(), dto.getStartDate());
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}/budget")
    @PreAuthorize("hasAnyRole('company', 'coordinator')")
    public ResponseEntity<Void> editBudget(@PathVariable Long id, @RequestBody ProjectDTO dto) throws Exception {
        projectService.editProjectBudget(id, dto.getBudget());
        return ResponseEntity.ok().build();
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('company', 'coordinator')")
    public ResponseEntity<List<ProjectDTO>> getAllProjects() {
        List<Project> projects = projectRepository.findAll();
        List<ProjectDTO> result = projects.stream()
                .map(dtoMapper::toDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('company', 'coordinator')")
    public ResponseEntity<ProjectDTO> getProjectById(@PathVariable Long id) {
        try {
            Project project = projectRepository.findById(id).get();
            return ResponseEntity.ok(dtoMapper.toDto(project));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/company/{companyNit}")
    @PreAuthorize("hasAnyRole('company', 'coordinator')")
    public ResponseEntity<List<ProjectDTO>> getProjectsByCompany(@PathVariable Long companyNit) {
        List<Project> projects = projectRepository.findByCompanyNit(companyNit);
        List<ProjectDTO> projectDTOs = projects.stream()
                .map(dtoMapper::toDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(projectDTOs);
    }

    //Ejemplo endpoint: GET http://localhost:8081/api/project/search?title=gestión
    @GetMapping("/search")
    @PreAuthorize("hasAnyRole('company', 'coordinator')")
    public ResponseEntity<List<ProjectDTO>> searchByName(@RequestParam String name) {
        List<Project> projects = projectRepository.findByNameContaining(name);
        List<ProjectDTO> dtos = projects.stream()
                .map(dtoMapper::toDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(dtos);
    }
}