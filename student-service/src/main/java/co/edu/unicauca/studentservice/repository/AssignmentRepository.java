package co.edu.unicauca.studentservice.repository;

import co.edu.unicauca.studentservice.entity.Assignment;
import co.edu.unicauca.studentservice.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AssignmentRepository extends JpaRepository<Assignment, Long> {
    List<Assignment> findByStudentCode(Long studentCode);
    List<Assignment> findByProjectId(Long ProjectId);
    Optional<Assignment> findAssignmentByStudentCodeAndProjectId(Long studentCode, Long projectId);
    Optional<Assignment> deleteByStudentCodeAndProjectId(Long studentCode, Long projectId);
}
