package co.edu.unicauca.studentservice.service;

import co.edu.unicauca.studentservice.entity.Student;
import co.edu.unicauca.studentservice.infra.dto.StudentDTO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface IStudentService {
    @Transactional
    public Student createStudent(StudentDTO studentDTO) throws Exception;

    @Transactional
    public Student updateStudent(Long code, StudentDTO studentDTO) throws Exception;

    @Transactional
    public Optional<Student> findByCode(Long code);

    @Transactional
    public List<Student> findAllStudents() throws Exception;

    @Transactional
    public Student deleteStudent(Long code) throws Exception;

    @Transactional
    List<Student> getStudentsWithoutAssignment() throws Exception;
}
