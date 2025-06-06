package co.edu.unicauca.studentservice.infra.mapper;

import co.edu.unicauca.studentservice.entity.Assignment;
import co.edu.unicauca.studentservice.entity.Student;
import co.edu.unicauca.studentservice.infra.dto.AssignmentRequestDTO;
import co.edu.unicauca.studentservice.infra.dto.AssignmentResponseDTO;
import org.springframework.stereotype.Component;

@Component
public class AssignmentMapper {

    public AssignmentResponseDTO toDto(Assignment assignment) {
        return new AssignmentResponseDTO(
                assignment.getId(),
                assignment.getStudent().getCode(),
                assignment.getProjectId(),
                assignment.getDateAssignment()
        );
    }

    public Assignment toEntity(AssignmentRequestDTO dto, Student student) {
        return new Assignment(
                null,
                student,
                dto.getProjectId()
        );
    }
}
