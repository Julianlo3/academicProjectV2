package com.projectMicroservice.presentation.controller;

import com.projectMicroservice.infrastructure.persistence.services.IProjectService;
import com.projectMicroservice.presentation.dto.ProjectDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/project")
public class ProjectController {
    private final IProjectService projectService;

    public ProjectController(IProjectService projectService) {
        this.projectService = projectService;
    }

    /**
     * Endpoint para crear un proyecto
     */
    @PostMapping
    public ResponseEntity<ProjectDto> createProject(@RequestBody ProjectDto projectDto) {
        ProjectDto createdProject = projectService.createProject(projectDto);
        return new ResponseEntity<>(createdProject, HttpStatus.CREATED);
    }

    /**
     * Endpoint para obtener un proyecto por su id
     */
    @GetMapping("/{id}")
    public ResponseEntity<ProjectDto> getProjectById(@PathVariable("id") Long projectId) {
        ProjectDto project = projectService.getProjectById(projectId);
        return ResponseEntity.ok(project);
    }

    /**
     * Endpoint para obtener todos los proyectos
     */
    @GetMapping
    public ResponseEntity<List<ProjectDto>> getAllProjects() {
        List<ProjectDto> projects = projectService.getAllProjects();
        return ResponseEntity.ok(projects);
    }

    /**
     * Endpoint para obtener proyectos según su estado
     */
    @GetMapping("/status/{statusToSearch}")
    public ResponseEntity<List<ProjectDto>> getProjectsByStatus(@PathVariable("statusToSearch") String status) {
        List<ProjectDto> projects = projectService.getProjectsByStatus(status);
        return ResponseEntity.ok(projects);
    }

    /**
     * Endpoint para actualizar un proyecto por su id
     */
    @PutMapping("/{id}")
    public ResponseEntity<ProjectDto> updateProject(@PathVariable("id") Long projectId, @RequestBody ProjectDto projectDto) {
        ProjectDto updatedProject = projectService.updateProject(projectId, projectDto);
        return ResponseEntity.ok(updatedProject);
    }

    /**
     * Endpoint para eliminar un proyecto por su id
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProject(@PathVariable("id") Long projectId) {
        projectService.deleteProject(projectId);
        return ResponseEntity.noContent().build();
    }

}
