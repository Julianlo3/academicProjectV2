package co.edu.unicauca.studentservice.repository;

import co.edu.unicauca.studentservice.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Optional<Student> findByCode(Long code);

    @Query("SELECT s FROM Student s WHERE s.id NOT IN (SELECT a.student.id FROM Assignment a)")
    List<Student> findStudentsWithoutAssignment();
}
