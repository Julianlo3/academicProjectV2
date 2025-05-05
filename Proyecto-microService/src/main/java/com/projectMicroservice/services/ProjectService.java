package com.projectMicroservice.services;

import com.projectMicroservice.entities.Project;
import com.projectMicroservice.entities.ProjectStatus;
import com.projectMicroservice.infra.ProjectRequestDTO;
import com.projectMicroservice.infra.ProjectResponseDTO;
import com.projectMicroservice.repositories.IProjectRepository;
import org.springframework.stereotype.Service;
import com.projectMicroservice.infra.ProjectMapper;

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
    public ProjectResponseDTO createProject(ProjectRequestDTO projectRequestDTO) {
        Project project = ProjectMapper.toEntity(projectRequestDTO);
        Project savedProject = projectRepository.save(project);
        return ProjectMapper.toResponseDTO(savedProject);
    }

    @Override
    public ProjectResponseDTO getProjectById(Long projectId) {
        Project project = projectRepository.findById(projectId).orElseThrow(()-> new RuntimeException("Proyecto no encontrado"));
        return ProjectMapper.toResponseDTO(project);
    }

    @Override
    public List<ProjectResponseDTO> getAllProjects() {
        List<Project> projects = projectRepository.findAll();
        return projects.stream().map(ProjectMapper::toResponseDTO).toList();
    }

    @Override
    public List<ProjectResponseDTO> getProjectsByStatus(String status) {

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

        return projects.stream().map(ProjectMapper::toResponseDTO).collect(Collectors.toList());
    }

    @Override
    public ProjectResponseDTO updateProject(Long projectId, ProjectRequestDTO projectRequestDTO) {
        Project project = projectRepository.findById(projectId).orElseThrow(()-> new RuntimeException("Proyecto no encontrado"));
        project.setTitle(projectRequestDTO.getTitle());
        project.setDescription(projectRequestDTO.getDescription());
        project.setStatus(projectRequestDTO.getStatus());
        Project updatedProject = projectRepository.save(project);
        return ProjectMapper.toResponseDTO(updatedProject);
    }

    @Override
    public void deleteProject(Long projectId) {
        if (!projectRepository.existsById(projectId)) {
            throw new RuntimeException("Project not found");
        }
        projectRepository.deleteById(projectId);
    }
}
