package com.projectMicroservice.infrastructure.persistence.repositories;

import com.projectMicroservice.domain.model.Project;
import com.projectMicroservice.infrastructure.persistence.entity.ProjectStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface IProjectRepository extends JpaRepository<Project, Long> {
    List<Project> findByStatus(ProjectStatus status);
}
