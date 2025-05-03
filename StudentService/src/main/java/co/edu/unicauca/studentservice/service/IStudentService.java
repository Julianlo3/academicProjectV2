package co.edu.unicauca.studentservice.service;

import co.edu.unicauca.studentservice.entity.Student;
import co.edu.unicauca.studentservice.infra.dto.StudentRequest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface IStudentService {
    @Transactional
    public Student createStudent(StudentRequest studentRequest) throws Exception;

    @Transactional
    public Student updateStudent(Long code, StudentRequest studentRequest) throws Exception;

    @Transactional
    public Optional<Student> findById(Long id);

    @Transactional
    public List<Student> findAllStudents() throws Exception;

    @Transactional
    public Student deleteStudent(Long id) throws Exception;
}
