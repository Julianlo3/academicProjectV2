package com.projectMicroservice.infrastructure.persistence.repositories;

import com.projectMicroservice.infrastructure.persistence.entity.ProjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface IProjectRepository extends JpaRepository<ProjectEntity, Long> {
    // Buscar proyectos cuyo nombre contenga la cadena ignorando mayúsculas/minúsculas
    List<ProjectEntity> findByDetails_NameContainingIgnoreCase(String name);
    List<ProjectEntity> findByCompanyNit(Long companyNit);
    ProjectEntity findByDetails_Name(String name);
}
