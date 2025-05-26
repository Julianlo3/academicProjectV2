package com.projectMicroservice.presentation.controller;

import com.projectMicroservice.application.port.in.ProjectServicePort;
import com.projectMicroservice.application.port.out.ProjectRepositoryPort;
import com.projectMicroservice.domain.model.Project;

import com.projectMicroservice.presentation.dto.ProjectDTO;
import com.projectMicroservice.presentation.dto.ProjectDtoMapper;
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
    private ProjectDtoMapper dtoMapper;

    @PostMapping
    @PreAuthorize("hasRole('company')")
    public ResponseEntity<ProjectDTO> createProject(@RequestBody ProjectDTO dto) {
        Project created = projectService.createProject(dtoMapper.toDomain(dto));
        return ResponseEntity
                .created(URI.create("/projects/" + created.getProjectId()))
                .body(dtoMapper.toDto(created));
    }

    @PostMapping("/{id}/approve")
    @PreAuthorize("hasRole('coordinator')")
    public ResponseEntity<Void> approveProject(@PathVariable Long id) throws Exception {
        projectService.approveProject(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{id}/reject")
    @PreAuthorize("hasRole('coordinator')")
    public ResponseEntity<Void> rejectProject(@PathVariable Long id) throws Exception {
        projectService.rejectProject(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{id}/assign")
    @PreAuthorize("hasRole('coordinator')")
    public ResponseEntity<Void> assignProject(@PathVariable Long id) throws Exception {
        projectService.assignProject(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{id}/complete")
    @PreAuthorize("hasRole('coordinator')")
    public ResponseEntity<Void> completeProject(@PathVariable Long id) throws Exception {
        projectService.completeProject(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}/details")
    @PreAuthorize("hasAnyRole('company', 'coordinator')")
    public ResponseEntity<Void> editDetails(@PathVariable Long id, @RequestBody ProjectDTO dto) throws Exception {
        projectService.editProjectDetails(id, dto.getTitle(), dto.getDescription(), dto.getDurationWeeks());
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}/requirements")
    @PreAuthorize("hasAnyRole('company', 'coordinator')")
    public ResponseEntity<Void> updateRequirements(@PathVariable Long id, @RequestBody ProjectDTO dto) throws Exception {
        projectService.updateRequirements(id, dto.getMinimumSemester(), dto.getRequiredSkills());
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}/technologies")
    @PreAuthorize("hasAnyRole('company', 'coordinator')")
    public ResponseEntity<Void> updateTechnologyStack(@PathVariable Long id, @RequestBody ProjectDTO dto) throws Exception {
        projectService.updateTechnologyStack(id, dto.getTechnologyStack());
        return ResponseEntity.ok().build();
    }

    @GetMapping
    @PreAuthorize("hasRole('guest')")
    public ResponseEntity<List<ProjectDTO>> getAllProjects() {
        List<Project> projects = projectRepository.findAll();
        List<ProjectDTO> result = projects.stream()
                .map(dtoMapper::toDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('coordinator')")
    public ResponseEntity<ProjectDTO> getProject(@PathVariable Long id) {
        try {
            Project project = projectRepository.findById(id).get();
            return ResponseEntity.ok(dtoMapper.toDto(project));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/company/{companyNit}")
    @PreAuthorize("hasRole('guest')")
    public ResponseEntity<List<ProjectDTO>> getProjectsByCompany(@PathVariable Long companyNit) {
        List<Project> projects = projectRepository.findByCompanyNit(companyNit);
        List<ProjectDTO> projectDTOs = projects.stream()
                .map(dtoMapper::toDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(projectDTOs);
    }

    //Ejemplo endpoint: GET http://localhost:8081/api/project/search?title=gestión
    @GetMapping("/search")
    @PreAuthorize("hasRole('guest')")
    public ResponseEntity<List<ProjectDTO>> searchByTitle(@RequestParam String title) {
        List<Project> projects = projectRepository.findByTitleContaining(title);
        List<ProjectDTO> dtos = projects.stream()
                .map(dtoMapper::toDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(dtos);
    }
}