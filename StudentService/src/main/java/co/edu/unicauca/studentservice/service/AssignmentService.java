package co.edu.unicauca.studentservice.service;

import co.edu.unicauca.studentservice.entity.Assignment;
import co.edu.unicauca.studentservice.entity.Student;
import co.edu.unicauca.studentservice.infra.dto.AssignmentRequest;
import co.edu.unicauca.studentservice.infra.mapper.AssignmentMapper;
import co.edu.unicauca.studentservice.repository.AssignmentRepository;
import co.edu.unicauca.studentservice.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AssignmentService implements IAssignmentService {
    @Autowired
    private AssignmentRepository assignmentRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private AssignmentMapper assignmentMapper;

    @Override
    public Assignment createAssignment(AssignmentRequest assignmentRequest) throws Exception {
        try {
            // 1. Verificar si el codigo de estudiante fue pasado y si el estudiante existe
            if (assignmentRequest.getStudentCode() != null) {
                if (studentRepository.findByCode(assignmentRequest.getStudentCode()).isEmpty()) {
                    throw new IllegalAccessException("El estudiante con CODIGO " + assignmentRequest.getStudentCode() + " no existe");
                }
            }

            // 2. Crear y mapear la signacion desde el DTO
            Student student = studentRepository.findByCode(assignmentRequest.getStudentCode()).get();
            Assignment assignment = assignmentMapper.toEntity(assignmentRequest, student);

            // 3. Guardar y retornar la asignacion

            return assignmentRepository.save(assignment);

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Optional<List<Assignment>> findAssignmentByStudentCode(Long studentCode) throws Exception {
        try{
            // 1. Verificar si el codigo de estudiante fue pasado y si el estudiante existe
            if (studentCode != null) {
                if (studentRepository.findByCode(studentCode).isEmpty()) {
                    throw new IllegalAccessException("El estudiante con CODIGO " + studentCode + " no existe");
                }
            }

            return assignmentRepository.findByStudentCode(studentCode);

        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<Assignment> findAllAssignment() throws Exception {
        try {
            return assignmentRepository.findAll();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Assignment deleteAssignment(Long id) throws Exception {
        try{
            // 1. Verificar si el id fue pasado y si existe
            if (id != null) {
                if (assignmentRepository.findById(id).isEmpty()) {
                    throw new IllegalAccessException("La asignacion con id " + id + " no existe");
                }
            }

            // 2. Obtener la asignacion a eliminar
            Assignment assignment = assignmentRepository.findById(id).get();

            // 3. Eliminar el estudiante
            assignmentRepository.delete(assignment);

            return assignment;

        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
