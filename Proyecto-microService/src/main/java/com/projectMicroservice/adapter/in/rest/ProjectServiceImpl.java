package com.projectMicroservice.adapter.in.rest;

import com.projectMicroservice.application.port.in.ProjectServicePort;
import com.projectMicroservice.application.port.out.ProjectRepositoryPort;
import com.projectMicroservice.domain.model.Project;
import com.projectMicroservice.domain.valueObject.ProjectDetails;
import com.projectMicroservice.domain.valueObject.ProjectRequirements;
import com.projectMicroservice.domain.valueObject.TechnologyStack;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public void editProjectDetails(Long projectId, String title, String description, int durationWeeks) throws Exception {
        Project project = getProjectOrThrow(projectId);
        ProjectDetails details = new ProjectDetails(title, description, durationWeeks);
        project.editDetails(details);
        repository.save(project);
    }

    @Override
    public void updateRequirements(Long projectId, int semester, String skills) throws Exception {
        Project project = getProjectOrThrow(projectId);
        ProjectRequirements requirements = new ProjectRequirements(semester, skills);
        project.updateRequirements(requirements);
        repository.save(project);
    }

    @Override
    public void updateTechnologyStack(Long projectId, List<String> stack) throws Exception {
        Project project = getProjectOrThrow(projectId);
        TechnologyStack techStack = new TechnologyStack(stack);
        project.updateTechnologyStack(techStack);
        repository.save(project);
    }

    // Utilidad privada para validar existencia
    private Project getProjectOrThrow(Long id) throws Exception {
        return repository.findById(id).orElseThrow(() -> new Exception("Project not found with ID: " + id));
    }
}
