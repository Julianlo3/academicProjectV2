package co.edu.unicauca.gestionusuariomicroservice.Service;


import co.edu.unicauca.gestionusuariomicroservice.entities.Student;
import co.edu.unicauca.gestionusuariomicroservice.repository.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author lopez
 * @date 14/04/2025
 */
@Service
public class StudentService {
    @Autowired
    private IStudentRepository studentRepository;

    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    public Optional<Student> getStudentById(String id) {
        return studentRepository.findById(id);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student updateStudent(Student student) {
        return studentRepository.save(student);
    }

    public void deleteStudent(String id) {
        studentRepository.deleteById(id);
    }
}
