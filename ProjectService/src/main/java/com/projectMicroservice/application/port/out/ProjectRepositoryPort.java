package com.projectMicroservice.application.port.out;

import com.projectMicroservice.domain.model.Project;

import java.util.Optional;
import java.util.List;

public interface ProjectRepositoryPort {

    Project save(Project project);
    Optional<Project> findById(Long id);
    List<Project> findAll();
    List<Project> findByNameContaining(String name);
    List<Project> findByCompanyNit(Long companyNit);
    Project findByName(String name);
    List<Project> findByCurrentState(String state);
    List<Project> findByCurrentStateAndAcademicPeriod(String state, int year, int term);
}