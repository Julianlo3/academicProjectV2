package co.edu.unicauca.gestionusuariomicroservice.repository;

import co.edu.unicauca.gestionusuariomicroservice.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IStudentRepository extends JpaRepository<Student, String> {
}
