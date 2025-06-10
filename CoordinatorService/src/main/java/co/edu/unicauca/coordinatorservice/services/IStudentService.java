package co.edu.unicauca.coordinatorservice.services;

import co.edu.unicauca.coordinatorservice.infra.dto.AssignmentRequestDTO;
import org.springframework.transaction.annotation.Transactional;

public interface IStudentService {
    @Transactional
    void assignStudent(AssignmentRequestDTO assignmentRequestDTO) throws Exception;
    @Transactional
    void unassignAllStudents(Long projectId) throws Exception;
}
