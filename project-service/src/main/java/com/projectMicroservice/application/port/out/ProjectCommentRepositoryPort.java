package com.projectMicroservice.application.port.out;

import com.projectMicroservice.domain.model.ProjectComment;

import java.util.List;

public interface ProjectCommentRepositoryPort {
    void saveComment(ProjectComment comment);
    List<ProjectComment> findByProjectId(Long projectId);
}
