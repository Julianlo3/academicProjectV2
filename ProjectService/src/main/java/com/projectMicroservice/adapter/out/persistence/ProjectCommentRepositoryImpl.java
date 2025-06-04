package com.projectMicroservice.adapter.out.persistence;

import com.projectMicroservice.application.port.out.ProjectCommentRepositoryPort;
import com.projectMicroservice.domain.model.ProjectComment;
import com.projectMicroservice.infrastructure.persistence.entity.ProjectCommentEntity;
import com.projectMicroservice.infrastructure.persistence.mapper.ProjectCommentMapper;
import com.projectMicroservice.infrastructure.persistence.repositories.IProjectCommentRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProjectCommentRepositoryImpl implements ProjectCommentRepositoryPort {

    private final IProjectCommentRepository repository;
    private final ProjectCommentMapper mapper;

    public ProjectCommentRepositoryImpl(IProjectCommentRepository repository, ProjectCommentMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public void saveComment(ProjectComment comment) {
        ProjectCommentEntity entity = mapper.toEntity(comment);
        repository.save(entity);
    }

    @Override
    public List<ProjectComment> findByProjectId(Long projectId) {
        return repository.findByProjectId(projectId)
                .stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }
}