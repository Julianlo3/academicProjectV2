package co.edu.unicauca.studentservice.service;

import co.edu.unicauca.studentservice.entity.Student;
import co.edu.unicauca.studentservice.infra.config.RabbitMQConfig;
import co.edu.unicauca.studentservice.infra.dto.StudentRequest;
import co.edu.unicauca.studentservice.repository.ProjectRepository;
import co.edu.unicauca.studentservice.repository.StudentRepository;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService implements IStudentService{
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private ProjectRepository projectRepository;

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
            Student student = new Student();
            student.setId(studentRequest.getId());
            student.setCode(studentRequest.getCode());
            student.setName(studentRequest.getName());
            student.setPhone(studentRequest.getPhone());
            student.setEmail(studentRequest.getEmail());
            student.setPassword(studentRequest.getPassword());

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
    public Student updateStudent(Long id, StudentRequest studentRequest) throws Exception {
        try {
            // 1. Verificar que el id pasado coincida con el id del estudiante que se quiere actualizar
            if (!Objects.equals(id, studentRequest.getId())) {
                throw new IllegalAccessException("El id del estudiante que se quiere actualizar no coincide con el id pasado");
            }

            // 2. Verificar si el codigo fue pasado y si existe
            if (studentRequest.getCode() != null) {
                if (studentRepository.findByCode(studentRequest.getCode()).isEmpty()) {
                    throw new IllegalAccessException("El estudiante con CODIGO " + studentRequest.getCode() + " no existe");
                }
            }

            // 3. Crear y mapear el estudiante desde el DTO
            Student student = new Student();
            student.setId(studentRequest.getId());
            student.setCode(studentRequest.getCode());
            student.setName(studentRequest.getName());
            student.setPhone(studentRequest.getPhone());
            student.setEmail(studentRequest.getEmail());
            student.setPassword(studentRequest.getPassword());

            // 4. Guardar el estudiante
            Student studentSaved = studentRepository.save(student);

            // 5. Publicar en RabbitMQ
            rabbitTemplate.convertAndSend(RabbitMQConfig.STUDENT_QUEUE, studentSaved);

            return studentSaved;

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Optional<Student> findById(Long id) {
        return studentRepository.findById(id);
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
    public Student deleteStudent(Long id) throws Exception {
        try{
            // 1. Verificar si el codigo fue pasado y si existe
            if (id != null) {
                if (studentRepository.findById(id).isEmpty()) {
                    throw new IllegalAccessException("El estudiante con ID " + id + " no existe");
                }
            }

            // 2. Obtener el estudiante a eliminar
            Student student = studentRepository.findById(id).get();

            // 3. Eliminar el estudiante
            studentRepository.delete(student);

            return student;

        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }


}
