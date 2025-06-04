package com.projectMicroservice.adapter.in.rest;

import com.projectMicroservice.application.port.in.ProjectCommentServicePort;
import com.projectMicroservice.application.port.out.ProjectCommentRepositoryPort;
import com.projectMicroservice.domain.model.ProjectComment;
import com.projectMicroservice.presentation.DTO.CreateProjectCommentDTO;
import com.projectMicroservice.presentation.DTO.ProjectCommentDTO;
import com.projectMicroservice.presentation.mapper.ProjectCommentDTOMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectCommentServiceImpl implements ProjectCommentServicePort {

    private final ProjectCommentRepositoryPort persistencePort;
    private final ProjectCommentDTOMapper mapper;

    public ProjectCommentServiceImpl(ProjectCommentRepositoryPort persistencePort,
                                     ProjectCommentDTOMapper mapper) {
        this.persistencePort = persistencePort;
        this.mapper = mapper;
    }

    @Override
    public void createComment(Long projectId, CreateProjectCommentDTO dto) {
        ProjectComment comment = mapper.toDomain(projectId, dto);
        persistencePort.saveComment(comment);
    }

    @Override
    public List<ProjectCommentDTO> getCommentsByProject(Long projectId) {
        return persistencePort.findByProjectId(projectId)
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }
}
