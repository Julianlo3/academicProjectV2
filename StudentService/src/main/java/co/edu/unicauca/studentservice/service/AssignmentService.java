package co.edu.unicauca.studentservice.service;

import co.edu.unicauca.studentservice.entity.Assignment;
import co.edu.unicauca.studentservice.entity.Student;
import co.edu.unicauca.studentservice.infra.dto.AssignmentRequestDTO;
import co.edu.unicauca.studentservice.infra.mapper.AssignmentMapper;
import co.edu.unicauca.studentservice.repository.AssignmentRepository;
import co.edu.unicauca.studentservice.repository.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class AssignmentService implements IAssignmentService {

    private final AssignmentRepository assignmentRepository;
    private final StudentRepository studentRepository;
    private final AssignmentMapper assignmentMapper;

    public AssignmentService(AssignmentRepository assignmentRepository, StudentRepository studentRepository, AssignmentMapper assignmentMapper) {
        this.assignmentRepository = assignmentRepository;
        this.studentRepository = studentRepository;
        this.assignmentMapper = assignmentMapper;
    }

    @Override
    @Transactional
    public Assignment createAssignment(AssignmentRequestDTO assignmentRequestDTO) throws Exception {
        try {
            // 1. Verificar si el codigo de estudiante fue pasado y si el estudiante existe
            if (assignmentRequestDTO.getStudentCode() != null) {
                if (studentRepository.findByCode(assignmentRequestDTO.getStudentCode()).isEmpty()) {
                    throw new IllegalAccessException("El estudiante con CODIGO " + assignmentRequestDTO.getStudentCode() + " no existe");
                }
            }

            // 2. Crear y mapear la signacion desde el DTO
            Student student = studentRepository.findByCode(assignmentRequestDTO.getStudentCode()).get();
            Assignment assignment = assignmentMapper.toEntity(assignmentRequestDTO, student);

            // 3. Guardar y retornar la asignacion

            return assignmentRepository.save(assignment);

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
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
    @Transactional
    public List<Assignment> findAllAssignment() throws Exception {
        try {
            return assignmentRepository.findAll();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
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
