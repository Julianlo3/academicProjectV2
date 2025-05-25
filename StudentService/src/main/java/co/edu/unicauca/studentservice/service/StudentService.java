package co.edu.unicauca.studentservice.service;

import co.edu.unicauca.studentservice.entity.Student;
import co.edu.unicauca.studentservice.infra.config.RabbitMQConfig;
import co.edu.unicauca.studentservice.infra.dto.StudentRequest;
import co.edu.unicauca.studentservice.infra.mapper.StudentMapper;
import co.edu.unicauca.studentservice.repository.StudentRepository;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService implements IStudentService{
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentMapper studentMapper;

    @Override
    @Transactional
    public Student createStudent(StudentRequest studentRequest) throws Exception {
        try {
            // 1. Verificar si el codigo fue pasado y si ya existe
            if (studentRequest.getCode() != null) {
                if (studentRepository.findByCode(studentRequest.getCode()).isPresent()) {
                    throw new IllegalAccessException("El estudiante con CODIGO " + studentRequest.getCode() + " ya existe");
                }
            }

            // 2. Crear y mapear el estudiante desde el DTO
            Student student = studentMapper.toEntity(studentRequest);

            // 3. Guardar el estudiante
            Student studentSaved = studentRepository.save(student);

            // 4. Publicar en RabbitMQ
            rabbitTemplate.convertAndSend(RabbitMQConfig.STUDENT_QUEUE, studentSaved);

            return studentSaved;

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Student updateStudent(Long code, StudentRequest studentRequest) throws Exception {
        try {
            // 1. Verificar si el codigo fue pasado y si existe
            if (code != null) {
                if (studentRepository.findByCode(code).isEmpty()) {
                    throw new IllegalAccessException("El estudiante con CODIGO " + code + " no existe");
                }
            }

            // 2. Crear y mapear el estudiante desde el DTO
            Student student = studentMapper.toEntity(studentRequest);

            // 3. Guardar el estudiante
            Student studentSaved = studentRepository.save(student);

            // 4. Publicar en RabbitMQ
            rabbitTemplate.convertAndSend(RabbitMQConfig.STUDENT_QUEUE, studentSaved);

            return studentSaved;

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Optional<Student> findByCode(Long code) {
        return studentRepository.findByCode(code);
    }

    @Override
    @Transactional
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


}
