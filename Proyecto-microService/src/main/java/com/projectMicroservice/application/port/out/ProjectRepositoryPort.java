package com.projectMicroservice.application.port.out;

import com.projectMicroservice.domain.model.Project;
import java.util.Optional;
import java.util.List;

public interface ProjectRepositoryPort {

    Project save(Project project);
    Optional<Project> findById(Long id);
    List<Project> findAll();
}