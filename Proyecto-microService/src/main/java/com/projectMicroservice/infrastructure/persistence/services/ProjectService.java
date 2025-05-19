package com.projectMicroservice.infrastructure.persistence.services;

import com.projectMicroservice.domain.model.Project;
import com.projectMicroservice.infrastructure.persistence.entity.ProjectStatus;
import com.projectMicroservice.infrastructure.persistence.repositories.IProjectRepository;
import com.projectMicroservice.presentation.dto.ProjectDto;
import org.springframework.stereotype.Service;
import com.projectMicroservice.presentation.dto.ProjectMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectService implements IProjectService {

    private final IProjectRepository projectRepository;

    public ProjectService(IProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public ProjectDto createProject(ProjectDto projectDto) {
        Project project = ProjectMapper.toEntity(projectDto);
        Project savedProject = projectRepository.save(project);
        return ProjectMapper.toDto(savedProject);
    }

    @Override
    public ProjectDto getProjectById(Long projectId) {
        Project project = projectRepository.findById(projectId).orElseThrow(()-> new RuntimeException("Proyecto no encontrado"));
        return ProjectMapper.toDto(project);
    }

    @Override
    public List<ProjectDto> getAllProjects() {
        List<Project> projects = projectRepository.findAll();
        return projects.stream().map(ProjectMapper::toDto).toList();
    }

    @Override
    public List<ProjectDto> getProjectsByStatus(String status) {

        List<Project> projects;

        switch (status) {
            case "PENDING":
                projects = projectRepository.findByStatus(ProjectStatus.PENDING);
                break;
            case "APPROVED":
                projects = projectRepository.findByStatus(ProjectStatus.APPROVED);
                break;
            case "REJECTED":
                projects = projectRepository.findByStatus(ProjectStatus.REJECTED);
                break;
            case "ASSIGNED":
                projects = projectRepository.findByStatus(ProjectStatus.ASSIGNED);
                break;
            case "COMPLETED":
                projects = projectRepository.findByStatus(ProjectStatus.COMPLETED);
                break;
            default:
                projects = new ArrayList<>();

        }

        return projects.stream().map(ProjectMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public ProjectDto updateProject(Long projectId, ProjectDto projectDto) {
        Project project = projectRepository.findById(projectId).orElseThrow(()-> new RuntimeException("Proyecto no encontrado"));
        project.setTitle(projectDto.getTitle());
        project.setDescription(projectDto.getDescription());
        project.setStatus(projectDto.getStatus());
        Project updatedProject = projectRepository.save(project);
        return ProjectMapper.toDto(updatedProject);
    }

    @Override
    public ProjectDto deleteProject(Long projectId) {
        if (!projectRepository.existsById(projectId)) {
            throw new RuntimeException("Project not found");
        }

        projectRepository.deleteById(projectId);
    }
}
