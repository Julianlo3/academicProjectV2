package co.edu.unicauca.studentservice.service;

import co.edu.unicauca.studentservice.entity.Student;
import co.edu.unicauca.studentservice.infra.dto.StudentDTO;
import co.edu.unicauca.studentservice.infra.mapper.StudentMapper;
import co.edu.unicauca.studentservice.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentService implements IStudentService{

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    public StudentService(StudentRepository studentRepository, StudentMapper studentMapper) {
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
    }

    @Override
    public Student createStudent(StudentDTO studentDTO) throws Exception {
        try {
            // 1. Verificar si el codigo fue pasado y si ya existe
            if (studentDTO.getCode() != null) {
                if (studentRepository.findByCode(studentDTO.getCode()).isPresent()) {
                    throw new IllegalAccessException("El estudiante con CODIGO " + studentDTO.getCode() + " ya existe");
                }
            }

            // 2. Crear y mapear el estudiante desde el DTO
            Student student = studentMapper.toEntity(studentDTO);

            // 3. Guardar el estudiante

            return studentRepository.save(student);

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Student updateStudent(Long code, StudentDTO studentDTO) throws Exception {
        try {
            // 1. Verificar si el codigo fue pasado y si existe
            if (code != null) {
                if (studentRepository.findByCode(code).isEmpty()) {
                    throw new IllegalAccessException("El estudiante con CODIGO " + code + " no existe");
                }
            }

            // 2. Crear y mapear el estudiante desde el DTO
            Student student = studentRepository.findByCode(code).get();
            student.setCode(studentDTO.getCode());
            student.setName(studentDTO.getName());
            student.setPhone(studentDTO.getPhone());
            student.setEmail(studentDTO.getEmail());

            // 3. Guardar el estudiante

            return studentRepository.save(student);

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Optional<Student> findByCode(Long code) {
        return studentRepository.findByCode(code);
    }

    @Override
    public List<Student> findAllStudents() throws Exception{
        try {
            return studentRepository.findAll();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Student deleteStudent(Long code) throws Exception {
        try{
            // 1. Verificar si el codigo fue pasado y si existe
            if (code != null) {
                if (studentRepository.findByCode(code).isEmpty()) {
                    throw new IllegalAccessException("El estudiante con codigo " + code + " no existe");
                }
            }

            // 2. Obtener el estudiante a eliminar
            Student student = studentRepository.findByCode(code).get();

            // 3. Eliminar el estudiante
            studentRepository.delete(student);

            return student;

        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<Student> getStudentsWithoutAssignment() throws Exception {
        try {
            return studentRepository.findStudentsWithoutAssignment();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

}
