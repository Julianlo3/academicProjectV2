package com.projectMicroservice.presentation.mapper;

import com.projectMicroservice.domain.model.ProjectComment;
import com.projectMicroservice.presentation.DTO.CreateProjectCommentDTO;
import com.projectMicroservice.presentation.DTO.ProjectCommentDTO;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ProjectCommentDTOMapper {
    // Dominio → DTO (salida)
    public ProjectCommentDTO toDto(ProjectComment comment) {
        ProjectCommentDTO dto = new ProjectCommentDTO();
        dto.setId(comment.getId());
        dto.setProjectId(comment.getProjectId());
        dto.setCoordinatorCode(comment.getCoordinatorCode());
        dto.setComment(comment.getComment());
        dto.setNewState(comment.getNewStatus());
        dto.setTimestamp(comment.getTimestamp()); // tipo Date
        return dto;
    }

    // DTO → Dominio (entrada)
    public ProjectComment toDomain(Long projectId, CreateProjectCommentDTO dto) {
        return new ProjectComment(
                null,                         // id autogenerado
                projectId,
                dto.getCoordinatorCode(),
                dto.getComment(),
                null,
                LocalDateTime.now()              // timestamp generado al crear
        );
    }
}
