package co.edu.unicauca.studentservice.service;

import co.edu.unicauca.studentservice.entity.Assignment;
import co.edu.unicauca.studentservice.infra.dto.AssignmentRequestDTO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface IAssignmentService {
    @Transactional
    Assignment createAssignment(AssignmentRequestDTO assignmentRequestDTO) throws Exception;

    @Transactional
    List<Assignment> findAssignmentByStudentCode(Long studentCode) throws Exception;

    @Transactional
    List<Assignment> findAllAssignment() throws Exception;

    @Transactional
    Assignment deleteAssignment(Long id) throws Exception;

    @Transactional
    List<Assignment> deleteAllAssignmentsByProjectId(Long ProjectId) throws Exception;
}
