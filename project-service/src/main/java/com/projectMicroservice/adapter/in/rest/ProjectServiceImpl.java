package com.projectMicroservice.adapter.in.rest;

import com.projectMicroservice.application.port.in.ProjectServicePort;
import com.projectMicroservice.application.port.out.ProjectCommentRepositoryPort;
import com.projectMicroservice.application.port.out.ProjectRepositoryPort;
import com.projectMicroservice.domain.model.Project;
import com.projectMicroservice.domain.model.ProjectComment;
import com.projectMicroservice.domain.valueObject.ProjectDetails;
import com.projectMicroservice.domain.valueObject.ProjectTimeline;
import com.projectMicroservice.presentation.DTO.CreateProjectCommentDTO;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;

@Service
public class ProjectServiceImpl implements ProjectServicePort {

    private final ProjectRepositoryPort projectRepositoryPort;
    private final ProjectCommentRepositoryPort projectCommentRepositoryPort;

    public ProjectServiceImpl(ProjectRepositoryPort repository, ProjectCommentRepositoryPort projectCommentRepositoryPort) {
        this.projectRepositoryPort = repository;
        this.projectCommentRepositoryPort = projectCommentRepositoryPort;
    }

    @Override
    public Project createProject(Project project) {
        return projectRepositoryPort.save(project);
    }

    @Override
    public void approveProject(Long projectId, ProjectComment projectComment) throws Exception {
        Project project = getProjectOrThrow(projectId);
        project.approve(); // cambia estado internamente
        projectRepositoryPort.save(project); // guarda los cambios

        projectComment.changeStatus("Approved");
        projectCommentRepositoryPort.saveComment(projectComment);
    }

    @Override
    public void rejectProject(Long projectId, ProjectComment projectComment) throws Exception {
        Project project = getProjectOrThrow(projectId);
        project.reject();
        projectRepositoryPort.save(project);

        projectComment.changeStatus("Rejected");
        projectCommentRepositoryPort.saveComment(projectComment);
    }

    @Override
    public void assignProject(Long projectId) throws Exception {
        Project project = getProjectOrThrow(projectId);
        project.assign();
        projectRepositoryPort.save(project);
    }

    @Override
    public void completeProject(Long projectId) throws Exception {
        Project project = getProjectOrThrow(projectId);
        project.complete();
        projectRepositoryPort.save(project);
    }

    @Override
    public void editProjectDetails(Long projectId, String name, String summary, String objectives, String description) throws Exception {
        Project project = getProjectOrThrow(projectId);
        project.editDetails(new ProjectDetails(name, summary, objectives, description));
        projectRepositoryPort.save(project);
    }

    @Override
    public void editProjectTimeline(Long projectId, int maxDurationInMonths, LocalDate startDate) throws Exception {
        Project project = getProjectOrThrow(projectId);
        project.editTimeline(new ProjectTimeline(maxDurationInMonths, startDate));
        projectRepositoryPort.save(project);
    }

    @Override
    public void editProjectBudget(Long projectId, BigDecimal newBudget) throws Exception {
        Project project = getProjectOrThrow(projectId);
        project.editBudget(newBudget);
        projectRepositoryPort.save(project);
    }

    // Utilidad privada para validar existencia
    private Project getProjectOrThrow(Long id) throws Exception {
        return projectRepositoryPort.findById(id).orElseThrow(() -> new Exception("Project not found with ID: " + id));
    }
}
