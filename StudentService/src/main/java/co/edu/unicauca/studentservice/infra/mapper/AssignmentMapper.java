package co.edu.unicauca.studentservice.infra.mapper;

import co.edu.unicauca.studentservice.entity.Assignment;
import co.edu.unicauca.studentservice.entity.Student;
import co.edu.unicauca.studentservice.infra.dto.AssignmentDTO;
import org.springframework.stereotype.Component;

@Component
public class AssignmentMapper {

    public AssignmentDTO toDto(Assignment assignment) {
        return new AssignmentDTO(
                assignment.getId(),
                assignment.getStudent().getCode(),
                assignment.getProjectId(),
                assignment.getDateAssignment()
        );
    }

    public Assignment toEntity(AssignmentDTO dto, Student student) {
        return new Assignment(
                dto.getId(),
                student,
                dto.getProjectId()
        );
    }
}
