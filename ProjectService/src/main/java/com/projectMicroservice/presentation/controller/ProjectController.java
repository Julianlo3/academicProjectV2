package com.projectMicroservice.presentation.controller;

import com.projectMicroservice.application.port.in.ProjectCommentServicePort;
import com.projectMicroservice.application.port.in.ProjectServicePort;
import com.projectMicroservice.application.port.out.ProjectCommentRepositoryPort;
import com.projectMicroservice.application.port.out.ProjectRepositoryPort;
import com.projectMicroservice.domain.model.Project;

import com.projectMicroservice.domain.model.ProjectComment;
import com.projectMicroservice.presentation.DTO.CreateProjectCommentDTO;
import com.projectMicroservice.presentation.DTO.ProjectCommentDTO;
import com.projectMicroservice.presentation.DTO.ProjectDTO;
import com.projectMicroservice.presentation.mapper.ProjectCommentDTOMapper;
import com.projectMicroservice.presentation.mapper.ProjectDTOMapper;
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

    private final ProjectServicePort projectService;
    private final ProjectCommentServicePort projectCommentService;
    private final ProjectRepositoryPort projectRepository;
    private final ProjectCommentRepositoryPort projectCommentRepository;
    private final ProjectDTOMapper projectDTOMapper;
    private final ProjectCommentDTOMapper projectCommentDTOMapper;

    public ProjectController(ProjectServicePort projectService, ProjectCommentServicePort projectCommentService, ProjectRepositoryPort projectRepository, ProjectCommentRepositoryPort projectCommentRepository, ProjectDTOMapper projectDTOMapper, ProjectCommentDTOMapper projectCommentDTOMapper) {
        this.projectService = projectService;
        this.projectCommentService = projectCommentService;
        this.projectRepository = projectRepository;
        this.projectCommentRepository = projectCommentRepository;
        this.projectDTOMapper = projectDTOMapper;
        this.projectCommentDTOMapper = projectCommentDTOMapper;
    }


    @PostMapping
    @PreAuthorize("hasRole('company')")
    public ResponseEntity<ProjectDTO> createProject(@RequestBody ProjectDTO dto) {
        Project created = projectService.createProject(projectDTOMapper.toDomain(dto));
        return ResponseEntity
                .created(URI.create("/projects/" + created.getProjectId()))
                .body(projectDTOMapper.toDto(created));
    }

    @PutMapping("/{id}/approve")
    @PreAuthorize("hasRole('coordinator')")
    public ResponseEntity<Void> approveProject(@PathVariable Long id, @RequestBody CreateProjectCommentDTO dto) throws Exception {
        projectService.approveProject(id, projectCommentDTOMapper.toDomain(id, dto));
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}/reject")
    @PreAuthorize("hasRole('coordinator')")
    public ResponseEntity<Void> rejectProject(@PathVariable Long id, @RequestBody CreateProjectCommentDTO dto) throws Exception {
        projectService.rejectProject(id, projectCommentDTOMapper.toDomain(id, dto));
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}/assign")
    @PreAuthorize("hasRole('coordinator')")
    public ResponseEntity<Void> assignProject(@PathVariable Long id, @RequestBody CreateProjectCommentDTO dto) throws Exception {
        projectService.assignProject(id, projectCommentDTOMapper.toDomain(id, dto));
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}/complete")
    @PreAuthorize("hasRole('coordinator')")
    public ResponseEntity<Void> completeProject(@PathVariable Long id, @RequestBody CreateProjectCommentDTO dto) throws Exception {
        projectService.completeProject(id, projectCommentDTOMapper.toDomain(id, dto));
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}/details")
    @PreAuthorize("hasAnyRole('company')")
    public ResponseEntity<Void> editDetails(@PathVariable Long id, @RequestBody ProjectDTO dto) throws Exception {
        projectService.editProjectDetails(id, dto.getName(), dto.getSummary(), dto.getObjectives(), dto.getDescription());
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}/timeline")
    @PreAuthorize("hasAnyRole('company')")
    public ResponseEntity<Void> editTimeline(@PathVariable Long id, @RequestBody ProjectDTO dto) throws Exception {
        projectService.editProjectTimeline(id, dto.getMaxDurationInMonths(), dto.getStartDate());
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}/budget")
    @PreAuthorize("hasAnyRole('company')")
    public ResponseEntity<Void> editBudget(@PathVariable Long id, @RequestBody ProjectDTO dto) throws Exception {
        projectService.editProjectBudget(id, dto.getBudget());
        return ResponseEntity.ok().build();
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('student', 'coordinator', 'guest')")
    public ResponseEntity<List<ProjectDTO>> getAllProjects() {
        List<Project> projects = projectRepository.findAll();
        List<ProjectDTO> result = projects.stream()
                .map(projectDTOMapper::toDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('company', 'coordinator')")
    public ResponseEntity<ProjectDTO> getProjectById(@PathVariable Long id) {
        try {
            Project project = projectRepository.findById(id).get();
            return ResponseEntity.ok(projectDTOMapper.toDto(project));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/company/{companyNit}")
    @PreAuthorize("hasAnyRole('company', 'coordinator')")
    public ResponseEntity<List<ProjectDTO>> getProjectsByCompany(@PathVariable Long companyNit) {
        List<Project> projects = projectRepository.findByCompanyNit(companyNit);
        List<ProjectDTO> projectDTOs = projects.stream()
                .map(projectDTOMapper::toDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(projectDTOs);
    }

    //Ejemplo endpoint: GET http://localhost:8081/api/project/search?name=gestión
    @GetMapping("/search")
    @PreAuthorize("hasAnyRole('company', 'coordinator', 'guest')")
    public ResponseEntity<List<ProjectDTO>> searchByName(@RequestParam String name) {
        List<Project> projects = projectRepository.findByNameContaining(name);
        List<ProjectDTO> dtos = projects.stream()
                .map(projectDTOMapper::toDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/name/{name}")
    @PreAuthorize("hasAnyRole('company', 'coordinator', 'guest')")
    public ResponseEntity<ProjectDTO> getProjectByName(@PathVariable String name) {
        Project project = projectRepository.findByName(name);
        if(project == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(projectDTOMapper.toDto(project));
    }

    @GetMapping("comments/{id}")
    @PreAuthorize("hasAnyRole('company', 'coordinator')")
    public ResponseEntity<List<ProjectCommentDTO>> getProjectComments(@PathVariable Long id) {
        List<ProjectComment> projectsComments = projectCommentRepository.findByProjectId(id);
        List<ProjectCommentDTO> result = projectsComments.stream()
                .map(projectCommentDTOMapper::toDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(result);
    }


}
