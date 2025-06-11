package com.projectMicroservice.infrastructure.persistence.repositories;

import com.projectMicroservice.infrastructure.persistence.entity.ProjectCommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IProjectCommentRepository extends JpaRepository<ProjectCommentEntity, Long> {
    List<ProjectCommentEntity> findByProjectId(Long projectId);
}