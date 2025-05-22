package com.projectMicroservice.presentation.controller;

import com.projectMicroservice.application.port.in.ProjectServicePort;
import com.projectMicroservice.application.port.out.ProjectRepositoryPort;
import com.projectMicroservice.domain.model.Project;

import com.projectMicroservice.presentation.dto.ProjectDTO;
import com.projectMicroservice.presentation.dto.ProjectDtoMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/project")
public class ProjectController {

    private final ProjectServicePort projectService;
    private final ProjectRepositoryPort projectRepository;
    private final ProjectDtoMapper dtoMapper;

    public ProjectController(ProjectServicePort projectService, ProjectRepositoryPort projectRepository, ProjectDtoMapper dtoMapper) {
        this.projectService = projectService;
        this.projectRepository = projectRepository;
        this.dtoMapper = dtoMapper;
    }

    @PostMapping
    @PreAuthorize("hasRole('company')")
    public ResponseEntity<ProjectDTO> createProject(@RequestBody ProjectDTO dto) {
        Project created = projectService.createProject(dtoMapper.toDomain(dto));
        return ResponseEntity
                .created(URI.create("/projects/" + created.getProjectId()))
                .body(dtoMapper.toDto(created));
    }

    @GetMapping("/{id}")
    @PreAuthorize("permitAll()")
    public ResponseEntity<ProjectDTO> getProject(@PathVariable Long id) {
        try {
            Project project = projectRepository.findById(id).get();
            return ResponseEntity.ok(dtoMapper.toDto(project));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
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
    @PreAuthorize("hasRole('coordinator')")
    public ResponseEntity<Void> editDetails(@PathVariable Long id, @RequestBody ProjectDTO dto) throws Exception {
        projectService.editProjectDetails(id, dto.getTitle(), dto.getDescription(), dto.getDurationWeeks());
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}/requirements")
    @PreAuthorize("hasRole('company')")
    public ResponseEntity<Void> updateRequirements(@PathVariable Long id, @RequestBody ProjectDTO dto) throws Exception {
        projectService.updateRequirements(id, dto.getMinimumSemester(), dto.getRequiredSkills());
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}/technologies")
    @PreAuthorize("hasRole('company')")
    public ResponseEntity<Void> updateTechnologyStack(@PathVariable Long id, @RequestBody ProjectDTO dto) throws Exception {
        projectService.updateTechnologyStack(id, dto.getTechnologyStack());
        return ResponseEntity.ok().build();
    }

    @GetMapping
    @PreAuthorize("permitAll()")
    public ResponseEntity<List<ProjectDTO>> getAllProjects() {
        List<Project> projects = projectRepository.findAll();
        List<ProjectDTO> result = projects.stream()
                .map(dtoMapper::toDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(result);
    }
}