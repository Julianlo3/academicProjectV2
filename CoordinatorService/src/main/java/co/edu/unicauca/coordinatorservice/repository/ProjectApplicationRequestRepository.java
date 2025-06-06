package co.edu.unicauca.coordinatorservice.repository;

import co.edu.unicauca.coordinatorservice.entities.ProjectApplicationRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProjectApplicationRequestRepository extends JpaRepository<ProjectApplicationRequest, Long> {
    Optional<ProjectApplicationRequest> findByStudentCodeAndProjectId(Long studentCode, Long projectId);
}
