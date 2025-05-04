package co.edu.unicauca.gestioncoordinadormicroservice.repository;

import co.edu.unicauca.gestioncoordinadormicroservice.entities.ProjectToApprove;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectToApproveRepository extends JpaRepository<ProjectToApprove, Long> {
    ProjectToApprove findByExternalId(Long externalId);
}
