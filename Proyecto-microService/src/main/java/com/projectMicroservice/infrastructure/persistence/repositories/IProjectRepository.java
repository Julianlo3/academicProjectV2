package com.projectMicroservice.infrastructure.persistence.repositories;

import com.projectMicroservice.infrastructure.persistence.entity.ProjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface IProjectRepository extends JpaRepository<ProjectEntity, Long> {
    // Buscar proyectos cuyo título contenga la cadena ignorando mayúsculas/minúsculas
    List<ProjectEntity> findByDetails_TitleContainingIgnoreCase(String title);
    List<ProjectEntity> findByCompanyNit(Long companyNit);
}
