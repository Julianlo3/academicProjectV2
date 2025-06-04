package com.projectMicroservice.infrastructure.persistence.mapper;

import com.projectMicroservice.domain.model.ProjectComment;
import com.projectMicroservice.infrastructure.persistence.entity.ProjectCommentEntity;
import org.springframework.stereotype.Component;

@Component
public class ProjectCommentMapper {

    public ProjectCommentEntity toEntity(ProjectComment comment) {
        ProjectCommentEntity entity = new ProjectCommentEntity();
        entity.setProjectId(comment.getProjectId());
        entity.setCoordinatorCode(comment.getCoordinatorCode());
        entity.setComment(comment.getComment());
        entity.setNewState(comment.getNewStatus());
        // timestamp lo maneja @CreationTimestamp
        return entity;
    }

    public ProjectComment toDomain(ProjectCommentEntity entity) {
        return new ProjectComment(
                entity.getId(),
                entity.getProjectId(),
                entity.getCoordinatorCode(),
                entity.getComment(),
                entity.getNewState(),
                entity.getTimestamp()
        );
    }
}
