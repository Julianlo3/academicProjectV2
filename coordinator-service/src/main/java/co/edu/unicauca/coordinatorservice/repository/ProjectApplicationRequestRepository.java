package co.edu.unicauca.coordinatorservice.repository;

import co.edu.unicauca.coordinatorservice.entities.ApplicationStatus;
import co.edu.unicauca.coordinatorservice.entities.ProjectApplicationRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProjectApplicationRequestRepository extends JpaRepository<ProjectApplicationRequest, Long> {
    Optional<ProjectApplicationRequest> findByStudentCodeAndProjectId(Long studentCode, Long projectId);
    List<ProjectApplicationRequest> findByProjectId(Long projectId);
    List<ProjectApplicationRequest> findByStudentCode(Long studentCode);
    List<ProjectApplicationRequest> findByStatus(ApplicationStatus status);
}
