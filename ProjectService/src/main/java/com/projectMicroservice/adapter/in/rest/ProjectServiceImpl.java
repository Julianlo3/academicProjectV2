package com.projectMicroservice.adapter.in.rest;

import com.projectMicroservice.application.port.in.ProjectServicePort;
import com.projectMicroservice.application.port.out.ProjectRepositoryPort;
import com.projectMicroservice.domain.model.Project;
import com.projectMicroservice.domain.valueObject.ProjectDetails;
import com.projectMicroservice.domain.valueObject.ProjectTimeline;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;

@Service
public class ProjectServiceImpl implements ProjectServicePort {

    private final ProjectRepositoryPort repository;

    public ProjectServiceImpl(ProjectRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public Project createProject(Project project) {
        return repository.save(project);
    }

    @Override
    public void approveProject(Long projectId) throws Exception {
        Project project = getProjectOrThrow(projectId);
        project.approve(); // cambia estado internamente
        repository.save(project); // guarda los cambios
    }

    @Override
    public void rejectProject(Long projectId) throws Exception {
        Project project = getProjectOrThrow(projectId);
        project.reject();
        repository.save(project);
    }

    @Override
    public void assignProject(Long projectId) throws Exception {
        Project project = getProjectOrThrow(projectId);
        project.assign();
        repository.save(project);
    }

    @Override
    public void completeProject(Long projectId) throws Exception {
        Project project = getProjectOrThrow(projectId);
        project.complete();
        repository.save(project);
    }

    @Override
    public void editProjectDetails(Long projectId, String name, String summary, String objectives, String description) throws Exception {
        Project project = getProjectOrThrow(projectId);
        project.editDetails(new ProjectDetails(name, summary, objectives, description));
        repository.save(project);
    }

    @Override
    public void editProjectTimeline(Long projectId, int maxDurationInMonths, LocalDate startDate) throws Exception {
        Project project = getProjectOrThrow(projectId);
        project.editTimeline(new ProjectTimeline(maxDurationInMonths, startDate));
        repository.save(project);
    }

    @Override
    public void editProjectBudget(Long projectId, BigDecimal newBudget) throws Exception {
        Project project = getProjectOrThrow(projectId);
        project.editBudget(newBudget);
    }

    // Utilidad privada para validar existencia
    private Project getProjectOrThrow(Long id) throws Exception {
        return repository.findById(id).orElseThrow(() -> new Exception("Project not found with ID: " + id));
    }
}
