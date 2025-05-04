package co.edu.unicauca.studentservice.repository;

import co.edu.unicauca.studentservice.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Optional<Student> findByCode(Long code);
}
