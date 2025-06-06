package com.projectMicroservice.adapter.out.persistence;

import com.projectMicroservice.application.port.out.ProjectRepositoryPort;
import com.projectMicroservice.domain.model.Project;
import com.projectMicroservice.infrastructure.persistence.entity.AcademicPeriodEmbeddable;
import com.projectMicroservice.infrastructure.persistence.mapper.ProjectMapper;
import com.projectMicroservice.infrastructure.persistence.entity.ProjectEntity;

import com.projectMicroservice.infrastructure.persistence.repositories.IProjectRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class ProjectRepositoryImpl implements ProjectRepositoryPort {

    private final IProjectRepository projectRepository;
    private final ProjectMapper mapper;

    public ProjectRepositoryImpl(IProjectRepository projectRepository, ProjectMapper mapper) {
        this.projectRepository = projectRepository;
        this.mapper = mapper;
    }

    @Override
    public Project save(Project project) {
        ProjectEntity entity = mapper.toEntity(project);
        ProjectEntity saved = projectRepository.save(entity);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<Project> findById(Long id) {
        return projectRepository.findById(id).map(mapper::toDomain);
    }

    @Override
    public List<Project> findAll() {
        return projectRepository.findAll().stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<Project> findByNameContaining(String name) {
        List<ProjectEntity> entities = projectRepository.findByDetails_NameContainingIgnoreCase(name);
        return entities.stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<Project> findByCompanyNit(Long companyNit) {
        List<ProjectEntity> entities = projectRepository.findByCompanyNit(companyNit);
        return entities.stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Project findByName(String name){
        ProjectEntity entity = projectRepository.findByDetails_Name(name);
        return mapper.toDomain(entity);
    }

    @Override
    public List<Project> findByCurrentState(String state) {
        List<ProjectEntity> entities = projectRepository.findByCurrentState(state);
        return entities.stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<Project> findByCurrentStateAndAcademicPeriod(String state, int year, int term) {
        List<ProjectEntity> entities = projectRepository.findByCurrentStateAndAcademicPeriod_YearAndAcademicPeriod_Term(state, year, term);
        return entities.stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }
}
