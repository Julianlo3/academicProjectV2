package co.edu.unicauca.studentservice.repository;

import co.edu.unicauca.studentservice.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}
