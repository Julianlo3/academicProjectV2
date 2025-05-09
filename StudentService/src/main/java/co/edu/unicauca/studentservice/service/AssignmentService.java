package co.edu.unicauca.studentservice.service;

import co.edu.unicauca.studentservice.entity.Assignment;
import co.edu.unicauca.studentservice.infra.dto.AssignmentRequest;
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
    private ProjectServiceClient projectServiceClient;

    @Override
    public Assignment createAssignment(AssignmentRequest assignmentRequest) throws Exception {
        try {
            // 1. Verificar si el codigo de estudiante fue pasado y si el estudiante existe
            if (assignmentRequest.getStudent() != null) {
                if (studentRepository.findByCode(assignmentRequest.getStudent()).isEmpty()) {
                    throw new IllegalAccessException("El estudiante con CODIGO " + assignmentRequest.getStudent() + " no existe");
                }
            }

            // 2. Crear y mapear la signacion desde el DTO
            Assignment assignment = new Assignment();
            assignment.setStudent(studentRepository.findByCode(assignmentRequest.getStudent()).get());
            assignment.setProject(assignmentRequest.getProject());
            assignment.setProjectEntity(projectServiceClient.getProjectById(assignmentRequest.getProject()).getBody());

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

            Optional<List<Assignment>> assignmentList = assignmentRepository.findByStudentCode(studentCode);

            for (Assignment assignment : assignmentList.get()) {
                try{
                    assignment.setProjectEntity(projectServiceClient.getProjectById(assignment.getProject()).getBody());
                }catch (Exception e){
                    assignment.setProjectEntity(null);
                }
            }

            return assignmentList;

        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<Assignment> findAllAssignment() throws Exception {
        try {

            List<Assignment> assignmentList = assignmentRepository.findAll();

            for (Assignment assignment : assignmentList) {
                try{
                    assignment.setProjectEntity(projectServiceClient.getProjectById(assignment.getProject()).getBody());
                }catch (Exception e){
                    assignment.setProjectEntity(null);
                }
            }

            return assignmentList;
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
